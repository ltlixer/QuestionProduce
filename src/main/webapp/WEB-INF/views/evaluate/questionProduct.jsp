<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/frameset.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../com/easyui.jsp"%>
<html>
<head>
<TITLE>Student Register</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link href="<c:url value='/resources/css/main.css' />" rel="stylesheet"
	type="text/css" media="screen" />
<script type="text/javascript"
	src="<c:url value='/resources/js/selectAll.js' />"></script>

<script type="text/javascript"
	src="<c:url value='/resources/js/dialog.js'/>"></script>

<title>问题产生</title>
<script type="text/javascript">
	$(function() {
		/*调用问题产生的算法 产生问题 开始*/
		var contentText = "${content}";
		var content = [];
		content[0] = "${tittle}";
		content[1] = contentText;
		analyze(content);
		/*调用问题产生的算法 产生问题 结束*/
	});
	function linkText() {
		location.href = "/question/evaluate/stuLinklistText";
	}
	function addEvaluate() {
		var json = {};
		json.evaluates = eval("(" + jsonstr + "])");
		for (var i = 1; i <= jsonIndex; i++) {
			var tOrF = $("input[name='evaluate" + i + "']:checked").val();
			if (typeof(tOrF) == "undefined"){
				$.messager.alert('提示', '你还有未评估的数据项');
				return false;
			}
		}
		for (var i = 1; i <= jsonIndex; i++) {
			var tOrF = $("input[name='evaluate" + i + "']:checked").val();
			var desc = $("textarea[name='desc" + i + "']").val();
			json.evaluates[i - 1].tOrF = tOrF;
			json.evaluates[i - 1].desc = desc;
		}
			var post = {
				data : JSON.stringify(json)
			};//JSON.stringify(json)把json转化成字符串
			var textId = $("input[name='textId']").val();
			var url = "/question/evaluate/saveEvaluate?textId="+textId;
			$.post(url, post, function(data) {
				//return "redirect:";fail
				if (data == "success") {
					location.href = "/question/evaluate/queryTextListEvaluated/1";
				} else {
					$.messager.alert('消息反馈', '评估提交失败！');
				}
			});
		return false;
	}

</script>
</head>
<body>
	<div class="div3">
		<font size="4"><label>课文标题：</label>${tittle}</font>
		<div style="float: right">
			<font size="4">课程名：${courseName}&nbsp;</font>
		</div>
	</div>
	<div style="width: 98%; padding-left: 20px">
		<font size="3"> <c:forEach var="sentence" items="${sentences}">
				&nbsp;&nbsp;
				${sentence}<br>
			</c:forEach>
		</font>
	</div>

	<div class="div3">
		<font size="4"><label id="inforvaluate"></label></font> <img
			id="loading" width="20px"
			src="<c:url value='/resources/images/loading.gif'/>">
	</div>
	<div class="div4">
		<form action="#" method="post">
			<input type="hidden" name="textId" value="${textId}"> 
			<table border="1" class="editTab" id="showEvaluate"
				style="font-size:">
				<tr>
					<th width="4%">序号</th>
					<th width="36%">句子</th>
					<th width="37%">问题</th>
					<th width="13%">评估</th>
					<th width="10%">错误原因</th>

				</tr>
			</table>
			 <div style="margin-left: 100px;"><input type="button" onclick="return addEvaluate()"
				class="btnPaleGreen" name="submit" style="width: 200px" value="提交评估结果"> <input
				type="button" onclick="linkText()" style="width: 200px" class="btnGray" value="返回课文">
			</div><br> <br>
		</form>
	</div>
</body>
<script src="<c:url value='/resources/question/js/common.js'/>"></script>
<script src="<c:url value='/resources/question/js/pos.js'/>"></script>
<script src="<c:url value='/resources/question/js/srl.js'/>"></script>
<script src="<c:url value='/resources/question/js/last.js'/>"></script>
<script src="<c:url value='/resources/question/js/mq.js'/>"></script>
<script
	src="<c:url value='/resources/question/js/wipeNeedlessComponent.js'/>"></script>
<script
	src="<c:url value='/resources/question/js/questionGenerator.js'/>"></script>
<script src="<c:url value='/resources/question/js/causeResult.js'/>"></script>
<script src="<c:url value='/resources/question/js/how.js'/>"></script>


</html>