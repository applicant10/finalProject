package kr.spring.record.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.record.domain.RecordCommand;
import kr.spring.record.service.RecordService;
import kr.spring.util.PagingUtil;

@Controller
public class RecordController {
	private Logger log = Logger.getLogger(this.getClass());
	
	private int rowCount = 20;
	private int pageCount = 10;
	
	@Resource
	private RecordService recordService;
	
	@RequestMapping("/record/record.do")
	public ModelAndView process(
			@RequestParam(value="pageNum",defaultValue="1")
			int currentPage,
			HttpSession session,Model model
			) {
		
		String userNick = (String)session.getAttribute("userNick");
		
		if(log.isDebugEnabled()) {
			log.debug("<<pageNum>> : " + currentPage);
		}
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userNick",userNick);
		
		int count = recordService.getRowCount(map);
		
		if(log.isDebugEnabled()) {
			log.debug("<<count>> : " + count);
		}
		
		PagingUtil page = new PagingUtil(currentPage,count,rowCount,pageCount,"record.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<RecordCommand> list = null;
		if(count > 0) {
			list = recordService.list(map);
		}
		
		if(log.isDebugEnabled()) {
			log.debug("<<list>> : " + list);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("record");
		mav.addObject("count",count);
		mav.addObject("list",list);
		mav.addObject("pagingHtml",page.getPagingHtml());
		return mav;
	}
	
}