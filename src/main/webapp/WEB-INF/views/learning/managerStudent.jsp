<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			loadMsg : '数据加载中,请稍后...',
			onLoadError : function() {
				alert('数据加载失败!');
			},
			columns : [ [ {
				field : 'ck',
				checkbox : true
			}, {
				field : 'num',
				title : '学号',
				width : 100
			}, {
				field : 'name',
				title : '姓名',
				width : 100
			}, {
				field : 'email',
				title : '电子邮件',
				width : 100
			}, {
				field : 'grade',
				title : '成绩',
				width : 100
			}, {
				field : 'opt',
				title : '操作',
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
				+ id + "','" + name + "')><U> 删除</U></a> ";
		return dele;
	}
	function removeStudent(id, name) {
		$.messager.confirm("确认", "确认删除" + name + "同学？", function(isSure) {
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
			$.messager.confirm("确认", "确定删除" + rows.length + "条记录？", function(isSure) {
				if (isSure) {
					var url = "/question/removeStudentBystuIds?stuIds=" +ids;
					location.href=url;
				} else {
					return;
				}
			})
		} else {
			$.messager.alert('提示','你还未选择要删除的数据');  
		}

	}
	
	function addExcell() {
		 if($("#file").val()==""){
			$.messager.alert('提示','你还未选择文件');  
			return false;
		} else{
			var val = $("#file").val();
			if(val.indexOf(".xls")==-1&&val.indexOf(".xlsx")==-1){
				$.messager.alert('提示','所选不是Excell文档');  
				return false;
			}
			return true;
		}
		
	}
</script>
<body>



	<!-- 用户查询表一览 -->
	<table id="userSelTable" title="学生管理列表" width="100%"
		iconCls="icon-edit"></table>
	<div id="toolbar">
		<font size="2"> <form:form
				action="/question/addStudentByExcell" enctype="multipart/form-data"
				method="post">
			 从Excell添加学生信息：<input type="file" id="file" name="file"
					value="选择文件">
				<input type="submit" class="btnPaleGreen" onclick="return addExcell()" value="添加">
				<font color="red">Excell文件中必须包含【学号】【姓名】【成绩】字段的三列</font>
			</form:form>
		</font>
		<font color="red"><label id="infor">${infor}</label></font>
	</div>
</body>
</html>
