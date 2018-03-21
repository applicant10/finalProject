<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/resume/enterDetail.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui.min.css">
<script src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/resume/enterDetail.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=88cdf326d6f10aace1bb5ccf2bbd4181&libraries=services"></script>
<div class="row">
	<div class="container">
		<h3 class="col-lg-offset-1 col-md-offset-2 col-sm-offset-2 col-xs-offset-1">기업 정보</h3>
		<div id="wrapInfo" class="col-lg-10 col-md-10 col-sm-10 col-xs-10 col-lg-offset-1 col-md-offset-2 col-sm-offset-2 col-xs-offset-1">
				<input type="hidden" value="${info.enterprise_address}" id="enterMapAdd">
				<input type="hidden" value="${info.enterprise_name}" id="enterMappName">
				<div id="enName" class="col-lg-4 col-md-4 col-sm-5 col-xs-12">
					<label>기업명</label>
					<h4 id="name">${info.enterprise_name}</h4>
				</div>         
				<div id="enType" class="col-lg-4 col-md-4 col-sm-5 col-xs-12">
					<label>기업 종류</label>
					<h4 id="type">${info.enterprise_type}</h4>
				</div>
				<div id="enSal" class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
					<label>연봉 정보</label>
					<h4 id="sal">
						신입 연봉 : ${info.enterprise_pay}만원<br><br>
						개발자 평균 연봉 : ${info.enterprise_pay_percent}만원
					</h4>
				</div>          
			<div id="wrapAddress" class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<label>기업 주소</label>      
				<div id="enAddress">
					<div>주소 : ${info.enterprise_address}</div>
					<div>상세 주소 : ${info.enterprise_address_detail}</div>
					<div>우편 번호 : ${info.enterprise_postCode}</div>
				</div>
			</div>
			<div id="map" class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				asdfasdf
			</div>
		</div>
		<div id=btns class="col-lg-6 col-md-6 col-sm-8 col-xs-8 col-lg-offset-5 col-md-offset-5 col-sm-offset-5 col-xs-offset-4">
			<input type="button" id="btn1" class="btn btn-default" value="내정보" onclick="${pageContext.request.contextPath}/user/myPageMain.do">
			<input type="button" id="btn2" class="btn btn-default" value="홈으로" onclick="'${pageContext.request.contextPath}/main/main.do'">
		</div>
	</div>
</div>