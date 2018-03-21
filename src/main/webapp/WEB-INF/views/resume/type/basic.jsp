<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/resume/resumeDetail.css">
<script src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/resume/resumeDetail.js"></script>
<div class="row">
	<div class="col-lg-8 col-md-10 col-sm-10 col-xs-10 col-lg-offset-2 col-md-offset-2 col-sm-offset-1 col-xs-offset-1">        
		<div id="proprotexttext" class="col-lg-4 col-md-4 col-lg-offset-1">
			<div>              
				<h4>이력서 상세 내역 - 기본</h4>                                             
				<span style="color:gray;">*bubble 혹은 standard도 이용해 보세요!</span>                    
			</div>                                  
		</div>                                         
		<div id="proproidid" class="col-lg-3 col-md-2"> 
			<div>                                               
				<h4>${resumeCommand.md_name}</h4>               
				<span>님의 이력서 입니다.</span>
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
	<div class="col-lg-11 col-md-10 col-sm-10 col-xs-12 col-lg-offset-1 col-md-offset-2 col-sm-offset-1">                   
  	<div class="col-lg-4 col-md-4 col-sm-10 col-xs-10 col-lg-offset-4 col-md-offset-2 col-sm-offset-3 col-xs-offset-1">
	  	<ul>
		<c:if test="${fn:endsWith(resumeCommand.r_pname, '.jpg') ||   
			  fn:endsWith(resumeCommand.r_pname, '.JPG') ||
			  fn:endsWith(resumeCommand.r_pname, '.gif') ||
			  fn:endsWith(resumeCommand.r_pname, '.GIF') ||
			  fn:endsWith(resumeCommand.r_pname, '.png') ||
			  fn:endsWith(resumeCommand.r_pname, '.PNG')}">                               
		  	<li>                     
			<div>                                                     
				<img src="${pageContext.request.contextPath}/user/imageView.do?userId=${resumeCommand.m_id}" style="max-width:180px">
			</div>
			</li>
		</c:if>
		<c:if test="${empty resumeCommand.r_pname}">
			<li>
				<div>                            
		    		<img style="width:200px;height:200px;object-fit:cover;border-radius:50%;overflow:hidden;" src="${pageContext.request.contextPath}/resources/images/resume/blank-profile.png" alt="">
	    		</div>
	    	</li>
	    </c:if>                    
		</ul>
	</div>
	<div class="col-lg-10 col-md-10 col-sm-12 col-xs-12 col-lg-offset-2">	
		<table>
			<tr>
				<td colspan="6" class="title">
					기본 내용
				</td>
			</tr>
			<tr>                                                                       
				<td colspan="2" class="title">희망 근무지</td>
				<td colspan="2" class="title">희망 급여</td>
				<td colspan="2" class="title">희망 업무</td>               
			</tr>
			<tr>                        
				<td colspan="2">${resumeCommand.r_loc}</td>
				<td colspan="2">${resumeCommand.r_price}</td>
				<td colspan="2">${resumeCommand.r_job}</td>
			</tr>                      
			<tr>                       
				<td colspan="3" class="title">기타</td>
				<td colspan="3" class="title">작성일</td>
			</tr>
			<tr>
				<td colspan="3">${resumeCommand.r_guitar}</td>
				<td colspan="3">${resumeCommand.r_date}</td>
			</tr>
			<tr><td class="borderSpace"></td></tr>
			<tr>
				<td colspan="6" class="title">자기 소개</td>
			</tr>                         
			<tr>
				<td colspan="6">${resumeCommand.r_intro}</td>                   
			</tr>
			<tr><td class="borderSpace"></td></tr>
			<tr>
				<td colspan="6" class="title">
					경력
				</td>
			</tr>
			<tr>
				<td class="title">회사명</td>
				<td colspan="2" class="title">직급</td>
				<td colspan="3" class="title">직무 내용</td>
			</tr>
			<tr>
				<td>${resumeCommand.rl_title}</td>
				<td colspan="2">${resumeCommand.rl_position}</td>
				<td colspan="3">${resumeCommand.rl_def}</td>
			</tr>
			<tr>
				<td colspan="3" class="title">입사 날짜</td>
				<td colspan="3" class="title">퇴사 날짜</td>
			</tr>
			<tr>
				<td colspan="3">${resumeCommand.rl_sd}</td>
				<td colspan="3">${resumeCommand.rl_ed}</td>
			</tr>
			<tr><td class="borderSpace"></td></tr>
			<tr>
				<td colspan="6" class="title">수상 내역</td>
			</tr>
			<tr>
				<td colspan="3" class="title">수상 명</td>
				<td colspan="3" class="title">수상 기관</td>
			</tr>
			<tr>
				<td colspan="3">${resumeCommand.rc_title}</td>
				<td colspan="3">${resumeCommand.rc_inst}</td>
			</tr>
			<tr><td class="borderSpace"></td></tr>
			<tr>
				<td colspan="6" class="title">
					학력
				</td>
			</tr>
			<tr>
				<td colspan="2" class="title">학교명</td>
				<td colspan="3" class="title">졸업일</td>
				<td class="title">학교 구분</td>
			</tr>
			<tr>
				<td colspan="2"> ${resumeCommand.a_title}</td>
				<td colspan="3">${resumeCommand.a_ed}</td>
				<td>${resumeCommand.a_grade}</td>
			</tr>
			<tr><td class="borderSpace"></td></tr>
			<tr>
				<td colspan="6" class="title">취미</td>
			</tr>
			<tr>
				<td colspan="6">${resumeCommand.h_name}</td>
			</tr>
			<tr><td class="borderSpace"></td></tr>
			<tr>
				<td colspan="6" class="title">
					자격증
				</td>
			</tr>
			<tr>
				<td class="title">자격증 명</td>
				<td colspan="2" class="title">발급 기관</td>
				<td colspan="3" class="title">발급 연도</td>
			</tr>
			<tr>
				<td>${resumeCommand.l_name}</td>
				<td colspan="2">${resumeCommand.l_com}</td>
				<td colspan="3">${resumeCommand.l_year}</td>
			</tr>
			<tr><td class="borderSpace"></td></tr>
			<tr>
				<td colspan="6" class="title">포트 폴리오</td>
			</tr>
			<tr>
				<td colspan="6">첨부파일 : <a href="file.do?userId=${userId}">${resumeCommand.fname}</a></td>
			</tr>
			<c:if test="${userGrade>=20&&userGrade<30}">
			<tr><td class="borderSpace"></td></tr>
			<tr>
				<td colspan="6" class="borderSpace">			
					
					<c:if test="${finger==0}"><a href="#" class="btn btn-default" id="likeResume"><img id="imgSize" src="${pageContext.request.contextPath}/resources/images/resume/unLike.png"><span>관심 이력서 등록</span></a></c:if>
					<c:if test="${finger==1}"><a href="#" class="btn btn-default" id="likeResume"><img id="imgSize" src="${pageContext.request.contextPath}/resources/images/resume/liked.png"><span>관심 이력서 등록</span></a></c:if>
				</td>              
			</tr>
			<tr>
				<td colspan="6" class="borderSpace">
					<input type="text" id="emailCopy" value="${resumeCommand.m_id}" style="width:200px;text-align:center;" readonly> 
					<input type="button" class="btn btn-default" id="clipboard" onclick="copyClipboard()" value="이메일 복사">                               
				</td>
			</tr>
			</c:if>
			<c:if test="${userId eq resumeCommand.m_id}">
			<tr><td class="borderSpace"></td></tr>
			<tr>
				<td colspan="6" class="borderSpace">                
					<span class="col-lg-12 col-md-12 col-sm-12 col-xs-12">    
						<a class="btn btn-default" href='${pageContext.request.contextPath}/resume/myResumeModifyForm.do'>수정</a>   
						<a class="btn btn-default" id="deleteConfirm" >삭제</a>    
					</span>
				</td>
			</tr>
			</c:if>              
		</table>
	</div>
	</div>
</div>

    
    
    
