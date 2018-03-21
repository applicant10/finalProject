package kr.spring.board.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.board.service.BoardService;

@Controller
public class BoardDeleteController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private BoardService boardService;
	
	@RequestMapping("/board/delete.do")
	public String submit(@RequestParam("num") int num, HttpSession session) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<num>> : " + num);
		}
		
		//±€ ªË¡¶
		boardService.delete(num);
		
		return "redirect:/board/boardList.do";
	}
}
