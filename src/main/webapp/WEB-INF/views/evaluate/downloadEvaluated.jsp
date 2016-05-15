<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<c:url value='/resources/bootstrap3/css/bootstrap.min.css' />" rel="stylesheet" type="text/css" />
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
		<h2> </h2>
		<input id="link1" type="hidden" value="${link}">
		<form action="/question/evaluate/queryEvaluated">
		
		<table  class="table table-hover" style="width:95%;margin:0 auto;" id="table">
					<tr>
						<th><spring:message code="courseName"/></th>
						<th><spring:message code="className"/></th>
						<th><input type="checkbox" id="selectAll"
							onclick="checkEvent('courseIds','selectAll')" /></th>
					</tr>
					<c:if test="${not empty courses}">
						<c:forEach var="course" items="${courses}">
							<tr>
								<td>${course.year}<spring:message code="ji"/>${course.courseName}</td>
								<td>${course.teacher.teaName}</td>
								<td><input type="checkbox" name="courseIds"
									value="${course.courseId}"></td>
							</tr>
						</c:forEach>
					</c:if>
					<tr><td colspan="3" align="center"><input type="submit" onclick="return addE('courseIds')" value="<spring:message code='queryevaluated'/>" style="width: 100px"
						class="btnPaleGreen" /></td></tr>
		</table>
		</form>
	
		<hr color="#00aaff">
		<div  id="div3" align="center">
		<form action="/question/evaluate/downloadEvaluated">
		<input type="hidden" value="${courseIds}" name="courseIds">
		<table class="table table-hover" style="width:95%;margin:0 auto;" id="table">
				<tr>
					<th colspan="4"><spring:message code="evaluatedlist"/></th>
				</tr>
				<tr>
					<th width="30%"><spring:message code="courseName"/></th>
					<th width="30%"><spring:message code="tealabel"/></th>
					<th width="20%"><spring:message code="sendTextCounts"/></th>
					<th width="20%"><spring:message code="evaluatedCounts"/></th>
				</tr>
				<tr>
					<c:if test="${not empty list}">
						<c:forEach var="list" items="${list}">
							<tr>
								<td>${list.courseName}</td>
								<td>${list.teaName}</td>
								<td>${list.countText}</td>
								<td>${list.countEvaluate}</td>
							</tr>
						</c:forEach>
					</c:if>
					<tr>
					<td colspan="2" align="center"><a href="#" onclick="return list();">查看已评估的材料明细</a></td>
					<td colspan="2" align="center"><button style="width:200px" class="btnPaleGreen">下载已评估的数据</button></td>
					</tr>
			</table>
		</form>
		
		</div>
		<div  id="div4">
			<table class="table table-hover" style="width:95%;margin:0 auto;" id="table">
				<tr>
					<th colspan="6">已评估的材料 <a href="#" onclick="return hiden()">影藏明细</a></th>
				</tr>
				<tr>
					<th width="20%"><spring:message code="title"/></th>
					<th width="20%"><spring:message code="courseName"/></th>
					<th width="20%"><spring:message code="publishTeacher"/></th>
					
				</tr>
				<tr>
					<c:if test="${not empty texts}">
						<c:forEach var="texts" items="${texts}">
							<tr>
								<td>${texts.textTitle}</td>
								<td>${texts.course.year}<spring:message code="ji"/>${texts.course.courseName}</td>
								<td>${texts.teacher.teaName}</td>
							</tr>
						</c:forEach>
					</c:if>
			</table>
		</div>
	</div>
</body>
</html>
