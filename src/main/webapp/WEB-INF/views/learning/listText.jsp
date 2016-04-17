<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
	var questionTypes = document.getElementsByName("questionTypes"+textId);
		var types="";
		for(var i = 0;i<questionTypes.length;i++){
			if (questionTypes[i].checked) {
				types += "-"+questionTypes[i].value;
			}
		}
		if(types==""){
			$.messager.alert("<spring:message code='prompt'/>", "<spring:message code='pleaseSelectQuestiontype'/>");
		}else{
			$("img#"+textId).show();
			console.log(types);
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
		<img src="<c:url value='/resources/images/icon.png'/>" />&nbsp;<span><spring:message code="site"/>：<spring:message code="onlineAss"/>>><spring:message code="courseStudy"/></span>
		</c:if>
			<c:if test="${user=='tea'}">
		<img src="<c:url value='/resources/images/icon.png'/>" />&nbsp;<span><spring:message code="site"/>：<spring:message code="learningResource"/>>><spring:message code="learningResourceQuery"/>
		</span>
		</c:if>
		</div>
		<h2><spring:message code="learningResource"/></h2>
		<c:if test="${user=='stu'}">
		<input id="link1" type="hidden" value="${link}">
		<form action="/question/text/queryTextByCourse/1">
			<table width="90%">
			<c:if test="${courseSize=='0'}">
			<tr>
			<td ></td>
			<td colspan="4" align="center">
					<font size="4"><spring:message code="courseSelectThenLearn"/><button class="btnPaleGreen" onclick="return select()"><spring:message code="toCourseSelect"/></button></font>
			</td>
			</tr>
			</c:if>
					<tr id="query">
						<td ></td>
						<td align="right"><font size="4"><spring:message code="pleaseSelectCourse"/>:</font>
						<select name="course" style="width: 200px">
					<c:if test="${not empty courses}">
						<c:forEach var ="course" items="${courses}">
							<option value="${course.courseId}">${course.year} - ${course.courseName}</option>
						</c:forEach>
					</c:if>
			</select></td>
						<td><spring:message code="pleaseEnterKeyword"/>
						<input type="text" id="findText" name="findText" style="width: 200px" value="${findText}"/><font color="red"><spring:message code="nullable"/></font></td>
						<td><input type="submit" value="<spring:message code='learningResourceQuery'/>"   style="width: 100px"  class="btnPaleGreen" /></td>
				</tr>
				</table>
		</form>
				<hr color="#00aaff">
		</c:if>
		<div class="div4">
			<table border="1" class="editTab" id="table">
			<tr>
			<c:if test="${user=='stu'}">
			<th colspan="6"><spring:message code="teachersUploadTextList"/></th>
			</c:if>
			<c:if test="${user=='tea'}">
			<th colspan="9"><spring:message code="clickToGenerateQuestionForAss"/></th><font color="red"><label>${infor}</label></font>
			</c:if>
			</tr>
						<tr>
							<th width="10%"><spring:message code="title"/></th>
							<th width="10%"><spring:message code="courseName"/></th>
							
							<th width="7%"><spring:message code="publishTeacher"/></th>
							<th width="13%"><spring:message code="publishTime"/></th>
							<c:if test="${user=='stu'}">
							<th width="10%"><spring:message code="lookText"/></th>
							</c:if>
							<c:if test="${user=='tea'}">
							<th width="5%"><spring:message code="viewOriginal"/></th>
							<th width="15%" colspan="2"><spring:message code="generateQuestion"/></th>
							<th width="7%"><spring:message code="delete"/></th>
							</c:if>
							<th width="10%"><spring:message code="downloadText"/>${downloadInfor}</th>
						</tr>
						<tr>
						<c:if test="${infor=='no'}">
						<tr><td colspan="8" align="center"> <font color="red" size="4"><spring:message code="teacherHasNoAss"/></font></td></tr>
						</c:if>
						<c:if test="${not empty texts}">
						<c:forEach var="texts" items="${texts}">
							<tr>
							<td align="center">${texts.textTitle}</td>
							<td align="center">${texts.course.year} - ${texts.course.courseName}</td>
							<td align="center">${texts.teacher.teaName}</td>
							<td align="center"><fmt:formatDate pattern="yyyy-MM-dd" value="${texts.createTime}" /></td>
							<c:if test="${user=='stu'}">
							<td align="center"><a href="/question/text/lookText/${texts.teacher.teaNum}?textName=${texts.textName}&user=stu"><spring:message code="study"/></a></td>
							</c:if>
							<c:if test="${user=='tea'}">
							<td align="center"><a href="/question/text/lookText/${texts.teacher.teaNum}?textName=${texts.textName}">查看原文</a></td>
							<td align="left">
							<c:forEach var="questionTypes" items="${questionTypes}">
								<input name="questionTypes${texts.textId}" type="checkbox" value="${questionTypes.questionType}" checked="checked"><font size="1">${questionTypes.questionTypeName}</font><br/>
							</c:forEach>
							</td><td align="center">
							<a href="#" onclick='return showLoad(${texts.textId})'><spring:message code="generateQuestion"/></a>
							<img style="float: right;" id="${texts.textId}" class="loadimg" width="20px" src="<c:url value='/resources/images/loading.gif'/>"></td>
							<td align="center"><a href="/question/text/deleteText/${texts.textId}" onclick='return deleteItem()'><spring:message code="delete"/></a></td>
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
									<span><spring:message code="total"/>:${sumCount} &nbsp;&nbsp;<spring:message code="currentPage"/>：${pageNow}
									</span>&nbsp; 
									<a href="${pageContext.request.contextPath}" id="first"><spring:message code="firstPage"/></a>&nbsp; 
									<c:if test="${pageNow>1}">
										<a href="${pageContext.request.contextPath}" id="forwrad"><spring:message code="previous"/></a>&nbsp;
									</c:if>
									<c:if test="${pageNow<sumCount}">
										<a	href="${pageContext.request.contextPath}" id="next"><spring:message code="next"/></a>&nbsp; 
									</c:if>
									<a href="${pageContext.request.contextPath}" id="end"><spring:message code="lastPage"/></a>&nbsp; 
									<span><spring:message code="goto"/></span>
										<select name="select" id="changePage" style="WIDTH: 40px">
										<c:if test="${sumCount>0}">
										<option value="${pageNow}">${pageNow}</option>
										<c:forEach var="i" begin="1" end="${sumCount}">
											< <c:if test="${i!=pageNow }">
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
