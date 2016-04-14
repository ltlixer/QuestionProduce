<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<c:url value='/resources/css/main.css' />" rel="stylesheet"
	type="text/css" media="screen" />
	<script type="text/javascript" src="<c:url value='/resources/jQuery/jquery-1.7.2.js' />"></script>
<title>选择要完成的作业</title>
<script type="text/javascript">
$(function(){
	if($("#link").val()=="first"){
		$("#div4").hide();
	} 
	if('${courseSize}'=='0'){
		$("#query").hide();//若无课程，查询按钮影藏
		$("#div6").hide();//若无课程，分页栏影藏
	}
})
function select(){
	 location.href="/question/queryCourse/1";
	 return false;
}
</script>
</head>
<body>
	<div class="bodyDiv">
		<div class="div1">
			<img src="<c:url value='/resources/images/icon.png'/>" />&nbsp;<span>位置：在线作业>>查询作业</span>
		</div>
		<h2>查询作业</h2>
		<input id="link" type="hidden" value="${link}">
		<form action="/question/assignment/queryAssignmentByCourseId">
		
			<table width="90%">
			<c:if test="${courseSize=='0'}">
			<td ></td>
			<tr><td colspan="4" align="center">
					<font size="4">请先选课，在进行学习。<button  onclick="return select()" class="btnPaleGreen">去选课</button></font>
			</td>
			</tr>
			</c:if>
			
					<tr id="query">
					<td align="right"></td>
						<td align="right"><font size="4">请选择课程:</font>
						<select name="course" style="width: 200px">
					<c:if test="${not empty courses}">
						<c:forEach var ="course" items="${courses}">
							<option value="${course.courseId}">${course.year}级${course.courseName}</option>
						</c:forEach>
					</c:if>
			</select></td>
						<td align="right">请输入关键词</td>
						<td>
						<input type="text" id="findAss" name="findAss" style="width: 200px" value="${findAss}"/><font color="red">（可空）</font></td>
						<td><input type="submit" id="query" style="width: 150px"  class="btnPaleGreen" value="查询作业"   /></td>
				</tr>
				</table>
		</form>
				<hr color="#00aaff">
		<div class="div4" id="div4">
		<center>查看已完成的作业：<a
				href="/question/assignment/finishedAssignment/1">查看
			</a></center>
			<table border="1" class="editTab">
				<tr>
					<th colspan="7">新的作业题</th>
				</tr>
				
				<tr>
				
			</tr>
				<tr>
					<th align="center" width="20%">课文标题</th>
					<th align="center" width="20%">科目</th>
					<th align="center" width="10%">限时</th>
					<th align="center" width="20%">发布时间</th>
					<th align="center" width="10%">发布教师</th>
					<th align="center" width="10%">点击开始</th>
				</tr>
					<c:if test="${infor=='no'}">
					<tr><td colspan="7" align="center"><font color="red" size="4"> 老师还没有布置作业</font></td></tr>
					</c:if>
				<c:forEach var="ass" items="${assignments}">
					<tr>
						<td align="center">${ass.text.textTitle}</td>
						<td align="center">${ass.text.course.courseName}</td>
						<td align="center">${ass.assTime}分钟</td>
						<td align="center">${ass.createTime}</td>
						<td align="center">${ass.teacher.teaName}</td>
						<td align="center"><a
							href="/question/question/stulinkQuestionPage/${ass.assId}">开始做本次作业
						</a></td>
					</tr>
				</c:forEach>
			</table>
			<br> 
			<hr>
			<%-- 		<table border="1" class="editTab">
			<tr><th colspan="8"><h2>已完成的作业</h2></th></tr>
			<tr>
					<th align="center" width="8%">作业主题</th>
					<th align="center" width="30%">作业内容</th>
					<th align="center" width="30%">答案</th>
					<th align="center" width="4%">规定时间</th>
					<th align="center" width="4%">所用时间</th>
					<th align="center" width="8%">所属课程</th>
					<th align="center" width="8%">所属教师</th>
					<th align="center" width="8%">&nbsp;</th>
				</tr>
			<c:forEach var="finishAssignment" items="${finishAssignments}">
				 <tr>
							<td align="center">${finishAssignment.assignment.assTitle}</td>
							<td align="center">${finishAssignment.assignment.question}</td>
							<td align="center">${finishAssignment.answer}</td>
							<td align="center">${finishAssignment.assignment.assTime}分钟</td>
							<td align="center">${finishAssignment.useTime}分钟</td>
							<td align="center">${finishAssignment.assignment.courseName}</td>
							<td align="center">${finishAssignment.assignment.teacher.teaName}</td>
							<td align="center">已完成</td>
						</tr>
				 </c:forEach>
				 </table> --%>
		</div>
	</div>
</body>
</html>