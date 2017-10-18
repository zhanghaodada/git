var group01=["","编号","名称","库存","完结","排序","操作"];
var group02=[   [{"input":"a","number":"1","name":"超时空要塞","inventory":"24","grounding":"1","sort01":"1","revise":""}],
                [{"input":"a","number":"2","name":"从零开始的异世界","inventory":"12","grounding":"1","sort01":"1","revise":""}],
                [{"input":"a","number":"3","name":"电玩咖GAMER！","inventory":"10","grounding":"0","sort01":"1","revise":""}],
                [{"input":"a","number":"6","name":"Charlotte","inventory":"24","grounding":"1","sort01":"1","revise":""}],
                [{"input":"a","number":"27","name":"干物妹！小埋","inventory":"24","grounding":"1","sort01":"1","revise":""}],
                [{"input":"a","number":"72","name":" 欢迎来到实力至上主义的教室","inventory":"10","grounding":"0","sort01":"1","revise":""}],
                [{"input":"a","number":"66","name":"镇魂街","inventory":"12","grounding":"1","sort01":"1","revise":""}],
			];
//创建图片的数组
var img=["list00","list01","list02","list03","list04","list05","list06"];




function _onload(){
	
	var div_middle=document.getElementById("div_middle");
	//创建每一行的div元素
	var div_middle_list=document.createElement("div");
	div_middle_list.setAttribute("class","div_middle_list_01");
	div_middle.appendChild(div_middle_list);
//	//创建ul
//	var list_ul=document.createElement("ul");
//	list_ul.setAttribute("class","list_ul");
//	div_middle_list.appendChild(list_ul);
	//创建承载input li
		var list_ul_li01=document.createElement("div");
		list_ul_li01.setAttribute("class","list_ul_li01");
		div_middle_list.appendChild(list_ul_li01);
		//创建input标签
		var ul_li01_input000=document.createElement("input");
		ul_li01_input000.setAttribute("id","ul_li01_input000");
		
		ul_li01_input000.setAttribute("type","checkbox");
		list_ul_li01.appendChild(ul_li01_input000);
	//创建承载编号
	    var list_ul_li02=document.createElement("div");
		list_ul_li02.setAttribute("class","list_ul_li02");
		div_middle_list.appendChild(list_ul_li02);
		//创建编号文本节点
		var ul_li02_text=document.createTextNode(group01[1]);
		list_ul_li02.appendChild(ul_li02_text);
		
	//创建名称
	 var list_ul_li03=document.createElement("div");
		list_ul_li03.setAttribute("class","list_ul_li03");
		div_middle_list.appendChild(list_ul_li03);
		//创建编号文本节点
		var ul_li03_text=document.createTextNode(group01[2]);
		list_ul_li03.appendChild(ul_li03_text);
	//创建库存
	 var list_ul_li04=document.createElement("div");
		list_ul_li04.setAttribute("class","list_ul_li04");
		div_middle_list.appendChild(list_ul_li04);
		//创建编号文本节点
		var ul_li04_text=document.createTextNode(group01[3]);
		list_ul_li04.appendChild(ul_li04_text);
	//创建上架
	var list_ul_li05=document.createElement("div");
		list_ul_li05.setAttribute("class","list_ul_li05");
		div_middle_list.appendChild(list_ul_li05);
		//创建编号文本节点
		var ul_li05_text=document.createTextNode(group01[4]);
		list_ul_li05.appendChild(ul_li05_text);
	//创建排序
	var list_ul_li06=document.createElement("div");
		list_ul_li06.setAttribute("class","list_ul_li06");
		div_middle_list.appendChild(list_ul_li06);
		//创建编号文本节点
		var ul_li06_text=document.createTextNode(group01[5]);
		list_ul_li06.appendChild(ul_li06_text);
	//创建操作
	var list_ul_li07=document.createElement("div");
		list_ul_li07.setAttribute("class","list_ul_li07");
		div_middle_list.appendChild(list_ul_li07);
		//创建编号文本节点
		var ul_li07_text=document.createTextNode(group01[6]);
		list_ul_li07.appendChild(ul_li07_text);
	
	
	
	
	
	
	
	//添加展示信息
	for(var i=0;i<group02.length;i++){
		var div_middle_list01=document.createElement("div");
		div_middle_list01.setAttribute("class","div_middle_list_02");
		div_middle_list01.setAttribute("id","div_middle_list_02id"+i);
		div_middle.appendChild(div_middle_list01);
		
		
	  //给div添加值
	  //创建承载input li
		var list_ul_li01=document.createElement("div");
		list_ul_li01.setAttribute("class","list_ul_li01display");
		div_middle_list01.appendChild(list_ul_li01);
		//创建input标签
		var ul_li01_input=document.createElement("input");
		ul_li01_input.setAttribute("id","ul_li01_input");
		ul_li01_input.setAttribute("class","ul_li01_input_class");
		ul_li01_input.setAttribute("type","checkbox");
		list_ul_li01.appendChild(ul_li01_input);
	//创建承载编号
	    var list_ul_li02=document.createElement("div");
		list_ul_li02.setAttribute("class","list_ul_li02display");
		div_middle_list01.appendChild(list_ul_li02);
		//创建编号文本节点
		var ul_li02_text=document.createTextNode(group02[i][0].number);
		list_ul_li02.appendChild(ul_li02_text);
		
	//创建名称
	 var list_ul_li03=document.createElement("div");
		list_ul_li03.setAttribute("class","list_ul_li03display");
		div_middle_list01.appendChild(list_ul_li03);
		//创建承载封面的div
		var list_ul_li03_div=document.createElement("div");
		list_ul_li03_div.setAttribute("class","list_ul_li03_div");
		//设id
		list_ul_li03_div.setAttribute("id","list_ul_li03_div_id"+i);
		//创键承载悬浮大图的div
		var list_ul_li03_hidden=document.createElement("div");
		list_ul_li03_hidden.setAttribute("id","list_ul_li03_hidden"+i);
		var sty="width:225px;height:300px;opacity:0;z-index:20;position: absolute;left:90px;background-image: url(img/list0"+i+".jpg);";
		list_ul_li03_hidden.setAttribute("style",sty);
		//var sty01="#list_ul_li03_div_id"+i+":hover{opacity:1;}";
		//创建鼠标移动事件
		list_ul_li03_div.setAttribute("onmouseover","testhave("+i+")");
		//创建鼠标移出事件
		list_ul_li03_div.setAttribute("onmouseout","testhidden("+i+")");
		
		list_ul_li03.appendChild(list_ul_li03_hidden);
		list_ul_li03.appendChild(list_ul_li03_div);
		//创建封面img
		var ul_li03_div_img=document.createElement("img");
		ul_li03_div_img.setAttribute("src","img/"+img[i]+".jpg");
		list_ul_li03_div.appendChild(ul_li03_div_img);
		//创建编号文本节点
		var ul_li03_text=document.createTextNode(group02[i][0].name);
		list_ul_li03.appendChild(ul_li03_text);
		
		
	//创建库存
	 var list_ul_li04=document.createElement("div");
		list_ul_li04.setAttribute("class","list_ul_li04display");
		div_middle_list01.appendChild(list_ul_li04);
		//创建编号文本节点
		var ul_li04_text=document.createTextNode(group02[i][0].inventory);
		list_ul_li04.appendChild(ul_li04_text);
		
	//创建上架
	var list_ul_li05=document.createElement("div");
		list_ul_li05.setAttribute("class","list_ul_li05display");
		div_middle_list01.appendChild(list_ul_li05);
//		//创建编号文本节点
//		var ul_li05_text=document.createTextNode(group02[i][0].grounding);
//		list_ul_li05.appendChild(ul_li05_text);
           //创建加减号
		 var ul_li05_img=document.createElement("img");
		 list_ul_li05.appendChild(ul_li05_img);
		if(group02[i][0].grounding==="0"){
		 
		 ul_li05_img.setAttribute("src","img/错号01.png");
		}
		else{
			ul_li05_img.setAttribute("src","img/对号.png");
		}
		 
		 
	//创建排序
	var list_ul_li06=document.createElement("div");
		list_ul_li06.setAttribute("class","list_ul_li06display");
		div_middle_list01.appendChild(list_ul_li06);
		//创建编号文本节点
		var ul_li06_text=document.createTextNode(group02[i][0].sort01);
		list_ul_li06.appendChild(ul_li06_text);
	//创建操作
	var list_ul_li07=document.createElement("div");
		list_ul_li07.setAttribute("class","list_ul_li07display");
		div_middle_list01.appendChild(list_ul_li07);
		//创建修改div
		var list_ul_li07_leftdiv=document.createElement("div");
		list_ul_li07_leftdiv.setAttribute("class","list_ul_li07_leftdiv");
		list_ul_li07.appendChild(list_ul_li07_leftdiv);
		   //创建文本节点
		   var leftdiv_word=document.createTextNode("修改");
		   list_ul_li07_leftdiv.appendChild(leftdiv_word);
		//创建删除div
		var list_ul_li07_rightdiv=document.createElement("div");
		list_ul_li07_rightdiv.setAttribute("class","list_ul_li07_rightdiv");
	    list_ul_li07.appendChild(list_ul_li07_rightdiv);
	     //创建文本节点
		   var rightdiv_word=document.createTextNode("删除");
		   list_ul_li07_rightdiv.appendChild(rightdiv_word);

//		//创建编号文本节点
//		var ul_li07_text=document.createTextNode(group02[i][0].revise);
//		list_ul_li07.appendChild(ul_li07_text);
	
	}
	
	//增加点击事件最后
	ul_li01_input000.setAttribute("onclick","testonclick()");
	
}
//创建鼠标移动到封面时显示大图
function testhave(i){
	var list_ul_li03_hidden=document.getElementById("list_ul_li03_hidden"+i);
	list_ul_li03_hidden.setAttribute("style","width:225px;height:300px;transition:1.5s;opacity: 1;z-index:20;position: absolute;left:90px;background-image: url(img/"+img[i]+".jpg);");
}
//创建移除效果
function testhidden(i){
	var list_ul_li03_hidden=document.getElementById("list_ul_li03_hidden"+i);
	list_ul_li03_hidden.setAttribute("style","opacity:0;");
}
//创建全选和反选时间
function testonclick(){
	var getinput=document.getElementById("ul_li01_input000");
	var getinputall=document.getElementsByClassName("ul_li01_input_class");
	for(var i=0;i<getinputall.length;i++){
		if(getinput.checked==true){
			getinputall[i].checked=true;
		}
		else{
			getinputall[i].checked=false;
		}
	}
}
