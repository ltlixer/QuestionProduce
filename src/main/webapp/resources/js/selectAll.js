function remove(name){
	   if(getSelectCount(name)<1){
	     alert("至少要选中一个选项!!");
	     return false;
	   }
	   if(confirm("确定删除？")){
		   return true;
		}else{
			return false;
		}
}
function add(name){
	   if(getSelectCount(name)<1){
	     alert("至少要选一条数据");
	     return false;
	   }
	   if(confirm("确定添加？")){
		   return true;
		}else{
			return false;
		}
}
function add1(name){
	   if(getSelectCount1(name)<1){
	     alert("至少要选一条数据");
	     return false;
	   }
	   if(confirm("确定添加？")){
		   return true;
		}else{
			return false;
		}
}
function getSelectCount1(name) {
	var count = 0;
	var ids = document.getElementsByClassName(name);
	for (var i = 0; i < ids.length; i++) {
		if (ids[i].checked) {
			count++;
		}
	}
	return count;
}
function getSelectCount(name) {
	var count = 0;
	var ids = document.getElementsByName(name);
	for (var i = 0; i < ids.length; i++) {
		if (ids[i].checked) {
			count++;
		}
	}
	return count;
}





function checkEvent(name,allCheckId) {
	var allCk = document.getElementById(allCheckId);
	if(allCk.checked == true) checkAll(name);
	else checkAllNo(name);
}

function checkAll(name) {
	var names=document.getElementsByName(name);
	var len = names.length;
	if(len>0){
		var i = 0;
		for(i=0;i<len;i++){
			names[i].checked = true;
		}
	}
}
function checkAllNo(name) {
	var names=document.getElementsByName(name);
	var len = names.length;
	if(len>0){
		var i = 0;
		for(i=0;i<len;i++){
			names[i].checked = false;
		}
	}
}