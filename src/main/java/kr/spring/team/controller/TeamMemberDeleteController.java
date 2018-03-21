package kr.spring.team.controller;

import java.util.HashMap;
import java.util.Map;

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
public class TeamMemberDeleteController {
	//ÆÀ Å»Åð
private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private TeamMemberService teamMemberService;
	
	@Resource 
	private RecordService recordService;
	
	@RequestMapping("/study/teamMemberDelete.do")
	public String submit(@RequestParam("g_num")int g_num,
			@RequestParam("m_nick") String m_nick,
			@RequestParam("g_name") String g_name,
			HttpSession session) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<g_num>> : " + g_num);
			log.debug("<<m_nick>> : " + m_nick);
			log.debug("<<g_name>> : " + g_name);
		}
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("g_num", g_num);
		map.put("m_nick", m_nick);
		map.put("g_name", g_name);
		
		teamMemberService.deleteInfoRecord(map);
		teamMemberService.deleteInfo(map);
		
		return "redirect:/study/myGroup.do";
	}
}
