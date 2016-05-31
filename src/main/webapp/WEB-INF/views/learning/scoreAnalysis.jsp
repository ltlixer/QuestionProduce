<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<c:url value='/resources/bootstrap3/css/bootstrap.min.css' />" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<c:url value='/resources/chartjs/Chart.js' />"></script>
<script type="text/javascript" src="<c:url value='/resources/jQuery/jquery-1.12.3.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/resources/bootstrap3/js/bootstrap.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/resources/question/js/score-analysis/scoreAnalysis.js' />"></script>
<script type="text/javascript">
	function selectedCourse(courseId){
		var url = "/question/text/queryTextByCourseId/"+courseId;
		var textSelect = document.getElementById("textSelect");
		var assList = document.getElementById("assList");
		if(typeof(assList) != "undefined" && assList != null){
			assList.innerHTML = "";
		}
		$.ajax({
	         type: "get",
	         dataType: "json",
	         url: url,
	         success: function (msg) {
	             var str = "<label>课文：</label>";
	             str += "<select id='textList' class='text' name='textId' onchange='selectedText(this.options[this.options.selectedIndex].value);'>";
				 str += "<option value='-1' style='display:none;'>--请选择课文--</option>";
	             for (i in msg) {
	            	 var textId = msg[i].textId;
	            	 var textTitle = msg[i].textTitle;
	                 str += "<option value='"+textId+"'>"+textTitle+"</option>";
	             }
	             str += "</select>";
	             textSelect.innerHTML = str;
	         }
	     });
		
	}
	function selectedText(textId){
		var url = "/question/assignment/queryAssignmentByTextId/"+textId;
		var assSelect = document.getElementById("assSelect");
		$.ajax({
	         type: "get",
	         dataType: "json",
	         url: url,
	         success: function (msg) {
	             var str = "<label>作业：</label>";
	             str += "<select id='assList' class='text' name='assId' onchange='selectedAss(this.options[this.options.selectedIndex].value);'>";
	             str += "<option value='-1' style='display:none;'>--请选择作业--</option>";
	             for (i in msg) {
	            	 var assId = msg[i].assId;
	            	 var assName = msg[i].assName;
	                 str += "<option value='"+assId+"'>"+assName+"</option>";
	             }
	             str += "</select>";
	             assSelect.innerHTML = str;
	         }
	     });
		
	}
	$('#myTab a').click(function (e) {
		 e.preventDefault()
		 $(this).tab('show')
	})	
</script>
<title>成绩分析</title>
</head>
<body >
	<div class="bodyDiv">
		<h2> </h2>
		<div>
			<label>课程：</label>
			<select id="courseList" class="text" name="courseId" onchange="selectedCourse(this.options[this.options.selectedIndex].value);">
				<option value="-1" style="display:none;">--请选择课程--</option>
				<c:if test="${not empty listCourse}">
					<c:forEach var ="course" items="${listCourse}">
						<option value="${course.courseId}">${course.year} - ${course.courseName}</option>
					</c:forEach>
				</c:if>
			</select>
			<span id="textSelect"></span>
			<span id="assSelect"></span>
		</div>
		<p> </p>
		<div class="div4">
			<div id="questionTable"></div>
			<ul id="myTab" class="nav nav-tabs" style="display:none;" role="tablist">
				<li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">学生成绩分布图</a></li>
				<li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">问题正确率分布图</a></li>
				<li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">作业时间图</a></li>
			</ul>
			<div id="myTabContent" style="display:none;" class="tab-content">
				<div role="tabpanel" class="tab-pane active" id="home" style="width:700px;margin:0 auto;"><canvas id="canvas1"></canvas><div style="height:80px;"> </div></div>
				<div role="tabpanel" class="tab-pane" id="profile" style="width:700px;margin:0 auto;"><canvas id="canvas2"></canvas><div style="height:80px;"> </div></div>
				<div role="tabpanel" class="tab-pane" id="messages" style="width:700px;margin:0 auto;"><canvas id="canvas3"></canvas><div style="height:80px;"> </div></div>
			</div>
			
		</div>
	</div>

</body>
</html>