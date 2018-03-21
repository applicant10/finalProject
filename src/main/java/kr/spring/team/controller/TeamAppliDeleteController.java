package kr.spring.team.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.team.service.TeamAppliService;

@Controller
public class TeamAppliDeleteController{
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private TeamAppliService teamAppliService;
	
	@RequestMapping("/study/appliDelete.do")
	public String submit(@RequestParam("a_num")int num,
			@RequestParam("g_name")String g_name,
			@RequestParam("g_num") int g_num,
			HttpSession session) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<num>> : " + num);
		}
		
		teamAppliService.delete(num);
		
		return "redirect:/study/appliList.do?g_num="+g_num+"&g_name="+g_name;
	}
}
