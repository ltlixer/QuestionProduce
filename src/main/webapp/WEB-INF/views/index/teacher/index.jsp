<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>

<body>
	<div class="body">
	<!-- header -->
	<jsp:include page="../../include/teacher/header.jsp"></jsp:include>
	<!-- Main Page -->
	<div class="content">
		<!-- sidebar左侧导航栏 -->
		<jsp:include page="../../include/teacher/sidebar.jsp"></jsp:include>
        
        <div class="content_right">
            <div class="right_nav">
                <span class="glyphicon glyphicon-home " style="font-size: 20px;color: #ffffff;margin-left: 15px;margin-top: 10px"></span>
                <span class="span1" style="color: #ffffff;font-size: 15px;margin-top: 10px;margin-left: 10px;"></span>
                <span class="span2" style="color: #ffffff;font-size: 15px;margin-top: 10px;"></span>
            </div>
            <iframe name="mainFrame" target="_self"  frameborder="0" height="100%" width="100%" style="padding-top:50px;padding-bottom:60px;" src="<c:url value="/resources/html/right.html" />"></iframe>
            
        </div>
    </div>
	<!-- End Main Page -->	
	
	<!-- footer -->	
	<jsp:include page="../../include/teacher/footer.jsp"></jsp:include>		
	</div>
<script type="text/javascript">
    var winWidth = 0;
    var winHeight = 0;

    var debounce = function (func, threshold, execAsap) {
        var timeout;
        return function debounced () {
            var obj = this, args = arguments;
            function delayed () {
                if (!execAsap)
                    func.apply(obj, args);
                timeout = null;
            };
            if (timeout)
                clearTimeout(timeout);
            else if (execAsap)
                func.apply(obj, args);
            timeout = setTimeout(delayed, threshold );
        };
    };
//    adjust();
 window.onload = function(){
     var body = document.getElementsByClassName("body")[0];
     var content = document.getElementsByClassName("content")[0];
     //获取窗口宽度
     if (window.innerWidth)
         winWidth = window.innerWidth;
     else if ((document.body) && (document.body.clientWidth))
         winWidth = document.body.clientWidth;
     //获取窗口高度
     if (window.innerHeight)
         winHeight = window.innerHeight;
     else if ((document.body) && (document.body.clientHeight))
         winHeight = document.body.clientHeight;

     //通过深入Document内部对body进行检测，获取窗口大小
     if (document.documentElement  && document.documentElement.clientHeight &&
             document.documentElement.clientWidth)
     {
         winHeight = document.documentElement.clientHeight;
         winWidth = document.documentElement.clientWidth;
     }
     //在这里写你的处理函数，winWidth和winHeight这两个全局变量分别是页面宽度和高度

     body.style.height = (parseInt(winHeight)+50)+"px";
//        body.style("height",winHeight)
//        body.style("width",winWidth)
     body.style.width = winWidth;

     content.style.height = (parseInt(winHeight) -50)+"px";
 };
    window.onresize = debounce(function(){
        var body = document.getElementsByClassName("body")[0];
        var content = document.getElementsByClassName("content")[0];
        //获取窗口宽度
        if (window.innerWidth)
            winWidth = window.innerWidth;
        else if ((document.body) && (document.body.clientWidth))
            winWidth = document.body.clientWidth;
        //获取窗口高度
        if (window.innerHeight)
            winHeight = window.innerHeight;
        else if ((document.body) && (document.body.clientHeight))
            winHeight = document.body.clientHeight;

        //通过深入Document内部对body进行检测，获取窗口大小
        if (document.documentElement  && document.documentElement.clientHeight &&
                document.documentElement.clientWidth)
        {
            winHeight = document.documentElement.clientHeight;
            winWidth = document.documentElement.clientWidth;
        }
        //在这里写你的处理函数，winWidth和winHeight这两个全局变量分别是页面宽度和高度

        body.style.height = (parseInt(winHeight)+50)+"px";
//        body.style("height",winHeight)
//        body.style("width",winWidth)
        body.style.width = winWidth;

        content.style.height = (parseInt(winHeight) -60)+"px";
    },10,true);

</script>
</body>
</html>
