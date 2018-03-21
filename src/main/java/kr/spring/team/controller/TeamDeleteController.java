package kr.spring.team.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.record.domain.RecordCommand;
import kr.spring.record.service.RecordService;
import kr.spring.team.service.TeamMemberService;

@Controller
public class TeamDeleteController {
	//ÆÀ ÆóÁö
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private TeamMemberService teamMemberService;
	
	@Resource 
	private RecordService recordService;
	
	@RequestMapping("/study/teamDelete.do")
	public String submit(@RequestParam("g_num")int num,
			RecordCommand recordCommand,
			HttpSession session) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<num>> : " + num);
		}
		
		teamMemberService.deleteRecord(recordCommand);
		teamMemberService.delete(num);
		
		return "redirect:/study/myGroup.do";
	}
}
