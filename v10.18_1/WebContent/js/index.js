//带有加号的表头
var head=["商品管理","订单管理","前台管理","权限管理","会员管理","系统设置"];
//下拉菜单子选项
//第一个
var group=[
[{"name":"Collect","link":"protectlist.jsp"},{"name":"商品列表","link":"ProductServlet"},{"name":"商品类别","link":"cateCRUDservlet"},{"name":"商品规格","link":"ruleservlet"}],
[{"name":"订单管理","link":"orderservlet"},{"name":"已付款","link":""},{"name":"已发货","link":""},{"name":"已完成","link":""}],
[{"name":"注册地址","link":""},{"name":"密码管理","link":""},{"name":"其他管理","link":""}],
[{"name":"用户管理","link":""},{"name":"密码管理","link":""},{"name":"其他管理","link":""}],
[{"name":"Collect","link":"vipmanage.jsp"},{"name":"会员管理","link":"account_consumerservlet"},{"name":"其他管理","link":""}],
[{"name":"留言板","link":"addmessageservlet"},{"name":"时间","link":"time.jsp"},{"name":"about us","link":"about.jsp"}]
];

//onload加载
function init(){
	//得到父类div
	var div_middle_left=document.getElementById("div_middle_left");
	
	for(var i=0;i<head.length;i++){
		//创建带有加号表头的div
		var div_middle_left00=document.createElement("div");
		div_middle_left00.setAttribute("class","div_middle_left00");
		div_middle_left00.setAttribute("id","div_middle_left00"+i);
		div_middle_left.appendChild(div_middle_left00);
		//创建承载图片的div
		var div_middle_left00_img=document.createElement("div");
		div_middle_left00_img.setAttribute("id","div_img_have_id"+i);
		div_middle_left00_img.setAttribute("onclick","test("+i+")");
		div_middle_left00_img.setAttribute("class","div_middle_left00_img");
		div_middle_left00.appendChild(div_middle_left00_img);
		//创建图片
		var img_have=document.createElement("img");
		img_have.setAttribute("id","img_have_id"+i);
		img_have.setAttribute("class","img_have");
		img_have.setAttribute("src","img/jiahao.png");
		div_middle_left00_img.appendChild(img_have);
		//创建承载标题的p标签
		var p_have=document.createElement("p");
		div_middle_left00.appendChild(p_have);
		//赋值给p标签
		var p_have_word=document.createTextNode(head[i]);
		p_have.appendChild(p_have_word);
		//创建隐藏的div
		var div_hidden=document.createElement("div");
		div_hidden.setAttribute("id","div_hidden0"+i);
		div_hidden.setAttribute("class","div_hidden");
		div_hidden.setAttribute("style","height:0px;overflow: hidden;");
//		//添加点击事件
//		
//		div_hidden.setAttribute("onclick","test()");
		div_middle_left.appendChild(div_hidden);
		
		//创键下拉列表
		for(var j=0;j<group[i].length;j++){
			//得到隐藏div的id
			var div_hidden01=document.getElementById("div_hidden0"+i);
			//创建下拉列表的表
		var div_01=document.createElement("div");
		//将div追加到大div上
		div_hidden01.appendChild(div_01);
		div_01.setAttribute("class","div_have_class");
		//创建a标签
		var div_have_a=document.createElement("a");
		div_have_a.setAttribute("href",group[i][j].link);
		div_have_a.setAttribute("target","ifrm");
		var div_01_word=document.createTextNode(group[i][j].name);
		div_01.appendChild(div_have_a);
		div_have_a.appendChild(div_01_word);
		
		//创建承载>的div框
		var div_01_math=document.createElement("div");
		div_01_math.setAttribute("class","div_have_class_math");
	    var div_01_math_word=document.createTextNode(">");
		div_01.appendChild(div_01_math);
		div_01_math.appendChild(div_01_math_word);
	   }
		
	}
}

//点击事件
function test(i){

	    //得到div标题
	  var get_div=document.getElementById("div_middle_left00"+i);
	  //得到新建的div
	  var div_have=document.getElementById("div_hidden0"+i);
	  //得到存图片的div
	var div_img=document.getElementById("img_have_id"+i);
	//如果是加号则下拉菜单
	if(div_img.src.match("jiahao")){
		//替换图片为减号
		div_img.setAttribute("src","img/jianhao.png");
		//设置div标题的样式
		get_div.setAttribute("style","background-color: #DF4D4E;");
	//改变div大小	 background-color: #DF4D4E;
	var a="overflow:hidden ;width:200px;height:"+(group[i].length*40)+"px; ";
	div_have.setAttribute("style",a);
		div_have.style.transition="height 1s";
	}
	//如果是减号则上拉菜单
	else{
	
		//替换图片为加号
		div_img.setAttribute("src","img/jiahao.png");
		div_have.setAttribute("style","height: 0px;overflow: hidden;");
		div_have.style.transition="height 1s";
//		div_have.innerHTML="";
		get_div.setAttribute("style","background-color: #282828;");
	}
}

































//function init(){
//	
//	//加载第一个
//	//根据数组的选项来定义下拉菜单选项div以及样式
//	for(var i=0;i<group03.length;i++){
//		//得到新建的div
//	    var div_have=document.getElementById("div_middle_left_01_have");
//		var div_01=document.createElement("div");
//		//将div追加到大div上
//		div_have.appendChild(div_01);
//		div_01.setAttribute("class","div_have_class");
//		div_01.setAttribute("id","div_01_"+i);
//		//创建a标签
//		var div_have_a=document.createElement("a");
//		div_have_a.setAttribute("href","login.html");
//		div_have_a.setAttribute("target","ifrm");
//		var div_01_word=document.createTextNode(group03[i]);
//		div_01.appendChild(div_have_a);
//		div_have_a.appendChild(div_01_word);
//		
//		//创建承载>的div框
//		var div_01_math=document.createElement("div");
//		div_01_math.setAttribute("class","div_have_class_math");
//	    var div_01_math_word=document.createTextNode(">");
//		div_01.appendChild(div_01_math);
//		div_01_math.appendChild(div_01_math_word);
//		
//		
//	}
//	//加载第二个
//	
//	//根据数组的选项来定义下拉菜单选项div以及样式
//	for(var i=0;i<group01.length;i++){
//		//得到新建的div
//	    var div_have=document.getElementById("div_middle_left_02_have");
//		var div_01=document.createElement("div");
//		//将div追加到大div上
//		div_have.appendChild(div_01);
//		div_01.setAttribute("class","div_have_class");
//		//创建a标签
//		var div_have_a=document.createElement("a");
//		div_have_a.setAttribute("href",group01[i].link);
//		div_have_a.setAttribute("target","ifrm");
//		var div_01_word=document.createTextNode(group01[i].name);
//		div_01.appendChild(div_have_a);
//		div_have_a.appendChild(div_01_word);
//		
//		//创建承载>的div框
//		var div_01_math=document.createElement("div");
//		div_01_math.setAttribute("class","div_have_class_math");
//	    var div_01_math_word=document.createTextNode(">");
//		div_01.appendChild(div_01_math);
//		div_01_math.appendChild(div_01_math_word);
//	}
//	//加载第三个
//	//根据数组的选项来定义下拉菜单选项div以及样式
//	for(var i=0;i<group02.length;i++){
//		//得到新建的div
//	    var div_have=document.getElementById("div_middle_left_03_have");
//		var div_01=document.createElement("div");
//		//将div追加到大div上
//		div_have.appendChild(div_01);
//		div_01.setAttribute("class","div_have_class");
//		//创建a标签
//		var div_have_a=document.createElement("a");
//		div_have_a.setAttribute("href",group02[i].link);
//		div_have_a.setAttribute("target","ifrm");
//		var div_01_word=document.createTextNode(group02[i].name);
//		div_01.appendChild(div_have_a);
//		div_have_a.appendChild(div_01_word);
//		
//		//创建承载>的div框
//		var div_01_math=document.createElement("div");
//		div_01_math.setAttribute("class","div_have_class_math");
//	    var div_01_math_word=document.createTextNode(">");
//		div_01.appendChild(div_01_math);
//		div_01_math.appendChild(div_01_math_word);
//	}
//}
//
////第一个下拉列表
//function testexpand03(){
//	//得到div标题
//	var get_div=document.getElementById("div_middle_left_01");
//	//得到新建的div
//	var div_have=document.getElementById("div_middle_left_01_have");
//	//得到存图片的div
//	var div_img=document.getElementById("div_middle_left_01_img_have");
//	//如果是加号则下拉菜单
//	if(div_img.src.match("jiahao")){
//		//替换图片为减号
//		div_img.setAttribute("src","img/jianhao.png");
//		//设置div标题的样式
//		get_div.setAttribute("style","background-color: #DF4D4E;");
//	//改变div大小	 background-color: #DF4D4E;
//	var a="overflow:hidden ;width:200px;height:"+(group03.length*40)+"px; ";
//	div_have.setAttribute("style",a);
//		div_have.style.transition="height 1s";
//	}
//	//如果是减号则上拉菜单
//	else{
//	
//		//替换图片为加号
//		div_img.setAttribute("src","img/jiahao.png");
//		div_have.setAttribute("style","height: 0px;overflow: hidden;");
//		div_have.style.transition="height 1s";
////		div_have.innerHTML="";
//		get_div.setAttribute("style","background-color: #282828;");
//	}
//	
//}
////第二个下拉列表
//function testexpand(){
//	//得到div标题
//	var get_div=document.getElementById("div_middle_left_02");
//	//
//	var div_have=document.getElementById("div_middle_left_02_have");
//	//得到存图片的div
//	var div_img=document.getElementById("div_middle_left_02_img_have");
//	//如果是加号则下拉菜单
//	if(div_img.src.match("jiahao")){
//		//替换图片为减号
//		div_img.setAttribute("src","img/jianhao.png");
//		//设置div标题的样式
//		get_div.setAttribute("style","background-color: #DF4D4E;");
//	//改变div大小	
//	var a="overflow:hidden ;width:200px;height:"+(group01.length*40)+"px;";
//	div_have.setAttribute("style",a);
//	div_have.style.transition="height 1s";
//	
//	}
//	//如果是减号则上拉菜单
//	else{
//		//替换图片为加号
//		div_img.setAttribute("src","img/jiahao.png");
//		div_have.setAttribute("style","height: 0px;overflow:hidden ;");
//	    div_have.style.transition="height 1s";
//		get_div.setAttribute("style","background-color: #282828;");
//	}
//	
//}
////设置第三个
//function testexpand01(){
//	//得到div标题
//	var get_div=document.getElementById("div_middle_left_03");
//	//
//	var div_have=document.getElementById("div_middle_left_03_have");
//	//得到存图片的div
//	var div_img=document.getElementById("div_middle_left_03_img_have");
//	//如果是加号则下拉菜单
//	if(div_img.src.match("jiahao")){
//		//替换图片为减号
//		div_img.setAttribute("src","img/jianhao.png");
//		//设置div标题的样式
//		
//
//	get_div.setAttribute("style","background-color: #DF4D4E;");
//	//改变div大小	
//	var a="overflow:hidden ;width:200px;height:"+(group02.length*40)+"px;";
//	div_have.setAttribute("style",a);
//	div_have.style.transition="height 1s";
//	
//	}
//	//如果是减号则上拉菜单
//	else{
//		//替换图片为加号
//		div_img.setAttribute("src","img/jiahao.png");
//		div_have.setAttribute("style","height: 0px;overflow:hidden ;");
//		div_have.style.transition="height 1s";
//		get_div.setAttribute("style","background-color: #282828;");
//	}
//	
//}
////点击事件
////function $(id){
////	return document.getElementById(id);
////}
////window.onload=function(){
////	$("div_01_0").onclick=function(){
////		document.getElementById("ifrm").src="login.html";
////	}
////}
