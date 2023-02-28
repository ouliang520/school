//第一个轮播
var imgul = document.getElementById("index-1-1");
var btnul = document.getElementById("index-1-2");
var imgli = imgul.getElementsByTagName("li");
var btnli = btnul.getElementsByTagName("li");
var b = btnul.getElementsByTagName("img");
var index = 0;
imgul.style.width = 553*imgli.length+"px"
for(var i = 0; i<imgli.length; i++){
		b[i].style.display = "none";
	}
	b[0].style.display = "block";
for(var i = 0; i<imgli.length; i++){
	btnli[i].num = i; 
	btnli[i].onclick = function(){
		index = this.num;
		imgul.style.left = -553*index+"px";
		change();
	}
}
setInterval(function(){
	imgul.style.left = -553*index+"px";
	change();
	index++;
	index %= 5;
},3000)
function change(){
	for(var i = 0; i<imgli.length; i++){
		b[i].style.display = "none";
	}
	b[index].style.display = "block";
	
}
//第二个轮播
var btnl = document.getElementById("btn-left");
var btnr = document.getElementById("btn-right");
var ulsan = document.getElementById("index-1-3");
var nar = 0;
btnl.onclick = function(){
	nar++;
	if(nar>2){
		nar = 0;
	}
	ulsan.style.left = -864*nar+"px";
}
btnr.onclick = function(){
	nar--;
	if(nar<0){
		nar = 2;
	}
	ulsan.style.left = -864*nar+"px";
}
//第三个轮播
var imgul2 = document.getElementById("zb-x-1");
var btnul2 = document.getElementById("zb-x-2");
var imgli2 = imgul2.getElementsByTagName("li");
var btnli2 = btnul2.getElementsByTagName("li");
var a = btnul2.getElementsByTagName("img");
var index2 = 0;
imgul2.style.width = 320*imgli2.length+"px"
for(var i = 0; i<imgli2.length; i++){
		a[i].style.display = "none";
	}
	a[0].style.display = "block";
for(var i = 0; i<imgli2.length; i++){
	btnli2[i].num = i; 
	btnli2[i].onclick = function(){
		index2 = this.num;
		imgul2.style.left = -320*index2+"px";
		change2();
	}
}
setInterval(function(){
	imgul2.style.left = -320*index2+"px";
	change2();
	index2++;
	index2 %= 3;
},3000)
function change2(){
	for(var i = 0; i<imgli2.length; i++){
		a[i].style.display = "none";
	}
	a[index2].style.display = "block";
	
}
//第四个轮播
var imgul3 = document.getElementById("div-u-1");
var btnul3 = document.getElementById("div-u-2");
var imgli3 = imgul3.getElementsByTagName("li");
var btnli3 = btnul3.getElementsByTagName("li");
var c = btnul3.getElementsByTagName("img");
var index3 = 0;
imgul3.style.width = 320*imgli3.length+"px"
for(var i = 0; i<imgli3.length; i++){
		c[i].style.display = "none";
	}
	c[0].style.display = "block";
for(var i = 0; i<imgli3.length; i++){
	btnli3[i].num = i; 
	btnli3[i].onclick = function(){
		index3 = this.num;
		imgul3.style.left = -320*index3+"px";
		change3();
	}
}
setInterval(function(){
	imgul3.style.left = -320*index3+"px";
	change3();
	index3++;
	index3 %= 3;
},3000)
function change3(){
	for(var i = 0; i<imgli3.length; i++){
		c[i].style.display = "none";
	}
	c[index3].style.display = "block";
}
//第五个轮播
var imgul4 = document.getElementById("lun-x-1");
var btnul4 = document.getElementById("lun-x-2");
var imgli4 = imgul4.getElementsByTagName("li");
var btnli4 = btnul4.getElementsByTagName("li");
var d = btnul4.getElementsByTagName("img");
var index4 = 0;
imgul4.style.width = 320*imgli4.length+"px"
for(var i = 0; i<imgli4.length; i++){
		d[i].style.display = "none";
	}
	d[0].style.display = "block";
for(var i = 0; i<imgli4.length; i++){
	btnli4[i].num = i; 
	btnli4[i].onclick = function(){
		index4 = this.num;
		imgul4.style.left = -320*index4+"px";
		change4();
	}
}
setInterval(function(){
	imgul4.style.left = -320*index4+"px";
	change4();
	index4++;
	index4 %= 2;
},3000)
function change4(){
	for(var i = 0; i<imgli4.length; i++){
		d[i].style.display = "none";
	}
	d[index4].style.display = "block";
}
//第六个轮播
var zhouul = document.getElementById("zhou");
var didiul = document.getElementById("didi");
var zhouli = zhouul.getElementsByTagName("li");
var didili = didiul.getElementsByTagName("li");
var zhoua = zhouul.getElementsByTagName("a");
var index5 = 0;
zhoua[0].style.color = "#00A1D6";
zhouli[0].style.borderBottom = "#00A1D6 solid 1px";
for(var i = 0; i<zhouli.length; i++){
	zhouli[i].num = i; 
	zhouli[i].onclick = function(){
		index5 = this.num;
		didiul.style.left = -1070*index5+"px";
		shan();
	}
}
function shan(){
	for(var j = 0 ; j<zhouli.length;j++){
		zhoua[j].style.color = "#212121";
		zhouli[j].style.borderBottom = "none";
	}
	zhoua[index5].style.color = "#00A1D6";
	zhouli[index5].style.borderBottom = "#00A1D6 solid 1px";
}
//第七个轮播
var zhouul2 = document.getElementById("zhou1");
var didiul2 = document.getElementById("didi1");
var zhouli2 = zhouul2.getElementsByTagName("li");
var didili2 = didiul2.getElementsByTagName("li");
var zhoua2 = zhouul2.getElementsByTagName("a");
var index6 = 0;
zhoua2[0].style.color = "#00A1D6";
zhouli2[0].style.borderBottom = "#00A1D6 solid 1px";
for(var i = 0; i<zhouli2.length; i++){
	zhouli2[i].num = i; 
	zhouli2[i].onclick = function(){
		index6 = this.num;
		didiul2.style.left = -1070*index6+"px";
		shan2();
	}
}
function shan2(){
	for(var j = 0 ; j<zhouli.length;j++){
		zhoua2[j].style.color = "#212121";
		zhouli2[j].style.borderBottom = "none";
	}
	zhoua2[index6].style.color = "#00A1D6";
	zhouli2[index6].style.borderBottom = "#00A1D6 solid 1px";
}