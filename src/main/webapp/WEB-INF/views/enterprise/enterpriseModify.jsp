<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <link href="${pageContext.request.contextPath}/resources/css/resume/styleRegisterForm.css" rel="stylesheet">
 <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/resume/duplicated.js"></script>
 <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/resume/enterRegiAddress.js"></script>
   	<div>                      
	   	<div class="col-lg-9 col-md-9 col-sm-10 col-xs-10 col-lg-offset-4 col-md-offset-2 col-sm-offset-2 col-xs-offset-2" style="padding:0 0 30px 0;">
	   		<h3 class="h3Title">기업 회원 정보 수정(1/2)</h3>                   
	   		<div style="color:gray;">*수정을 원하시는 곳에 값을 변경해 주세요.</div>                                          
	   	</div>
	   	<p>                
   		<form:form commandName="enterpriseUserCommand" action="enterpriseMod.do" id="enterpriseRegisterForm">
   			<div class="firstForm">
   			<ul>
   				<li>
   					<label for="enterprise_num">사업자 번호 : </label>
   					<input type="text" id="enterprise_num" name="enterprise_num" value="${enterpriseUserCommand.enterprise_num}">
   					<div id="confirmEnterNum" style="text-align:center">입력해 주세요!</div>
   				</li>
   				<li style="margin:0 0 22px 0">
   					<label for="enterprise_name">기업명 : </label>
   					<input type="text" id="enterprise_name" name="enterprise_name" value="${enterpriseUserCommand.enterprise_name }">
   				</li>
   				<li style="margin:0 0 22px 0">
   					<label for="enterprise_ceo">대표자 명 : </label>
   					<input type="text" id="enterprise_ceo" name="enterprise_ceo" value="${enterpriseUserCommand.enterprise_ceo}">
   				</li>
   				<li>
   					<label for="enterprise_postCode">기업 우편 번호 : </label>
   					<input type="text" class="postCode" id="enterprise_postCode" name="enterprise_postCode" style="width:240px;" value="${enterpriseUserCommand.enterprise_postCode}" readOnly>
   					<input type="button" id="enterprise_postCode_search" value="주소 찾기">
   				</li>
   				<li style="margin:0 0 22px 0">                
   					<label for="enterprise_address">기업 주소 : </label>
   					<input type="text" id="enterprise_address" name="enterprise_address" value="${enterpriseUserCommand.enterprise_address}">
   				</li>
   				<li style="margin:0 0 22px 0">	
   					<label for="enterprise_address_detail">기업 상세 주소</label>
   					<input type="text" id="enterprise_address_detail" name="enterprise_address_detail" value="${enterpriseUserCommand.enterprise_address_detail}">
   				</li>
   				<li style="margin:0 0 22px 0">
   					<label for="enterprise_phone_num">기업 전화 번호 : </label>
   					<input type="text" id="enterprise_phone_num" name="enterprise_phone_num" value="${enterpriseUserCommand.enterprise_phone_num}">
   				</li>
   				<li style="margin:0 0 22px 0">
   					<label for="enterprise_pax_num">기업 팩스 번호 : </label>
   					<input type="text" id="enterprise_pax_num" name="enterprise_pax_num" value="${enterpriseUserCommand.enterprise_pax_num}">
   				</li>
   				<li style="margin:0 0 22px 0">
   					<label for="enterprise_type">기업 종류 : </label>
   					<select name="enterprise_type">
   						<option value="대기업">대기업</option>
   						<option value="중소 기업">중소 기업</option>
   						<option value="소기업">소기업</option>
   					</select>
   				</li>
   				<li style="margin:0 0 22px 0">
   					<label for="enterprise_info">기업 정보 : </label>
   					<input type="text" id="enterprise_info" name="enterprise_info" value="${enterpriseUserCommand.enterprise_info}">
   				</li>
   				<li>
   					<input type="button" value="Next" class="nextButton2">
   				</li>
   			</ul>
   			</div>
   			
   			<div style="display:none" class="secondForm">
   			<ul>
   				<li>
   					<label for="m_id">아이디 : </label>
   					<input type="email" id="m_id" name="m_id" value="${enterpriseUserCommand.m_id}">
   					<div id="confirmEnterId" style="text-align:center">입력해 주세요!</div>
   				</li>                     
   				<li style="margin:0 0 22px 0">
   					<label for="enterprise_id">닉네임 : </label>
   					<input type="text" id="m_nick" name="m_nick" value="${enterpriseUserCommand.m_nick}">
   				</li>
   				<li>
   					<label for="enterprise_password">비밀 번호 : </label>
   					<input type="password" id="enterprise_password" name="enterprise_password" value="${enterpriseUserCommand.enterprise_password}">
   					<div id="boxLength">*비밀 번호를 입력해 주세요.</div>
   				</li>
   				<li>
   					<label for="enterprise_password_confirm">비밀 번호 확인: </label>
   					<input type="password" id="enterprise_password_confirm" name="enterprise_password_confirm" value="${enterpriseUserCommand.enterprise_password_confirm}">
   					<div id="boxBox">*두 비밀번호는 같아야 합니다!</div>
   				</li>
   				
   				<li style="margin:0 0 22px 0">
   					<label for="enterprise_email">기업 메일 주소 : </label>
   					<input type="email" id="enterprise_email" name="enterprise_email" value="${enterpriseUserCommand.enterprise_email}">
   				</li>
   				<li style="margin:0 0 22px 0">
   					<label for="enterprise_charge">담당자 명 : </label>
   					<input type="text" id="enterprise_charge" name="enterprise_charge" value="${enterpriseUserCommand.enterprise_charge}">
   				</li>
   				<li style="margin:0 0 22px 0">
   					<label for="enterprise_charge_phone">담당자 연락처 : </label>
   					<input type="text" id="enterprise_charge_phone" name="enterprise_charge_phone" value="${enterpriseUserCommand.enterprise_charge_phone}">
   				</li>             
   				<li>            
   					<span style="width:400px;">*선택 항목*</span>
   				</li>         
   				<li>
   					<input type="button" id="payInput" value="연봉 입력">
   				</li>
   				<li>
   					<div id="pay" style="display:none;">
	   					<label for="enterprise_pay">신입 연봉(단위:만원) : </label>
	   					<input type="number" class="others" id="enterprise_pay" name="enterprise_pay" value="${enterpriseUserCommand.enterprise_pay}" disabled="disabled">
   					</div>
   				</li>
   				<li>
   					<input type="button" id="payInput2" value="평균 연봉 입력">
   				</li>
   				<li>
   					<div id="pay_per" style="display:none;">
	   					<label for="enterprise_pay_percent">개발자 평균 연봉(단위:만원) : </label>
	   					<input type="number" class="others" id="enterprise_pay_percent" name="enterprise_pay_percent" value="${enterpriseUserCommand.enterprise_pay_percent}" disabled="disabled">
   					</div>
   				</li>
   				<li>
   				<li>
   					<input type="button" value="Prev" class="prevButton2">
   				</li>
   				<li>
   					<input type="submit" value="수정">
   					<input type="button" id="home" value="Home" class="homeButton" onclick="location.href='${pageContext.request.contextPath}/main/main.do'">
   				</li>
   			</ul>
   			</div>
   		</form:form>
   	</div>
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	