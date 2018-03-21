package kr.spring.lecture.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.lecture.domain.L_contentCommand;
import kr.spring.lecture.domain.LectureCommand;
import kr.spring.lecture.service.L_contentService;
import kr.spring.lecture.service.LectureService;

@Controller
public class LContentManageController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private L_contentService l_contentService;
	@Resource
	private LectureService lectureService;

	@ModelAttribute("lcCommand")
	private L_contentCommand initCommand() {
		return new L_contentCommand();
	}

	@RequestMapping(value="/lecture/insertLcontent.do", method=RequestMethod.GET)
	public String insertLcontentForm(@RequestParam("l_num")int l_num, Model model) {
		model.addAttribute("l_num", l_num);
		return "insertLcontentForm";
	}

	@RequestMapping(value="/lecture/insertLcontent.do", method=RequestMethod.POST)
	public String insertLContent(@ModelAttribute("lcCommand")@Valid L_contentCommand lcCommand, BindingResult result, Model model, HttpSession session) {
		lcCommand.setLc_hit(0);
		if(result.hasErrors()) {
			return "insertLcontentForm";
		}
		if(log.isDebugEnabled()) {
			log.debug(">> l_num >> : " + lcCommand.getL_num());
		}
		
		l_contentService.insetL_content(lcCommand, lcCommand.getL_num());
		
		String userId = (String)session.getAttribute("userId");
		List<LectureCommand> list = lectureService.selectLectureUseId(userId);
		model.addAttribute("list", list);
		return "redirect:/lecture/myLectureList.do";
	}

	@RequestMapping(value="/lecture/lcontentUpdate.do", method=RequestMethod.GET)
	public String lcontentUpdateFrom(@RequestParam("lc_num") int lc_num, Model model) {
		L_contentCommand lcCommand = l_contentService.selectOne(lc_num);
		System.out.println(lcCommand.toString());
		
		model.addAttribute("lcCommand", lcCommand);

		return "lcontentUpdateForm";
	}

	@RequestMapping(value="/lecture/lcontentUpdate.do", method=RequestMethod.POST)
	public String lcontentUpdateSubmit(@ModelAttribute("lcCommand")@Valid L_contentCommand lcCommand, BindingResult result, Model model) {
		System.out.println("lcontentUpdateSubmit : lc_num!! "+lcCommand.getLc_num());
		if(result.hasErrors()) {
			model.addAttribute(lcCommand);
			return "lcontentUpdateForm";
		}
		System.out.println(lcCommand.toString());
		l_contentService.updateL_content(lcCommand);

		return "redirect:/lecture/myLectureList.do";
	}
	
	@RequestMapping("/lecture/lcontentDelete.do")
	public String lcontentDelete(@RequestParam("lc_num") int lc_num, Model model) {
		l_contentService.deleteL_content(lc_num);
		
		return "redirect:/lecture/myLectureList.do";
	}
}