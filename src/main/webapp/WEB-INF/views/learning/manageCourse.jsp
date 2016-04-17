<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/frameset.dtd">
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page import="java.text.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"> 

<title>My JSP 'userList.jsp' starting page</title>
<link href="<c:url value='/resources/css/main.css' />"
	rel="stylesheet" type="text/css" media="screen" />
	<script type="text/javascript"
	src="<c:url value='/resources/js/delete.js' />"></script>
	<script type="text/javascript" src="<c:url value='/resources/jQuery/jquery-1.7.2.js' />"></script>
	<script type="text/javascript">
	$(function(){
		$("#courseName").focus(function(){
			$(this).css("background", "#CCFFFF");
			$("label#addCourseInfor").text("");
		}).blur(function() {
			$(this).css("background", "#FFFFFF");
		});
	});
	function addCourse() {
		if($.trim($("#courseName").val())==""){
			$("label#addCourseInfor").text("<spring:message code='courseNameCannotNull'/>");
			return false;
		}else{
			return true;
		}
	}
	</script>
</head>
<body>
	<div class="bodyDiv">
		<div class="div1">
			<img src="<c:url value='/resources/images/icon.png'/>"/>&nbsp;<span><spring:message code="site"/>：<spring:message code="imformationManagement"/>&gt;&gt;<spring:message code="courseManagement"/></span>
		</div>
		<h2><spring:message code="courseManagement"/></h2>
		<!-- <div class="div3"> -->
			<form:form action="/question/course/addCourse" method="post" commandName="course">
				<input type="hidden" name="method" value="query">
				
				<table>
					<tr>
						<td><b><spring:message code="addCourse"/>:</b><spring:message code="pleaseEnterCourseName"/></td>
						<td>
						<form:input type="text" id="courseName" path="courseName"/></td>
						<td>
						<form:select name="year" path="year">
							<%int year = Integer.parseInt(new SimpleDateFormat("YYYY")
									.format(new Date()));
							for (int i = year; i >= year - 10; i--) {%>
							
							<option value="<%=i%>"><%=i%></option>
							
							<%}%>
						</form:select>
						</td>
						<td><input type="submit" value="<spring:message code='add'/>"  onclick="return addCourse()"  class="btnPaleGreen" /></td><td><label id="addCourseInfor" style="color: red"></label></td>
				</tr>
				</table>
			</form:form>
			<!-- </div> -->
			
			<div class="div4">
				<form action="" method="post" name="form1">
					<table>
						<tr>
							<th><spring:message code="courseName"/></th>
							<th><spring:message code="grade"/></th>
							<th><spring:message code="teacher"/></th>
							<th><spring:message code="delete"/></th>
						</tr>
						<tr>
						<c:forEach var="courses" items="${courses }">
							<tr>
							<td align="center">${courses.courseName}</td>
							<td align="center">${courses.year}</td>
							<td align="center">${courses.teacher.teaName}</td>
							<td align="center"><a href="/question/course/deleteCourse/${courses.courseId}" onclick='return deleteItem()'><spring:message code="delete"/></a></td>
						</tr>
						</c:forEach>
					</table>
				</form>
			</div>
		</div>
</body>
</html>
