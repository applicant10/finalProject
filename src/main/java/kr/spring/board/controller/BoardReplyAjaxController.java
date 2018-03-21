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
	
	//��� ���
	@RequestMapping("/board/listReply.do")
	@ResponseBody
	public Map<String,Object> getList(@RequestParam(value="pageNum",defaultValue="1") int currentPage,@RequestParam("b_num") int b_num){
		
		if(log.isDebugEnabled()) {
			log.debug("<<currentPage>> : " + currentPage);
			log.debug("<<b_num>> : " + b_num);
		}
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("b_num", b_num);
		
		//�� ���� ����
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
	
	//��� ���
	@RequestMapping("/board/writeReply.do")
	@ResponseBody
	public Map<String,String> writeReply(BoardReplyCommand boardReplyCommand,HttpSession session,HttpServletRequest request){
		
		if(log.isDebugEnabled()) {
			log.debug("<<boardReplyCommand>> : " + boardReplyCommand);
		}
		
		Map<String,String> map = new HashMap<String,String>();
		
		String userId = (String)session.getAttribute("userId");
		if(userId==null) {
			//�α��� �ȵ�
			map.put("result", "logout");
		}else {
			//�α��� ��
			
			//ip����
			boardReplyCommand.setBr_ip(request.getRemoteAddr());
			
			//��� ���
			boardService.insertReply(boardReplyCommand);
			
			map.put("result", "success");
		}
		return map;
	}
	
	//��� ����
	@RequestMapping("/board/updateReply.do")
	@ResponseBody
	public Map<String,String> modifyReply(BoardReplyCommand boardReplyCommand,HttpSession session,HttpServletRequest request){
		if(log.isDebugEnabled()) {
			log.debug("<<boardReplyCommand>> : " + boardReplyCommand);
		}
		 Map<String, String> map = new HashMap<String, String>();
		
		String userId = (String)session.getAttribute("userId");
		
		if(userId==null) {
			//�α����� �� �Ǿ� �ִ� ���
			map.put("result", "logout");
		}else if(userId!=null && userId.equals(boardReplyCommand.getM_id())) {
			//�α��� ���̵�� �ۼ��� ���̵� ��ġ
			
			//ip ����
			boardReplyCommand.setBr_ip(request.getRemoteAddr());
			
			//��� ����
			boardService.updateReply(boardReplyCommand);
			map.put("result", "success");
		}else {
			//�α��� ���̵�� �ۼ��� ���̵� ����ġ
			map.put("result", "wrongAccess");
		}
				
		return map;
	}
	
	//��� ����
	@RequestMapping("/board/deleteReply.do")
	@ResponseBody
	public Map<String,String> deleteReply(@RequestParam("br_num") int br_num,@RequestParam("m_id") String m_id,HttpSession session){
		 
		if(log.isDebugEnabled()) {
			log.debug("<<id>> : " + m_id);
		}
		  Map<String, String> map = new HashMap<String, String>();
	      
	      String userId = (String) session.getAttribute("userId");
	      
	      if(userId == null) {
	         //�α����� �Ǿ����� ����
	         map.put("result", "logout");
	      }else if(userId!= null && userId.equals(m_id)){
	         //�α����� �Ǿ� �ְ� �α����� ���̵�� �ۼ��� ���̵� ��ġ�� ��
	         boardService.deleteReply(br_num);
	         map.put("result", "success");
	      }else {
	         map.put("result", "wrongAccess");
	      }
		
		return map;
	}
	
}











