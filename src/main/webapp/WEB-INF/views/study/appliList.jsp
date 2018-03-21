<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="${pageContext.request.contextPath}/resources/css/study/study.css" rel="stylesheet">
      <!-- 게시판 시작 -->
      <div class="container">
      	<div class="appliList">
		<h3>지원 현황</h3><br>
			<c:if test="${count == 0}">
			<div class="center">가입신청이 없습니다.</div>
			</c:if>
			<c:if test="${count > 0}">
			<table class="table">
				<tr>
					<th>닉네임</th>
					<th>신청일</th>
				</tr>
				<c:forEach var="appliList" items="${list}">
				<tr>
					<td><a href="${pageContext.request.contextPath}/study/appliDetail.do?a_num=${appliList.a_num}&g_num=${g_num}&g_name=${g_name}">${appliList.m_nick}</a></td>
					<td>${appliList.a_date}</td>
				</tr>
				</c:forEach>
			</table>
			<div class="text-center">${pagingHtml}</div>
			</c:if>	
		<br>
		</div>
	</div>
