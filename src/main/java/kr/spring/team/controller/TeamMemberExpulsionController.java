package kr.spring.team.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.record.domain.RecordCommand;
import kr.spring.record.service.RecordService;
import kr.spring.team.service.TeamMemberService;

@Controller
public class TeamMemberExpulsionController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private TeamMemberService teamMemberService;
	
	@Resource
	private RecordService recordService;
	
	@RequestMapping("/study/memberDelete.do")
	public String submit(@RequestParam("g_num")int g_num,
			@RequestParam("g_name")String g_name,
			@RequestParam("m_nick")String m_nick,
			RecordCommand recordCommand
			) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("g_num", g_num);
		map.put("m_nick", m_nick);
		map.put("g_name", g_name);
		
		if(log.isDebugEnabled()) {
			log.debug("<<g_num>> : " + g_num);
			log.debug("<<g_name>> : " + g_name);
			log.debug("<<m_nick>> : " + m_nick);
		}
		
		teamMemberService.redCard(map);
		teamMemberService.redCardRecord(map);
		
		return "redirect:/study/teamBoard.do?g_num="+g_num;
	}
	
}
