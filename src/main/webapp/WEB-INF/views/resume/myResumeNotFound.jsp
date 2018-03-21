<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui.min.css">
<script src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/resume/resumeNotFound.js"></script>
<script>


</script>
	<div class="row">                   
		<div>                      
			<img id="hathat" style="width:500px;height:730px" class="col-lg-10 col-md-10 col-sm-8 col-xs-10 col-lg-offset-4 col-md-offset-4 col-sm-offset-2" alt="" src="${pageContext.request.contextPath}/resources/images/resume/craig-whitehead-256284.jpg">
		</div>                              
	</div>                                             
	<div id="dialog" title="이력서 작성" style="text-align:center">                                                   
		작성하신 이력서가 없네요!<br>                          
		작성 페이지로 이동 하시겠습니까?<br>      
		<a class="btn btn-default" href="${pageContext.request.contextPath}/user/myResumeForm.do">이력서 작성</a>
	</div>
<p>