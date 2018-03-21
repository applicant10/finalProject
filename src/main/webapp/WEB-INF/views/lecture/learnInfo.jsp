<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/lecture/movement.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lecture/lectureSessionAjax.js"></script>
<div class="container">
	<div class="col-xs-12 col-md-12 panel" id="learnInfoTitle" style="height:80px;">
		<b>${lecture.l_title}</b> 작성자 : ${writer.m_nick}
	</div>
	<!-- 오른쪽 수강정보 패널 -->
	<div class="col-xs-12 col-md-3 pull-right panel panel-default" style="margin-top: 15px;">
		<p class="text-center"><b>${member.m_nick}님의  수강 정보</b></p>
		
		<div class="col-md-12">시작일 : ${lnCommand.sDate}</div>
		<c:if test="${(comCount / lcCount) * 100 == 100}">
			<div class="col-md-12">완료일 : ${lnCommand.eDate}</div>
		</c:if>
		<c:if test="${(comCount / lcCount) * 100 < 100}">
			<div class="col-md-12">학습 ${learnday}일차</div>
		</c:if>
		<div class="col-xs-12">
			학습 달성도&nbsp;&nbsp;
			<c:if test="${(comCount / lcCount) * 100 == 100}">
				<fmt:formatNumber value="${(comCount / lcCount) * 100}"/>%
			</c:if>
			<c:if test="${(comCount / lcCount) * 100 < 100}">
				<fmt:formatNumber value="${(comCount / lcCount) * 100}" pattern=".00"/>%
			</c:if>
			<div class="progress course_progress" style="background-color: #e6e6e6; height: 10px;">
				<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="${(comCount / lcCount) * 100}" aria-valuemin="0" aria-valuemax="100" style="width: ${(comCount / lcCount) * 100}%;"></div>
			</div>
		</div>
	</div>
	<!-- 강좌 소개와 강의 리스트 -->
	<div class="col-xs-12 col-md-9" style="margin-top: 15px;">
		${lecture.l_title} 총 ${lcCount}강(<c:if test="${lecture.l_redate != null}">최근 수정일 : ${lecture.l_redate}</c:if><c:if test="${lecture.l_redate == null}">개설일 : ${lecture.l_date}</c:if>)
		<p>
			${lecture.l_shortcon}
		</p>
		<c:if test="${lcCount == 0}">
				<p>등록된 강좌 내용이 없습니다.</p>
		</c:if>
		<!-- 강의 리스트 -->
		<c:if test="${lcCount > 0}">
			<table class="table">
				<thead>
					<tr>
						<th>강의 제목</th>
						<th class="xs-invisible">작성일 <span class="small">(최근수정)</span></th>
						<th>수강 여부</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${lcList}">
						<c:if test="${item.l_m_num == 0}">
							<tr onclick="location.href='${pageContext.request.contextPath}/lecture/addLearnStudent.do?l_num=${item.l_num}&lc_num=${item.lc_num}'">
								<td>${item.lc_title}</td>
								
								<c:if test="${item.lc_redate == null}">
									<td class="xs-invisible">${item.lc_date}</td>
								</c:if>
								<c:if test="${item.lc_redate != null}">
									<td class="xs-invisible">${item.lc_date} (${item.lc_redate})</td>
								</c:if>
								
								<td><span style="color:gray;">미수강</span></td>
							</tr>
						</c:if>
						<c:if test="${item.l_m_num > 0}">
							<tr onclick="location.href='${pageContext.request.contextPath}/lecture/learnStudent.do?l_num=${item.l_num}&l_m_num=${item.l_m_num}&lc_num=${item.lc_num}'">
								<td>${item.lc_title}</td>
								
								<c:if test="${item.lc_redate == null}">
									<td class="xs-invisible">${item.lc_date}</td>
								</c:if>
								<c:if test="${item.lc_redate != null}">
									<td class="xs-invisible">${item.lc_date} (${item.lc_redate})</td>
								</c:if>
								
								<c:if test="${item.comdate != null}">
									<td><span style="color:green;">수강  (${item.comdate})</span></td>
								</c:if>
								<c:if test="${item.comdate == null}">
									<td><span style="color:black;">수강중</span></td>
								</c:if>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
			<div class="panel" id="lecture_reply"></div>
		</c:if>
	</div>
</div>