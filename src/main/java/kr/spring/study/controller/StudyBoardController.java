package kr.spring.study.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.study.domain.StudyCommand;
import kr.spring.study.service.StudyService;
import kr.spring.util.PagingUtil; 

@Controller
public class StudyBoardController {
	private Logger log = Logger.getLogger(this.getClass());
	
	private int rowCount = 15;
	private int pageCount = 15;
	
	@Resource
	private StudyService studyService;
	  
	@RequestMapping("/study/studyBoard.do")
	public ModelAndView process(
			@RequestParam(value="pageNum",defaultValue="1")
			int currentPage,
			@RequestParam(value="keyfield",defaultValue="")
			String keyfield,
			@RequestParam(value="keyword",defaultValue="")
			String keyword
			) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<pageNum>> : " + currentPage);
			log.debug("<<keyfield>> : " + currentPage);
			log.debug("<<keyword>> : " + currentPage);
		}
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);
		
		//ÃÑ ±ÛÀÇ °¹¼ö ¶Ç´Â °Ë»öµÈ ±ÛÀÇ °¹¼ö
		int count = studyService.getRowCount(map);
		
		if(log.isDebugEnabled()) {
			log.debug("<<count>> : " + count);
		}
		
		PagingUtil page = new PagingUtil(keyfield,keyword,currentPage,count,rowCount,pageCount,"studyBoard.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<StudyCommand> list = null;
		if(count > 0) {
			list = studyService.list(map);
		}
		
		if(log.isDebugEnabled()) {
			log.debug("<<list>> : " + list);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("studyBoard");
		mav.addObject("count",count);
		mav.addObject("list",list);
		mav.addObject("pagingHtml",page.getPagingHtml());
		return mav;
		
	}

}
