<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/user/user.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/resume/confirmId.js"></script>
<div class="row">
<div class="container">            
	<div class="col-lg-10 col-md-10 col-sm-11 col-xs-10 col-lg-offset-2 col-md-offset-2 col-sm-offset-1 col-xs-offset-1">
	<div id="wrapAll">
	<h3>회원 가입</h3>
	<!-- 	// 같은 경로에서 파일을 호출시에는 파일명만 호출해도 앞에 있는 주소는 그대로 나옴 -->
	<form:form commandName="command" action="registerForm.do" id="registerForm">
		<form:errors element="div" cssClass="error-color"/>
			<ul>
			<li>
			<div class="col-lg-2 col-md-2 col-sm-10 col-xs10">
				<label for="m_id">아이디</label>
			</div>            
			<div class="col-lg-10 col-md-10 col-sm-12 col-xs-12">
				<div class="col-lg-6 col-md-10 col-sm-10 col-xs-10">             
					<form:input path="m_id" cssStyle="width:240px;"/>
				</div>                                                                    
				<div class="col-lg-6 col-md-10 col-sm-10 col-xs-10">
					<input type="button" class="btn" id="confirmId" value="ID중복체크">
					<span id="message_id"></span>
					<img src="${pageContext.request.contextPath}/resources/images/ajax-loader.gif" id="loading" width="16" height="16" style="display:none;">
					<form:errors path="m_id" cssClass="error-color"/>
				</div>             
			</div>
			</li>
			<li>
				<br><br>
			</li>
			<li>              
			<div class="col-lg-2 col-md-2 col-sm-10 col-xs10">
				<label for="m_nick">닉네임</label>
			</div>
			<div class="col-lg-10 col-md-10 col-sm-12 col-xs-12">
				<div class="col-lg-8 col-md-10 col-sm-10 col-xs-10">               
				<form:input path="m_nick" cssStyle="width:240px;"/>
				<span id="message_nick"></span>
				</div>
				<form:errors path="m_nick" cssClass="error-color"/>
			</div>
			</li>
			<li>
				<br><br>
			</li>
			<li>
			<div class="col-lg-2 col-md-2 col-sm-10 col-xs10">
				<label for="m_pw">비밀번호</label>
			</div>
			<div class="col-lg-10 col-md-10 col-sm-12 col-xs-12">
				<div class="col-lg-6 col-md-10 col-sm-10 col-xs-10">
				<form:password path="m_pw" cssStyle="width:240px;"/>
				</div>
				<form:errors path="m_pw" cssClass="error-color"/>
			</div>
			</li>
			<li>
				<br><br>
			</li>
			<li>
			<div class="col-lg-2 col-md-2 col-sm-10 col-xs10">
				<label for="md_name">이름</label>
			</div>
			<div class="col-lg-10 col-md-10 col-sm-12 col-xs-12">
				<div class="col-lg-6 col-md-10 col-sm-10 col-xs-10">
				<form:input path="md_name" cssStyle="width:240px;"/>
			</div>
				<form:errors path="md_name" cssClass="error-color"/>
			</div>
			</li>
			<li>
				<br><br>
			</li>
			<li>
			<div class="col-lg-2 col-md-2 col-sm-10 col-xs10">
				<label for="md_phone">전화 번호</label>
			</div>
			<div class="col-lg-10 col-md-10 col-sm-12 col-xs-12">
				<div class="col-lg-6 col-md-10 col-sm-10 col-xs-10">
				<form:input path="md_phone" cssStyle="width:240px;"/>
			</div>
				<form:errors path="md_phone" cssClass="error-color"/>
			</div>
			</li>
			<li>
				<br><br>     
			</li>
			<li>            
		<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 pull-right">
			<input type="submit" class="btn" id="button1" value="전송">
			<input type="button" class="btn" id="button2" value="Home" onclick="location.href='${pageContext.request.contextPath}/main/main.do'">
		</div>
		</li>
		<li>
			<br><br>
		</li>
		</ul>
	</form:form>
	</div>
	</div>
</div>
</div>