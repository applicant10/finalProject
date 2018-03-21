package kr.spring.team.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.spring.record.domain.RecordCommand;
import kr.spring.record.service.RecordService;
import kr.spring.team.domain.TeamMemberCommand;
import kr.spring.team.service.TeamMemberService;

@Controller
public class StudyEstablishController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private TeamMemberService teamMemberService;
	
	@Resource
	private RecordService recordService;
	
	@RequestMapping(value="/study/studyEstablish.do")
	public String form(HttpSession session,Model model) {
		String nick = (String)session.getAttribute("userNick");
		
		TeamMemberCommand command = new TeamMemberCommand();
		
		command.setM_nick(nick);
		model.addAttribute("command",command);
		
		return "studyEstablish";
	}
	@RequestMapping(value="/study/studyEstablish.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command")@Valid TeamMemberCommand teamMemberCommand,RecordCommand recordCommand,HttpSession session,BindingResult result,HttpServletRequest request) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<teamMemberCommand>> : " + teamMemberCommand);
		}
		
		if(result.hasErrors()) {
			return "studyEstablish";
		}
		
		teamMemberService.insertInfo(teamMemberCommand);
		teamMemberService.insertRecord(recordCommand);
		
		return "redirect:/main/main.do";
	}
}