<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui.min.css">
<script src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/resume/resumeDetail.js"></script>
<script>

</script>
<div>                                        
	<div id="showResumeDetail">                   
	<table>                  
		<tr>
			<td>                
				<div class="resumeHeader col-lg-10 col-md-9 col-sm-12 col-xs-12 col-lg-offset-3 col-md-offset-2 col-sm-offset-1">       
					                 
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
			</td>
		</tr>
		<tr>
			<td class="resumeContent">      
				   
				<div id="rG_resume" class="col-lg-9 col-md-9 col-sm-10 col-xs-12 col-lg-offset-4 col-md-offset-3 col-sm-offset-2 col-xs-offset-1">
					<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
						희망 근무지 : ${resumeCommand.r_loc}<br>
						희망 급여 : ${resumeCommand.r_price}<br>    
						희망 업무 : ${resumeCommand.r_job}<br>   
						자기 소개 : ${resumeCommand.r_intro}<br>
						기타 : ${resumeCommand.r_guitar}<br>        
					</div>      
					<div id="photoRe"class="col-lg-5 col-md-5 col-sm-5 col-xs-5 col-lg-offset-2 col-md-offset-2 col-sm-offset-2 col-xs-offset-1">               
						<c:if test="${fn:endsWith(resumeCommand.r_pname, '.jpg') ||   
							  fn:endsWith(resumeCommand.r_pname, '.JPG') ||
							  fn:endsWith(resumeCommand.r_pname, '.gif') ||
							  fn:endsWith(resumeCommand.r_pname, '.GIF') ||
							  fn:endsWith(resumeCommand.r_pname, '.png') ||
							  fn:endsWith(resumeCommand.r_pname, '.PNG')}">
							<div class="align-center">
							등록하신 사진 : <br>
								<img src="${pageContext.request.contextPath}/user/imageView.do?userId=${resumeCommand.m_id}" style="max-width:180px">
							</div>
						</c:if>
						<c:if test="${empty resumeCommand.r_pname}">            
		          			<img style="width:200px;height:200px;object-fit:cover;display:inline-block;border-radius:50%;overflow:hidden;" src="${pageContext.request.contextPath}/resources/images/blank-profile.png" alt="">
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
				<div id="rAc_resume" style="display:none;" class="col-lg-9 col-md-9 col-sm-10 col-xs-10 col-lg-offset-5 col-md-offset-3 col-sm-offset-2 col-xs-offset-2">
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
		<c:if test="${userGrade>=20}">
			<tr>
				<td>
					<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 col-lg-offset-8 col-md-offset-6 col-sm-offset-6 col-xs-offset-6">
						<a href="#" class="btn btn-default" id="likeResume">관심 이력서 등록</a>
					</div>
				</td>              
			</tr>
		</c:if>
		<tr>
			<td>                                  
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 col-lg-offset-7 col-md-offset-4 col-sm-offset-2 col-xs-offset-1">
					<input type="text" id="emailCopy" value="${resumeCommand.m_id}" style="width:200px;text-align:center;" readonly> 
					<input type="button" class="btn btn-default" id="clipboard" onclick="copyClipboard()" value="이메일 복사">                               
				</div>              
			</td>                            
		</tr>                               
		<tr>
			<td>      
				<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 col-lg-offset-8 col-md-offset-6 col-sm-offset-6 col-xs-offset-6">작성일 : ${resumeCommand.r_date}</div>
			</td>   
		</tr>
		<tr>   
		</tr>
	</table>
	</div>
</div>

    
    
    
