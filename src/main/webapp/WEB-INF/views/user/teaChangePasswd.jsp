<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="../com/easyui.jsp" %>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"> 
<title>密码修改</title>
<head>


<link href="<c:url value='/resources/css/easylayout.css' />" rel="stylesheet"
	type="text/css" media="screen" />
<script type="text/javascript" src="<c:url value='/resources/js/dialog.js'/>"></script> 

<script type="text/javascript">
$(function(){
	 createDialog("content","<spring:message code='changePassword'/>");
});

	function checkInfo() {
		 var oldpass=document.getElementsByName("oldpassword");
		  var newpass=document.getElementsByName("newPassword");
		  var repass=document.getElementsByName("renewPassword");
		  var ps =document.getElementsByName("ps");
		 if(oldpass[0].value==""){
			 $("#oldpassword").text("<spring:message code='oldPasswordNotNUll'/>");
			 return false;
		 }else if(ps[0].value!=oldpass[0].value){
			 $("#oldpassword").text("<spring:message code='oldPasswordNotRight'/>");
			 return false;
		 }else if(newpass[0].value==""){
			 $("#newPassword").text("<spring:message code='newPasswordNotNull'/>");
			 return false;
		 }else{
			 if(newpass[0].value!=repass[0].value){
				 $("#renewPassword").text("<spring:message code='rePasswordNotRight'/>");
				 return false;
			 }else{
				 return true;
			 }
			 
		 }
	}
</script>
</head>

 <body>
	<div id="content" align="center">
	<br><br><br>
		<label style="font-family: 微软雅黑,Tohoma;font-size: 16" >${name}<spring:message code="welcome"/></label><br><br><br>
		<form action="/question/updateTeaPassword" method="post" onsubmit="return checkInfo()" name="form" target="_top">
			<input type="hidden" name="ps" value="${ps}"/>
			<input type="hidden" name="id" value="${id}"/>
			<div class="div_ul">
			<ul>
			
				<li>
					<label style="font-family: 微软雅黑,Tohoma"><spring:message code="oldPassword"/></label>
					<input type="password" name="oldpassword"/>
					 <span style="color: red" id="oldpassword"> </span> 
				</li>
				<li>
					<label style="font-family: 微软雅黑,Tohoma"><spring:message code="newPassword"/></label>
					<input type="password" name="newPassword" value="">
					<span style="color: red" id="newPassword"> </span> 
				</li>
				
				<li>
					<label style="font-family: 微软雅黑,Tohoma"><spring:message code="repassword"/></label>
					<input type="password" name="renewPassword" value="">
					<span style="color: red" id="renewPassword"> </span> 
				<li>
				<li style="text-align: center; padding: 0px; height: 40px; line-height: 40px;">
					
					<input class="btnPaleGreen" type="submit" value="<spring:message code='ok'/>"/>
					<input class="btnGray" type="reset" value="<spring:message code='reset'/>">
					
				</li>
			</ul>
			</div>
		</form>
	</div>

</body> 
</HTML>