package kr.spring.team.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.record.domain.RecordCommand;
import kr.spring.record.service.RecordService;
import kr.spring.team.domain.TeamAppliCommand;
import kr.spring.team.service.TeamAppliService;
import kr.spring.util.StringUtil;

@Controller
public class TeamAppliDetailController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private TeamAppliService teamAppliService;
	
	
	@RequestMapping("/study/appliDetail.do")
	public ModelAndView process(HttpSession session,
			@RequestParam("a_num")int num,
			@RequestParam("g_name")String g_name
			) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<num>> : " + num);
			log.debug("<<g_name>> : " + g_name);
		}
		
		TeamAppliCommand appli = teamAppliService.select(num);
		
		appli.setA_content(StringUtil.useBrNoHtml(appli.getA_content()));
		
		return new ModelAndView("appliDetail","appli",appli);
		
	}
}
