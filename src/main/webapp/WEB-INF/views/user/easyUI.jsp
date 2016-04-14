<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/frameset.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<TITLE>Student Register</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link href="<c:url value='/resources/css/easylayout.css' />" rel="stylesheet"
	type="text/css" media="screen" />
<script type="text/javascript" src="<c:url value='/resources/js/dialog.js'/>"></script> 
<!-- 使用easyUI 引入包 -->
 <link rel="stylesheet" type="text/css" href="<c:url value='/resources/easyui/themes/default/easyui.css' />">   
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/easyui/themes/icon.css' />">   
<script type="text/javascript" src="<c:url value='/resources/easyui/jquery.min.js'/>"></script>   
<script type="text/javascript" src="<c:url value='/resources/easyui/jquery.easyui.min.js'/>"></script>
<title>easyUI test</title>

<script type="text/javascript">
$(function(){
	 createDialog('update','更新数据');
	  createDialog('userAdd','增添数据');
	createDialog('infor','用户信息');
	 closeDialog('update');
	closeDialog('userAdd');
	closeDialog('infor'); 
	 $("#search").hide();  
	 ajaxTable(); 
})
 
function ajaxTable(){
	var name = $("#queryName").val();
	var url;
	if($.trim(name)!=""){
		url = "test1SelByName.do?name="+name;	
	}else{
		url = "/question/test1Sel";
	}
	
	//加载表格
	$('#userSelTable').datagrid({
		url: url,
		toolbar:'#toolbar',
		checkOnSelect:true,
		pagination:true,//是否分页
		pageSize: 5,//设定每页显示5条数据
        pageList: [5, 10,15, 20, 25, 30],
		fitColumns:true,//列自适应表格宽度
		striped:true,//当true时，单元格显示条纹
		idFiled:'stuId',
		checkOnSelect:true,
		rownumbers:true,
		loadMsg:'数据加载中,请稍后...',
		onLoadError:function(){
			alert('数据加载失败!');
		},
		onLoadSuccess:function(data){
		},
		 columns:[[
					{field:'ck',checkbox:true},
					{field:'num',title:'账号',width:100},
					{field:'pass',title:'密码',width:100},
					{field:'name',title:'姓名',width:100},
					{field:'email',title:'电子邮件',width:100},
					{field:'opt',title:'操作',formatter:optFormater,width:100}
				]],
				onDblClickRow:function(rowIndex, rowData){
					showInfor(rowData.name,rowData.city,rowData.country,rowData.email);
				} 
	})
	
var pager = $('#userSelTable').datagrid('getPager');    //得到DataGrid页面
pager.pagination({
    //showPageList:false,
    buttons:[{
        iconCls:'icon-search',
        handler:function(){
            $("#search").show();
        }
    },{
        iconCls:'icon-add',
        handler:function(){
            openDialog('userAdd');
        }
    },{
        iconCls:'icon-cancel',
        handler:function(){
            test1Deles();
        }
    }]
});
	
}
function showInfor(name,city,country,email){
	$("#nameInfor").text(name);
	$("#cityInfor").text(city);
	$("#countryInfor").text(country);
	$("#emailInfor").text(email);
	openDialog("infor")
}
function optFormater(value,row,index){
	var id = row.id;
	var name =row.name;
	var city = row.city;
	var country = row.country;
	var email = row.email;
	var edit = "<a style='color:blue;cursor:pointer' onclick=test1Update('"+id+"','"+name+"','"+city+"','"+country+"','"+email+"')><U>修改</U></a> "+"|";
	var dele= "<a style='color:blue;cursor:pointer' onclick=test1Dele('"+id+"','"+name+"')><U> 删除</U></a> ";
	return edit+dele;
}
function test1Dele(id,name){
	var isSure = confirm("您确认删除用户"+name+"吗？");
		if(isSure){
			var url = "test1DeleteById.do?id="+id;
			$.ajax({
					url:url,
					type:"POST",
					async: false,
					data:'json',  
					success:function(data){
						ajaxTable();
					}
				});	
			
		}else{
			return;
	}
}
function test1Deles(){
	var names = "";
	var ids="";
	var rows = $("#userSelTable").datagrid('getSelections');
	for(var i=0; i<rows.length; i++){
	    if(i==0){
	    	ids = rows[i].id;
	    	names=rows[i].name;
	    }else{
	    	ids = ids+"-"+rows[i].id;
	     	names=names+","+rows[i].name;
	    }
	   
	}
	if(rows.length>0){
		var isSure = confirm("您确认删除用户"+names+" 共 "+rows.length+"条记录  吗？");
		if(isSure){
				var url = "test1DeleteByIds.do?ids="+ids;
				$.ajax({
						url:url,
						type:"POST",
						async: false,
						data:'json',  
						success:function(data){
							ajaxTable();
						}
					});	
		}else{
			return;
		} 
	}else{
		alert("你还未选择要删除的数据");
	}
	
}
function test1Update(id,name,city,country,email){
	openDialog('update');
	$("#id2").val(id);
	$("#name2").val(name);
	$("#city2").val(city);
	$("#country2").val(country);
	$("#email2").val(email);
}

function updateCheck(){
	$("#userUpdateForm").submit();
}
function addCheck(){
	var name = $.trim($("#name").val());
	var city = $.trim($("#city").val());
	var country =$.trim( $("#country").val());
	var email = $.trim($("#email").val());
	$("#nameCheck").hide();
	$("#cityCheck").hide();
	$("#countryCheck").hide();
	$("#emailCheck").hide();
	if(name==""){
		$("#nameCheck").text("姓名不能为空！").show();
	}else if(city==""){
		$("#cityCheck").text("城市不能为空！").show();
	}else if(country==""){
		$("#countryCheck").text("国家不能为空！").show();
	}else if(email==""){
		$("#emailCheck").text("邮箱地址不能为空！").show();
	}else{
		var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
		if (!reg.test(email))
		{
			$("#emailCheck").text("邮箱格式不正确！").show();
		}else{
			return true;
		}
	
	}	
	return false;
}

function checkName(){
	var name = $("#name").val();
	var url ="checkName.do?name="+name;
	if($.trim(name)!=""){
		$.ajax({
		url:url,
		type:"POST",
		async: true,
		data:'json',  
		success:function(data){
			if(data=='no'){
				$("#nameCheck").text("该用户名已存在");	
				$("#nameCheckR").text("");
			}
			if(data=='ok'){	
				$("#nameCheckR").text("该用户名可以使用");
				$("#nameCheck").text("");	
			}	
		}
		});
	}
}
</script>
</head>
<body>
	<div class="div1">
		<!-- 用户查询表一览 -->
		<table id="userSelTable" title="用户管理列表" width="100%" iconCls="icon-edit"></table>
		
		<div id="toolbar"
			style="border: 0px solid red; width: auto; heigth: auto;">

			<div id="search"
				style="border: 0px solid green; width: 58%; height: 30px; float: left; padding-top: 2px;">
				<span>姓名:</span> <input type="text" id="queryName" name="queryName" />
				<input type="button" onclick="ajaxTable()" value="查询" class="btn" />

			</div>

			<div
				style="border: 0px solid #999999; width: 38%; height: 30px; float: right; text-align: right; padding-right: 25px; padding-top: 6px;">
				<img alt="" src="<c:url value="/resources/images/upload_24.png"/>" width="20" height="20" /> <a
					href="javascript:return false;" onclick="openDialog('userAdd')">添加用户</a>
			</div>
		</div>

		<div id="update">
			<form id="userUpdateForm" action="test1Update.do" method="post">
				<div class="div_ul">
					<ul>
						<li><input type="hidden" id="id2" name="id2"> <label>
								姓名： </label> <input type="text" id="name2" name="name2"
							style="width: 155px;" /> <span style="color: red"> * </span> <span
							id="nameError" style="color: red"></span></li>

						<li><label> 城市： </label> <input type="text" id="city2"
							name="city2" style="width: 155px;" /> <span style="color: red">
								* </span> <span id="cityError" style="color: red"></span></li>

						<li><label> 国家： </label> <input type="text" id="country2"
							name="country2" style="width: 155px;" /> <span
							style="color: red"> * </span></li>

						<li><label> 邮箱： </label> <input type="text" id="email2"
							name="email2" style="width: 155px;" /> <span style="color: red">
								* </span></li>

						<li
							style="text-align: center; padding: 0px; height: 40px; line-height: 40px;">
							&nbsp; <input type="button" value="保存" class="btnPaleGreen"
							onclick="updateCheck()" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
							type="button" value="取消" onclick="closeDialog('update')"
							class="btnGray" />
						</li>
					</ul>
				</div>
			</form>
		</div>


		<div id="userAdd">
			<form id="userAddForm" action="test1.do" method="post">
				<br> <br> <br> <br>
				<div class="div_ul">
					<ul>
						<li><label> 姓名： </label> <input type="text" id="name"
							name="name" style="width: 155px;" onblur="checkName()" /> <span
							style="color: red"> * </span> <span id="nameCheck"
							style="font-size: 12px; color: red"></span> <span id="nameCheckR"
							style="font-size: 12px; color: blue"></span></li>
						<li><label> 城市： </label> <input type="text" id="city"
							name="city" style="width: 155px;" onblur="check()" /> <span
							style="color: red"> * </span> <span id="cityCheck"
							style="font-size: 12px; color: red"></span></li>
						<li><label> 国家： </label> <input type="text" id="country"
							name="country" style="width: 155px;" onblur="check()" /> <span
							style="color: red"> * </span> <span id="countryCheck"
							style="font-size: 12px; color: red"></span></li>
						<li><label> 邮箱： </label> <input type="text" id="email"
							name="email" style="width: 155px;" /> <span style="color: red">
								* </span> <span id="emailCheck" style="font-size: 12px; color: red"></span>
						</li>

						<li
							style="text-align: center; padding: 0px; height: 40px; line-height: 40px;">
							&nbsp; <input type="submit" value="保存" class="btnPaleGreen"
							onclick="return addCheck()" />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="button"
							value="取消" onclick="closeDialog('userAdd')" class="btnGray" />
						</li>
					</ul>
				</div>
			</form>
		</div>

		<div id="infor">
			<table width="400">
				<tr>
					<td>姓名</td>
					<td id="nameInfor"></td>
				</tr>
				<tr>
					<td>城市</td>
					<td id="cityInfor"></td>
				</tr>
				<tr>
					<td>国家</td>
					<td id="countryInfor"></td>
				</tr>
				<tr>
					<td>电子邮件</td>
					<td id="emailInfor"></td>
				</tr>
			</table>
		</div>
		<hr>
	</div>
</body>
</html>