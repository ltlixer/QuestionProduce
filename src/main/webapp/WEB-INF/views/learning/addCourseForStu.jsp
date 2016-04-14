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
<script type="text/javascript">
$(function(){
	$("#first").click(function(){
		var sumPage = ${sumCount};
		this.href=this.href+"/queryCourse/1?sumPage="+sumPage
	});
	$("#end").click(function(){
		var sumPage = ${sumCount};
		this.href=this.href+"/queryCourse/"+sumPage+"?sumPage="+sumPage
	});
	$("#forwrad").click(function(){
		var sumPage = ${sumCount};
		var pageNow = ${pageNow}-1;
		this.href=this.href+"/queryCourse/"+pageNow+"?sumPage="+sumPage
	});
	$("#next").click(function(){
		var sumPage = ${sumCount};
		var pageNow = ${pageNow}+1;
		this.href=this.href+"/queryCourse/"+pageNow+"?sumPage="+sumPage
	});
	$("#changePage").change(function(){
		var sumPage = ${sumCount};
		var pageNow = this.value;
		var link = $("#link");
		link[0].href=link[0].href+"/queryCourse/"+pageNow+"?sumPage="+sumPage
		link[0].click();
	});
	
})
</script>
<title>选择课程</title>
<script type="text/javascript"
	src="<c:url value='/resources/js/selectAll.js' />"></script>
</head>
<body>
	<div class="bodyDiv">
		<div class="div1">
			<img src="<c:url value='/resources/images/icon.png'/>" />&nbsp;<span>位置：选择老师</span>
		</div>
		<h2>选择课程</h2>
		<div class="div4">
		<center> <a href="/question/checkedCourse">查看已选择的课程
		</a> </center> 
			<form action="/question/selectCourse" method="post">
				<table class="editTab" border="1">
					<tr>
						<th colspan="4">可选择的课程</th>
					</tr>
					<tr>
						<th align="center"><font size="4"><b>课程名</b></font></th>
						<th align="center"><font size="4" ><b>年级</b></font></th>
						<th align="center"><font size="4"><b>授课教师</b></font></th>
						<th align="center"><input type="checkbox" id="selectAll"
							onclick="checkEvent('courseIds','selectAll')" /></th>
					</tr>
					<c:if test="${not empty list}">
						<c:forEach var="course" items="${list}">
							<tr>
								<td align="center">${course.courseName}</td>
								<td align="center">${course.year}</td>
								<td align="center">${course.teacher.teaName}</td>
								<td align="center"><input type="checkbox" name="courseIds"
									value="${course.courseId}"></td>
							</tr>
						</c:forEach>
					</c:if>
				</table>
				<p class="operationBtn">
					<input type="submit" value="选课" class="btnPaleGreen"
						onclick="return add('courseIds')" />&nbsp;&nbsp;
				</p>
			</form>
		</div>

		<div class="div6" align="center">
			<table>

				<tr height=20>
					<td height="20" align="center" valign="middle" nowrap>
					<span>共-${sumCount}-页 &nbsp;&nbsp;第-${pageNow}-页 </span>&nbsp; <a
						href="${pageContext.request.contextPath}" id="first">首页</a>&nbsp;
						<c:if test="${pageNow>1}">
							<a href="${pageContext.request.contextPath}" id="forwrad">上一页</a>&nbsp;
									</c:if> <c:if test="${pageNow<sumCount}">
							<a href="${pageContext.request.contextPath}" id="next">下一页</a>&nbsp; 
									</c:if> <a href="${pageContext.request.contextPath}" id="end">尾页</a>&nbsp;
						<span>跳转到</span> <select name="select" id="changePage"
						style="WIDTH: 40px">
							<c:if test="${sumCount>0}">
								<option value="${pageNow}">${pageNow}</option>
								<c:forEach var="i" begin="1" end="${sumCount}">
											< <c:if test="${i!=pageNow }">
										<option value="${i}">${i}</option>
									</c:if>
								</c:forEach>
							</c:if>
					</select> <a href="${pageContext.request.contextPath}" id="link"></a></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>