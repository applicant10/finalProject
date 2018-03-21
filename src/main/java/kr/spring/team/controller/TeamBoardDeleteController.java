package kr.spring.team.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.team.service.TeamBoardService;

@Controller
public class TeamBoardDeleteController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private TeamBoardService teamBoardService;
	
	@RequestMapping("/study/teamBoardDelete.do")
	public String submit(
			@RequestParam("tb_num")int num,
			@RequestParam("g_num")int g_num
			,HttpSession session) {
			
		if(log.isDebugEnabled()) {
			log.debug("<<num>> : " + num);
			log.debug("<<g_num>> : " + g_num);
		}
		
		teamBoardService.delete(num);
		
		return "redirect:/study/teamBoard.do?g_num="+g_num;
	}
}
