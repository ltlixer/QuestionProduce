<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<c:url value='/resources/css/main.css' />" rel="stylesheet"
	type="text/css" media="screen" />
	<script type="text/javascript" src="<c:url value='/resources/jQuery/jquery-1.7.2.js' />"></script>
<script type="text/javascript">
$(function(){
	$(".text").focus(function(){
		$(this).css("background", "#CCFFFF");
	}).blur(function(){
		$(this).css("background", "#FFFFFF");
	});
	$(".text1").focus(function(){
		$(this).css("background", "#CCFFFF");
	}).blur(function(){
		$(this).css("background", "#FFFFFF");
	});
	$("#assTitle").focus(function(){
		$("label#assTitleInfor").text("");
	});
	$("#question").focus(function(){
		$("label#questionInfor").text("");
	});
})

function addAss() {
	if($.trim($("#assTitle").val())==""){
		$("label#assTitleInfor").text("作业标题不能为空");
		return false;
	} else if($("#question").val()==""){
		$("label#questionInfor").text("作业题目不能为空");
		return false;
	} else{
		return true;
	}
	
}
</script>
<title>发布作业</title>
</head>
<body class="listBody" >
	<div class="bodyDiv">
		<div class="div1">
			<img src="<c:url value='/resources/images/icon.png'/>" />&nbsp;<span>位置：发布学习内容&gt;&gt;发布课外作业</span>
		</div>
		<div class="div2">
			<table class="editTab" >
				<form:form action="/question/assignment/addAssignment"
					modelAttribute="assignment">
					<tr><td colspan="3"><h2>发布课外作业</h2></td></tr>
					<tr>
						<td align="center"><b>作业主题</b>&nbsp;&nbsp;<label style="color: red" id="assTitleInfor"></label></td>
					</tr>
					<tr>
						<td align="center">
						<form:textarea cols="100"  rows="1" class="text1" id="assTitle"
								path="assTitle" style="font-size:13px"></form:textarea></td>
					</tr>
					<tr>
						<td align="center"><b>作业内容(题目)</b>&nbsp;&nbsp;<label style="color: red" id="questionInfor"></label></td>
					</tr>
					<tr>
						<td align="center"><form:textarea cols="100" rows="10" class="text1" id="question"
								name="question" path="question" style="font-size:13px"></form:textarea>
						</td>
					</tr>
					<tr>
						<td align="center"><b>课程:</b><form:select class="text"
								path="courseName">
								<c:forEach var="course" items="${courseList}">
									<option value="${course.courseName}">${course.courseName}</option>
								</c:forEach>
							</form:select></td>
					</tr>
					<tr align="center"><td><b>限时:</b>
						<form:select class="text" path="assTime">
							<option value="10">10分钟</option>
							<option value="5">5分钟</option>
							<option value="6">6分钟</option>
							<option value="8">8分钟</option>
							<option value="15">15分钟</option>
							<option value="20">20分钟</option>
							<option value="30">30分钟</option>
							<option value="30">40分钟</option>
						</form:select>
						</td>
					<tr>
						<td align="center"><input type="submit" onclick="return addAss()" class="btn2" name="submit"
							value="发布作业"></td>
					</tr>
				</form:form>
			</table>
		</div>
	</div>
</body>
</html>