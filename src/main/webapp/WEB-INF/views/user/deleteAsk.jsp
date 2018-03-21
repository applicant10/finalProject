<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container">
	<p>정말 탈퇴하시겠습니까?</p>
	<form:form commandName="member" action="delete.do" id="deleteAsckForm" method="post">
		<form:hidden path="m_id" />
		<label for="m_pw">비밀번호</label>
		<form:password path="m_pw"/> <!-- input타입에서 password타입으로 바꿈 -->
		<form:errors path="m_pw" cssClass="error-color"/>
		<div>
			<input type="submit" value="탈퇴"/>
			<input type="button" value="돌아가기" onclick="location.href='${pageContext.request.contextPath}/user/myInfo.do'"/>
		</div>
	</form:form>
</div>