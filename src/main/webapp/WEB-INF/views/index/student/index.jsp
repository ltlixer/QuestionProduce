<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<frameset rows="60,*,30" frameborder="no" framespacing="0" style="min-width:769px;">
	<frame name="header" src="<c:url value='/resources/html/student/header.html?stuName=${stu.stuName}'/>" scrolling="no"></frame>
	<frameset cols="240,*" frameborder="no" framespacing="0">
		<frame name="sidebar" src="<c:url value="/resources/html/student/sidebar.html" />" scrolling="no"></frame>
		<frameset name="frameset_right" rows="42,*" frameborder="no" framespacing="0" >
			<frame name="route" src="<c:url value='/resources/html/student/route.html'/>" scrolling="no"></frame>
			<frame name="mainFrame" src="<c:url value="/resources/html/right-student.html" />"></frame>
		</frameset>
	</frameset>
   <frame name="footer" src="<c:url value='/resources/html/student/footer.html' />" scrolling="no"></frame>
 </frameset>