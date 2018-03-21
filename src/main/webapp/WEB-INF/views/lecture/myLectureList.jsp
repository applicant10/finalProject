<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="${pageContext.request.contextPath}/resources/lib/jquery-ui-1.12.1/jquery-ui.min.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/jquery-ui-1.12.1/jquery-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lecture/myLectureList.js"></script>

<div class="container">
	<div class="row">
		<!-- 유저 정보 -->
		<div class="col-xs-12 col-md-4">
			<div class="panel panel-info">
				<div class="panel-heading">
					<span class="text-center lead"><b>${user.m_nick}</b><small>(${user.m_id})</small></span>
				</div>
				<div class="panel-body">
					<p style="margin-left:30px;">회원 등급 : ${user.m_grade}</p>
					<p style="margin-left:30px;">개설한 강의 수 : ${lectureCount}</p>
				</div>
			</div>
		</div>
		<!-- 강의 목록-->
		<div class="col-xs-12 col-md-8">
			<a href="${pageContext.request.contextPath}/lecture/insertLecture.do">새 강의 개설</a>
			<ul class="list-group">
				<c:forEach var="item" items="${list}">
					<li class="list-group-item">
					<span id="lecture_title_${item.l_num}">${item.l_title}</span>
					<div class="btn-group btn-group-xs pull-right">
						<button id="lecture_${item.l_num}" data-state="close" data-load="off" class="btn btn-info btn-xs"><span class="glyphicon glyphicon-list"></span></button>
						<button onclick="location.href='lectureView.do?l_num=${item.l_num}'" class="btn btn-info btn-xs"> <span class="glyphicon glyphicon-search"></span></button>
						<button onclick="location.href='lectureUpdate.do?l_num=${item.l_num}'" class="btn btn-info btn-xs"><span class="glyphicon glyphicon-pencil"></span></button>
						<c:if test="${item.l_open == 'open'}">
							<button id="lectureClose-l-num_${item.l_num}" class="btn btn-info btn-xs"><span id="iconEye" class="glyphicon glyphicon-eye-open"></span></button>
							<%-- <button id="lectureClose-l_num_${item.l_num}" onclick="location.href='lectureClose.do?l_num=${item.l_num}'" class="btn btn-info btn-xs"><span class="glyphicon glyphicon-eye-open" id="opened_${item.l_num}"></span></button> --%>
						</c:if>
						<c:if test="${item.l_open == 'close'}">
							<button id="lectureOpen-l-num_${item.l_num}" class="btn btn-info btn-xs"><span id="iconEye" class="glyphicon glyphicon-eye-close"></span></button>
							<%-- <button id="lectureOpen-l_num_${item.l_num}" onclick="location.href='lectureOpen.do?l_num=${item.l_num}'" class="btn btn-info btn-xs"><span class="glyphicon glyphicon-eye-close" id="closed_${item.l_num}"></span></button> --%>
						</c:if>
					</div>
					<div id="child_${item.l_num}"></div>
					</li>
				</c:forEach>
			</ul>
			<!-- <table class="table table-bordered"></table> -->
		</div>
	</div>
</div>