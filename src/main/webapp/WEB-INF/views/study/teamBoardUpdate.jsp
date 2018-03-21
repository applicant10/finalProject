<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="${pageContext.request.contextPath}/resources/plugins/summernote/summernote.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/summernote/summernote.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/summernote/lang/summernote-ko-KR.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/study/team.board.write.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/study/study.css" rel="stylesheet">
    <!-- 게시판 글쓰기 -->
    <div class="container">
		<h3>팀 게시판 글쓰기</h3><br>
		<form:form commandName="command" action="teamBoardUpdate.do" id="teamBoardUpdate_form" enctype="multipart/form-data">
			<form:hidden path="m_nick"/>
			<form:hidden path="tb_num"/>
			<form:hidden path="g_num"/>
			<form:errors element="div" cssClass="error-color"/>

					<label for="tb_title">제목</label>	
					<form:input path="tb_title" class="form-control"/>
					<form:errors path="tb_title" cssClass="error-color"/><br>
				
					<label for="tb_content">내용</label>
					<form:textarea path="tb_content" cssClass="summernote"/>
					<form:errors path="tb_content" cssClass="error-color"/>
				
					<label for="upload">첨부파일</label>
					<input type="file" id="upload" name="upload" class="btn btn-default"/>
					<c:if test="${!empty command.filename}">
					<br>
					<span>(${command.filename})파일이 등록되어 있습니다.
			
					다시 업로드하면 기존 파일은 삭제 됩니다.</span>
					</c:if>
				
			<div class="button">
				<input type="submit" value="수정하기" class="btn btn-default">
				<input type="button" value="목록" class="btn btn-default" onclick="location.href='teamBoard.do?g_num=${command.g_num}'">
			</div>
			<br><br>
		</form:form>
	</div>