<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/confirmId.js"></script>

<link type="text/css" href="${pageContext.request.contextPath}/resources/css/board.css" rel="stylesheet" />



	<!-- ======== @Region: #content ======== -->
	<div id="content">
		<div class="showcase block block-border-bottom-grey">
			<div class="container">
				<h2 class="block-title">서비스 이용 문의</h2>

				<div>
					<table class="table table-striped">
						<thead class="tb_bbs_view">
							<tr>
								<th>${detail.q_title }</th>
							</tr>
							<tr>
								<td>
									<div class="bbs_ad">
										<ul class="bbs_ad_lf">
											<li class="stit">작성일 : ${detail.q_date}</li>
										</ul>
										<ul class="bbs_ad_rf">
											<li class="stit">조회수 : ${detail.q_hit }</li>
										</ul>
										<p class="cboth"></p>
									</div>
								</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="contents">${detail.q_content }</td>
							</tr> 
						</tbody>
					</table>
				</div>
				
	<div id="reply_div">
		<span class="reply-title">답변드립니다</span>
		<form id="br_form">
			<input type="hidden" name="br_num"
			       value="${command.br_num}" id="br_num">
			<input type="hidden" name="m_id"
			       value="${m_id}" id="m_id">
			<textarea rows="3" cols="50"
			  name="br_content" id="br_content"
			  class="rep-content" style="width: 100%; height: 50px; resize: none;"
			  <c:if test="${empty m_id}">disabled="disabled"</c:if>
			  ><c:if test="${empty m_id}">로그인해야 작성할 수 있습니다.</c:if></textarea>              
			<c:if test="${!empty m_id}">
			<div id="br_first">
				<span class="letter-count">300/300</span>
			</div>
			<div id="br_second" class="align-right">
				<input type="submit" value="전송">
			</div>
			</c:if>
		</form>
	</div>
				
				<a href="qnaBoardList.do" class="btn btn-default pull-right">목록</a>
				<a href="qnaBoardDelete.do?num=${detail.q_num}" class="btn btn-default pull-right">삭제</a>
				<a href="qnaBoardUpdateForm.do?num=${detail.q_num}" class="btn btn-default pull-right">수정</a>
			</div>
		</div>
	</div>
	<!-- /content -->
