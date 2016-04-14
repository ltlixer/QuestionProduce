

function howQuestionBySentence(sentence) {

    /*var questions = [];
    var newQuestions = [];
   var allsentence = sentenceSlimplifer(sentence);
    for (var sentenceId = 0; sentenceId < allsentence.length; sentenceId++) {
        sentence = allsentence[sentenceId];
        for (var wordIndex = 0; wordIndex < sentence.length; wordIndex++) {
            var question = "";
            var word = sentence[wordIndex];
            if (word.semrelate == "eAdvt") {
                question = getSentenceContent(sentence) + "eAdvt:【" + word.cont + "】 " + word.relate+" "+word.pos;

                var newquestion = {
                    label: "怎么样",
                    text: question
                };
                newQuestions[newQuestions.length] = newquestion;

            }
        }
    }

     for (var index = 0; index < newQuestions.length; index++) {
     questions = pushQuestion(questions, newQuestions[index]);
     }
     return questions;*/


    var questions = [];
    if (sentence[sentence.length - 1].cont == "？" || sentence[sentence.length - 1].cont == "?") {
        return questions;
    }
    //条件句 复合句
    var newQuestions =[];
    newQuestions = questionHowByeCond(sentence);
    for (var index = 0; index < newQuestions.length; index++) {
        questions = pushQuestion(questions, newQuestions[index]);
    }
    //简单句
    var allsentence = sentenceSlimplifer(sentence);
    for (var sentenceId = 0; sentenceId < allsentence.length; sentenceId++) {
        var newQuestions =[];
        sentence = allsentence[sentenceId];
        //怎么样作定语
         newQuestions = questionHowByFeatATT(sentence);
        for (var index = 0; index < newQuestions.length; index++) {
            questions = pushQuestion(questions, newQuestions[index]);
        }

        // 怎么样 做状语
        newQuestions = questionHowByMannADV(sentence);
        for (var index = 0; index < newQuestions.length; index++) {
            questions = pushQuestion(questions, newQuestions[index]);
        }
        //怎么样作宾语，补语
         newQuestions = questionHowByFeatVOB_CMP(sentence);
        for (var index = 0; index < newQuestions.length; index++) {
            questions = pushQuestion(questions, newQuestions[index]);
        }

    }

    return questions;
}

//怎么样作宾语 补语的情况
/**
 * 规则： 搜索（word.semrelate == "Feat"）的描写词，该词的semparent为被修饰的词：如红色的花。红色（Feat）<--花
 *
 * @param sentence
 * @returns {Array}
 */
function  questionHowByFeatVOB_CMP(sentence){

    var newQuestions = [];
    for (var wordIndex = 0; wordIndex < sentence.length; wordIndex++) {
        var word = sentence[wordIndex];
        var question = "";
        var startHow = 0;//怎么样开始位置
        var endHow = 0;//怎么样结束位置
        if (word.semrelate == "Feat"&&word.semparent<word.id) {
            //如：硬币落下后哪一面朝上本来是偶然的。是-->偶然
            if(word.relate == "VOB"&&word.pos=="a"&&word.parent==word.semparent){//是动宾关系 并且是形容词
                startHow = wordIndex;
                endHow = wordIndex+1;
                for(var before =wordIndex-1;before>0;before-- ){
                    //修饰 宾语 的状语 不保留
                    //如：显得格外漂亮。。很 格外去除
                    if(sentence[before].relate=="ADV"&&sentence[before].parent==word.id){
                        startHow = before;
                    }else{
                        break;
                    }
                }

                if(startHow<endHow){
                    question="";
                    for(var qid = 0;qid<startHow;qid++){
                        if(qid==0&&sentence[qid].pos=="c"){
                            continue;
                        }
                        question +=sentence[qid].cont;
                    }
                    question +="怎么样";
                    for(var qid = endHow;qid<sentence.length;qid++){
                        question +=sentence[qid].cont;
                    }
                    var answer ="";
                    for(var aid=startHow;aid<endHow;aid++){
                        answer+=sentence[aid].cont;
                    }
                    var newquestion = {
                        label: "怎样",
                        text: question,
                        answer:answer
                    };
                    newQuestions[newQuestions.length] = newquestion;
                }
            }
            if(word.relate == "CMP"&&word.pos!="v"&&word.parent==word.semparent){//动补关系
                startHow = wordIndex;
                endHow = wordIndex+1;
                var isAddu = false;
                for(var after =wordIndex+1;after<sentence.length;after++ ){
                    //如：我国的音乐、舞蹈、绘画、雕刻，变得更加丰富多彩、美轮美奂。
                    //补语成分是并列的多个
                    if(sentence[after].cont=="、"&&after+2<sentence.length&&sentence[after+1].relate=="COO"&&sentence[after+1].parent==word.id){
                        endHow = after+2;
                    }else{
                        break;
                    }
                }
                for(var before =wordIndex-1;before>0;before-- ){
                    //修饰 补语 的状语 不保留
                    //如：他普通话说得很好。很 要去除
                    if(sentence[before].relate=="ADV"&&sentence[before].parent==word.id){
                        startHow = before;
                        //动词后 无 得  添加一个【得】
                    }else if(sentence[before].id==word.semparent&&sentence[before].pos=="v"){
                       if(sentence[before].pos!="u"){
                           isAddu = true;
                       }
                    }else{
                        break;
                    }
                }

                if(startHow<endHow){
                    question="";
                    for(var qid = 0;qid<startHow;qid++){
                        if(qid==0&&sentence[qid].pos=="c"){
                            continue;
                        }
                        question +=sentence[qid].cont;
                    }
                    if(isAddu){
                        question +="得";
                    }
                    question +="怎么样";
                    for(var qid = endHow;qid<sentence.length;qid++){
                        question +=sentence[qid].cont;
                    }
                    var answer ="";
                    for(var aid=startHow;aid<endHow;aid++){
                        answer+=sentence[aid].cont;
                    }
                    var newquestion = {
                        label: "怎样",
                        text: question,
                        answer:answer
                    };
                    newQuestions[newQuestions.length] = newquestion;
                }
            }
        }

    }
    return  newQuestions;
}

//怎么样作状语的情况
/**
 *规则：搜索方式角色的词（word.semrelate == "Mann"），并且word.relate == "ADV"的词作为状语 使用怎么替换
 *   中心词为 word.semparent
 *
 * 当所搜索的状语前还有一状语（word.relate == "ADV"）修饰中心词的词，该修饰词语之前的状语合并，一起被替换
 * 判断状语后是否有 地（pos == "u"），若有不被替换，若无，添加
 *
 * @param sentence
 * @returns {Array}
 */
function questionHowByMannADV(sentence){
    var newQuestions = [];
    for (var wordIndex = 0; wordIndex < sentence.length; wordIndex++) {
        var word = sentence[wordIndex];
        var question = "";
        var startHow = 0;//怎么样开始位置
        var endHow = 0;//怎么样结束位置
        //作状语
        if (word.semrelate == "Mann"&&word.relate == "ADV") {
            if(word.semparent>word.id){
                startHow = wordIndex;

                for(var before=wordIndex-1;before>0; before--){
                    if(sentence[before].relate == "ADV"){
                        if(sentence[before].parent==word.semparent||sentence[before].parent==word.id){
                            startHow = before;
                        }
                    }else{
                        break;
                    }

                }
                for(var index =wordIndex+1;index<sentence.length;index++) {
                    if(sentence[index].pos == "u"){
                        endHow = index+1;
                    }/*else{
                        endHow = index;
                    }*/
                    if(sentence[index].id==word.semparent){
                        endHow = index;
                        break;
                        /*if(sentence[index-1].pos == "u"){
                            endHow = index-1;
                        }else{
                            endHow = index;
                        }*/
                   }
                }
                if(startHow<endHow){
                    for(var qid = 0;qid<startHow;qid++){
                        if(qid==0&&sentence[qid].pos=="c"){
                            continue;
                        }
                        question +=sentence[qid].cont;
                    }
                    question +="怎样";
                    for(var qid = endHow;qid<sentence.length;qid++){
                        if(sentence[qid].cont==":"||sentence[qid].cont=="："){
                            question +="。";
                            break;
                        }
                        question +=sentence[qid].cont;
                    }
                    var answer ="";
                    if(sentence[endHow-1].cont=="地"){
                        endHow--;
                    }
                    for(var aid=startHow;aid<endHow;aid++){
                        answer+=sentence[aid].cont;
                    }
                    answer+="地";

                    var newquestion = {
                        label: "怎样",
                        text: question,
                        answer:answer
                    };
                    newQuestions[newQuestions.length] = newquestion;
                }
            }

        }
    }
    return  newQuestions;
}
//怎么样作定语的情况
/**
 * 规则： 搜索（word.semrelate == "Feat"）的描写词，该词的semparent为被修饰的词：如红色的花。红色（Feat）<--花
 *        寻找 Feat后 的pos为u的词，若找到可以产生问题。修饰词替换为 怎么样。若修饰词前有副词修饰，或者修饰词后有semparent词的ATT
 *        这些修饰词一起替换为 怎么样
 * @param sentence
 * @returns {Array}
 */
function  questionHowByFeatATT(sentence){
    var newQuestions = [];
    for (var wordIndex = 0; wordIndex < sentence.length; wordIndex++) {
        var word = sentence[wordIndex];
        var question = "";
        var startHow = 0;//怎么样开始位置
        var endHow = 0;//怎么样结束位置
        //作定语
        if (word.semrelate == "Feat"&&word.relate == "ATT"&&(word.pos == "a"||word.pos == "i"||word.pos == "n")) {
            //XXXX(Feat)XXX的（u）XXX 情况
            if(word.semparent>word.id){
                //搜索怎么样的位置
                for(var index =wordIndex+1;index<sentence.length;index++) {
                    startHow = 0;
                    endHow = 0;
                    if (sentence[index].pos == "u") {
                        //如： 红色的爪子
                    	if(index+1<sentence.length){
	                        if (sentence[index + 1].id == word.parent) {
	                            startHow = wordIndex;
	                            endHow = index;
	                            break;
	                        } else {
	                            //如：红色的小爪子
	                            for (var after = index + 1; after < sentence.length; after++) {
	                                if (sentence[after].relate == "ATT" && sentence[after].parent == word.parent&&after<word.semparent) {
	                                    startHow = wordIndex;
	                                    endHow = after+1;
	                                    //最高的一届
	                                    if(sentence[after].pos=="m"){
	                                        endHow = after;
	                                    }
	                                }else{
	                                    break;
	                                }
	                            }
	                            break;
	                        }	
                    	}

                    }
                }
                if(startHow<endHow){
                    //定语前有状语修饰，应将状语也覆盖
                    for (var reIndex = wordIndex - 1; reIndex >= 0; reIndex--) {
                        if (sentence[reIndex].relate == "ADV"&& sentence[reIndex].parent == word.id) {
                            startHow = reIndex;
                        } else {
                            break;
                        }
                    }

                    for(var qid = 0;qid<startHow;qid++){
                        if(qid==0&&sentence[qid].pos=="c"){
                            continue;
                        }
                        question +=sentence[qid].cont;
                    }
                    question +="什么样";
                    if(sentence[endHow].pos!="u")
                        question +="的";
                    for(var qid = endHow;qid<sentence.length;qid++){
                        question +=sentence[qid].cont;
                    }
                    var answer ="";
                    for(var aid=startHow;aid<endHow;aid++){
                        answer+=sentence[aid].cont;
                    }
                    answer+="的";
                    var newquestion = {
                        label: "什么样",
                        text: question,
                        answer:answer
                    };
                    newQuestions[newQuestions.length] = newquestion;
                }
            }

        }
    }
    return  newQuestions;
}
/**
 * 条件句
 * @param sentence
 * @returns {Array}
 */
function questionHowByeCond(sentence){
    //符合句中的“怎么样”==条件句(eCond)
    var newQuestions =[];
    for(var index=0;index<sentence.length;index++){
        var word = sentence[index];
        if (word.semrelate == "eCond") {
            var question="";
            var startIndex =0;
            for(var wpId=word.semparent;wpId>word.id;wpId--){
                if(sentence[wpId].cont==","||sentence[wpId].cont=="，"){
                    startIndex=wpId+1;
                    break;
                }
            }
            //搜索答案开始位置
            var abeg = 0;
            var aend =  startIndex-1;
            for(var answerId = word.id; answerId>=0;answerId--){
                if(sentence[answerId].cont==","||sentence[answerId].cont=="，"){
                    abeg=answerId+1;
                    break;
                }
            }
            if(startIndex>0){
                question="怎么样";
                var isQuestion = true;
                if(sentence[startIndex].cont=="只要"||sentence[startIndex].cont=="除非"){
                    isQuestion = false;//不产生问题
                }
                if(sentence[startIndex].pos=="c"){
                    startIndex++;
                }
                if(sentence[startIndex].cont=="只要"||sentence[startIndex].cont=="除非"){
                    isQuestion = false;//不产生问题
                }
                for(var qid=startIndex;qid<sentence.length;qid++){
                    question+=sentence[qid].cont;
                }
                var answer = "";
                for(var aid = abeg;aid<aend;aid++){
                    answer+=sentence[aid].cont;
                }

                var newquestion = {
                    label: "怎样",
                    text: question,
                    answer:answer
                };
                if(isQuestion)
                    newQuestions[newQuestions.length] = newquestion;
            }

        }
    }
    return newQuestions;
}