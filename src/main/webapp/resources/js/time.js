function getDate() {
	var d = new Date();
	var vYear = d.getFullYear();
	var vMon = d.getMonth() + 1;
	var vDay = d.getDate();
	return vYear + "年" + vMon + "月" + vDay + "日";
}
