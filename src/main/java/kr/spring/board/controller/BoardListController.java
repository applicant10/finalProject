package kr.spring.board.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.board.domain.BoardCommand;
import kr.spring.board.service.BoardService;
import kr.spring.util.PagingUtil;

@Controller
public class BoardListController {
	private Logger log = Logger.getLogger(this.getClass());
	
	private int rowCount = 10;
	private int pageCount = 10;
	
	@Resource
	private BoardService boardService;
	
	@RequestMapping("/board/boardList.do")
	public ModelAndView getList(@RequestParam(value="pageNum",defaultValue="1")int currentPage,
								@RequestParam(value="keyfield",defaultValue="")String keyfield,
								@RequestParam(value="keyword",defaultValue="")String keyword){
		
		if(log.isDebugEnabled()) {
			log.debug("<<pageNum>> : " + currentPage);
			log.debug("<<keyfield>> : " + keyfield);
			log.debug("<<keyword>> : " + keyword);
		}
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);
		
		//ÃÑ ±ÛÀÇ °¹¼ö ¶Ç´Â °Ë»öµÈ ±ÛÀÇ °¹¼ö
		int count = boardService.getRowCount(map);
		
		if(log.isDebugEnabled()) {
			log.debug("<<count>> : " + count);
		}
		
		PagingUtil page = new PagingUtil(keyfield, keyword, currentPage, count, rowCount,pageCount,"list.do");
		
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<BoardCommand> list = null;
		
		if(count > 0) {
			list = boardService.list(map);
		}else {
			list = Collections.emptyList();
		}
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("boardList");
		mav.addObject("count", count);
		mav.addObject("list", list);
		mav.addObject("pagingHtml", page.getPagingHtml());
		return mav;
	}
}
