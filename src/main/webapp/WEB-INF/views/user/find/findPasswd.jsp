<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/find/find.css">
<div class="row">
	<div class="col-lg-5 col-md-5 col-sm-10 col-xs-9 col-lg-offset-3 col-md-offset-2 col-sm-offset-1 col-xs-offset-1">
		<h3>조회 결과 발송</h3>
		<div class="sub">*임시 비밀번호가 메일로 전송되었습니다.</div>
	</div>
	<div class="col-lg-4 col-md-6 col-sm-5 col-xs-10 col-lg-offset-4 col-md-offset-3 col-sm-offset-4 col-xs-offset-1">
		<div>
			<div id="resultPassCont"><strong>&quot;메일이 발송 되었습니다.&quot;</strong></div>
		</div>         
		<div>
			<input type="button" id="resultPass2" class="btn pull-right" value="로그인" onclick="location.href='${pageContext.request.contextPath}/user/loginForm.do'">
			<input type="button" id="resultPass" class="btn pull-right" value="홈으로" onclick="location.href='${pageContext.request.contextPath}/main/main.do'">
		</div>
	</div>       
</div>                   