<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../com/easyui.jsp" %>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>教师登录</title>
<link href="<c:url value='/resources/css/tea_login.css' />"
	rel="stylesheet" type="text/css" />
<!-- 用户注册页面 样式-->
<script type="text/javascript"
	src="<c:url value='/resources/js/dialog.js'/>"></script>
<link href="<c:url value='/resources/css/easylayout.css' />"
	rel="stylesheet" type="text/css" media="screen" />

<script type="text/javascript">
document.onkeypress = function esckey() {
    if (event.keyCode == 13)//“enter”键
    {
       $("#ok").click();
    }
}
	$(function() {
		/* 登录验证 */
		$("#errorInfor").text("");
		$('#account').focus().keypress(function(e) {
			var password = $.trim($("#password").val());
			if (e.which == 13) {
				if (password != '')
					login_action();
				else
					$('#password').focus();
			}
		});
		$('#password').keypress(function(e) {
			if (e.which == 13)
				login_action();
		});
		$('#ok').click(function() {
			login_action();
		});

		$('#reset').click(function() {
			$("#account").val('');
			$("#password").val('');
		});

	});
	function login_action() {
		var useName = $.trim($("#account").val());
		var password = $.trim($("#password").val());

		if (useName != '' && password != '') {
			$('#loginForm').submit();
			return true;
		}
		if (useName == '') {
			$("#errorInfor").text("用户名不能为空");
			$("#account").focus();
			return;
		}
		if (password == '') {
			$("#errorInfor").text("密码不能为空");
			$("#password").focus();
			return;
		}
	}
</script>
</head>
<body>
	<form:form method="post" id="loginForm" name="loginForm"
		action="/question/teaLogin" modelAttribute="teacher">
		<table width="980" border="0" align="center" cellpadding="0"
			cellspacing="0" class="login">
			<tr>
				<td valign="top"><table width="80%" border="0" align="center"
						cellpadding="0" cellspacing="0">
						<tr>
							<td width="35%" height="270">&nbsp;</td>
							<td width="34%">&nbsp;</td>
							<td width="31%">&nbsp;</td>
						</tr>
						<tr>
							<td height="40" align="right">用户名<strong>&nbsp;</strong></td>
							<td><form:input type="text" id="account" class="login_input"
									path="teaNum" /></td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td height="40" align="right">密&nbsp;&nbsp;码&nbsp;</td>
							<td><form:input id="password" type="password"
									class="login_input" path="teaPassword" />
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td height="40" align="right">&nbsp;</td>
							<td align="center"><input type="button" id="ok" name="ok"
								class="button_login" value=" " /> &nbsp; <input type="button"
								id="reset" name="reset" class="button_reset" value=" " />
								&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td align="right">&nbsp; <b><a
									href="javascript:return false;" onclick="openDialog('userAdd')">注册账号</a></b>
							</td>
							<td align="center"><font color="red"><label
									id="errorInfor">${teaLoginInfor}</label></font></td>
							<td>&nbsp;</td>
						</tr>
					</table></td>
			</tr>
		</table>
	</form:form>


	<!-- 注册对话框 -->
	<div id="userAdd">
		<form:form method="post" action="/question/teaRegister" name="form"
			modelAttribute="teacher">
			<br>
			<br>
			<br>
			<br>
			<div class="div_ul">
				<ul>
					<li><label> 登录账号： </label> <form:input class="text"
							name="teaNum" id="teaNum1" path="teaNum" /> <span
						style="color: red"> * </span> <span
						style="font-size: 12px; color: red" id="teaNum"></span></li>
					<li><label> 登录密码： </label> <form:password class="text"
							name="teaPassword" id="teaPasswordText" path="teaPassword" /> <span
						style="color: red"> * </span> <span
						style="font-size: 12px; color: red" id="teaPassword"></span></li>
					<li><label> 确认密码： </label> <input class="text"
						name="repassword" type="password" /> <span style="color: red">
							* </span><span style="font-size: 12px; color: red" id="repassword"></span></li>
					<li><label> 真实姓名： </label> <form:input class="text"
							name="teaName" path="teaName" /><span style="color: red">
							* </span> <span style="font-size: 12px; color: red" id="teaName"></span>

					</li>
					<li><label>班级课程： </label> <form:input class="text"
							name="teaMajor" path="teaMajor" /> <span style="color: red">
							* </span> <span id="teaMajor" style="font-size: 12px; color: red"></span>
					</li>
					<li><label> 电子邮箱： </label> <form:input class="text"
							teaName="teaEmail" path="teaEmail" /> <span style="color: red">
							* </span> <span id="teaEmail" style="font-size: 12px; color: red"></span>
					</li>
					<li><span id="error" style="font-size: 12px; color: red"></span>
					</li>
					<li
						style="text-align: center; padding: 0px; height: 40px; line-height: 40px;">
						&nbsp; <input type="submit" value="确认" class="btnPaleGreen"
						onclick="return check()" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset"
						value="重置" class="btnGray" />
					</li>
				</ul>

			</div>
		</form:form>
	</div>
	<script type="text/javascript">
	/* 注册验证 */
		$(function() {
			createDialog('userAdd', '账号注册');
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
			$("input[id='teaNum1']").blur(function() {
				var value = $("input[id='teaNum1']").val();
				if ($.trim(value) != "") {
					var url = "/question/teaRegisterAjax";
					var args = "teaNum=" + value;
					$.ajax({
						type : 'POST',
						url : url,
						data : args,
						dataType : 'text',
						success : function(data) {
							if (data == "0") {
								$("span#teaNum").text("该账号已存在");
							} else {
								$("span#teaNum").text("");
							}
						}
					});
				}
			});

		})
		function check(){
			var teaPassword = $("input[id='teaPasswordText']");
			var repassword = $("input[name='repassword']");
			var regs = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
			if ($.trim(teaPassword.val()) != $
					.trim(repassword.val())) {
				$(repassword).css("background", "#ffff66");
				$("span#repassword").text("两次输入的密码不一致");
				return false;
			} else if (($("span#teaNum").text() != "")
					|| ($("span#teaName").text() != "")
					|| ($("span#teaPassword").text() != "")
					|| ($("span#teaEmail").text() != "")
					|| ($("span#teaMajor").text() != "")) {
				return false;
			} else if ($("input[id='teaNum1']").val() == ""
					|| $("input[id='teaPasswordText']")
							.val() == ""
					|| $("input[name='teaName']").val() == ""
					|| $("input[name='teaEmail']").val() == ""
					|| $("input[name='teaMajor']").val() == "") {
				$("span#error").text("请先完善信息");
				return false;
			} else if ((regs.test($(
					"input[name='teaEmail']").val()) == false)) {
				$("span#teaEmail").text("邮箱格式不正确");
				return false;
			} else {
				$("span#error").text("");
				return true;
			}
		}
	</script>
</body>
</html>