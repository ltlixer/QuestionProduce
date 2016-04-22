/**
 * Created by mwq on 2015/3/28.
 */
var jsonstr="";//定义一个json的全局变量,保存问题结果
var jsonIndex =0;
// 原文章
var artical = '', title = '';
$('.produce').on('click', function() {
	var msg = {};
	msg[0] = "show";
	msg[1] = $('#text').val();
	analyze(msg);
})


// 参数msg[],msg[0]文本标题。msg[1]文本内容
function analyze(msg) {
	title = msg[0];
	var content = msg[1];
	// 有的文件里有标题（标题在文件第一行，标题完都会以回车换行。当然有的文件也没有标题，在回车之前会有标点符号）
	// 去除标题
	var index = 0;
	for (var i = 0; i < msg[1].length; i++) {
		if (msg[1][i] == "，" || msg[1][i] == "。" || msg[1][i] == ","
				|| msg[1][i] == ".") {
			break;
		}
		// 若有换行，但是没有遇到标点，说明是 标题
		if (msg[1][i] == '\r') {
			index = i;
			if (msg[1][i + 1] == '\n')
				index = i + 1;
			content = msg[1].substring(index);
			break;
		}
	}
	// 去除文章中有千分位分割的数字 的分隔符【1,333,666.7788】
	var reg = /(\d+),(\d\d\d)(\.\d+)?/g;
	while (1) {
		if (reg.test(content)) {
			content = content.replace(reg, '$1$2$3');
		} else {
			break;
		}
	}

	// 增加容错性，“又名” 词性解析错误，将之改为“又叫”
	content = content.replace('又名', '又叫');
	content = content.replace('又称', '又叫');
	content = content.replace('　　','');
    content = content.replace('　　','');

	// 把文件名（title）和文章内容（文本）一起提交到服务器。
	// 以便后续提取出第一句话作为标题
	var text = title + "。" + content;
	var base = "http://api.ltp-cloud.com/analysis/?", api_key = "n2T5b2L8XA0sMuSEJlQwZZqNxtDkdxJIEccA9Ree", element = $("#pattern"), pattern = 'all', format = "json";
	var artical = text
			|| removeBrace($('#text').val().replace(/(\s|\u00A0)+/g, ""))
					.toUpperCase();
	if (!artical) {
		return false;
	}
	var uri = (base + "api_key=" + api_key + "&text=" + artical + "&pattern="
			+ pattern + "&format=" + format + "&callback=" + "successCallBack");
	
	$.ajax({
		type : "POST",
		async : false,
		dataType : 'jsonp',
		timeout: 1000,    
		url : uri,
		success : successCallBack,
		error : function(err) {
			console.log(err);
		}
	});
	
	$('#originText').html('分析中，请耐心等候');
	$('#infor').html('分析中，请耐心等候');
	$('#inforvaluate').html('分析中，请耐心等候');
	$('#questions').html('');
}

// 请求成功的回调函数，
function successCallBack(d) {
	$('#originText').html('');
	$('.row:last').addClass('bgw');
	// 获取的数据data[[[{}]]],所以data[0][n]才是要用的数据
	var paragraph = d[0];
	var dataSets = [];
	// 提取第一句话作为标题
	var firstSentence = getSentenceContent(paragraph[0]);
	title = firstSentence.substring(0, firstSentence.length - 1);
	console.log('title:' + title);
	// 处理文本 下标从1开始，因为paragraph[0]是文章标题
	if (paragraph.length >= 1) {// 文本有内容
		if (title == "show") {// 在线演示代码
			for (var sentenceIndex = 1; sentenceIndex < paragraph.length; sentenceIndex++) {
				var sentence = paragraph[sentenceIndex];
				var p = document.createElement('p');
				p.className = "sentence";
				// 拼接分词后的字放回到#originText中
				var InitSentence = getSentenceContent(sentence);
				p.innerHTML = InitSentence;
				var questions;
				$('#originText').append(p);
				(function() {
					var s = sentence;
					p.onclick = function(e) {
						questions = generateQuestionBySentence(s);
						showQuestions(questions);
						$('p').removeClass('sentence-selected');
						e.target.className = "sentence sentence-selected"
					};
				})();
				$('.sentence')[0].click();
			}
		} else {// 传到后台的数据处理
			jsonstr="";
			jsonIndex =0;
			var sentenceid=0;//表示产生问题的句子的id
			$('#infor').html('请选择要发布的问题！点击【发布作业】进行作业布置');
			$('#inforvaluate').html('请对产生的问题进行评估');
			$('#loading').hide();
			var questionId =0;
			for (var sentenceIndex = 1; sentenceIndex < paragraph.length; sentenceIndex++) {
				var sentence = paragraph[sentenceIndex];
				var questions = generateQuestionBySentence(sentence);
				//数据评估使用
				 if(questions.length>0){
					 sentenceid++;
		                CreateData(title,sentenceid, sentence, questions);
		            }
				
				for(var qid = 0;qid<questions.length;qid++){
					questionId++;
					resultQuestionsFun(getSentenceContent(sentence),questions[qid].text,questions[qid].answer,questions[qid].label,questionId);
				}
			}
			
		}
	}
}
// srl: 语义角色标注; pos: 词性标注; last: 持续; mq: 数字;根据句子得到问题的集合
function generateQuestionBySentence(sentence) {
	var questions = [];
	if (filterSaidSentence(sentence)) {
		return questions;
	}
	// 【怎么样】 提问
	var howQuestions = howQuestionBySentence(sentence);
	for (var i = 0; i < howQuestions.length; i++) {
		questions = pushQuestion(questions, howQuestions[i]);
	}
	// 对原因进行提问--【为什么】
	var causeResultQuestions = causeResultQuestionBySentence(sentence);
	for (var i = 0; i < causeResultQuestions.length; i++) {
		questions = pushQuestion(questions, causeResultQuestions[i]);
	}
	// 分句简化
	var sentences = sentenceCompress(sentence);
	// 事实类问题提问
	for (var id = 0; id < sentences.length; id++) {
		var sentence = sentences[id];
		var srlQuestions = srlGenerateQuestionsBySentence(sentence);
		var posQuestions = posGenerateQuestionsBySentence(sentence);
		var lastQuestions = lastQuestionsBySentence(sentence);
		var mqQuestions = mqQuestion(sentence);
		for (var i = 0; i < srlQuestions.length; i++) {
			questions = pushQuestion(questions, srlQuestions[i]);
		}
		for (i = 0; i < posQuestions.length; i++) {
			questions = pushQuestion(questions, posQuestions[i]);
		}
		for (i = 0; i < lastQuestions.length; i++) {
			questions = pushQuestion(questions, lastQuestions[i]);
		}
		for (i = 0; i < mqQuestions.length; i++) {
			questions = pushQuestion(questions, mqQuestions[i]);
		}
	}
	var questionsnew =[];//保存问题长度大于5的数据
	for(var qlength=0;qlength<questions.length;qlength++){
		 var questionText = questions[qlength].text;
		 if(questionText.length>5){
			 questionsnew.push(questions[qlength]);
		 }
	}
	return questionsnew;
}

// 出现问题
function showQuestions(questions) {
	$('#questions').html('');
	if (questions.length == 0) {
		var alertDiv = $('<div></div>');
		alertDiv.addClass('alert');
		alertDiv.addClass('alert-warning');
		alertDiv.html('抱歉，该句不能产生问题');
		$('#questions').append(alertDiv);
	}
	for (var i = 0; i < questions.length; i++) {
		var question = questions[i];
		var p = document.createElement('p');
		p.innerHTML = question.text;
		var label = document.createElement('span');
		label.innerHTML = question.label;
		label.className = "label label-info";
		p.appendChild(label);
		/*var label = document.createElement('span');
		label.innerHTML = question.answer;
		label.className = "label label-info";
		p.appendChild(label);*/
		$("#questions").append(p);
	}
}

//处理每篇文章问题集合
function resultQuestionsFun(sentence,question,answer,label,id){
		/*var value = sentence+"##"+question+"##"+answer+"##"+label;*/
		var factoid = $("#factoidShowQuestion");
		var deeper = $("#deeperShowQuestion");
		if(outLabel(label)>=9){//深层次问题
			var deeperhtml="<tr>" +
			"<td align=center><input type='checkbox' class='questionNum' name='ck2' value='"+id+"'></td>" +
			"<td id='sentence"+id+"'>"+sentence+"</td>" +
			"<td><textarea rows='2' cols='60' class='question' name='"+id+"'>"+question+"</textarea></td>" +
			"<td><textarea rows='2' cols='16' class='answer' name='"+id+"' >" +answer+"</textarea></td>" +
			"<td id='label"+id+"'>"+label+"</td>" +
			"</tr>";
		}else{//事实类问题
			var factoidhtml="<tr>" +
			"<td align=center><input type='checkbox' class='questionNum' name='ck1' value='"+id+"'></td>" +
			"<td id='sentence"+id+"'>"+sentence+"</td>" +
			"<td><textarea rows='2' cols='60' class='question' name='"+id+"'>"+question+"</textarea></td>" +
			"<td><textarea rows='2' cols='16' class='answer' name='"+id+"' >" +answer+"</textarea></td>" +
			"<td id='label"+id+"'>"+label+"</td>" +
			"</tr>";
		}
		
		factoid.append(factoidhtml);
		deeper.append(deeperhtml);
}


//评估数据
function CreateData(title,sentenceid, sentence, questions) { //数据评估参数
    var pos = 0;
    for (var i = 0; i < sentence.length; i++) {
        if (sentence[i].pos == 'wp')  pos++;
    }
   /* var shortSentences = sentenceSlimplifer(sentence);
    var compressSentences = sentenceCompress(sentence);*/
   
    //1:句子长度 2:短句数 3:是否提取 4:问句类型 5:是否包含否定词
    for (var questionIndex = 0; questionIndex < questions.length; questionIndex++) {
        var questionText = questions[questionIndex].text;
        var title = title;
        var sentenceid = sentenceid;
        var sentecestr = getSentenceContent(sentence);
        var quest = questionText;
        var answer = questions[questionIndex].answer;
        var Feature1 = questionText.length;
        var Feature2 = pos;
        var Feature3 = Number(isNew);
        var Feature4 = outLabel(questions[questionIndex].label);
        var Feature5 = denyword(sentence);
        var showQuestion = $("#showEvaluate");
        if(sentenceid==1&&questionIndex==0){
        	jsonstr +="[{'title':'" + title + "','sentenceid':'" + sentenceid+ "','sentecestr':'" + sentecestr+ "','quest':'" + quest
				 + "','answer':'" + answer+ "','Feature1':'" + Feature1+"','Feature2':'" + Feature2+"','Feature3':'" + Feature3
				 +"','Feature4':'" + Feature4+"','Feature5':'" + Feature5+"','tOrF':'','desc':''}";
        }else{
        	jsonstr +=",{'title':'" + title + "','sentenceid':'" + sentenceid+ "','sentecestr':'" + sentecestr+ "','quest':'" + quest
			 + "','answer':'" + answer+ "','Feature1':'" + Feature1+"','Feature2':'" + Feature2+"','Feature3':'" + Feature3
			 +"','Feature4':'" + Feature4+"','Feature5':'" + Feature5+"','tOrF':'','desc':''}";
        }
        jsonIndex++;
      
        var html="<tr>" +
        "<td align=center>"+jsonIndex+"</td>" +
		"<td>"+sentecestr+"</td>" +
		"<td>"+quest+"</td>" +
		"<td><input name='evaluate"+jsonIndex+"' type='radio' checked='checked' value='1' />正确  " +
		"<input  name='evaluate"+jsonIndex+"'  type='radio' value='0' />错误</td>" +
		"<td><textarea rows='2' cols='10'  name='desc"+jsonIndex+"' ></textarea></td>" +
		"</tr>";
		/*var html="<tr>" +
				"<td style='display: none'>"+title+"</td>" +
				"<td style='display: none'>"+sentenceid+"</td>" +
				"<td>"+sentecestr+"</td>" +
				"<td>"+quest+"</td>" +
				"<td><input  name='"+questionIndex+"' type='radio'  value='T' />正确  " +
				"<input  name='"+questionIndex+"'  type='radio' value='F' />错误</td>" +
				"<td style='display: none'>" +answer+"</td>" +
				"<td style='display: none'>"+Feature1+"</td>" +
				"<td style='display: none'>"+Feature2+"</td>" +
				"<td style='display: none'>"+Feature3+"</td>" +
				"<td style='display: none'>"+Feature4+"</td>" +
				"<td style='display: none'>"+Feature5+"</td>" +
				"</tr>";*/
		showQuestion.append(html);
        
        
       /* //分句处理
        var shortSentence = '';
        for (var i = 0; i < shortSentences.length; i++) {
            shortSentence += '#' + (i + 1) + '. ' + getSentenceContent(shortSentences[i]) + ' ';
        }
        item.shortSentences = shortSentence;
        //简化处理
        var compressSentence = '';
        for (var i = 0; i < compressSentences.length; i++) {
            compressSentence += '#' + (i + 1) + '. ' + getSentenceContent(compressSentences[i]) + ' ';
        }
        item.compressSentences = compressSentence;*/
    }
   
}



// 读取cdv文件并生成问题
/*
 * $('#csvRead').on('change', function (event) { event.preventDefault(); file =
 * event.target.files[0];
 * 
 * Papa.parse(file, { complete: function (results) { var data = results.data,
 * text = ''; for (var i = 0, _l = data.length - 1; i < _l; i++) { var item =
 * data[i]; for (var j = 0, l = item.length; j < l; j++) { //text += item[j];
 * //每篇文章都走一遍analyze analyze(item[j]); } }
 * 
 * //console.log(text); } });
 * 
 * });
 */

/**
 * 片段句子是否包含说得话
 * 
 * @param sentence
 * @returns {boolean}
 */
function filterSaidSentence(sentence) {
	var str = getSentenceContent(sentence);
	var before = -1;
	before = str.indexOf("：“");
	if (before > -1) {
		return true;
	} else {
		return false;
	}
}
