package kr.spring.lecture.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.lecture.domain.L_contentCommand;
import kr.spring.lecture.domain.Le_numCommand;
import kr.spring.lecture.domain.LectureCommand;
import kr.spring.lecture.service.L_contentService;
import kr.spring.lecture.service.Lc_memService;
import kr.spring.lecture.service.Le_numService;
import kr.spring.lecture.service.LectureService;
import kr.spring.member.domain.MemberCommand;
import kr.spring.member.service.MemberService;

@Controller
public class LearnInfoController {
	@Resource
	private MemberService memberService;
	
	@Resource
	private L_contentService l_contentService;
	
	@Resource
	private LectureService lectureService;
	
	@Resource
	private Le_numService le_numService;
	
	@Resource
	private Lc_memService lc_memService;
	
	@RequestMapping("/lecture/learnInfo.do")
	public String learnInfo(@RequestParam("l_num") int l_num, HttpSession session, Model model) {
		String m_id = (String)session.getAttribute("userId");
		MemberCommand member = memberService.selectMember(m_id);
		//l_num을 이용해 해당 강의 커맨드 셀렉션
		LectureCommand lecture = lectureService.selectLecture(l_num);
		//작성자 정보
		MemberCommand writer = memberService.selectMember(lecture.getM_id());
		//유저의 수강정보
		Le_numCommand lnCommand = le_numService.selectLM(m_id, l_num);
		//강좌의 강의 수
		int lcCount = l_contentService.countLcUseLnum(l_num);
		//lc와 lc_mem 조인한 결과를 lc 커맨드에 담아서 리스트
		List<L_contentCommand> lcList = l_contentService.selectLcJoinLcmUseLm(l_num, lnCommand.getL_m_num());
		
		//수강 완료 강의 수
		int comCount = lc_memService.selectCommLCMuseLn(lnCommand.getL_m_num());
		
		//날짜 계산
		Date today = new Date();
		Date sDate = lnCommand.getsDate();
		long diff = today.getTime() - sDate.getTime();
		int learnday = (int)diff / (24 * 60 * 60 * 1000) + 1;
		
		//회원
		model.addAttribute("member", member);
		//작성자
		model.addAttribute("writer", writer);
		//강의 정보
		model.addAttribute("lecture", lecture);
		//해당 유저의 강의 수강 정보 등
		model.addAttribute("lnCommand", lnCommand);
		//해당 강좌의 강의 수
		model.addAttribute("lcCount", lcCount);
		//해당 강좌의 강의 리스트와 수강현황
		model.addAttribute("lcList", lcList);
		//해당 강좌 수강신청 후 지난 날짜
		model.addAttribute("learnday", learnday);
		//수강 완료 강의 수
		model.addAttribute("comCount", comCount);
		
		return "learnInfo";
	}
}