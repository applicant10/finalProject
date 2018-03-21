package kr.spring.qnaboard.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.spring.qnaboard.domain.QnABoardCommand;
import kr.spring.qnaboard.service.QnABoardService;

@Controller
public class QnAWriteController {
	private Logger log = Logger.getLogger(this.getClass());

	@Resource
	private QnABoardService qnaBoardService;

	@RequestMapping(value = "/qna/qnaBoardWriteForm.do")
	public String form(HttpSession session, Model model) {
		
		Date date = new Date();
		SimpleDateFormat sfm = new SimpleDateFormat("yyyy-MM-dd");

		model.addAttribute("userId", (String) session.getAttribute("userId"));
		model.addAttribute("userNick", (String) session.getAttribute("userNick"));
		model.addAttribute("today", sfm.format(date));
		
		return "qnaBoardWriteForm";
	}

	@RequestMapping(value = "/qna/qnaBoardWrite.do")
	public String submit(@ModelAttribute("command") @Valid QnABoardCommand qnABoardCommand,
			BindingResult result, HttpServletRequest request) {
		
		// ip셋팅
		qnABoardCommand.setQ_ip(request.getRemoteAddr());

		if (log.isDebugEnabled()) {
			log.debug("<<qnABoardCommand>> : " + qnABoardCommand);
		}

		if (result.hasErrors()) {
			return "qnaBoardWriteForm";
		}

		// 글쓰기
		qnaBoardService.insertQnA(qnABoardCommand);

		return "redirect:/qna/qnaBoardList.do";
	}

}
