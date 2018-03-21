<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/lecture/movement.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/lecture/learnStudent.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lecture/lectureSessionAjax.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lecture/youtubeIframAutoScale.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lecture/learnStudent.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lecture/lc_reply.js"></script>
<div class="container-fluid">
	<div class="md-visible"></div>
	<div class="container md-visible">
		<div class="panel-group md-menuBtn"
			style="box-shadow: 1px 1px 3px black;">
			<div class="panel panel-default">
				<div class="panel-heading">
					<div data-toggle="collapse" href="#collapse1">
						${lcontent.lc_title}</div>
				</div>
				<div id="collapse1" class="panel-collapse collapse">
					<ul class="list-group">
						<c:forEach var="item" items="${lcList}" varStatus="status">
							<c:if test="${item.l_m_num == 0}">
								<li class="list-group-item"
									onclick="location.href='${pageContext.request.contextPath}/lecture/addLearnStudent.do?l_num=${item.l_num}&lc_num=${item.lc_num}'">
									${item.lc_title} <span style="color: gray;">미수강</span>
								</li>
							</c:if>
							<c:if test="${item.l_m_num > 0}">
								<c:if test="${item.comdate != null}">
									<li class="list-group-item"
										onclick="location.href='${pageContext.request.contextPath}/lecture/learnStudent.do?l_num=${item.l_num}&l_m_num=${item.l_m_num}&lc_num=${item.lc_num}'">
										${item.lc_title} <span style="color: green;">수강</span> <c:if
											test="${item.lc_num == lcontent.lc_num}">
											<span style="color: black;">(현재 위치)</span>
											<!-- 아이콘으로 대체 -->
											<c:if test="${!status.first}">
												<!-- 처음 item이 아닐 경우 이전 item 값 가져옴 -->
												<input type="hidden" id="bfL_num"
													value="l_num=${lcList[status.index-1].l_num}&l_m_num=${lcList[status.index-1].l_m_num}&lc_num=${lcList[status.index-1].lc_num}">
											</c:if>
											<c:if test="${!status.last}">
												<!-- 마지막 item이 아닐 경우 다음 item 값 가져옴 -->
												<input type="hidden" id="afL_num"
													value="l_num=${lcList[status.index+1].l_num}&l_m_num=${lcList[status.index+1].l_m_num}&lc_num=${lcList[status.index+1].lc_num}">
											</c:if>
										</c:if>
									</li>
								</c:if>
								<c:if test="${item.comdate == null}">
									<li class="list-group-item"
										onclick="location.href='${pageContext.request.contextPath}/lecture/learnStudent.do?l_num=${item.l_num}&l_m_num=${item.l_m_num}&lc_num=${item.lc_num}'">
										${item.lc_title} <span style="color: black;">수강중</span> <c:if
											test="${item.lc_num == lcontent.lc_num}">
											<span style="color: black;">현재 위치</span>
										</c:if>
									</li>
								</c:if>
							</c:if>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- 제목 -->
	<div class="md-invisible">
		<div class="panel">
			<h3 class="text-center">${lcontent.lc_title}</h3>
		</div>
	</div>
	<!-- 대형화면 상태 사이드바 -->
	<div style="height: 400px; width: 250px;"
		class="sidebar-wrapper md-invisible col-md-4">
		<ul class="sidebar-nav">
			<c:forEach var="item" items="${lcList}">
				<li><c:if test="${item.l_m_num == 0}">
						<a
							href="${pageContext.request.contextPath}/lecture/addLearnStudent.do?l_num=${item.l_num}&lc_num=${item.lc_num}">
							<div class="row">
								<div style="float:left; position: relative; width:150px; text-overflow: ellipsis; overflow: hidden; white-space: nowrap;">${item.lc_title}</div>
								<!-- <div class="col-xs-4">
									<span style="color: gray;">미수강</span>
								</div> -->
							</div>
						</a>
					</c:if> <c:if test="${item.l_m_num > 0}">
						<c:if test="${item.comdate != null}">
							<a
								href="${pageContext.request.contextPath}/lecture/learnStudent.do?l_num=${item.l_num}&l_m_num=${item.l_m_num}&lc_num=${item.lc_num}">
								<div class="row">
									<div style="float:left; position: relative; width:150px; text-overflow: ellipsis; overflow: hidden; white-space: nowrap;">${item.lc_title}</div>
									<div style="float:left;">
										<span style="color: #69ce74;"><span
											class="glyphicon glyphicon-check"></span></span>
									</div>
								</div>

							</a>
						</c:if>
						<c:if test="${item.comdate == null}">
							<a
								href="${pageContext.request.contextPath}/lecture/learnStudent.do?l_num=${item.l_num}&l_m_num=${item.l_m_num}&lc_num=${item.lc_num}">
								<div class="row">
									<div style="float:left; position: relative; width:150px; text-overflow: ellipsis; overflow: hidden; white-space: nowrap;">${item.lc_title}</div>
									<div style="float:left;">
										<span style="color: white;"><span
											class="glyphicon glyphicon-unchecked"></span></span>
									</div>
								</div>

							</a>
						</c:if>
					</c:if></li>
			</c:forEach>
		</ul>
	</div>
	
	<!-- 본문 -->
	<div class="col-xs-12 col-md-8 col-lg-9">
		${lcontent.lc_content}

		<!-- 이전 / 수강 / 완료 -->
		<div class="container">
			<div class="col-xs-12 col-md-8" style="display: inline-block; text-align: center;">
				<div class="btn-group">
					<button type="button" class="btn btn-default btn-lg disabled"
						id="bfBtn">이전</button>

					<c:if test="${lcontent.comdate != null}">
						<button type="button" class="btn btn-default btn-lg disabled"
							id="alreadyComplete">
							<span class="glyphicon glyphicon-check"></span>
						</button>
					</c:if>
					<c:if test="${lcontent.comdate == null}">
						<button type="button" class="btn btn-default btn-lg"
							id="learnComplete"
							onclick="location.href='${pageContext.request.contextPath}/lecture/completeLearnStudent.do?l_num=${lcontent.l_num}&lc_num=${lcontent.lc_num}'">
							<span class="glyphicon glyphicon-check"></span>
						</button>
					</c:if>

					<button type="button" class="btn btn-default btn-lg disabled"
						id="afBtn">다음</button>
				</div>
			</div>
		</div>

		<!-- 댓글 부분 -->
		<div class="container" id="lcreplyDiv">
			<!-- 댓글 입력 -->
			<div class="col-xs-12 col-md-8" id="lcreplyInputDiv">
				<div id="loading" style="display:none;">
					<img src="${pageContext.request.contextPath}/resources/images/ajax-loader.gif">
				</div>
				<span>댓글 달기</span>
				<form id="reply_form">
					<input type="hidden" name="lc_num" value="${lcontent.lc_num}" id="lc_num">
					<input type="hidden" name="m_id" value="${userId}" id="userId">
					<textarea rows="3" style="width: 100%;" name="lcr_content" id="lcr_content"<c:if test="${empty userId}">disabled="disabled"</c:if>><c:if test="${empty userId}">로그인시에 댓글 입력이 가능합니다.</c:if></textarea>
					<c:if test="${!empty userId}">
						<div id="re_first">
							<span class="letter-count">300/300</span>
						</div>
						<div id="re_second">
							<input type="submit" value="전송">
						</div>
					</c:if>
				</form>
			</div>

			<!-- 댓글 목록 출력 -->
			<div class="col-xs-12 col-md-8" id="lcreplyOutput"></div>
			<div class="paging-button" style="display: none;">
				<input type="button" value="다음글 보기">
			</div>
		</div>
	</div>
</div>

