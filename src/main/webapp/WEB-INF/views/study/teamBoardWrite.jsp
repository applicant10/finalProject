<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link href="${pageContext.request.contextPath}/resources/plugins/summernote/summernote.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/summernote/summernote.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/summernote/lang/summernote-ko-KR.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/study/team.board.write.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/study/limit.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/study/study.css" rel="stylesheet">
    <!-- 게시판 글쓰기 -->
    <div class="container">
		<h3>팀 게시판 글쓰기</h3>
		<form:form commandName="command" action="teamBoardWrite.do" id="teamBoardWrite_form" enctype="multipart/form-data">
			<form:hidden path="m_nick"/>
			<form:hidden path="g_num"/>
			<form:errors element="div" cssClass="error-color"/>
			
					<br><label for="tb_title">제목</label>
					<form:input path="tb_title" class="form-control" onkeyup="chkword(this,40)"/>
					<form:errors path="tb_title" cssClass="error-color"/><br>
				
					<label for="tb_content">내용</label>
					<form:textarea path="tb_content"  cssClass="summernote"/>
					<form:errors path="tb_content" cssClass="error-color"/>
				
					<label for="upload">첨부파일</label>
					<input type="file" class="btn btn-default" id="upload" name="upload"/><br>
				
			<div class="button">
				<input type="submit" value="글쓰기" class="btn btn-default">
				<input type="button" value="목록" class="btn btn-default" onclick="location.href='teamBoard.do?g_num=${param.g_num}'">
				<br>
			</div>
			<br>
		</form:form>
	</div>