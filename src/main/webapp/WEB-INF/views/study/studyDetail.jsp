<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/study/study.reply.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/study/study.css" rel="stylesheet">
  
      
<!-- 스터디 모집 글 -->
<div class="container" class="form-group">
	<div class="title">	
		<h3>${study.t_title}</h3><br>
		<div class="Writer">
			글쓴이 : ${study.m_nick}&nbsp;&nbsp;&nbsp;
			지역 : ${study.t_area}&nbsp;&nbsp;&nbsp;
			과목 : ${study.t_sub}&nbsp;&nbsp;&nbsp;
			작성일 : ${study.t_date}
			<br><br>
		</div>
	</div>
	<p class="content">
		<br>${study.t_content}
	</p>
	<div class="align-right" style="text-align:right;">
		<c:if test="${!empty userNick && userNick == study.m_nick}">
		<input type="button" value="수정" class="btn btn-default" onclick="location.href='studyUpdate.do?t_num=${study.t_num}'">
		<input type="button" value="마감" class="btn btn-default" onclick="location.href='studyDelete.do?t_num=${study.t_num}'">
		</c:if>
		<c:if test="${!empty userNick && userNick != study.m_nick}">
			<c:if test="${count == 0}">
				<input type="button" value="지원 " class="btn btn-default" onclick="location.href='teamAppli.do?g_num=${study.g_num}'">
			</c:if>
				<input type="button" value="목록" class="btn btn-default" onclick="location.href='studyBoard.do'">
		</c:if>
	</div>
	<div id="reply_div">
		<span class="reply-title">댓글 달기</span>
			<form id="re_tform">
			<input type="hidden" name="t_num" value="${study.t_num}" id="t_num">
			<input type="hidden" name="m_nick" value="${userNick}" id="m_nick">
			<textarea rows="3" cols="50" class="form-control" name="re_tcontent" id="re_tcontent" class="rep-content" 
			<c:if test="${empty userNick}">disabled="disabled"</c:if>
			><c:if test="${empty userNick}">로그인해야 작성할 수 있습니다.</c:if></textarea>
			<c:if test="${!empty userNick}">
			<div id="re_second" style="text-align:right;"><br>
				<input type="submit" class="btn btn-default" value="전송">
			</div>
			</c:if>
		</form>
		<!-- 댓글 목록 출력 -->
		<div id="output" class="output"></div>
		<div class="paging-button" style="display:none;">
			<input type="button" value="다음글 보기">
		</div>
		<div id="loading" style="display:none;">
			<img src="${pageContext.request.contextPath}/resources/images/ajax-loader.gif">
		</div>
	</div>
</div> 
      
      
      
      