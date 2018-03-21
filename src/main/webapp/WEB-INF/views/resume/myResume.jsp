<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/resume/resumeDetail.css">
<script src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/resume/resumeDetail.js"></script>
<div class="row">
	<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 col-lg-offset-2 col-md-offset-1 col-sm-offset-1 col-xs-offset-1">        
		<div id="proprotexttext" class="col-lg-3 col-md-3">
			<div>              
				<h3>이력서 상세 내역 - 물방울 세상</h3>                                             
				<h5 style="color:gray;">*동그라미를 눌러 보세요!</h5>                    
			</div>
		</div>                    
		<div id="proproidid" class="col-lg-2 col-md-2 col-lg-offset-1 col-md-offset-1"> 
			<div>                              
				<h3>${resumeCommand.md_name}</h3>
				<h5>님의 이력서 입니다.</h5>
			</div>
		</div>
		<div id="proprobarbar" class="col-lg-3 col-md-3">
			<div id="barProgress" style="position:relative;"><span style="position:absolute;margin-left:50%;" class="progress-label"></span></div>
			<div style="text-align:center;padding:10px;">                          
				<span>부족한 항목 : </span>              
				<span id="falta"></span>             
			</div>
		</div>
			<%-- <div class="col-lg-4 col-md-5 col-sm-5 col-xs-5">
				<h3>이력서 상세 내역 - 물방울 세상</h3>                                             
				<h5 style="color:gray;">*동그라미를 눌러 보세요!</h5>
			</div>
			<div class="col-lg-4 col-md-5 col-sm-5 col-xs-5 col-lg-offset-3 col-md-offset-2 col-sm-offset-1 col-xs-offset-1">
				<h3>${resumeCommand.md_name}</h3>
				<h5>님의 이력서 입니다.</h5>
			</div> --%>
	</div>            
</div>
<div class="row" id="backSmoke" style="background:url('${pageContext.request.contextPath}/resources/images/resume/resumeBack.png');background-size:cover">
	
	<div style="margin:10px 0 0 0">             
		<div>                                                          
			<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12 col-lg-offset-2 col-md-offset-2 col-sm-offset-1 col-xs-offset-1">
				<div class="tumbler btn btn-default col-lg-3 col-md-3 col-sm-3 col-xs-3 col-lg-offset-1 col-xs-offset-1" id="rG"><span><br>기본 내용</span></div>
			<c:if test="${!empty resumeCommand.rl_title||resumeCommand.rl_title ne null}">          
				<div class="tumbler btn btn-default col-lg-3 col-md-3 col-sm-3 col-xs-3 col-lg-offset-3 col-md-offset-5 col-sm-offset-3 col-xs-offset-1" id="rC"><span class="reDetail"><br>경력</span></div>
			</c:if>                             
			</div>                         
			<div class="col-lg-9 col-md-9 col-sm-12 col-xs-12 col-md-offset-2 col-sm-offset-1">
			<c:if test="${!empty resumeCommand.rc_title||resumeCommand.rc_title ne null}">
				<div class="tumbler btn btn-default col-lg-3 col-md-3 col-sm-3 col-xs-3 col-sm-offset-2 col-xs-offset-1" id="rA"><span class="reDetail"><br>수상<br>경력</span></div>
			</c:if>
			<c:if test="${!empty resumeCommand.a_title||resumeCommand.a_title ne null}">                   
				<div class="tumbler btn btn-default col-lg-3 col-md-3 col-sm-3 col-xs-3 col-lg-offset-6 col-md-offset-4 col-sm-offset-2 col-xs-offset-1" id="rAc"><span class="reDetail"><br>학력</span></div>
			</c:if>
			</div>                
			<div class="col-lg-4 col-md-6 col-sm-6 col-xs-8 col-lg-offset-4 col-md-offset-5 col-sm-offset-4 col-xs-offset-2">                      
				<div style="text-align:center">
				<c:if test="${fn:endsWith(resumeCommand.r_pname, '.jpg') ||                       
					  fn:endsWith(resumeCommand.r_pname, '.JPG') ||                 
					  fn:endsWith(resumeCommand.r_pname, '.gif') ||
					  fn:endsWith(resumeCommand.r_pname, '.GIF') ||
					  fn:endsWith(resumeCommand.r_pname, '.png') ||
					  fn:endsWith(resumeCommand.r_pname, '.PNG')}">
					<div class="col-lg-9 col-md-9 col-sm-12 col-xs-12"> 
						<img id="userFoto" class="resumeFoto" src="imageView.do?userId=${userId}">
					</div>
				</c:if>
				<c:if test="${empty resumeCommand.r_pname}">
					<img id="defaultFoto" class="resumeFoto" src="${pageContext.request.contextPath}/resources/images/blank-profile.png">
				</c:if>                 
					<span style="background-color:black;">
						<span class="col-lg-9 col-md-9 col-sm-12 col-xs-12"><b>작성일 : ${resumeCommand.r_date}</b></span>
						<span class="col-lg-9 col-md-9 col-sm-12 col-xs-12">    
							<a class="btn btn-default" href='${pageContext.request.contextPath}/resume/myResumeModifyForm.do'>수정</a>   
							<a class="btn btn-default" id="deleteConfirm" >삭제</a>    
						</span>
					</span>
				</div>
			</div> 
			<div class="col-lg-9 col-md-9 col-sm-12 col-xs-12 col-lg-offset-2 col-md-offset-2 col-sm-offset-1">      
				<c:if test="${!empty resumeCommand.h_name||resumeCommand.h_name ne null}">
					<div class="tumbler btn btn-default col-lg-3 col-md-3 col-sm-3 col-xs-3 col-lg-offset-1 col-xs-offset-1" id="rH"><span class="reDetail"><br>취미</span></div>
				</c:if>
				<c:if test="${!empty resumeCommand.l_name||resumeCommand.l_name ne null}">
					<div class="tumbler btn btn-default col-lg-3 col-md-3 col-sm-3 col-xs-3 col-lg-offset-5 col-md-offset-7 col-sm-offset-4 col-xs-offset-3" id="rL"><span class="reDetail"><br>자격증</span></div>
				</c:if>
			</div>                       
			<div>
				<c:if test="${!empty resumeCommand.fname||resumeCommand.fname ne null}">                     
					<div class="tumbler btn btn-default col-lg-3 col-md-3 col-sm-3 col-xs-3 col-lg-offset-5 col-md-offset-6 col-sm-offset-5 col-xs-offset-5" id="rF"><span class="reDetail"><br>포트<br>폴리오</span></div>
				</c:if>                       
			</div>              
		</div>
		<div id="rG_resume" style="display:none;">
			<h4 class="rG_sub"><b>기본정보</b></h4><br>
			<span class="rG_sub" id="r_loc">희망 근무지 :${resumeCommand.r_loc}</span><br>
			<span class="rG_sub" id="r_price">희망 급여 : ${resumeCommand.r_price}</span><br>    
			<span class="rG_sub" id="r_job">희망 업무 : ${resumeCommand.r_job}</span><br>   
			<span class="rG_sub" id="r_intro">자기 소개 : ${resumeCommand.r_intro}</span><br>
			<span class="rG_sub" id="r_guitar">기타 : ${resumeCommand.r_guitar}</span><br>        
		</div> 
		<div id="rA_resume" style="display:none" class="">
			<h4 class="rA_resume"><b>수상 내역</b></h4>
			<span class="rA_resume">수상명 : ${resumeCommand.rc_title}</span><br>
			<span class="rA_resume">수여 기관 : ${resumeCommand.rc_inst}</span><br>
			<span class="rA_resume">수상 연도 : ${resumeCommand.rc_year}</span><br>
			<span class="rA_resume">수상 내용 : ${resumeCommand.rc_content}</span><br>
		</div>
		<div id="rC_resume" style="display:none;" class="">
			<h4 class="rC_resume"><b>회사명 : ${resumeCommand.rl_title}</b></h4><br>
			<span class="rC_resume">직급 : ${resumeCommand.rl_position}</span><br>
			<span class="rC_resume">시작일 : ${resumeCommand.rl_sd}</span><br>
			<span class="rC_resume">종료일 : ${resumeCommand.rl_ed}</span><br>
			<span class="rC_resume">직무 내용 : ${resumeCommand.rl_def}</span><br>
		</div>
		
		<div id="rAc_resume" style="display:none;" class="">
			<h4><b>학력</b></h4>
			<span class="rAc_resume">학교명 : ${resumeCommand.a_title}</span><br>
			<span class="rAc_resume">졸업일 : ${resumeCommand.a_ed}</span><br>
			<span class="rAc_resume">학교 구분 : ${resumeCommand.a_grade}</span><br>                  
		</div>
		<div id="rH_resume" style="display:none" class="">
			<h4><b>취미</b></h4>
			<span class="rH_resume">취미 : ${resumeCommand.h_name}</span>
		</div>
		<div id="rL_resume" style="display:none" class="">
			<h4><b>자격증</b></h4>
			<span class="rL_resume">자격증 명 : ${resumeCommand.l_name}</span><br>
			<span class="rL_resume">발급 기관 : ${resumeCommand.l_com}</span><br>
			<span class="rL_resume">발급 연도 : ${resumeCommand.l_year}</span><br>
		</div>
		<div id="rF_resume" style="display:none" class="">
			<h4 class="rF_resume"><b>첨부 파일</b></h4>
			<c:if test="${!empty resumeCommand.fname}">
				첨부파일 : <a href="file.do?userId=${userId}">${resumeCommand.fname}</a>
			</c:if>
		</div>                      
	</div>
	
	<div id="conDelete" title="삭제 확인" style="display:none">
		<h1>잠깐만요!</h1>               
			<div>
				<div>지금 이력서를 지우려고 하시는 건가요?<br> 다시한번 생각해 보는건 어떠세요??</div>
				<p>
					지우기 위해선 비밀번호를 입력해 주세요
				</p>
				<div>
				<form action="myResumeDelete.do" method="post">
					<input type="password" id="password" name="password" placeholder="회원님의 비밀번호를 입력해 주세요." style="width:240px">
					<input type="submit" id="deleteResume" value="삭제">
				</form>
				</div>
			</div>
	</div>
</div>
<br>
<br>

    
    
    
