<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<c:url value='/resources/css/main.css' />" rel="stylesheet"
	type="text/css" media="screen" />
<script type="text/javascript"
	src="<c:url value='/resources/jQuery/jquery-1.7.2.js' />"></script>
<script type="text/javascript">
	
	$(function(){
		$("#first").click(function(){
			var sumPage = ${sumCount};
			this.href=this.href+"/assignment/queryScoreAssignment/1?sumPage="+sumPage
		});
		$("#end").click(function(){
			var sumPage = ${sumCount};
			this.href=this.href+"/assignment/queryScoreAssignment/"+sumPage+"?sumPage="+sumPage
		});
		$("#forwrad").click(function(){
			var sumPage = ${sumCount};
			var pageNow = ${pageNow}-1;
			this.href=this.href+"/assignment/queryScoreAssignment/"+pageNow+"?sumPage="+sumPage
		});
		$("#next").click(function(){
			var sumPage = ${sumCount};
			var pageNow = ${pageNow}+1;
			this.href=this.href+"/assignment/queryScoreAssignment/"+pageNow+"?sumPage="+sumPage
		});
		$("#changePage").change(function(){
			var sumPage = ${sumCount};
			var pageNow = this.value;
			var link = $("#link");
			link[0].href=link[0].href+"/assignment/queryScoreAssignment/"+pageNow+"?sumPage="+sumPage
			link[0].click();
		});
		
	})
	
</script>
<title>批改作业</title>
</head>
<body>
	<div class="bodyDiv">
		<div class="div1">
			<img src="<c:url value='/resources/images/icon.png'/>" />&nbsp;<span>位置：学生成绩管理&gt;&gt;课外作业批改</span>
		</div>
		<h2>课外作业批改</h2>
		<div class="div4">
			<p align="center">
				<label style="color: red" id="errorInfor"></label>
			</p>

			<form action="/question/assignment/submitCorrect">
				<table class="editTab" border="3">
					<tr>
						<th colspan="10" align="center">待批改的作业</th> 
					</tr>
					<tr>
					<th align="center" width="10%">课文标题</th>
					<th align="center" width="10%">科目</th>
					<th align="center" width="10%">作业标题</th>
					<th align="center" width="10%">限时</th>
					<th align="center" width="10%">实际用时</th>
					<th align="center" width="10%">学生提交作业时间</th>
					<th align="center" width="10%">成绩</th>
					<th align="center" width="10%">学生姓名</th>
					<th align="center" width="10%">批改状态</th>
					<th align="center" width="10%">修改成绩</th>
				</tr>
				<c:forEach var="correctAssignment" items="${list}">
					<tr>
						<td align="center">${correctAssignment.assignment.text.textTitle}</td>
						<td align="center">${correctAssignment.assignment.text.course.courseName}</td>
						<td align="center">${correctAssignment.assignment.assName}</td>
						<td align="center">${correctAssignment.assignment.assTime}分钟</td>
						<td align="center">${correctAssignment.useTime}分钟</td>
						<td align="center">${correctAssignment.createTime}</td>
						<td align="center"><fmt:formatNumber value="${correctAssignment.score}" pattern="#0.0"/>分</td>
						<td align="center">${correctAssignment.student.stuName}</td>
						 <c:if test="${correctAssignment.correct==1}">
							<td align="center">教师批改</td>
						</c:if>
						 <c:if test="${correctAssignment.correct==-1}">
							<td align="center">系统批改</td>
						</c:if>
						
						<td align="center"><a href="/question/answer/tealinkAnswerPage/${correctAssignment.saId}">修改成绩</a></td>
					</tr>
				</c:forEach>

				</table>
			</form>
		</div>
		
		<div class="div6" align="center">
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
	</div>
</body>
</html>