<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="${pageContext.request.contextPath}/resources/css/resume/styleEnter.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/resume/likeResume.js"></script>
<div class="col-lg-10 col-md-8 col-sm-10 col-xs-10 col-lg-offset-3 col-md-offset-2 col-sm-offset-2 col-xs-offset-1">
	<h3>관심있는 이력서 목록</h3>
	<div class="grayColor">*클릭 하시면 해당 이력서로 이동합니다.</div>
</div>                        
<c:if test="${!empty listResume}">                 
<div class="row">                                    
	<div class="col-lg-10 col-md-8 col-sm-10 col-xs-10 col-lg-offset-3 col-md-offset-2 col-sm-offset-2 col-xs-offset-1">          
		<form id="deleteConfirm" action="deleteEnterResume.do" method="post">
			<table id="justOne">              
				<tr>                             
					<td class="ancho1">
						<div>번호</div>
					</td>
					<td>
						<div>이력서 아이디</div>
					</td>
					<td>
						<div>관심 분야</div>
					</td>                     
				</tr>
				<c:forEach var="id" items="${listResume}" varStatus="st">
					<tr class="ancho">
						<td class="ancho1">            
							(${st.count})
							<input type="checkbox" name="chLikeResume" value="${id.m_id}">
						</td>
						<td class="ancho6">
							<a href="${pageContext.request.contextPath}/user/enpriReView.do?m_id=${id.m_id}">${id.m_id}</a>
						</td>
						<td class="ancho3">
							${id.r_loc}
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="3">           
						<input type="submit" value="삭제">
					</td>
				</tr>
			</table>
		</form>
	</div>               
</div>
</c:if>
<c:if test="${empty listResume||listResume eq null}">
	<div class="row">
		<div class="col-lg-4 col-md-5 col-sm-7 col-xs-8 col-lg-offset-4 col-md-offset-3 col-sm-offset-2 col-xs-offset-1">
			<div id="wrap">
				<h4><strong>아직 이력서를 가져 오시지 않으셨군요!</strong></h4>
				<div>혹시 맘에 드는 이력서가 없으신가요?</div>            
				<div>아니면 관심있는 이력서가 제대로 로딩이 되지 않았나요??</div>
				<div><a href="${pageContext.request.contextPath}/user/resumeList.do">이력서 목록</a>으로 돌아가시려면 링크를 클릭해 주세요!</div>
				<div>아니면 <a href="${pageContext.request.contextPath}/main/main.do">메인 페이지</a>로 가시겠어요?</div>
			</div>
		</div>
	</div>
</c:if>