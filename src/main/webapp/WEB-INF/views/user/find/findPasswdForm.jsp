<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/find/find.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/find/findPass.js"></script>
<div class="row">
	<div class="col-lg-5 col-md-5 col-sm-10 col-xs-9 col-lg-offset-3 col-md-offset-2 col-sm-offset-1 col-xs-offset-1">
		<h3 id="bod">패스워드 찾기</h3>
		<div class="sub">*아래 항목을 모두 입력해야 메일이 발송 됩니다.</div>
	</div>          
	<form:form commandName="memberCommand" action="findPasswd.do" method="post" id="passSubmit">
		<div class="col-lg-9 col-md-10 col-sm-11 col-xs-9 col-lg-offset-3 col-md-offset-2 col-sm-offset-1 col-xs-offset-1">
			<label class="pas" for="m_id">가입시 아이디를 입력해 주세요.</label>
			<input type="email" id="m_id" class="col-sm-offset-2" name="m_id"><span id="id" class="alert"> *필수 항목 입니다.</span><br>
			<label class="pas" for="m_nick">가입시 닉네임을 입력해 주세요.</label>
			<input type="text" id="m_nick" class="col-sm-offset-2" name="m_nick"><span id="nick" class="alert"> *필수 항목 입니다.</span><br>
			<label class="pas" for="md_name">가입시 이름을 입력해 주세요.</label>
			<input type="text" id="md_name" class="col-sm-offset-2" name="md_name"><span id="name" class="alert"> *필수 항목 입니다.</span>            
		</div>
		<div class="col-lg-3 col-md-3 col-sm-8 col-xs-12 col-lg-offset-5 col-md-offset-4 col-sm-offset-2 col-xs-offset-1">
			<div class="col-lg-4 col-md-6 col-sm-4 col-xs-2 col-xs-offset-2">
				<input type="button" class="btn passSearch pull-right" value="홈으로" onclick="location.href='${pageContext.request.contextPath}/main/main.do'">
			</div>                                         
			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-2">
				<input type="submit" class="btn passSearch pull-right" value="찾기">
			</div>
		</div>                           
	</form:form>                            
</div>                                 