<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/lecture/movement.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/plugins/star-rating/jquery.rating.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lecture/lectureSessionAjax.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lecture/lectureView.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lecture/youtubeIframAutoScale.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lecture/lecture_reply.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/star-rating/jquery.rating.js"></script>
<style>
#lectureTitle {
	background-image:url("${pageContext.request.contextPath}/resources/images/lecture/titles.jpg");
}
</style>
<div class="container">
	<!-- 제목 패널 -->
	<div class="col-xs-12 col-md-12" id="lectureTitle">
		<input type="hidden" name="${lecture.l_num}" id="hiddenTitle" value="${lecture.l_num}">
		<h2 style="color: white">
			<b>${lecture.l_title}</b>
		</h2>
		<!-- 강좌 수강 여부 판별 -->
		<c:if test="${check == false}">
			<div id="enrollBtn" class="panel panel-default pull-right btn btn-default">
				<div class="panel-body">
					<b>강좌 수강 신청</b>
				</div>
			</div>
		</c:if>
		<!-- 수강 신청 완료한 강좌일 경우 버튼 출력 바뀜 -->
		<c:if test="${check == true}">
			<c:if test=""></c:if>
			<div class="panel panel-default pull-right btn btn-default" onclick="location.href='${pageContext.request.contextPath}/lecture/learnInfo.do?l_num=${lecture.l_num}'">
				<div class="panel-body">
					<b>강좌 보러 가기</b>
				</div>
			</div>
		</c:if>
	</div>
	<!-- 작성자 정보 패널 -->
	<div class="col-xs-12 col-md-3 pull-right panel panel-default" style="margin-top: 15px;">
		<p>
			<b>${writer}</b>
		</p>
		<c:if test="${lecture.l_pay == 0 || lecture.l_pay == null}">
			<p>무료</p>
		</c:if>
		<c:if test="${lecture.l_pay != 0}">
			<p>
				<b>${lecture.l_pay}원</b>
			</p>
		</c:if>
		<p>강좌 개설일 : ${lecture.l_date}</p>
		<c:if test="${lecture.l_redate != null}">
			<p>최근 수정일 : ${lecture.l_redate}</p>
		</c:if>
	</div>
	<!-- 본문 부분 -->
	<div class="col-xs-12 col-md-9 paenl panal-default">
		<p>${lecture.l_content}</p>
		<h4>강좌 교육 과정</h4>
		<hr>
		<c:if test="${lcCount == 0}">
			<p>등록된 강좌 내용이 없습니다.</p>
		</c:if>
		<c:if test="${lcCount > 0}">
			<table class="table">
				<thead>
					<tr>
						<th>강의 제목</th>
						<th>작성일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${lcList}">
						<tr>
							<td>${item.lc_title}</td>
							<td>${item.lc_date}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<hr>
			<div class="panel" id="lecture_reply"></div>
		</c:if>
		
		<div class="panel panel-default">
			<div class="panel-heading">강좌 평가 현황</div>
			<div class="panel-body">
				<div class="col-xs-12 col-md-6 text-center"><br><br><br>
					<span style="font-size: 60pt;"><fmt:formatNumber pattern=".0">${lecture.l_point}</fmt:formatNumber></span>
					<span style="font-size: 20pt;">/5.0</span>
				</div>
				<div class="col-xs-12 col-md-6" style="padding:0px 10px 0px 10px;">
					5점 : ${point.point5}건
					<div class="progress course_progress" style="background-color: #e6e6e6; height: 10px;">
						<div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="${point.point5}" aria-valuemin="0" aria-valuemax="${point.maxpoint}" style="width: ${(point.point5 / point.maxpoint) * 100}%;"></div>
					</div>
					4점 : ${point.point4}건
					<div class="progress course_progress" style="background-color: #e6e6e6; height: 10px;">
						<div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="${point.point4}" aria-valuemin="0" aria-valuemax="${point.maxpoint}" style="width: ${(point.point4 / point.maxpoint) * 100}%;"></div>
					</div>
					3점 : ${point.point3}건
					<div class="progress course_progress" style="background-color: #e6e6e6; height: 10px;">
						<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="${point.point3}" aria-valuemin="0" aria-valuemax="${point.maxpoint}" style="width: ${(point.point3 / point.maxpoint) * 100}%;"></div>
					</div>
					2점 : ${point.point2}건
					<div class="progress course_progress" style="background-color: #e6e6e6; height: 10px;">
						<div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="${point.point2}" aria-valuemin="0" aria-valuemax="${point.maxpoint}" style="width: ${(point.point2 / point.maxpoint) * 100}%;"></div>
					</div>
					1점 : ${point.point1}건
					<div class="progress course_progress" style="background-color: #e6e6e6; height: 10px;">
						<div class="progress-bar progress-bar-primary" role="progressbar" aria-valuenow="${point.point1}" aria-valuemin="0" aria-valuemax="${point.maxpoint}" style="width: ${(point.point1 / point.maxpoint) * 100}%;"></div>
					</div>
				</div>
			</div>
		</div>
		
		<!-- 댓글 부분 -->
		<div class="container" id="lreplyDiv">
			<!-- 댓글 입력 -->
			<div class="col-xs-12 col-md-8" id="lreplyInputDiv">
				<div class="panel panel-default">
					<div id="loading" style="display:none;">
						<img src="${pageContext.request.contextPath}/resources/images/ajax-loader.gif">
					</div>
					<span>강의평 남기기</span>
					
					<form id="reply_form">
						
						<input type="radio" name="lr_point" value="1" class="star"/>
						<input type="radio" name="lr_point" value="2" class="star"/>
						<input type="radio" name="lr_point" value="3" class="star"/>
						<input type="radio" name="lr_point" value="4" class="star"/>
						<input type="radio" name="lr_point" value="5" class="star"/>
						
						<input type="hidden" name="l_num" value="${lecture.l_num}" id="l_num">
						<input type="hidden" name="m_id" value="${userId}" id="userId">
						<textarea rows="3" style="width: 100%;" name="lr_content" id="lr_content"<c:if test="${empty userId || check == false}">disabled="disabled"</c:if>><c:if test="${empty userId || check == false}">강좌를 수강해야 강좌평 입력이 가능합니다.</c:if></textarea>
						<c:if test="${!empty userId}">
							<div id="re_first">
								<span class="letter-count">300/300</span>
							</div>
							<c:if test="${check == true}">
								<div id="re_second">
									<input type="submit" value="전송">
								</div>
							</c:if>
						</c:if>
					</form>
				</div>
			</div>

			
		</div>
		<!-- 댓글 목록 출력 -->
		<div class="container">
			<div class="col-xs-12 col-md-8" id="lcreplyOutput"></div>
			<div class="col-xs-12 col-md-8" style="display: none;">
				<input type="button" value="다음글 보기">
			</div>
		</div>
	</div>
</div>