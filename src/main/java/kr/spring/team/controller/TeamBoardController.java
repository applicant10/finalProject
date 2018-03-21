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

import kr.spring.team.domain.TeamBoardCommand;
import kr.spring.team.domain.TeamMemberCommand;
import kr.spring.team.service.TeamBoardService;
import kr.spring.team.service.TeamMemberService;
import kr.spring.util.PagingUtil;
import kr.spring.util.StringUtil;

@Controller
public class TeamBoardController {
	private Logger log = Logger.getLogger(this.getClass());
	 
	private int rowCount = 15;
	private int pageCount = 10;
	@Resource
	private TeamMemberService teamMemberService;
	
	@Resource
	private TeamBoardService teamBoardService;
	
	@RequestMapping(value="/study/teamBoard.do",method=RequestMethod.GET)
	public ModelAndView process(
			@RequestParam("g_num")int num,
			@RequestParam(value="pageNum",defaultValue="1")
			int currentPage,
			@RequestParam(value="keyfield",defaultValue="")
			String keyfield,
			@RequestParam(value="keyword",defaultValue="")
			String keyword,
			HttpSession session
			) {
		
		String m_nick = (String)session.getAttribute("userNick");
		
		if(log.isDebugEnabled()) {
			log.debug("<<pageNum>> : " + currentPage);
			log.debug("<<keyfield>> : " + currentPage);
			log.debug("<<keyword>> : " + currentPage);
		}
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("g_num", num);
		map.put("m_nick", m_nick);
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);

		int count = teamBoardService.getRowCount(map);
		int memberCount = teamMemberService.memberCount(map);
		
		if(log.isDebugEnabled()) {
			log.debug("<<count>> : " + count);
			log.debug("<<memberCount>> : " + memberCount);
		}
		
		
		PagingUtil page = new PagingUtil(keyfield,keyword,currentPage,count,rowCount,pageCount,"teamBoard.do","&g_num="+num);
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<TeamBoardCommand> list = null;
		if(count > 0) {
			list = teamBoardService.list(map);
		}
			
		
		if(log.isDebugEnabled()) {
			log.debug("<<list>> : " + list);
		}
		
		if(log.isDebugEnabled()) {
			log.debug("<<num>> : " + num);
		}
		
		TeamMemberCommand member = teamMemberService.selectBoard(num);
		
		member.setG_greet(StringUtil.useBrNoHtml(member.getG_greet()));
		member.setG_name(StringUtil.useBrNoHtml(member.getG_name()));
							
		ModelAndView mav = new ModelAndView();
		mav.setViewName("teamBoard");
		mav.addObject("member",member);
		mav.addObject("count",count);
		mav.addObject("memberCount",memberCount);
		mav.addObject("list",list);
		mav.addObject("pagingHtml",page.getPagingHtml());
		return mav;
	}
	
}
	