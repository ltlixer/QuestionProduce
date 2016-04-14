/**
 * 语义角色标注（srl）问题
 */



function srlGenerateQuestionsBySentence(sentence) {
    var questions = [];
    for (var wordIndex = 0; wordIndex < sentence.length; wordIndex++) {
        var word = sentence[wordIndex];
        var newQuestions = srlGenrateQuestionsByWord(sentence, word);
        for (var qi = 0; qi < newQuestions.length; qi++) {
            questions = pushQuestion(questions, newQuestions[qi]);
        }
    }
    return questions;
}

function srlGenrateQuestionsByWord(sentence, word) {
    var questions = [];
    if (word.arg.length != 0) {
        //先查找是否有component.type=='A0'||'A1'的词，如果有，将这个词赋值给A0|A1
        /*for(var componentIndex = 0; componentIndex<word.arg.length; componentIndex++){
         var component = word.arg[componentIndex];
         if (component.type=='A0') {
         A0 = component;
         };
         if (component.type=='A1') {
         A1 = component;
         };
         }*/
        for (var componentIndex = 0; componentIndex < word.arg.length; componentIndex++) {
            var component = word.arg[componentIndex];
            var newQuestion = srlGenrateQuestionByComponent(sentence, component);
            if (newQuestion && newQuestion.text)
                questions = pushQuestion(questions, newQuestion);
        }
    }
    return questions;
}

//component是当前词的arg
function srlGenrateQuestionByComponent(sentence, component) {
    var ruleFactory = function (srl, label, rpc) {
        return {
            srl: srl,
            label: label,
            replacement: rpc
        };
    };
    var rules = [
        ruleFactory('LOC', '地点状语', '在哪里'),
        ruleFactory('TMP', '时间状语', '什么时候'),
        ruleFactory('A0', '动作施事类', '什么')

    ];
    for (var i = 0; i < rules.length; i++) {
        var rule = rules[i];
        if (component.type == rule.srl) {
            var replacement = rule.replacement;
            var text = null;
            var answer=null;
            if (component.type == 'TMP') {        
                replacement = getTMPReplacement(sentence, component);
                if (!replacement) {
                    return false;
                }
                if(component.beg<sentence[0].id|| component.end>sentence[sentence.length-1].id)
                    return false;
                answer=getComponentStr(sentence,component);
                if(answer==null||answer==""){
                	return false;
                }
                text = componentReplace(sentence, component, replacement);
            }
            if (component.type == 'A0') {
                var beg_id;
                var befor_id;
                for (var index = 0; index < sentence.length; index++) {
                    if (sentence[index].id == component.beg) {
                        beg_id = index;
                    }
                    if (sentence[index].id == component.end) {
                        var currendpos = sentence[index].pos;
                        befor_id = index - 1;
                        if (/(nz)$/.test(currendpos)) {
                            replacement = '什么';
                            component = sentence[index];
                            answer=component.cont;
                            text = componentReplaceU(sentence, component, replacement);
                        }
                        else{
                            if (/r/.test(currendpos)) {
                            replacement = getReplacement(sentence, component);
                               if (!replacement)
                                 return false;
                                 answer=getComponentStr(sentence,component);
                                text = componentReplace(sentence, component, replacement);
                              }
                           else{
                              if (/n/.test(currendpos)) {
                                      if (befor_id > -1 && /(n|nd)$/.test(sentence[befor_id].pos)) {
                                         component = sentence[befor_id + 1];
                                         answer=component.cont;
                                         replacement = '什么';
                                         text = componentReplaceU(sentence, component, replacement);
                                       }
                                       else{
                                       component = sentence[befor_id + 1];
                                       for (var j = beg_id+1; j <= befor_id + 1; j++) {

                                        if ((sentence[j].cont== '的')&& (/n/.test(sentence[--j].pos))) {

                                             replacement = '什么';

                                             component = sentence[j];
                                             answer=component.cont;
                                             text = componentReplaceU(sentence, component, replacement);
                                             break;
                                         }
                                        else return false;
                                        //text = componentReplaceU(sentence, component, replacement);
                                       }
                                      // text = componentReplaceU(sentence, component, replacement);
                                   }
                                   
                             }
                             else return false;
                              }
                        
                            }
                    }
                }
            }
            if(component.type=='LOC'){
             if(component.beg<sentence[1].id || component.end>sentence[sentence.length-1].id) return false; 
               answer=getComponentStr(sentence,component);
               if(answer==null||answer==""){
               	return false;
               }
                text = componentReplace(sentence, component, replacement);
            }
            var reg =/(,|，)$/g;
           if(reg.test( answer)) {
               answer = answer.substr(0,answer.length-1);
           }
            var question = {
                label: rule.label,
                text: text,
                answer:answer
            };
            return question;
        }
    }
}


//得到component对应的词
function getComponentStr(sentence, component) {
    var str = "";
    for (var i = 0; i < sentence.length; i++) {
        if (sentence[i].id == component.beg)
            var beg_id = i;
        if (sentence[i].id == component.end)
            var end_id = i;
    }

    for (var i = beg_id; i <= end_id; i++) {
        str += sentence[i].cont;
    }
    return str;
}

function getReplacement(sentence, component) {
    var componentStr = getComponentStr(sentence, component);
    if (componentStr.indexOf('这') > -1 || componentStr.indexOf('那') > -1 ) {
        return false;
    }
    else
        return '谁';
}


function componentReplaceU(sentence, component, replacement) {
    var str = "";
    for (var i = 0; i < sentence.length; i++) {
        var word = sentence[i];
        if (word.id < component.id || word.id > component.id) {
            str+=word.cont;
        }
        if (word.id == component.id) {
            str += replacement;
        }
    }

    return str;

}

function componentReplace(sentence, component, replacement) {
    var str = "";
    if (component.beg == 0) {
        str += replacement;
        for (var i = component.end + 1; i < sentence.length; i++) {
            str += sentence[i].cont;
        }
        return str;
    }
      for (var i = 0; i < sentence.length; i++) {
        var word = sentence[i];
        if (word.id < component.beg || word.id > component.end) {
            str += word.cont;
        }
        if (word.id == component.beg ) {
            str += replacement;
        }

     }
      return str;
}

//得到对时间提问的疑问词
function getTMPReplacement(sentence, component) {
    var componentStr = getComponentStr(sentence, component);
    if (componentStr.indexOf('日') > 0) {
        return '哪一天';
    }
    if (componentStr.indexOf('月') > 0) {
        return '几月份';
    }
    if (componentStr.indexOf('年') > 0) {
        return '哪一年';
    }
    if (componentStr.indexOf('世纪') > 0) {
        return '几世纪';
    }
    else
        return '什么时候';
}

//得到去掉component后的句子
function removeComponent(sentence, component) {
    var sent = [];
    for (var i = 0; i < sentence.length; i++) {
        var word = sentence[i];
        if (i < component.beg || i > component.end) {
            sent.push(word);
        }
    }
    return sent;
}
