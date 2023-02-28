var fimg = document.getElementById("fimg");
var timer = setInterval(function(){
		count++;
		fimg.src = "img/footer/bq"+(count%2+3)+".png";
	},2000);