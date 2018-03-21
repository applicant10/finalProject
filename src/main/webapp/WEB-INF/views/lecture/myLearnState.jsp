<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/lecture/movement.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lecture/lectureSessionAjax.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lecture/myLearnState.js"></script>
<div class="container">
	<!-- 회원의 정보나 공지 등을 위한 공간 12 -->
	<div class="col-xs-12 col-md-12 panel" id="learnInfoTitle" style="height:80px;">
		<b>${m_nick}</b><br>${m_id}
	</div>
	<!-- 오른쪽 패널 -->
	<div class="col-xs-12 col-md-6 pull-right panel panel-default" style="margin-top: 15px;">
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
	</div>
	<!-- 왼 쪽 패널 -->
	<div class="col-xs-12 col-md-6">
		<h3 style="background-color: silver; padding-top:10px; padding-bottom:10px;">내 학습 진행률</h3>
		<c:forEach var="item" items="${totalEnrollList}">
			<!-- open -->
			<c:if test="${item.l_open == 'open'}">
			<!-- 각 강좌별 정보 시작 -->
			<div class="btn btn-default btn-block" id="lenum_${item.l_m_num}" onclick="location.href='${pageContext.request.contextPath}/lecture/learnInfo.do?l_num=${item.l_num}'" style="margin-bottom: 10px;">
				<div class="row">
					<div class="col-md-8">${item.l_title} (
					<!-- 퍼센트 표기 -->
					<fmt:formatNumber value="${(item.lconComdateCount / item.lconCount) * 100}"/>%)
				</div>
					<div class="col-md-4">${item.sDate} 시작</div>
				</div>
				<!-- 달성률 게이지 부분 -->
				<div class="progress course_progress" id="lenumProgress_${item.l_m_num}" style="background-color: #e6e6e6; height: 10px;">
					<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="${(item.lconComdateCount / item.lconCount) * 100}" aria-valuemin="0" aria-valuemax="100" style="width: ${(item.lconComdateCount / item.lconCount) * 100}%;"></div>
				</div>
			</div>
			<!-- 각 강좌별 정보 끝 -->
			</c:if>
			<!-- close -->
			<c:if test="${item.l_open == 'close'}">
			<div style="background-color: silver;">
				<!-- 각 강좌별 정보 시작 -->
				<div class="btn btn-default btn-block disabled" id="lenum_${item.l_m_num}" style="margin-bottom: 10px;">
					<div class="row">
						<div class="col-md-8">${item.l_title} (
						<!-- 퍼센트 표기 -->
						<fmt:formatNumber value="${(item.lconComdateCount / item.lconCount) * 100}"/>%)
					</div>
						<div class="col-md-4">${item.sDate} 시작</div>
					</div>
					<!-- 달성률 게이지 부분 -->
					<div class="progress course_progress" id="lenumProgress_${item.l_m_num}" style="background-color: #e6e6e6; height: 10px;">
						<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="${(item.lconComdateCount / item.lconCount) * 100}" aria-valuemin="0" aria-valuemax="100" style="width: ${(item.lconComdateCount / item.lconCount) * 100}%;"></div>
					</div>
				</div>
				<!-- 각 강좌별 정보 끝 -->
			</div>
			</c:if>
		</c:forEach>
	</div>
</div>