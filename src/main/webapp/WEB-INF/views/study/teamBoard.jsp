<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link href="${pageContext.request.contextPath}/resources/css/study/study.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/lecture/movement.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/study/teamBoard.js"></script>

<script type="text/javascript">
function button_event(){
	if (confirm("게시판 자료들을 복구할수 없습니다. 폐지하시겠습니까??") == true){
		location.href="teamDelete.do?g_num=${member.g_num}&m_nick=${userNick}&g_name=${member.g_name}";
	}else{

	    return;
	}
}
function delete_event(){
	if (confirm("정말 탈퇴하시겠습니까??") == true){
		location.href="teamMemberDelete.do?g_num=${member.g_num}&m_nick=${userNick}&g_name=${member.g_name}";
	}else{
	    return;
	}
}
</script>

      <!-- 게시판 시작 -->
      <div class="container">
      	<div class="g_name" style="float: left; width: 100%; padding:10px;">
      	</div>
      		
      	<div class="col-xs-12 col-md-3 panel panel-default" style="margin-top: 15px; padding: 15px;">
      		<div class="col-md-12">팀이름 : ${member.g_name}</div>
			<div class="col-md-12">매니저 : ${member.m_nick}</div>
			<div class="col-md-12">개설일 : ${member.g_date}</div>
			<div class="col-md-12">팀유형 : ${member.g_type}</div>
			<div class="col-md-12">멤버수 : ${memberCount}</div>
			<div class="col-md-12">
			<c:if test="${member.m_nick == userNick}">
			<a href="javascript:button_event();">팀 폐지</a>
			</c:if>
			<c:if test="${userNick != null && userNick != member.m_nick}">
			<a href="javascript:delete_event();">팀 탈퇴</a>
			</c:if>
			</div>
		</div>
			<div class="col-xs-12 col-md-9" style="margin-top: 15px;">
			<c:if test="${count == 0}">
			<div class="write" style="text-align:right;">
				<div class="teamBoard"  style="box-sizing: border-box; width: 200px; height: 100px; float: right; width: 70%; padding:10px;">
				<h3>등록된 게시물이 없습니다.</h3>
				</div><br><br><br><br><br><br><br><br><br><br><br><br>
					<c:if test="${member.m_nick == userNick}">
						<input type="button" value="모집 현황" class="btn btn-default xs-invisible" onclick="location.href='${pageContext.request.contextPath}/study/appliList.do?g_num=${param.g_num}&g_name=${member.g_name}'">
						<input type="button" value="멤버 모집" class="btn btn-default xs-invisible" onclick="location.href='${pageContext.request.contextPath}/study/studyWrite.do?g_num=${param.g_num}'">
						<input type="button" value="멤버 목록" class="btn btn-default xs-invisible" onclick="location.href='${pageContext.request.contextPath}/study/memberList.do?g_num=${param.g_num}&g_name=${member.g_name}'">
						<div class="xs-visible">
							<input type="button" value="모집 현황" class="btn btn-default form-control" onclick="location.href='${pageContext.request.contextPath}/study/appliList.do?g_num=${param.g_num}&g_name=${member.g_name}'">
							<input type="button" value="멤버 모집" class="btn btn-default form-control" onclick="location.href='${pageContext.request.contextPath}/study/studyWrite.do?g_num=${param.g_num}'">
							<input type="button" value="멤버 목록" class="btn btn-default form-control" onclick="location.href='${pageContext.request.contextPath}/study/memberList.do?g_num=${param.g_num}&g_name=${member.g_name}'">
						</div>
					</c:if>
					<input type="button" value="글쓰기" class="btn btn-default xs-invisible" onclick="location.href='${pageContext.request.contextPath}/study/teamBoardWrite.do?g_num=${param.g_num}'">
					<div class="xs-visible">
						<input type="button" value="글쓰기" class="btn btn-default form-control" onclick="location.href='${pageContext.request.contextPath}/study/teamBoardWrite.do?g_num=${param.g_num}'" >
					</div><br>
			</div>
			</c:if>
			<c:if test="${count > 0}">
			
			<div class="Search">
				<form action="teamBoard.do" id="search_form" method="get">
				    <input type="hidden" name="g_num" value="${param.g_num}">
					<div style="text-align:right;" class="form-inline form-group xs-invisible">
						<select name="keyfield" style="width:100px;height:35spx;" class="form-control">
							<option value="tb_title">제목</option>
							<option value="m_nick">작성자</option>
							<option value="tb_content">내용</option>
						</select>
							<input type="text" name="keyword" id="keyword" style="width:220px;height:35px;" class="form-control">
							<input type="submit" value="검색" class="btn btn-default">
					</div>
				</form>
				<form action="teamBoard.do" id="search_form2" method="get">
					<input type="hidden" name="g_num" value="${param.g_num}">
					<div class="xs-visible">
						<select name="keyfield" class="form-control">
							<option value="tb_title">제목</option>
							<option value="m_nick">작성자</option>
							<option value="tb_content">내용</option>
						</select>
							<br><input type="text" name="keyword" id="keyword" class="form-control"><br>
							<input type="submit" value="검색" class="btn btn-default form-control">
					</div>
				</form>
				</div>
				<br>
				<table class="table">
					<tr style="background-color:#474747;color:white;">
						<th width="60%">글 제목</th>
						<th width="20%">닉네임</th>
						<th class="xs-invisible">작성날짜</th>
						<c:if test="${!empty userNick && userNick == member.m_nick}">
						<th class="xs-invisible">삭제</th>
						</c:if>
					</tr>
					<c:forEach var="teamboard" items="${list}">
						<tr>
							<td><a href="${pageContext.request.contextPath}/study/teamBoardDetail.do?tb_num=${teamboard.tb_num}">${teamboard.tb_title}</a></td>
							<td>${teamboard.m_nick}</td>
							<td class="xs-invisible">${teamboard.tb_date}</td>
							<c:if test="${!empty userNick && userNick == member.m_nick}">
							<td class="xs-invisible"><a href="${pageContext.request.contextPath}/study/teamBoardDelete.do?tb_num=${teamboard.tb_num}&g_num=${member.g_num}">삭제</a></td>
							</c:if>
						</tr>
					</c:forEach>
				</table>
				<div class="write" style="text-align:right;">
					<c:if test="${member.m_nick == userNick}">
						<input type="button" value="모집 현황" class="btn btn-default xs-invisible" onclick="location.href='${pageContext.request.contextPath}/study/appliList.do?g_num=${param.g_num}&g_name=${member.g_name}'">
						<input type="button" value="멤버 모집" class="btn btn-default xs-invisible" onclick="location.href='${pageContext.request.contextPath}/study/studyWrite.do?g_num=${param.g_num}'">
						<input type="button" value="멤버 목록" class="btn btn-default xs-invisible" onclick="location.href='${pageContext.request.contextPath}/study/memberList.do?g_num=${param.g_num}&g_name=${member.g_name}'">
						
						<div class="xs-visible">
							<input type="button" value="모집 현황" class="btn btn-default form-control" onclick="location.href='${pageContext.request.contextPath}/study/appliList.do?g_num=${param.g_num}&g_name=${member.g_name}'">
							<input type="button" value="멤버 모집" class="btn btn-default form-control" onclick="location.href='${pageContext.request.contextPath}/study/studyWrite.do?g_num=${param.g_num}'">
							<input type="button" value="멤버 목록" class="btn btn-default form-control" onclick="location.href='${pageContext.request.contextPath}/study/memberList.do?g_num=${param.g_num}&g_name=${member.g_name}'">
						</div>
					</c:if>
					<input type="button" value="글쓰기" class="btn btn-default xs-invisible" onclick="location.href='${pageContext.request.contextPath}/study/teamBoardWrite.do?g_num=${param.g_num}'" >
					<div class="xs-visible">
						<input type="button" value="글쓰기" class="btn btn-default form-control" onclick="location.href='${pageContext.request.contextPath}/study/teamBoardWrite.do?g_num=${param.g_num}'" >
					</div>
				</div>
				<div class="text-center">
					${pagingHtml}
				</div>
				</c:if>
			</div>
		</div>

