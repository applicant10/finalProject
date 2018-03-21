package kr.spring.qnaboard.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.qnaboard.domain.QnABoardCommand;
import kr.spring.qnaboard.service.QnABoardService;

@Controller
public class QnADetailController {
	private Logger log = Logger.getLogger(this.getClass());

	@Resource
	private QnABoardService qnABoardService;

	@RequestMapping("/qna/qnaBoardDetail.do")
	public ModelAndView process(@RequestParam(value = "num", defaultValue = "") int num) 
	{

		//updateq_hit ¿¹Á¤
		qnABoardService.updateHitQnA(num);
		
		QnABoardCommand detail = qnABoardService.getQnADetail(num);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("qnaBoardDetail");
		mav.addObject("detail", detail);
		return mav;
	}
}
