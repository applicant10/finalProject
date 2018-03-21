package kr.spring.lecture.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LectureSessionAjaxController {
	//���� ���� �Ⱓ ���� �α��� ������ ���� ��Ʈ�ѷ�
		@RequestMapping("/lecture/studySessionSend.do")
		@ResponseBody
		public void studySessionRes(HttpSession session) {
			String userId = (String)session.getAttribute("userId");
			System.out.println(userId + " is learning...");
		}
}