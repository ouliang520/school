var banner = document.getElementById("banner");
var lis = banner.getElementsByTagName("li");
var lisa = document.getElementsByClassName("aa");
var qu = document.getElementsByClassName("qu")
var jian =window.screen.height;//可见区域的高
var divHeight = [];

for(var i = 0;i<qu.length;i++){
	divHeight.push(qu[i].getBoundingClientRect().top);
} 
window.addEventListener('scroll', updateNav);
function updateNav(){
	var juan =  document.documentElement.scrollTop;
	var k = 0;
	for (var i = 0; i < divHeight.length; i++) {
	    if (juan+(jian/2.5) > divHeight[i]) {
	        k = i;
	    }
	}
	lis[k].style.backgroundColor = "#00A1D6";
	lisa[k].style.color = "#FFFFFF";
	for (var i = 0; i < qu.length; i++) {
	    if (i != k){
	    	lis[i].style.backgroundColor = "#FFFFFF";
			lisa[i].style.color = "#505050";
	    }else{
			continue;
	    }
	}
} 

