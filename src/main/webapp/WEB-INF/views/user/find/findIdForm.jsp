<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/find/find.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/find/find.js"></script>
<div class="row">
	<div id="head" class="col-lg-9 col-md-10 col-sm-9 col-xs-9 col-lg-offset-3 col-md-offset-2 col-sm-offset-2 col-xs-offset-1">        
		<h3>아이디 찾기</h3>
		<div class="sub">*아래 항목을 전부 입력해 주셔야 확인이 가능 합니다.</div>
	</div>                
	<div class="col-lg-9 col-md-10 col-sm-9 col-xs-9 col-lg-offset-3 col-md-offset-2 col-sm-offset-2 col-xs-offset-1">       
		<div id="first" class="col-lg-3 col-md-3 col-sm-8 col-xs-8">              
			<label for="m_nick">가입시 입력하신 닉네임</label>                    
			<input type="text" id="m_nick" name="m_nick">
			<br>            
			<label for="md_name">가입시 입력하신 이름</label>                    
			<input type="text" id="md_name" name="md_name">             
		</div>                                                                                             
		<div id="second" class="col-lg-1 col-md-2 col-sm-8 col-xs-12">               
			<input type="button" class="btn pull-right" id="searchId" name="searchId" value="찾기">                                                                           
		</div>                                  
		<div id="third" class="col-lg-3 col-md-6 col-sm-12 col-xs-12">
			<div id="outer">                   
				<div id="resultId">*아이디가 표시 됩니다.</div>             
			</div>                                                       
		</div>                                           
                                        
	</div>                                                     
</div>           