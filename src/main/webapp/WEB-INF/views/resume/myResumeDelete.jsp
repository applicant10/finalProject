<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/resume/resumeDetail.js"></script>
<h1>잠깐만요!</h1>
<div>
<div>지금 이력서를 지우려고 하시는 건가요?<br> 다시한번 생각해 보는건 어떠세요??</div>
<p>
	지우기 위해선 비밀번호를 입력해 주세요
</p>
<div>
<form action="myResumeDelete.do" method="post">
	<input type="password" id="password" name="password" placeholder="회원님의 비밀번호를 입력해 주세요.">
	<input type="submit" id="deleteResume" value="삭제">
</form>
</div>
</div>