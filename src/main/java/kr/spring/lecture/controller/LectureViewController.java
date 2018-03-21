package kr.spring.lecture.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.lecture.domain.L_contentCommand;
import kr.spring.lecture.domain.LectureCommand;
import kr.spring.lecture.domain.LecturePointCommand;
import kr.spring.lecture.domain.LectureReplyCommand;
import kr.spring.lecture.service.L_contentService;
import kr.spring.lecture.service.Le_numService;
import kr.spring.lecture.service.LectureReplyService;
import kr.spring.lecture.service.LectureService;
import kr.spring.member.service.MemberService;
import kr.spring.subject.service.SubjectService;

@Controller
public class LectureViewController {
	@Resource
	private MemberService memberService;

	@Resource
	private LectureService lectureService;
	
	@Resource
	private L_contentService l_contentService;
	
	@Resource
	private SubjectService subjectService;
	
	@Resource
	private Le_numService le_numService;
	
	@Resource
	private LectureReplyService lrService;
	
	@ModelAttribute("myReply")
	private LectureReplyCommand initCommand() {
		return new LectureReplyCommand();
	}
	
	@RequestMapping("/lecture/lectureView.do")
	public String lectureVeiw(@RequestParam("l_num") int l_num, HttpSession session, Model model) {
		String m_id = (String)session.getAttribute("userId");
		LectureCommand lecture = lectureService.selectLecture(l_num);
		boolean checkStudy = le_numService.checkLectureUseId(m_id, l_num);
		List<L_contentCommand> lcList = l_contentService.selectLcUseLnum(l_num);
		int lcCount = l_contentService.countLcUseLnum(l_num);
		String writer = memberService.lectureWriter(l_num);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("l_num", l_num);
		map.put("m_id", m_id);
		
		lrService.averagePoint(l_num);
		
		LectureReplyCommand myReply = lrService.myReply(map);
		
		if(myReply != null) {
			model.addAttribute("myReply", myReply);
			model.addAttribute("result","updateLReply.do");
			model.addAttribute("formId", "mre_form");
		} else {
			model.addAttribute("result","writeLReply.do");
			model.addAttribute("formId", "reply_form");
		}
		
		model.addAttribute("subject", subjectService.selectOneUseSnum(lecture.getS_num()));
		model.addAttribute("check", checkStudy);
		model.addAttribute("lecture", lecture);
		model.addAttribute("lcList", lcList);
		model.addAttribute("lcCount", lcCount);
		model.addAttribute("writer", writer);
		
		LecturePointCommand lpcommand = lrService.lecturePoint(l_num);
		lpcommand.calcMaxPoint();
		
		model.addAttribute("point", lpcommand);
		
		
		return "lectureView";
	}
}