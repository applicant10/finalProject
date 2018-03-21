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
public class StudyUpdateController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private StudyService studyService;
	
	@RequestMapping(value="/study/studyUpdate.do",method=RequestMethod.GET)
	public String form(@RequestParam("t_num")int num, Model model) {
		
		StudyCommand studyCommand = studyService.selectBoard(num);
		model.addAttribute("command",studyCommand);
		
		return "studyUpdate";
	}
	@RequestMapping(value="/study/studyUpdate.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command")@Valid StudyCommand studyCommand, BindingResult result,HttpSession session,HttpServletRequest request) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<studyCommand>> : " + studyCommand);
		}
		
		StudyCommand study = studyService.selectBoard(studyCommand.getT_num());
		
		if(result.hasErrors()) {
			studyCommand.setM_nick(study.getM_nick());

		}
		
		if(log.isDebugEnabled()) {
			log.debug("<<studyCommand>> : " + studyCommand);
		}
		
		studyService.update(studyCommand);
		
		return "redirect:/study/studyBoard.do";
	}
}

