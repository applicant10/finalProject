package kr.spring.lecture.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.lecture.domain.Lc_replyCommand;
import kr.spring.lecture.service.Lc_replyService;
import kr.spring.util.PagingUtil;

@Controller
public class Lc_replyAjaxController {
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 10;

	@Resource
	private Lc_replyService lc_replyService;

	@RequestMapping("/lecture/listLcReply.do")
	@ResponseBody
	public Map<String, Object> getLcrList(
			@RequestParam(value="pageNum", defaultValue="1") int currentPage,
			@RequestParam("lc_num") int lc_num){
		if(log.isDebugEnabled()) {
			log.debug(">> currentPage >> " + currentPage);
			log.debug(">> lc_num >> " + lc_num);
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lc_num", lc_num);

		//총 lc_reply 갯수
		int count = lc_replyService.getRowCountReply(map);

		PagingUtil page = new PagingUtil(currentPage, count, rowCount, 1, null);
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());

		List<Lc_replyCommand> list = null;
		if(count>0) {
			list = lc_replyService.list(map);
		}else {
			list = Collections.emptyList();
		}

		Map<String, Object> mapJson = new HashMap<String, Object>();
		mapJson.put("count", count);
		mapJson.put("rowCount", rowCount);
		mapJson.put("list", list);

		return mapJson;
	}
	//댓글 등록
	@RequestMapping("/lecture/writeLcReply.do")
	@ResponseBody
	public Map<String,String> writeReply(Lc_replyCommand lc_replyCommand, HttpSession session,HttpServletRequest request){
		
		Map<String,String> map = new HashMap<String, String>();

		String userId = (String)session.getAttribute("userId");

		if(userId==null) {
			//로그인 안됨
			map.put("result", "logout");
		}else {
			//로그인 됨

			//ip 저장
			lc_replyCommand.setLcr_ip(request.getRemoteAddr());
			
			if(log.isDebugEnabled()) {
				log.debug(">> lc_replyCommand >> : " + lc_replyCommand.toString());
			}
			
			//댓글 등록
			lc_replyService.insertReply(lc_replyCommand);

			map.put("result","success");
		}

		return map;
	}
	//댓글 수정
	@RequestMapping("/lecture/updateLcReply.do")
	@ResponseBody
	public Map<String, String> modifyReply(Lc_replyCommand lc_replyCommand, HttpSession session, HttpServletRequest request){

		if(log.isDebugEnabled()) {
			log.debug("<<boardReplyCommand>> : " + lc_replyCommand);
		}

		Map<String, String> map = new HashMap<String, String>();		

		String userId = (String)session.getAttribute("userId");

		if(userId == null) {
			//로그인 안되어 있는 경우
			map.put("result", "logout");
		}else if(userId != null && userId.equals(lc_replyCommand.getM_id())) {
			//로그인 아이디와 작성자 아이디 일치

			//ip 저장
			lc_replyCommand.setLcr_ip(request.getRemoteAddr());

			//댓글 수정
			lc_replyService.updateReply(lc_replyCommand);
			map.put("result", "success");
		}else {
			//로그인 아이디와 작성자 아이디 불일치
			map.put("result", "wrongAccess");
		}

		return map;
	}

	//댓글 삭제
	@RequestMapping("/lecture/deleteLcReply.do")
	@ResponseBody
	public Map<String, String> deleteReply(@RequestParam("lcr_num") int lcr_num, @RequestParam("id") String id, HttpSession session){
		if(log.isDebugEnabled()) {
			log.debug("<<re_num>> : " + lcr_num);
			log.debug("<<id>> : " + id);
		}

		Map<String, String> map = new HashMap<String, String>();

		String userId = (String)session.getAttribute("userId");
		if(userId == null) {
			//로그인이 되어있지 않음
			map.put("result", "logout");
		}else if(userId != null && userId.equals(id)){
			//로그인 되어 있고, 로그인 한 아이디와 작성자 아이디 일치
			lc_replyService.deleteReply(lcr_num);
			map.put("result", "success");
		}else {
			map.put("result", "wrongAccess");
		}

		return map;
	}
}