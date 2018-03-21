<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="${pageContext.request.contextPath}/resources/css/study/study.css" rel="stylesheet">
<!-- 게시판 시작 -->
<div class="container">
	<div class="center">
	<h2>가입 신청서</h2>
	</div>
	<div class="appliDetail">
		신청자 : ${appli.m_nick}
		신청날짜 : ${appli.a_date}<br>
		<br>
	</div>
	<br>
	
	<p class="a_content">
		자기소개 : ${appli.a_content}<br>
	</p>
	<br>
	<div class="button">
	<input type="button" class="btn btn-default" value="수락" onclick="location.href='appliAccept.do?g_num=${appli.g_num}&m_nick=${appli.m_nick}&a_num=${appli.a_num}&g_name=${param.g_name}'">
	<input type="button" class="btn btn-default" value="거절" onclick="location.href='appliDelete.do?a_num=${appli.a_num}&g_num=${appli.g_num}&g_name=${param.g_name}'">
	</div>
	<br>
</div>

