/**
 * 根据语义依存关系对原因结果句提问
 */
function causeResultQuestionBySentence(sentence) {
   var questions = [];
    var newQuestions = [];
    if (sentence[sentence.length - 1].cont == "？" || sentence[sentence.length - 1].cont == "?") {
        return questions;
    }
    newQuestions = questionByeResu(sentence);
    for (var index = 0; index < newQuestions.length; index++) {
        questions = pushQuestion(questions, newQuestions[index]);
    }
    newQuestions = questionByeCau(sentence);
    for (var index = 0; index < newQuestions.length; index++) {
        questions = pushQuestion(questions, newQuestions[index]);
    }
    newQuestions = questionByReas(sentence);
    for (var index = 0; index < newQuestions.length; index++) {
        questions = pushQuestion(questions, newQuestions[index]);
    }
    newQuestions = questionByeSupp(sentence);
    for (var index = 0; index < newQuestions.length; index++) {
        questions = pushQuestion(questions, newQuestions[index]);
    }
    return questions;
}

/**
 * 对结果句进行提问：
 *
 * @param sentence
 * @returns {Array}
 */
function  questionByeResu(sentence){
    var newQuestions = [];
    var startIndex = 0;//eResult 句型 问句的开始位置
    var endIndex = 0;//eResult 句型 问句的结束位置
    for (var wordIndex = 0; wordIndex < sentence.length; wordIndex++) {
        var word = sentence[wordIndex];
        var question = "";
        //结果关系（eResu）
        //找到 【结果关系成分】
        if (word.semrelate == "eResu") {
            //增加容错性，去除一些不是原因结果句，但LTP当做原因结果句的常见例子
            //如 XXX报道，XXX称，XXX表示，XXX报告/报道,XXX透露,XXX调查所知，
            var str = sentence[word.semparent].cont;
            var nextStr = sentence[word.semparent + 1].cont;
            if ((str == "报道" || str == "称" || str == "表示" || str == "报告" || str == "透露" ||
                str == "宣布" || str == "知") && (nextStr == "，" || nextStr == ",")) {
                continue;
            }
            //寻找开始断句的符号的下标
            startIndex = startPunctuateWpIndex(sentence, word);
            //【原因成分】与【结果成分】间有逗号分隔 可以产生问题
            if (startIndex != -1) {
                if (sentence[startIndex + 1].pos == "c") {
                    startIndex = startIndex + 2;
                } else {
                    startIndex = startIndex + 1;
                }
                endIndex = endPunctuateWpIndex(sentence, word, startIndex);
                question = "为什么";
                //主语
                var A0 = findA0ByResult(sentence, word, startIndex);
                if (A0.length > 0) {//主语和该结果分句不相连，找到主语
                    for (var A0Index = 0; A0Index < A0.length; A0Index++) {
                        if (A0[A0Index] != "　　")//去除全角空格
                            question += A0[A0Index];
                    }
                }
                //句干
                for (var i = startIndex; i < endIndex; i++) {
                    question += sentence[i].cont;
                }
                //句尾
                //若最后一个标点不是 句号 分号 应该加入
                if (sentence[sentence.length - 1].cont == "”" || sentence[sentence.length - 1].cont == "’") {
                    question += sentence[sentence.length - 1].cont;
                }
                question += "呢？";

                //答案
                var abeg = 0;
                var aend =  startIndex-1;
                for(var answerId = word.semparent; answerId>=0;answerId--){
                    if(sentence[answerId].cont==","||sentence[answerId].cont=="，"){
                        abeg=answerId+1;
                        break;
                    }
                }
                var answer = "";
                for(var aid = abeg;aid<aend;aid++){
                    answer+=sentence[aid].cont;
                }

                var newquestion = {
                    label: "原因结果",
                    text: question,
                    answer:answer
                };
                newQuestions[newQuestions.length] = newquestion;
            }
        }
    }
    return  newQuestions;
}
/**
 * 原因在后的句子进行 提问
 * @param sentence
 * @returns {Array}
 */
function questionByeCau(sentence){
    var newQuestions = [];
    var wpIndex = 0;//eCau 句型的 问句结束位置
    for (var wordIndex = 0; wordIndex < sentence.length; wordIndex++) {
        var word = sentence[wordIndex];
        var question = "";
        //规则，使用最接近 eCau分句的标点作为问句的结束位置
        if (word.pos == "wp") {
            wpIndex = word.id;
        }
        //原因关系(eCau)
        //找到【原因】成分，反推结果成分
        if (word.semrelate == "eCau") {
            if (wpIndex > 0 && wpIndex < word.id && word.semparent < wpIndex) {
                question = "为什么";
                for (var i = 0; i < wpIndex; i++) {
                    question += sentence[i].cont;
                }
                question += "呢？";

                //答案
                var abeg = wpIndex+1;
                var aend = sentence.length;
                 var answer = "";
                for(var aid = abeg;aid<aend;aid++){
                    answer+=sentence[aid].cont;
                }
                var newquestion = {
                    label: "原因结果",
                    text: question,
                    answer:answer
                };
                newQuestions[newQuestions.length] = newquestion;
            }
        }
    }
return newQuestions;
}
/**
 * 对缘故角色的句子进行提问
 * @param sentence
 * @returns {Array}
 */
function questionByReas(sentence){
    var newQuestions = [];
    var wpIndex = 0;//eCau 句型的 问句结束位置
    for (var wordIndex = 0; wordIndex < sentence.length; wordIndex++) {
        var word = sentence[wordIndex];
        var question = "";
        //缘故角色（Reas）
        if (word.semrelate == "Reas") {
            var semparentId = word.semparent;
            var isFindA0 = false;//是否找到主语
            var isFindA1 = false;//是否找到宾语
            var A0 = [];
            var A1 = [];

            //搜索问句的开始位置
            //规则：若 Reas 词汇到 reas的semparent间有标点符号，选择标点符号的后一位作为问句的开始位置
            //若无标点符号，选择一个前后不关联的位置断开，当前词汇的parent（或parent的parent....）==semparentId,若断开位置是连词，后退一个
            //若不存在上述情况，选择semparentId 为问句的开始位置
            var startIndexReas = 0;
            for (var reasId = word.id; reasId <= semparentId; reasId++) {
                if (sentence[reasId].pos == "wp") {
                    startIndexReas = reasId + 1;
                    break;
                }
            }
            if (startIndexReas == 0) {
                for (var reasId = word.id + 1; reasId < semparentId; reasId++) {
                    if (sentence[reasId].parent == semparentId) {
                        startIndexReas = reasId;
                        if (sentence[reasId].pos == "c")
                            startIndexReas++;
                        break;
                    } else {
                        var parentId = sentence[sentence[reasId].parent].parent;
                        while (1) {
                            if (parentId <= word.id || parentId > semparentId) {
                                break;
                            }
                            if (parentId == semparentId) {
                                startIndexReas = reasId;
                                if (sentence[reasId].pos == "c")
                                    startIndexReas++;
                                break;
                            } else {
                                parentId = sentence[parentId].parent;
                            }
                        }
                        break;
                    }
                }
            }
            if (startIndexReas == 0) {
                startIndexReas = semparentId;
            }
            // console.log(sentence[startIndexReas].cont);
            //搜索问句的结束位置
            //规则：搜索中心词（Reas 的semparent）后最近的一个逗号或句号）
            var endIndexReas = 0;
            for (var reasId = semparentId; reasId < sentence.length; reasId++) {
                if (sentence[reasId].cont == "，" || sentence[reasId].cont == "," || sentence[reasId].cont == "。") {
                    endIndexReas = reasId;
                    break;
                }
            }

            //找主语和宾语。
            for (var arg = 0; arg < sentence[semparentId].arg.length; arg++) {
                var argNode = sentence[semparentId].arg[arg];
                if (argNode.type == 'A0') {
                    A0 = [];
                    isFindA0 = true;
                    var begA0 = argNode.beg;
                    var endA0 = argNode.end;
                    var iA0 = 0;
                    if ((endA0 < startIndexReas || begA0 > endIndexReas)) {
                        for (var indexA0 = begA0; indexA0 <= endA0; indexA0++) {
                            A0[iA0] = sentence[indexA0].cont;
                            iA0++;
                        }
                    }
                    //主语是rease,或者包含rease在内,该主语无效
                    if (endA0 >= word.id && begA0 <= word.id) {
                        isFindA0 = false;
                        A0 = [];
                    }
                }
                if (argNode.type == 'A1') {
                    A1 = [];
                    isFindA1 = true;
                    var begA1 = argNode.beg;
                    var endA1 = argNode.end;
                    var iA1 = 0;
                    if (endA1 > startIndexReas && endA1 < endIndexReas) {
                        endIndexReas = endA1 + 1;
                    }

                    if (endA1 < startIndexReas || begA1 > endIndexReas) {
                        for (var indexA1 = begA1; indexA1 <= endA1; indexA1++) {
                            A1[iA1] = sentence[indexA1].cont;
                            iA1++;
                        }
                    }
                    //宾语是rease,或者包含rease在内,该宾语语无效
                    if (endA1 >= word.id && begA1 <= word.id) {
                        isFindA1 = false;
                        A1 = [];
                    }
                }
            }

            //有A0或者有A1 并且reas的semparent和reas 不是动宾关系
            if ((isFindA0 || isFindA1) && !(sentence[semparentId].relate == "VOB" && sentence[semparentId].parent == word.id)) {
                question = "";
                //时间状语
                var tmp = searchArgTMP(sentence, semparentId, startIndexReas, endIndexReas);
                if (tmp != "") {
                    question += tmp;
                }
                var loc = searchArgLOC(sentence, semparentId, startIndexReas, endIndexReas);
                if (loc != "") {
                    question += loc;
                }

                if (A0.length > 0) {
                    for (var A0Index = 0; A0Index < A0.length; A0Index++) {
                        question += A0[A0Index];
                    }
                }
                question += "为什么";
                for (var i = startIndexReas; i < endIndexReas; i++) {
                    question += sentence[i].cont;
                }
                if (A1.length > 0) {
                    for (var A1Index = 0; A1Index < A1.length; A1Index++) {
                        question += A1[A1Index];
                    }
                }
                question += "呢？";
                //答案
                var answer="";
                var abeg =0;
                var aend = word.id;
                for(var aid = word.id;aid>=0;aid--){
                    if(sentence[aid].parent== word.id){
                        abeg=aid;
                    }else{
                        break;
                    }
                }
                for(aid = abeg;aid<=aend;aid++){
                    answer+= sentence[aid].cont;
                }
                var newquestion = {
                    label: "原因结果",
                    text: question,
                    answer:answer
                };
                newQuestions[newQuestions.length] = newquestion;
            }

        }
    }
return newQuestions;
}
/**
 * 对 假设局进行提问（eSupp）
 * 规则：
 * 搜索word.semrelate == "eSupp"的词。中心词word.semparent
 * 搜索假设 词到中心词间的最后一个 逗号为问句的开始位置，若开始位置有副词 连词，开始位置后移
 * 搜索和中心词不相连的主语。
 * 搜索结束位置。查看中心词是否有宾语，若有，怎将宾语（宾语在中心词后）后的第一个标点作为宾语的结束位置；若无则将句子结尾作为结束位置
 *
 * @param sentence
 * @returns {Array}
 */
function questionByeSupp(sentence){
    var newQuestions = [];
    var startIndex = 0;//esupp 句型的 问句开始位置
    var endIndex = 0;//esupp 句型的 问句开始位置
    for (var wordIndex = 0; wordIndex < sentence.length; wordIndex++) {
        var word = sentence[wordIndex];
        var question = "";
        //原因关系(eCau)
        //找到【原因】成分，反推结果成分
        if (word.semrelate == "eSupp") {
            for(var startId = word.id;startId<word.semparent;startId++){
                //寻找 假设 词 到 结果词间的逗号作为问句的开始符号
                if(sentence[startId].cont==","||sentence[startId].cont=="，"){
                    startIndex = startId+1;
                }
            }

            if(startIndex>0){

                if(sentence[startIndex].pos=="c"||sentence[startIndex].pos=="d"){
                    startIndex++;
                }
                //搜索主语
                var A0 = [];
                if(searchArgA0(sentence, word.semparent).length==0
                    &&(sentence[startIndex]!="n"||sentence[startIndex]!="r")){
                    A0 = searchArgA0(sentence, word.id);
                }
                question = "为什么";
                for(var i=0;i<A0.length;i++){
                    question += A0[i];
                }
                //找中心语的宾语
                var A1=[];
                var index =word.semparent;
                var begA1 = 0;
                var endA1 = 0;
                for (var arg = 0; arg < sentence[index].arg.length; arg++) {
                    var argNode = sentence[index].arg[arg];
                    if (argNode.type == 'A1') {
                        begA1 = argNode.beg;
                         endA1 = argNode.end;
                        var iA1 = 0;
                        for (var indexA1 = begA1; indexA1 <= endA1; indexA1++) {
                            A1[iA1] = sentence[indexA1].cont;
                            iA1++;
                        }
                        break;
                    }
                }
                if(A1.length>0&&begA1>word.semparent){
                    for(var wpEnd=endA1;wpEnd<sentence.length;wpEnd++){
                        if(sentence[wpEnd].pos=="wp"){
                            endIndex = wpEnd;
                            break;
                        }
                    }
                }else{
                    endIndex = sentence.length-1;
                }
                for(var qid=startIndex;qid<endIndex;qid++){
                    question += sentence[qid].cont;
                }
                question += "呢？";
                var answer = "";
                for(var aid = 0;aid<startIndex;aid++){
                    answer+=sentence[aid].cont;
                }
                var newquestion = {
                    label: "原因结果",
                    text: question,
                    answer:answer
                };
                newQuestions[newQuestions.length] = newquestion;
            }
        }
    }
    return newQuestions;
}





//查找 问句的开始下标
/**
 * 规则：统计 word的semparent 下标到 word 间的逗号分隔符，
 *       若无逗号则返回-1，表示该不对该句提问；
 *       若有一个逗号，则将该逗号的下标返回；
 *       若有多个逗号，将从第一个逗号开始检索分割前后语义的逗号==
 *                 分割前后语义的逗号的检索规则：逗号后面的词语 的parent 都和逗号前面的句子无联系。
 *                 {逗号后面词语的parent不小于逗号所在的位置}

 *                 若第一逗号后是一个有词短语并且短语后紧跟逗号，选择下一个逗号
 *
 * @param sentence
 * @param word  表示 word.semrelate == "eResu"
 * @returns {*}
 * @constructor
 */
function startPunctuateWpIndex(sentence, word) {
    var wpIndex = [];//保存逗号的下标
    var wpCount = 0;//逗号的个数统计
    var semparentId = word.semparent;
    var eResultId = word.id;
    for (var i = semparentId + 1; i < eResultId; i++) {
        if (sentence[i].cont == "，" || sentence[i].cont == ",") {
            wpIndex[wpCount] = i;
            wpCount++;
        }
    }
    //无逗号 返回-1
    if (wpCount == 0) {
        return -1;
    } else if (wpCount == 1) {//有一个逗号将该逗号的下标返回
        return wpIndex[0];
    } else {//有多个逗号 需要进行分析判断，选择哪个逗号进行分句
        var isCurrentWp = false;
        for (var j = 0; j < wpCount - 1; j++) {//从第一个逗号开始遍历到最后一个的前一个
            isCurrentWp = true;//默认是当前的逗号
            // 若第一逗号后是一个有词短语并且短语后紧跟逗号，选择下一个逗号.如 原因，副词，
            if (sentence[wpIndex[j] + 1].pos == "d" && (sentence[wpIndex[j] + 2].cont == "，" || sentence[wpIndex[j] + 2].cont == ",")) {
                isCurrentWp = false;
                continue;
            }
            for (var index = wpIndex[j] + 1; index < wpIndex[j + 1]; index++) {
                if (sentence[index].parent < wpIndex[j]) {//逗号后面的词语 的parent 都和逗号前面的句子有联系,则该逗号不成立
                    isCurrentWp = false;
                    break;
                }
            }
            if (isCurrentWp) {
                return wpIndex[j];
                break;
            }
        }
        //循环完还未找到 说明是最后一个标点
        if (!isCurrentWp) {
            return wpIndex[wpCount - 1];
        }
    }
}


/**
 * 搜索当前问句的结束位置
 * 规则：若结果词（word.semrelate == "eResu"）word 的后面还有 word2的semparent 等于 word的id的情况（连续结果类）
 *              或者 当前word的子COO
 *              我们选择两个词汇间的逗号（若有多个逗号，选择分割前后语义的逗号为分割符）作为前一个问题的结束。
 *                  分割前后语义的逗号的检索规则：逗号后面的词语 的parent 都和逗号前面的句子无联系。
 *                   {逗号后面词语的parent不小于逗号所在的位置}
 *       若无，选择转折词，总结出前的逗号为结束位置，
 *       若无， 结束位置选择句末作为问题的结束位置。
 * @param sentence
 * @param word  word.semrelate == "eResu"
 * @returns {number}  返回id 作为问句的结束位置
 */
function endPunctuateWpIndex(sentence, word) {
    var wpIndex = [];//保存逗号的下标
    var wpCount = 0;//逗号的个数统计
    //搜索word 的子节点，并且semrelate == "eResu"的词汇  同时记录之间的逗号情况
    for (var i = word.id + 1; i < sentence.length - 1; i++) {
        if (sentence[i].cont == "，" || sentence[i].cont == ",") {
            wpIndex[wpCount] = i;
            wpCount++;
        }
        if ((sentence[i].semrelate == "eResu" && sentence[i].semparent == word.id) || (sentence[i].semrelate == "eResu" && sentence[i].relate == "COO")) {
            //判断逗号的个数，若有多个逗号，需要选择分割前后语义的逗号，若有一个 返回该逗号的位置，若无返回句子的末尾为结束位置
            if (wpCount == 1) {
                return wpIndex[0];
            } else {//有多个逗号 需要进行分析判断，选择哪个逗号进行分句
                var isCurrentWp = false;
                for (var j = 0; j < wpCount - 1; j++) {//从第一个逗号开始遍历到最后一个的前一个
                    isCurrentWp = true;//默认是当前的逗号
                    for (var index = wpIndex[j] + 1; index < wpIndex[j + 1]; index++) {
                        if (sentence[index].parent < wpIndex[j]) {//逗号后面的词语 的parent 都和逗号前面的句子有联系,则该逗号不成立
                            isCurrentWp = false;
                            break;
                        }
                    }
                    if (isCurrentWp) {
                        return wpIndex[j];
                        break;
                    }
                }
                //循环完还未找到 说明是最后一个标点
                if (!isCurrentWp && wpCount != 0) {
                    return wpIndex[wpCount - 1];
                }
            }
        }
    }
    //若不存在两个连续的 eResu,并且有多个逗号，我们选择 总结词，转折词前的逗号为结束位置
    //如  XXX，但XXX    XXXX，其中XXX  XXXX,这XXX
    if (wpCount > 0) {
        for (var j = 0; j <= wpCount - 1; j++) {//从第一个逗号开始遍历到最后一个
            if (sentence[wpIndex[j] + 1].cont == "这" || sentence[wpIndex[j] + 1].cont == "但"
                || sentence[wpIndex[j] + 1].cont == "但是" || sentence[wpIndex[j] + 1].cont == "其中") {
                return wpIndex[j];
            }
        }
    }
    return sentence.length - 1;
}


/**
 * 搜索  【原因，结果】句型中 结果部分的主语
 * 规则：1，首先查找结果分句是否有自己的主语，若存在 并且主语在问句开始位置之前，返回主语；若存在 并且主语在问句开始位置之后，则不返回主语。产生问题时，直接使用自己的主语成分。若没找到，下一步
 *       2，当结果分句中没有自己的主语， 就在原因分句中找主语{word.semparent 知道的下标处搜索}。若找到返回主语，若无，下一步
 *       3，若原因分句中无主语，就在原因分句相关联的前面的句子中搜索。{sentence[semparentId].relate == "COO"
 *                       lastCooId = sentence[semparentId].parent }直到找到 head 为止。若找到 返回主语；
 *          若当 到达head都还没主语，说明原句不存在主语，使用【它】替代
 * @param sentence
 * @param word
 * @param startIndex
 * @returns {Array}
 */
function findA0ByResult(sentence, word, startIndex) {
    var A0 = [];//结果分句有自己的主语并且主语在问句开始位置之后，则不返回主语内容；
    // 结果分句有自己的主语并且主语在问句开始位置之前，返回主语；
    // 若无，查找关联的主语，找不到用“它”替代
    var resultWordId = word.id;
    var isA0Join = false;//主语是否在结果部分
    //搜搜主语是否在结果分句中
    for (var arg = 0; arg < word.arg.length; arg++) {
        var argNode = word.arg[arg];
        if (argNode.type == 'A0') {//有自己的主语
            isA0Join = true;//表示主语与结果分句相连
            var begA0 = argNode.beg;
            var endA0 = argNode.end;
            if (endA0 < startIndex) {//如果主语在 问句的开始标记之前，提取主语，否则主语不提取
                var iA0 = 0;
                for (var indexA0 = begA0; indexA0 <= endA0; indexA0++) {
                    A0[iA0] = sentence[indexA0].cont;
                    iA0++;
                }
            }
            return A0;
        }
    }

    //若该分句开头为【名词】不再找主语
    if (sentence[startIndex].pos == "n") {
        isA0Join = true;//不需要主语
        return A0;
    }


    //若主语和结果分句不相连，搜索主语
    if (!isA0Join) {
        var semparentId = word.semparent;
        var isFindA0 = false;//是否找到主语
        var isFindA0InCause = false;//是否在原因分句中找到主语
        var begA0;
        var endA0;
        //主语因为xxxx,所以XXXXX。
        //在原因分句中搜索主语
        A0 = searchArgA0(sentence, semparentId);
        if (A0.length > 0) {
            isFindA0 = true;//找到主语
            isFindA0InCause = true;//在原因分句中找到主语
        }

        //在原因分句的前面关联句中找主语
        if (!isFindA0InCause) {
            //如果在原因分句中也未找到主语，则看这个原因分句核心词是否是coo,若是，寻找coo的主语
            //如：主语xxxx,coo,因为cooXXXXX,所以XXXX
            if (sentence[semparentId].relate == "COO") {
                var lastCooId = sentence[semparentId].parent;
                while (1) {
                    //寻找最近一个COO的主语 直到找到Head结点
                    if (sentence[lastCooId].parent == -1) {
                        A0 = searchArgA0(sentence, lastCooId);
                        if (A0.length > 0) {
                            isFindA0 = true;//找到主语
                        }
                        break;
                    } else if (sentence[lastCooId].relate == "COO") {
                        A0 = searchArgA0(sentence, lastCooId);
                        if (A0.length > 0) {
                            isFindA0 = true;//找到主语
                            break;
                        } else {
                            lastCooId = sentence[lastCooId].parent;
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        /* //若找不到主语，使用“它”替代
         if (!isFindA0) {
         A0[0] = "它";
         }*/
    }
    return A0;
}

/**
 * 在sentence 中 指定 index的id中的arg里搜索A0
 * @param sentence
 * @param index
 * @returns {Array}
 */
function searchArgA0(sentence, index) {
    var A0 = [];
    for (var arg = 0; arg < sentence[index].arg.length; arg++) {
        var argNode = sentence[index].arg[arg];
        if (argNode.type == 'A0') {
            var begA0 = argNode.beg;
            var endA0 = argNode.end;
            var iA0 = 0;
            for (var indexA0 = begA0; indexA0 <= endA0; indexA0++) {
                A0[iA0] = sentence[indexA0].cont;
                iA0++;
            }
            break;
        }
    }
    return A0;
}


/**
 *
 * @param sentence
 * @param index
 * @param startId
 * @param endId
 * @returns
 */
function searchArgTMP(sentence, index, startId, endId) {
    var TMP = "";
    for (var arg = 0; arg < sentence[index].arg.length; arg++) {
        var argNode = sentence[index].arg[arg];
        if (argNode.type == 'TMP') {
            var begTMP = argNode.beg;
            var endTMP = argNode.end;
            if (endTMP < startId || begTMP > endId) {
                for (var indexTMP = begTMP; indexTMP <= endTMP; indexTMP++) {
                    TMP += sentence[indexTMP].cont;
                }
                if (sentence[endTMP].pos != "wp") {
                    TMP += "，";
                }
            }
            break;
        }
    }
    return TMP;
}
/**
 * 在sentence 中 指定 index的id中的arg里搜索 地点状语
 * @param sentence
 * @param index
 * @param startId
 * @param endId
 * @returns {Array}
 */
function searchArgLOC(sentence, index, startId, endId) {
    var LOC = "";
    for (var arg = 0; arg < sentence[index].arg.length; arg++) {
        var argNode = sentence[index].arg[arg];
        if (argNode.type == 'LOC') {
            var begLOC = argNode.beg;
            var endLOC = argNode.end;

            if (endLOC < startId || begLOC > endId) {
                for (var indexLOC = begLOC; indexLOC <= endLOC; indexLOC++) {
                    LOC += sentence[indexLOC].cont;
                }
                if (sentence[endLOC].pos != "wp") {
                    LOC += "，";
                }
            }
            break;
        }
    }
    return LOC;
}


