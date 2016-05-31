function selectedAss(assId){
	document.getElementById("canvas1").innerHTML="";
	document.getElementById("canvas2").innerHTML="";
	document.getElementById("canvas3").innerHTML="";
	showQuestionTable(assId);
	paintPie(assId);
	paintBar(assId);
	paintLine(assId);
	showChart();
}
/**
 * 显示图
 */
function showChart(){
	var myTab = document.getElementById("myTab");
	var myTabContent = document.getElementById("myTabContent");
	myTab.style.display="block";
	myTabContent.style.display="block";
}
/**
 * 显示问题列表
 */
function showQuestionTable(assId){
	var questionTable = document.getElementById("questionTable");
	questionTable.innerHTML="";
	var url = "/question/question/getQuestionsByAssId/"+assId;
	$.ajax({
         type: "get",
         dataType: "json",
         url: url,
         success: function (msg) {
        	var str = "<table class='table table-hover' style='width:95%;margin:0 auto;'><tr>";
    		str += "<th>题号</th>";
    		str += "<th>题干</th>";
    		str += "<th>参考答案</th><tr>";
        	for (i in msg) {
        		str += "<tr><td>"+msg[i].qId+"</td><td>"+msg[i].question
        			+"</td><td>"+msg[i].answer+"</td></tr>";
        	}
        	str += "</table>";
        	questionTable.innerHTML=str;
         }
     });
}
/**
 * 显示饼图形式的 学生成绩分布图
 * @param assId
 */
function paintPie(assId){
	var url = "/question/scoreAssignment/queryScoreAssignment/"+assId;
	//优、良、中、及格、不及格 各个等级的人数
	var level1=0,level2=0,level3=0,level4=0,level5=0;
	$.ajax({
         type: "get",
         dataType: "json",
         url: url,
         success: function (msg) {
        	 for (i in msg) {
        		 if(msg[i].score>=90){
        			 level1++;
        		 }else if(msg[i].score>=80 && msg[i].score<90){
        			 level2++;
        		 }else if(msg[i].score>=70 && msg[i].score<80){
        			 level3++;
        		 }else if(msg[i].score>=80 && msg[i].score<70){
        			 level4++;
        		 }else{
        			 level5++;
        		 }
        	 }
        	 var config = {
 			    type: 'pie',
 			    data: {
 			        labels: ["优", "良", "中", "及格", "不及格"],
 			        datasets: [{
 		                data: [level1,level2,level3,level4,level5],
 		                backgroundColor: ["#F7464A","#46BFBD","#FDB45C","#949FB1","#4D5360"],
 		            }]
 			    },
 			    options: {
 			        responsive: true,
 			        title:{
 			            display:true,
 			            text:'学生成绩分布图'
 			        }
 			    }
 			};
     		var ctx1 = document.getElementById("canvas1").getContext("2d");
     	    window.myLine1 = new Chart(ctx1, config);
         }
     });
}
/**
 * 显示该作业中的每个作业的正确率
 * @param assId
 */
function paintBar(assId){
	var url = "/question/scoreAssignment/queryStuAnswerCorrectRate/"+assId;
	var questionId = new Array();
	var rate = new Array();
	$.ajax({
         type: "get",
         dataType: "json",
         url: url,
         success: function (msg) {
        	 for (i in msg) {
        		 questionId[i] = msg[i].asswerId;
        		 rate[i] = parseInt(msg[i].similarity);
        	 }
        	 var config = {
 			    type: 'bar',
 			    data: {
 			        labels: questionId,
 			        datasets: [{
 			        	label:"正确率(%)",
 			        	backgroundColor: "rgba(91, 129, 205, 0.75)",
 		                data: rate,
 		                lineTension: 0,
 		                fill: false
 		            }]
 			    },
 			    options: {
 			        responsive: true,
 			        title:{
 			            display:true,
 			            text:'问题正确率分布图'
 			        }
 			    }
 			};
     		var ctx2 = document.getElementById("canvas2").getContext("2d");
     		window.myLine2 = new Chart(ctx2, config);
         }
     });
}
/**
 * 显示学生作业耗时 折线图
 * @param assId
 */
function paintLine(assId){
	var url = "/question/scoreAssignment/queryStuTime/"+assId;
	var stu = new Array();
	var time = new Array();
	$.ajax({
         type: "get",
         dataType: "json",
         url: url,
         success: function (msg) {
        	 for (i in msg) {
        		 stu[i] = msg[i].user;
        		 time[i] = msg[i].useTime/1000;
        	 }
        	 var config = {
 			    type: 'bar',
 			    data: {
 			        labels: stu,
 			        datasets: [{
 			        	label:"用时(秒)",
 			        	backgroundColor: "rgba(120, 217, 51 ,0.5)",
 		                data: time,
 		                lineTension: 0,
 		                fill: false
 		            }]
 			    },
 			    options: {
 			        responsive: true,
 			        title:{
 			            display:true,
 			            text:'作业时间图'
 			        }
 			    }
 			};
     		var ctx3 = document.getElementById("canvas3").getContext("2d");
     	    window.myLine3 = new Chart(ctx3, config);
         }
     });
}