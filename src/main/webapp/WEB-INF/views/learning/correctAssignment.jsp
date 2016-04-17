<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<c:url value='/resources/css/main.css' />" rel="stylesheet"
	type="text/css" media="screen" />
<script type="text/javascript"
	src="<c:url value='/resources/jQuery/jquery-1.7.2.js' />"></script>
<script type="text/javascript">
	
	$(function(){
		$("#first").click(function(){
			var sumPage = ${sumCount};
			this.href=this.href+"/assignment/queryScoreAssignment/1?sumPage="+sumPage
		});
		$("#end").click(function(){
			var sumPage = ${sumCount};
			this.href=this.href+"/assignment/queryScoreAssignment/"+sumPage+"?sumPage="+sumPage
		});
		$("#forwrad").click(function(){
			var sumPage = ${sumCount};
			var pageNow = ${pageNow}-1;
			this.href=this.href+"/assignment/queryScoreAssignment/"+pageNow+"?sumPage="+sumPage
		});
		$("#next").click(function(){
			var sumPage = ${sumCount};
			var pageNow = ${pageNow}+1;
			this.href=this.href+"/assignment/queryScoreAssignment/"+pageNow+"?sumPage="+sumPage
		});
		$("#changePage").change(function(){
			var sumPage = ${sumCount};
			var pageNow = this.value;
			var link = $("#link");
			link[0].href=link[0].href+"/assignment/queryScoreAssignment/"+pageNow+"?sumPage="+sumPage
			link[0].click();
		});
		
	})
	
</script>
<title>批改作业</title>
</head>
<body>
	<div class="bodyDiv">
		<div class="div1">
			<img src="<c:url value='/resources/images/icon.png'/>" />&nbsp;<span><spring:message code="site"/>：<spring:message code="scoreManagement"/>&gt;&gt;<spring:message code="markHomework"/></span>
		</div>
		<h2><spring:message code="markHomework"/></h2>
		<div class="div4">
			<p align="center">
				<label style="color: red" id="errorInfor"></label>
			</p>

			<form action="/question/assignment/submitCorrect">
				<table class="editTab" border="3">
					<tr>
						<th colspan="10" align="center"><spring:message code="needMarkHomework"/></th> 
					</tr>
					<tr>
					<th align="center" width="10%"><spring:message code="textTitle"/></th>
					<th align="center" width="10%"><spring:message code="courseName"/></th>
					<th align="center" width="10%"><spring:message code="assTitle"/></th>
					<th align="center" width="10%"><spring:message code="limited"/></th>
					<th align="center" width="10%"><spring:message code="actualHours"/></th>
					<th align="center" width="10%"><spring:message code="stuSubmitTime"/></th>
					<th align="center" width="10%"><spring:message code="score"/></th>
					<th align="center" width="10%"><spring:message code="stuName"/></th>
					<th align="center" width="10%"><spring:message code="markState"/></th>
					<th align="center" width="10%"><spring:message code="modifyScore"/></th>
				</tr>
				<c:forEach var="correctAssignment" items="${list}">
					<tr>
						<td align="center">${correctAssignment.assignment.text.textTitle}</td>
						<td align="center">${correctAssignment.assignment.text.course.courseName}</td>
						<td align="center">${correctAssignment.assignment.assName}</td>
						<td align="center">${correctAssignment.assignment.assTime}<spring:message code="minute"/></td>
						<td align="center">${correctAssignment.useTime}<spring:message code="minute"/></td>
						<td align="center">${correctAssignment.createTime}</td>
						<td align="center"><fmt:formatNumber value="${correctAssignment.score}" pattern="#0.0"/></td>
						<td align="center">${correctAssignment.student.stuName}</td>
						 <c:if test="${correctAssignment.correct==1}">
							<td align="center"><spring:message code="teacherMark"/></td>
						</c:if>
						 <c:if test="${correctAssignment.correct==-1}">
							<td align="center"><spring:message code="systemMark"/></td>
						</c:if>
						
						<td align="center"><a href="/question/answer/tealinkAnswerPage/${correctAssignment.saId}"><spring:message code="modifyScore"/></a></td>
					</tr>
				</c:forEach>

				</table>
			</form>
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