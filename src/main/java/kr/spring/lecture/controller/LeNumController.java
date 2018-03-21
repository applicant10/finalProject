package kr.spring.lecture.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.lecture.service.Le_numService;

@Controller
public class LeNumController {
	@Resource
	private Le_numService le_numService;
	
	@RequestMapping("/lecture/enrollment.do")
	public String enrollment(@RequestParam("l_num") int l_num, HttpSession session, Model model) {
		String m_id = (String)session.getAttribute("userId");
		
		//�������̺� �����ϰ�, ���¹�ȣ�� �ش�Ǵ� ���� ����Ʈ �������ؼ� ���� �������̺�� ����
		le_numService.insertLeNum(m_id, l_num);
		return "redirect:/lecture/lectureView.do?l_num="+l_num;	//�ش� ���� �������� ����
	}
}