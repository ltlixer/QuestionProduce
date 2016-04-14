<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../com/easyui.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<c:url value='/resources/css/main.css' />" rel="stylesheet"
	type="text/css" media="screen" />
	<script type="text/javascript"
	src="<c:url value='/resources/js/delete.js' />"></script>
<script type="text/javascript">
$(function(){
	if($("#link1").val()=="first"){
		$("#table").hide();
		$("#div6").hide();
	} 
	if('${courseSize}'=='0'){
		$("#query").hide();//若无课程，查询按钮影藏
		$("#div6").hide();//若无课程，分页栏影藏
	}
	
	$(".loadimg").hide();
	 /* 变量 user ="stu"代表是学生访问该页面；user=tea教师访问该页面，具有删除等更高权限   */
	var findText = $("#findText").val();
	 $("#first").click(function(){
		var sumPage = ${sumCount};
		var user = $("#user")[0].name
		if(user=='stu'){
			this.href=this.href+"/text/queryTextByCourse/1?sumPage="+sumPage+"&findText="+findText+"&course="+$("select[name='course']").val();
		}else{
			this.href=this.href+"/text/queryText/1?sumPage="+sumPage
		}
	});
	$("#end").click(function(){
		var sumPage = ${sumCount};
		var user = $("#user")[0].name
		if(user=='stu'){
			this.href=this.href+"/text/queryTextByCourse/"+sumPage+"?sumPage="+sumPage+"&findText="+findText+"&course="+$("select[name='course']").val();
		}else{
			this.href=this.href+"/text/queryText/"+sumPage+"?sumPage="+sumPage
		}
	});
	$("#forwrad").click(function(){
		var sumPage = ${sumCount};
		var pageNow = ${pageNow}-1;
		var user = $("#user")[0].name
		if(user=='stu'){
			this.href=this.href+"/text/queryTextByCourse/"+pageNow+"?sumPage="+sumPage+"&findText="+findText+"&course="+$("select[name='course']").val();
		}else{
			this.href=this.href+"/text/queryText/"+pageNow+"?sumPage="+sumPage
		}
	});
	$("#next").click(function(){
		var sumPage = ${sumCount};
		var pageNow = ${pageNow}+1;
		var user = $("#user")[0].name
		if(user=='stu'){
			this.href=this.href+"/text/queryTextByCourse/"+pageNow+"?sumPage="+sumPage+"&findText="+findText+"&course="+$("select[name='course']").val();
		}else{
			this.href=this.href+"/text/queryText/"+pageNow+"?sumPage="+sumPage
		}
	});
	$("#changePage").change(function(){
		var sumPage = ${sumCount};
		var pageNow = this.value;
		var link = $("#link");
		var user = $("#user")[0].name
		if(user=='stu'){
			link[0].href=link[0].href+"/text/queryTextByCourse/"+pageNow+"?sumPage="+sumPage+"&findText="+findText+"&course="+$("select[name='course']").val();
		}else{
			link[0].href=link[0].href+"/text/queryText/"+pageNow+"?sumPage="+sumPage
		}
		link[0].click();
	});
	
	$("#findText").focus(function(){
		$(this).css("background", "#CCFFFF");
	}).blur(function(){
		$(this).css("background", "#FFFFFF");
	});
	
})

function showLoad(textId){
	var questionTypes = document.getElementsByName("questionTypes");
		var types="";
		for(var i = 0;i<questionTypes.length;i++){
			if (questionTypes[i].checked) {
				types += "-"+questionTypes[i].value;
			}
		}
		if(types==""){
			$.messager.alert('提示', '请选择题型');
		}else{
			$("img#"+textId).show();
			 location.href="/question/text/productQuestion/"+textId+"?types="+types;
		}
		
	
	 return false;
}
function select(){
	 location.href="/question/queryCourse/1";
	 return false;
}
</script>
</head>
<body>
	<div class="bodyDiv">
		<div class="div1">
		<c:if test="${user=='stu'}">
		<img src="<c:url value='/resources/images/icon.png'/>" />&nbsp;<span>位置：在线作业>>课程学习</span>
		</c:if>
			<c:if test="${user=='tea'}">
		<img src="<c:url value='/resources/images/icon.png'/>" />&nbsp;<span>位置：学习材料>>学习材料查询
		</span>
		</c:if>
		</div>
		<h2>学习材料</h2>
		<c:if test="${user=='stu'}">
		<input id="link1" type="hidden" value="${link}">
		<form action="/question/text/queryTextByCourse/1">
			<table width="90%">
			<c:if test="${courseSize=='0'}">
			<tr>
			<td ></td>
			<td colspan="4" align="center">
					<font size="4">请先选课，在进行学习。<button class="btnPaleGreen" onclick="return select()">去选课</button></font>
			</td>
			</tr>
			</c:if>
					<tr id="query">
						<td ></td>
						<td align="right"><font size="4">请选择课程:</font>
						<select name="course" style="width: 200px">
					<c:if test="${not empty courses}">
						<c:forEach var ="course" items="${courses}">
							<option value="${course.courseId}">${course.year}级${course.courseName}</option>
						</c:forEach>
					</c:if>
			</select></td>
						<td>请输入关键词
						<input type="text" id="findText" name="findText" style="width: 200px" value="${findText}"/><font color="red">（可空）</font></td>
						<td><input type="submit" value="查询学习资料"   style="width: 100px"  class="btnPaleGreen" /></td>
				</tr>
				</table>
		</form>
				<hr color="#00aaff">
		</c:if>
		<div class="div4">
			<table border="1" class="editTab" id="table">
			<tr>
			<c:if test="${user=='stu'}">
			<th colspan="6">教师上传的课文列表</th>
			</c:if>
			<c:if test="${user=='tea'}">
			<th colspan="9">点击【产生问题】将产生待布置的作业问题</th><font color="red"><label>${infor}</label></font>
			</c:if>
			</tr>
						<tr>
							<th width="10%">标题</th>
							<th width="10%">课程名</th>
							
							<th width="7%">发布教师</th>
							<th width="13%">发布时间</th>
							<c:if test="${user=='stu'}">
							<th width="10%">查看课文</th>
							</c:if>
							<c:if test="${user=='tea'}">
							<th width="5%">查看原文</th>
							<th width="15%" colspan="2">产生问题</th>
							<th width="7%">删除</th>
							</c:if>
							<th width="10%">课文下载${downloadInfor}</th>
						</tr>
						<tr>
						<c:if test="${infor=='no'}">
						<tr><td colspan="8" align="center"> <font color="red" size="4">老师还没有布置作业</font></td></tr>
						</c:if>
						<c:if test="${not empty texts}">
						<c:forEach var="texts" items="${texts}">
							<tr>
							<td align="center">${texts.textTitle}</td>
							<td align="center">${texts.course.year}级${texts.course.courseName}</td>
							<td align="center">${texts.teacher.teaName}</td>
							<td align="center"><fmt:formatDate pattern="yyyy-MM-dd" value="${texts.createTime}" /></td>
							<c:if test="${user=='stu'}">
							<td align="center"><a href="/question/text/lookText/${texts.teacher.teaNum}?textName=${texts.textName}&user=stu">学习</a></td>
							</c:if>
							<c:if test="${user=='tea'}">
							<td align="center"><a href="/question/text/lookText/${texts.teacher.teaNum}?textName=${texts.textName}">查看原文</a></td>
							<td align="left">
							<c:forEach var="questionTypes" items="${questionTypes}">
								<input name="questionTypes" type="checkbox" value="${questionTypes.questionType}" checked="true"><font size="1">${questionTypes.questionTypeName}</font><br/>
							</c:forEach>
							</td><td align="center">
							<a href="#" onclick='return showLoad(${texts.textId})'>产生问题</a>
							<img style="float: right;" id="${texts.textId}" class="loadimg" width="20px" src="<c:url value='/resources/images/loading.gif'/>"></td>
							<td align="center"><a href="/question/text/deleteText/${texts.textId}" onclick='return deleteItem()'>删除</a></td>
							</c:if>
							<td align="center"><a href="/question/text/downloadText/${texts.teacher.teaNum}?fileName=${texts.textName}" id="file">
							<c:set var="string1" value="${texts.textName}"/>
							<c:set var="string2" value="${fn:substringAfter(string1, '_')}"/>
								${string2}</a></td>
						</tr>
						</c:forEach>
						</c:if>
					</table>
					<a id="user" name="${user}"></a>
					</div>
					<div class="div6" align="center" id="div6">
						<table>
								<tr  height=20>
									<td height="20" align="center" valign="middle" nowrap>
									<span>共-${sumCount}-页  &nbsp;&nbsp;第-${pageNow}-页
									</span>&nbsp; 
									<a href="${pageContext.request.contextPath}" id="first">首页</a>&nbsp; 
									<c:if test="${pageNow>1}">
										<a href="${pageContext.request.contextPath}" id="forwrad">上一页</a>&nbsp;
									</c:if>
									<c:if test="${pageNow<sumCount}">
										<a	href="${pageContext.request.contextPath}" id="next">下一页</a>&nbsp; 
									</c:if>
									<a href="${pageContext.request.contextPath}" id="end">尾页</a>&nbsp; 
									<span>跳转到</span>
										<select name="select" id="changePage" style="WIDTH: 40px">
										<c:if test="${sumCount>0}">
										<option value="${pageNow}">${pageNow}</option>
										<c:forEach var="i" begin="1" end="${sumCount}">
											<c:if test="${i!=pageNow }">
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
