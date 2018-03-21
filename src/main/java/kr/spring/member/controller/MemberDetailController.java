package kr.spring.member.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.spring.member.domain.MemberCommand;
import kr.spring.member.service.MemberService;
import kr.spring.resume.domain.UserResumeCommand;
import kr.spring.resume.service.UserResumeService;

@Controller
public class MemberDetailController {
	@Resource
	private MemberService memberService;
	@Resource
	private UserResumeService userResumeService;
	
	@RequestMapping("/user/myInfo.do")
	public String showDetail(HttpSession session, Model model) {
		String id = (String)session.getAttribute("userId");
		UserResumeCommand resumeCommand = userResumeService.selectResume(id);
		boolean check = false;
		if(resumeCommand!=null) {
			check=true;
		}
		MemberCommand member = memberService.selectMemberDetail(id);
		model.addAttribute("member", member);
		model.addAttribute("check",check);
		return "myInfo";
	}
}
