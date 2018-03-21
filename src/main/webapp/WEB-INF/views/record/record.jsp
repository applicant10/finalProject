<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="${pageContext.request.contextPath}/resources/css/study/study.css" rel="stylesheet">
<div class="container">
      	<div class="record">
			<c:if test="${count == 0}">
			<div class="center"><h2>기록이 없습니다.</h2></div>
			</c:if>
			<c:if test="${count > 0}">
			<table class="table">
				<tr style="background-color:#474747;color:white;"><br><br>
					<th width="70%">기록</th>
					<th>날짜</th>
				</tr>
				<c:forEach var="record" items="${list}">
				<tr>
					<td>${record.r_content}${record.record}</td>
					<td>${record.r_date}</td>
				</tr>
				</c:forEach>
			</table>
			</c:if>
		</div>
		<div class="text-center">${pagingHtml}</div>
	</div>  