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
<title><spring:message code="courseSelect"/></title>
<script type="text/javascript"
	src="<c:url value='/resources/js/selectAll.js' />"></script>
</head>
<body>
	<div class="bodyDiv" style="width:90%;margin:30px auto;">
		
		<div class="div4">
		
			<form action="/question/selectCourse" method="post">
				<table class="table table-hover">
					<tr>
						<th><font size="4"><b><spring:message code="courseName"/></b></font></th>
						<th><font size="4" ><b><spring:message code="grade"/></b></font></th>
						<th><font size="4"><b><spring:message code="teacher"/></b></font></th>
						<th><input type="checkbox" id="selectAll"
							onclick="checkEvent('courseIds','selectAll')" /></th>
					</tr>
					<c:if test="${not empty list}">
						<c:forEach var="course" items="${list}">
							<tr>
								<td>${course.courseName}</td>
								<td>${course.year}</td>
								<td>${course.teacher.teaName}</td>
								<td><input type="checkbox" name="courseIds"
									value="${course.courseId}"></td>
							</tr>
						</c:forEach>
					</c:if>
				</table>
				<center>
					<input type="submit" value="<spring:message code='selectCourse'/>" class="btn btn-default"
						onclick="return add('courseIds')" />&nbsp;&nbsp;
				<a href="/question/checkedCourse" class="right"><spring:message code="lookSelectedCourse"/></a> 
				</center>
			</form>
		</div>
		<div><p></p></div>
		<div align="right">
			<table>
				<tr height=20>
					<td height="20" align="center" valign="middle" nowrap>
					<span><spring:message code="total"/>:${sumCount} &nbsp;&nbsp;<spring:message code="currentPage" />:${pageNow} </span>&nbsp; <a
						href="${pageContext.request.contextPath}" id="first"><spring:message code="firstPage"/></a>&nbsp;
						<c:if test="${pageNow>1}">
							<a href="${pageContext.request.contextPath}" id="forwrad"><spring:message code="previous"/></a>&nbsp;
									</c:if> <c:if test="${pageNow<sumCount}">
							<a href="${pageContext.request.contextPath}" id="next"><spring:message code="next"/></a>&nbsp; 
									</c:if> <a href="${pageContext.request.contextPath}" id="end"><spring:message code="lastPage"/></a>&nbsp;
						<span><spring:message code="goto"/></span> <select name="select" id="changePage"
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