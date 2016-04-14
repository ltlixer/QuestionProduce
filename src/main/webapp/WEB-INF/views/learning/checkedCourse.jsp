 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<c:url value='/resources/css/main.css' />" rel="stylesheet"
	type="text/css" media="screen" />
<script type="text/javascript" src="<c:url value='/resources/jQuery/jquery-1.7.2.js' />"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="bodyDiv">
		<div class="div1">
			<img src="<c:url value='/resources/images/icon.png'/>" />&nbsp;<span>位置：已选择的课程</span>
		</div>
		<div class="div4">
				<table class="editTab" border="1">
					<tr>
						<td colspan="4"><h2>已经选择的课程</h2></td>
					</tr>
					<tr>
						<th align="center"><font size="4"><b>课程名</b></font></th>
						<th align="center"><font size="4" ><b>年级</b></font></th>
						<th align="center"><font size="4"><b>授课教师</b></font></th>
						<th align="center"><font size="4"><b>退选</b></font></th>
					</tr>
					<c:forEach var="course" items="${course}">

						<tr>
							<td align="center">${course.courseName}</td>
							<td align="center">${course.year}</td>
							<td align="center">${course.teacher.teaName}</td>
							<td align="center"><a href="/question/deleteCourseBystu/${course.courseId}">退选</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="div6"></div>

			</div>
</body>
</html> 