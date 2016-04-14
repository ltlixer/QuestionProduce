<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>学生在线学习系统-教师端</title>
  </head>
	<frameset rows="60,*,28" frameborder="no" framespacing="0" >
  			<frame src="<c:url value='/resources/html/teatop.html?s=${tea.teaNum}'/>" scrolling="no"></frame>
	        <frameset id="centerSet" cols="210,10,*" frameborder="no" framespacing="0">
				<frame src="<c:url value="/resources/html/tealeft.html" />" scrolling="no"></frame>
				<frame src="<c:url value="/resources/html/center.html" />" scrolling="no"></frame>
				<frame src="<c:url value="/resources/html/tearight.html" />" name="mainFrame"></frame>
	        </frameset>
	        <frame src="<c:url value="/resources/html/bottom.html"/>" scrolling="no"></frame>
  </frameset>
</html>
