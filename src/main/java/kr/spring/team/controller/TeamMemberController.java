package kr.spring.team.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.team.domain.TeamMemberCommand;
import kr.spring.team.service.TeamMemberService;
import kr.spring.util.PagingUtil;

@Controller
public class TeamMemberController {
	private Logger log = Logger.getLogger(this.getClass());
	
	private int rowCount = 10;
	private int pageCount = 10;
	
	@Resource
	private TeamMemberService teamMemberService;
	
	@RequestMapping(value="/study/myGroup.do",method=RequestMethod.GET)
	public ModelAndView process(HttpSession session, 
			@RequestParam(value="pageNum",defaultValue="1")
			int currentPage) {
		
		String nick = (String)session.getAttribute("userNick");

		
		if(log.isDebugEnabled()) {
			log.debug("<<pageNum>> : " + currentPage);
		}
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("m_nick", nick);
		
		
		int count = teamMemberService.getRowCount(map);
		
		if(log.isDebugEnabled()) {
			log.debug("<<count>> : " + count);
		}

		
		PagingUtil page = new PagingUtil(currentPage,count,rowCount,pageCount,"myGroup.do");
		/*map.put("m_nick", nick);*/
		map.put("start",page.getStartCount());
		map.put("end",page.getEndCount());
		
		List<TeamMemberCommand> list = null;
		if(count > 0) {
			list = teamMemberService.list(map);
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("myGroup");
		mav.addObject("count",count);
		mav.addObject("list",list);
		mav.addObject("pagingHtml",page.getPagingHtml());
		return mav; 
	}
}
