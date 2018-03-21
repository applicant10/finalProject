package kr.spring.team.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.team.domain.TeamBoardCommand;
import kr.spring.team.service.TeamBoardService;
import kr.spring.util.StringUtil;

@Controller
public class TeamBoardDetailController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private TeamBoardService teamBoardService;
	
	@RequestMapping("/study/teamBoardDetail.do")
	public ModelAndView process(HttpSession session,
			@RequestParam("tb_num")int num
			) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<num>> : " + num);
		}
		
		TeamBoardCommand board = teamBoardService.select(num);

		board.setTb_title(StringUtil.useBrNoHtml(board.getTb_title()));
		
		return new ModelAndView("teamBoardDetail","board",board);
	}
	//파일 다운로드(이미지 포함)
	@RequestMapping("/study/file.do")
	public ModelAndView download(@RequestParam("tb_num")int num) {
		TeamBoardCommand board = teamBoardService.select(num);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("tdownloadView");
		mav.addObject("downloadFile", board.getUploadfile());
		mav.addObject("filename",board.getFilename());
		return mav;
	}
}
