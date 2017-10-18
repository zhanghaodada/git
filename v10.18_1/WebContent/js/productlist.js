function _onload(){
	var getdivclass=document.getElementsByClassName("div_img");
	for(var i=0;i<getdivclass.length;i++){
		var getvalue=parseInt(getdivclass[i].getAttribute("value"));
			if(getvalue==1){
		getdivclass[i].setAttribute("style","background-image:url(img/对号.png);");
	      }
	if(getvalue==0){
		getdivclass[i].setAttribute("style","background-image:url(img/错号01.png);");
	}
	}


    
	var getimgclass=document.getElementsByClassName("img_hover");
//	var getdivclass=document.getElementsByClassName("div_hiddlen");
	for(var i=0;i<getimgclass.length;i++)
	{
		getimgclass[i].setAttribute("onmouseover","testhave("+i+")");
		getimgclass[i].setAttribute("onmouseout","testhidden("+i+")");
		
	}

}
//创建鼠标移动到封面时显示大图
function testhave(i){
	var list_ul_li03_hidden=document.getElementById("div_hiddlen"+i);
	list_ul_li03_hidden.style.opacity="1";
	list_ul_li03_hidden.style.zIndex="10";
}
//创建移除效果
function testhidden(i){
	var list_ul_li03_hidden=document.getElementById("div_hiddlen"+i);
	list_ul_li03_hidden.style.opacity="0";
	list_ul_li03_hidden.style.zIndex="-10";
}