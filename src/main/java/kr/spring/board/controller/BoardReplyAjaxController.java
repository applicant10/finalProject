package kr.spring.board.controller;

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

import kr.spring.board.domain.BoardReplyCommand;
import kr.spring.board.service.BoardService;
import kr.spring.util.PagingUtil;

@Controller
public class BoardReplyAjaxController {
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 10;
	
	@Resource
	private BoardService boardService;
	
	//댓글 목록
	@RequestMapping("/board/listReply.do")
	@ResponseBody
	public Map<String,Object> getList(@RequestParam(value="pageNum",defaultValue="1") int currentPage,@RequestParam("b_num") int b_num){
		
		if(log.isDebugEnabled()) {
			log.debug("<<currentPage>> : " + currentPage);
			log.debug("<<b_num>> : " + b_num);
		}
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("b_num", b_num);
		
		//총 글의 갯수
		int count = boardService.getRowCountReply(map);
		
		PagingUtil page = new PagingUtil(currentPage,count,rowCount,1,null);
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<BoardReplyCommand> list = null;
		if(count > 0) {
			list = boardService.listReply(map);
		}else {
			list = Collections.emptyList();
		}
		
		Map<String,Object> mapJson = new HashMap<String,Object>();
		mapJson.put("count", count);
		mapJson.put("rowCount", rowCount);
		mapJson.put("list", list);
		
		return mapJson;
	}
	
	//댓글 등록
	@RequestMapping("/board/writeReply.do")
	@ResponseBody
	public Map<String,String> writeReply(BoardReplyCommand boardReplyCommand,HttpSession session,HttpServletRequest request){
		
		if(log.isDebugEnabled()) {
			log.debug("<<boardReplyCommand>> : " + boardReplyCommand);
		}
		
		Map<String,String> map = new HashMap<String,String>();
		
		String userId = (String)session.getAttribute("userId");
		if(userId==null) {
			//로그인 안된
			map.put("result", "logout");
		}else {
			//로그인 됨
			
			//ip저장
			boardReplyCommand.setBr_ip(request.getRemoteAddr());
			
			//댓글 등록
			boardService.insertReply(boardReplyCommand);
			
			map.put("result", "success");
		}
		return map;
	}
	
	//댓글 수정
	@RequestMapping("/board/updateReply.do")
	@ResponseBody
	public Map<String,String> modifyReply(BoardReplyCommand boardReplyCommand,HttpSession session,HttpServletRequest request){
		if(log.isDebugEnabled()) {
			log.debug("<<boardReplyCommand>> : " + boardReplyCommand);
		}
		 Map<String, String> map = new HashMap<String, String>();
		
		String userId = (String)session.getAttribute("userId");
		
		if(userId==null) {
			//로그인이 안 되어 있는 경우
			map.put("result", "logout");
		}else if(userId!=null && userId.equals(boardReplyCommand.getM_id())) {
			//로그인 아이디와 작성자 아이디 일치
			
			//ip 저장
			boardReplyCommand.setBr_ip(request.getRemoteAddr());
			
			//댓글 수정
			boardService.updateReply(boardReplyCommand);
			map.put("result", "success");
		}else {
			//로그인 아이디와 작성자 아이디 불일치
			map.put("result", "wrongAccess");
		}
				
		return map;
	}
	
	//댓글 삭제
	@RequestMapping("/board/deleteReply.do")
	@ResponseBody
	public Map<String,String> deleteReply(@RequestParam("br_num") int br_num,@RequestParam("m_id") String m_id,HttpSession session){
		 
		if(log.isDebugEnabled()) {
			log.debug("<<id>> : " + m_id);
		}
		  Map<String, String> map = new HashMap<String, String>();
	      
	      String userId = (String) session.getAttribute("userId");
	      
	      if(userId == null) {
	         //로그인이 되어있지 않음
	         map.put("result", "logout");
	      }else if(userId!= null && userId.equals(m_id)){
	         //로그인이 되어 있고 로그인한 아이디와 작성자 아이디가 일치할 때
	         boardService.deleteReply(br_num);
	         map.put("result", "success");
	      }else {
	         map.put("result", "wrongAccess");
	      }
		
		return map;
	}
	
}











