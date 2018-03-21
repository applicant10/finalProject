package kr.spring.qnaboard.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import kr.spring.qnaboard.service.QnABoardService;

@Controller
public class QnADeleteController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private QnABoardService qnaboardService;
	
	@RequestMapping("/qna/qnaBoardDelete.do")
	public String submit(@RequestParam("num") int num, HttpSession session) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<num>> :" + num );
		}
		
		//±€ªË¡¶ 
		qnaboardService.deleteQnA(num);
		
		return "redirect:/qna/qnaBoardList.do";
	}

}
