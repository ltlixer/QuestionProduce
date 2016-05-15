 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<c:url value='/resources/css/bootstrap.min.css' />" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<c:url value='/resources/jQuery/jquery-1.7.2.js' />"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="bodyDiv" style="width:90%;margin:30px auto;">
		<div class="div4">
				<table class="table table-hover">
					<tr>
						<td colspan="4"><h2><spring:message code="selectedCourse"/></h2></td>
					</tr>
					<tr>
						<th><font size="4"><b><spring:message code="courseName"/></b></font></th>
						<th><font size="4" ><b><spring:message code="grade"/></b></font></th>
						<th><font size="4"><b><spring:message code="teacher"/></b></font></th>
						<th><font size="4"><b><spring:message code="backCourse"/></b></font></th>
					</tr>
					<c:forEach var="course" items="${course}">

						<tr>
							<td>${course.courseName}</td>
							<td>${course.year}</td>
							<td>${course.teacher.teaName}</td>
							<td><a href="/question/deleteCourseBystu/${course.courseId}"><spring:message code="backCourse"/></a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="div6"></div>

			</div>
</body>
</html> 