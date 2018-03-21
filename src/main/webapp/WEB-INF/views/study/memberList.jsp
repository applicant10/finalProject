<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="${pageContext.request.contextPath}/resources/css/study/study.css" rel="stylesheet">

      <!-- 게시판 시작 -->
      <div class="container">
      	<div class="memberList">
		<h3>지원 현황</h3><br>
			<table class="table">
				<tr style="background-color:#474747;color:white;">
					<th>닉네임</th>
					<th>가입일</th>
					<th>추방</th>
				</tr>
				<c:forEach var="memberList" items="${memberList}">
				<tr>
					<td>${memberList.m_nick}</td>
					<td>${memberList.g_date}</td>
					<td><a href="${pageContext.request.contextPath}/study/memberDelete.do?g_num=${g_num}&m_nick=${memberList.m_nick}&g_name=${g_name}">추방</a></td>
				</tr>
				</c:forEach>
			</table>
			<div class="text-center">${pagingHtml}</div>
		<br>
		</div>
	</div>