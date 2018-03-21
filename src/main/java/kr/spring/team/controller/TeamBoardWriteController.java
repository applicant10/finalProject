package kr.spring.team.controller;

import java.util.HashMap;
import java.util.Map;

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

import kr.spring.team.domain.TeamBoardCommand;
import kr.spring.team.service.TeamBoardService;

@Controller
public class TeamBoardWriteController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private TeamBoardService teamBoardService;
	
	@RequestMapping(value="/study/teamBoardWrite.do",method=RequestMethod.GET)
	public String form(HttpSession session,Model model,
			@RequestParam(value="g_num")int num){
		
		if(log.isDebugEnabled()) {
			log.debug("<<num>> : " + num);
			
		}
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("g_num", num);
		
		String nick = (String)session.getAttribute("userNick");
		
		TeamBoardCommand command = new TeamBoardCommand();
		command.setM_nick(nick);
		command.setG_num(num);
		
		model.addAttribute("command",command);
		
		return "teamBoardWrite";
		
	}
	
	@RequestMapping(value="/study/teamBoardWrite.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command")@Valid TeamBoardCommand teamBoardCommand,HttpSession session,BindingResult result,HttpServletRequest request,
			@RequestParam(value="g_num")int g_num
			) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<teamBoardCommand>> : " + teamBoardCommand);
		}
		
		if(result.hasErrors()) {
			return "teamBoardWrite";
		}
		
		teamBoardService.insert(teamBoardCommand);
		
		return "redirect:/study/teamBoard.do?g_num="+g_num;
	}
}
