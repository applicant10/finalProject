<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<link href="${pageContext.request.contextPath}/resources/plugins/summernote/summernote.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/summernote/summernote.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/summernote/lang/summernote-ko-KR.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lecture/insertLContent.js"></script>

<div class="container">
	<div class="panel panel-default" style="padding: 15px 15px 55px 15px;">
		<form:form commandName="command" action="write.do" id="register_form">
			<form:hidden path="m_id" />
			<form:hidden path="b_nick" />
			<form:errors element="div" cssClass="error-color" />
			
			<div class="form-group">
				<label for="b_title">제목</label>
				<form:input path="b_title" cssClass="form-control"/>
				<form:errors path="b_title" cssClass="error-color" />
			</div>
			<div class="form-group">
			<label for="b_content">내용</label>
				<form:errors path="b_content" cssClass="error-color" />
				<form:textarea path="b_content" cssClass="summernote" id="b_content"/>
			</div>
			<div class="text-center">
				<input type="submit" value="전송" class="col-xs-6 btn btn-default">
				<input type="button" value="목록"  class="col-xs-6 btn btn-default" onclick="location.href='boardList.do'">
			</div>
		</form:form>
	</div>
</div>