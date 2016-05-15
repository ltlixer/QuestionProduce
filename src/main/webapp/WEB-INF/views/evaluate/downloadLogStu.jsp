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
<link href="<c:url value='/resources/css/bootstrap.min.css' />"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="<c:url value='/resources/js/delete.js' />"></script>
<script type="text/javascript"
	src="<c:url value='/resources/jQuery/jquery-1.7.2.js' />"></script>
	<script type="text/javascript"
	src="<c:url value='/resources/js/selectAll.js' />"></script>
<script type="text/javascript">
	$(function() {
		var first = "${first}"
			if (first == "first") {
				$("#viewLog").hide();
			}
	})
	function addE(name){
		   if(getSelectCount(name)<1){
		     alert("至少要选一条数据");
		     return false;
		   }else{
			  return true; 
		   }
	}
	function view(name){
		if(getSelectCount(name)<1){
		     alert("至少要选一条数据");
		     return false;
		   }
		var names=document.getElementsByName(name);
		var courseIds = "";
		var len = names.length;
		if(len>0){
			var i = 0;
			for(i=0;i<len;i++){
				if(names[i].checked==true){
					courseIds +="-"+names[i].value;
				}
			}
		}
		if(courseIds!=""){
			 location.href="/question/evaluate/viewlogStu?courseIds="+courseIds;
		}else{
			return false;
		}
	}
	
</script>
</head>
<body>
	<div class="bodyDiv">
		
		<h2> </h2>
		<input id="link1" type="hidden" value="${link}">
		<form action="/question/evaluate/downlogStu">
		
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
					<tr><td colspan="3" align="center"><input type="submit" onclick="return addE('courseIds')" value="<spring:message code="downstulog"/>" style="width: 100px"
						class="btnPaleGreen" />&nbsp;&nbsp;<a href="#" onclick="return view('courseIds')"><spring:message code="looklist"/></a></td></tr>
		</table>
		</form>
		<hr color="#00aaff">
		
		<table border="1" class="table table-hover" style="width:95%;margin:0 auto;" id="viewLog">
				<tr>
					<th colspan="6"><spring:message code="stuSendAssList"/></th>
				</tr>
				<tr>
					<th width="20%"><spring:message code="courseName"/></th>
					<th width="10%"><spring:message code="title"/></th>
					<th width="10%"><spring:message code="stuName"/></th>
					<th width="20%"><spring:message code="questionType"/></th>
					<th width="20%"><spring:message code="startTime"/></th>
					<th width="20%"><spring:message code="endTime"/></th>
				</tr>
				<tr>
					<c:if test="${not empty logs}">
						<c:forEach var="list" items="${logs}">
							<tr>
								<td>${list.assignment.text.course.courseName}</td>
								<td>${list.assignment.text.textTitle}</td>
								<td>${list.user}</td>
								<td>${list.questionType}</td>
								<td>${list.startTime}</td>
								<td>${list.endTime}</td>
							</tr>
						</c:forEach>
					</c:if>
			</table>
		
	</div>
</body>
</html>
