package kr.spring.lecture.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.lecture.domain.L_contentCommand;
import kr.spring.lecture.service.L_contentService;
import kr.spring.lecture.service.Lc_memService;

@Controller
public class LearnStudentController {
	@Resource
	private L_contentService l_contentService;

	@Resource
	private Lc_memService lc_memService;

	@RequestMapping("/lecture/learnStudent.do")
	public String learnStudent(
			//수강테이블 기본키
			@RequestParam("l_m_num") int l_m_num,
			//강의컨텐츠 기본키
			@RequestParam("lc_num") int lc_num,
			//강의테이블 기본키
			@RequestParam("l_num") int l_num,
			HttpSession session, Model model) {

		//강의컨텐츠-회원 테이블 리스트
		List<L_contentCommand> lcList = l_contentService.selectLcJoinLcmUseLm(l_num, l_m_num);

		for(L_contentCommand comm : lcList) {
			System.out.println("l_m_num : " + comm.getL_m_num());
		}

		//선택한 강의페이지
		L_contentCommand lSibalcontent = l_contentService.selectLcJoinLcmOne(l_num, l_m_num, lc_num);

		if(lSibalcontent.getLc_content().contains("//www.youtube.com/embed/")) {


			int substring0 = lSibalcontent.getLc_content().indexOf("//www.youtube.com/embed/");
			int substring1 = "//www.youtube.com/embed/".length();
			int substring2 = lSibalcontent.getLc_content().indexOf("\"", substring0+substring1);

			String subStrings = lSibalcontent.getLc_content().substring(substring0+substring1, substring2);
//			System.out.println("subString0 : " + substring0);
//			System.out.println("subString1 : " + substring1);
//			System.out.println("subString2 : " + substring2);
			System.out.println("subStrings : " + subStrings);

			model.addAttribute("youtubeIdValue", subStrings);
		}
		model.addAttribute("lcList", lcList);
		model.addAttribute("lcontent", lSibalcontent);

		return "learnStudent";
	}
}