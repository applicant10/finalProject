package kr.spring.lecture.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.lecture.service.L_contentService;
import kr.spring.lecture.service.Lc_memService;
import kr.spring.lecture.service.Le_numService;

@Controller
public class CompleteLearnStudentController {
	@Resource
	private Lc_memService lc_memService;
	@Resource
	private L_contentService l_contentService;
	@Resource
	private Le_numService le_numService;

	@RequestMapping("/lecture/completeLearnStudent.do")
	public String completeLearnStudent(
			//강의컨텐츠 기본키
			@RequestParam("lc_num") int lc_num,
			//강의테이블 기본키
			@RequestParam("l_num") int l_num,
			HttpSession session, Model model) {
		
		String m_id = (String)session.getAttribute("userId");
		int l_m_num = le_numService.selectLM(m_id, l_num).getL_m_num();

		//수강 완료 처리
		lc_memService.completeLearnContent(lc_num, l_m_num, l_num);
		
		model.addAttribute("message", "강의 수강 완료!");
		model.addAttribute("url", "/lecture/learnStudent.do?l_num="+l_num+"&l_m_num="+l_m_num+"&lc_num="+lc_num);

		return "/common/alert";
	}
}