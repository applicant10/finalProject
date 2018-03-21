<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/study/study.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/study/limit.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/study/study.css" rel="stylesheet">

    <!-- 프로젝트 팀 개설 -->
    <div class="container" class="form-group">
    	<div class="establish"><br>
		<form:form commandName="command" action="studyEstablish.do" id="studyEstablish_form" enctype="multipart/form-data">
			<form:hidden path="m_nick"/>
			<form:errors element="div" cssClass="error-color"/>
				
				<label for="g_name">팀 이름</label><br>
				<form:input path="g_name" class="form-control" onkeyup="chkword(this,20)"/>
				<form:errors path="g_name" cssClass="error-color"/><br>
				
				<label for="g_type">팀 유형</label><br>
				<input type=radio name="g_type" value="Study" checked/>스터디 그룹
				<input type=radio name="g_type" value="Project"/>프로젝트 팀<br>
				
			<div class="align-center" style="text-align:center;">
				<input type="submit" value="그룹 개설" class="btn btn-default">
				<input type="button" value="홈으로" class="btn btn-default" onclick="location.href='main.do'">
			</div>
			<br>
		</form:form> 
		</div>  
	</div>
	<br>