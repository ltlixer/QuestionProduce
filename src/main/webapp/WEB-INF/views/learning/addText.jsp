<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"> 

<title>My JSP 'userList.jsp' starting page</title>
<link href="<c:url value='/resources/css/main.css' />"
	rel="stylesheet" type="text/css" media="screen" />
	<script type="text/javascript" src="<c:url value='/resources/jQuery/jquery-1.7.2.js' />"></script>
<script type="text/javascript">
$(function(){
	$("#img").hide();
	$(".text").focus(function(){
		$(this).css("background", "#CCFFFF");
	}).blur(function(){
		$(this).css("background", "#FFFFFF");
	});
	$("#textTitle").focus(function(){
		$("label#textTitleInfor").text("");
	});
	$("#texFile").click(function(){
		$("label#textFileInfor").text("");
	});
})

function addText() {
	if($.trim($("#textTitle").val())==""){
		$("label#textTitleInfor").text("<spring:message code='courseTitleNotNull'/>");
		return false;
	} else if($("#texFile").val()==""){
		$("label#textFileInfor").text("<spring:message code='courseResourceNotNull'/>");
		return false;
	} else{
		$("#img").show();
		var val = $("#texFile").val();
		if(val.indexOf(".doc")==-1&&val.indexOf(".docx")==-1){
			$("#img").hide();
			$("label#textFileInfor").text("<spring:message code='courseResourceNotDOC'/>");
			return false;
		}
		return true;
	}
	
}
</script>
</head>
<body>
	<div class="bodyDiv">
		<div class="div1">
		<img src="<c:url value='/resources/images/icon.png'/>"/>&nbsp;<span><spring:message code="site"/>：<spring:message code="postAss"/>&gt;&gt;<spring:message code="uploadLearningResources"/></span>
		</div>
			<div class="div2" align="center">
			<form:form action="/question/text/uploadText" enctype="multipart/form-data" method="post" commandName="text">
				<table align="center">
					<tr><td colspan="3"><h2><spring:message code="uploadLearningResources"/></h2></td></tr>
					<tr><td width="30%" align="center"><spring:message code="uploadTeacher"/></td>
						<td width="40%">${teaName}</td>
						<td width="30%"></td>
					</tr>
					<tr><td align="center"><spring:message code="courseTitle"/></td>
						<td><form:input type="text" id="textTitle" class="text" path="textTitle"/><font color="red">*</font></td>
						<td><label style="color: red" id="textTitleInfor"></label></td>
					</tr>
					<tr><td align="center"><spring:message code="courseSelect"/></td>
						<td>
						<select id="brand" class="text" name="courseId">
							<c:if test="${not empty listCourse}">
									<c:forEach var ="course" items="${listCourse}">
										<option value="${course.courseId}">${course.year} - ${course.courseName}</option>
									</c:forEach>
							</c:if>
						</select><font color="red">*</font>
						</td>
						<td></td>
					</tr>
					<%-- <tr><td align="center">设置学习时间</td>
						<td>
						<form:select id="textTime" class="text" path="textTime">
							<option value="10">10分钟</option>
							<option value="5">5分钟</option>
							<option value="6">6分钟</option>
							<option value="8">8分钟</option>
							<option value="15">15分钟</option>
							<option value="20">20分钟</option>
							<option value="30">30分钟</option>
							<option value="30">40分钟</option>
						</form:select><font color="red">*</font>
						<form:input type="text" class="text" path="textTime"/></td>
						<td></td>
					</tr> --%>
					<tr><td align="center"><spring:message code="uploadText"/></td>
						<td><input type="file" id="texFile" name="files" ><font color="red">* （*.doc/*.docx）</font></td>
						<td><label style="color: red" id="textFileInfor">${infor}</label></td>
					</tr>
					
					<!-- <tr><td align="center">课文附件资料一</td>
					<td><input type="file" name="files" >（可为空）</td>
					<td></td>
					</tr>
					<tr><td align="center">课文附件资料二</td>
					<td><input type="file" name="files" >（可为空）</td>
					<td></td>
					</tr> -->
					<tr><td align="right"><img width="20px" id="img" src="<c:url value='/resources/images/loading.gif'/>"></td>
						<td><input type="submit" onclick="return addText()" class="btnPaleGreen" value="<spring:message code='upload'/>">
						</td>
						<td></td>
					</tr>
					<tr><td align="center"><spring:message code="prompt"/></td>
						<td><spring:message code="prompt1"/><br>
						    <spring:message code="prompt2"/><br>
							</td>
						<td></td>
					</tr>
				</table>
    </form:form>
   	 	<p><font color="red">${message}</font></p>
			</div>
			
		</div>
</body>
</html>
