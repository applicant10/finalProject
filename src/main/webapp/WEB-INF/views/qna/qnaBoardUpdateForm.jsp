<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/confirmId.js"></script>

<link type="text/css" href="${pageContext.request.contextPath}/resources/css/board.css" rel="stylesheet" />

<script type="text/javascript">
    function formSubmit()
    {
    document.getElementById("qnaUpdate").submit();
    }
</script>



	<!-- ======== @Region: #content ======== -->
	<div id="content">
		<div class="showcase block block-border-bottom-grey">
			<div class="container">
				<h2 class="block-title">서비스 이용 문의</h2>
				<form action="qnaBoardUpdate.do" id="qnaUpdate" name="qnaUpdate" method="post">
				<input type="hidden" id="q_num" name="q_num" value="${command.q_num }" />
				<div>
					<table class="table table-striped">
						<thead class="tb_bbs_view">
							<tr>
								<th><input type="text" id="q_title" name="q_title" style="width: 100%;" value="${command.q_title}"/></th>
							</tr>
							<tr>
								<td>
									<div class="bbs_ad">
										<ul class="bbs_ad_lf">
											<li class="stit">작성일 : ${command.q_date}</li>
										</ul>
										<ul class="bbs_ad_rf">
											<li class="stit">조회수 : ${command.q_hit }</li>
										</ul>
										<p class="cboth"></p>
									</div>
								</td>
							</tr>
							<tr>
									<td>
										<div class="bbs_ad">
											<ul class="bbs_ad_lf">
												<li class="stit">작성자 : ${command.m_id }</li>
											</ul>
										</div>
									</td>
								</tr>
						</thead>
						<tbody>
							<tr>
								<td class="contents">
									<textarea id="q_content" name="q_content" style="width: 100%; height: 200px; resize: none;">${command.q_content }</textarea> 
								</td>
							</tr> 
						</tbody>
					</table>
				</div>
			</form>	
				<a href="qnaBoardDetail.do?num=${command.q_num}" class="btn btn-default pull-right">취소</a>
				<a href="#none" onclick="formSubmit(); return false;"  class="btn btn-default pull-right">수정</a>
			</div>
			
		</div>
	</div>
	<!-- /content -->
