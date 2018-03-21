<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/confirmId.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/lecture/movement.css"> 
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<!-- <style type="text/css">
	 /* DivTable.com */
	.divTable{
		display: table;
		width: 100%;
	}
	.divTableRow {
		display: table-row;
	}
	.divTableHeading {
		background-color: #EEE;
		display: table-header-group;
	}
	.divTableCell, .divTableHead {
		border: 1px solid #999999;
		display: table-cell;
		padding: 3px 10px;
	}
	.divTableCell.colspan {
		display: none;
	    /* collapse border */
	    margin-top: -1px;
	    margin-bottom: -1px;
	}
	.divTableHeading {
		background-color: #EEE;
		display: table-header-group;
		font-weight: bold;
	}
	.divTableFoot {
		background-color: #EEE;
		display: table-footer-group;
		font-weight: bold;
	}
	.divTableBody {
		display: table-row-group;
	}
	
 </style>
 -->
 
<script type="text/javascript">
//<accoidion>
/* $( function() {
   $( "#accordion" ).accordion();
 } );
//<div table>
jQuery.fn.slideFadeTableRow = function(speed, easing, callback) {
    $tr = this;
    if ($tr.is(':hidden')) {
        $tr.show().find('td > div').animate({opacity: 'toggle', height: 'toggle'}, speed, easing, callback);
    } else{
        $tr.hide().find('td > div').animate({opacity: 'toggle', height: 'toggle'}, speed, easing, callback);
    }
    
    return $tr;
};
 */

function toggle_layer(num, yn) {
	
// 	$("[name="+num+"cont]").hide().prepareTableRowForSliding();  
	
// 	$("[name="+num+"cont]").slideFadeTableRow(300, 'swing', function(){});
	
 	$(".disv").slideUp(0);
	$("[name="+num+"cont]").slideToggle(300);
 	if(yn == "Y"){
 		$("[name="+num+"answer]").slideToggle(300);
 	}11
}

function answerTr(num) {
	
	var numTd = num+"tr";
	
	var anwTr = "<tr id='"+numTd+"'>";
		anwTr += '<td colspan="4"><textarea id="'+num+'answer" style="width: 100%; height: 200px; resize: none"></textarea></td>';
		anwTr += '<td><a href="#none" onclick="answerSubmit('+num+');" class="btn btn-default pull-right">저장</a></td>';
		anwTr += '</tr>';
	
	$("[name="+num+"cont]").after(anwTr);
}

function answerUd(num){
	
	$("#"+num+"answerUr").removeAttr("readonly");
	$("#"+num+"a2").show();
	$("#"+num+"a1").hide();

}

function answerUpSubmit(num){
		
	$("#qnaAnswerForm #q_num").val(num);
	$("#qnaAnswerForm #q_answer").val($("#"+num+"answerUr").val());
	
	document.getElementById("qnaAnswerForm").submit();
}

function answerSubmit(num){	
	$("#qnaAnswerForm #q_num").val(num);
	$("#qnaAnswerForm #q_answer").val($("#"+num+"answerUr").val());
	
	document.getElementById("qnaAnswerForm").submit();
}
</script>


<!-- 출처: http://rahm.tistory.com/21 [RAHM]
 -->

<!-- ======== @Region: #content ======== -->
<div id="content">
	<div class="showcase block block-border-bottom-grey">
		<div class="container">
			<h2 class="block-title">서비스 이용 문의</h2>


			<div align="center">
				<form action="qnaBoardList.do" id="search_form" method="get">
					<table class="table">
						<colgroup>
							<col width="10%">
							<col>
						</colgroup>
						<tbody>
							<tr>
								<td class="th" scope="row"><select name="keyfield">
										<option value="title">제목</option>
										<option value="id">ID</option>
										<option value="content">내용</option>
								</select></td>
								<td><input type="text" name="keyword" id="keyword">
									<input type="text" style="display: none;" title="자동 페이지넘김 방지">
									<input type="submit" id="CSCSC01S0" value="조회" class="inp_bbtn">
								</td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>

			<div style="padding-top: 20px"></div>

			<c:if test="${count == 0}">
				<div class="align-center">등록된 게시물이 없습니다.</div>
			</c:if>

			<c:if test="${count > 0}">
				<table class="table">
					<%-- <colgroup>
						<col width="5%">
						<col width="50%">
						<col class="xs-invisible" width="20%">
						<col width="10%">
						<col width="12%">
						<col width="15%">
					</colgroup> --%>
					<thead>
						<tr>
							<td class="xs-visible">NO.</td>
							<td class="xs-invisible">번호</td>    
							<td>제목</td>
							<td class="xs-invisible">작성일</td>
							
							
							<td>NICK</td> 
							
							 
							<td class="xs-visible">답변</td>  
							<td class="xs-invisible">답변여부</td>
						</tr>
					</thead>
					<tbody>
						
						<c:forEach var="article" items="${list}">
							<c:set var="answerYn" value="N"/>
							<c:if test="${!empty article.q_answer || userGrade == 100}">
								<c:set var="answerYn" value="Y"/>
							</c:if>
							<tr onclick="toggle_layer(${article.q_num}, '${answerYn}')">
								<td>${article.q_num}</td>
								<%-- <td><a href="qnaBoardDetail.do?num=${article.q_num}">${article.q_title}</a></td> --%>
								<td>${article.q_title}</td>
								<td  class="xs-invisible">${article.q_date}</td>
<%-- 								<td>${article.q_hit}</td> --%>
								<td>${article.q_nick}</td>
								<c:if test="${empty article.q_answer}">
									<td class="xs-visible" style="color: red;">&nbsp;<span class="glyphicon glyphicon-exclamation-sign"></span></td>
									<td class="xs-invisible" style="color: red;">미답변</td>
								</c:if>
								<c:if test="${!empty article.q_answer}">
									<td class="xs-visible" style="color: green;">&nbsp;<span class="glyphicon glyphicon-ok-sign"></span></td>
									<td class="xs-invisible" style="color: green;">답변완료</td>
								</c:if>
							</tr>
							<tr name="${article.q_num}cont" bgcolor="#FFFFFF" style="display: none;" class="disv">
								<td colspan="5">
									<div name="${article.q_num}cont" style="display: none;" class="disv">
										[질문내용]<br>${article.q_content}
									</div>
								</td>
							</tr>
							<tr name="${article.q_num}answer" bgcolor="#D5D5D5" style="display: none;" class="disv">
								<td colspan="5">
									<div name="${article.q_num}answer" style="display: none" class="disv">
									[답변]<br>	
								<c:if test="${empty article.q_answer && userGrade == 100}">
									<textarea class="answerUr" id="${article.q_num}answerUr"  style="width:100%;"></textarea>
									<a id="${article.q_num}a2" href="#none" onclick="answerSubmit(${article.q_num});" class="btn btn-default pull-right">저장</a>
								</c:if>
								<c:if test="${!empty article.q_answer && userGrade == 100}">
								    <textarea class="answerUr" id="${article.q_num}answerUr" style="width:100%;">${article.q_answer}</textarea>
								    <a id="${article.q_num}a1" href="#none" onclick="answerUpSubmit(${article.q_num})" class="btn btn-default pull-right">수정</a>
								</c:if>
								<c:if test="${!empty article.q_answer && userGrade != 100}">
									${article.q_answer}
								</c:if>
								</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<div align="center">${pagingHtml}</div>
			</c:if>
			
			<%-- 
			<div class="divTable" style="width: 100%;">
				<div class="divTableHeading">
					<div class="divTableRow">
						<div class="divTableHead" style="width:9%" >번호</div>
						<div class="divTableHead" style="width:*" >제목</div>
						<div class="divTableHead" style="width:20%" >작성일</div>
						<div class="divTableHead" style="width:12%" >닉네임</div>
						<div class="divTableHead" style="width:10%" >답변여부</div>
					</div>
				</div>
				<div class="divTableBody">
					<c:forEach var="article" items="${list}">
						<div class="divTableRow">
							<div class="divTableCell">${article.q_num}</div>
							<div class="divTableCell">${article.q_title}</div>
							<div class="divTableCell">${article.q_date}</div>
							<div class="divTableCell">${article.q_nick}</div>
							<c:if test="${empty article.q_answer}"><div class="divTableCell" style="color: red;">미답변</div></c:if>
							<c:if test="${!empty article.q_answer}"><div class="divTableCell" style="color: blue;">답변</div></c:if>
						</div>
						<div class="divTableRow" >
							<div name="${article.q_num}cont" class="divTableCell colspan" style="background-color: #FFFFFF;" >[질문내용]<br>${article.q_content}</div>
						</div>
						<c:if test="${empty article.q_answer && userId == 'admin@test.com'}">
							<div class="divTableRow">
								<div class="divTableCell colspan" style="background-color: D5D5D5;">
									<textarea class="answerUr" id="${article.q_num}answerUr"  style="width:100%;"></textarea>
									<a id="${article.q_num}a2" href="#none" onclick="answerSubmit(${article.q_num});" class="btn btn-default pull-right">저장</a>
								</div>
							</div>
						</c:if>
						<c:if test="${!empty article.q_answer && userId == 'admin@test.com'}">
							<div class="divTableRow">
								<div class="divTableCell colspan" style="background-color: D5D5D5;">
								    <textarea class="answerUr" id="${article.q_num}answerUr" style="width:100%;">${article.q_answer}</textarea>
								    <a id="${article.q_num}a1" href="#none" onclick="answerUpSubmit(${article.q_num})" class="btn btn-default pull-right">수정</a>
								</div>
							</div>
						</c:if>
						<c:if test="${!empty article.q_answer && userId != 'admin@test.com'}">
							<div class="divTableRow">
								<div class="divTableCell colspan" style="background-color: D5D5D5;">
									${article.q_answer}
								</div>
							</div>
						</c:if>
					</c:forEach>
				</div>
			</div>
			
			<!-- DivTable.com -->
			
			<div id="accordion">
				<c:forEach var="article" items="${list}">
				  <h3>${article.q_title}</h3>
				  <div>
				    [질문내용]<br>${article.q_content}
				    <c:if test="${!empty article.q_answer && userId != 'admin@test.com'}">
					 <br><br>[답변]<br>${article.q_answer}
					</c:if>
				  </div>
				</c:forEach>
			</div>
 --%>			
			<div align="right">
				<c:if test="${!empty userId}">
				<a href="qnaBoardWriteForm.do" class="btn btn-default pull-right">글쓰기</a>
				</c:if>
			</div>
		</div>
	</div>
</div>
<form id="qnaAnswerForm" name="qnaAnswerForm" method="post" action="qnaBoardAnswerUpdate.do">
	<input type="hidden" id="q_num" name="q_num" />
	<input type="hidden" id="q_answer" name="q_answer" />
</form>
<!-- /content -->
<script type="text/javascript">
	var rowWidth = $('.divTableRow:first').width();
	var colWidth = $('.divTableCell:first').width();
	var marginRight = colWidth - rowWidth + 22;
	$('.divTableCell.colspan').css('margin-right', marginRight + 'px'); 
</script>
