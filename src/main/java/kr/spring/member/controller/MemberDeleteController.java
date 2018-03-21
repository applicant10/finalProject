package kr.spring.member.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.spring.member.domain.MemberCommand;
import kr.spring.member.service.MemberService;

@Controller
public class MemberDeleteController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	MemberService memberService;
	
	@RequestMapping(value="/user/delete.do", method=RequestMethod.GET)
	public String askView(HttpSession session, Model model) {
		//�� ���� �����ְ� ������ Ȯ�� �޴� ��� �߰�����.
		String id = (String)session.getAttribute("userId");
		
		if(log.isDebugEnabled()) {
			log.debug("<<from sesssion String>> : " + id);
		}
		
		MemberCommand member = memberService.selectMemberDetail(id);	//�ӽ÷� ȸ������ ���
		
		model.addAttribute("member", member);
		
		return "deleteAsk";
	}
	
	@RequestMapping(value="/user/delete.do", method=RequestMethod.POST)
	public String deleteAgree(@ModelAttribute("member") MemberCommand member, HttpSession session, Model model, BindingResult result) {
		if(log.isDebugEnabled()) {
			log.debug("<<memberCommand>> : " + member);
		}
		
		String id = (String)session.getAttribute("userId");
		
		System.out.println("Ż���û ID : " + id);
		try {
			MemberCommand command = memberService.selectMember(id);
			System.out.println("�������� �˻��� pw" + command.getM_pw());
			boolean check = false;
			
			if(check) {	//��й�ȣ �¾ƹ���.
				memberService.deleteMember(id);
				session.invalidate();
				return "redirect:/main/main.do";
			}else {	//��й�ȣ Ʋ��.
				throw new Exception();
			}
		}catch(Exception e) {	//Ʋ���� catch������� ������.
			model.addAttribute("message", "��й�ȣ�� �߸� �Է��ϼ̽��ϴ�.");
			model.addAttribute("url", "/user/delete.do");
			return "/common/alert";
		}
	}
}