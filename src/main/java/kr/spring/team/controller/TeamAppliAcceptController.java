package kr.spring.team.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.record.domain.RecordCommand;
import kr.spring.record.service.RecordService;
import kr.spring.team.domain.TeamAppliCommand;
import kr.spring.team.service.TeamAppliService;

@Controller
public class TeamAppliAcceptController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private TeamAppliService teamAppliService;
	
	@RequestMapping("/study/appliAccept.do")
	public String submit(
			@RequestParam("g_num")int g_num,
			@RequestParam("a_num")int a_num,
			@RequestParam("m_nick")String m_nick,
			@RequestParam("g_name")String g_name,
			TeamAppliCommand teamAppliCommand,
			RecordCommand recordCommand
			) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<g_num>> : " + g_num);
			log.debug("<<a_num>> : " + a_num);
			log.debug("<<m_nick>> : " + m_nick);
			log.debug("<<g_name>> : " + g_name);
			log.debug("<<teamAppliCommand>> : " + teamAppliCommand);
		}
		
		teamAppliService.join(teamAppliCommand);
		teamAppliService.after(a_num);
		teamAppliService.insertRecord(recordCommand);
		
		
		return "redirect:/study/appliList.do?g_num="+g_num+"&g_name="+g_name;
	}
	
}
	
	

