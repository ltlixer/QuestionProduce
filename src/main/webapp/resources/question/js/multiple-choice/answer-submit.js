function submitQuestion(){
	var assId = $("input#assId").attr("value");
	var useTime = $("input#useTime").attr("value");
	var jsonstr1 = "[{'assId':'" + assId + "','useTime':'" + useTime + "'}]";
	var questionNum = document.getElementsByName("questionNum");
	var jsonstr2 = "[";
	for(var i =0;i<questionNum.length;i++){
		var qtype = $("input#qtype"+questionNum[i].value).attr("value");
		var qid = $("input#qids"+questionNum[i].value).attr("value");
		var answerold = $("input#answerold"+questionNum[i].value).attr("value");
		var answer = null;
		if(qtype=="multiplechoice"){
			var answerRa = $("input[name='mcanswers"+questionNum[i].value+"']");
			for(var j=0;j<answerRa.length;j++){
				if(answerRa[j].checked){
					answer=answerRa[j].value;
					break;
				}
			}
		}else{
			answer = $("textarea#answers"+questionNum[i].value).val();
			console.log(answer);
		}
		if(i==0){
			jsonstr2 += "{'qid':'" + qid + "','answerold':'"+answerold+"','answers':'"+answer+"'}";
		}else{
			jsonstr2 += ",{'qid':'" + qid + "','answerold':'"+answerold+"','answers':'"+answer+"'}";
		}
	}
	jsonstr2 += "]";
	$.messager.confirm('确认', '您确定提交作业吗？', function(isSure) {
		if(isSure){
			$("#useTime").val(m-min);
			var json = {};
			json.content = eval("(" + jsonstr2 + ")");//转换为json对象 
			json.ass = eval("(" + jsonstr1 + ")");
			var post = {
				data : JSON.stringify(json)
			};//JSON.stringify(json)把json转化成字符串
			var url = "/question/answer/submitAnswer1";
			$.post(url, post, function(data) {
				//return "redirect:";fail
				if (data == "success") {
					location.href = "/question/assignment/stulinkqueryAssignment";
				} else {
					$.messager.alert('消息反馈', '本次提交作业失败！');
				}
			});
		}
	}); 
}