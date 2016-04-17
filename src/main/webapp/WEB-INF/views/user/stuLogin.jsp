<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="../com/easyui.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>学生登录</title>
<!-- 用户登录界面  样式-->
<link href="<c:url value='/resources/css/User_Login.css' />"
	rel="stylesheet" type="text/css" media="screen" />
<!-- 用户注册页面 样式-->
<script type="text/javascript"
	src="<c:url value='/resources/js/dialog.js'/>"></script>
<link href="<c:url value='/resources/css/easylayout.css' />"
	rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript">
document.onkeypress = function esckey() {
    if (event.keyCode == 13)//“enter”键
    {
       $("#IbtnEnter").click();
    }
}
</script>
</head>
<body id="userlogin_body">
	<p align="center">
	<font style="font-family: 微软雅黑;font-weight: bold;" color="#626636" size="6"><spring:message code="systemName"/></font><br><br>
	</p>
	<div id="user_login">
		<dl>
			<dd id=user_top>
				<ul>
					<li class=user_top_l></li>
					<li class=user_top_c></li>
					<li class=user_top_r></li>
				</ul>
			</dd>
			<dd id=user_main>
				<form:form method="post" action="/question/stuLogin"
					modelAttribute="student">
					<ul>
						<li class=user_main_l></li>
						<li class=user_main_c>

							<div class=user_main_box>
								<ul>
									<li class=user_main_text><form:label path="stuNum"><spring:message code="userName"/></form:label>
									</li>
									<li class=user_main_input><form:input
											class="TxtUserNameCssClass" path="stuNum" /></li>
								</ul>
								<ul>
									<li class=user_main_text><form:label path="stuPassword"><spring:message code="password"/></form:label></li>
									<li class=user_main_input><form:password
											class="TxtPasswordCssClass" path="stuPassword" /></li>
								</ul>
							</div> <br> <br> <c:forEach begin="1" end="15">
	   			            	&nbsp;
	   			            </c:forEach> <img alt=""
							src="<c:url value="/resources/images/edit_add.png"/>" width="10"
							height="10" /> <b><a href="javascript:return false;"
								onclick="openDialog('userAdd')"><spring:message code="regisLabel"/></a></b> <br> <c:if
								test="${not empty stuLoginInfor}">
								<c:forEach begin="1" end="10">
	   			            	&nbsp;
	   			            	</c:forEach>
								<b><font color="red">${stuLoginInfor}</font></b>
							</c:if> <c:forEach begin="1" end="13">
	   			            	&nbsp;
	   			            	</c:forEach> <form:errors path="stuNum"></form:errors><br /> <c:forEach
								begin="1" end="14">
	   			            	&nbsp;
	   			            	</c:forEach> <form:errors path="stuPassword"></form:errors><br />

						</li>
						<li class=user_main_r><input class=IbtnEnterCssClass
							id=IbtnEnter
							style="BORDER-TOP-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px; BORDER-BOTTOM-WIDTH: 0px; BORDER-RIGHT-WIDTH: 0px;    width: 60px; height: 60px"
							type=image src="<c:url value="/resources/images/user_log.png"/>"
							name=IbtnEnter></li>
					</ul>
				</form:form>
			</dd>
			<dd id=user_bottom></dd> 
		</dl>
	</div>

	<!-- 注册对话框 -->
	<div id="userAdd">
		<form:form method="post" action="/question/stuRegister" name="form"
			modelAttribute="student">
			<br>
			<br>
			<div class="div_ul">
				<ul>

					<li><label> <spring:message code="count"/>： </label> <form:input class="text"
							id="stuNum1" name="stuNum" path="stuNum" /> <span
						style="color: red"> * </span> <span
						style="font-size: 12px; color: red" id="stuNum"></span> <!-- <font color="red"><label id="stuNum"></label></font> --></li>
					<li><label> <spring:message code="loginpassword"/>： </label> <form:password class="text"
							name="stuPassword" id="stuPasswordText" path="stuPassword" /> <span
						style="color: red"> * </span> <span
						style="font-size: 12px; color: red" id="stuPassword"></span></li>
					<li><label> <spring:message code="repassword"/>： </label> <input class="text"
						name="repassword" id="repasswordText" type="password" /> <span
						style="color: red"> * </span><span
						style="font-size: 12px; color: red" id="repassword"></span></li>
					<li><label><spring:message code="realName"/>： </label> <form:input class="text"
							name="stuName" path="stuName" /><span style="color: red">
							* </span> <span style="font-size: 12px; color: red" id="stuName"></span>

					</li>
					<li><label> <spring:message code="email"/>： </label> <form:input class="text"
							stuName="stuEmail" path="stuEmail" /> <span style="color: red">
							* </span> <span id="stuEmail" style="font-size: 12px; color: red"></span>
					</li>
					<li><span id="error" style="font-size: 12px; color: red"></span>
					</li>
					<li
						style="text-align: center; padding: 0px; height: 40px; line-height: 40px;">
						&nbsp; <input type="submit" value="<spring:message code='ok'/>" class="btnPaleGreen"
						onclick="return checkInfo()" /> <!-- onclick="return addCheck()"  -->
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset"
						value="<spring:message code='cancel'/>" class="btnGray" />
					</li>
				</ul>

			</div>
		</form:form>
	</div>
	<script type="text/javascript">
	<!-- 注册对话框 -->
		$(function() {
			createDialog('userAdd', '<spring:message code="regisLabel"/>');
			closeDialog('userAdd');

			//文本框获取焦点 失去焦点变色
			$(".text").focus(function() {
				$(this).css("background", "#CCFFFF");
				$("span#error").text("");
			}).blur(function() {
				var name = this.name;
				var value = this.value;
				if ($.trim(value) == "") {
					$(this).css("background", "#ffff66");
					var text = $("font#" + name).text();
					$("span#" + name).text(text + "不能为空");
				} else {
					$(this).css("background", "#FFFFFF");
					$("span#" + name).text("");
				}
			});
			//Ajax校验输入账号是否存在
			$("input[id='stuNum1']").blur(function() {
				var value = $("input[id='stuNum1']").val();
				if ($.trim(value) != "") {
					var url = "/question/registerAjax";
					var args = "stuNum=" + value;
					$.ajax({
						type : 'POST',
						url : url,
						data : args,
						dataType : 'text',
						success : function(data) {
							if (data == "0") {
								$("span#stuNum").text("该账号已存在");
							} else {
								$("span#stuNum").text("");
							}
						}
					});
				}
			});
		});
		function checkInfo() {
			var newpass = $("#stuPasswordText");
			var repass = $("#repasswordText");
			var regs = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
			
			if ($.trim(newpass.val()) != $.trim(repass.val())) {
				$(repass).css("background", "#ffff66");
				$("span#repassword").text("两次输入的密码不一致");
				return false;
			} else if (($("span#stuNum").text() != "")
					|| ($("span#stuName").text() != "")
					|| ($("span#stuPassword").text() != "")
					|| ($("span#stuEmail").text() != "")) {
				return false;
			} else if ($("input[id='stuNum1']").val() == ""
					|| $("input[id='stuPasswordText']").val() == ""
					|| $("input[name='stuName']").val() == ""
					|| $("input[name='stuEmail']").val() == "") {
				$("span#error").text("请先完善信息");
				return false;
			} else if ((regs.test($("input[name='stuEmail']").val()) == false)) {
				$("span#stuEmail").text("邮箱格式不正确");
				return false;
			} else {
				return true;
			}

		}
	</script>
</body>
</html>
