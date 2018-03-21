package kr.spring.study.controller;

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

import kr.spring.study.domain.StudyReplyCommand;
import kr.spring.study.service.StudyService;
import kr.spring.util.PagingUtil;

@Controller
public class StudyReplyAjaxController {
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 10;
	
	@Resource
	private StudyService studyService;
	
	@RequestMapping("/study/studyReply.do")
	@ResponseBody
	public Map<String,Object> getList(
			@RequestParam(value="pageNum",defaultValue="1")int currentPage,
			@RequestParam("t_num")int num){
		
		if(log.isDebugEnabled()) {
			log.debug("<<currentPage>> : " + currentPage);
			log.debug("<<num>> : " + num);
		}
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("t_num", num);
		
		int count = studyService.getRowCountReply(map);
		
		PagingUtil page = new PagingUtil(currentPage,count,rowCount,1,null);
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<StudyReplyCommand> list = null;
		if(count > 0) {
			list = studyService.studyReply(map);
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
	@RequestMapping("/study/insertReply.do")
	@ResponseBody
	public Map<String,String> insertReply(StudyReplyCommand studyReplyCommand,HttpSession session,HttpServletRequest request){
		
		if(log.isDebugEnabled()) {
			log.debug("<<studyReplyCommand>> : " + studyReplyCommand);
		}
		
		Map<String,String> map = new HashMap<String,String>();
		
		String m_nick = (String)session.getAttribute("userNick");
		if(m_nick==null) {
			//�α��� �� ��
			map.put("result", "logout");
		}else {
			//�α��� ��
			studyService.insertReply(studyReplyCommand);
			
			map.put("result","success");
		}
		return map;
	}
	
	//��� ����
	@RequestMapping("/study/updateReply.do")
	@ResponseBody
	public Map<String,String> updateReply(
			StudyReplyCommand studyReplyCommand,
			HttpSession session,
			HttpServletRequest request){
		
		if(log.isDebugEnabled()) {
			log.debug("<<studyReplyCommand>> : " + studyReplyCommand);
		}
		
		Map<String,String> map = new HashMap<String,String>();
		
		String userNick = (String)session.getAttribute("userNick");
		
		if(userNick==null) {
			//�α��� �� ��
			map.put("result", "logout");
		}else if(userNick!=null && userNick.equals(studyReplyCommand.getM_nick())) {
			//�α��� �Ǿ��ְ� �ۼ��� �г��Ӱ� ��ġ
			map.put("result", "success");
		}else {
			//�α��� �Ǿ��ְ� �ۼ��ڰ� �ƴ� ���
			map.put("result", "wrongAccess");
		}
		
		return map;
	}
	
	//��� ����
	@RequestMapping("/study/deleteReply.do")
	@ResponseBody
	public Map<String,String> deleteReply(
			@RequestParam("re_num") int re_tnum,
			@RequestParam("m_nick")String nick,
			HttpSession session){
			
			if(log.isDebugEnabled()) {
				log.debug("<<nick>> : " + nick);
			}
			
			Map<String,String> map = new HashMap<String,String>();
			
			String userNick = (String)session.getAttribute("userNick");
			if(userNick==null) {
				//�α����� �Ǿ����� ����
				map.put("result","logout");
			}else if(userNick!=null && userNick.equals(nick)) {
				//�α��� �Ǿ��ְ� �г����� �ۼ��ڿ� ��ġ
				studyService.deleteReply(re_tnum);
				map.put("result", "success");
			}else {
				map.put("result", "wrongAccess");
			}
				
			return map;
	}
	
}
