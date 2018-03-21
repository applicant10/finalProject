package kr.spring.lecture.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.spring.lecture.domain.LectureCommand;
import kr.spring.lecture.service.Le_numService;
import kr.spring.lecture.service.LectureService;

@Controller
public class MyLearnStateController {
	
	@Resource
	private Le_numService le_numService;
	
	@Resource
	private LectureService lectureService;
	
	@RequestMapping("/lecture/myLearnState.do")
	public String myLearnState(HttpSession session, Model model) {
		String m_id = (String)session.getAttribute("userId");
		String m_nick = (String)session.getAttribute("userNick");
		
		//유저가 수강신청했던 모든 강좌
		List<LectureCommand> totalEnrollList = lectureService.lecture_JoinLeNum_UseLMNum_Calc(m_id);
		
		model.addAttribute("m_id", m_id);
		model.addAttribute("m_nick", m_nick);
		model.addAttribute("totalEnrollList", totalEnrollList);
		
		return "myLearnState";
	}
}