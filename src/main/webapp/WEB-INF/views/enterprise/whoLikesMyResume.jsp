<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="${pageContext.request.contextPath}/resources/css/user/styleAlert.css" rel="stylesheet">
<div class="row">                  
	<div class="container">         
		<div class="col-lg-12 col-md-12 col-sm-10 col-xs-12">
			<div class="col-lg-10 col-md-10 col-sm-11 col-xs-11 col-lg-offset-1 col-md-offset-1 col-sm-offset-1">
				<img src="${pageContext.request.contextPath}/resources/images/resume/time-3091031_1920.jpg" style="height:100px;width:1000px;object-fit:cover;">
			</div>
			<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 col-lg-offset-1 col-md-offset-1 col-sm-offset-1">               
				<h3>당신에게 관심있는 기업</h3>                                                     
				<h5 style="color:gray;">*상세 정보를 원하시면 해당 기업명을 클릭해 주세요.</h5>
			</div>                                                 
		<c:if test="${empty list}">                   
			<div class="col-lg-12 col-md-12 col-sm-10 col-xs-12">
				<div id="noneLike" class="col-lg-6 col-md-6 col-sm-8 col-xs-10 col-lg-offset-4 col-md-offset-4 col-sm-offset-4 col-xs-offset-2">                                                
					<strong>아직 기업이 이력서를 열람 하지 않은것 같아요!</strong>           
				</div>                                  
				<div id="tip" class="col-lg-4 col-md-4 col-sm-7 col-xs-7 col-sm-offset-4 col-xs-offset-2">
					<div class="col-lg-offset-3 col-md-offset-3 col-sm-offset-2 col-xs-offset-3">
						<img id="followImg" src="${pageContext.request.contextPath}/resources/images/resume/empty.png">
					</div>                 
					<div>            
						<h4>Tip!</h4>       
						<span>이력서 완성도에 따라서 취업 성공률도 달라진다는 점!</span><br>
						<span>잊지 마세요!</span>
					</div>
				</div>                    
			</div>
		</c:if>
			<table class="col-lg-10 col-md-10 col-sm-10 col-xs-11 col-lg-offset-1 col-md-offset-1 col-sm-offset-1">
				<c:forEach var="enter" items="${list}" varStatus="status">
						<tr>                          
							<td class="gray">번호</td>                
							<td class="gray">열람한 기업명</td>
							<td class="gray">담당자 명</td>
							<td class="gray">등록일</td>
						</tr>
						<tr>
							<td class="content">${status.count}</td>
							<td class="content"><a href="${pageContext.request.contextPath}/user/enterDetailInfo.do?email=${enter.enterprise_email}">${enter.enterNames}</a></td>
							<td class="content">${enter.enterprise_charge}</td>
							<td class="content">${enter.enterLikeDate}</td>
						</tr>         
				</c:forEach>           
			</table>                         
			<div class="col-lg-6 col-md-6 col-sm-8 col-xs-8 col-lg-offset-5 col-md-offset-5 col-sm-offset-5 col-xs-offset-4">
				<input type="button" id="btn1" class="btn btn-default" value="내정보" onclick="location.href='${pageContext.request.contextPath}/user/myPageMain.do'">
				<input type="button" id="btn2" class="btn btn-default" value="홈으로" onclick="location.href='${pageContext.request.contextPath}/main/main.do'">
			</div>
		</div>    
	</div>                                   
</div>