<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/frameset.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="../com/easyui.jsp" %>
<html>
<head>
<TITLE>Teacher Register</TITLE>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<c:url value='/resources/css/bootstrap.min.css' />" rel="stylesheet" type="text/css" />
<link href="<c:url value='/resources/css/easylayout.css' />" rel="stylesheet"
	type="text/css" media="screen" />
<script type="text/javascript" src="<c:url value='/resources/js/dialog.js'/>"></script> 

<script type="text/javascript">
$(function(){
	 createDialog('content',"<spring:message code='changeEmail'/>");
});
function close(){
	closeDialog('content');
}
	$(function(){
		//文本框获取焦点 失去焦点变色
		$(".text").focus(function() {
			$(this).css("background", "#CCFFFF");
			 $("span#stuEmail").text("");
		}).blur(function() {
			 var name = this.name;
			var value = this.value;
			if($.trim(value)==""){
				$(this).css("background", "#ffff66");
			}else{
				$(this).css("background", "#FFFFFF");
				 $("span#stuEmail").text("");
			}
		});
	})
	function update(){
		var regs=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
		if($("input[name='stuEmail']").val()==""){
			 $("label#error").text("<spring:message code='pleaseEnterEmail'/>");
			 return false;
		 }else if((regs.test($("input[name='stuEmail']").val()) == false)){
			 $("span#stuEmail").text("<spring:message code='emailError'/>");
			 return false;
		 }else {
			 $("span#stuEmail").text("");
			 return true;
		 }
	}
</script>
</head>
<body>
		<div class="div4" id="content" align="center">
		<label style="font-family: 微软雅黑;" ><font size="4"><spring:message code="changeEmail"/></font></label>
		<form:form method="post" action="/question/updateStudent" onsubmit="return checkInfo()" name="form" modelAttribute="student">
			<form:input path="stuId" type="hidden"/>
			<div class="div_table">
			<br><br>
			<table class="table">
				<tr align="center">
					<td><spring:message code="stuNum"/></td>
					<td><form:input class="text" onfocus="this.blur()" name="stuNum" path="stuNum" />
					</td>
					<td><font id="fcolor" color="red"><span id="stuNum"></span></font></td>
				</tr>
				
				<tr align="center">
					<td><spring:message code="name"/></td>
					<td><form:input class="text" onfocus="this.blur()" name="stuName" path="stuName" /></td>
					<td><font color="red"><span id="stuName"></span></font></td>
				</tr>
				<tr align="center">
					<td><spring:message code="email"/></td>
					<td><form:input  class="text" name="stuEmail" path="stuEmail" /></td>
					<td><font color="red"><span id="stuEmail"></span>
					</font></td>
				</tr>
				<tr align="center">
					<td colspan="3">
					<input class="btnPaleGreen" type="submit" onclick="return update()" value="确认"/>
					</td>
				</tr>
				<tr>
				<td colspan="3"><font color="red"><label id="error">${infor}</label></font></td>
				</tr>
			</table>
			</div>
		</form:form>
	</div>
</body>
</HTML>