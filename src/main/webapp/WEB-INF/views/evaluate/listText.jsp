<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
	
	if($("#link1").val()=="first"){
		$("#table").hide();
		$("#div6").hide();
	} 
	if('${courseSize}'=='0'){
		$("#query").hide();//若无课程，查询按钮影藏
		$("#div6").hide();//若无课程，分页栏影藏
	}
	
	
	
	
	$(".loadimg").hide();
	 /* 变量 user ="stu"代表是学生访问该页面；user=tea教师访问该页面，具有删除等更高权限   */
	var findText = $("#findText").val();
	 $("#first").click(function(){
		var sumPage = ${sumCount};
			this.href=this.href+"/evaluate/queryTextList/1?sumPage="+sumPage+"&course="+$("select[name='course']").val();
		
	});
	$("#end").click(function(){
		var sumPage = ${sumCount};
		
			this.href=this.href+"/evaluate/queryTextList/"+sumPage+"?sumPage="+sumPage+"&course="+$("select[name='course']").val();
		
	});
	$("#forwrad").click(function(){
		var sumPage = ${sumCount};
		var pageNow = ${pageNow}-1;
		
			this.href=this.href+"/evaluate/queryTextList/"+pageNow+"?sumPage="+sumPage+"&course="+$("select[name='course']").val();
		
	});
	$("#next").click(function(){
		var sumPage = ${sumCount};
		var pageNow = ${pageNow}+1;
		
			this.href=this.href+"/evaluate/queryTextList/"+pageNow+"?sumPage="+sumPage+"&course="+$("select[name='course']").val();
		
	});
	$("#changePage").change(function(){
		var sumPage = ${sumCount};
		var pageNow = this.value;
		var link = $("#link");
			link[0].href=link[0].href+"/evaluate/queryTextList/"+pageNow+"?sumPage="+sumPage+"&course="+$("select[name='course']").val();
			link[0].click();
	});
	
	$("#findText").focus(function(){
		$(this).css("background", "#CCFFFF");
	}).blur(function(){
		$(this).css("background", "#FFFFFF");
	});
	
})

function showLoad(textId){
	$("img#"+textId).show();
}
function select(){
	 location.href="/question/queryCourse/1";
	 return false;
}
</script>
</head>
<body>
	<div class="bodyDiv">
		
	<h2><spring:message code="learningResource"/></h2>
		<input id="link1" type="hidden" value="${link}">
		<form action="/question/evaluate/queryTextList/1">
			<table width="90%">
			<c:if test="${courseSize=='0'}">
			<tr>
			<td ></td>
			<td colspan="4" align="center">
					<font size="4"><spring:message code="courseSelectThenLearn"/><button class="btnPaleGreen" onclick="return select()"><spring:message code="toCourseSelect"/></button></font>
			</td>
			</tr>
			</c:if>
					<tr id="query">
						<td ></td>
						<td align="right"><font size="4"><spring:message code="pleaseSelectCourse"/>:</font>
						<select name="course" style="width: 200px">
					<c:if test="${not empty courses}">
						<c:forEach var ="course" items="${courses}">
							<option value="${course.courseId}">${course.year}级${course.courseName}</option>
						</c:forEach>
					</c:if>
			</select></td>
						<td><input type="submit" value="<spring:message code='learningResourceQuery'/>"   style="width: 100px"  class="btnPaleGreen" /></td>
				</tr>
				</table>
		</form>
				<hr color="#00aaff">
		
		
		<div class="div4">
			<table border="1" class="editTab" id="table">
			<tr>
			<th colspan="6"><spring:message code='learningResourceQuery'/><spring:message code='evaluateText'/></th>
			</tr>
						<tr>
							<th width="20%"><spring:message code="title"/></th>
							<th width="20%"><spring:message code="courseName"/></th>
							<th width="20%"><spring:message code="publishTeacher"/></th>
							<th width="20%"><spring:message code="publishTime"/></th>
							<th width="20%"><spring:message code="questionEvaluate"/></th>
						</tr>
						
						<tr>
						<c:if test="${not empty texts}">
						<c:forEach var="texts" items="${texts}">
							<tr>
							<td align="center">${texts.textTitle}</td>
							<td align="center">${texts.course.courseName}</td>
							<td align="center">${texts.teacher.teaName}</td>
							<td align="center"><fmt:formatDate pattern="yyyy-MM-dd" value="${texts.createTime}" /></td>
							<td align="center"><a href="/question/evaluate/productQuestion/${texts.textId}" onclick='showLoad(${texts.textId})'><spring:message code="toEvaluate"/></a>
							<img style="float: right;" id="${texts.textId}" class="loadimg" width="20px" src="<c:url value='/resources/images/loading.gif'/>"></td>
						</tr>
						</c:forEach>
						</c:if>
					</table>
					</div>
					<div class="div6" align="center" id="div6">
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
   	 	<p><font color="red">${message}</font></p>
		</div>
</body>
</html>
