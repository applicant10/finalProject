<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/lecture/movement.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/board.reply.js"/></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/confirmId.js"></script>

<div class="container">
	<h2 class="block-title">${board.b_title}</h2>
		<div class="panel panel-default" style="padding:0px 15px 0px 15px;">
			<div class="panel-heading" style="padding-bottom: 30px;">
				<div class="col-sm-2 xs-invisible">No.${board.b_num}</div>
				<div class="col-sm-4">작성자 : ${board.m_id}</div>
				<div class="col-sm-3">등록일 : ${board.b_date}</div>
				<div class="col-sm-3">조회수 : ${board.b_hit}</div>
			</div>
			<div class="panel-body">
				${board.b_content}
			</div>
		
			<div class="panel-footer text-right">
				<c:if test="${!empty userId && userId == board.m_id}">
					<input type="button" value="수정" class="btn btn-default" onclick="location.href='update.do?num=${board.b_num}'">
					<input type="button" value="삭제" class="btn btn-default" onclick="location.href='delete.do?num=${board.b_num}'">
				</c:if>
				<input type="button" value="목록" class="btn btn-default" onclick="location.href='boardList.do'">
			</div>
		</div>
		<br>
		<div id="reply_div">
			<span class="reply-title">댓글 달기</span>
			<form id="re_form">
				<input type="hidden" name="b_num" value="${board.b_num}" id="b_num">
				<input type="hidden" name="m_id" value="${userId}" id="userId">
				<textarea rows="3" cols="50" name="br_content" id="br_content" class="form-control"
				<c:if test="${empty userId}">disabled="disabled"</c:if>
				><c:if test="${empty userId}">로그인해야 작성할 수 있습니다.</c:if></textarea>
			<c:if test="${!empty userId}">
			<div id="br_first">
				<span class="letter-count">300/300</span>
			</div>
			<div id="br_second" class="align-right">
				<input type="submit" value="전송" class="btn btn-default pull-right">
			</div>
			</c:if>	
			</form>
		</div>
		<!-- 목록 출력 -->
		<br>
		<br>
		<div class="card-body" id="output">
		<div class="paging-button" style="display:none;">
			<input type="button" value="다음글 보기">
		</div>
		<div id="loading" style="display:none;">
		  <img src="${pageContext.request.contextPath}/resources/images/ajax-loader.gif">
	    </div>
	   </div> 
</div>










