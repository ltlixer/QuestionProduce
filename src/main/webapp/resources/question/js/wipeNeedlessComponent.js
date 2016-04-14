/**
 * 精简句子成分:复合句分成简单句
 */

function denyword(sentence) {
    var isDeny = 0;
    sentence = filterQuestionMark(sentence);
    for (var wordIndex = 0; wordIndex < sentence.length; wordIndex++) {
        var word = sentence[wordIndex];
        if (word.cont == '不' || word.cont == '否' || word.cont == '非' || word.cont == '没')
            isDeny = 1;
    }
    return isDeny;
}
function sentenceSlimplifer(sentence) {
    var allsentence = new Array();
    var i = 0;
    var j = 0;  // allsentence[i][j];表示分句
    var isNew = false;//是否分句
    var iscoo = false;//是否为coo句
    var wordCurrentIndex = -1;//记录分句当前的位置
    var A0 = new Array();
    A0 = [];
    //处理疑问句，若是疑问句，我们将不分句,直接返回
    if (sentence[sentence.length - 1].cont == "？" || sentence[sentence.length - 1].cont == "?") {
        allsentence[0] = new Array();
        allsentence[0] = sentence;
        return allsentence;
    }
    for (var wordIndex = 0; wordIndex < sentence.length; wordIndex++) {
        var word = sentence[wordIndex];
        isNew = false;

        //连续两个是coo的，后一个不再是COO
        //1.直接相连
        //2.除有 顿号、 并列词隔开的两个coo   【HEAD/COO】【、/连词】【 COO】
        //3.coo 中间有修饰成分的相连
        if (isCoo(word, sentence)) {
            isNew = true;
            //寻找上一个coo
            var lastcooId =-1;
            for(var a=wordIndex-1;a>=0;a--){
                if(isCoo(sentence[a], sentence) || sentence[a].relate == 'HED'){
                    lastcooId=a;
                    break;
                }
            }
            var id = wordIndex - 1;
            if (id > 0) {
                while (1) {
                    if (isCoo(sentence[id], sentence) || sentence[id].relate == 'HED') {
                        isNew = false;
                        break;
                    }
                    //顿号 或者连词
                    if ((sentence[id].cont == '、'||sentence[id].pos == 'c')) {
                        id--;
                        //修饰词 定语 状语
                    }else if ((sentence[id].relate == 'ADV'||sentence[id].relate == 'ATT')&&sentence[id].parent==wordIndex){
                        id--;
                    }else {
                        //修饰 直接修饰coo的词的修饰语
                        if(sentence[id].parent!=-1&&((sentence[sentence[id].parent].relate == 'ATT'||sentence[sentence[id].parent].relate == 'ADV')&&sentence[sentence[id].parent].parent==wordIndex)){
                            id--;
                            //前一个coo的修饰词 动宾短语 如：登【楼】远眺
                        }else if(lastcooId!=-1&&sentence[id].relate == 'VOB'&&sentence[id].parent==lastcooId){
                            id--;
                        }else{
                            break;
                        }
                    }
                    if(id<0){
                        break;
                    }
                }
            }

        }
        //处理分句
        // 处理coo的句子.找到coo时，进入代码段。保存coo前一个分句
        if (isNew) {
            iscoo = true;
            var start_index = wordCurrentIndex + 1;
            var end_index = 0;
            //搜索分句的结束位置
            for (var index = 0; index < wordIndex; index++) {
                if (sentence[index].parent == wordIndex) {
                    end_index = index;
                    break;
                } else {
                    end_index = wordIndex;
                }
            }
            allsentence[i] = new Array();
            j = 0;
            //插入主语
            if (A0.length > 0) {
                for (var k = 0; k < A0.length; k++) {
                    allsentence[i][j] = A0[k];
                    j++;
                }
            }

            //插入主语后的词语
            for (var k = start_index; k < end_index; k++) {
                wordCurrentIndex++;
                if (wordCurrentIndex == sentence.length - 1) {
                    allsentence[i][j] = sentence[wordCurrentIndex];
                    break;
                } else if (sentence[wordCurrentIndex].pos == 'wp' && (isPunctuateWp(sentence, wordCurrentIndex, wordIndex))) {
                    allsentence[i][j] = sentence[wordCurrentIndex];
                    break;
                } else {
                    allsentence[i][j] = sentence[wordCurrentIndex];
                }
                j++;

            }
            i++;
            //完成coo前一个分句后，查找当前coo分句的主语。为下一个分句做准备
            A0 = searchA0(sentence, word);
        }
    }
    //处理coo 的最后一个分句
    if (iscoo) {
        allsentence[i] = new Array();
        j = 0;
        //插入最后一个分句的主语
        if (A0.length > 0) {
            for (var k = 0; k < A0.length; k++) {
                allsentence[i][j] = A0[k];
                j++;
            }
        }
        //插入主语后的词语
        for (var k = wordCurrentIndex + 1; k < sentence.length; k++) {
            allsentence[i][j] = sentence[k];
            j++;
        }
    } else {//处理没有coo的句子
        allsentence[0] = new Array();
        allsentence[0] = sentence;
    }
    return allsentence;
}
//判断是否是coo
function isCoo(word, sentence) {
    //word.pos!="m"不是数字word.pos!="q"不是单位
    if (word.relate == 'COO' && word.pos != "m" && word.pos != "q") {
        /*if(word.pos=="q"){
         var text = word.cont;
         if(text=='′'||text=='°'||text=='"'||text=='\''){
         return false;
         }//排除 度分秒
         }*/
        var parentId = word.parent;//word的parent id
        while (1) {
            //核心词汇出发的coo 并且 词性相同
            if ((sentence[parentId].relate == 'HED')&&(sentence[parentId].pos==word.pos)) {
                return true;
            }
            //特殊词性v p  也为coo
            if (sentence[parentId].relate == 'HED') {
                if((word.pos=='v'&&sentence[parentId].pos=='p')||(word.pos=='p'&&sentence[parentId].pos=='v'))
                    return true;

            }
            if (sentence[parentId].relate == 'COO') {
                parentId = sentence[parentId].parent;
                if (parentId == -1) {
                    return false;
                }
            } else {
                return false;
            }
        }

    } else {
        return false;
    }
}
//搜索分句不相连的主语/若主语和分句不在一起，也就是共享前一个分句的主语则返回主语
function searchA0(sentence, word) {
    var isGetA0 = false;//是否找到主语
    var A0Start;//主语开始位置
    var A0End;//主语结束位置
    var A0 = new Array(); //主语
    var jet = false;//主语是否和该分句相连

    //搜索该分句的主语是否和该分句相连。若相连不返回主语
    for (var varg = 0; varg < word.arg.length; varg++) {
        jet = false;
        var javasc = word.arg[varg];
        if (javasc.type == 'A0') {
            jet = true;
            //找到了coo句子的主语了。
            var star = javasc.beg;
            var end = javasc.end;
            var parentIndex = word.parent;
            //说明主语不和该分句相连
            if (parentIndex > star && parentIndex > end) {
                jet = false;
                A0Start = star;
                A0End = end;
            }
            //分句主语  是【与***】结构
            if(sentence[star].cont=='与'||sentence[star].cont=='和'){
                jet = false;//虽然找到分句的主语，但还是应该将主句的主语加进来
            }
            break;
        }
    }
    //主语和分句相连
    if (jet) {
        A0 = [];
        return A0;
    }
    //该分句不存在主句，应将前找到他的主语（前面分句的主语）
    var xd = word.parent;
    do {
        var cooParent = sentence[xd];
        for (var cj = 0; cj < cooParent.arg.length; cj++) {
            var com = cooParent.arg[cj];
            if (com.type == 'A0') {
                isGetA0 = true;
                A0Start = com.beg;//还是记录在我们的str1和str2中
                A0End = com.end;
                break;
            }
        }
       if(isGetA0){
           break;
       }
        xd = cooParent.parent;//这样就一定能找到我们要的数据
        if (xd == -1) {
            break;
        }
    } while (1);

    //找到主语
    if (isGetA0) {
        var index = 0;
        for (var k = A0Start; k <= A0End; k++) {
            A0[index] = sentence[k];
            index++;
        }
    } else {
        A0 = [];
    }
    return A0;
}
//是否是断句标点
function isPunctuateWp(sentence, wordCurrentIndex, wordIndex) {
    var parentIndex = sentence[wordCurrentIndex].parent;
    var nextParentIndex = sentence[wordCurrentIndex + 1].parent;
    if (parentIndex != nextParentIndex) {
        var id = wordCurrentIndex + 1;
        while (1) {
            if (sentence[id].parent == wordIndex) {
                return true;
            }
            //左附加关系（修饰右边词语的词）//是后一个词语的主语 //是后一个的前置宾语//符号后还有其他标点符号，如“**”
            if (sentence[id].relate == 'LAD' || sentence[id].relate == 'SBV'||sentence[id].relate == 'FOB'||sentence[id].relate == 'WP') {
                id = sentence[id].parent;
            } else if (sentence[id].relate == 'ATT' || sentence[id].relate == 'ADV') {
                id = sentence[id].parent;
            } else {
                return false;
            }
        }
    } else {
        return false;
    }
}

function sentenceCompress(sentence) {
    var allsentence = new Array();
    allsentence = sentenceSlimplifer(sentence);
    for (var all_id = 0; all_id < allsentence.length; all_id++) {
        if(allsentence.length==1) isNew=false;
        else isNew=true;
        sentence = allsentence[all_id];
        for (var wordIndex = 0; wordIndex < sentence.length; wordIndex++) {
            var word = sentence[wordIndex];
            var isADV = false;
            var isADV_child = false;
            var isADV_parent = false;
            var isADVpc = false;
            var isADVpp = false;
            //删除ADV的child、判断ADV的parent 如果是名词、动词不删 其他词删、在删除其他词时，要看其他词的child和parent。parent如果是n词，不删。其他词删。
            // 使用sentence[id].id，不要直接用id
            if (word.relate == 'ADV' && word.pos != 'n' && word.pos != 'ns' && word.pos != 'nd' && word.pos != 'nz' && word.pos != 'nh') {
                isADV = true;
                var ADV_ID = word.id; //找到ADV的下标
                for (var i = 0; i < sentence.length; i++) {
                    if (sentence[i].parent == ADV_ID && sentence[i].pos != 'v' && sentence[i].pos != 'n' && sentence[i].pos.pos != 'ns' && sentence[i].pos.pos != 'nd' && sentence[i].pos != 'nz' && sentence[i].pos != 'nh') {
                        isADV_child = true;
                        var ADVchild_ID = sentence[i].id;
                    }
                    if (sentence[i].id == word.parent && sentence[i].pos != 'i' && sentence[i].pos != 'v' && sentence[i].pos != 'n' && sentence[i].pos.pos != 'ns' && sentence[i].pos.pos != 'nd' && sentence[i].pos != 'nz' && sentence[i].pos != 'nh') {
                        isADV_parent = true;
                        var ADVparent_ID = sentence[i].id;
                        for (var j = 0; j < sentence.length; j++) {
                            if (sentence[j].parent == ADVparent_ID && sentence[j].pos != 'n' && sentence[i].pos.pos != 'ns' && sentence[i].pos.pos != 'nd' && sentence[i].pos != 'nz' && sentence[i].pos != 'nh') {
                                isADVpc = true;
                                var ADVpc_ID = sentence[j].id;
                            }
                            if (sentence[j].id == sentence[i].parent && sentence[j].pos != 'i' && sentence[j].pos != 'v' && sentence[j].pos != 'n' && sentence[j].pos.pos != 'ns' && sentence[j].pos.pos != 'nd' && sentence[j].pos != 'nz' && sentence[j].pos != 'nh') {
                                isADVpp = true;
                                var ADVpp_ID = sentence[j].id;
                            }
                        }


                    }
                }
                for (var windex = 0; windex < sentence.length; windex++) {
                    winword = sentence[windex];
                    if (winword.arg.length != 0) {
                        for (var winIndex = 0; winIndex < winword.arg.length; winIndex++) {
                            var component = winword.arg[winIndex];
                            //判断有无LCO或TMP
                            if (component.type == 'LOC' || component.type == 'TMP') {
                                begin_id = component.beg;
                                end_id = component.end;
                                if (ADV_ID >= begin_id && ADV_ID <= end_id)  isADV = false;
                                else {
                                    if (ADVchild_ID >= begin_id && ADVchild_ID <= end_id)  isADV_child = false;
                                    if (ADVparent_ID >= begin_id && ADVparent_ID <= end_id)  isADV_parent = false;
                                    else {
                                        if (ADVpc_ID >= begin_id && ADVpc_ID <= end_id)  isADVpc = false;
                                        if (ADVpp_ID >= begin_id && ADVpp_ID <= end_id)  isADVpp = false;
                                    }
                                }

                            }//if LOC
                        }//for winIndex
                    }//if winword.arg.length
                }//for windex
            }//if(adv)
            if (isADV) {
                allsentence[all_id] = removeADV(allsentence[all_id], ADV_ID);
                if (isADV_child)  allsentence[all_id] = removeADV(allsentence[all_id], ADVchild_ID);
                if (isADV_parent){
                    allsentence[all_id] = removeADV(allsentence[all_id], ADVparent_ID);                
                    if (isADVpp)  allsentence[all_id] = removeADV(allsentence[all_id], ADVpp_ID);                             
                    if (isADVpc) allsentence[all_id] = removeADV(allsentence[all_id], ADVpc_ID);         
                }
            }                                
        }
    }

    return allsentence;
}
function removeADV(sentence, id) {
    var sent = [];
    var sen_adv=-2;
    for (var i = 0; i < sentence.length; i++) {
        if (sentence[i].id == id)  sen_adv = i;
    }
    for (var wordIndex = 0; wordIndex < sentence.length; wordIndex++) {
        var word = sentence[wordIndex];
        if (wordIndex < sen_adv || wordIndex > sen_adv) {
            sent.push(word);//push() 方法可向数组的末尾添加一个或多个元素，并返回新的长度。   
        }
    }
    return sent;
}

