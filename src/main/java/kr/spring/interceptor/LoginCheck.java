package kr.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginCheck extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
		//�α��� �ߴ��� ���� üũ
		HttpSession session = req.getSession();
		
		//�α��� X
		if(session.getAttribute("userId") == null) {
			res.sendRedirect(req.getContextPath()+"/user/loginForm.do");
			return false;
		}
		//�α��� O
		return true;
	}
}
