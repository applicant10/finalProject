<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/lecture/movement.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/confirmId.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/board.js"/></script>
<div class="container">
	<div class="text-right">
	<form action="boardList.do" id="search_form" class="form-inline center-block" method="get">
		<select name="keyfield" class="form-control">
			<option value="b_title">제목</option>
			<option value="b_nick">작성자</option>
			<option value="b_content">내용</option>
		</select>

		<input type="text" class="form-control" name="keyword" id="keyword">

		<input type="submit" class="btn btn-default form-control" value="찾기">
	</form>
	</div><br>
	<c:if test="${count == 0}">
	<div>등록된 게시물이 없습니다.</div>
	</c:if>
	<c:if test="${count > 0}">
	<table class="table table-hover">
		<tr>
			<th class="xs-invisible">번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th class="xs-invisible">조회수</th>
			<th class="xs-invisible">등록날짜</th>
		</tr>
		<c:forEach var="article" items="${list}">
		<tr onclick="location.href='detail.do?num=${article.b_num}'">
			<td class="xs-invisible">${article.b_num}</td>
			<td>${article.b_title}</td>
			<td>${article.b_nick}</td>
			<td class="xs-invisible">${article.b_hit}</td>
			<td class="xs-invisible">${article.b_date}</td>
		</tr>
		</c:forEach>
	</table>
	<div>
		<c:if test="${!empty userId}">
		<input type="button" value="글쓰기" class="btn btn-default pull-right" onclick="location.href='write.do'">
		</c:if>
	</div>
	<div class="text-center">${pagingHtml}</div>
	</c:if>
</div>