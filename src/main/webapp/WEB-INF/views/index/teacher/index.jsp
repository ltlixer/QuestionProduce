<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>

<body>
	<!-- header -->
	<jsp:include page="../../include/teacher/header.jsp"></jsp:include>
	<!-- Main Page -->
	<div class="content">
		<!-- sidebar左侧导航栏 -->
		<jsp:include page="../../include/teacher/sidebar.jsp"></jsp:include>
        
        <div class="content_right">
            <div class="right_nav">
                <span class="glyphicon glyphicon-home " style="font-size: 20px;color: #ffffff;margin-left: 15px;margin-top: 10px"></span>
                <span class="span1" style="color: #ffffff;font-size: 15px;margin-top: 10px;margin-left: 10px;"></span>
                <span class="span2" style="color: #ffffff;font-size: 15px;margin-top: 10px;"></span>
            </div>
            <iframe name="mainFrame" target="_self"  frameborder="0" height="100%" width="100%" src="<c:url value="/resources/html/right.html" />"></iframe>
            
        </div>
    </div>
	<!-- End Main Page -->	
	
	<!-- footer -->	
	<jsp:include page="../../include/teacher/footer.jsp"></jsp:include>		
	
</body>
</html>
