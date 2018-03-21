<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="${pageContext.request.contextPath}/resources/css/study/study.css" rel="stylesheet">
      <!-- 게시판 시작 -->
      <div class="container">
      	<div class="myGroup">
			<c:if test="${count == 0}">
				<tr><br><br>
					<th><h3>내가 가입한 그룹</h3></th>
				</tr>
			<div class="center">가입한 그룹이 없습니다.</div>
			</c:if>
			<c:if test="${count > 0}">
			<table class="table">
				<tr style="background-color:#474747;color:white;"><br><br>
					<th><h4>내가 가입한 그룹</h4></th>
				</tr>
				<c:forEach var="team" items="${list}">
				<tr>
					<td><a href="${pageContext.request.contextPath}/study/teamBoard.do?g_num=${team.g_num}">${team.g_name}</a></td>
				</tr>
				</c:forEach>
			</table>
			</c:if>
		</div>
		<div class="text-center">${pagingHtml}</div>
	</div>
