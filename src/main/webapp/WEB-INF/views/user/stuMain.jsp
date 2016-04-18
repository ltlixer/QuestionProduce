<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <script type="text/javascript" src="<c:url value='/resources/jQuery/jquery-1.7.2.js' />"></script>
  <script type="text/javascript">
  $(function(){
	  var language ="<spring:message code='language'/>";//语言选择
	  if(language=="en"){
		  var fs =  $("frame[name='zh_CN']");
			for(var i=0;i<fs.length;i++){
				fs[i].remove();
			}
	  }else{
		  var fs =  $("frame[name='en']");
			for(var i=0;i<fs.length;i++){
				fs[i].remove();
			} 
	  }
  })
 
  </script>
    <title><spring:message code='systemName'/>stu</title>
  </head>

	<frameset rows="60,*,28" frameborder="no" framespacing="0" >
  			<frame name ="zh_CN" src="<c:url value='/resources/html_zh_CN/stutop.html?s=${stu.stuName}'/>" scrolling="no"></frame>
  			<frame name ="en" src="<c:url value='/resources/html_en/stutop.html?s=${stu.stuName}'/>" scrolling="no"></frame>
	        <frameset id="centerSet" cols="220,10,*" frameborder="no" framespacing="0">
				<frame name="zh_CN" src="<c:url value="/resources/html_zh_CN/stuleft.html" />" scrolling="no"></frame>
				<frame name="en" src="<c:url value="/resources/html_en/stuleft.html" />" scrolling="no"></frame>
				<frame src="<c:url value="/resources/html/center.html" />" scrolling="no"></frame>
				<frame  src="<c:url value="/resources/html/sturight.html" />" name="mainFrame"></frame>
				
	        </frameset>
	        <frame src="<c:url value="/resources/html/bottom.html"/>" scrolling="no"></frame> 
  </frameset>
</html>
