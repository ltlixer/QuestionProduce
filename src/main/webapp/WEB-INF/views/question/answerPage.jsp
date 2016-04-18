<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/frameset.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="../com/easyui.jsp" %>
<html>
<head>
<TITLE>Answer Page</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link href="<c:url value='/resources/css/main.css' />" rel="stylesheet"
	type="text/css" media="screen" />
<script type="text/javascript"
	src="<c:url value='/resources/js/dialog.js'/>"></script>
	
	
<title>批改作业</title>
<script type="text/javascript">
	
	function submitTip(title,mesg){
		var saId = $("#saId").val();//成绩表Id
		var evaluate =$("#evaluate").val();
		var str2 = "[";
		var count = "${fn:length(answers)}";
		var right =0;
		for(var i = 1;i<=count;i++){
			var answerId =  $("#answerId"+i).val();
			var tOrF= $("input[name='answer"+i+"']:checked").val();
			if(tOrF=="T"){
				right++;
			}
			if (i == 1) {
				str2 += "{'answerId':'" + answerId + "','tOrF':'"
						+ tOrF+ "'}";
			} else {
				str2 += ",{'answerId':'" + answerId + "','tOrF':'"
				+ tOrF+ "'}";
			}
		}
		str2 += "]";
		var score = (right/count)*100;
		 var str1 = "[{'saId':'" + saId + "','evaluate':'" + evaluate
			+ "','score':'" + score + "'}]"; 
		var json = {};
		json.scores = eval("(" + str2 + ")");//转换为json对象 
		json.sa = eval("(" + str1 + ")");
		$.messager.confirm(title, mesg+"。"+right+"小题正确", function(isSure) {
			if(isSure){
				var post = {data : JSON.stringify(json)};//JSON.stringify(json)把json转化成字符串
					var url = "/question/answer/submitScore";
					$.post(url, post, function(data) {
						//return "success:";error
						if (data == "success") {
							location.href = "/question/assignment/showScoreAssignment/1";
						} else {
							$.messager.alert('消息反馈', '本次批改提交失败！');
						}
					});
			}
		}); 
	}
   
    
    function linksAss(){
    	location.href ="/question/assignment/queryScoreAssignment";
    }
    
</script>
</head>
<body>
	<div class="div3">
		<font size="4"><label><spring:message code="textLabel1"/>${textTitle}<spring:message code="textLabel2"/></label>
		</font>
		<div style="float: right"><font size="4"><spring:message code="courseName"/>${courseName}</font>&nbsp;&nbsp;&nbsp;&nbsp;</div>
	</div>
	<div style="width: 98%; padding-left: 20px">
		<font size="3"> <c:forEach var="sentence" items="${texts}">
				&nbsp;&nbsp;
				${sentence}<br>
			</c:forEach>
		</font>
	</div>

	<div class="div3">
		<font size="4"><label><spring:message code="questionLabel1"/>${fn:length(answers)}<spring:message code="questionLabel2"/></label></font>
		<div style="float: right;"><font size="4">${stuName}<spring:message code="stu"/></font><font size="4" color="red"><spring:message code="timeLabel1"/>${useTime}<spring:message code="timeLabel2"/>&nbsp;&nbsp;</font>
		</div>
	</div>
	<div class="div4" style="width: 98%">
		<form id="submitFormId" action="#" method="post">
			<input type="hidden" id="saId" name="saId" value="${saId}">
			<table border="1" class="editTab" id="showAnswer" align="center">
				<tr>
				<c:if test="${user=='tea'}">
					<th width="3%"><spring:message code="qid"/></th>
					<th width="44%"><spring:message code="question"/></th>
					<th width="14%"><spring:message code="stuAnswer"/></th>
					<th width="14%"><spring:message code="refAnswer"/></th>
					<th width="15%"><spring:message code="correct"/></th>
					<th width="10%"><spring:message code="stuToReAnswer"/></th>
				</c:if>
					
				</tr>
					<c:set var="i" value="${0}"/>
					<c:forEach var="answer" items="${answers}">
					<c:set var="i" value="${i+1}"/>
					<tr>
						<td align="center">${i}.</td>
						<td>${answer.question.question}</td>
						<c:if test="${user=='tea'}">
							<td align="center"><input type="hidden" id="answerId${i}" name="answerId" value="${answer.asswerId}">${answer.answer}</td>
							<td align="center">${answer.question.answer}</td>
							<td>
							
							 <c:if test="${answer.tOrF=='T'}">
								<input   name="answer${i}" type="radio" checked="checked" value="T" /> <spring:message code="right"/>&nbsp;&nbsp;
								<input  name="answer${i}"  type="radio" value="F" /><spring:message code="error"/>
							 </c:if> 
							<c:if test="${answer.tOrF=='F'}">
								<input   name="answer${i}" type="radio"  value="T" /> <spring:message code="right"/>&nbsp;&nbsp;
								<input  name="answer${i}"  type="radio" checked="checked" value="F" /><spring:message code="error"/>
							 </c:if> 
							
							</td>
							<td align="center">${answer.similarity}</td>
						</c:if>
					</tr>
				</c:forEach>
			
			<tr>
				 <c:if test="${user=='tea'}"> 
				 <tr>
				 <td colspan="6" align="center" valign="middle">
				<font size="4"><label><spring:message code="assEvaluate"/></label></font><textarea id="evaluate" name="evaluate" class="easyui-validatebox" data-options="required:true" missingMessage="请对本次作业作一个简要评价"  cols="80" rows="2">${evaluate}</textarea>
				</td>
				</tr>
				<tr>
				<td colspan="6" align="center">
				<input type="button" onclick="return submitTip('确认','您确定提交成绩吗？')" class="btnPaleGreen" style="width: 130px" value="<spring:message code="submit"/>">
					<input type="button" onclick="linksAss()" class="btnGray" style="width: 130px" value="<spring:message code="reAssList"/>">
				</td>
				</c:if> 
				</tr>
			</table>
				<br><br>
		</form>
	</div>
</body>
</html>