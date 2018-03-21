<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/study/study.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/study/study.css" rel="stylesheet">
	<!-- 모집글에 신청서 보내기 -->
	<div class="container" >
		<div class="apply">
		<h3>팀 가입 신청서</h3>
		<form:form commandName="command" action="teamAppli.do" id="teamAppli_form" enctype="multipart/form-data">
			<form:hidden path="m_nick"/>
			<form:hidden path="g_num"/>
			<div class="a_content">
				<div class="a_cont">
				<label for="a_content">간단한 자기소개,포부를 적어주세요!</label><br>
				</div>
				<form:textarea path="a_content" class="form-control"/>
				<form:errors path="a_content" cssClass="error-color"/>
			</div>
			<br>
			<div class="button">
				<input type="submit" class="btn btn-default" value="지원">
				<input type="button" class="btn btn-default" value="취소" onclick="location.href='myGroup.do'">
			</div>
			<br>
		</form:form>
		</div>
	</div>