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
		//내 정보 보여주고 마지막 확인 받는 기능 추가하자.
		String id = (String)session.getAttribute("userId");
		
		if(log.isDebugEnabled()) {
			log.debug("<<from sesssion String>> : " + id);
		}
		
		MemberCommand member = memberService.selectMemberDetail(id);	//임시로 회원정보 출력
		
		model.addAttribute("member", member);
		
		return "deleteAsk";
	}
	
	@RequestMapping(value="/user/delete.do", method=RequestMethod.POST)
	public String deleteAgree(@ModelAttribute("member") MemberCommand member, HttpSession session, Model model, BindingResult result) {
		if(log.isDebugEnabled()) {
			log.debug("<<memberCommand>> : " + member);
		}
		
		String id = (String)session.getAttribute("userId");
		
		System.out.println("탈퇴요청 ID : " + id);
		try {
			MemberCommand command = memberService.selectMember(id);
			System.out.println("세션으로 검색한 pw" + command.getM_pw());
			boolean check = false;
			
			if(check) {	//비밀번호 맞아버림.
				memberService.deleteMember(id);
				session.invalidate();
				return "redirect:/main/main.do";
			}else {	//비밀번호 틀림.
				throw new Exception();
			}
		}catch(Exception e) {	//틀리면 catch블락으로 던져짐.
			model.addAttribute("message", "비밀번호를 잘못 입력하셨습니다.");
			model.addAttribute("url", "/user/delete.do");
			return "/common/alert";
		}
	}
}