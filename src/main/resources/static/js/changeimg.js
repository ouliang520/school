
	var item=document.getElementsByClassName("ms");
	var items = document.getElementsByClassName("mname");
	var item1 = document.getElementById("tou-ul");
	var tli = item1.getElementsByTagName("li") 
	var count = 3;
	for(var i=0;i<item.length;i++){
		item[i].style.backgroundImage="url(img/header/m"+(i+1)+".png)";
		item[i].style.backgroundRepeat="no-repeat";
		item[i].style.backgroundPosition="25px center";
	}
	for(var i = 0;i<items.length;i++){
		items[i].style.backgroundImage="url(img/header/n"+(i+1)+".png)";
		items[i].style.backgroundRepeat="no-repeat";
		items[i].style.backgroundPosition="25px center";
	}
	for(var i = 0;i<tli.length;i++){
		tli[i].style.backgroundImage="url(img/header/tt"+(i+1)+".png)";// 改之前
		tli[i].style.backgroundRepeat="no-repeat";
		tli[i].style.backgroundPosition="25px center";
	}
