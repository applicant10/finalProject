<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/study/team.reply.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/study/study.css" rel="stylesheet">
	<!-- 글보기 시작 -->
	<div class="container">
		<c:if test="${empty userId}">
			<input type="button" value="로그인" onclick="location.href='${pageContext.request.contextPath}/user/loginForm.do'">
		</c:if>
		<c:if test="${!empty userId}">
			<h2 style="text-align:center;">${board.tb_title}</h2>
				<div style="text-align:right;">
				글쓴이 : ${board.m_nick}&nbsp;&nbsp;&nbsp;
				작성일: ${board.tb_date}&nbsp;&nbsp;&nbsp;
				<c:if test="${!empty board.filename}">
				첨부파일 : <a href="file.do?tb_num=${board.tb_num}">${board.filename}</a>
				</c:if>
				</div>
				<br>
			<br><p>
			${board.tb_content}
			</p>
		</c:if>
	<div class="align-right" style="text-align:right;">
		<c:if test="${!empty userNick && userNick == board.m_nick}">
		<input type="button" value="수정" class="btn btn-default" onclick="location.href='teamBoardUpdate.do?tb_num=${board.tb_num}&g_num=${board.g_num}'">
		<input type="button" value="삭제" class="btn btn-default" onclick="location.href='teamBoardDelete.do?tb_num=${board.tb_num}&g_num=${board.g_num}'">
		<input type="button" value="목록" class="btn btn-default" onclick="location.href='teamBoard.do?g_num=${board.g_num}'">
		</c:if>
		<c:if test="${!empty userNick && userNick != board.m_nick}">
		<input type="button" value="목록" class="btn btn-default" onclick="location.href='teamBoard.do?g_num=${board.g_num}'">
		</c:if>
		<br>
	</div>
	<div id="reply_div">
		<span class="reply-title">댓글 달기</span>
			<form id="re_gform">
			<input type="hidden" name="tb_num" value="${board.tb_num}" id="tb_num">
			<input type="hidden" name="m_nick" value="${userNick}" id="m_nick">
			<textarea rows="3" cols="50" class="form-control" name="re_gcontent" id="re_gcontent" class="rep-content"
			<c:if test="${empty userNick}">disabled="disabled"</c:if>
			><c:if test="${empty userNick}">로그인해야 작성할 수 있습니다.</c:if></textarea><br>
			<c:if test="${!empty userNick}">
			<div id="re_second" style="text-align:right;">
				<input type="submit" class="btn btn-default" value="작성">
			</div>
			<br>
			</c:if>
		</form>
		<!-- 댓글 목록 출력 -->
		<div id="output"></div>
		<div class="paging-button" style="display:none;">
			<input type="button" class="btn btn-default" value="더보기">
		</div>
		<div id="loading" style="display:none;">
			<img src="${pageContext.request.contextPath}/resources/images/ajax-loader.gif">
		</div>
	</div>
</div> 
      