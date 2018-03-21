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

import kr.spring.lecture.domain.LectureReplyCommand;
import kr.spring.lecture.service.LectureReplyService;
import kr.spring.util.PagingUtil;

@Controller
public class LectureReplyAjaxController {
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 10;

	@Resource
	private LectureReplyService lrService;
	
	@RequestMapping("/lecture/listLReply.do")
	@ResponseBody
	public Map<String, Object> getLrList(
			@RequestParam(value="pageNum", defaultValue="1") int currentPage,
			@RequestParam("l_num") int l_num){
		
		if(log.isDebugEnabled()) {
			log.debug(">> currentPage >> " + currentPage);
			log.debug(">> l_num >> " + l_num);
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("l_num", l_num);

		//총 lc_reply 갯수
		int count = lrService.getRowCountReply(map);

		PagingUtil page = new PagingUtil(currentPage, count, rowCount, 1, null);
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());

		List<LectureReplyCommand> list = null;
		if(count>0) {
			list = lrService.list(map);
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
	@RequestMapping("/lecture/writeLReply.do")
	@ResponseBody
	public Map<String,String> writeReply(LectureReplyCommand myReplyCommand, HttpSession session,HttpServletRequest request){
		
		Map<String,String> mapJson = new HashMap<String, String>();

		String userId = (String)session.getAttribute("userId");

		if(userId==null) {
			//로그인 안됨
			mapJson.put("result", "logout");
		}else {
			//로그인 됨

			//ip 저장
			myReplyCommand.setLr_ip(request.getRemoteAddr());
			
			if(log.isDebugEnabled()) {
				log.debug(">> lectureReplyCommand >> : " + myReplyCommand.toString());
			}
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("l_num", myReplyCommand.getL_num());
			map.put("m_id", myReplyCommand.getM_id());
			
			//댓글 등록
			lrService.insertReply(myReplyCommand, map);

			mapJson.put("result","success");
		}

		return mapJson;
	}
	
	//댓글 수정
	@RequestMapping("/lecture/updateLReply.do")
	@ResponseBody
	public Map<String, String> modifyReply(LectureReplyCommand myReplyCommand, HttpSession session, HttpServletRequest request){

		if(log.isDebugEnabled()) {
			log.debug("<<lectureReplyCommand>> : " + myReplyCommand.toString());
		}

		Map<String, String> map = new HashMap<String, String>();		

		String userId = (String)session.getAttribute("userId");
		
		if(log.isDebugEnabled()) {
			log.debug(">> lectureReplyCommand. id >> : " + myReplyCommand.getM_id());
			log.debug(">> userId >> : " + userId);
			log.debug(">> userId eq m_id >> : " + userId.equals(myReplyCommand.getM_id()));
			log.debug(">> userId ne null >> : " + userId != null);
			log.debug(">> totals >> : " + userId != null && userId.equals(myReplyCommand.getM_id()));
		}

		if(userId == null) {
			//로그인 안되어 있는 경우
			map.put("result", "logout");
			
		}else if(userId.equals(myReplyCommand.getM_id())) {//로그인 아이디와 작성자 아이디 일치
			System.out.println("in!!");
			//ip 저장
			myReplyCommand.setLr_ip(request.getRemoteAddr());

			//댓글 수정
			lrService.updateReply(myReplyCommand);
			map.put("result", "success");
			
		}else {
			System.out.println("Wooo!!");
			//로그인 아이디와 작성자 아이디 불일치
			map.put("result", "wrongAccess");
		}

		return map;
	}
}