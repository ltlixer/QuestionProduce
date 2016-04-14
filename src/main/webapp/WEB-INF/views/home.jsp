<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8"> 
 <link href="<c:url value='/resources/css/main.css' />" rel="stylesheet"
	type="text/css" media="screen" />
	<script type="text/javascript"
	src="<c:url value='/resources/jQuery/jquery-1.7.2.js' />"></script>
	<script type="text/javascript"
	src="<c:url value='/resources/js/dateFormat.js'/>"></script>
	<title>系统主页</title>
	<script type="text/javascript">
	$(function(){
		timeShow();
	})
	 function timeShow(){
		$("#time").html(new Date().format("yyyy年MM月dd日 hh:mm:ss"));	
	   setTimeout("timeShow()",1000);
	    }
	</script>
</head>
<body class="mainBody">
<h1 align="center" style="font-size: 40px">
	中文智能提问系统  
</h1>
<br>
<P style="font-size: 20px" align="center"> 现在的时间是：<label id="time"></label></P>
<br>
<div align="center">
<font size="5">
<a href="<c:url value='/resources/question/main.html' />">在线演示</a><br><br>
<!-- <a href="/question/easyUI">EasyUI测试</a><br><br> -->

<a href="/question/linkStuLogin">学生入口</a><br><br>
<a href="/question/linkTeaLogin ">教师入口</a><br><br>
</font>
</div>
<%-- <div style="width: 50px; height: 50px"><a href="/question/easyUI"><img  width="90%"  src="<c:url value='/resources/images/tea.jpg' />"></a></div>  
<table align="center">
<tr>
<td width="40%" align="center"><a href="/question/linkStuLogin"><img width="90%" src="<c:url value='/resources/images/stu.jpg' />"></a></td>
<td width="20%"></td>
<td width="40%" align="center"><a href="/question/linkTeaLogin"><img  width="90%"  src="<c:url value='/resources/images/tea.jpg' />"></a></td>
</tr>
<tr>
<td width="40%" align="center"><b style="font-size: 25px">学生登录入口</b></td>
<td></td>
<td width="40%" align="center"><b style="font-size: 25px">教师登录入口</b></td>
</tr>
</table>--%>
</body>
</html>
