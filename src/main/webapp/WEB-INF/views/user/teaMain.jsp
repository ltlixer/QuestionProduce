<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <script type="text/javascript" src="<c:url value='/resources/jQuery/jquery-1.7.2.js' />"></script>
   <script type="text/javascript">
  window.onload=function(){
	  var language ="<spring:message code='language'/>";//语言选择
	  if(language=="en"){
		  var cntop = document.getElementById("cntop");
		  var cnleft = document.getElementById("cnleft");
		  cntop.parentNode.removeChild(cntop);
		  cnleft.parentNode.removeChild(cnleft);
	  }else{
		  var entop = document.getElementById("entop");
		  var enleft = document.getElementById("enleft");
		  entop.parentNode.removeChild(entop);
		  enleft.parentNode.removeChild(enleft);
	  }
  }
 
  </script>
  <title><spring:message code='systemName'/> tea</title>
    
  </head>
	<frameset rows="60,*,28" frameborder="no" framespacing="0" >
  			<frame id="cntop" name="zh_CN" src="<c:url value='/resources/html_zh_CN/teatop.html?s=${tea.teaNum}'/>" scrolling="no"></frame>
  			<frame id="entop" name="en" src="<c:url value='/resources/html_en/teatop.html?s=${tea.teaNum}'/>" scrolling="no"></frame>
	        <frameset id="centerSet" cols="220,10,*" frameborder="no" framespacing="0">
				<frame id="cnleft" name="zh_CN" src="<c:url value="/resources/html_zh_CN/tealeft.html" />" scrolling="no"></frame>
				<frame id="enleft" name="en" src="<c:url value="/resources/html_en/tealeft.html" />" scrolling="no"></frame>
				<frame src="<c:url value="/resources/html/center.html" />" scrolling="no"></frame>
				<frame src="<c:url value="/resources/html/tearight.html" />" name="mainFrame"></frame>
				
	        </frameset>
	        <frame src="<c:url value="/resources/html/bottom.html"/>" scrolling="no"></frame>
  </frameset>
  
</html>
