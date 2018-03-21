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
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.team.domain.TeamAppliCommand;
import kr.spring.team.service.TeamAppliService;

@Controller
public class TeamApplyWriteController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private TeamAppliService teamAppliService;
	
	@RequestMapping(value="/study/teamAppli.do",method=RequestMethod.GET)
	public String form(
			@RequestParam("g_num")int g_num,
			HttpSession session,Model model) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<g_num>> : " + g_num);
		}
		
		String nick = (String)session.getAttribute("userNick");
		
		TeamAppliCommand command = new TeamAppliCommand();
		
		command.setM_nick(nick);
		command.setG_num(g_num);
		
		model.addAttribute("command",command);
		
		return "teamAppli";
	}
	
	@RequestMapping(value="/study/teamAppli.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command")@Valid TeamAppliCommand teamAppliCommand,HttpSession session,BindingResult result,HttpServletRequest request) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<teamAppliCommand>> : " + teamAppliCommand);
		}
		
		if(result.hasErrors()) {
			return "teamAppli";
		}
		
		teamAppliService.insert(teamAppliCommand);
		
		return "redirect:/main/main.do";
	}
			
}
