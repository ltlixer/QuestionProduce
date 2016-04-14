/**
 * 从服务器获取textId文章的选择题
 * 
 */
function pasteQuestion(){
	var textId = $("#textId").val();
	 $.ajax({
         type: "get",
         dataType: "json",
         url: "/question/question/getMultipleChoiceQuestion/"+textId,
         success: function (msg) {
             var str = "";
             for (i in msg) {
            	 var value = msg[i].question+"##"+msg[i].key;
                 str += "<tr>" +
				"<td align=center><input type='checkbox' class='questionNum' name='multiplechoice' value='"+i+"'></td>" +
				"<td id='sentence"+i+"'>"+msg[i].sentence+"</td><td id='question"+i+"'>"+msg[i].question+"</td>"+"<td style='text-align:center;'>";
                 for(j in msg[i].distracter)
                	 str += " <input type='text' name='multiplechoice"+i+"' maxlength='1' size='1' style='text-align:center;' value='"+msg[i].distracter[j].distracter+"'>";
				 str += "</td>"+"<td id='answer"+i+"'>"+msg[i].answer+"</td>" +
				"</tr>";
             }
             $("#multiplechoiceShowQuestion").append(str);
         }
     });
}