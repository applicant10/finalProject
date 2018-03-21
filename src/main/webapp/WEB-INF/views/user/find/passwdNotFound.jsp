<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/find/find.css">
<div class="row">
	<div class="col-lg-5 col-md-5 col-sm-10 col-xs-9 col-lg-offset-3 col-md-offset-2 col-sm-offset-1 col-xs-offset-1">
		<h3>검색하신 결과가 없네요...</h3>
		<div class="sub">*다시 시도 해보시는건 어떨까요??</div>
	</div>
	<div class="col-lg-5 col-md-5 col-sm-10 col-xs-9 col-lg-offset-5 col-md-offset-4 col-sm-offset-2 col-xs-offset-2">
		<div>
			검색하신 유저가 없습니다. <br>입력하신 값이 맞는지 다시 한번 확인해 주세요.
		</div>
		<div>
			<input type="button" id="resultPass2" class="btn" value="다시시도" onclick="location.href='${pageContext.request.contextPath}/user/findPasswdForm.do'">
			<input type="button" id="resultPass" class="btn" value="홈으로" onclick="location.href='${pageContext.request.contextPath}/main/main.do'">
		</div>
	</div>
</div>