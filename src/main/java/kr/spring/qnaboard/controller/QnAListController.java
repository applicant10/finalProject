package kr.spring.qnaboard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.qnaboard.domain.QnABoardCommand;
import kr.spring.qnaboard.service.QnABoardService;
import kr.spring.util.PagingUtil;

@Controller
public class QnAListController {
	private Logger log = Logger.getLogger(this.getClass());

	private int rowCount = 10;
	private int pageCount = 10;

	@Resource
	private QnABoardService qnABoardService;

	@RequestMapping("/qna/qnaBoardList.do")
	public ModelAndView process(
			HttpSession session,
			@RequestParam(value = "pageNum", defaultValue = "1") int currentPage,
			@RequestParam(value = "keyfield", defaultValue = "") String keyfield,
			@RequestParam(value = "keyword", defaultValue = "") String keyword) 
	{
		String id = (String) session.getAttribute("m_id");
		
		// 로그
		if (log.isDebugEnabled()) {
			log.debug("<<pageNum>> : " + currentPage);
			log.debug("<<keyfield>> : " + keyfield);
			log.debug("<<keyword>> : " + keyword);
		}

		// DB QNA BOARD SELECT 용 (Where 쿼리조건)
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);

		// 총 글의 갯수 또는 검색된 글의 갯수
		int count = qnABoardService.getQnaRowCnt(map);
		//로그
		if (log.isDebugEnabled()) {
			log.debug("<<count>> : " + count);
		}
		
		//페이징 처리
		PagingUtil page = new PagingUtil(keyfield, keyword, currentPage, count, rowCount, pageCount, "qnaBoardList.do");

		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());

		List<QnABoardCommand> list = null;
		if (count > 0) {
			list = qnABoardService.getQnAList(map);
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("qnaBoardList");
		mav.addObject("count", count);
		mav.addObject("list", list);
		mav.addObject("pagingHtml", page.getPagingHtml());
		
		mav.addObject("m_id", id);
		return mav;
	}
}
