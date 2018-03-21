<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="${pageContext.request.contextPath}/resources/plugins/summernote/summernote.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/summernote/summernote.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/summernote/lang/summernote-ko-KR.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lecture/insertLContent.js"></script>
<div class="container">
	<div class="panel panel-default" style="padding:10px 15px 50px 10px;">
		<form:form commandName="lcCommand" action="insertLcontent.do" id="insertLCForm">
			<%-- <form:hidden path="l_num"/> --%>
			<input type="hidden" name="l_num" id="l_num" value="${l_num}">
			
			<div class="form-group">
				<label for="lc_title">제  목</label>
				<form:input path="lc_title" id="lc_title" class="form-control"/>&nbsp;<form:errors path="lc_title"/><br>
			</div>
			
			<div class="form-group">
				<label for="lc_title">내  용</label>
				<form:errors path="lc_content"/><br>
				<form:textarea path="lc_content" cssClass="summernote" id="lc_content"/><br>
			</div>
			
			<div class="text-center">
				<input type="submit" value="submit" class="btn btn-default col-xs-6">
				<input type="reset" class="btn btn-default col-xs-6" onclick="location.href='myLectureList.do'" value="내 강좌 목록">
			</div>
		</form:form>
	</div>
	
</div>