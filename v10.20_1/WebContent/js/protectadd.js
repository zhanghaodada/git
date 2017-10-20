var properties=[
                {"name":"商品名称"},
                {"name":"所属类别"},
                {"name":"货号"},
                {"name":"规格"},
                {"name":"上传照片"},
                {"name":"商品价格"},
                {"name":"点击数"},
                {"name":"是否推荐"},
                {"name":"是否特价"},
                {"name":"是否上线"},
                {"name":"商品描述"},
                
//              {"protectclass":"所属类别"},
//              {"number":"货号"},
//              {"norms":"规格"},
//              {"photo":"上传照片"},
//              {"price":"商品价格"},
//              {"clicknumber":"点击数"},
//              {"recommend":"是否推荐"},
//              {"specialoffer":"是否特价"},
//              {"online":"是否上线"},
//              {"description":"商品描述"},
];
//创建二级联动需要的数据
var selectgroup=["=请选择=","衣服","电子产品","动漫周边","食品"];
var selectgroup01=[
                  ["卫衣","裤子","t恤"],
                  ["手机","电脑","其他"],
                  ["周边","漫画周刊"],
                  ["吃的","喝的"],
];
//创建衣服尺码
var clothsize=["衣服尺码","175/75","180/75","170/70"];



function _onload(){
	//得到承载所有的div
	var div_all=document.getElementById("div_all");
	
	for(var i=0;i<properties.length;i++){
		//创建商品名称整行div
		var div_list=document.createElement("div");
		div_list.setAttribute("class","div_list");
		div_all.appendChild(div_list);
		//创建承载商品.......等等的div
		var div_list_leftdiv=document.createElement("div");
		div_list_leftdiv.setAttribute("class","div_list_leftdiv");
		div_list.appendChild(div_list_leftdiv);
		  //创建文本节点
		  var div_list_leftdiv_word=document.createTextNode(properties[i].name);
		  div_list_leftdiv.appendChild(div_list_leftdiv_word);
		  
		  
		  
		  
		  //创建第一行右边div
		  if(i==0){
		  	//创建右边div
		  	var div_list_rightdiv=document.createElement("div");
			div_list_rightdiv.setAttribute("class","div_list_rightdiv");
			div_list.appendChild(div_list_rightdiv);
			//创建input标签
			var rightdiv_input=document.createElement("input");
			rightdiv_input.setAttribute("id","right_div01_input");
			div_list_rightdiv.appendChild(rightdiv_input);
		  	//创建承载*的span
		  	var rightdiv_span=document.createElement("span");
		  	rightdiv_span.setAttribute("id","right_div01_span");
		  	div_list_rightdiv.appendChild(rightdiv_span);
		  	//创建文本节点
		  	var rightdiv_span_word=document.createTextNode("*");
		  	rightdiv_span.appendChild(rightdiv_span_word);
		  	
		  }
		  
		  
		  
		  
		 //创建第二行右边div
	     else if(i==1){
	     	//创建右边div
		  	var div_list_rightdiv=document.createElement("div");
			div_list_rightdiv.setAttribute("class","div_list_rightdiv");
			div_list.appendChild(div_list_rightdiv);
	     	//创建二级联动首选
	     	var rightdiv02_select01=document.createElement("select");
	     	rightdiv02_select01.setAttribute("id","rightdiv02_select01");
	     	rightdiv02_select01.setAttribute("onchange","clickOpt()");
	     	div_list_rightdiv.appendChild(rightdiv02_select01);
	     	for(var j=0;j<selectgroup.length;j++){
	     		//创建option
	     		var rightdiv02_select01_option=document.createElement("option");
	     		rightdiv02_select01_option.setAttribute("value",j);
	     		rightdiv02_select01.appendChild(rightdiv02_select01_option);
	     		//获取文本节点
	     		var rightdiv02_select01_word=document.createTextNode(selectgroup[j]);
	     		rightdiv02_select01_option.appendChild(rightdiv02_select01_word);
	     	}
	     	//创建二级选项
	     	var rightdiv02_select02=document.createElement("select");
	     	rightdiv02_select02.setAttribute("id","child");
	     	div_list_rightdiv.appendChild(rightdiv02_select02);
	     	//创建承载*的span
	     	//创建承载*的span
		  	var rightdiv_span=document.createElement("span");
		  	rightdiv_span.setAttribute("id","right_div01_span");
		  	div_list_rightdiv.appendChild(rightdiv_span);
		  	//创建文本节点
		  	var rightdiv_span_word=document.createTextNode("*");
		  	rightdiv_span.appendChild(rightdiv_span_word);
	     	
	     }
	     
	     
	     
		  //创建第三行右边div
		  else if(i==2){
		  	//创建右边div
		  	var div_list_rightdiv=document.createElement("div");
			div_list_rightdiv.setAttribute("class","div_list_rightdiv");
			div_list.appendChild(div_list_rightdiv);
			//创建input标签
			var rightdiv_input=document.createElement("input");
			rightdiv_input.setAttribute("id","right_div01_input");
			div_list_rightdiv.appendChild(rightdiv_input);
		  	//创建承载*的span
		  	var rightdiv_span=document.createElement("span");
		  	rightdiv_span.setAttribute("id","right_div01_span");
		  	div_list_rightdiv.appendChild(rightdiv_span);
		  	//创建文本节点
		  	var rightdiv_span_word=document.createTextNode("*");
		  	rightdiv_span.appendChild(rightdiv_span_word);
		  }
		  
		  
		  
		  
		  
		  //创建第四行右边div
		  else if(i==3){
		  	//创建右边div
		  	var div_list_rightdiv=document.createElement("div");
			div_list_rightdiv.setAttribute("class","div_list_rightdiv");
			div_list.appendChild(div_list_rightdiv);
	     	//创建二级联动首选
	     	var rightdiv02_select01=document.createElement("select");
	     	rightdiv02_select01.setAttribute("id","rightdiv02_select01");
	     	//rightdiv02_select01.setAttribute("onchange","clickOpt()");
	     	div_list_rightdiv.appendChild(rightdiv02_select01);
	     	for(var j=0;j<clothsize.length;j++){
	     		//创建option
	     		var rightdiv02_select01_option=document.createElement("option");
	     		rightdiv02_select01_option.setAttribute("value",j);
	     		rightdiv02_select01.appendChild(rightdiv02_select01_option);
	     		//获取文本节点
	     		var rightdiv02_select01_word=document.createTextNode(clothsize[j]);
	     		rightdiv02_select01_option.appendChild(rightdiv02_select01_word);
	     	}
	     	//创建承载*的span
		  	var rightdiv_span=document.createElement("span");
		  	rightdiv_span.setAttribute("id","right_div01_span");
		  	div_list_rightdiv.appendChild(rightdiv_span);
		  	//创建文本节点
		  	var rightdiv_span_word=document.createTextNode("*");
		  	rightdiv_span.appendChild(rightdiv_span_word);
		  }
		  //创建第五行右边div
		  else if(i==4){
		  	
		  }
		  //创建第六行右边div
		  else if(i==5){
		  	//创建右边div
		  	var div_list_rightdiv=document.createElement("div");
			div_list_rightdiv.setAttribute("class","div_list_rightdiv");
			div_list.appendChild(div_list_rightdiv);
			//创建input标签
			var rightdiv_input=document.createElement("input");
			rightdiv_input.setAttribute("id","right_div01_input");
			div_list_rightdiv.appendChild(rightdiv_input);
		  	//创建承载*的span
		  	var rightdiv_span=document.createElement("span");
		  	rightdiv_span.setAttribute("id","right_div01_span");
		  	div_list_rightdiv.appendChild(rightdiv_span);
		  	//创建文本节点
		  	var rightdiv_span_word=document.createTextNode("*");
		  	rightdiv_span.appendChild(rightdiv_span_word);
		  }
		  //创建第七行右边div
          else if(i==6){
		//创建右边div
		  	var div_list_rightdiv=document.createElement("div");
			div_list_rightdiv.setAttribute("class","div_list_rightdiv");
			div_list.appendChild(div_list_rightdiv);
			//创建input标签
			var rightdiv_input=document.createElement("input");
			rightdiv_input.setAttribute("id","right_div01_input");
			div_list_rightdiv.appendChild(rightdiv_input);
}
		  //创建第八行右边div
		  else if(i==7){
		  	//创建右边div
		  	var div_list_rightdiv=document.createElement("div");
			div_list_rightdiv.setAttribute("class","div_list_rightdiv");
			div_list.appendChild(div_list_rightdiv);
			//创建按钮只能选一个
			var div_list_rightdiv_div01=document.createElement("div");
			div_list_rightdiv_div01.setAttribute("class","div_list_rightdiv_div01");
			div_list_rightdiv.appendChild(div_list_rightdiv_div01);
			    //创建input
			    var div01_input01=document.createElement("input");
			    div_list_rightdiv_div01.appendChild(div01_input01);
			    div01_input01.setAttribute("type","radio");
			     div01_input01.setAttribute("name","select01");
			
			var div_list_rightdiv_div02=document.createElement("div");
			div_list_rightdiv_div02.setAttribute("class","div_list_rightdiv_div02");
						div_list_rightdiv.appendChild(div_list_rightdiv_div02);
                    //创建文本节点
                    var rightdiv_div02_word00=document.createTextNode("是");
                    div_list_rightdiv_div02.appendChild(rightdiv_div02_word00);
                    
                    
                    

			var div_list_rightdiv_div03=document.createElement("div");
			div_list_rightdiv_div03.setAttribute("class","div_list_rightdiv_div03");
						div_list_rightdiv.appendChild(div_list_rightdiv_div03);
                      //创建input
			    var div01_input02=document.createElement("input");
			    div_list_rightdiv_div03.appendChild(div01_input02);
			    div01_input02.setAttribute("type","radio");
			     div01_input02.setAttribute("name","select01");
			     
			     
			var div_list_rightdiv_div04=document.createElement("div");
			div_list_rightdiv_div04.setAttribute("class","div_list_rightdiv_div04");
						div_list_rightdiv.appendChild(div_list_rightdiv_div04);
                          //创建文本节点
                    var rightdiv_div04_word00=document.createTextNode("否");
                    div_list_rightdiv_div04.appendChild(rightdiv_div04_word00);
                    
		  }
		   //创建九行右边div
		  else if(i==8){
		  	//创建右边div
		  	var div_list_rightdiv=document.createElement("div");
			div_list_rightdiv.setAttribute("class","div_list_rightdiv");
			div_list.appendChild(div_list_rightdiv);
			//创建按钮只能选一个
			var div_list_rightdiv_div01=document.createElement("div");
			div_list_rightdiv_div01.setAttribute("class","div_list_rightdiv_div01");
			div_list_rightdiv.appendChild(div_list_rightdiv_div01);
			    //创建input
			    var div01_input01=document.createElement("input");
			    div_list_rightdiv_div01.appendChild(div01_input01);
			    div01_input01.setAttribute("type","radio");
			     div01_input01.setAttribute("name","select01");
			
			var div_list_rightdiv_div02=document.createElement("div");
			div_list_rightdiv_div02.setAttribute("class","div_list_rightdiv_div02");
						div_list_rightdiv.appendChild(div_list_rightdiv_div02);
                    //创建文本节点
                    var rightdiv_div02_word00=document.createTextNode("是");
                    div_list_rightdiv_div02.appendChild(rightdiv_div02_word00);
                    
                    
                    

			var div_list_rightdiv_div03=document.createElement("div");
			div_list_rightdiv_div03.setAttribute("class","div_list_rightdiv_div03");
						div_list_rightdiv.appendChild(div_list_rightdiv_div03);
                      //创建input
			    var div01_input02=document.createElement("input");
			    div_list_rightdiv_div03.appendChild(div01_input02);
			    div01_input02.setAttribute("type","radio");
			     div01_input02.setAttribute("name","select01");
			     
			     
			var div_list_rightdiv_div04=document.createElement("div");
			div_list_rightdiv_div04.setAttribute("class","div_list_rightdiv_div04");
						div_list_rightdiv.appendChild(div_list_rightdiv_div04);
                          //创建文本节点
                    var rightdiv_div04_word00=document.createTextNode("否");
                    div_list_rightdiv_div04.appendChild(rightdiv_div04_word00);
		  }
		   //创建十行右边div
		   else if(i==9){
		   	//创建右边div
		  	var div_list_rightdiv=document.createElement("div");
			div_list_rightdiv.setAttribute("class","div_list_rightdiv");
			div_list.appendChild(div_list_rightdiv);
			//创建按钮只能选一个
			var div_list_rightdiv_div01=document.createElement("div");
			div_list_rightdiv_div01.setAttribute("class","div_list_rightdiv_div01");
			div_list_rightdiv.appendChild(div_list_rightdiv_div01);
			    //创建input
			    var div01_input01=document.createElement("input");
			    div_list_rightdiv_div01.appendChild(div01_input01);
			    div01_input01.setAttribute("type","radio");
			     div01_input01.setAttribute("name","select01");
			
			var div_list_rightdiv_div02=document.createElement("div");
			div_list_rightdiv_div02.setAttribute("class","div_list_rightdiv_div02");
						div_list_rightdiv.appendChild(div_list_rightdiv_div02);
                    //创建文本节点
                    var rightdiv_div02_word00=document.createTextNode("是");
                    div_list_rightdiv_div02.appendChild(rightdiv_div02_word00);
                    
                    
                    

			var div_list_rightdiv_div03=document.createElement("div");
			div_list_rightdiv_div03.setAttribute("class","div_list_rightdiv_div03");
						div_list_rightdiv.appendChild(div_list_rightdiv_div03);
                      //创建input
			    var div01_input02=document.createElement("input");
			    div_list_rightdiv_div03.appendChild(div01_input02);
			    div01_input02.setAttribute("type","radio");
			     div01_input02.setAttribute("name","select01");
			     
			     
			var div_list_rightdiv_div04=document.createElement("div");
			div_list_rightdiv_div04.setAttribute("class","div_list_rightdiv_div04");
						div_list_rightdiv.appendChild(div_list_rightdiv_div04);
                          //创建文本节点
                    var rightdiv_div04_word00=document.createTextNode("否");
                    div_list_rightdiv_div04.appendChild(rightdiv_div04_word00);
		   }
//		    //创建十一行右边div
//		  else if(i==10){}
		 
	}
	
}


//二级联动
function addOption(val,txt){
	var opt=document.createElement("option");
	opt.text=txt;
	opt.value=val;
	child.options.add(opt);
}
function clickOpt(){
	var partent=document.getElementById("rightdiv02_select01");
	var p_value=partent.value;
	var child=document.getElementById("child");
	var c_length=child.options.length;
	if(c_length>0){
//		for(var i=0;i<c_length;i++){
//			child.options.remove(0);
//		}
    child.options.length=0;
	}
	//alert("ceshi");
	//重新创建自选择像
	if(p_value=="1"){
		for(var i=0;i<selectgroup01[0].length;i++){
			addOption(i,selectgroup01[0][i]);
		}
		
	}
	else if(p_value=="2"){
		for(var i=0;i<selectgroup01[1].length;i++){
			addOption(i,selectgroup01[1][i]);
		}
	}
	else if(p_value=="3"){
		for(var i=0;i<selectgroup01[2].length;i++){
			addOption(i,selectgroup01[2][i]);
		}
	}
	else if(p_value=="4"){
		for(var i=0;i<selectgroup01[3].length;i++){
			addOption(i,selectgroup01[3][i]);
		}
	}
}