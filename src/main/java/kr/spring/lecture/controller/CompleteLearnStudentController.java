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
			//���������� �⺻Ű
			@RequestParam("lc_num") int lc_num,
			//�������̺� �⺻Ű
			@RequestParam("l_num") int l_num,
			HttpSession session, Model model) {
		
		String m_id = (String)session.getAttribute("userId");
		int l_m_num = le_numService.selectLM(m_id, l_num).getL_m_num();

		//���� �Ϸ� ó��
		lc_memService.completeLearnContent(lc_num, l_m_num, l_num);
		
		model.addAttribute("message", "���� ���� �Ϸ�!");
		model.addAttribute("url", "/lecture/learnStudent.do?l_num="+l_num+"&l_m_num="+l_m_num+"&lc_num="+lc_num);

		return "/common/alert";
	}
}