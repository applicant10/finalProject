package kr.spring.board.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.board.domain.BoardCommand;
import kr.spring.board.service.BoardService;
import kr.spring.util.StringUtil;

@Controller
public class BoardDetailController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private BoardService boardService;
	
	@RequestMapping("/board/detail.do")
	public ModelAndView getDetail(@RequestParam("num")int num) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<num>> : " + num);
		}
		
		//해당 글의 조회수 증가
		boardService.updateHit(num);
		
		BoardCommand board = boardService.selectBoard(num);
		board.setB_title(StringUtil.useNoHtml(board.getB_title()));
		
		return new ModelAndView("boardView","board",board);
	}
}









