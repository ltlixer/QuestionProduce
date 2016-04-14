<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>安全退出</title>
<script language='javascript' type='text/javascript'>
	var secs = 5; //倒计时的秒数 
	var URL;
	function Load(url) {
		URL = url;
		for (var i = secs; i >= 0; i--) {
			window.setTimeout('doUpdate(' + i + ')', (secs - i) * 1000);
		}
	}
	function doUpdate(num) {
		document.getElementById('ShowDiv').innerHTML = '将在' + num
				+ '秒后自动跳转到登录界面';
		if (num == 0) {
			window.location = URL;
		}
	}
</script>
</head>
<body>
	<h2 align="center"><font color="00ccff">安全退出</font></h2>
	<div id="ShowDiv"></div>
	<%
		session.invalidate();
	%>
	<script language='javascript' type='text/javascript'>
	Load("<%=request.getContextPath()%>/");
	</script>
</body>
</html>