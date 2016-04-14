<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<c:url value='/resources/css/main.css' />" rel="stylesheet"
	type="text/css" media="screen" />
<script type="text/javascript"
	src="<c:url value='/resources/js/delete.js' />"></script>
<script type="text/javascript"
	src="<c:url value='/resources/jQuery/jquery-1.7.2.js' />"></script>
	<script type="text/javascript"
	src="<c:url value='/resources/js/selectAll.js' />"></script>
<script type="text/javascript">
	$(function() {
		$("#div4").hide();
		var first = "${first}"
		if (first == "first") {
			$("#div3").hide();
		}

	})
	function list(){
		$("#div4").show(200);
	}
	function hiden(){
		$("#div4").hide(200);
	}
	function addE(name){
		   if(getSelectCount(name)<1){
		     alert("至少要选一条数据");
		     return false;
		   }else{
			  return true; 
		   }
	}
</script>
</head>
<body>
	<div class="bodyDiv">
		<div class="div4">
			<img src="<c:url value='/resources/images/icon.png'/>" />&nbsp;<span>位置：材料列表-问题产生</span>
		</div>
		<h2>评估结果查询</h2>
		<input id="link1" type="hidden" value="${link}">
		<form action="/question/evaluate/queryEvaluated">
		
		<table  class="editTab" id="table">
					<tr>
						<th align="center">课程名</th>
						<th align="center">年级</th>
						<th align="center"><input type="checkbox" id="selectAll"
							onclick="checkEvent('courseIds','selectAll')" /></th>
					</tr>
					<c:if test="${not empty courses}">
						<c:forEach var="course" items="${courses}">
							<tr>
								<td align="center">${course.year}级${course.courseName}</td>
								<td align="center">${course.teacher.teaName}</td>
								<td align="center"><input type="checkbox" name="courseIds"
									value="${course.courseId}"></td>
							</tr>
						</c:forEach>
					</c:if>
					<tr><td colspan="3" align="center"><input type="submit" onclick="return addE('courseIds')" value="查询评估结果" style="width: 100px"
						class="btnPaleGreen" /></td></tr>
		</table>
		</form>
	
		<hr color="#00aaff">
		<div  id="div3" align="center">
		<form action="/question/evaluate/downloadEvaluated">
		<input type="hidden" value="${courseIds}" name="courseIds">
		<table border="1" class="editTab" id="table">
				<tr>
					<th colspan="4">评估明细</th>
				</tr>
				<tr>
					<th width="30%">课程名</th>
					<th width="30%">教师</th>
					<th width="20%">发布材料总篇数</th>
					<th width="20%">已评估材料篇数</th>
				</tr>
				<tr>
					<c:if test="${not empty list}">
						<c:forEach var="list" items="${list}">
							<tr>
								<td align="center">${list.courseName}</td>
								<td align="center">${list.teaName}</td>
								<td align="center">${list.countText}</td>
								<td align="center">${list.countEvaluate}</td>
							</tr>
						</c:forEach>
					</c:if>
					<tr>
					<td colspan="2" align="center"><a href="#" onclick="return list();">查看已评估的材料明细</a></td>
					<td colspan="2" align="center"><button onclick="download()" style="width:200px" class="btnPaleGreen">下载已评估的数据</button></td>
					</tr>
			</table>
		</form>
		
		</div>
		<div  id="div4">
			<table border="1" class="editTab" id="table">
				<tr>
					<th colspan="6">已评估的材料 <a href="#" onclick="return hiden()">影藏明细</a></th>
				</tr>
				<tr>
					<th width="20%">标题</th>
					<th width="20%">课程名</th>
					<th width="20%">发布教师</th>
				</tr>
				<tr>
					<c:if test="${not empty texts}">
						<c:forEach var="texts" items="${texts}">
							<tr>
								<td align="center">${texts.textTitle}</td>
								<td align="center">${texts.course.year}级${texts.course.courseName}</td>
								<td align="center">${texts.teacher.teaName}</td>
							</tr>
						</c:forEach>
					</c:if>
			</table>
		</div>
	</div>
</body>
</html>
