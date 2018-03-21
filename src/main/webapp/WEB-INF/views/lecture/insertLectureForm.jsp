<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- jquery / bootstrap -->
<link href="${pageContext.request.contextPath}/resources/plugins/summernote/summernote.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/summernote/summernote.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/summernote/lang/summernote-ko-KR.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lecture/insertLecture.js"></script>
<div class="container">
	<label>강좌 개설</label>
	<form:form commandName="lecture" action="insertLecture.do" id="insertLectureForm">
	분야 선택<br>
	<select id="lv1" size="${lv1Size}">
		<c:forEach var="lv1Item" items="${lv1List}">		
			<option value="${lv1Item.lv1}">${lv1Item.lv1}</option>
		</c:forEach>
	</select>
	<select id="lv2" size="5" name="s_num"></select><br><br>
	<span id="selectedSubject"></span>
	<img src="${pageContext.request.contextPath}/resources/images/ajax-loader.gif" id="loading" width="16" height="16" style="display:none;">
	<br><br>
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
	<input type="hidden" value="${userId}" name="m_id"/>
	<div class="form-group text-center">
			<input type="submit" value="개설하기" class="btn btn-default col-xs-6">
			<input type="reset" class="btn btn-default col-xs-6" onclick="location.href='myLectureList.do'" value="내 강좌 목록">
	</div>
	</form:form>
</div>