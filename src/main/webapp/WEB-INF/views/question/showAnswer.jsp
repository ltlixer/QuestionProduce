<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/frameset.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	
	
<title>Answer</title>
<script type="text/javascript">
    function linksAss(){
    	location.href ="/question/assignment/showScoreAssignment/1";
    }
    function linksAssStu(){
    	location.href ="/question/assignment/queryScoreAssignmentBystuId/1";
    }
</script>
</head>
<body>
	<div class="div3">
		<font size="4"><label><spring:message code="textLabel3"/>${textTitle}<spring:message code="textLabel4"/></label>
		</font>
		<div style="float: right"><font size="4"><spring:message code="courseName"/>${courseName}</font>&nbsp;&nbsp;&nbsp;&nbsp;</div>
	</div>
	<div style="width: 98%; padding-left: 20px">
		<font size="3"> <c:forEach var="sentence" items="${texts}">
				&nbsp;&nbsp;
				${sentence}<br>
			</c:forEach>
		</font>
	</div>

	<div class="div3">
		<font size="4"><label><spring:message code="questionLabel1"/>${fn:length(answers)}<spring:message code="questionLabel2"/> <spring:message code="questionLabel3"/>&nbsp;&nbsp;<spring:message code="gradesLabel1"/><fmt:formatNumber value="${score}" pattern="#0.0"/><spring:message code="gradesLabel2"/></label></font>
		<div style="float: right;"><font size="4"><spring:message code="stuName"/>${stuName}&nbsp;&nbsp;</font><font size="4" color="red"><spring:message code="timeLabel1"/>${useTime}<spring:message code="timeLabel2"/>&nbsp;&nbsp;</font>
		</div>
	</div>
	<div class="div4" style="width: 98%">
		<form id="submitFormId" action="#" method="post">
			<input type="hidden" id="saId" name="saId" value="${saId}">
			<table border="1" class="editTab" id="showAnswer" align="center">
				<tr>
					<th width="5%"><spring:message code="qid"/></th>
					<th width="60%"><spring:message code="question"/></th>
					<th width="13%"><spring:message code="stuAnswer"/></th>
					<th width="12%"><spring:message code="refAnswer"/></th>
					<th width="10%"><spring:message code="correctResult"/></th>
				</tr>
					<c:set var="i" value="${0}"/>
					<c:forEach var="answer" items="${answers}">
					<c:set var="i" value="${i+1}"/>
					<tr>
						<td align="center">${i}.</td>
						<td>${answer.question.question}</td>
							<td align="center"><input type="hidden" id="answerId${i}" name="answerId" value="${answer.asswerId}">
							${answer.answer}</td>
							
							<td align="center">${answer.question.answer}</td>
							<td align="center">
							<c:if test="${answer.tOrF=='T'}">
							<spring:message code="right"/>
							</c:if>
							<c:if test="${answer.tOrF=='F'}">
							<font color="red"><spring:message code="error"/></font>
							</c:if>
							</td>
					</tr>
				</c:forEach>
			
			<tr>
				 
				 <tr>
				 <td colspan="5" align="center">
				<font size="4"><spring:message code="evaluate"/>${evaluate}</font>
				</td>
				</tr>
				<tr>
				<td colspan="5" align="center">
				<c:if test="${user=='tea'}"> 
					<input type="button" onclick="linksAss()" class="btnGray" style="width: 100px" value="<spring:message code='back'/>">
				</c:if>
				<c:if test="${user=='stu'}"> 
					<input type="button" onclick="linksAssStu()" class="btnGray" style="width: 100px" value="<spring:message code='back'/>">
				</c:if>
				</td>
				</tr>
			</table>
				<br><br>
		</form>
	</div>
</body>
</html>