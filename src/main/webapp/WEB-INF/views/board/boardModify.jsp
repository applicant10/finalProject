<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<div class="page-main-style">
   <h1>글수정</h1>
   <form:form commandName="command" action="update.do" id="register_form" enctype="multipart/form-data">
   <form:hidden path="m_id"/>
   <form:hidden path="b_num"/>
      <form:errors element="div" cssClass="error-color"/>
      <ul>
         <li>
            <label for="b_title">제목</label>
            <form:input path="b_title"/>
            <form:errors path="b_title" cssClass="error-color"/>
         </li>
         <li>
            <label for="b_content">내용</label>
            <form:textarea path="b_content"/>
            <form:errors path="b_content" cssClass="error-color"/>
         </li>
         
      </ul>
      <div class="align-center">
         <input type="submit" value="전송">
         <input type="button" value="목록" onclick="location.href='boardList.do'">
      </div>
      
   </form:form>
</div>