<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!-- Sidebar -->
<div class="content_left col-lg-3 col-md-3 col-sm-3">
    <ul class="first_nav tab">
        <li class="first_li first_li2">
            <span class="glyphicon glyphicon-leaf"></span>
            <span class="lispan2">基本信息</span>

        </li>
        <ul class="second_nav second_nav2">
            <li><a href="/question/queryCourse/1" target="mainFrame">选择课程</a></li>
            <li><a href="/question/linkUpdateStudent" target="mainFrame">修改邮箱</a></li>
            <li><a href="/question/linkStuUpdatePassword" target="mainFrame">密码重置</a></li>
        </ul>
        <li class="first_li first_li3">
            <span class="glyphicon glyphicon-pencil"></span>
            <span class="lispan3">在线作业</span>

        </li>
        <ul class="second_nav second_nav3">
            <li><a href="/question/text/stuLinklistText" target="mainFrame">课 程 学 习</a></li>
            <li><a href="/question/assignment/stulinkqueryAssignment" target="mainFrame">开始在线作业</a></li>
            <li><a href="/question/assignment/finishedAssignment/1" target="mainFrame">完成的作业</a></li>
            <li><a href="/question/assignment/queryScoreAssignmentBystuId/1" target="mainFrame">查看作业成绩</a></li>
        </ul>
        <li class="first_li first_li4">
            <span class="glyphicon glyphicon-menu-up"></span>
            <span>收起菜单</span>
        </li>
    </ul>

</div>
<!-- End Sidebar -->
<script>
    var str1 = "";
    var str2 = "";

    $(".first_li1").click(function(){
        str1 = $(".lispan1").text();
        $(".second_nav1").slideToggle();
        $(".second_nav2").slideUp();
        $(".second_nav3").slideUp();
//        alert(str1);
    })
    $(".first_li2").click(function(){
        str1 = $(".lispan2").text();
        $(".second_nav2").slideToggle();
        $(".second_nav1").slideUp();
        $(".second_nav3").slideUp();
//        alert(str1);
    })
    $(".first_li3").click(function(){
        str1 = $(".lispan3").text();
        $(".second_nav3").slideToggle();
        $(".second_nav2").slideUp();
        $(".second_nav1").slideUp();
    })
    $(".first_li4").click(function(){
        $(".second_nav1").slideUp();
        $(".second_nav2").slideUp();
        $(".second_nav3").slideUp();
    })
    $(".second_nav>li").click(function(){
//        $(this).stopPropagation();
        str2 = $(this).text();
        $(".span1").html(str1+">");
        $(".span2").html(str2);
//        alert(str1);
//        alert(str2);
    })
//    $(".first_li").each(function(index){
//        if(index == 4){
//            $(".second_nav").slideUp();
//        }else{
//            $(this).click(function(){
//                $(".second_nav").slideUp();
//                setTimeout($(".second_nav").eq(index).slideToggle(),500);
//
//            })
//        }
//    })
</script>