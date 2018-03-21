package kr.spring.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.member.domain.MemberCommand;
import kr.spring.member.service.MemberService;
import kr.spring.record.service.RecordService;

@Controller
public class MemberUpdateController {
	@Resource
	private MemberService memberService;
	
	@Resource
	private RecordService recordservice;
	
	@RequestMapping(value="/user/update.do", method=RequestMethod.GET)
	public String form(HttpSession session, Model model) {
		String id = (String)session.getAttribute("userId");
		MemberCommand member = memberService.selectMemberDetail(id);
		
		model.addAttribute("member", member);
		return "memberUpdate";
	}
	
	@RequestMapping(value="/user/update.do", method=RequestMethod.POST)
	public String submit(@ModelAttribute("member")@Valid MemberCommand memberCommand, BindingResult result, Model model,
			@RequestParam("m_nick")String m_nick
			) {
		if(result.hasErrors()) {
			return "memberUpdate";
		}
		memberService.updateMember(memberCommand);
		
		model.addAttribute("message", "���� ������ �Ϸ� �Ǿ����ϴ�.");
		model.addAttribute("url", "/user/myInfo.do");
		
		//record �߰�
		Map<String, String> map = new HashMap<String, String>();
		map.put("m_nick", m_nick);
		map.put("record", "�� ȸ�� ������ �����Ͽ����ϴ�.");
		map.put("r_content", m_nick);
		
		recordservice.insertRecord(map);
		
		return "/common/alert";
	}
}