<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/frameset.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../com/easyui.jsp" %>
<html>
<head>
<TITLE>Student Register</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link href="<c:url value='/resources/css/main.css' />" rel="stylesheet"
	type="text/css" media="screen" />
<script type="text/javascript"
	src="<c:url value='/resources/js/dialog.js'/>"></script>
	
	
<title>批改作业</title>
<script type="text/javascript">
    function linksAss(){
    	location.href ="/question/assignment/showScoreAssignment/1";
    }
</script>
</head>
<body>
	<div class="div3">
		<font size="4"><label>课文《${textTitle}》 </label>
		</font>
		<div style="float: right"><font size="4">课程名：${courseName}</font>&nbsp;&nbsp;&nbsp;&nbsp;</div>
	</div>
	<div style="width: 98%; padding-left: 20px">
		<font size="3"> <c:forEach var="sentence" items="${texts}">
				&nbsp;&nbsp;
				${sentence}<br>
			</c:forEach>
		</font>
	</div>

	<div class="div3">
		<font size="4"><label>问题（共${fn:length(answers)}小题） 批改结果详细&nbsp;&nbsp;成绩：<fmt:formatNumber value="${score}" pattern="#0.0"/>分</label></font>
		<div style="float: right;"><font size="4">学生姓名：${stuName}&nbsp;&nbsp;</font><font size="4" color="red">测试所用时间：${useTime}分钟&nbsp;&nbsp;</font>
		</div>
	</div>
	<div class="div4" style="width: 98%">
		<form id="submitFormId" action="#" method="post">
			<input type="hidden" id="saId" name="saId" value="${saId}">
			<table border="1" class="editTab" id="showAnswer" align="center">
				<tr>
					<th width="5%">题号</th>
					<th width="60%">问题</th>
					<th width="13%">学生答案</th>
					<th width="12%">参考答案</th>
					<th width="10%">批改结果</th>
				</tr>
					<c:set var="i" value="${0}"/>
					<c:forEach var="answer" items="${answers}">
					<c:set var="i" value="${i+1}"/>
					<tr>
						<td align="center">${i}.</td>
						<td>${answer.question.question}</td>
							<td align="center"><input type="hidden" id="answerId${i}" name="answerId" value="${answer.asswerId}">
							${answer.answer}</td>
							
							<td align="center">${answer.question.answer}</td>
							<td align="center">
							<c:if test="${answer.tOrF=='T'}">
							正确
							</c:if>
							<c:if test="${answer.tOrF=='F'}">
							<font color="red">错误</font>
							</c:if>
							</td>
					</tr>
				</c:forEach>
			
			<tr>
				 
				 <tr>
				 <td colspan="5" align="center">
				<font size="4">评语：${evaluate}</font>
				</td>
				</tr>
				<tr>
				<td colspan="5" align="center">
				<c:if test="${user=='tea'}"> 
					<input type="button" onclick="linksAss()" class="btnGray" style="width: 100px" value="返回">
				</c:if>
				</td>
				</tr>
			</table>
				<br><br>
		</form>
	</div>



</body>
</html>