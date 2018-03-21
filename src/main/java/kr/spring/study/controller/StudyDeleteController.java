package kr.spring.study.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.study.service.StudyService;

@Controller
public class StudyDeleteController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private StudyService studyService;
	
	@RequestMapping("/study/studyDelete.do")
	public String submit(@RequestParam("t_num")int num,HttpSession session) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<num>> : " + num);
		}
		
		studyService.delete(num);
		
		return "redirect:/study/studyBoard.do";
	}
}
