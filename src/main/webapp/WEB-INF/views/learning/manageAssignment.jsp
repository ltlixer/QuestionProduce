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
<link href="<c:url value='/resources/css/main.css' />" rel="stylesheet"
	type="text/css" media="screen" />
	<script type="text/javascript"
	src="<c:url value='/resources/js/delete.js' />"></script>
<script type="text/javascript" src="<c:url value='/resources/jQuery/jquery-1.7.2.js' />"></script>
<script type="text/javascript">
$(function(){
	$("#first").click(function(){
		var sumPage = ${sumCount};
		this.href=this.href+"/assignment/queryAssignment/1?sumPage="+sumPage
	});
	$("#end").click(function(){
		var sumPage = ${sumCount};
		this.href=this.href+"/assignment/queryAssignment/"+sumPage+"?sumPage="+sumPage
	});
	$("#forwrad").click(function(){
		var sumPage = ${sumCount};
		var pageNow = ${pageNow}-1;
		this.href=this.href+"/assignment/queryAssignment/"+pageNow+"?sumPage="+sumPage
	});
	$("#next").click(function(){
		var sumPage = ${sumCount};
		var pageNow = ${pageNow}+1;
		this.href=this.href+"/assignment/queryAssignment/"+pageNow+"?sumPage="+sumPage
	});
	$("#changePage").change(function(){
		var sumPage = ${sumCount};
		var pageNow = this.value;
		var link = $("#link");
		link[0].href=link[0].href+"/assignment/queryAssignment/"+pageNow+"?sumPage="+sumPage
		link[0].click();
	});
	
})
</script>
<title>管理已发布作业</title>
</head>
<body>
	<div class="bodyDiv">
		<div class="div1">
			<img src="<c:url value='/resources/images/icon.png'/>" />&nbsp;<span><spring:message code="site"/>：<spring:message code="learningResourceManagement"/>>><spring:message code="homeworkManagement"/></span>
		</div>
		<h2><spring:message code="homeworkManagement"/></h2>
		<div class="div4">
			<table border="1" class="editTab">
	<tr>
	<th colspan="8" align="center"><spring:message code="publishedAss"/></th>
	</tr>
			<tr>
				<th align="center" width="15%"><spring:message code="textTitle"/></th>
				<th align="center" width="10%"><spring:message code="courseName"/></th>
				<th align="center" width="15%"><spring:message code="assTitle"/></th>
				<th align="center" width="10%"><spring:message code="limited"/></th>
				<th align="center" width="15%"><spring:message code="createTime"/></th>
				<th align="center" width="10%"><spring:message code="publishTeacher"/></th>
				<th align="center" width="15%"><spring:message code="lookQuestion"/></th>
				<th align="center" width="10%"><spring:message code="deleteAss"/></th>
			</tr>
			<c:forEach var="ass" items="${list}">
			<tr>
				<td align="center">${ass.text.textTitle}</td>
				<td align="center">${ass.text.course.courseName}</td>
				<td align="center">${ass.assName}</td>
				<td align="center">${ass.assTime}<spring:message code="minute"/></td>
				<td align="center">${ass.createTime}</td> 
				<td align="center">${ass.teacher.teaName}</td>
				<td align="center"><a
					href="/question/question/tealinkQuestionPage/${ass.assId}"><spring:message code="viewDetail"/></a></td>
			<td align="center"><a
					href="/question/assignment/deleteAssignment/${ass.assId}" onclick='return deleteItem()'><spring:message code="delete"/> </a></td>
		
			</tr>
		</c:forEach>

	</table> 
	</div>
	<div class="div6" align="center">
						<table>
						
								<tr  height=20>
									<td height="20" align="center" valign="middle" nowrap>
									<span><spring:message code="total"/>:${sumCount} &nbsp;&nbsp;<spring:message code="currentPage"/>：${pageNow}
									</span>&nbsp; 
									<a href="${pageContext.request.contextPath}" id="first"><spring:message code="firstPage"/></a>&nbsp; 
									<c:if test="${pageNow>1}">
										<a href="${pageContext.request.contextPath}" id="forwrad"><spring:message code="previous"/></a>&nbsp;
									</c:if>
									<c:if test="${pageNow<sumCount}">
										<a	href="${pageContext.request.contextPath}" id="next"><spring:message code="next"/></a>&nbsp; 
									</c:if>
									<a href="${pageContext.request.contextPath}" id="end"><spring:message code="lastPage"/></a>&nbsp; 
									<span><spring:message code="goto"/></span>
										<select name="select" id="changePage" style="WIDTH: 40px">
										<c:if test="${sumCount>0}">
										<option value="${pageNow}">${pageNow}</option>
										<c:forEach var="i" begin="1" end="${sumCount}">
											< <c:if test="${i!=pageNow }">
												<option value="${i}">${i}</option>
											</c:if>
											</c:forEach>
										</c:if>
									</select>
									<a href="${pageContext.request.contextPath}" id="link"></a>
									</td>
								</tr>
								</table>
			</div>
	</div>
</body>
</html>