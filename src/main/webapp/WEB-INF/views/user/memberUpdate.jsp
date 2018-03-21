<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/user/myInfoUpdate.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/resume/confirmNick.js"></script>
<div class="row">
	<div class="container">
		<div id="wrapAll" class="col-lg-4 col-md-4 col-sm-8 col-xs-10 col-lg-offset-2 col-md-offset-1 col-sm-offset-1 col-xs-offset-1">
			<h3>회원 정보 수정</h3>
			<div id="info">*한번 바뀐 정보는 되돌릴 수 없습니다.<br>닉네임 중복체크를 해주셔야 다음 진행이 가능 합니다.</div>
			<form:form commandName="member" action="update.do" id="modifyForm">
				<form:hidden path="m_id"/>
				<form:errors element="div" cssClass="error-color"/>
				<ul>         
					<li>            
						<label for="m_nick">닉네임</label>
						<form:input path="m_nick"/>
						<div id="duple" class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
							<input type="button" class="btn" id="confirmId" value="닉네임 중복체크">
							<span class="col-xs-12" id="message_id"></span>           
						</div>          
						<form:errors path="m_nick" cssClass="error-color"/>
					</li>
					<li>
						<label for="md_name">이름</label>
						<form:input path="md_name"/>
						<form:errors path="md_name" cssClass="error-color"/>
					</li>
					<li>
						<label for="m_pw">비밀번호</label>
						<form:password path="m_pw"/>
						<form:errors path="m_pw" cssClass="error-color"/>             
					</li>
					<li>
						<label for="md_phone">전화 번호</label>
						<form:input path="md_phone"/>
						<form:errors path="md_phone" cssClass="error-color"/>
					</li>          
				</ul>                   
				<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 col-lg-offset-3 col-md-offset-3 col-sm-offset-2 col-xs-offset-2">
					<input type="submit" class="btn btn-default" value="수정">
					<input type="button" class="btn btn-default" value="Home" onclick="location.href='${pageContext.request.contextPath}/main/main.do'">
				</div>             
			</form:form>          
		</div>            
		<div id="tip" class="col-lg-4 col-md-4 col-sm-3 col-xs-10 col-xs-offset-1">
			<div class="col-lg-offset-3 col-md-offset-3 col-sm-offset-2 col-xs-offset-3">
				<img id="followImg" src="${pageContext.request.contextPath}/resources/images/resume/empty.png">
			</div>                 
			<div>            
				<h4>Tip!</h4>       
				<span>회원님! 혹시 이력서 작성은 완료 하셨나요?</span><br>
				<span>이력서 완성도에 따라서 취업 성공률도 달라진다는 점!</span><br>
				<span>잊지 마세요!</span>
			</div>
		</div>
		<br>
	</div>
</div>