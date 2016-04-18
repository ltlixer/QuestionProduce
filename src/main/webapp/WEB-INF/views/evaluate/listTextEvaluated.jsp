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
	$(".loadimg").hide();
	 /* 变量 user ="stu"代表是学生访问该页面；user=tea教师访问该页面，具有删除等更高权限   */
	var findText = $("#findText").val();
	 $("#first").click(function(){
		var sumPage = ${sumCount};
		
			this.href=this.href+"/evaluate/queryTextListEvaluated/1?sumPage="+sumPage+"&findText="+findText
		
	});
	$("#end").click(function(){
		var sumPage = ${sumCount};
			this.href=this.href+"/evaluate/queryTextListEvaluated/"+sumPage+"?sumPage="+sumPage+"&findText="+findText
		
	});
	$("#forwrad").click(function(){
		var sumPage = ${sumCount};
		var pageNow = ${pageNow}-1;
		
			this.href=this.href+"/evaluate/queryTextListEvaluated/"+pageNow+"?sumPage="+sumPage+"&findText="+findText
		
	});
	$("#next").click(function(){
		var sumPage = ${sumCount};
		var pageNow = ${pageNow}+1;
		
			this.href=this.href+"/evaluate/queryTextListEvaluated/"+pageNow+"?sumPage="+sumPage+"&findText="+findText
		
	});
	$("#changePage").change(function(){
		var sumPage = ${sumCount};
		var pageNow = this.value;
		var link = $("#link");
		
			link[0].href=link[0].href+"/evaluate/queryTextListEvaluated/"+pageNow+"?sumPage="+sumPage+"&findText="+findText
		
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

</script>
</head>
<body>
	<div class="bodyDiv">
		<h2><spring:message code="learningResource"/></h2>
		<div class="div4">
			<table border="1" class="editTab" id="table">
			<tr>
			<th colspan="6"><spring:message code="evaluateText"/></th>
			</tr>
						<tr>
							<th width="20%"><spring:message code="title"/></th>
							<th width="20%"><spring:message code="courseName"/></th>
							<th width="15%"><spring:message code="publishTeacher"/></th>
							<th width="15%"><spring:message code="publishTime"/></th>
							<th width="15%"><spring:message code="evaluateStatus"/></th>
							<th width="20%"><spring:message code="evaluateDelete"/></th>
						</tr>
						
						<tr>
						<c:if test="${not empty texts}">
						<c:forEach var="texts" items="${texts}">
							<tr>
							<td align="center">${texts.textTitle}</td>
							<td align="center">${texts.course.courseName}</td>
							<td align="center">${texts.teacher.teaName}</td>
							<td align="center"><fmt:formatDate pattern="yyyy-MM-dd" value="${texts.createTime}" /></td>
							<td align="center"><spring:message code="evaluatedhave"/></td>
							<td align="center"><a href="/question/evaluate/deleteEvaluate/${texts.textId}"><spring:message code="delete"/></a></td>
							
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
