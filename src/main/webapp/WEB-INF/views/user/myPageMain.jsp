<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/resume/resumeChoice.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui.min.css">
<script src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
<div class="row">
	<div style="margin:0 auto;">
		<div class="col-lg-12 col-md-12 col-sm-11 col-xs-10 col-lg-offset-3 col-md-offset-2 col-sm-offset-2 col-xs-offset-1">
			<h2>회원님!</h2>
			<h4> 어떤내용이 필요 하신가요?</h4>                                         
		</div>
		<div class="col-lg-11 col-md-11 col-sm-11 col-xs-11 col-lg-offset-2 col-md-offset-1 col-sm-offset-1 col-xs-offset-1"><br>
			<div class="col-lg-4 col-md-5 col-sm-5 col-xs-5 col-lg-offset-1 col-md-offset-1 col-sm-offset-1 col-xs-offset-1">                  
					<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 col-lg-offset-4 col-md-offset-4 col-sm-offset-3 col-xs-offset-3">         
						<a href="${pageContext.request.contextPath}/user/myInfo.do" class="btn btn-default" >회원정보</a>                   
					</div>                                                           
					<div style="padding:45px 0 0 0;">                        
						<img style="width:400px;height:100px;object-fit:cover;" src="${pageContext.request.contextPath}/resources/images/resume/jasper-van-der-meij-757.jpg">
					</div>                      
			</div>                                   
			<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">     
				<div>                        
					<img style="width:400px;height:100px;object-fit:cover;" src="${pageContext.request.contextPath}/resources/images/resume/luke-chesser-50.jpg">
				</div>                                                                              
					<div style="margin:15px 0 0 0">                               
						<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12 col-lg-offset-4 col-md-offset-4 col-sm-offset-3 col-xs-offset-2">
							<a href="${pageContext.request.contextPath}/user/myResume.do" class="btn btn-default" >이력서 관리</a>
						</div>                    
					</div>
			</div>                                       
		</div>                    
	</div>              
	<%-- <div class="btn btn-default" id="resumeTypeChoice">이력서 종류 선택하기</div>
	<div id="resumeType" style="display:none">
		<div class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/main/main.do'">기본</div>
		<div class="btn btn-default">슬라이드</div>
		<div class="btn btn-default">비눗방울</div>
	</div> --%>
</div>    
