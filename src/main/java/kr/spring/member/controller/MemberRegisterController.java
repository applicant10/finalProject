package kr.spring.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.member.domain.MemberCommand;
import kr.spring.member.service.MemberService;
import kr.spring.record.service.RecordService;

@Controller
public class MemberRegisterController {
	@Resource
	private MemberService memberService;
	
	@Resource
	private RecordService recordservice;
	
	@ModelAttribute("command")
	public MemberCommand initCommand() {
		return new MemberCommand();
	}
	
	@RequestMapping(value="/user/register.do", method=RequestMethod.GET)
	public String registerChoice() {
		return "registerChoice";
	}
	
	@RequestMapping(value="/user/registerForm.do", method=RequestMethod.GET)
	public String registerForm() {
		return "registerForm";
	}
	
	@RequestMapping(value="/user/registerForm.do", method=RequestMethod.POST)
	public String submit(@ModelAttribute("command") @Valid MemberCommand member, BindingResult result, HttpSession session,
			@RequestParam("m_nick")String m_nick
			) {
		member.setM_grade(1);
		if(result.hasErrors()) {
			return registerForm();
		}
		
		//회원가입
		memberService.insert(member);
		
		//record 추가
		Map<String, String> map = new HashMap<String, String>();
		map.put("m_nick", m_nick);
		map.put("record", "님 회원가입 하였습니다.");
		map.put("r_content", m_nick);
		recordservice.insertRecord(map);
		
		return "redirect:/main/main.do";
	}

}
