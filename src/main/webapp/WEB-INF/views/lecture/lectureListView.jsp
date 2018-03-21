<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lecture/lectureListView.js"></script>
<style>
	.ui-menu {
		width: 150px;
	}
</style>
<div class="container">
	<!-- 검색 옵션 -->
	<div class="col-xs-12 col-md-3 pull-right panel panel-default"
		style="margin-top: 15px;">
		<form action="lectureList.do" id="lectureList_form" method="get">
			<div class="form-group">
				<br>
				<select class="form-control" name="keyfield">
					<option value="title">제목</option>
					<option value="id">아이디</option>
					<option value="content">내용</option>
				</select>
			</div>
			<div class="form-group">
				<input type="text" name="keyword" id="keyword" class="form-control" placeholder="검색 키워드">
			</div>

			<div class="form-group">
				<div class="radio">
					<label><input type="radio" name="l_pay" value="payAll">모두</label>
				</div>
				<div class="radio">
					<label><input type="radio" name="l_pay" value="payFree">무료</label>
				</div>
				<div class="radio">
					<label><input type="radio" name="l_pay" value="payment">유료</label>
				</div>
			</div>
			
			<div class="form-group">
				<c:forEach var="lv1" items="${subLv1s}">
					<button type="button" class="btn btn-default form-control" id="SubjectToggleBtn" data-lv1="${lv1.lv1}">${lv1.lv1}</button>
					<c:forEach var="lv2" items="${subLv2s}">
						<c:if test="${lv2.lv1 == lv1.lv1}">
							<div id="subs_${lv1.lv1}" data-lv1="${lv1.lv1}" style="display: none;">
								<div class="radio">
									<label><input type="radio" name="s_num" value="${lv2.s_num}">${lv2.lv2}</label>
								</div>
							</div>
						</c:if>
					</c:forEach>
				</c:forEach>
			</div>

			<div class="form-group">
				<input type="submit" class="btn btn-info form-control" value="검  색" ><br>
			</div>

		</form>
	</div>
	
	<!-- 강의 리스트 0 -->
	<c:if test="${count == 0}">
		<div class="col-xs-12 col-md-9" style="margin-top: 15px;">
			<h3>
				<p class="text-center">등록된 강의가 없습니다.</p>
			</h3>
			<br>
		</div>
	</c:if>
	
	<!-- 강의 리스트 -->
	<c:if test="${count > 0}">
		<c:forEach var="item" items="${list}">
			<div class="col-xs-12 col-md-9" style="margin-top: 15px;">
				<div class="panel panel-default" style="cursor: pointer; margin-bottom: 5px;" onclick="location.href='lectureView.do?l_num=${item.l_num}'">
					<div class="panel-body">
						<h2>${item.l_title}</h2>
						${item.l_hit}명 수강 / 
						<c:if test="${item.l_point == 0 || item.l_point == null}">
							<span style="color:silver;">강좌평 없음.</span>
						</c:if>
						<c:if test="${item.l_point > 0}">
							평점 : <b><fmt:formatNumber pattern=".0">${item.l_point}</fmt:formatNumber></b>점<br>
						</c:if>
							
						<p>${item.l_shortcon}</p>
					</div>
				</div>
			</div>
		</c:forEach>
		<div class="col-xs-12 col-md-12 text-center">${pagingHtml}</div>
	</c:if>
</div>