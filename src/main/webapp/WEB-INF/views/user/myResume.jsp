<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<c:if test="${member.r_date eq null}">
		<div>
			<div>작성하신 이력서가 없네요!<br>작성 페이지로 이동 하시겠습니까?</div>
			<a href="${pageContext.request.contextPath}/user/myResumeForm.do">이력서 작성</a>
		</div>
	</c:if>
	<c:if var="resume" test="${r_date ne null}">
		<div>
			<div>
				<ul>
					<li>
						<span>이름 : </span> ${resume.m_id}
					</li>
					<li>
						<span>전화 번호 : </span> ${resume.md_phone}
					</li>
					<li>
						<span>원하는 근무지 : </span> ${resume.r_loc}
					</li>
					<li>
						<span>email : </span> ${resume.m_id}
					</li>
				</ul>
			</div>
		</div>
	</c:if>
</div>