<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/resume/styleResumeForm.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/resume/checkModiForm.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/resume/resumeForm.js"></script>
<div class="row">
	<div>
	<div style="margin-left:28%">  
		<h1>이력서 수정</h1>
		<div style="color:gray">*변경하시게 되면 이전 데이터는 사라집니다.</div>
	</div>
	<br>
	<form:form commandName="resumeCommand" action="myResumeModify.do" id="myResumeModify" method="post" enctype="multipart/form-data">
		<form:errors element="div" cssClass="error-color"/>
		<ul class="big-list resumeForm">
			<!-- 필수 항목 시작 -->
			<li>
			<div>
				<label for="md_name">이름</label>
				<input id="md_name" name="md_name" type="text" value="${resumeCommand.md_name}">
				
			</div>
			</li>
			<li>
			<div>
				<label for="md_phone">전화번호</label>
				<input type="number" id="md_phone" name="md_phone" value="${resumeCommand.md_phone}">
				
			</div>
			</li>
			<li>
			<div>
				<label for="r_loc">원하는 근무지</label>
				<input id="r_loc" name="r_loc" type="text" value="${resumeCommand.r_loc}"/>
				
			</div>
			</li>
			<!-- 이력서 항목 없어도 되는 항목 시작 -->
			
						<li>
							<input type="checkbox" id="select_price" value="Select">Price
						</li>
						<li>
							<label for="r_price">희망 급여</label>
							<input type="number" id="r_price" name="r_price" value="${resumeCommand.r_price}" <c:if test="${empty resumeCommand.r_price}">disabled="disabled"</c:if>>
						</li>
						<li>
							<input type="checkbox" id="select_job" value="Job">Job
						</li>
						<li> 
							<label for="r_job">희망 업무</label>
							<input id="r_job" name="r_job" type="text" value="${resumeCommand.r_job}" <c:if test="${empty resumeCommand.r_job}">disabled="disabled"</c:if>/>
						</li>
						<li>
							<input type="checkbox" id="select_intro" value="Ing">Ing...
						</li>           
						<li>                                                               
							<div class="col-lg-12 col-md-10 col-sm-12 col-xs-12">                             
								<label for="r_intro"><b>자기 소개</b></label>           
								<textarea id="r_intro" name="r_intro" rows="8" cols="60" style="resize:none;"<c:if test="${empty resumeCommand.r_intro}">disabled="disabled"</c:if>>${resumeCommand.r_intro}</textarea>
							</div>         
						</li>
						<li>
						<input type="checkbox" id="select_guitar" value="ETC">ETC.
						</li>
						<li>
							<label for="r_guitar">기타(어떤 말이든지 좋아요!!)</label>
							<input id="r_guitar" name="r_guitar" type="text" value="${resumeCommand.r_guitar}" <c:if test="${empty resumeCommand.r_guitar}">disabled="disabled"</c:if>/>
						</li>                   
						<li>
						<input type="checkbox" id="select_pic" value="Photo">Photo
						</li>
						<li>
							<label for="r_picture">이력서 사진</label>
							<input type="file" id="r_picture" name="r_picture" value="${resumeCommand.r_picture}" <c:if test="${empty resumeCommand.r_pname}">disabled="disabled"</c:if>>
							<c:if test="${empty resumeCommand.r_pname}">
								<br>
                    	<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 col-lg-offset-3 col-md-offset-3 col-sm-offset-2 col-xs-offset-2">
							<table>                                       
								<tr>                 
									<td>	
									&quot;<span class="r_pname">등록된 파일이 없습니다.</span>&quot;
									</td>
								</tr>
							</table>
						</div>
							</c:if>         
							<c:if test="${!empty resumeCommand.r_pname}">
								<br>	                      
 						<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 col-lg-offset-5 col-md-offset-3 col-sm-offset-2 col-xs-offset-2">
							<table>                     
								<tr>                                      
									<td>          
									&quot;<span class="r_pname">${resumeCommand.r_pname}이 등록 되어 있습니다.</span>&quot;
									<br>
									&quot;변경을 원할 시에는 다른 사진을 업로드 해주세요.&quot;
									</td>
								</tr>
							</table>                     
						</div>
							</c:if>
						</li>
					
			<!-- 이력서 항목 없어도 되는 항목 끝 -->
			<!-- 필수 항목 끝 -->
			<!-- 캐리어 시작 -->
			
					<li>
						<input type="checkbox" id="rl_checkCareer" value="Career">Career
					</li>
					<li>
						<label for="rl_title">회사명</label>
						<input type="text" name="rl_title" id="rl_title" value="${resumeCommand.rl_title}" <c:if test="${empty resumeCommand.rl_title }">disabled="disabled"</c:if>>
					</li>
					<li>
						<label for="rl_position">직급</label>
						<input type="text" name="rl_position" id="rl_position" value="${resumeCommand.rl_position}" <c:if test="${empty resumeCommand.rl_position}">disabled="disabled"</c:if>/>
					</li>
					<li>
						<label for="rl_sd">시작일</label>
						<input type="date" name="rl_sd" id="rl_sd" value="${resumeCommand.rl_sd}" <c:if test="${empty resumeCommand.rl_sd }">disabled="disabled"</c:if>/>
					</li>
					<li>
						<label for="rl_ed">종료일</label>
						<input type="date" name="rl_ed" id="rl_ed" value="${resumeCommand.rl_ed}" <c:if test="${empty resumeCommand.rl_ed}">disabled="disabled"</c:if>/>
					</li>
					<li>
						<label for="rl_def">직무 내용</label>
						<input type="text" name="rl_def" id="rl_def" value="${resumeCommand.rl_def}" <c:if test="${empty resumeCommand.rl_def}">disabled="disabled"</c:if>/>
					</li>
					
			<!-- 캐리어 끝 -->
			<!-- 수상 경력 시작 -->
			
					<li>
						<input type="checkbox" id="rc_checkAwards" value="Awards">Awards
					</li>
					<li>
						<label for="rc_title">수상명</label>
						<input id="rc_title" name="rc_title" type="text" value="${resumeCommand.rc_title}" <c:if test="${empty resumeCommand.rc_title}">disabled="disabled"</c:if>/>
					</li>
					<li>
						<label for="rc_inst">수여 기관</label>
						<input id="rc_inst" name="rc_inst" type="text" value="${resumeCommand.rc_inst}" <c:if test="${empty resumeCommand.rc_inst}">disabled="disabled"</c:if>/>
					</li>
					<li>
						<label for="rc_year">수상 연도</label>
						<input type="date" id="rc_year" name="rc_year" value="${resumeCommand.rc_year}" <c:if test="${empty resumeCommand.rc_year}">disabled="disabled"</c:if>>
					</li>
					<li>
						<label for="rc_content">수상 내용</label>
						<input id="rc_content" name="rc_content" type="text" value="${resumeCommand.rc_content}" <c:if test="${empty resumeCommand.rc_content}">disabled="disabled"</c:if>/>
					</li>
				
			<!-- 수상 경력 끝 -->
			<!-- 학력 시작 -->
			
						<li>
							<input type="checkbox" id="a_checkAchieve" value="Achieve">Achieve
						</li>
						<li>
							<label for="a_grade">학교 구분(최종 학력)</label>
							<select name="a_grade" <c:if test="${empty resumeCommand.a_grade}">disabled="disabled"</c:if>>     
								<option value="초등학교(중퇴)">초등학교(중퇴)</option>
								<option value="초등학교(졸)">초등학교(졸)</option>
								<option value="중학교(중퇴)">중학교(중퇴)</option>
								<option value="중학교(졸)">중학교(졸)</option>
								<option value="고등학교(중퇴)">고등학교(중퇴)</option>
								<option value="고등학교(졸)">고등학교(졸)</option>
								<option value="대학교(중퇴)">대학교(중퇴)</option>
								<option value="대학교(졸)">대학교(졸)</option>
								<option value="대학원(중퇴)">대학원(중퇴)</option>
								<option value="대학원(졸)">대학원(졸)</option>
							</select>
						</li>
						<li>
							<label for="a_title">학교명</label>
							<input id="a_title" name="a_title" type="text" value="${resumeCommand.a_title}" <c:if test="${empty resumeCommand.a_title}">disabled="disabled"</c:if>/>
						</li>
						<li>
							<label for="a_ed">졸업일</label>
							<input type="date" id="a_ed" name="a_ed" value="${resumeCommand.a_ed}"<c:if test="${empty resumeCommand.a_ed}"> disabled="disabled"</c:if>>
						</li>
						<li>
							<br>
						</li>
					
			<!-- 학력 끝 -->
			<!-- 취미 시작 -->
			
						<li> 
							<input type="checkbox" id="h_checkHobby" value="Hobby">Hobby
						</li>
						<li>
							<label for="h_name">취미</label>
							<input id="h_name" name="h_name" type="text" value="${resumeCommand.h_name}" <c:if test="${empty resumeCommand.h_name}">disabled="disabled"</c:if>/>
						</li>
					
			<!-- 취미 끝 -->
			<!-- 자격증 시작 -->
			
						<li>
							<input type="checkbox" id="l_checkLicense" value="License">License
						</li>
						<li>
							<label for="l_name">이름</label>
							<input id="l_name" name="l_name" type="text" value="${resumeCommand.l_name}" <c:if test="${empty resumeCommand.l_name}">disabled="disabled"</c:if>/>
						</li>
						<li>
							<label for="l_com">발급 기관</label>
							<input id="l_com" name="l_com" type="text" value="${resumeCommand.l_com}" <c:if test="${empty resumeCommand.l_com}">disabled="disabled"</c:if>/>
						</li>
						<li>
							<label>발급 연도</label>
							<input type="date" id="l_year" name="l_year" value="${resumeCommand.l_year}" <c:if test="${empty resumeCommand.l_year}">disabled="disabled"</c:if>>
						</li>
					
			<!-- 자격증 끝 -->
			<!-- 파일 시작 -->
			
						<li>
							<input type="checkbox" id="f_checkPortfolio" value="Portfolio">Portfolio
						</li>
						<li>
							<label for="fFile">파일</label>
							<input type="file" id="fFile" name="fFile" value="${resumeCommand.fFile}" <c:if test="${empty resumeCommand.fname}">disabled="disabled"</c:if>>
							<c:if test="${empty resumeCommand.fname}">
								<br>	
								<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 col-lg-offset-5 col-md-offset-3 col-sm-offset-2 col-xs-offset-2">  
									<table>
										<tr>
											<td>	
											&quot;<span id="fname">등록된 파일이 없습니다.</span>&quot;
										</tr>
									</table>
								</div>
							</c:if>
							<c:if test="${!empty resumeCommand.fname}">
								<br>	
								<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 col-lg-offset-5 col-md-offset-3 col-sm-offset-2 col-xs-offset-2">  
									<table>
										<tr>  
											<td>	
											&quot;<span id="fname">${resumeCommand.fname}이 등록 되어 있습니다.</span>&quot;
											<br>
											&quot;변경을 원할 시에는 다른 파일을 업로드 해주세요.&quot;
											</td>
										</tr>
									</table>
								</div>
							</c:if>
						</li>
					
			<!-- 파일 끝 -->
		
						<li style="height:50px">
							<div id="submitButton">       
								<input type="submit" class="submitButton" value="작성 완료">
								<input type="button" value="Home" class="homeButton" onclick="location.href='${pageContext.request.contextPath}/main/main.do'">
							</div>
						</li>
		</ul>
	</form:form>
	</div>
</div> --%>









<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/resume/styleResumeForm.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/resume/checkForm.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/resume/resumeForm.js"></script>
<div class="row">
	<div class="row">
		<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 col-lg-offset-3 col-md-offset-3 col-sm-offset-2 col-xs-offset-2">          
			<h1>이력서 작성</h1>
			<div><span class="optionSpan">*변경하신 내용은 삭제 됩니다. (변경하시지 않은 내용은 그대로 반영 됩니다.)</span></div>
		</div>
	</div>
	<form:form commandName="resumeCommand" action="myResumeModify.do" id="myResumeModify" method="post" enctype="multipart/form-data">
		<form:errors element="div" cssClass="error-color"/>
		<div class="row">
			<ul class="big-list resumeForm size">               
				<!-- 필수 항목 시작 -->     
				<li>
					<strong style="margin:5px">이력서 노출 형태 선택 </strong>
					<div>                     
						<input type="radio" name="publicType" id="public" value="public" style="margin:4px;"<c:if test="${resumeCommand.publicType eq 'public'}">checked="checked"</c:if>>전체 공개 
						<input type="radio" name="publicType" id="onlyEnter" value="onlyEnter" style="margin:4px;"<c:if test="${resumeCommand.publicType eq 'onlyEnter'}">checked="checked"</c:if>>기업 공개 
						<input type="radio" name="publicType" id="private" value="private" style="margin:4px;"<c:if test="${resumeCommand.publicType eq 'private'}">checked="checked"</c:if>>회원끼리만 공개
						<input type="radio" name="publicType" id="default" value="default" style="margin:4px;">비공개  
					</div>                  
				</li>                              
				<li>
					<strong style="margin:5px;">이력서 타입 선택</strong>
					<div>
						<input type="radio" name="r_type" id="r_type" value="bubble">bubble
						<input type="radio" name="r_type" id="r_type" value="standard" checked="checked">standard
						<input type="radio" name="r_type" id="r_type" value="basic">basic
					</div>
				</li>
				<li>
					<div>
						<label for="md_name">이름</label>
						<input id="md_name" name="md_name" type="text" value="${resumeCommand.md_name}">
					</div>
				</li>
				<li>
					<div>
						<label for="md_phone">전화번호</label>
						<input type="number" id="md_phone" name="md_phone" value="${resumeCommand.md_phone}">
					</div>
				</li>
				<li>
					<div>
						<label for="r_loc">원하는 근무지</label>
						<%-- <input id="r_loc" type="text" name="r_loc" value="${resumeCommand.r_loc}"> --%>
						<select name="r_loc">
							<option value="전국">전국</option>
							<option value="서울">서울</option>
							<option value="경기">경기</option>
							<option value="강원도">강원도</option>
							<option value="광주">광주</option>
							<option value="대구">대구</option>
							<option value="대전">대전</option>
							<option value="부산">부산</option>
							<option value="울산">울산</option>
							<option value="인천">인천</option>
							<option value="경남">경남</option>
							<option value="경북">경북</option>
							<option value="전남">전남</option>
							<option value="전북">전북</option>
							<option value="충남">충남</option>
							<option value="충북">충북</option>
							<option value="제주">제주</option>
							<option value="세종">세종</option>
							<option value="아시아">아시아</option>
							<option value="아메리카">아메리카</option>
							<option value="유럽">유럽</option>
							<option value="호주">호주</option>
							<option value="아프리카">아프리카</option>
							<option value="호주">호주</option>
							<option value="기타">기타</option>
						</select>
					</div>
				</li>
				<!-- 이력서 항목 없어도 되는 항목 시작 -->
	
				</ul>
		</div>
			<div class="row">
				<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 col-lg-offset-3 col-md-offset-3 col-sm-offset-2 col-xs-offset-2">
					<div id="select_price" class="btn btn-default slideButtonToggle">
						Price
					</div>
					<span class="optionSpan">*원하시는 급여를 입력해 주세요.</span>
				</div>                                       
			</div>             
			<div id="r_price_content" <c:if test="${empty resumeCommand.r_price||resumeCommand.r_price eq null}">style="display:none"</c:if>>
				<ul class="big-list resumeForm size">
					<li>
						<label for="r_price">희망 급여</label>
						<input type="number" id="r_price" name="r_price" value="${resumeCommand.r_price}" <c:if test="${empty resumeCommand.r_price||resumeCommand.r_price eq null}">disabled="disabled"</c:if>>
					</li>
				</ul>
			</div>
			<div class="row">
				<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 col-lg-offset-3 col-md-offset-3 col-sm-offset-2 col-xs-offset-2">
					<div id="select_job" class="btn btn-default slideButtonToggle">
						Job                                
					</div>      
					<span class="optionSpan">*원하시는 업무 내용을 입력해 주세요.</span>                                                
				</div>
			</div>               
				<div id="r_job_content" <c:if test="${empty resumeCommand.r_job||resumeCommand.r_job eq null}">style="display:none;"</c:if>>
					<ul class="big-list resumeForm size">
						<li>                   
							<label for="r_job">희망 업무</label>
							<input id="r_job" name="r_job" type="text" value="${resumeCommand.r_job}" <c:if test="${empty resumeCommand.r_job||resumeCommand.r_job eq null}">disabled="disabled"</c:if>>
						</li>
					</ul>
				</div>
			<div class="row">
				<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 col-lg-offset-3 col-md-offset-3 col-sm-offset-2 col-xs-offset-2">
					<div id="select_guitar" class="btn btn-default slideButtonToggle">
						ETC.
					</div>
					<span class="optionSpan">*원하시는 내용을 입력해 주세요.</span>
				</div>
			</div>
				<div id="r_guitar_content" <c:if test="${empty resumeCommand.r_guitar||resumeCommand.r_guitar eq null}">style="display:none"</c:if>>
					<ul class="big-list resumeForm size">
						<li>
							<label for="r_guitar">기타(어떤 말이든지 좋아요!!)</label>
							<input id="r_guitar" name="r_guitar" type="text" value="${resumeCommand.r_guitar}" <c:if test="${empty resumeCommand.r_guitar||resumeCommand.r_guitar eq null}">disabled="disabled"</c:if>>
						</li>                
					</ul>             
				</div>
			<div class="row">
				<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 col-lg-offset-3 col-md-offset-3 col-sm-offset-2 col-xs-offset-2">
			<div id="select_pic" class="btn btn-default slideButtonToggle">
				Photo
			</div>
			<span class="optionSpan">*회원님의 사진을 올려 주세요.</span>
			</div>
			</div>
			<div id="r_picture_content" style="display:none;">
				<ul class="big-list resumeForm size">
					<li>                   
						<label for="r_picture">이력서 사진</label>
						<input type="file" id="r_picture" name="r_picture" value="${resumeCommand.r_picture}" disabled="disabled">
					</li>
				</ul>
			</div>
			<div>				
				<c:if test="${empty resumeCommand.r_pname}">
				<ul class="big-list resumeForm size">
					<li>                   
                    	<div>
							&quot;<span class="r_pname">등록된 파일이 없습니다.</span>&quot;		
						</div>
					</li>            
				</ul>
				</c:if>
				<c:if test="${!empty resumeCommand.r_pname}">
				<ul class="big-list resumeForm size">
					<li>                                  
 						<div>          
							&quot;<span class="r_pname">${resumeCommand.r_pname}이 등록 되어 있습니다.</span>&quot;
							<br>
							&quot;변경을 원할 시에는 다른 사진을 업로드 해주세요.&quot;               
						</div>
					</li>
				</ul>
				</c:if>
			</div>
	
				<!-- 이력서 항목 없어도 되는 항목 끝 -->
				<!-- 필수 항목 끝 -->
				<!-- 캐리어 시작 -->
			<div class="row">
				<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 col-lg-offset-3 col-md-offset-3 col-sm-offset-2 col-xs-offset-2">
			<div id="rl_checkCareer" class="btn btn-default slideButtonToggle">
				Career
			</div>
			<span class="optionSpan">*경력 내용을 입력해 주세요.</span>
			</div>
			</div>
			<div id="rl_all_content" <c:if test="${empty resumeCommand.rl_title}">style="display:none"</c:if>>
				<ul class="big-list resumeForm size">
					<li>
						<label for="rl_title">회사명</label>
						<input type="text" name="rl_title" id="rl_title" value="${resumeCommand.rl_title}" <c:if test="${empty resumeCommand.rl_title}">disabled="disabled"</c:if>>
					</li>
					<li>
						<label for="rl_position">직급</label>
						<input type="text" name="rl_position" id="rl_position" value="${resumeCommand.rl_position}" <c:if test="${empty resumeCommand.rl_position}">disabled="disabled"</c:if>>
					</li>
					<li>
						<label for="rl_sd">시작일</label>
						<input type="date" name="rl_sd" id="rl_sd" value="${resumeCommand.rl_sd}" <c:if test="${empty resumeCommand.rl_sd}">disabled="disabled"</c:if>>
					</li>
					<li>
						<label for="rl_ed">종료일</label>
						<input type="date" name="rl_ed" id="rl_ed" value="${resumeCommand.rl_ed}" <c:if test="${empty resumeCommand.rl_ed}">disabled="disabled"</c:if>>
					</li>
					<li>
						<label for="rl_def">직무 내용</label>
						<input type="text" name="rl_def" id="rl_def" value="${resumeCommand.rl_def}" <c:if test="${empty resumeCommand.rl_def}">disabled="disabled"</c:if>>
					</li>
				</ul>
			</div>
				<!-- 캐리어 끝 -->
				<!-- 수상 경력 시작 -->
			<div class="row">
				<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 col-lg-offset-3 col-md-offset-3 col-sm-offset-2 col-xs-offset-2">
			<div id="rc_checkAwards" class="btn btn-default slideButtonToggle">
				Awards
			</div>
			<span class="optionSpan">*수상하신 내역을 입력해 주세요.</span>
			</div>
			</div>
			<div id="rc_all_content" <c:if test="${empty resumeCommand.rc_title}">style="display:none"</c:if>>
				<ul class="big-list resumeForm size">
					<li>
						<label for="rc_title">수상명</label>
						<input id="rc_title" name="rc_title" type="text" value="${resumeCommand.rc_title}" <c:if test="${empty resumeCommand.rc_title}">disabled="disabled"</c:if>>
					</li>
					<li>
						<label for="rc_inst">수여 기관</label>
						<input id="rc_inst" name="rc_inst" type="text" value="${resumeCommand.rc_inst}" <c:if test="${empty resumeCommand.rc_inst}">disabled="disabled"</c:if>>
					</li>
					<li>
						<label for="rc_year">수상 연도</label>
						<input type="date" id="rc_year" name="rc_year" value="${resumeCommand.rc_year}" <c:if test="${empty resumeCommand.rc_year}">disabled="disabled"</c:if>>
					</li>
					<li>
						<label for="rc_content">수상 내용</label>
						<input id="rc_content" name="rc_content" type="text" value="${resumeCommand.rc_content}" <c:if test="${empty resumeCommand.rc_content}">disabled="disabled"</c:if>>
					</li>
				</ul>
			</div>
				<!-- 수상 경력 끝 -->
				<!-- 학력 시작 -->
			<div class="row">
				<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 col-lg-offset-3 col-md-offset-3 col-sm-offset-2 col-xs-offset-2">
			<div id="a_checkAchieve" class="btn btn-default slideButtonToggle">
				Achieve
			</div>
			<span class="optionSpan">*학력을 입력해 주세요.</span>
			</div>
			</div>
			<div id="a_all_content" <c:if test="${empty resumeCommand.a_grade}">style="display:none;"</c:if>>
				<ul class="big-list resumeForm size">
					<li>
						<label for="a_grade">학교 구분(최종 학력)</label>
						<select name="a_grade" <c:if test="${empty resumeCommand.a_grade}">disabled="disabled"</c:if>>          
							<option value="초등학교(중퇴)" <c:if test="${resumeCommand.a_grade=='초등학교(중퇴)'}">selected="selected"</c:if>>초등학교(중퇴)</option>
							<option value="초등학교(졸)" <c:if test="${resumeCommand.a_grade=='초등학교(졸)'}">selected="selected"</c:if>>초등학교(졸)</option>
							<option value="중학교(중퇴)" <c:if test="${resumeCommand.a_grade=='중학교(중퇴)'}">selected="selected"</c:if>>중학교(중퇴)</option>
							<option value="중학교(졸)" <c:if test="${resumeCommand.a_grade=='초등학교(졸)'}">selected="selected"</c:if>>중학교(졸)</option>
							<option value="고등학교(중퇴)" <c:if test="${resumeCommand.a_grade=='고등학교(중퇴)'}">selected="selected"</c:if>>고등학교(중퇴)</option>
							<option value="고등학교(졸)" <c:if test="${resumeCommand.a_grade=='고등학교(졸)'}">selected="selected"</c:if>>고등학교(졸)</option>
							<option value="대학교(중퇴)" <c:if test="${resumeCommand.a_grade=='대학교(중퇴)'}">selected="selected"</c:if>>대학교(중퇴)</option>
							<option value="대학교(졸)" <c:if test="${resumeCommand.a_grade=='대학교(졸)'}">selected="selected"</c:if>>대학교(졸)</option>
							<option value="대학원(중퇴)" <c:if test="${resumeCommand.a_grade=='대학원(중퇴)'}">selected="selected"</c:if>>대학원(중퇴)</option>
							<option value="대학원(졸)" <c:if test="${resumeCommand.a_grade=='대학원(졸)'}">selected="selected"</c:if>>대학원(졸)</option>
						</select>
					</li>
					<li>
						<label for="a_title">학교명</label>
						<input id="a_title" name="a_title" type="text" value="${resumeCommand.a_title}" <c:if test="${empty resumeCommand.a_title}">disabled="disabled"</c:if>>
					</li>
					<li>
						<label for="a_ed">졸업일</label>
						<input type="date" id="a_ed" name="a_ed" value="${resumeCommand.a_ed}" <c:if test="${empty resumeCommand.a_ed}">disabled="disabled"</c:if>>
					</li>
					<li>
						<br>
					</li>
				</ul>
			</div>
				<!-- 학력 끝 -->
				<!-- 취미 시작 -->
			<div class="row">
				<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 col-lg-offset-3 col-md-offset-3 col-sm-offset-2 col-xs-offset-2">
			<div id="h_checkHobby" class="btn btn-default slideButtonToggle"> 
				Hobby
			</div>
			<span class="optionSpan">*취미를 입력해 주세요.</span>
			</div>
			</div>
			<div id="h_all_content" <c:if test="${empty resumeCommand.h_name}">style="display:none;"</c:if>>
				<ul class="big-list resumeForm size">
					<li>
						<label for="h_name">취미</label>
						<input id="h_name" name="h_name" type="text" value="${resumeCommand.h_name}" <c:if test="${empty resumeCommand.h_name}">disabled="disabled"</c:if>>
					</li>
				</ul>
			</div>
				<!-- 취미 끝 -->
				<!-- 자격증 시작 -->
			<div class="row">
				<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 col-lg-offset-3 col-md-offset-3 col-sm-offset-2 col-xs-offset-2">
			<div id="l_checkLicense" class="btn btn-default slideButtonToggle">
				License
			</div>
			<span class="optionSpan">*취득하신 자격증을 입력해 주세요.</span>
			</div>
			</div>
			<div id="l_all_content" <c:if test="${empty resumeCommand.l_name}">style="display:none;"</c:if>>
				<ul class="big-list resumeForm size">
					<li>
						<label for="l_name">이름</label>
						<input id="l_name" name="l_name" type="text" value="${resumeCommand.l_name}" <c:if test="${empty resumeCommand.l_name}">disabled="disabled"</c:if>>
					</li>
					<li>
						<label for="l_com">발급 기관</label>
						<input id="l_com" name="l_com" type="text" value="${resumeCommand.l_com}" <c:if test="${empty resumeCommand.l_com}"> disabled="disabled"</c:if>>
					</li>
					<li>
						<label>발급 연도</label>
						<input type="date" id="l_year" name="l_year" value="${resumeCommand.l_year}" <c:if test="${empty resumeCommand.l_year}">disabled="disabled"</c:if>>
					</li>
				</ul>
			</div>
				<!-- 자격증 끝 -->
				<!-- 파일 시작 -->
			<div class="row">
				<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 col-lg-offset-3 col-md-offset-3 col-sm-offset-2 col-xs-offset-2">
					<div id="f_checkPortfolio" class="btn btn-default slideButtonToggle">
						Portfolio           
					</div>   
					<span class="optionSpan">*포트폴리오 내용을 입력해 주세요.</span>         
				</div>
			</div>
			<div id="f_all_content" <c:if test="${empty resumeCommand.fname}">style="display:none"</c:if>>
				<ul class="big-list resumeForm size">
					<li>
						<label for="fFile">파일</label>
						<input type="file" id="fFile" name="fFile" multiple value="${resumeCommand.fFile}" <c:if test="${empty resumeCommand.fname}">disabled="disabled"</c:if>>
					</li>
				</ul>
			</div>
			<div>
				<c:if test="${empty resumeCommand.fname}">
				<ul class="big-list resumeForm size">
					<li>
					<div>  
						&quot;<span id="fname">등록된 파일이 없습니다.</span>&quot;
					</div>
					</li>
				</ul>
				</c:if>
				<c:if test="${!empty resumeCommand.fname}">
				<ul class="big-list resumeForm size">
					<li>
						<div>  	
							&quot;<span id="fname">${resumeCommand.fname}이 등록 되어 있습니다.</span>&quot;
							<br>
							&quot;<span>변경을 원할 시에는 다른 파일을 업로드 해주세요.</span>&quot;
						</div>
					</li>
				</ul>
				</c:if>
			</div>
			<!-- 파일 끝 -->
			<!-- 자기소개 -->                   
			<div class="row">
				<div class="col-lg-8 col-md-8col-sm-8 col-xs-8 col-lg-offset-3 col-md-offset-3 col-sm-offset-2 col-xs-offset-2">
			<div id="select_intro" class="btn btn-default slideButtonToggle">
				Ing...             
			</div>
			<span class="optionSpan">*자기소개 목록 입니다.</span>
			</div>            
			</div>               
			<div id="select_intro2" <c:if test="${empty resumeCommand.r_intro}">style="display:none;"</c:if>>
				<ul class="big-list resumeForm size">
					<li>
						<div><strong>자기 소개</strong></div>
						<textarea id="r_intro" name="r_intro" rows="8" cols="88" style="resize:none;" <c:if test="${empty resumeCommand.r_intro}">disabled="disabled"</c:if>>${resumeCommand.r_intro}</textarea>
					</li>
				</ul>                                            
			</div>                                              
               
			<div class="row">                                 
				<div id="submitButton"class="col-lg-2 col-md-2 col-sm-3 col-xs-3 col-lg-offset-4 col-md-offset-4 col-sm-offset-3 col-xs-offset-2">       
					<input type="submit" class="submitButton" value="작성 완료">             
				</div>                            
				<div id="submitButton"class="col-lg-2 col-md-2 col-sm-3 col-xs-3 col-xs-offset-1">
					<input type="button" value="Home" class="homeButton" onclick="location.href='${pageContext.request.contextPath}/main/main.do'">
				</div>           
			</div>                
	</form:form>                  
</div>                         
                 

           


















































