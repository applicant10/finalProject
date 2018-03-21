package kr.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginCheck extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
		//로그인 했는지 여부 체크
		HttpSession session = req.getSession();
		
		//로그인 X
		if(session.getAttribute("userId") == null) {
			res.sendRedirect(req.getContextPath()+"/user/loginForm.do");
			return false;
		}
		//로그인 O
		return true;
	}
}
