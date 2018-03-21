<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/resume/resumeList.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui.min.css">	
<script src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/resume/addResume.js"></script>
	<div class="row">
        <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 col-lg-offset-2 col-md-offset-2 col-sm-offset-2 col-xs-offset-2">
          <h2 class="my-4">Resume List</h2>
          <div class="grayColor">*클릭시 해당 이력서로 이동합니다.</div>
        </div>
        <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 col-lg-offset-2 col-md-offset-2 col-sm-offset-2 col-xs-offset-2">
	        <form  action="searchJungler.do" method="post" id="jungler">

		        <div id="wrapSelect" class="col-lg-3 col-md-4 col-sm-8 col-xs-8">
		        <select name="r_loc" id="r_loc">
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
					<option value="없음" selected="selected">없음</option>
				</select>
				</div>            
		        <div class="col-lg-4 col-md-6 col-sm-10 col-xs-12">
		        	<input type="text" id="m_id" name="m_id" placeholder="ID 검색">
		        	<input type="submit" class="btn" value="검색">
		        </div>
	        </form>         
        </div>
        <br>
        <div class="row">
        <div class="col-lg-10 col-md-10 col-sm-12 col-xs-12 col-lg-offset-2 col-md-offset-2 col-sm-offset-1 col-xs-offset-1">   
        <c:if test="${list ne null}">
        <c:forEach var="resume" items="${list}">
	        <div class="col-lg-5 col-md-5 col-sm-6 col-xs-12">
        	<input type="hidden" name="r_num" value="${resume.r_num}">
	        	<div style="margin:10%;">               
	        		<c:if test="${!empty resume.r_pname}">
		          		<a href="${pageContext.request.contextPath}/user/enpriReView.do?m_id=${resume.m_id}">
		          			<img style="width:200px;height:200px;object-fit:cover;display:inline-block;border-radius:50%;overflow:hidden;" src="enpriImageView.do?m_id=${resume.m_id}" alt="">
		          		</a>
	          		</c:if>
	          		<c:if test="${empty resume.r_pname}">            
		          		<a href="${pageContext.request.contextPath}/user/enpriReView.do?m_id=${resume.m_id}">
		          			<img style="width:200px;height:200px;object-fit:cover;display:inline-block;border-radius:50%;overflow:hidden;" src="${pageContext.request.contextPath}/resources/images/resume/blank-profile.png" alt="">
		          		</a>
	          		</c:if>
	          	</div>           
	          <h4><a href="${pageContext.request.contextPath}/user/enpriReView.do?m_id=${resume.m_id}">아이디 : ${resume.m_id}</a></h4><br>
	          <h5>희망 직종 : ${resume.r_job}</h5>
	          <p>자기 소개 : ${resume.r_intro}<c:if test="${empty resume.r_intro}">뭐든 자신 있습니다!</c:if></p>    
	        </div>
        </c:forEach>               
      </c:if>
	  <div id="resumes${num}"></div>
      <c:if test="${num==0}">
      		<div class="col-lg-10 col-md-10 col-sm-12 col-xs-12 col-lg-offset-2 col-md-offset-2 col-sm-offset-1 col-xs-offset-1">
      			<h4 id="nullException"><strong>&quot;아직 등록된 이력서 정보가 없습니다.&quot;</strong></h4>
      			<div class="grayColor" id="boot">*혹시 계속 로드가 되지 않을시에는 관리자에게 문의해 주세요!</div>
      		</div>
      </c:if>                
      <c:if test="${numm==0&&list ne null}">
      	<div class="col-lg-10 col-md-10 col-sm-12 col-xs-12 col-lg-offset-2 col-md-offset-2 col-sm-offset-1 col-xs-offset-1">
      			<h4 id="nullException"><strong>&quot;검색하신 정보가 없습니다.&quot;</strong></h4>
      			<div class="grayColor" id="boot">*검색어를 확인해 주세요!</div>
      		</div>
      </c:if>                                     
        </div> 
        </div>                       
      </div>   
	        <div class="btn btn-default" id="nextResumeShow" <c:if test="${num==0}">style="display:none"</c:if>>다음 이력서 보기</div>
        

