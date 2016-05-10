<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
function selectedCourse(courseId){
	var url = "/question/text/queryTextByCourseId/"+courseId;
	var textSelect = document.getElementById("textSelect");
	var assList = document.getElementById("assList");
	if(typeof(assList) != "undefined" && assList != null){
		assList.innerHTML = "";
	}
	$.ajax({
         type: "get",
         dataType: "json",
         url: url,
         success: function (msg) {
             var str = "<label>课文：</label>";
             str += "<select id='textList' class='text' name='textId' onchange='selectedText(this.options[this.options.selectedIndex].value);'>";
			 str += "<option value='-1' style='display:none;'>--请选择课文--</option>";
             for (i in msg) {
            	 var textId = msg[i].textId;
            	 var textTitle = msg[i].textTitle;
                 str += "<option value='"+textId+"'>"+textTitle+"</option>";
             }
             str += "</select>";
             textSelect.innerHTML = str;
         }
     });
}
function selectedText(textId){
	var url = "/question/assignment/queryTextUndoneAssignmentByText/"+textId;
	self.location = url;
}
</script>
</head>
<body>
	<div class="bodyDiv">
		<div class="div1">
			<img src="<c:url value='/resources/images/icon.png'/>" />&nbsp;<span><spring:message code="site"/>：<spring:message code="onlineAss"/>>><spring:message code="queryAss"/></span>
		</div>
		<h2><spring:message code="queryAss"/></h2>
		<input id="link" type="hidden" value="${link}">
		<c:if test="${courseSize=='0'}">
			<div style="text-align:center;">
				<font size="4">
					<spring:message code="courseSelectThenLearn"/>
					<button  onclick="return select()" class="btnPaleGreen">
						<spring:message code="toCourseSelect"/>
					</button>
				</font>
			</div>
		</c:if>
		<c:if test="${not empty courses}">
			<font size="4">作业筛选       </font>
			<label>班级：</label>
			<select id="courseList" name="course" style="width: 200px"  onchange="selectedCourse(this.options[this.options.selectedIndex].value);">
				<option value="-1" style="display:none;">--请选择课程--</option>
				<c:forEach var ="course" items="${courses}">
					<option value="${course.courseId}">${course.year} - ${course.courseName}</option>
				</c:forEach>
			</select>
			<span id="textSelect"></span>
		</c:if>
		
		<hr color="#00aaff">
		<div class="div4" id="div4">
		<center><spring:message code="lookFinishedAss"/>：<a
				href="/question/assignment/finishedAssignment/1"><spring:message code="look"/>
			</a></center>
			<table border="1" class="editTab">
				<tr>
					<th colspan="7"><spring:message code="newAss"/></th>
				</tr>
				
				<tr>
				
			</tr>
				<tr>
					<th align="center" width="15%"><spring:message code="textTitle"/></th>
					<th align="center" width="15%"><spring:message code="assTitle"/></th>
					<th align="center" width="15%"><spring:message code="courseName"/></th>
					<th align="center" width="10%"><spring:message code="limited"/></th>
					<th align="center" width="15%"><spring:message code="publishTime"/></th>
					<th align="center" width="15%"><spring:message code="publishTeacher"/></th>
					<th align="center" width="15%"><spring:message code="clickBegin"/></th>
				</tr>
					<c:if test="${infor=='no'}">
					<tr><td colspan="7" align="center"><font color="red" size="4"> <spring:message code="teacherHasNoAss"/></font></td></tr>
					</c:if>
				<c:forEach var="ass" items="${assignments}">
					<tr>
						<td align="center">${ass.text.textTitle}</td>
						<td align="center">${ass.assName}</td>
						<td align="center">${ass.text.course.courseName}</td>
						<td align="center">${ass.assTime}<spring:message code="minute"/></td>
						<td align="center">${ass.createTime}</td>
						<td align="center">${ass.teacher.teaName}</td>
						<td align="center"><a
							href="/question/question/stulinkQuestionPage/${ass.assId}"><spring:message code="beginAss"/>
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