<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login/login.css">
<div class="row">
	<div class="container">
		<div id="wrapAll" class="col-lg-10 col-md-12 col-sm-10 col-xs-11 col-lg-offset-1 col-md-offset-1 col-sm-offset-1 col-xs-offset-1">
			<h3>Log-In 페이지 입니다.</h3>                  
			<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12 col-sm-offset-1">
				<form:form commandName="command" action="login.do" id="loginForm">
					<form:errors element="div" cssClass="error-color"/>
						<ul>                                                     
						<li>            
							<label for="m_id">아이디</label>
							<form:input path="m_id" cssStyle="width:300px;"/>
							<form:errors path="m_id" cssClass="error-color"/>
						</li>                         
						<li>          
							<label for="m_pw">비밀번호</label>
							<form:password path="m_pw" cssStyle="width:300px;"/> <!-- input타입에서 password타입으로 바꿈 -->
							<form:errors path="m_pw" cssClass="error-color"/>
						</li>
						</ul>                   
						<div class="pull-right col-xs-offset-2">       
							<input type="submit" class="btn" value="전송">
							<input type="button" class="btn" value="홈으로" onclick="location.href='${pageContext.request.contextPath}/main/main.do'">
						</div>
				</form:form>          
			</div>
			<div id="btns" class="col-lg-5 col-md-5 col-sm-10 col-xs-12 col-sm-offset-1">
					<h4>아이디/비밀번호 찾기</h4>            
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-11 col-xs-offset-2">
						<a id="aBtn1" class="btn btn-default col-lg-offset-2 col-md-offset-2" href="${pageContext.request.contextPath}/user/findIdForm.do">아이디 찾기</a>
						<div class="help col-md-offset-1">아이디를 잊어 버리셨나요?</div>
					</div>                          
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-11 col-xs-offset-2">
						<a id="aBtn2" class="btn btn-default col-lg-offset-2 col-md-offset-2" href="${pageContext.request.contextPath}/user/findPasswdForm.do">비밀번호 찾기</a>
						<div class="help col-md-offset-1">비밀번호를 잊어 버리셨나요?</div>
				</div>                         
			</div>
		</div>            
	</div>
</div>