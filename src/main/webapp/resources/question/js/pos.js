/**
 * 词性标注（pos）问题 || 这段是依存句法（ne）问题
 */
function posGenerateQuestionsBySentence(sentence) {
    NERNum = 0;
    var questions = [];
    for (var i = 0; i < sentence.length; i++) {
        var word = sentence[i];
        if (word.ne == 'O')
            continue;
        newQuestion = posGenerateQuestionByWord(sentence, word);
        if (newQuestion && newQuestion.text)
            questions = pushQuestion(questions, newQuestion);
    }
    return questions;
}

function posGenerateQuestionByWord(sentence, word) {
    var id = -1;
    for (var i = 0; i < sentence.length; i++) {
        if (sentence[i].id == word.parent) {
            id = i;
            break;
        }
    }
    if (id != -1 && sentence[id].arg.length != 0) {
        if (word.parent > -1 && sentence[id].arg) {
            var args = sentence[id].arg;
            for (var i = 0; i < args.length; i++) {
                if (args[i].type == 'A0' && args[i].beg == word.id) {
                    break;
                }
            }
        }
    }
     
    var rpcLbl = posGetReplacementAndLabel(word);
    if (!rpcLbl)
        return null;
    var question = {
        label: rpcLbl.label,
        text: replaceNode(sentence, word, rpcLbl.replacement),
        answer:getAnswer(sentence,word)
    };
    return question;
}

function posGetReplacementAndLabel(word) {

    var rpcLblFactory = function (rpc, lbl) {
        return {
            replacement: rpc,
            label: lbl
        };
    };
    var rpcLblArray = [
        rpcLblFactory('谁', '人名'),
        rpcLblFactory('哪家机构', '机构名'),
        rpcLblFactory('哪里', '地名')
    ];
    var rpcLbl = null;
    //Nh:人名 Ni:机构名 Ns:地名
    var posArray = ['S-Nh', 'S-Ni', 'S-Nl', 'S-Ns'];
    var posArray2 = ['E-Nh', 'E-Ni', 'E-Nl', 'E-Ns'];
    for (var i = 0; i < posArray.length; i++) {
        if (word.ne.indexOf(posArray[i]) >= 0) {
            NERNum++;
            rpcLbl = rpcLblArray[i];
            if (i == 3) {
                if (word.relate == 'COO') {
                    return false;
                }
                rpcLbl = rpcLblArray[2];
            }
            break;
        }

    }
    for (var i = 0; i < posArray.length; i++) {
        if (word.ne.indexOf(posArray2[i]) >= 0) {
            NERNum++;
            rpcLbl = rpcLblArray[i];
            if (i == 3) {
                rpcLbl = rpcLblArray[2];
            }
            break;
        }
    }
    
    if (!rpcLbl)
        return null;
    /*if (word.relate == "ATT") {
        rpcLbl.replacement += "的";
    }*/
    return rpcLbl;
}
function getAnswer(sentence, word) {
    var str = "";
    for (var wordIndex = 0; wordIndex < sentence.length; wordIndex++) {
        var thisWord = sentence[wordIndex];
        if (thisWord == word||(thisWord.parent==word.id&&thisWord.ne!='O')) {
                str += thisWord.cont;
        }
    }
    return str;
}
function replaceNode(sentence, word, replacement) {
    var isReplaced = false;
    var str = "";
    for (var wordIndex = 0; wordIndex < sentence.length; wordIndex++) {
        var thisWord = sentence[wordIndex];
        //if(thisWord == word || isAncestor(sentence,word,thisWord)){
        if (thisWord == word||(thisWord.parent==word.id&&thisWord.ne!='O')) {
            if (!isReplaced) {
                str += replacement;
                isReplaced = true;
            }
        }
        else {
            str += thisWord.cont;
        }
    }
    return str;
}

//判断当前词和关键词是否存在可替换的依存关系
/*function isAncestor(sentence,word1,word2){
 if(word2.parent == word1.id){
 return true;
 }
 else if (word2.parent == -1){
 return false;
 }else{
 return isAncestor(sentence,word1,sentence[word2.parent]);
 }
 }*/
