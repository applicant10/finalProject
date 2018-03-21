package kr.spring.team.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.team.domain.TeamBoardReplyCommand;
import kr.spring.team.service.TeamBoardService;
import kr.spring.util.PagingUtil;

@Controller
public class TeamReplyAjaxController {
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 10;
	
	@Resource
	private TeamBoardService teamBoardService;
	
	@RequestMapping("/study/teamReply.do")
	@ResponseBody
	public Map<String,Object> teamReply(
			@RequestParam(value="pageNum",defaultValue="1")int currentPage,
			@RequestParam("tb_num")int num){
				
		if(log.isDebugEnabled()) {
			log.debug("<<currentPage>> : " + currentPage);
			log.debug("<<num>> : " + num);
		}
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("tb_num", num);
		
		int count = teamBoardService.g_getRowCountReply(map);
		
		PagingUtil page = new PagingUtil(currentPage,count,rowCount,1,null);
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<TeamBoardReplyCommand> list = null;
		if(count > 0) {
			list = teamBoardService.teamReply(map);
		}else {
			list = Collections.emptyList();
		}
		
		Map<String,Object> mapJson = new HashMap<String,Object>();
		mapJson.put("count", count);
		mapJson.put("rowCount",rowCount);
		mapJson.put("list", list);
		
		return mapJson;
	}
	
	//´ñ±Û µî·Ï
	@RequestMapping("/study/g_insertReply.do")
	@ResponseBody
	public Map<String,String> g_insertReply(TeamBoardReplyCommand teamBoardReplyCommand,HttpSession session,HttpServletRequest request){
		
		if(log.isDebugEnabled()) {
			log.debug("<<teamBoardReplyCommand>> : " + teamBoardReplyCommand);
		}
		
		Map<String,String> map = new HashMap<String,String>();
		
		String m_nick = (String)session.getAttribute("userNick");
		if(m_nick==null) {
			map.put("result", "logout");
		}else {
			teamBoardService.g_insertReply(teamBoardReplyCommand);
			map.put("result", "success");
		}
		return map;
		
	}
	
	//´ñ±Û ¼öÁ¤
	@RequestMapping("/study/g_updateReply.do")
	@ResponseBody
	public Map<String,String> g_updateReply(
			TeamBoardReplyCommand teamBoardReplyCommand,
			HttpSession session,
			HttpServletRequest request
			){
		
		if(log.isDebugEnabled()) {
			log.debug("<<teamBoardReplyCommand>> : " + teamBoardReplyCommand);
		}
		
		Map<String,String> map = new HashMap<String,String>();
		
		String userNick = (String)session.getAttribute("userNick");
		
		if(userNick==null) {
			map.put("result", "logout");
		}else if(userNick!=null && userNick.equals(teamBoardReplyCommand.getM_nick())) {
			teamBoardService.g_updateReply(teamBoardReplyCommand);
			map.put("result", "success");
		}else {
			map.put("result","wrongAccess");
		}
		
		return map;
	}	
	
	//´ñ±Û »èÁ¦
	@RequestMapping("/study/g_deleteReply.do")
	@ResponseBody
	public Map<String,String> g_deleteReply(
			@RequestParam("re_gnum") int re_gnum,
			@RequestParam("m_nick")String nick,
			HttpSession session){
		
			if(log.isDebugEnabled()) {
				log.debug("<<nick>> : " + nick);
			}
			
			Map<String,String> map = new HashMap<String,String>();
			
			String userNick = (String)session.getAttribute("userNick");
			if(userNick==null) {
				map.put("result", "logout");
			}else if(userNick!=null && userNick.equals(userNick)) {
				teamBoardService.g_deleteReply(re_gnum);
				map.put("result", "success");
			}else {
				map.put("result", "wrongAccess");
			}
			
			return map;
	}
	
}
