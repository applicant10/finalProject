<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--Header & navbar-branding region-->
<div data-stellar-background-ratio="0.1" style="background-color:black;">
	<div class="header">
        <div class="header-inner container">
          <div class="row">
            <div class="col-md-8">
              <!--navbar-branding/logo - hidden image tag & site name so things like Facebook to pick up, actual logo set via CSS for flexibility -->
              <a class="navbar-brand" href="${pageContext.request.contextPath}/main/main.do" title="Home">
                <h1 class="hidden">
                    <img src="${pageContext.request.contextPath}/resources/bootstrap/img/logo.png" alt="Flexor Logo">
                    Team
                 </h1>
              </a>
              <div class="navbar-slogan">
                	나를 표현하는 즐거움
                <br> By Team
              </div>
            </div>
            </div>
           
            <div class="col-md-12 col-lg-12">
              <!--user menu-->
              <ul class="list-inline user-menu pull-right">
              <c:if test="${empty userId}">
                <li class="user-register"><i class="fa fa-edit text-primary "></i> <a href="${pageContext.request.contextPath}/user/register.do" class="text-uppercase">Register</a></li>
                <li class="user-login"><i class="fa fa-sign-in text-primary"></i> <a href="${pageContext.request.contextPath}/user/loginForm.do" class="text-uppercase">Login</a></li>
              </c:if>
             <c:if test="${!empty userId}">
             	<c:if test="${like}"><li><a href="${pageContext.request.contextPath}/user/whoLikesMine.do"><span class="glyphicon glyphicon-exclamation-sign" style="color:red;"></span></a></li></c:if>
             	<li><i class="text primary"></i><b>${userNick}님 안녕하세요?</b></li>
             	<li><a href="${pageContext.request.contextPath}/user/logout.do">로그아웃</a></li>
             </c:if>  
              </ul>
            </div>
          </div>
         </div>
       </div>
  <!--Change the background class to alter background image, options are: benches, boots, buildings, city, metro -->
      <div class="container">
        <div class="navbar navbar-default">
          <!--mobile collapse menu button-->
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse" aria-expanded="false" style="text-align:right"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
          
          <!--everything within this div is collapsed on mobile-->
          <div class="navbar-collapse collapse" style="background:#ffffff;">
            <ul class="nav navbar-nav" id="main-menu">
              <li class="icon-link">
                <a href="${pageContext.request.contextPath}/main/main.do"><i class="fa fa-home"></i></a>
              </li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">나의 정보<b class="caret"></b></a>
                <!-- Dropdown Menu -->
                <ul class="dropdown-menu">
                  <li class="dropdown-header">Client-INFO</li>
                  <c:if test="${userGrade==100}"><li><a href="${pageContext.request.contextPath}/user/admin.do">관리 페이지</a></li></c:if>
                  <li><a href="${pageContext.request.contextPath}/user/myPageMain.do" tabindex="-1" class="menu-item">내 정보 조회</a></li>
                  <li><a href="${pageContext.request.contextPath}/lecture/makeLectureIntro.do" tabindex="-1" class="menu-item">내 개설 강좌</a></li>
                  <li><a href="${pageContext.request.contextPath}/lecture/myLearnState.do" tabindex="-1" class="menu-item">내 학습 현황</a></li>
                  <li><a href="${pageContext.request.contextPath}/user/resumeList.do" tabindex="-1" class="menu-item">이력서 열람</a></li>
                  <li><a href="${pageContext.request.contextPath}/record/record.do" tabindex="-1" class="menu-item">내 활동 기록</a></li>
                </ul>
              </li>
              <li><a href="${pageContext.request.contextPath}/lecture/lectureList.do">강좌보기</a></li>
              <li class="dropdown dropdown-mm">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">그룹 모집<b class="caret"></b></a>
                <!-- Dropdown Menu -->
                <ul class="dropdown-menu dropdown-menu-mm dropdown-menu-persist">
                  <li class="row">
                    <ul class="col-md-6">
                      <li class="dropdown-header">개설</li>
                      <li><a href="${pageContext.request.contextPath}/study/studyEstablish.do">STUDY GROUP / PROJECT TEAM 개설</a></li> 
                    </ul>
                    <ul class="col-md-6">
                      <li class="dropdown-header">MY GROUP</li>
                      <li><a href="${pageContext.request.contextPath}/study/myGroup.do">내가 가입한 그룹</a></li>
                    </ul>
                    <ul class="col-md-6">
                      <li class="dropdown-header">모집</li>
                      <li><a href="${pageContext.request.contextPath}/study/studyBoard.do?g_type='Study'">STUDY / PROJECT 멤버 모집</a></li>
                    </ul>
                  </li>
                </ul>
              </li>
              <li><a href="${pageContext.request.contextPath}/board/boardList.do">게시판</a></li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">QnA<b class="caret"></b></a>
                <!-- Dropdown Menu -->
                <ul class="dropdown-menu">
                  <li class="dropdown-header">Let's Talk</li>
                  <li><a href="${pageContext.request.contextPath}/qna/qnaBoardList.do" tabindex="-1" class="menu-item">서비스 이용 문의</a></li>
                  <li><a href="about.html" tabindex="-1" class="menu-item">지식인</a></li>
                </ul>
              </li>
              <c:if test="${userGrade == 100}">
              	<li><a href="${pageContext.request.contextPath}/admin/adminMain.do">관리자</a></li>
              </c:if>
            </ul>
          </div>
          <!--/.navbar-collapse -->
        </div>
      </div>
            <!--header rightside-->