/**
 * 对持续时间问题
 */
var lastKeyWords = ['经历', '持续', '花费', '为期', '长达'];

function lastQuestionsBySentence(sentence) {
    var questions = [];
    for (var wordIndex = 0; wordIndex < sentence.length; wordIndex++) {
        var word = sentence[wordIndex];
        for (var i = 0; i < lastKeyWords.length; i++) {
            if (word.cont == lastKeyWords[i] && wordIndex < sentence.length - 2) {
                var mWord = sentence[wordIndex + 1];
                var qWord = sentence[wordIndex + 2];
                if (qWord.pos == 'q'
                    && mWord.pos == 'm'
                    && mWord.relate == "ATT"
                    && mWord.parent == qWord.id) {
                    var replacement = "多久";
                    var component = {beg: mWord.id, end: qWord.id};
                    var text = componentReplace(sentence, component, replacement);
                    var answer=getComponentStr(sentence,component);
                    var newQuestion = {
                        label: '持续时间',
                        answer:answer,
                        text: text
                    };
                    if (newQuestion)
                        questions = pushQuestion(questions, newQuestion);
                }

            }
        }
    }
    return questions;
}