function createDialog(idName, title) {
	$("#" + idName).dialog({
		title : title,
		modal : true, // 模式窗口：窗口背景不可操作
		resizable : true, // 可拖动边框大小
		center : true,  
	   
	});
}
function closeDialog(idName) {
	$("#" + idName).dialog('close');
}
function openDialog(idName) {
	$("#" + idName).dialog('open');
}

