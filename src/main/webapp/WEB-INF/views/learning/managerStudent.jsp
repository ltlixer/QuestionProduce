<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="../com/easyui.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link href="<c:url value='/resources/css/easylayout.css' />"
	rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript"
	src="<c:url value='/resources/js/dialog.js'/>"></script>
<title>My JSP 'userList.jsp' starting page</title>

</head>
<script type="text/javascript">
	$(function() {
		ajaxTable();
	})
	function ajaxTable() {
		var url = "/question/ajaxStudentByteaId";
		//加载表格
		$('#userSelTable').datagrid({
			url : url,
			toolbar : '#toolbar',
			checkOnSelect : true,
			pagination : true,//是否分页
			pageSize : 15,//设定每页显示10条数据
			pageList : [10,15,20, 25, 30, 50],
			fitColumns : true,//列自适应表格宽度
			striped : true,//当true时，单元格显示条纹
			idFiled : 'stuId',
			checkOnSelect : true,
			rownumbers : true,
			loadMsg : "<spring:message code='loading'/>",
			onLoadError : function() {
				alert("<spring:message code='dataLoadError'/>");
			},
			columns : [ [ {
				field : 'ck',
				checkbox : true
			}, {
				field : 'num',
				title : "<spring:message code='stuNum'/>",
				width : 100
			}, {
				field : 'name',
				title : "<spring:message code='name'/>",
				width : 100
			}, {
				field : 'email',
				title : "<spring:message code='email'/>",
				width : 100
			}, {
				field : 'grade',
				title : "<spring:message code='score'/>",
				width : 100
			}, {
				field : 'opt',
				title : "<spring:message code='operating'/>",
				formatter : optFormater,
				width : 100
			} ] ]

		})
		var pager = $('#userSelTable').datagrid('getPager'); //得到DataGrid页面
		pager.pagination({
			buttons : [ {
				iconCls : 'icon-cancel',
				handler : function() {
					removeStudents();
				}
			} ]
		});
	}
	function optFormater(value, row, index) {
		var id = row.stuId;
		var name = row.name;
		var dele = "<a style='color:blue;cursor:pointer' onclick=removeStudent('"
				+ id + "','" + name + "')><U> <spring:message code='delete'/></U></a> ";
		return dele;
	}
	function removeStudent(id, name) {
		$.messager.confirm("<spring:message code='confirm'/>", "<spring:message code='confirmDeletion'/>" + name + "<spring:message code='classmate'/>？", function(isSure) {
			if (isSure) {
				var url = "/question/removeStudentBystuId/" + id;
				location.href=url;
			} else {
				return;
			}
		});

	}
	function removeStudents() {
		var ids = "";
		var rows = $("#userSelTable").datagrid('getSelections');
		if(rows.length>0)
			ids = rows[0].stuId;
		for (var i = 1; i < rows.length; i++) {
			ids = ids+"-"+rows[i].stuId;
		}
		
		if (rows.length > 0) {
			$.messager.confirm("<spring:message code='confirm'/>", "<spring:message code='confirmDeletion'/>" + rows.length + "<spring:message code='records'/>？", function(isSure) {
				if (isSure) {
					var url = "/question/removeStudentBystuIds?stuIds=" +ids;
					location.href=url;
				} else {
					return;
				}
			})
		} else {
			$.messager.alert("<spring:message code='prompt'/>","<spring:message code='notSelectDeleteData'/>");  
		}

	}
	
	function addExcell() {
		 if($("#file").val()==""){
			$.messager.alert("<spring:message code='prompt'/>","<spring:message code='notSelectFile'/>");  
			return false;
		} else{
			var val = $("#file").val();
			if(val.indexOf(".xls")==-1&&val.indexOf(".xlsx")==-1){
				$.messager.alert("<spring:message code='prompt'/>","<spring:message code='selectNotExcel'/>");  
				return false;
			}
			return true;
		}
		
	}
</script>
<body>



	<!-- 用户查询表一览 -->
	<table id="userSelTable" title="<spring:message code='stuManagementList'/>" width="100%"
		iconCls="icon-edit"></table>
	<div id="toolbar">
		<font size="2"> <form:form
				action="/question/addStudentByExcell" enctype="multipart/form-data"
				method="post">
			<spring:message code="addStuFromExcel"/>：<input type="file" id="file" name="file"
					value="<spring:message code='selectFile'/>">
				<input type="submit" class="btnPaleGreen" onclick="return addExcell()" value="<spring:message code='add'/>">
				<font color="red"><spring:message code="excelContainNameStuidScore"/></font>
			</form:form>
		</font>
		<font color="red"><label id="infor">${infor}</label></font>
	</div>
</body>
</html>
