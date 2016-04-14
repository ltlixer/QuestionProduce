<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/frameset.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 <%@ include file="../com/easyui.jsp" %> 
<html>
<head>
<TITLE>Student Register</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link href="<c:url value='/resources/css/main.css' />" rel="stylesheet"
	type="text/css" media="screen" />
<script type="text/javascript"
	src="<c:url value='/resources/js/dialog.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resources/js/dateFormat.js'/>"></script>

<title>问题产生</title>
<script type="text/javascript">
var multiplechoiceStartTime="";
var multiplechoiceEndTime="";
var factoidStartTime="";
var factoidEndTime="";
var deeperStartTime="";
var deeperEndTime="";
var originalStartTime="";
var originalEndTime="";
var secondViewMultiplechoice = false;
var secondViewFactoid = false;/* 表示是否是第二次点击事实类问题的下一题：当点上一步时记录标注 为true 不计时 */
var secondViewDeeper = false;/* 表示是否是第二次点击深层次问题的下一题：当点上一步时记录标注  为true 不计时 */

$(function() {
		timeShow();
		$("#MultiplechoiceQuestion").hide();
		$("#FactoidQuestion").hide();
		$("#DeeperQuestion").hide();
		$("#OriginalQuestion").hide();
		$("#submitAss").hide();
		$("#multiplechoiceNextId").hide();
		$("#factoidNextId").hide();
		$("#deeperNextId").hide();
		$("#deeperLastId").hide();
		$("#originalLastId").hide();
		var MultiplechoiceSize = "${MultiplechoiceSize}";
		var FactoidSize = "${FactoidSize}";
    	var DeeperSize="${DeeperSize}";
    	var OriginalSize="${OriginalSize}";
    	if(MultiplechoiceSize!='0'){
    		multiplechoiceStartTime =new Date();
    		multiplechoiceQuestionShow(0);
    	}else if(FactoidSize!='0'){
    		factoidStartTime =new Date();
    		factoidQuestionShow(0);
    	}else if(DeeperSize!='0'){
    		deeperStartTime =new Date(); 
    		deeperQuestionShow(0);
    	}else if(OriginalSize!='0'){
    		originalStartTime = new Date(); 
    		OriginalQuestionShow(0)
    	}
    	
	}); 
	//倒计时函数
	var secs = 60; //倒计时的秒数 
	var min =${assTime}-1;//分钟
	var m =${assTime};//分钟
    function timeShow(){
    	secs--
    	if(min==0&&secs==0){
    		$("label#timeShow").text("0分0秒");
    		submitTest();
    		return;
    	}
    	 $("label#timeShow").text(min+"分"+secs+"秒");
        if(secs==0){
        	min--;
        	secs=60;
        }
        setTimeout("timeShow()",1000);
    }
	
    function multiplechoiceQuestionShow(sec){
		var MultiplechoiceSize = "${MultiplechoiceSize}";
		var FactoidSize = "${FactoidSize}";
    	var DeeperSize="${DeeperSize}";
    	var OriginalSize="${OriginalSize}";
			$("#MultiplechoiceQuestion").show(sec);
			if(DeeperSize!='0'||OriginalSize!='0'||FactoidSize!='0'){
				$("#multiplechoiceNextId").show();
			}else{
				$("#submitAss").show();
			} 
	}
	function factoidQuestionShow(sec){
		var MultiplechoiceSize = "${MultiplechoiceSize}";
		var FactoidSize = "${FactoidSize}";
    	var DeeperSize="${DeeperSize}";
    	var OriginalSize="${OriginalSize}";
			$("#FactoidQuestion").show(sec);
			if(DeeperSize!='0'||OriginalSize!='0'){
				$("#factoidNextId").show();
			}else{
				$("#submitAss").show();
			} 
			//处理上一题按钮
			if(MultiplechoiceSize!='0'){
				$("#factoidLastId").show();
			}
	}
	function deeperQuestionShow(sec){
		var MultiplechoiceSize = "${MultiplechoiceSize}";
		var FactoidSize = "${FactoidSize}";
    	var DeeperSize="${DeeperSize}";
    	var OriginalSize="${OriginalSize}";
		$("#DeeperQuestion").show(sec);
		//处理下一题按钮
		if(OriginalSize!='0'||MultiplechoiceSize!='0'){
			$("#deeperNextId").show();
		}else{
			$("#submitAss").show();
		}
		//处理上一题按钮
		if(FactoidSize!='0'){
			$("#deeperLastId").show();
		}
	}
	function OriginalQuestionShow(sec){
		var MultiplechoiceSize = "${MultiplechoiceSize}";
		var FactoidSize = "${FactoidSize}";
    	var DeeperSize="${DeeperSize}";
    	var OriginalSize="${OriginalSize}";
		$("#OriginalQuestion").show(sec);
		$("#submitAss").show();
		//处理上一题按钮
		if(FactoidSize!='0'||DeeperSize!='0'||MultiplechoiceSize!='0'){
			$("#originalLastId").show();
		}
	}
	
	function multiplechoiceNext(){
    	if(!secondViewMultiplechoice){
    		multiplechoiceEndTime=new Date();
    	}
    	var FactoidSize="${FactoidSize}";
    	var DeeperSize="${DeeperSize}";
    	var OriginalSize="${OriginalSize}";
		$("#MultiplechoiceQuestion").hide(200);
    	$("#FactoidQuestion").hide();
		$("#DeeperQuestion").hide();
		$("#OriginalQuestion").hide();
		if(FactoidSize!='0'){
    		if(!secondViewMultiplechoice){//第一次计时 点击上一步后不计时
    			factoidStartTime=new Date();
    		}
    		factoidQuestionShow(200);
    	}else if(DeeperSize!='0'){
    		if(!secondViewFactoid){//第一次计时 点击上一步后不计时
    			deeperStartTime=new Date();
    		}
    		deeperQuestionShow(200);
    	}else if(OriginalSize!='0'){
    		if(!secondViewFactoid){//第一次计时 点击上一步后不计时
        		originalStartTime=new Date();
    		}
    		OriginalQuestionShow(200)
    	}
    }
	
    function factoidNext(){
    	if(!secondViewFactoid){
    		factoidEndTime=new Date();
    	}
    	var DeeperSize="${DeeperSize}";
    	var OriginalSize="${OriginalSize}";
		$("#MultiplechoiceQuestion").hide();
    	$("#FactoidQuestion").hide(200);
		$("#DeeperQuestion").hide();
		$("#OriginalQuestion").hide();
    	if(DeeperSize!='0'){
    		if(!secondViewFactoid){//第一次计时 点击上一步后不计时
    			deeperStartTime=new Date();
    		}
    		deeperQuestionShow(200);
    	}else if(OriginalSize!='0'){
    		if(!secondViewFactoid){//第一次计时 点击上一步后不计时
        		originalStartTime=new Date();
    		}
    		OriginalQuestionShow(200)
    	}
    }
    
    function deeperNext(){
    	if(!secondViewDeeper){
    		deeperEndTime=new Date();//只有第一次点击下一步时计时
    	}
    	var OriginalSize="${OriginalSize}";
		$("#MultiplechoiceQuestion").hide();
    	$("#FactoidQuestion").hide();
		$("#DeeperQuestion").hide(200);
		$("#OriginalQuestion").hide();
    	if(OriginalSize!='0'){
    		if(!secondViewDeeper){
        		originalStartTime=new Date();
    		}
    		OriginalQuestionShow(200);
    	}
    }
    
    function factoidLast(){
		$("#MultiplechoiceQuestion").hide();
    	$("#FactoidQuestion").hide(200);
		$("#DeeperQuestion").hide();
		$("#OriginalQuestion").hide();
    	var MultiplechoiceSize = "${MultiplechoiceSize}";
    	if(MultiplechoiceSize!='0'){
    		secondViewMultiplechoice = true;
    		multiplechoiceQuestionShow(200);
    	}
    }
    function deeperLast(){
		$("#MultiplechoiceQuestion").hide();
    	$("#FactoidQuestion").hide();
		$("#DeeperQuestion").hide(200);
		$("#OriginalQuestion").hide();
    	var FactoidSize = "${FactoidSize}";
    	if(FactoidSize!='0'){
    		secondViewFactoid = true;
    		factoidQuestionShow(200);
    	}
    }
	function originalLast(){
		$("#MultiplechoiceQuestion").hide();
		$("#FactoidQuestion").hide();
		$("#DeeperQuestion").hide();
		$("#OriginalQuestion").hide(200);
		var FactoidSize = "${FactoidSize}";
    	var DeeperSize="${DeeperSize}";
    	if(DeeperSize!='0'){
    		secondViewDeeper = true;
    		deeperQuestionShow(200);
    	}else if(FactoidSize!='0'){
    		secondViewFactoid = true;
    		factoidQuestionShow(200);
    	}
	}
    
	function submitTip(title,mesg){
		if(originalStartTime!=""){
			originalEndTime=new Date();
		}else if(deeperStartTime!=""){
			deeperEndTime = new Date();
		}else if(factoidStartTime !=""){
			factoidEndTime = new Date();
		}else if(multiplechoiceStartTime!=""){
			multiplechoiceEndTime=new Date();
		}
		$.messager.confirm(title, mesg, function(isSure) {
			if(isSure){
				var ma = document.getElementsByClassName("multiplechoiceAnswer");
				if(ma.length>0){
					for(var i = 0;i<ma.length;i++){
						var an = getRadioValue("mcanswers"+(i+1));
						var ans = document.getElementById("answers"+(i+1));
						ans.value=an;
					}
				}
				if(multiplechoiceStartTime!=""){
					$("#multiplechoiceStartTime").val(multiplechoiceStartTime.format("yyyy-MM-dd hh:mm:ss"));
					$("#multiplechoiceEndTime").val(multiplechoiceEndTime.format("yyyy-MM-dd hh:mm:ss"));
				}
				if(factoidStartTime!=""){
					$("#factoidStartTime").val(factoidStartTime.format("yyyy-MM-dd hh:mm:ss"));
					$("#factoidEndTime").val(factoidEndTime.format("yyyy-MM-dd hh:mm:ss"));
				}
				if(deeperStartTime!=""){
					$("#deeperStartTime").val(deeperStartTime.format("yyyy-MM-dd hh:mm:ss"));
					$("#deeperEndTime").val(deeperEndTime.format("yyyy-MM-dd hh:mm:ss"));
				}	
				if(originalStartTime!=""){
					$("#originalStartTime").val(originalStartTime.format("yyyy-MM-dd hh:mm:ss"));
					$("#originalEndTime").val(originalEndTime.format("yyyy-MM-dd hh:mm:ss"));
				}
				$("#useTime").val(m-min);
				  $("#submitbt").click();  
			}
		}); 
	}
	function getRadioValue(name){
		var radioes = document.getElementsByName(name);
		for(var i=0;i<radioes.length;i++)
		{
		if(radioes[i].checked){
		return radioes[i].value;
		}
		}
		return false;
	}
</script>
</head>
<body>
	<div class="div3">
		<font size="4">阅读<label>课文《${textTitle}》回答下列问题 </label>
		</font>
		<span style="float: right;"><font size="3">课程名：${courseName}</font>&nbsp;&nbsp;</span>
	</div>
	<br>
	<div style="width: 98%; padding-left: 20px">
		<font size="3"> <c:forEach var="sentence" items="${texts}">
				&nbsp;&nbsp;
				${sentence}<br>
			</c:forEach>
		</font>
	</div>
	<div class="div3">
		<font size="4"><label>问题（共${questionsize}小题）</label></font>
		<div style="float: right;"><font size="4" color="red">测试总时间：${assTime}分钟
		， 剩余时间<label id="timeShow"></label></font>&nbsp;&nbsp;&nbsp;&nbsp;</div>
	</div>
	<div class="div4" style="width: 98%">
		<form id="submitFormId" action="/question/answer/submitAnswer" method="post">
			<input type="hidden" name="assId" value="${assId}">
			<input type="hidden" id="useTime" name="useTime" value="${assTime}">
			
			<c:if test="${MultiplechoiceSize>0}">
				<table border="1" class="editTab" id="MultiplechoiceQuestion" align="center">
				<tr>
					<th colspan="3" align="left">选择题（共${FactoidSize}小题）</th>
				</tr>
				<tr>
					<th width="7%">题号</th>
					<th width="60%">问题</th>
					<th width="33%">答案</th>
				</tr>
					<c:set var="i" value="${0}"/>
					<c:forEach var="question" items="${MultiplechoiceQuestions}">
					<c:set var="i" value="${i+1}"/>
					<tr>
						<td align="center">问题 ${i}.</td>
						<td>${question.question}</td>
						<td class="multiplechoiceAnswer">
							
							<c:forEach var="distracter" items="${question.distracter}">
							<input type="radio" name="mcanswers${i}" value="${distracter.distracter}"/><label>${distracter.distracter}</label>
							</c:forEach>
							
						<input type="hidden" id="answers${i}" name="answers" value="">
						<input type="hidden" name="qids" value="${question.qId}">
						<input type="hidden" name="answerold" value="${question.answer}">
						</td>
					</tr>
				</c:forEach>
			<tr>
				<td colspan="3" align="center">
					<input type="button" id="multiplechoiceNextId" onclick="multiplechoiceNext()" class="btnPaleGreen" style="width: 100px" value="下一题">
				</td>
				</tr>
			</table>
			</c:if>
			
			<c:if test="${FactoidSize>0}">
				<table border="1" class="editTab" id="FactoidQuestion" align="center">
				<tr>
					<th colspan="3" align="left">事实类问题（共${FactoidSize}小题）</th>
				</tr>
				<tr>
					<th width="7%">题号</th>
					<th width="60%">问题</th>
					<th width="33%">答案</th>
				</tr>
					<c:set var="i" value="${0}"/>
					<c:forEach var="question" items="${FactoidQuestions}">
					<c:set var="i" value="${i+1}"/>
					<tr>
						<td align="center">问题 ${i}.</td>
						<td>${question.question}</td>
							<td><textarea  name="answers" class="easyui-validatebox" data-options="required:true" missingMessage="请输入答案"  style='width: 300px'></textarea>
							<input type="hidden" name="qids" value="${question.qId}">
							<input type="hidden" name="answerold" value="${question.answer}">
							</td>
					</tr>
				</c:forEach>
			<tr>
				<td colspan="3" align="center">
					<input type="button" id="factoidNextId" onclick="factoidNext()" class="btnPaleGreen" style="width: 100px" value="下一题">
					<input type="button" id="factoidLastId" onclick="factoidLast()" class="btnGray" style="width: 100px" value="上一题">
				</td>
				</tr>
			</table>
			</c:if>
			
			<c:if test="${DeeperSize>0}">
				<table border="1" class="editTab" id="DeeperQuestion" align="center">
				<tr>
					<th colspan="3" align="left">深层次问题（共${DeeperSize}小题）</th>
				</tr>
				<tr>
					<th width="7%">题号</th>
					<th width="60%">问题</th>
					<th width="33%">答案</th>
				</tr>
					<c:set var="i" value="${0}"/>
					<c:forEach var="question" items="${DeeperQuestions}">
					<c:set var="i" value="${i+1}"/>
					<tr>
						<td align="center">问题 ${i}.</td>
						<td>${question.question}</td>
							<td><textarea  name="answers" class="easyui-validatebox" data-options="required:true" missingMessage="请输入答案"  style='width: 300px'></textarea>
							<input type="hidden" name="qids" value="${question.qId}">
							<input type="hidden" name="answerold" value="${question.answer}">
							</td>
					</tr>
				</c:forEach>
			<tr>
				<td colspan="3" align="center">
					<input type="button" id="deeperNextId" onclick="deeperNext()" class="btnPaleGreen" style="width: 100px" value="下一题">
					<input type="button" id="deeperLastId" onclick="deeperLast()" class="btnGray" style="width: 100px" value="上一题">
				</td>
				</tr>
			</table>
			
			</c:if>
			<c:if test="${OriginalSize>0}">
				<table border="1" class="editTab" id="OriginalQuestion" align="center">
				<tr>
					<th colspan="3" align="left">原始问题（共${OriginalSize}小题）</th>
				</tr>
				<tr>
					<th width="7%">题号</th>
					<th width="60%">问题</th>
					<th width="33%">答案</th>
				</tr>
					<c:set var="i" value="${0}"/>
					<c:forEach var="question" items="${OriginalQuestions}">
					<c:set var="i" value="${i+1}"/>
					<tr>
						<td align="center">问题 ${i}.</td>
						<td>${question.question}</td>
							<td><textarea  name="answers" class="easyui-validatebox" data-options="required:true" missingMessage="请输入答案"  style='width: 300px'></textarea>
							<input type="hidden" name="qids" value="${question.qId}">
							<input type="hidden" name="answerold" value="${question.answer}">
							</td>
					</tr>
				</c:forEach>
			<tr>
				<td colspan="3" align="center">
					<input type="button" id="originalLastId" onclick="originalLast()" class="btnGray" style="width: 100px" value="上一题">
				</td>
				</tr>
			</table>
		</c:if>
		<input type="hidden" id="multiplechoiceStartTime" name="multiplechoiceStartTime" value="">
		<input type="hidden" id="multiplechoiceEndTime" name="multiplechoiceEndTime" value="">
		<input type="hidden" id="factoidStartTime" name="factoidStartTime" value="">
		<input type="hidden" id="factoidEndTime" name="factoidEndTime" value="">
		<input type="hidden" id="deeperStartTime" name="deeperStartTime" value="">
		<input type="hidden" id="deeperEndTime" name="deeperEndTime" value="">
		<input type="hidden" id="originalStartTime" name="originalStartTime" value="">
		<input type="hidden" id="originalEndTime" name="originalEndTime" value="">
			<p align="center">
				<input type="submit"  class="btn2"
				name="submit" id="submitbt" value="提交作业" style="display:none;">
				<input type="button" id="submitAss" onclick="return submitTip('确认','您确定提交作业吗？')" class="btnPaleGreen" style="width: 100px" value="提交作业">
				</p>
				<br><br>
		</form>
	</div>
	

</body>
</html>