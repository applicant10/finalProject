package kr.spring.qnaboard.controller;

import java.util.Collection;
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

import kr.spring.qnaboard.domain.QnABoardReplyCommand;
import kr.spring.qnaboard.service.QnABoardService;
import kr.spring.util.PagingUtil;

@Controller
public class QnAReplyAjaxController {
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 10;
	
	@Resource
	private QnABoardService qnABoardService;
	
	//��� ��� 
	@RequestMapping("/qna/qnalistReply.do")
	@ResponseBody
	public Map<String, Object> getQnAList(
			@RequestParam(value="pageNum", defaultValue="1")
			int currentPage,
			@RequestParam("num") int num){
		
		if(log.isDebugEnabled()) {
			log.debug("<<currentPage>>:"+currentPage);
			log.debug("<<num>>:"+num);
		}
		
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("num", num);
		
		//�� ���� ����
		int count = qnABoardService.getQnAReplyRowCount(map);
		
		PagingUtil page = new PagingUtil(currentPage, count, rowCount, 1, null);
		
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<QnABoardReplyCommand> list = null;
		if(count>0) {
			list = qnABoardService.getQnAReplyList(map);
		}else {
			list = Collections.emptyList();
		}
		
		Map<String, Object> mapJson = new HashMap<String, Object>();
		mapJson.put("count", count);
		mapJson.put("rowCount", rowCount);
		mapJson.put("list", list);
		
		return mapJson;
	}
	
	//��� ��� 
	@RequestMapping("/qna/qnAWriteReply.do")
	@ResponseBody
	public Map<String, String> writeReply(
				QnABoardReplyCommand qnABoardReplyCommand,
				HttpSession session,
				HttpServletRequest request){
		
		if(log.isDebugEnabled()) {
			log.debug("<<qnABoardReplyCommand>>:"+qnABoardReplyCommand);
		}
		
		Map<String, String> map = new HashMap<String, String>();
		
		String m_id = (String)session.getAttribute("m_id");
		if(m_id==null) {
			//�α��� �ȵ� 
			map.put("result", "logout");
		}else {
			//�α��� �� ���
			//ip���� 
			qnABoardReplyCommand.setBr_ip(request.getRemoteAddr());
			//��� ��� 
			qnABoardService.insertReply(qnABoardReplyCommand);
			
			map.put("result", "success");
		}
		return map;
	}
	
	//��� ���� 
	@RequestMapping("/qna/qnAUpdateReply.do")
	@ResponseBody
	public Map<String, String> updateReply(
			QnABoardReplyCommand qnABoardReplyCommand,
			HttpSession session,
			HttpServletRequest request){
		
		if(log.isDebugEnabled()) {
			log.debug("<<qnaBoardReplyCommand>> :" + qnABoardReplyCommand);
		}
		
		Map<String, String> map = new HashMap<String, String>();
		
		String m_id = (String)session.getAttribute("m_id");
		
		if(m_id==null) {
			//�α����� �ȵǴ� ��� 
			map.put("result", "logout");
		}else if(m_id!=null && m_id.equals(qnABoardReplyCommand.getM_id())) {
			//�α��� ���̵�� �ۼ��� ���̵� ��ġ 
			//ip����
			qnABoardReplyCommand.setBr_ip(request.getRemoteAddr());
			
			//��ۼ��� 
			qnABoardService.updateReply(qnABoardReplyCommand);
			map.put("result", "success");
		}else {
			//�α��� ���̵�� �ۼ��� ���̵� ����ġ 
			map.put("result", "wrongAccess");
		}
		return map;
	}
	
	//��ۻ��� 
	@RequestMapping("/qna/qnADeleteReply.do")
	@ResponseBody
	public Map<String, String> deleteReply(
			@RequestParam("br_num") int br_num,
			@RequestParam("m_id") String m_id,
			HttpSession session){
		
		if(log.isDebugEnabled()) {
			log.debug("<<br_num>>:" + br_num);
			log.debug("<<m_id>>:"+ m_id);
		}
		
		Map<String, String> map = new HashMap<String, String>();
		
		String user_id = (String)session.getAttribute("m_id");
		
		if(user_id==null) {
			//�α��� �Ǿ����� ���� 
			map.put("result", "logout");
		}else if(user_id!=null && user_id.equals(m_id)) {
			//�α��� �Ǿ��ְ� �α����� ���̵�� �ۼ��� ���̵� ��ġ 
			qnABoardService.deleteReply(br_num);
			map.put("result", "success");
		}else {
			map.put("result", "wrongAccess");
		}
		
		return map;
	}
}
