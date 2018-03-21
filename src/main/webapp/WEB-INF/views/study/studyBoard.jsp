<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/study/study.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/study/study.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/lecture/movement.css" />
      <!-- 게시판 시작 -->
      <div class="container">
      <div class="studyBoard"><br><br>
			<form action="studyBoard.do" id="search_form" method="get">
				<div class="Search">
					<div style="text-align:right;" class="form-inline form-group xs-invisible">
						<select name="keyfield" style="width:100px;height:35spx;" class="form-control">
							<option value="t_title">제목</option>
							<option value="m_nick">작성자</option>
							<option value="t_content">내용</option>
							<option value="g_type">팀 유형</option>
						</select>
							<input type="text" name="keyword" id="keyword" style="width:220px;height:35px;" class="form-control">
							<input type="submit" value="검색" class="btn btn-default">
					</div>
				</div>
				</form>
				<form action="studyBoard.do" id="search_form2" method="get">
					<div class="xs-visible">
						<select name="keyfield" class="form-control"><br>
							<option value="t_title">제목</option>
							<option value="m_nick">작성자</option>
							<option value="t_content">내용</option>
							<option value="g_type">팀 유형</option>
						</select>
							<br><input type="text" name="keyword" id="keyword" class="form-control"><br>
							<input type="submit" value="검색" class="btn btn-default form-control"><br>
					</div>
				</form>
			
			<c:if test="${count == 0}">
			<div class="align-center">등록된 게시물이 없습니다.</div>
			</c:if>
			<c:if test="${count > 0}">
			<div class="table">
				<table class="table">
					<tr style="background-color:#474747;color:white;">
						<th class="xs-invisible">팀 유형</th>
						<th width="50%">제목</th>
						<th width="15%">작성자</th>
						<th class="xs-invisible">과목</th>
						<th class="xs-invisible">지역</th>
						<th class="xs-invisible">등록일</th>
					</tr>
					<c:forEach var="recruit" items="${list}">
					<tr>
						<td class="xs-invisible">${recruit.g_type}</td>
						<td><a href="${pageContext.request.contextPath}/study/studyDetail.do?t_num=${recruit.t_num}&g_num=${recruit.g_num}&m_nick=${userNick}">${recruit.t_title}</a></td>
						<td>${recruit.m_nick}</td>
						<td class="xs-invisible">${recruit.t_sub}</td>
						<td class="xs-invisible">${recruit.t_area}</td>
						<td class="xs-invisible">${recruit.t_date}</td>
					</tr>
					</c:forEach>
				</table>
			</div>
			<div class="text-center">
				${pagingHtml}
			</div>
			</c:if>	
		<br>
	</div>
	</div>

