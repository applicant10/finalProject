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

		//�� lc_reply ����
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
	
	
	//��� ���
	@RequestMapping("/lecture/writeLReply.do")
	@ResponseBody
	public Map<String,String> writeReply(LectureReplyCommand myReplyCommand, HttpSession session,HttpServletRequest request){
		
		Map<String,String> mapJson = new HashMap<String, String>();

		String userId = (String)session.getAttribute("userId");

		if(userId==null) {
			//�α��� �ȵ�
			mapJson.put("result", "logout");
		}else {
			//�α��� ��

			//ip ����
			myReplyCommand.setLr_ip(request.getRemoteAddr());
			
			if(log.isDebugEnabled()) {
				log.debug(">> lectureReplyCommand >> : " + myReplyCommand.toString());
			}
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("l_num", myReplyCommand.getL_num());
			map.put("m_id", myReplyCommand.getM_id());
			
			//��� ���
			lrService.insertReply(myReplyCommand, map);

			mapJson.put("result","success");
		}

		return mapJson;
	}
	
	//��� ����
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
			//�α��� �ȵǾ� �ִ� ���
			map.put("result", "logout");
			
		}else if(userId.equals(myReplyCommand.getM_id())) {//�α��� ���̵�� �ۼ��� ���̵� ��ġ
			System.out.println("in!!");
			//ip ����
			myReplyCommand.setLr_ip(request.getRemoteAddr());

			//��� ����
			lrService.updateReply(myReplyCommand);
			map.put("result", "success");
			
		}else {
			System.out.println("Wooo!!");
			//�α��� ���̵�� �ۼ��� ���̵� ����ġ
			map.put("result", "wrongAccess");
		}

		return map;
	}
}