<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/admin.css">
<script src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/admin/admin.js"></script>
<div class="row">
	<div class="container">
		<div id="tabMenu" class="col-lg-12 col-md-12 col-sm-12 col-xs-12 col-lg-offset-2 col-md-offset-2 col-sm-offset-2 col-xs-offset-1">
			<h3>계정 활성화/비활성화</h3>
			<div class="gray">*비활성화시 고객의 접근을 막을 수 있습니다.</div>
			<div id="memberBtn" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 col-lg-offset-1 col-md-offset-1 col-sm-offset-1 col-xs-offset-1">
				회원 정보
			</div>
			<div id="enterpriseBtn" class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
				기업 정보
			</div>
		</div>
		<div id="member" class="col-lg-12 col-md-12 col-sm-12 col-xs-12 col-lg-offset-2 col-md-offset-2 col-sm-offset-2 col-xs-offset-1">
			<c:if test="${!empty member}">
			<table>
				<tr class="tr">
					<td class="num">번호</td>
					<td class="mId">아이디</td>
					<td class="mNick">닉네임</td>
					<td class="mAccess">제명 여부</td>
					<td class="mBtn">재명 버튼</td>
				</tr>  
				<c:forEach var="m" items="${member}" varStatus="i">
					<tr>
						<td class="num">${i.count}</td>
						<td class="mId">${m.m_id}</td>
						<td class="mNick">${m.m_nick}</td>
						<td class="mAccess">
							<c:if test="${m.m_access==0}">활동 가능</c:if>
							<c:if test="${m.m_access==1}">재명 됨</c:if>
						</td>
						<td class="mBtn">
							<input class="accessMember btn btn-default" data-id="${m.m_id}" <c:if test="${m.m_access==0}">value="재명"</c:if><c:if test="${m.m_access==1}">value="비재명"</c:if>>
						</td>
					</tr>  
				</c:forEach>
			</table>
			</c:if>
			<c:if test="${empty member}">
				<div class="null">아직 가입한 회원이 없습니다.</div>
			</c:if>
		</div>
		<div id="enter" class="col-lg-12 col-md-12 col-sm-12 col-xs-12 col-lg-offset-2 col-md-offset-2 col-sm-offset-2 col-xs-offset-1">
			<c:if test="${!empty enter}">
			<table>
				<tr class="tr">          
					<td class="num">번호</td>
					<td class="mId">아이디</td>
					<td class="mNick">닉네임</td>
					<td class="mAccess">제명 여부</td>
					<td class="mBtn">재명 버튼</td>
				</tr>         
				<c:forEach var="e" items="${enter}" varStatus="j">
					<tr>
						<td class="num">${j.count}</td>
						<td class="mId">${e.m_id}</td>
						<td class="mNick">${e.m_nick}</td>
						<td class="mAccess">
							<c:if test="${e.m_access==0}">활동 가능</c:if>
							<c:if test="${e.m_access==1}">재명 됨</c:if>
						</td>                       
						<td class="mBtn">
							<input class="accessMember btn btn-default" data-id="${e.m_id}" <c:if test="${e.m_access==0}">value="재명"</c:if><c:if test="${e.m_access==1}">value="비재명"</c:if>>
						</td>           
					</tr>  
				</c:forEach>
			</table>
			</c:if>
			<c:if test="${empty enter}">
				<div class="null">아직 가입한 기업 회원이 없습니다.</div>
			</c:if>
		</div>
	</div>
</div>