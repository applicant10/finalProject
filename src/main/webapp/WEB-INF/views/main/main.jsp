<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/resume/main.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/resume/main.css">
    <div class="hero" id="highlighted">          
        <div id="highlighted-slider" class="container">
        <div class="showcase block block-border-bottom-grey">
        <h2 class="block-title" style="color:gray;">
            <strong>Our Introduction</strong>
        </h2>
      <div class="inner">
        <!--Slideshow-->              
          <div class="item-slider" data-toggle="owlcarousel" data-owlcarousel-settings='{"singleItem":true, "navigation":true, "transitionStyle":"fadeUp"}'>
            <!--Slideshow content-->
            <!--Slide 1-->
            <div class="item">
              <div class="row">
                <div class="col-md-6 col-md-push-6 item-caption">
                  <h2 class="h1 text-weight-light">
                      <span class="text-primary">Our Team Members</span>
                    </h2>
                  <div style="color:black;text-align:center;">
                  	<div class="spacing"><span style="font-size:23px;">팀장</span> : 김정현</div>
                  	<div class="spacing"><span style="font-size:23px;">조원</span> : 이우진, 조정민, 최재민, 황재명</div>
                  	<div class="spacing"><span style="font-size:23px;">주제</span> : 기업에 구직하던 당신! 기업이 구인하게 만들자!</div>
                  	<div class="spacing" id="contentsHide">
                  		<br>
                  		<span style="font-size:23px;">내용</span> : <br>
                  		기업에 이력서를 작성하느라 밤샘하던 하루 이틀
                  		더이상의 기다림은 없다.<br>
                  		내가 찾아 가지 않고 기업이 맞춤형 인재를 찾아서<br>
                  		내 이력서를 가져간다.
                  	</div>
                  </div>
                </div>
                <div class="col-md-6 col-md-pull-6 hidden-xs">
                <div>
                  	<img id="firstLady" src="${pageContext.request.contextPath}/resources/bootstrap/img/slides/ha1.jpg" alt="Slide 1" class="center-block img-responsive">
                </div>
                <div>
                	<img id="secondLady" style="display:none;" src="${pageContext.request.contextPath}/resources/images/resume/hayearsu.jpg" alt="Slide 1" class="center-block img-responsive">
                </div>
                </div>
              </div>
            </div>
            <!--Slide 2-->
            <div class="item">
              <div class="row">
                <div class="col-md-6 text-right-md item-caption">
                  <h2 class="h1 text-weight-light">
                      <span class="text-primary">Team</span>
                    </h2>           
                  <div style="color:black">
                  	<h4><strong style="font-size:23px;">2018년</strong> 다들 취업 대박 나시길...</h4>
                  	<br>
                  	<div class="col-xs-offset-3 col-md-offset-4">
	                  	<div class="spacing">우리 모두 다 같이 <strong style="font-size:23px;">취업</strong>을 뽀개 봅시다!</div>
	                  	<div class="spacing">항상 할 수 있다는 믿음으로 달려 봅시다.</div>
	                  	<div class="spacing">파이아!!!!!</div>    
	                  	<br>
	                  	<div class="spacing">하연수가 지켜본다!!!!</div>          
                  	</div>
                  </div>             
                </div>                             
                <div class="col-md-6 hidden-xs">
                  <img src="${pageContext.request.contextPath}/resources/images/resume/hacafesu.jpg" alt="Slide 2" class="center-block img-responsive">
                </div>
              </div>
            </div>
          </div>
        </div>
        </div>
      </div>
    </div>
  <!-- ======== @Region: #content ======== -->
  <div id="content">
    <!--Showcase-->
    <div class="showcase block block-border-bottom-grey">
      <div class="container">
        <h2 class="block-title">
            <strong>Showcase</strong>
          </h2>
        <p>이력서 리스트</p>
        <div class="item-carousel" data-toggle="owlcarousel" data-owlcarousel-settings='{"items":4, "pagination":false, "navigation":true, "itemsScaleUp":true}'>
        <c:forEach var="resume" items="${list}">
	          <div class="item">
	            <a href="${pageContext.request.contextPath}/user/enpriReView.do?m_id=${resume.m_id}" class="overlay-wrapper">
	            <c:if test="${fn:endsWith(resume.r_pname, '.jpg') ||   
								  fn:endsWith(resume.r_pname, '.JPG') ||
								  fn:endsWith(resume.r_pname, '.gif') ||
								  fn:endsWith(resume.r_pname, '.GIF') ||
								  fn:endsWith(resume.r_pname, '.png') ||
								  fn:endsWith(resume.r_pname, '.PNG')}">
					<div class="align-center">
							<img style="height:200px;object-fit:cover;overflow:hidden;display:block;width:100%;" src="${pageContext.request.contextPath}/user/enpriImageView.do?m_id=${resume.m_id}" alt="" class="coffeeStyle">
					</div>               
				</c:if>                            
				<c:if test="${empty resume.r_pname}">
					<img style="height:200px;object-fit:cover;overflow:hidden;display:block;width:100%;" src="${pageContext.request.contextPath}/resources/images/resume/blank-profile.png" class="coffeeStyle">
				</c:if>
	                <span class="overlay">                             
	                  <span class="overlay-content"> <span class="h4">${resume.m_nick}</span> </span>
	                </span>               
	              </a>
	            <div class="item-details bg-noise">
	              <h4 class="item-title">
	                  <a href="${pageContext.request.contextPath}/user/enpriReView.do?m_id=${resume.m_id}">${resume.m_nick}</a>
	                </h4>
	            </div>
	          </div>
	          </c:forEach>
        </div>
      </div>
    </div>
  </div>
  <!-- /content -->
  <!-- Call out block -->
  <div class="block block-pd-sm block-bg-primary">
    <div class="container">
      <div class="row">
        <h3 class="col-md-4">
            Some of our Clients
          </h3>
        <div class="col-md-8">
          <div class="row">
            <!--Client logos should be within a 120px wide by 60px height image canvas-->
            <div style="margin-top:15px;">
	            <div class="col-xs-6 col-md-2">
	              <a href="https://www.samsung.com/sec/" title="Client 1"><i style="color:white;font-size:20px;">&quot;Samsong&quot;</i></a>
	            </div>          
	            <div class="col-xs-6 col-md-2">           
	              <a href="https://www.lge.co.kr/lgekor/main.do" title="Client 2"><i style="color:white;font-size:20px;">&quot;Gold-S&quot;</i></a>
	            </div>
	            <div class="col-xs-6 col-md-2">
	              <a href="https://www.apple.com/kr//?afid=p238%7Cs6bhCwOX2-dc_mtid_18707vxu38484_pcrid_223939953812_&cid=aos-kr-kwgo-brand--slid-" title="Client 3"><i style="color:white;font-size:20px;">&quot;Pear&quot;</i></a>
	            </div>
	            <div class="col-xs-6 col-md-2">
	              <a href="https://www.microsoft.com/ko-kr" title="Client 4"><i style="color:white;font-size:20px;">&quot;Door&quot;</i></a>
	            </div>
	            <div class="col-xs-6 col-md-2">
	              <a href="http://www.marvel.co.kr/main.do" title="Client 5"><i style="color:white;font-size:20px;">&quot;Mable&quot;</i></a>
	            </div>
	            <div class="col-xs-6 col-md-2">
	              <a href="http://www.nexon.com/Home/Game.aspx" title="Client 6"><i style="color:white;font-size:20px;">&quot;Nexttom&quot;</i></a>
	            </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  

