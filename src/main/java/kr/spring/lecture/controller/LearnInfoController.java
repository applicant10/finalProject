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
		//l_num�� �̿��� �ش� ���� Ŀ�ǵ� ������
		LectureCommand lecture = lectureService.selectLecture(l_num);
		//�ۼ��� ����
		MemberCommand writer = memberService.selectMember(lecture.getM_id());
		//������ ��������
		Le_numCommand lnCommand = le_numService.selectLM(m_id, l_num);
		//������ ���� ��
		int lcCount = l_contentService.countLcUseLnum(l_num);
		//lc�� lc_mem ������ ����� lc Ŀ�ǵ忡 ��Ƽ� ����Ʈ
		List<L_contentCommand> lcList = l_contentService.selectLcJoinLcmUseLm(l_num, lnCommand.getL_m_num());
		
		//���� �Ϸ� ���� ��
		int comCount = lc_memService.selectCommLCMuseLn(lnCommand.getL_m_num());
		
		//��¥ ���
		Date today = new Date();
		Date sDate = lnCommand.getsDate();
		long diff = today.getTime() - sDate.getTime();
		int learnday = (int)diff / (24 * 60 * 60 * 1000) + 1;
		
		//ȸ��
		model.addAttribute("member", member);
		//�ۼ���
		model.addAttribute("writer", writer);
		//���� ����
		model.addAttribute("lecture", lecture);
		//�ش� ������ ���� ���� ���� ��
		model.addAttribute("lnCommand", lnCommand);
		//�ش� ������ ���� ��
		model.addAttribute("lcCount", lcCount);
		//�ش� ������ ���� ����Ʈ�� ������Ȳ
		model.addAttribute("lcList", lcList);
		//�ش� ���� ������û �� ���� ��¥
		model.addAttribute("learnday", learnday);
		//���� �Ϸ� ���� ��
		model.addAttribute("comCount", comCount);
		
		return "learnInfo";
	}
}