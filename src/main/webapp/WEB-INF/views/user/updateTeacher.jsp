<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/frameset.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../com/easyui.jsp" %>
<html>
<head>
<TITLE>Teacher Register</TITLE>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="<c:url value='/resources/css/easylayout.css' />" rel="stylesheet"
	type="text/css" media="screen" />
<script type="text/javascript" src="<c:url value='/resources/js/dialog.js'/>"></script> 

<script type="text/javascript">
$(function(){
	 createDialog('content','个人信息修改');
});
function close(){
	closeDialog('content');
}
	$(function(){
		//文本框获取焦点 失去焦点变色
		$(".text").focus(function() {
			$(this).css("background", "#CCFFFF");
		}).blur(function() {
			 var name = this.name;
			var value = this.value;
			if($.trim(value)==""){
				$(this).css("background", "#ffff66");
				var text = $("font#"+name).text();
				$("span#"+name).text(text+"不能为空");
			}else{
				$(this).css("background", "#FFFFFF");
				$("span#"+name).text("");
			}
		});
		$("input[name='submit']").click(function(){
			var regs=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
			if((regs.test($("input[name='teaEmail']").val()) == false)){
				 $("span#teaEmail").text("邮箱格式不正确");
				 return false;
			 }else if( $("input[name='teaName']").val()==""||
					 $("input[name='teaEmail']").val()==""||
					 $("input[name='teaMajor']").val()==""){
				 $("label#error").text("请先完善信息");
				 return false;
			 }else{
				 $("span#teaEmail").text("");
				 return true;
			 }
		});
		
	})
</script>
</head>
<body>
		<div class="div4" id="content" align="center">
		<label style="font-family: 微软雅黑; "><font size="4">个人信息修改</font></label>
		<form:form method="post" action="/question/updateTeacher" onsubmit="return checkInfo()" name="form" modelAttribute="teacher">
			<form:input path="teaId" type="hidden"/>
			<div class="div_table">
			<br><br>
			<table class="editTab">
				<tr align="center">
					<td><label>登录账号</label> </td>
					<td><form:input class="text" onfocus="this.blur()" name="teaNum" path="teaNum" />
					</td>
					<td><font id="fcolor" color="red"><span id="teaNum"></span></font></td>
				</tr>
				
				<tr align="center">
					<td><label>真实姓名</label></td>
					<td><form:input class="text" name="teaName" path="teaName" /></td>
					<td><font color="red"><span id="teaName"></span></font></td>
				</tr>
				
				<tr align="center">
					<td><label>所授课程</label></td>
					<td><form:input class="text" name="teaMajor" path="teaMajor" /></td>
					<td><font color="red"><span id="teaMajor"></span></font></td>
				</tr>
				
				<tr align="center">
					<td><label>电子邮箱</label></td>
					<td><form:input  class="text" teaName="teaEmail" path="teaEmail" /></td>
					<td><font color="red"><span id="teaEmail"></span>
					</font></td>
				</tr>
				<tr align="center">
					<td colspan="3">
					<input class="btnPaleGreen" type="submit" value="确认"/>
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