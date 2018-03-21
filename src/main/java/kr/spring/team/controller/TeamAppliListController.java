package kr.spring.team.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.team.domain.TeamAppliCommand;
import kr.spring.team.service.TeamAppliService;
import kr.spring.util.PagingUtil;

@Controller
public class TeamAppliListController {
	private Logger log = Logger.getLogger(this.getClass());
	
	private int rowCount = 20;
	private int pageCount = 10;
	
	@Resource
	private TeamAppliService teamAppliService;
	
	
	
	@RequestMapping("/study/appliList.do")
	public ModelAndView process(
			@RequestParam("g_num")int num,
			@RequestParam("g_name")String g_name,
			@RequestParam(value="pageNum",defaultValue="1")
			int currentPage
			) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<pageNum>> : " + currentPage);
		}
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("g_num",num);
		map.put("g_name",g_name);
		
				
		int count = teamAppliService.getRowCount(map);
		
		if(log.isDebugEnabled()) {
			log.debug("<<count>> : " + count);
		}
		
		PagingUtil page = new PagingUtil(currentPage,count,rowCount,pageCount,"appliList.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<TeamAppliCommand> list = null;
		if(count > 0) {
			list = teamAppliService.list(map);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("appliList");
		mav.addObject("count",count);
		mav.addObject("list",list);
		mav.addObject("pagingHtml",page.getPagingHtml());
		mav.addObject("g_num", num);
		mav.addObject("g_name", g_name);
		return mav;
	}
			
}
