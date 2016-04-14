<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<c:url value='/resources/css/main.css' />" rel="stylesheet"
	type="text/css" media="screen" />
<script type="text/javascript"
	src="<c:url value='/resources/js/delete.js' />"></script>
<script type="text/javascript"
	src="<c:url value='/resources/jQuery/jquery-1.7.2.js' />"></script>
	<script type="text/javascript"
	src="<c:url value='/resources/js/selectAll.js' />"></script>
<script type="text/javascript">
	$(function() {
		var first = "${first}"
			if (first == "first") {
				$("#viewLog").hide();
			}
	})

	function addE(name){
		   if(getSelectCount(name)<1){
		     alert("至少要选一条数据");
		     return false;
		   }else{
			  return true; 
		   }
	}
	function view(name){
		if(getSelectCount(name)<1){
		     alert("至少要选一条数据");
		     return false;
		   }
		var names=document.getElementsByName(name);
		var courseIds = "";
		var len = names.length;
		if(len>0){
			var i = 0;
			for(i=0;i<len;i++){
				if(names[i].checked==true){
					courseIds +="-"+names[i].value;
				}
			}
		}
		if(courseIds!=""){
			 location.href="/question/evaluate/viewlogTea?courseIds="+courseIds;
		}else{
			return false;
		}
	}
	
</script>
</head>
<body>
	<div class="bodyDiv">
		<div class="div4">
			<img src="<c:url value='/resources/images/icon.png'/>" />&nbsp;<span>位置：评估结果-教师出题日志</span>
		</div>
		<h2>教师出题时间日志下载</h2>
		<input id="link1" type="hidden" value="${link}">
		<form action="/question/evaluate/downlogTea">
		<table  class="editTab" id="table">
					<tr>
						<th align="center">课程名</th>
						<th align="center">年级</th>
						<th align="center"><input type="checkbox" id="selectAll"
							onclick="checkEvent('courseIds','selectAll')" /></th>
					</tr>
					<c:if test="${not empty courses}">
						<c:forEach var="course" items="${courses}">
							<tr>
								<td align="center">${course.year}级${course.courseName}</td>
								<td align="center">${course.teacher.teaName}</td>
								<td align="center"><input type="checkbox" name="courseIds"
									value="${course.courseId}"></td>
							</tr>
						</c:forEach>
					</c:if>
					<tr><td colspan="3" align="center"><input type="submit" onclick="return addE('courseIds')" value="下载出题日志" style="width: 100px"
						class="btnPaleGreen" />
						&nbsp;&nbsp;<a href="#" onclick="return view('courseIds')">查看明细</a>
						</td></tr>
		</table>
		</form>
		<hr color="#00aaff">
		<table border="1" class="editTab" id="viewLog">
				<tr>
					<th colspan="6">教师布置作业日志明细</th>
				</tr>
				<tr>
					<th width="20%">课程名</th>
					<th width="10%">标题</th>
					<th width="10%">学生姓名</th>
					<th width="20%">问题类型</th>
					<th width="20%">开始时间</th>
					<th width="20%">结束时间</th>
				</tr>
				<tr>
					<c:if test="${not empty logs}">
						<c:forEach var="list" items="${logs}">
							<tr>
								<td align="center">${list.assignment.text.course.courseName}</td>
								<td align="center">${list.assignment.text.textTitle}</td>
								<td align="center">${list.user}</td>
								<td align="center">${list.questionType}</td>
								<td align="center">${list.startTime}</td>
								<td align="center">${list.endTime}</td>
							</tr>
						</c:forEach>
					</c:if>
			</table>
	</div>
</body>
</html>
