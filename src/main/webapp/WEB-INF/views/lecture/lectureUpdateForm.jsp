<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- jquery / bootstrap -->
<link href="${pageContext.request.contextPath}/resources/plugins/summernote/summernote.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/summernote/summernote.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/summernote/lang/summernote-ko-KR.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lecture/insertLecture.js"></script>
	
<div class="container">
	<p>강좌 수정 페이지</p>
	<form:form commandName="lecture" action="lectureUpdate.do" id="LectureUpdateForm">
	<form:errors element="div"/>
	분야 : ${subject.lv1} > ${subject.lv2}
	<span id="selectedSubject"></span>
		<img src="${pageContext.request.contextPath}/resources/images/ajax-loader.gif" id="loading" width="16" height="16" style="display: none;">
		<br>
		<br>
		<form:hidden path="l_num" />
		<form:hidden path="l_date" />
		<form:hidden path="m_id" />
		<form:hidden path="s_num" />
		<form:hidden path="l_open" />
		<!-- 꼭 오픈 여부 추가하자 -->
		<div class="form-group">
			<label for="l_title">제 목</label>
			<form:input path="l_title" id="l_title" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="l_shortcon">간략한 소개글</label>
			<form:textarea path="l_shortcon" id="l_shortcon" class="form-control" style="100%"/>
			<span id="scCount">300/300</span><br>
		</div>
		<div class="form-group">
			<label for="l_content">강의 메인 페이지 (강의 개요)</label>
			<form:errors path="l_content"/>
			<form:textarea path="l_content" cssClass="summernote" id="l_content"/><br>
		</div>
		<div class="form-group">
			<input type="submit" class="btn btn-default" value="수정하기">
		</div>
		</form:form>
</div>