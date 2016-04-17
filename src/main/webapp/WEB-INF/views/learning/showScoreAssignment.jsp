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
<script type="text/javascript" src="<c:url value='/resources/jQuery/jquery-1.7.2.js' />"></script>
<script type="text/javascript">
$(function(){
	$("#first").click(function(){
		var sumPage = ${sumCount};
		this.href=this.href+"/assignment/showScoreAssignment/1?sumPage="+sumPage
	});
	$("#end").click(function(){
		var sumPage = ${sumCount};
		this.href=this.href+"/assignment/showScoreAssignment/"+sumPage+"?sumPage="+sumPage
	});
	$("#forwrad").click(function(){
		var sumPage = ${sumCount};
		var pageNow = ${pageNow}-1;
		this.href=this.href+"/assignment/showScoreAssignment/"+pageNow+"?sumPage="+sumPage
	});
	$("#next").click(function(){
		var sumPage = ${sumCount};
		var pageNow = ${pageNow}+1;
		this.href=this.href+"/assignment/showScoreAssignment/"+pageNow+"?sumPage="+sumPage
	});
	$("#changePage").change(function(){
		var sumPage = ${sumCount};
		var pageNow = this.value;
		var link = $("#link");
		link[0].href=link[0].href+"/assignment/showScoreAssignment/"+pageNow+"?sumPage="+sumPage
		link[0].click();
	});
	
})
</script>
<title>课外作业成绩</title>
</head>
<body >
	<div class="bodyDiv">
		<div class="div1">
			<img src="<c:url value='/resources/images/icon.png'/>" />&nbsp;<span><spring:message code="site"/>：<spring:message code="scoreManagement"/>&gt;&gt;<spring:message code="homeworkScore"/></span>
		</div>
		<h2><spring:message code="homeworkScore"/></h2>
		<div class="div4">
			<table class="editTab" border="3">
					<tr>
					<th align="center" width="15%"><spring:message code="textTitle"/></th>
					<th align="center" width="15%"><spring:message code="courseName"/></th>
					<th align="center" width="10%"><spring:message code="stu"/></th>
					<th align="center" width="10%"><spring:message code="actualHours"/></th>
					<th align="center" width="10%"><spring:message code="assScore"/></th>
					<th align="center" width="30%"><spring:message code="evaluation"/></th>
					<th align="center" width="10%"><spring:message code="viewDetail"/></th>
					</tr>
					<c:forEach var="list" items="${list}">
					<tr>
					<td align="center" >${list.assignment.text.textTitle}</td>
					<td align="center">${list.assignment.text.course.courseName}</td>
					<td align="center">${list.student.stuName }</td>
					<td align="center">${list.useTime }<spring:message code="minute"/></td>
					<td align="center"><fmt:formatNumber value="${list.score}" pattern="#0.0"/></td>
					<td align="center">${list.evaluate}</td>
					<td align="center"><a href="/question/answer/showAnswer/${list.saId}"><spring:message code="look"/></a></td>
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