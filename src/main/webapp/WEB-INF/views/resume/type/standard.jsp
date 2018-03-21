<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/resume/styleResume.css">
<script src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/resume/resumeDetail.js"></script>
<div class="row">
	<div class="col-lg-8 col-md-11 col-sm-10 col-xs-10 col-lg-offset-3 col-md-offset-1 col-sm-offset-1 col-xs-offset-1">        
		<div id="proprotexttext" class="col-lg-4 col-md-4">
			<div>                    
				<h3>이력서 상세 내역 - 표준</h3>                                             
				<h5 style="color:gray;">*바를 클릭해 보세요!</h5>                    
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
	</div>            
</div>
<div class="row">                                        
	<div id="showResumeDetail">                   
    	<div class="row">                                                    
			<div class="resumeHeader col-lg-10 col-md-11 col-sm-12 col-xs-12 col-lg-offset-2 col-md-offset-1 col-sm-offset-1 col-xs-offset-1">
				<div class="col-lg-9 col-md-11 col-sm-11 col-xs-12 col-lg-offset-1">
				<ul>                
					<li><a href="#" class="col-lg-12 col-md-12 col-sm-12 col-xs-12 btn btn-default" id="rG"><span class="reDetail">기본 이력서 내용</span></a></li>
					<c:if test="${!empty resumeCommand.rl_title||resumeCommand.rl_title ne null}">
						<li><a href="#" class="col-lg-2 col-md-2 col-sm-2 col-xs-6 btn btn-default" id="rC"><span class="reDetail">경력</span></a></li>
					</c:if>
					<c:if test="${!empty resumeCommand.rc_title||resumeCommand.rc_title ne null}">
						<li><a href="#" class="col-lg-2 col-md-2 col-sm-2 col-xs-6 btn btn-default" id="rA"><span class="reDetail">수상 경력</span></a></li>
					</c:if>
					<c:if test="${!empty resumeCommand.a_title||resumeCommand.a_title ne null}">
						<li><a href="#" class="col-lg-2 col-md-2 col-sm-2 col-xs-6 btn btn-default" id="rAc"><span class="reDetail">학력</span></a></li>
					</c:if>      
					<c:if test="${!empty resumeCommand.h_name||resumeCommand.h_name ne null}">
						<li><a href="#" class="col-lg-2 col-md-2 col-sm-2 col-xs-6 btn btn-default" id="rH"><span class="reDetail">취미</span></a></li>
					</c:if>
					<c:if test="${!empty resumeCommand.l_name||resumeCommand.l_name ne null}">
						<li><a href="#" class="col-lg-2 col-md-2 col-sm-2 col-xs-6 btn btn-default" id="rL"><span class="reDetail">자격증</span></a></li>
					</c:if>
					<c:if test="${!empty resumeCommand.fname||resumeCommand.fname ne null}">   
						<li><a href="#" class="col-lg-2 col-md-2 col-sm-2 col-xs-6 btn btn-default" id="rF"><span class="reDetail">포트 폴리오</span></a></li>
					</c:if>
					<li></li>
				</ul>
				</div>
			</div>
			</div>
		</div>
		<div class="row">
		<table>
		<tr>
			<td class="resumeContent">                                 
				   
				<div id="rG_resume" class="col-lg-10 col-md-11 col-sm-10 col-xs-10 col-lg-offset-5 col-md-offset-2 col-sm-offset-2 col-xs-offset-2">
					<div class="col-lg-3 col-md-4 col-sm-4 col-xs-10 col-lg-offset-1" style="margin:10px;">
						희망 근무지 : ${resumeCommand.r_loc}<br>
						희망 급여 : ${resumeCommand.r_price}<br>    
						희망 업무 : ${resumeCommand.r_job}<br>   						                       
						기타 : ${resumeCommand.r_guitar}<br>        
					</div>                                               
					                    
					<div id="photoRe"class="col-lg-4 col-md-4 col-sm-4 col-xs-12 col-lg-offset-1 col-md-offset-2 col-sm-offset-2 col-xs-offset-1">               
						<c:if test="${fn:endsWith(resumeCommand.r_pname, '.jpg') ||   
							  fn:endsWith(resumeCommand.r_pname, '.JPG') ||
							  fn:endsWith(resumeCommand.r_pname, '.gif') ||
							  fn:endsWith(resumeCommand.r_pname, '.GIF') ||
							  fn:endsWith(resumeCommand.r_pname, '.png') ||
							  fn:endsWith(resumeCommand.r_pname, '.PNG')}">
							<div class="align-center">
							등록하신 사진 : <br>
								<img src="${pageContext.request.contextPath}/user/imageView.do?userId=${resumeCommand.m_id}" style="width:200px;height:200px;object-fit:cover;display:inline-block;border-radius:50%;overflow:hidden;">
							</div>
						</c:if>
						<c:if test="${empty resumeCommand.r_pname}">            
		          			<img style="width:200px;height:200px;object-fit:cover;display:inline-block;border-radius:50%;overflow:hidden;" src="${pageContext.request.contextPath}/resources/images/resume/blank-profile.png" alt="">
	          			</c:if>
					</div>
				</div>
				<div id="rC_resume" style="display:none;" class="col-lg-9 col-md-9 col-sm-10 col-xs-10 col-lg-offset-5 col-md-offset-3 col-sm-offset-2 col-xs-offset-2">
					회사명 : ${resumeCommand.rl_title}<br>
					직급 : ${resumeCommand.rl_position}<br>
					시작일 : ${resumeCommand.rl_sd}<br>
					종료일 : ${resumeCommand.rl_ed}<br>
					직무 내용 : ${resumeCommand.rl_def}<br>
				</div>
				<div id="rA_resume" style="display:none" class="col-lg-9 col-md-9 col-sm-10 col-xs-10 col-lg-offset-5 col-md-offset-3 col-sm-offset-2 col-xs-offset-2">
					수상명 : ${resumeCommand.rc_title}<br>
					수여 기관 : ${resumeCommand.rc_inst}<br>
					수상 연도 : ${resumeCommand.rc_year}<br>
					수상 내용 : ${resumeCommand.rc_content}<br>
				</div>
				<div id="rAc_resume" style="display:none;background:yellow;" class="col-lg-9 col-md-9 col-sm-10 col-xs-10 col-lg-offset-5 col-md-offset-3 col-sm-offset-2 col-xs-offset-2">
					학교명 : ${resumeCommand.a_title}<br>
					졸업일 : ${resumeCommand.a_ed}<br>
					학교 구분 : ${resumeCommand.a_grade}<br>
				</div>
				<div id="rH_resume" style="display:none" class="col-lg-9 col-md-9 col-sm-10 col-xs-10 col-lg-offset-5 col-md-offset-3 col-sm-offset-2 col-xs-offset-2">
					취미 : ${resumeCommand.h_name}
				</div>
				<div id="rL_resume" style="display:none" class="col-lg-9 col-md-9 col-sm-10 col-xs-10 col-lg-offset-5 col-md-offset-3 col-sm-offset-2 col-xs-offset-2">
					자격증 명 : ${resumeCommand.l_name}<br>
					발급 기관 : ${resumeCommand.l_com}<br>
					발급 연도 : ${resumeCommand.l_year}<br>
				</div>
				<div id="rF_resume" style="display:none" class="col-lg-9 col-md-9 col-sm-10 col-xs-10 col-lg-offset-5 col-md-offset-3 col-sm-offset-2 col-xs-offset-2">
					<c:if test="${!empty resumeCommand.fname}">
						첨부파일 : <a href="file.do?userId=${userId}">${resumeCommand.fname}</a>
					</c:if>
				</div>                
			</td>                           
		</tr>
		<tr>
			<td>             
				<div class="container">            
				<div id="selfIntro" class="col-lg-10 col-md-9 col-sm-10 col-xs-10 col-lg-offset-4 col-md-offset-3 col-sm-offset-2 col-xs-offset-2">               
					<div class="col-lg-8 col-md-8 col-sm-10 col-xs-10 col-lg-offset-5 col-md-offset-3 col-sm-offset-2 col-xs-offset-2">
						<h4 id="introName">자기 소개</h4>  
					</div>        
					<div class="col-lg-8 col-md-8 col-sm-10 col-xs-10">
						<c:if test="${empty resumeCommand.r_intro}">아직 작성된 자기 소개 항목을 작성하지 않았습니다.</c:if>
						<span>${resumeCommand.r_intro}</span>
					</div>
				</div>
				</div>          
			</td>
		</tr>
		<c:if test="${userGrade>=20&&userGrade<30}">
			<tr>
				<td>
					<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 col-lg-offset-8 col-md-offset-5 col-sm-offset-5 col-xs-offset-4">
						<c:if test="${finger==0}"><a href="#" class="btn btn-default" id="likeResume"><img id="imgSize" src="${pageContext.request.contextPath}/resources/images/resume/unLike.png"><span>관심 이력서 등록</span></a></c:if>
						<c:if test="${finger==1}"><a href="#" class="btn btn-default" id="likeResume"><img id="imgSize" src="${pageContext.request.contextPath}/resources/images/resume/liked.png"><span>관심 이력서 등록</span></a></c:if>
					</div>            
				</td>                          
			</tr>
		</c:if>                                            
		<tr>
			<td>                                  
				<div class="col-lg-5 col-md-5 col-sm-8 col-xs-10 col-lg-offset-7 col-md-offset-4 col-sm-offset-4 col-xs-offset-2">
					<input type="text" id="emailCopy" value="${resumeCommand.m_id}" style="width:200px;text-align:center;" readonly> 
					<input type="button" class="btn btn-default" id="clipboard" onclick="copyClipboard()" value="이메일 복사">                               
				</div>
			</td>                            
		</tr>                               
		<tr>
			<td>      
				<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 col-lg-offset-8 col-md-offset-6 col-sm-offset-5 col-xs-offset-5">작성일 : ${resumeCommand.r_date}</div>
			</td>   
		</tr>
		<tr>
			<c:if test="${userId eq resumeCommand.m_id}">
				<td>                 
					<span class="col-lg-9 col-md-9 col-sm-12 col-xs-12 col-lg-offset-8 col-md-offset-6 col-sm-offset-6 col-xs-offset-6">    
						<a class="btn btn-default" href='${pageContext.request.contextPath}/resume/myResumeModifyForm.do'>수정</a>   
						<a class="btn btn-default" id="deleteConfirm" >삭제</a>    
					</span>
				</td>
			</c:if>   
		</tr>
	</table>
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
</div>

    
    
    
