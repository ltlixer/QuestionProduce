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
        <li class="first_li first_li1">
            <span class="glyphicon glyphicon-align-justify"></span>
           <span class="lispan1">基本信息</span>

        </li>
        <ul class="second_nav second_nav1" >
            <li><a href="/question/course/manageCourse" target="mainFrame">添加课程信息</a></li>
			<li><a href="/question/queryStudentByteaId" target="mainFrame">录入学生信息</a></li>
			<li><a href="/question/linkUpdateTeacher" target="mainFrame">修改个人信息</a></li>
			<li><a href="/question/linkTeaUpdatePassword" target="mainFrame">密 码 重 置</a></li>
        </ul>
        <li class="first_li first_li2">
            <span class="glyphicon glyphicon-leaf"></span>
            <span class="lispan2">发布作业</span>

        </li>
        <ul class="second_nav second_nav2">
            <li><a href="/question/text/linkAddText" target="mainFrame">上传课文</a></li>
			<li><a href="/question/text/queryText/1" target="mainFrame">布置作业</a></li>
			<li><a href="http://222.198.126.241/pad/teacher/index.html" target="mainFrame">协同写作</a></li>
            <li><a href="/question/assignment/queryAssignment/1" target="mainFrame">管理作业</a></li>
        </ul>
        <li class="first_li first_li3">
            <span class="glyphicon glyphicon-pencil"></span>
            <span class="lispan3">作业评价</span>
        </li>
        <ul class="second_nav second_nav3">
			<li><a href="/question/assignment/queryScoreAssignment/1" target="mainFrame">作业批改</a></li>
			<li><a href="/question/assignment/showScoreAssignment/1" target="mainFrame">查看成绩</a></li>
			<li><a href="/question/assignment/scoreAnalysis" target="mainFrame">成绩分析</a></li>
        </ul>
        <li class="first_li first_li4">
            <span class="glyphicon glyphicon-pencil"></span>
            <span class="lispan4">报表打印</span>
        </li>
        <ul class="second_nav second_nav4">
           <li><a href="/question/evaluate/linkqueryEvaluated" target="mainFrame">打分评估结果</a></li>
			<li><a href="/question/evaluate/linkqueryLogTea" target="mainFrame">出题时间跟踪</a></li>
			<li><a href="/question/evaluate/linkqueryLogStu" target="mainFrame">做题时间跟踪</a></li>
        </ul>
        <li class="first_li first_li5">
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
        $(".second_nav4").slideUp();
        $(".second_nav2").slideUp();
        $(".second_nav3").slideUp();
//        alert(str1);
    })
    $(".first_li2").click(function(){
        str1 = $(".lispan2").text();
        $(".second_nav2").slideToggle();
        $(".second_nav4").slideUp();
        $(".second_nav1").slideUp();
        $(".second_nav3").slideUp();
//        alert(str1);
    })
    $(".first_li3").click(function(){
        str1 = $(".lispan3").text();
        $(".second_nav3").slideToggle();
        $(".second_nav4").slideUp();
        $(".second_nav2").slideUp();
        $(".second_nav1").slideUp();
    })
    $(".first_li4").click(function(){
        str1 = $(".lispan4").text();
        $(".second_nav4").slideToggle();
        $(".second_nav3").slideUp();
        $(".second_nav2").slideUp();
        $(".second_nav1").slideUp();
    })
    $(".first_li5").click(function(){
        $(".second_nav1").slideUp();
        $(".second_nav2").slideUp();
        $(".second_nav3").slideUp();
        $(".second_nav4").slideUp();
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