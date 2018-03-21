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

import kr.spring.team.domain.TeamBoardCommand;
import kr.spring.team.service.TeamBoardService;

@Controller
public class TeamBoardUpdateController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private TeamBoardService teamBoardService;
	
	@RequestMapping(value="/study/teamBoardUpdate.do",method=RequestMethod.GET)
	public String form(@RequestParam("tb_num")int num,
			Model model) {
		
		TeamBoardCommand teamBoardCommand = teamBoardService.select(num);
		model.addAttribute("command",teamBoardCommand);
		
		return "teamBoardUpdate";
	}
	@RequestMapping(value="/study/teamBoardUpdate.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command")@Valid TeamBoardCommand teamBoardCommand,BindingResult result,HttpSession session,HttpServletRequest request,
			@RequestParam("g_num")int g_num
			) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<teamBoardCommand>> : " + teamBoardCommand);
		}
		
		TeamBoardCommand teamBoard = teamBoardService.select(teamBoardCommand.getTb_num());
		
		if(result.hasErrors()) {
			teamBoardCommand.setFilename(teamBoard.getFilename());
			return "teamBoardUpdate";
		}
		if(teamBoardCommand.getUpload().isEmpty()){
			teamBoardCommand.setUploadfile(teamBoard.getUploadfile());
			teamBoardCommand.setFilename(teamBoard.getFilename());
		}
		
		if(log.isDebugEnabled()) {
			log.debug("<<teamBoardCommand>> : " + teamBoardCommand);
		}
		
		teamBoardService.update(teamBoardCommand);
		
		return "redirect:/study/teamBoard.do?g_num="+g_num;
	}
}
