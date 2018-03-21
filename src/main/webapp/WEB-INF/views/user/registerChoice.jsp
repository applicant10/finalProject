<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui.min.css">
<script src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/resume/resumeDetail.js"></script>
	<div class="row">
		<div class="col-lg-10 col-md-9 col-sm-12 col-xs-12 col-lg-offset-3 col-md-offset-2 col-sm-offset-1" style="margin-bottom:15px;">
			<div>           
				<h3 style="border-bottom:1px solid #C0C0C0;width:50%;">어떤 형태의 가입을 원하시나요?</h3>          
			</div>
		    <table>
		    	<tr>
			    	<td>
				    	<img id="img1" src="${pageContext.request.contextPath}/resources/images/resume/stadium-2921657_1920.jpg" style="width:500px;height:200px;object-fit:cover;overflow:hidden;">
				    	<img id="img2" src="${pageContext.request.contextPath}/resources/images/resume/sky-2235735_1920.jpg" style="width:500px;height:200px;display:none;object-fit:cover;overflow:hidden;">
				    </td>
				    <td>
				    	<div id="regularMember">                 
				    		<a href="${pageContext.request.contextPath}/user/registerForm.do" class="btn btn-default" style="margin-left:10px;">일반 회원 가입</a>
				    	</div>
				    	<br>
				    	<div id="enterpriseMember">
				    		<a href="${pageContext.request.contextPath}/user/registerEnterpriseForm.do" class="btn btn-default" style="margin-left:10px;">기업 회원 가입</a>
				    	</div>
			    	</td>
		    	</tr>
		    </table>
	            
	    </div>
    </div>