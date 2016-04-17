<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
		$("#time").html(new Date().format("yyyy/MM/dd hh:mm:ss"));	
	   setTimeout("timeShow()",1000);
	    }
	</script>
</head>
<body class="mainBody">
<h1 align="center" style="font-size: 40px">
	<spring:message code="systemName"/> 
</h1>
<p style="font-size: 20px" align="center"><spring:message code="languageSelect"/><a href="/question/language/?locale=zh_cn"><spring:message code="Chinese"/></a>&nbsp;<a  href="/question/language/?locale=en"><spring:message code="English"/></a></p>
<br>
<P style="font-size: 20px" align="center"><spring:message code="nowTime"/><label id="time"></label></P>
<br>
<div align="center">
<font size="5">
<a href="<c:url value='/resources/question/main.html' />"><spring:message code="online"/></a><br><br>

<a href="/question/linkStuLogin"><spring:message code="stuEnt"/></a><br><br>
<a href="/question/linkTeaLogin "><spring:message code="teaEnt"/></a><br><br>
</font>
</div>

</body>
</html>
