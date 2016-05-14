<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<head>
<!-- Basic -->
<meta charset="UTF-8" />

<link href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet" type="text/css">
<link href="<c:url value='/resources/css/responsive-nav.css'/>" rel="stylesheet" type="text/css">
<link href="<c:url value='/resources/css/mycss.css'/>" rel="stylesheet" type="text/css">
<script src="<c:url value='/resources/js/jquery-2.2.2.min.js'/>"></script>
<script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/resources/js/responsive-nav.min.js'/>"></script>
</head>
<!-- Start: Header -->
<div class="header">
	<div class="col-lg-2 col-md-2 col-sm-2 nav_class"
		style="border-right: 1px solid lightgrey">
		<img src="<c:url value='/resources/images/logonew.png'/>" style="width: 200px; height: 60px">
	</div>
	<div class="col-lg-4   col-md-4  col-sm-4 nav_class">
		<span class="glyphicon glyphicon-th-large span_user"
			style="color: lightgrey; margin-left: 15px"></span> <input
			type="text" class="form-control bk-radius" placeholder="Search"
			style="width: 200px; margin-left: 50px; margin-top: -25px;">
		<button class="btn btn-default btnclass" type="submit">
			<span class="glyphicon glyphicon-search"></span>
		</button>
	</div>
	<div
		class="col-lg-2 col-lg-offset-2 col-md-2 col-md-offset-2 col-sm-2 col-sm-offset-2 nav_class">
		<button type="button" class="btn btn-default btn_icon"
			aria-label="Left Align">
			<span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
		</button>
		<button type="button" class="btn btn-default btn_icon"
			aria-label="Left Align">
			<span class="glyphicon glyphicon-bell" aria-hidden="true"></span>
		</button>
		<button type="button" class="btn btn-default btn_icon"
			aria-label="Left Align">
			<span class="glyphicon glyphicon-comment" aria-hidden="true"></span>
		</button>
	</div>
	<div class="col-lg-2 col-md-2 col-sm-2 nav_class">
		<div class="divclass"
			style="text-align: center; margin-bottom: 10px; cursor: pointer">
			<img src="<c:url value='/resources/images/webwxgeticon.jpg'/>"
				style="width: 50px; border-radius: 50%; padding-top: 5px;"> <span
				style="margin-left: 10px">${tea.teaName}</span>
		</div>
		<div class="show_div" style="display: none; z-index: 1000;">
			<div class="sub_div">
				<p>修改密码</p>
			</div>
			<div class="sub_div">
				<p><a href="/question/exit">退出</a></p>
			</div>
		</div>
	</div>
</div>
<!-- End: Header -->
<script>
    $(".divclass").click(function(){
        $(".show_div").slideToggle();
    });
    $(".sub_div").mouseenter(function(){
        $(this).addClass("sub_divcolor")
    }).mouseleave(function(){
        $(this).removeClass("sub_divcolor")
    })
</script>