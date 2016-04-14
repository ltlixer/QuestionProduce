/**
 * Created by renxianglei on 2015/10/16.
 *//*
var fileName = $('.fileName').html(),
    docHeight = window.innerHeight,
    isAddFile = false;

//初始化代码框
var myCodeMirror = CodeMirror.fromTextArea($('#js')[0], {
    value: "//Input here",
    extraKeys: {
        "Ctrl-Q": "autocomplete",
        "F11": function (cm) {
            cm.setOption("fullScreen", !cm.getOption("fullScreen"));
        },
        "Esc": function (cm) {
            if (cm.getOption("fullScreen")) cm.setOption("fullScreen", false);
        }
    },
    lineNumbers: true,
    lineWrapping: true,
    foldGutter: true,
    // fullScreen: true,
    keyMap: "sublime",
    autoCloseBrackets: true,
    matchBrackets: true,
    showCursorWhenSelecting: true,
    scrollbarStyle: "simple",
    gutters: ["CodeMirror-linenumbers", "CodeMirror-foldgutter"],
    theme: 'monokai'
});

var copyMirror = CodeMirror.fromTextArea($('#copy')[0], {
    value: myCodeMirror.getValue(),
    mode: "javascript",
    autofocus: true,
    extraKeys: {
        "Ctrl-Q": "autocomplete",
        "F11": function (cm) {
            cm.setOption("fullScreen", !cm.getOption("fullScreen"));
        },
        "Esc": function (cm) {
            if (cm.getOption("fullScreen")) cm.setOption("fullScreen", false);
        }
    },
    lineNumbers: true,
    lineWrapping: true,
    foldGutter: true,
    // fullScreen: true,
    keyMap: "sublime",
    autoCloseBrackets: true,
    matchBrackets: true,
    showCursorWhenSelecting: true,
    scrollbarStyle: "simple",
    gutters: ["CodeMirror-linenumbers", "CodeMirror-foldgutter"],
    theme: 'monokai'
});

myCodeMirror.setSize('100%', docHeight - 150);
copyMirror.setSize('100%', docHeight - 150);

$(window).resize(function () {
    docHeight = window.innerHeight;
    myCodeMirror.setSize('100%', docHeight - 150);
    copyMirror.setSize('100%', docHeight - 150);
})


//新建版本逻辑
$('.addModel').click(function () {
    if (!isAddFile) {
        $('.input-content').css('display', 'block');
    } else {
        $('.input-content').css('display', 'none');
    }
    isAddFile = !isAddFile;
});

//切换代码版本
$("#modelList").on('change', function () {
    queryCode();
})

//切换所要修改的文件
$("#fileList").on('change', function () {
    window.location = './code?name=' + this.value;
})

$('.sure').on('click', function () {

    if ($('.newModel').val() === '') {
        alert('填入内容不得为空');
    } else {
        var modelName = $('.newModel').val();
        $("#modelList").append($("<option></option>").attr("value", modelName).text(modelName));
        $('.newModel').val('');
        $('.input-content').css('display', 'none');
        //选中新建版本
        var optionLength = $("#modelList")[0].options.length;
        $("#modelList")[0].options[optionLength - 1].selected = true;

        save();
    }
})

$('.cancel').on('click', function () {
    $('.input-content').css('display', 'none');
});

//保存代码
function save() {

    if ($("#modelList :selected").text() == '原始版本') {
        if (!confirm('原始版本，一经更改，无法还原。你确定要更改原始版本吗？')) {
            return false;
        }
    }
    var postParams = {
        name: fileName,
        code: copyMirror.getValue(),
        version: $("#modelList :selected").text()
    };

    $.ajax({
        type: 'POST',
        url: '/modify',
        data: postParams && $.param(postParams),
        dataType: 'JSON'
    }).then(function (data) {
        myCodeMirror.setValue(data.code);
    }, function (err) {
        console.log(err);
    })
}

//删除版本
function del() {

    if (!confirm('确定要删除该版本？')) {
        return;
    }

    if ($("#modelList :selected").text() == '原始版本') {
        alert('原始版本不能删除');
        return;
    }

    var postParams = {
        name: fileName,
        version: $("#modelList :selected").text()
    };

    $.ajax({
        type: 'POST',
        url: '/del',
        data: postParams && $.param(postParams),
        dataType: 'JSON'
    }).then(function (data) {
        $("#modelList :selected").remove();
        query();

    }, function (err) {
        console.log(err);
    })
}

//复制代码到可操作框中
function copy() {
    copyMirror.setValue(myCodeMirror.getValue());
}

//查询版本代码
function queryCode() {

    var postParams = {
        name: fileName,
        version: $("#modelList :selected").text()
    };
    $.ajax({
        type: 'POST',
        url: '/query',
        data: postParams && $.param(postParams),
        dataType: 'JSON'
    }).then(function (data) {
        myCodeMirror.setValue(data.code);
        copy();
    }, function (err) {
        console.log(err);
    })
}

//预览，将修改后的代码写入文件中并在新窗口展示
function writeFile() {

    var postParams = {
        name: fileName,
        code: copyMirror.getValue()
    };

    $.ajax({
        type: 'POST',
        url: '/writeFile',
        data: postParams && $.param(postParams)
    }).then(function (data) {
        window.open('http://101.200.205.238/', '_blank');
    }, function (err) {
        console.log(err);
    });

    //$.ajax({
    //    type: 'POST',
    //    url: '/writeFile',
    //    data: {},
    //    dataType: 'JSON'
    //}).then(function(data) {
    //    //创建一个embed类型的captcha
    //    var captcha = new window.Geetest({
    //        gt: '4f2ef8e36cedbbe4413c9c51eefa8887',
    //        product: 'embed'
    //    }).appendTo(".toolbar");
    //
    //    captcha.onSuccess(function() {
    //        var validate = captcha.getValidate();
    //        console.log(validate);
    //    })
    //}, function(err) {
    //    console.log(err);
    //});
}*/