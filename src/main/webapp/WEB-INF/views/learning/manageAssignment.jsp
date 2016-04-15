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
			<img src="<c:url value='/resources/images/icon.png'/>" />&nbsp;<span>位置：学习资料管理>>课外作业管理</span>
		</div>
		<h2>课外作业管理</h2>
		<div class="div4">
			<table border="1" class="editTab">
	<tr>
	<th colspan="8" align="center">已发布的作业</th>
	</tr>
			<tr>
				<th align="center" width="15%">课文标题</th>
				<th align="center" width="10%">科目</th>
				<th align="center" width="15%">作业标题</th>
				<th align="center" width="10%">限时</th>
				<th align="center" width="15%">创建时间</th>
				<th align="center" width="10%">发布教师</th>
				<th align="center" width="15%">查看问题</th>
				<th align="center" width="10%">删除作业</th>
			</tr>
			<c:forEach var="ass" items="${list}">
			<tr>
				<td align="center">${ass.text.textTitle}</td>
				<td align="center">${ass.text.course.courseName}</td>
				<td align="center">${ass.assName}</td>
				<td align="center">${ass.assTime}分钟</td>
				<td align="center">${ass.createTime}</td> 
				<td align="center">${ass.teacher.teaName}</td>
				<td align="center"><a
					href="/question/question/tealinkQuestionPage/${ass.assId}">查看详细</a></td>
			<td align="center"><a
					href="/question/assignment/deleteAssignment/${ass.assId}" onclick='return deleteItem()'>删除 </a></td>
		
			</tr>
		</c:forEach>

	</table> 
	</div>
	<div class="div6" align="center">
						<table>
						
								<tr  height=20>
									<td height="20" align="center" valign="middle" nowrap>
									<span>共-${sumCount}-页  &nbsp;&nbsp;第-${pageNow}-页
									</span>&nbsp; 
									<a href="${pageContext.request.contextPath}" id="first">首页</a>&nbsp; 
									<c:if test="${pageNow>1}">
										<a href="${pageContext.request.contextPath}" id="forwrad">上一页</a>&nbsp;
									</c:if>
									<c:if test="${pageNow<sumCount}">
										<a	href="${pageContext.request.contextPath}" id="next">下一页</a>&nbsp; 
									</c:if>
									<a href="${pageContext.request.contextPath}" id="end">尾页</a>&nbsp; 
									<span>跳转到</span>
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