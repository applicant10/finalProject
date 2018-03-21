package kr.spring.study.controller;

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

import kr.spring.study.domain.StudyCommand;
import kr.spring.study.service.StudyService;

@Controller
public class StudyWriteController {
	private Logger log = Logger.getLogger(this.getClass());

	@Resource
	private StudyService studyService;
	
	@RequestMapping(value="/study/studyWrite.do",method=RequestMethod.GET)
	public String form(
			@RequestParam("g_num") int g_num,
			HttpSession session,Model model) {
		String nick = (String)session.getAttribute("userNick");
		
		StudyCommand command = new StudyCommand();
		
		command.setM_nick(nick);
		command.setG_num(g_num);
		
		model.addAttribute("command",command);
		
		return  "studyWrite";
	}
	@RequestMapping(value="/study/studyWrite.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command")@Valid StudyCommand studyCommand,HttpSession session,BindingResult result,HttpServletRequest request) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<studyCommand>> :" + studyCommand);
		}
		
		if(result.hasErrors()) {
			return "studyWrite";
		}

		//±Û¾²±â
		studyService.insert(studyCommand);
			
		return "redirect:/study/studyBoard.do";
	}
}
