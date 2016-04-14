<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/frameset.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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

<title>问题产生</title>
<script type="text/javascript">
    function linkAss(){
    	location.href ="/question/assignment/queryAssignment/1";
    }
</script>
</head>
<body>
	<div class="div3">
		<font size="4">阅读<label>课文《${textTitle}》回答下列问题 </label>
		</font>
		<span style="float: right;"><font size="3">课程名：${courseName}</font>&nbsp;&nbsp;</span>
	</div>
	<br>
	<div style="width: 98%; padding-left: 20px">
		<font size="3"> <c:forEach var="sentence" items="${texts}">
				&nbsp;&nbsp;
				${sentence}<br>
			</c:forEach>
		</font>
	</div>

	<div class="div3">
		<font size="4"><label>问题（共${fn:length(questions)}小题）</label></font>
		<div style="float: right;"><font size="4" color="red">测试总时间：${assTime}分钟
		</font>&nbsp;&nbsp;&nbsp;&nbsp;</div>
	</div>
	<div class="div4" style="width: 98%">
		<form id="submitFormId" action="/question/answer/submitAnswer" method="post">
			<input type="hidden" name="assId" value="${assId}">
			<input type="hidden" id="useTime" name="useTime" value="${assTime}">
			<table border="1" class="editTab" id="showQuestion" align="center">
				<tr>
					<th width="7%">题号</th>
					<th width="70%">问题</th>
					<th width="13%">参考答案</th>
					<th width="10%">问题类别</th>
				</tr>
					<c:set var="i" value="${0}"/>
					<c:forEach var="question" items="${questions}">
					<c:set var="i" value="${i+1}"/>
					<tr>
						<td align="center">问题 ${i}.</td>
						<td>${question.question}</td>
						
							<td>${question.answer}</td>
							<td>${question.questionType}</td>
					</tr>
				</c:forEach>
			<tr>
				<td colspan="4" align="center">
					<input type="button" onclick="linkAss()" class="btnPaleGreen" style="width: 100px" value="返回作业列表">
				</td>
				</tr>
			</table>
				<br><br>
		</form>
	</div>



</body>
</html>