<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>学生在线学习系统--学生端</title>
  </head>
	<frameset rows="60,*,28" frameborder="no" framespacing="0" >
  			<frame src="<c:url value='/resources/html/stutop.html?s=${stu.stuName}'/>" scrolling="no"></frame>
	        <frameset id="centerSet" cols="210,10,*" frameborder="no" framespacing="0">
				<frame src="<c:url value="/resources/html/stuleft.html" />" scrolling="no"></frame>
				<frame src="<c:url value="/resources/html/center.html" />" scrolling="no"></frame>
				<frame src="<c:url value="/resources/html/sturight.html" />" name="mainFrame"></frame>
	        </frameset>
	        <frame src="<c:url value="/resources/html/bottom.html"/>" scrolling="no"></frame>
  </frameset>
</html>
