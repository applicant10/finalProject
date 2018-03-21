package kr.spring.lecture.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.lecture.domain.L_contentCommand;
import kr.spring.lecture.service.L_contentService;
import kr.spring.lecture.service.Lc_memService;
import kr.spring.lecture.service.Le_numService;

@Controller
public class AddLearnStudentController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private Lc_memService lc_memService;
	
	@Resource
	private Le_numService le_numService;
	
	@Resource
	private L_contentService l_contentService;

	@RequestMapping("/lecture/addLearnStudent.do")
	public String addLearnStudent(
			//���������� �⺻Ű
			@RequestParam("lc_num") int lc_num,
			//�������̺� �⺻Ű
			@RequestParam("l_num") int l_num,
			HttpSession session, Model model) {
		
		String m_id = (String)session.getAttribute("userId");
		int l_m_num = le_numService.selectLM(m_id, l_num).getL_m_num();
		
		if(log.isDebugEnabled()) {
			log.debug("l_m_num : " + l_m_num);
		}
		
		lc_memService.insertLcmem(lc_num, l_m_num);
		
		//����������-ȸ�� ���̺� ����Ʈ
		List<L_contentCommand> lcList = l_contentService.selectLcJoinLcmUseLm(l_num, l_m_num);
		
		//������ ����������
		L_contentCommand lSibalcontent = l_contentService.selectOne(lc_num);
		
		model.addAttribute("lcList", lcList);
		model.addAttribute("lcontent", lSibalcontent);
		
		model.addAttribute("l_m_num", l_m_num);
		model.addAttribute("lc_num", lc_num);
		model.addAttribute("l_num", l_num);
		
		return "learnStudent";
	}
}
