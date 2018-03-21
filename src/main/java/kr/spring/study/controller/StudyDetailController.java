package kr.spring.study.controller;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.study.domain.StudyCommand;
import kr.spring.study.service.StudyService;
import kr.spring.team.domain.TeamAppliCommand;
import kr.spring.team.service.TeamAppliService;

@Controller
public class StudyDetailController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private StudyService studyService;
	
	@Resource
	private TeamAppliService teamAppliService;
	
	@RequestMapping("/study/studyDetail.do")
	public ModelAndView process(HttpSession session,
			@RequestParam("t_num")int t_num,
			@RequestParam("g_num")int g_num
			) {
		String m_nick = (String)session.getAttribute("userNick");
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("g_num", g_num);
		map.put("m_nick", m_nick);
		
		log.debug("g_num >> " + map.get("g_num"));
		log.debug("m_nick>> " + map.get("m_nick"));
		
		int count = teamAppliService.applyCount(map);
		log.debug("count>> " + count);
		if(log.isDebugEnabled()) {
			log.debug("<<t_num>> : " + t_num);
		}
		
		StudyCommand study = studyService.selectBoard(t_num);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("studyDetail");
		mav.addObject("count",count);
		mav.addObject("study",study);
		return mav;
	}
}
