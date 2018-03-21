package kr.spring.qnaboard.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.qnaboard.domain.QnABoardCommand;
import kr.spring.qnaboard.service.QnABoardService;

@Controller
public class QnAUpdataController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private QnABoardService qnABoardService;

	@RequestMapping(value="/qna/qnaBoardUpdateForm.do")
	public ModelAndView form(@RequestParam("num")int num, Model model) {
		
		QnABoardCommand qnaBoardCommand = qnABoardService.getQnADetail(num);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("qnaBoardUpdateForm");
		mav.addObject("command",qnaBoardCommand);
		
		return mav;
	}
	
	@RequestMapping(value="/qna/qnaBoardUpdate.do")
	public String submit(@ModelAttribute("command")
						 @Valid QnABoardCommand qnABoardCommand,
						 BindingResult result,
						 HttpServletRequest request) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<QnABoardCommand>> : " + qnABoardCommand);
		}
		
		QnABoardCommand board = qnABoardService.getQnADetail(qnABoardCommand.getQ_num());
		
		if(result.hasErrors()) {
			
			return "qnaBoardUpdateForm";
		}
		
		//ip셋팅
		qnABoardCommand.setQ_ip(request.getRemoteAddr());
		
		//글수정
		qnABoardService.updateQnA(qnABoardCommand);
		
		return "redirect:/qna/qnaBoardList.do";
	}
	//답변 메서드
	@RequestMapping(value="/qna/qnaBoardAnswerUpdate.do")
	public String answer(@ModelAttribute("command")
						 @Valid QnABoardCommand qnABoardCommand,
						 BindingResult result,
						 HttpServletRequest request) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<QnABoardCommand>> : " + qnABoardCommand);
		}
		
		
		if(result.hasErrors()) {
			
			return "redirect:/qna/qnaBoardList.do";
		}
		
		
		//글수정
		qnABoardService.updateAnswerQnA(qnABoardCommand);
		
		return "redirect:/qna/qnaBoardList.do";
	}
}
