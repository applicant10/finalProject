<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/user/myInfo.css">
<div class="row">
	<div class="container">        
		<div id="menu" class="col-lg-4 col-md-4 col-sm-11 col-xs-10 col-lg-offset-1 col-md-offset-2 col-sm-offset-1 col-xs-offset-1">
			<h3>이력서 확인</h3>                      
			<div class="myInformation">*작성하신 이력서와 기업에서 보낸 알림을 받을 수 있습니다.</div>     
				<div id="wrapImg" class="col-lg-6 col-md-7 col-sm-3 col-xs-6 col-sm-offset-1">
					<img id="imgChart" src="${pageContext.request.contextPath}/resources/images/resume/resumeChart.png">
				</div>                                                            
				<div class="col-lg-4 col-md-4 col-sm-4 col-xs-3">                               
					<div class="col-lg-8 col-md-8 col-sm-11 col-xs-10">       
						<c:if test="${check==false}"><a class="btn-size btn btn-default" href="${pageContext.request.contextPath}/user/myResumeForm.do">이력서 작성</a><br></c:if>
						<c:if test="${check==true}"><a class="btn-size btn btn-default" href="${pageContext.request.contextPath}/user/enpriReView.do?m_id=${member.m_id}">이력서 확인</a><br></c:if>
					</div>                        
					<div class="col-lg-8 col-md-8 col-sm-11 col-xs-10">        
						<a class="btn-size btn btn-default" href="${pageContext.request.contextPath}/user/whoLikesMine.do">알림 확인</a>
					</div>
				</div>                     
		</div>                              
		<div id="wrapHalf" class="col-lg-5 col-md-5 col-sm-11 col-xs-10 col-lg-offset-1 col-md-offset-1 col-sm-offset-1 col-xs-offset-1">
			<h3>My Info</h3>       
			<div class="info">
			 <span class="myInformation">*회원님의 정보 </span><strong>수정</strong> <span class="myInformation">혹은</span> <strong>탈퇴</strong><span class="myInformation">를 도와 드립니다.</span>
			</div>
			<ul>             
			    <li>
			        <label>아이디 : </label>
			        <span>${member.m_id}</span>          
			   </li>
			   <li>
			       <label>닉네임 : </label>
			       <span>${member.m_nick}</span>
			   </li>
			   <li>
			       <label>회원 종류 : </label>
			       <span><c:if test="${member.m_grade eq 1}">일반 회원</c:if></span>
			   </li>
			   <li>
			       <label>이름 : </label>
			       <c:if test="${not empty member.md_name}">
						<span>${member.md_name}</span>
			       </c:if>
			       <c:if test="${empty member.md_name}">
			       		<span>[ 비어 있음 ]</span>
			       </c:if>
			       
			   </li>
			   <li>        
			       <label>전화번호 : </label>
			       <c:if test="${not empty member.md_phone}">
						<span>${member.md_phone}</span>
			       </c:if>
			       <c:if test="${empty member.md_phone}">
			       		<span>[ 비어 있음 ]</span>       
			       </c:if>
			    </li>       
			</ul>
			<div class="col-lg-offset-1 col-md-offset-1 col-sm-offset-1 col-xs-offset-1">
			    <input type="button" class="btn btn-default" value="정보 수정" onclick="location.href='${pageContext.request.contextPath}/user/update.do'"/>
			    <input type="button" class="btn btn-default" value="회원 탈퇴" onclick="location.href='${pageContext.request.contextPath}/user/delete.do'"/>
			</div>
		</div>
	</div>
</div>