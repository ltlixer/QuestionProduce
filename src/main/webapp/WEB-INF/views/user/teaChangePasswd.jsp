<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../com/easyui.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"> 
<title>密码修改</title>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="<c:url value='/resources/css/easylayout.css' />" rel="stylesheet"
	type="text/css" media="screen" />
<script type="text/javascript" src="<c:url value='/resources/js/dialog.js'/>"></script> 

<script type="text/javascript">
$(function(){
	 createDialog('content','密码修改');
});

	function checkInfo() {
		 var oldpass=document.getElementsByName("oldpassword");
		  var newpass=document.getElementsByName("newPassword");
		  var repass=document.getElementsByName("renewPassword");
		  var ps =document.getElementsByName("ps");
		 if(oldpass[0].value==""){
			 $("#oldpassword").text("原始密码不能为空");
			 return false;
		 }else if(ps[0].value!=oldpass[0].value){
			 $("#oldpassword").text("原始密码不正确！");
			 return false;
		 }else if(newpass[0].value==""){
			 $("#newPassword").text("新密码不能为空");
			 return false;
		 }else{
			 if(newpass[0].value!=repass[0].value){
				 $("#renewPassword").text("两次输入的密码不一致！");
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
		<label style="font-family: 微软雅黑,Tohoma;font-size: 16" >${name}教师，你好！</label><br><br><br>
		<form action="/question/updateTeaPassword" method="post" onsubmit="return checkInfo()" name="form" target="_top">
			<input type="hidden" name="ps" value="${ps}"/>
			<input type="hidden" name="id" value="${id}"/>
			<div class="div_ul">
			<ul>
			
				<li>
					<label style="font-family: 微软雅黑,Tohoma">原始密码</label>
					<input type="password" name="oldpassword"/>
					 <span style="color: red" id="oldpassword"> </span> 
				</li>
				<li>
					<label style="font-family: 微软雅黑,Tohoma">新密码</label>
					<input type="password" name="newPassword" value="">
					<span style="color: red" id="newPassword"> </span> 
				</li>
				
				<li>
					<label style="font-family: 微软雅黑,Tohoma">确认新密码</label>
					<input type="password" name="renewPassword" value="">
					<span style="color: red" id="renewPassword"> </span> 
				<li>
				<li style="text-align: center; padding: 0px; height: 40px; line-height: 40px;">
					
					<input class="btnPaleGreen" type="submit" value="确认"/>
					<input class="btnGray" type="reset" value="重置">
					
				</li>
			</ul>
			</div>
		</form>
	</div>

</body> 
</HTML>