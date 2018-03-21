package kr.spring.lecture.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.lecture.domain.LectureCommand;
import kr.spring.lecture.service.LectureService;
import kr.spring.member.domain.MemberCommand;
import kr.spring.member.service.MemberService;
import kr.spring.record.service.RecordService;
import kr.spring.subject.domain.SubjectCommand;
import kr.spring.subject.service.SubjectService;

@Controller
public class MyLectureListController {
	@Resource
	private MemberService userLoginService;

	@Resource
	private LectureService lectureService;

	@Resource
	private SubjectService subjectService;
	
	@Resource
	private RecordService recordservice;

	@ModelAttribute("lecture")
	public LectureCommand initLecture() {
		return new LectureCommand();
	}

	@RequestMapping(value="/lecture/makeLectureIntro.do", method=RequestMethod.GET)
	public String introPage(HttpSession session, Model model) {
		String userId = (String)session.getAttribute("userId");
		int count = lectureService.countLectureUseId(userId);
		if(count < 1) {
			return "makeLectureIntro";
		}else {
			MemberCommand user = userLoginService.selectMember(userId);
			List<LectureCommand> list = lectureService.selectLectureUseId_self(userId);
			int lectureCount = lectureService.countLectureUseId(userId);
			model.addAttribute("user", user);
			model.addAttribute("list", list);
			model.addAttribute("lectureCount", lectureCount);
			return "myLectureList";
		}
	}

	@RequestMapping("/lecture/myLectureList.do")
	public String myLectureList(HttpSession session, Model model) {
		String userId = (String)session.getAttribute("userId");
		MemberCommand user = userLoginService.selectMember(userId);
		List<LectureCommand> list = lectureService.selectLectureUseId_self(userId);
		int lectureCount = lectureService.countLectureUseId(userId);
		model.addAttribute("user", user);
		model.addAttribute("list", list);
		model.addAttribute("lectureCount", lectureCount);
		return "myLectureList";
	}

	@RequestMapping(value="/lecture/insertLecture.do", method=RequestMethod.GET)
	public String insertLectureForm(Model model) {

		List<SubjectCommand> subjectList = subjectService.selectLv1();

		System.out.println("subject select List1 size : " + subjectList.size());

		model.addAttribute("lv1List", subjectList);
		model.addAttribute("lv1Size", subjectList.size());
		return "insertLectureForm";
	}

	@RequestMapping(value="/lecture/insertLecture.do", method=RequestMethod.POST)
	public String insertLecture(@ModelAttribute("lecture")@Valid LectureCommand lecture, BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
			return "redirect:/lecture/insertLecture.do";
		}
		
		lecture.setL_hit(0);
		lecture.setL_open("close");
		lecture.setL_pay(0);
		lecture.setL_donation("none");
		lecture.setL_adv("none");
		lectureService.insertLecture(lecture);
		
		return "redirect:/lecture/myLectureList.do";
	}

	@RequestMapping(value="/lecture/lectureUpdate.do", method=RequestMethod.GET)
	public String modifyLectureForm(@RequestParam("l_num") int l_num, Model model) {

		LectureCommand lecture = lectureService.selectLecture(l_num);
		SubjectCommand subject = subjectService.selectOneUseSnum(lecture.getS_num());
		model.addAttribute("lecture", lecture);
		model.addAttribute("subject", subject);

		return "lectureUpdateForm";
	}
	//강좌 업데이트
	@RequestMapping(value="/lecture/lectureUpdate.do", method=RequestMethod.POST)
	public String modifyLecture(@ModelAttribute("lecture")@Valid LectureCommand lecture, BindingResult result) {

		if(result.hasErrors()) {
			return "lectureUpdateForm";
		}

		lectureService.modifyLecture(lecture);

		return "redirect:/lecture/makeLectureIntro.do";
	}
}