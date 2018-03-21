<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="${pageContext.request.contextPath}/resources/css/resume/styleEnter.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui.min.css">
<script src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/resume/resumeDetail.js"></script>
<div class="topop col-lg-6 col-md-8 col-sm-10 col-xs-10 col-lg-offset-3 col-md-offset-2 col-sm-offset-2 col-xs-offset-1">
	<h3><b>가입하신 기업 회원 정보 입니다.</b></h3>
	<div class="grayColor">*한번 변경하신 정보는 다시 되돌릴 수 없습니다.</div>
</div>                 
<div class="row">
	<div class="col-lg-10 col-md-8 col-sm-10 col-xs-10 col-lg-offset-3 col-md-offset-2 col-sm-offset-1 col-xs-offset-1">
		<table>                
			<tr>                  
				<td class="title" colspan="3">
					<span>아이디</span>
				</td>          
				<td class="title" colspan="2">
					<span>닉네임</span>            
				</td>
			</tr>
			<tr>
				<td class="content" colspan="3">
					<span>${enterpriseUserCommand.m_id}</span>
				</td>
				<td class="content" colspan="2">
					<span>${enterpriseUserCommand.m_nick}</span>
				</td>
			</tr>
			<tr>
				<td>
				</td>
			</tr>
			<tr>
				<td class="title" colspan="2">
					<span>기업명</span>
				</td>
				<td class="title" colspan="2">
					<span>사업자 번호</span>
				</td>
				<td class="title">
					<span>대표자 명</span>
				</td>
			</tr>
			<tr>
				<td class="content" colspan="2">
					<span>${enterpriseUserCommand.enterprise_name}</span>
				</td>
				<td class="content" colspan="2">
					<span>${enterpriseUserCommand.enterprise_num}</span>
				</td>
				<td class="content">
					<span>${enterpriseUserCommand.enterprise_ceo}</span>
				</td>
			</tr>
			<tr>
				<td>
				</td>
			</tr>
			<tr>
				<td class="title">
					<span>기업 주소</span>
				</td>
				<td class="title">
					<span>우편 번호</span>
				</td>
				<td class="title">
					<div>기업 상세 주소</div>
				</td>
				<td class="title">
					<div>기업 정보</div>
				</td>
				<td class="title">
					<div>기업 종류</div>
				</td>
			</tr>
			<tr>
				<td class="content">
					<div>${enterpriseUserCommand.enterprise_address}</div>
				</td>
				<td class="content">
					<div>${enterpriseUserCommand.enterprise_postCode}</div>
				</td>
				<td class="content">
					<div>${enterpriseUserCommand.enterprise_address_detail}</div>
				</td>
				<td class="content">
					<div>${enterpriseUserCommand.enterprise_info}</div>
				</td>
				<td class="content">
					<div>${enterpriseUserCommand.enterprise_type}</div>
				</td>
			</tr>
			<tr>
				<td>
				</td>
			</tr>
			<tr>
				<td class="title" colspan="2">
					<div>기업 전화 번호</div>
				</td>
				<td class="title" colspan="3">
					<div>기업 팩스 번호</div>
				</td>
			</tr>
			<tr>
				<td class="content" colspan="2">
					<div>${enterpriseUserCommand.enterprise_phone_num}</div>
				</td>
				<td class="content" colspan="3">
					<div>${enterpriseUserCommand.enterprise_pax_num}</div>
				</td>
			</tr>
			<tr>
				<td>
				</td>
			</tr>
			<tr>
				<td class="title" colspan="2">
					<div>기업 메일 주소</div>
				</td>
				<td class="title" colspan="2">
					<div>담당자 명</div>
				</td>
				<td class="title">
					<div>담당자 연락처</div>
				</td>                
			</tr>
			<tr>
				<td class="content" colspan="2">
					<div>${enterpriseUserCommand.enterprise_email}</div>
				</td>
				<td class="content" colspan="2">
					<div>${enterpriseUserCommand.enterprise_charge}</div>
				</td>
				<td class="content">
					<div>${enterpriseUserCommand.enterprise_charge_phone}</div>
				</td>
			</tr>
			<tr>
				<td>
				</td>
			</tr>
			<tr>
				<td class="title" colspan="5">
					<div>기업 연봉 정보</div>
				</td>
			</tr>
			<tr>
				<td class="content" colspan="5">
					신입 연봉 : ${enterpriseUserCommand.enterprise_pay}<br>
					개발자 평균 연봉 : ${enterpriseUserCommand.enterprise_pay_percent}
				</td>
			</tr>
			<tr>
				<td colspan="5">
					<div>
						<input type="button" value="정보 수정" onclick="location.href='${pageContext.request.contextPath}/user/enterpriseModifyInfo.do'">
						<input type="button" class="btn btn-default" id="deleteConfirm" value="회원 탈퇴">
					</div>
				</td>
			</tr>
			<tr>
			
			</tr>
			<tr>
			
			</tr>
		</table>
	</div>
	<div id="conDelete" title="삭제 확인" style="display:none">
		<h1>잠깐만요!</h1>               
			<div>
				<div>회원 탈퇴를 진행 중 입니다.<br>진행을 위해선 회원님의 비밀번호를 다시한번 입력해 주세요.</div>
					<br>
					<div style="padding:5px;">               
					<form action="enterpriseDeleteInfo.do" method="post">
						<input type="password" id="password" name="password" placeholder="비밀번호를 입력해 주세요." style="width:200px">
						<input class="btn" type="submit" value="회원 탈퇴">
					</form>
				</div>               
			</div>
	</div>
</div>