<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/frameset.dtd">
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			$("label#addCourseInfor").text("课程名不能为空");
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
			<img src="<c:url value='/resources/images/icon.png'/>"/>&nbsp;<span>位置：基本信息管理&gt;&gt;课程管理</span>
		</div>
		<h2>课程管理</h2>
		<!-- <div class="div3"> -->
			<form:form action="/question/course/addCourse" method="post" commandName="course">
				<input type="hidden" name="method" value="query">
				
				<table>
					<tr>
						<td><b>添加课程:</b>请你输入课程名</td>
						<td>
						<form:input type="text" id="courseName" path="courseName"/></td>
						<td>
						<form:select name="year" path="year">
							<%int year = Integer.parseInt(new SimpleDateFormat("YYYY")
									.format(new Date()));
							for (int i = year; i >= year - 10; i--) {%>
							
							<option value="<%=i%>"><%=i%>级</option>
							
							<%}%>
						</form:select>
						</td>
						<td><input type="submit" value="添加"  onclick="return addCourse()"  class="btnPaleGreen" /></td><td><label id="addCourseInfor" style="color: red"></label></td>
				</tr>
				</table>
			</form:form>
			<!-- </div> -->
			
			<div class="div4">
				<form action="" method="post" name="form1">
					<table>
						<tr>
							<th>课程名</th>
							<th>年级</th>
							<th>教师</th>
							<th>删除</th>
						</tr>
						<tr>
						<c:forEach var="courses" items="${courses }">
							<tr>
							<td align="center">${courses.courseName}</td>
							<td align="center">${courses.year}级</td>
							<td align="center">${courses.teacher.teaName}</td>
							<td align="center"><a href="/question/course/deleteCourse/${courses.courseId}" onclick='return deleteItem()'>删除</a></td>
						</tr>
						</c:forEach>
					</table>
				</form>
			</div>
		</div>
</body>
</html>
