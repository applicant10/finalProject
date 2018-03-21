package kr.spring.board.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.spring.board.domain.BoardCommand;
import kr.spring.board.service.BoardService;

@Controller
public class BoardWriteController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private BoardService boardService;
	
	@RequestMapping(value="/board/write.do",method=RequestMethod.GET)
	public String form(HttpSession session,Model model) {
		String id = (String)session.getAttribute("userId");
		String nick = (String)session.getAttribute("userNick");
		
		
		BoardCommand command = new BoardCommand();
		command.setM_id(id);
		command.setB_nick(nick);
		model.addAttribute("command", command);
		
		return "boardWrite";
	}
	@RequestMapping(value="/board/write.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command")@Valid BoardCommand boardCommand,BindingResult result,HttpServletRequest request) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<boardCommand>> : " + boardCommand);
		}
		
		if(result.hasErrors()) {
			return "boardWrite";
		}
		
		//ip 셋팅
		boardCommand.setB_ip(request.getRemoteAddr());
		
		//글쓰기
		boardService.insert(boardCommand);
		
		return "redirect:/board/boardList.do";
	}
	
}






