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
    document.getElementById("qnawrite").submit();
    }
</script>


	<!-- ======== @Region: #content ======== -->
	<div id="content">
		<div class="showcase block block-border-bottom-grey">
			<div class="container">
				<h2 class="block-title">서비스 이용 문의</h2>
				<form id="qnawrite" name="qnawrite" method="post" action="qnaBoardWrite.do">
					<input type="hidden" id="m_id" name="m_id" value="${userId}" />
					<input type="hidden" id="q_nick" name="q_nick" value="${userNick}" />
					<div>
						<table class="table table-striped">
							<thead class="tb_bbs_view">
								<tr>
									<th><input type="text" id="q_title" name="q_title" style="width: 100%"/></th>
								</tr>
								<tr>
									<td>
										<div class="bbs_ad">
											<ul class="bbs_ad_lf">
												<li class="stit">작성일 : ${today}</li>
											</ul>
											<ul class="bbs_ad_rf">
												<li class="stit">조회수 : 0</li>
											</ul>
											<p class="cboth"></p>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="bbs_ad">
											<ul class="bbs_ad_lf">
												<li class="stit">작성자 : ${userNick}</li>
											</ul>
										</div>
									</td>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="contents">
										<textarea id="q_content" name="q_content" style="width: 100%; height: 200px; resize: none;"></textarea>
									</td>
								</tr> 
							</tbody>
						</table>
					</div>
				</form>
				
				<a href="qnaBoardList.do" class="btn btn-default pull-right">목록</a>
				<a href="#none" onclick="formSubmit(); return false;" class="btn btn-default pull-right">저장</a>
			</div>
		</div>
	</div>
	<!-- /content -->
