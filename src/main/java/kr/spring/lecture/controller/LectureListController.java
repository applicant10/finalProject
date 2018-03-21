package kr.spring.lecture.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.lecture.domain.LectureCommand;
import kr.spring.lecture.service.LectureService;
import kr.spring.subject.domain.SubjectCommand;
import kr.spring.subject.service.SubjectService;
import kr.spring.util.PagingUtil;

@Controller
public class LectureListController {
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 10;
	private int pageCount = 10;
	
	@Resource
	private LectureService lectureService;
	
	@Resource SubjectService subjectService;
	
	@RequestMapping("/lecture/lectureList.do")
	public ModelAndView lectureListView(
			@RequestParam(value="pageNum", defaultValue="1")int currentPage,
			@RequestParam(value="keyfield", defaultValue="")String keyfield,
			@RequestParam(value="keyword",defaultValue="")String keyword,
			@RequestParam(value="s_num", defaultValue="0")int subject) {
		
		if(log.isDebugEnabled()) {
			log.debug("currentPage : " + currentPage);
			log.debug("keyfield : " + keyfield);
			log.debug("keyword : " + keyword);
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);
		map.put("subject", subject);
		
		int count = lectureService.getRowCount_otherSearch(map);
		
		PagingUtil page = new PagingUtil(keyfield,keyword,currentPage,count,rowCount, pageCount,"lectureList.do", "&subject="+subject);
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<LectureCommand> list = null;
		if(count > 0) {
			list = lectureService.listOtherSearch(map);
		}
		
		List<SubjectCommand> subLv1s = subjectService.selectLv1();
		List<SubjectCommand> subLv2s = subjectService.selectLv2AllSearch();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("lectureListView");
		mav.addObject("count",count);
		mav.addObject("list", list);
		mav.addObject("pagingHtml", page.getPagingHtml());
		
		mav.addObject("subLv1s", subLv1s);
		mav.addObject("subLv2s", subLv2s);
		
		return mav;
	}
}
