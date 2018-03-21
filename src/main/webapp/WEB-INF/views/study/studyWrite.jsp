<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link href="${pageContext.request.contextPath}/resources/plugins/summernote/summernote.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/summernote/summernote.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/summernote/lang/summernote-ko-KR.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/study/team.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/study/limit.js"></script>

<link href="${pageContext.request.contextPath}/resources/css/study/study.css" rel="stylesheet">

    <!-- 게시판 글쓰기 -->
    <div class="container">
		<h3>스터디 모집 글쓰기</h3>
		<form:form commandName="command" action="studyWrite.do" id="studyWrite_form" enctype="multipart/form-data">
			<form:hidden path="m_nick"/>
			<form:hidden path="g_num"/>
			<form:errors element="div" cssClass="error-color"/>
			
				<label for="t_title">제목 </label>	
				<form:input path="t_title" class="form-control" onkeyup="chkword(this,33)"/>
				<form:errors path="t_title" cssClass="error-color"/><br>
				
				<label for="t_area">지역 </label>
				<form:input path="t_area" class="form-control" onkeyup="chkword(this,13)"/>
				<form:errors path="t_area" cssClass="error-color"/><br>
				
				<label for="t_sub">과목 </label>
				<select name="t_sub">
    				<option value="App">애플리케이션 개발</option>
    				<option value="Wep">웹 개발</option>
    				<option value="Android">안드로이드</option>
    				<option value="IOS">IOS</option>
				</select><br>
				<br><label for="t_content">내용 </label>
				<form:textarea path="t_content" cssClass="summernote"/>
				<form:errors path="t_content" cssClass="error-color"/>
				
			<div class="button">
				<input type="submit" class="btn btn-default" value="글쓰기">
				<input type="button" class="btn btn-default" value="목록" onclick="location.href='studyBoard.do'">
			</div>
			<br>
		</form:form>
	</div>