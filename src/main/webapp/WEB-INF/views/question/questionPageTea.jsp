<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/frameset.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <%@ include file="../com/easyui.jsp" %> 
<html>
<head>
<TITLE>Student Register</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link href="<c:url value='/resources/css/main.css' />" rel="stylesheet"
	type="text/css" media="screen" />
<script type="text/javascript"
	src="<c:url value='/resources/js/dialog.js'/>"></script>

<title>question page</title>
<script type="text/javascript">
    function linkAss(){
    	location.href ="/question/assignment/queryAssignment/1";
    }
</script>
</head>
<body>
	<div class="div3">
		<font size="4"><label><spring:message code="textLabel1"/>${textTitle}<spring:message code="textLabel2"/> </label>
		</font>
		<span style="float: right;"><font size="3"><spring:message code="courseName"/>：${courseName}</font>&nbsp;&nbsp;</span>
	</div>
	<br>
	<div style="width: 98%; padding-left: 20px">
		<font size="3"> <c:forEach var="sentence" items="${texts}">
				&nbsp;&nbsp;
				${sentence}<br>
			</c:forEach>
		</font>
	</div>

	<div class="div3">
		<font size="4"><label><spring:message code="questionLabel1"/>${fn:length(questions)}<spring:message code="questionLabel2"/></label></font>
		<div style="float: right;"><font size="4" color="red"><spring:message code="timeLabel1"/>${assTime}<spring:message code="timeLabel2"/>
		</font>&nbsp;&nbsp;&nbsp;&nbsp;</div>
	</div>
	<div class="div4" style="width: 98%">
		<form id="submitFormId" action="/question/answer/submitAnswer" method="post">
			<input type="hidden" name="assId" value="${assId}">
			<input type="hidden" id="useTime" name="useTime" value="${assTime}">
			<table border="1" class="editTab" id="showQuestion" align="center">
				<tr>
					<th width="7%"><spring:message code="qid"/></th>
					<th width="70%"><spring:message code="question"/></th>
					<th width="13%"><spring:message code="refAnswer"/></th>
					<th width="10%"><spring:message code="questionType"/></th>
				</tr>
					<c:set var="i" value="${0}"/>
					<c:forEach var="question" items="${questions}">
					<c:set var="i" value="${i+1}"/>
					<tr>
						<td align="center"><spring:message code="question"/> ${i}.</td>
						<td>${question.question}</td>
						
							<td>${question.answer}</td>
							<td>${question.questionType}</td>
					</tr>
				</c:forEach>
			<tr>
				<td colspan="4" align="center">
					<input type="button" onclick="linkAss()" class="btnPaleGreen" style="width: 100px" value="<spring:message code='reAssList1'/>">
				</td>
				</tr>
			</table>
				<br><br>
		</form>
	</div>



</body>
</html>