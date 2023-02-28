var gz1 = document.getElementById("btn-gz1");
var gz2 = document.getElementById("btn-gz2");
var gz3 = document.getElementById("btn-gz3");
var gz4 = document.getElementById("btn-gz4");
var gz = document.getElementById("gz");
gz1.onmousemove = function(){
	this.value = "取消关注";
}
gz1.onmouseout = function(){
	this.value = "已关注";
}
gz2.onmousemove = function(){
	this.value = "取消关注";
}
gz2.onmouseout = function(){
	this.value = "已关注";
}
gz3.onmousemove = function(){
	this.value = "取消关注";
}
gz3.onmouseout = function(){
	this.value = "已关注";
}
gz4.onmousemove = function(){
	this.value = "取消关注";
}
gz4.onmouseout = function(){
	this.value = "已关注";
}
gz.onmousemove = function(){
	this.innerHTML = "已关注";
}
gz.onmouseout = function(){
	this.innerHTML= "已关注654.4万";
}