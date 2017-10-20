function _onload(){
	
	
	$.ajax({
		type:"GET",
	    url:"http://localhost:7878/frontpage/shoppingservlet",
	    success:function(data){
	    	//alert(data);
	    	$("#div_head_list02").html("购物车"+data+"件");
	    }
	});
	
	
	
	
	 //利用ajax给电子产品,笔记本赋值
    var xmlhttp;
    if (window.XMLHttpRequest)
      {// code for IE7+, Firefox, Chrome, Opera, Safari
      xmlhttp=new XMLHttpRequest();
      }
    else
      {// code for IE6, IE5
      xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
      }
    //
    
    xmlhttp.open("GET","http://localhost:7878/frontpage/frontpageservlet",true);
    xmlhttp.send();
    //
    
    xmlhttp.onreadystatechange=function()
    {
    if (xmlhttp.readyState==4 && xmlhttp.status==200)
      {//得到类别的值
    	 //alert(xmlhttp.responseText);
   	 var catelist=eval(xmlhttp.responseText);
    
     //给展示页面赋值
   	 var string="";
   	 for(var i=0;i<catelist.length;i++){
   	       
    		
   		 //得到父类div框
   		 var div_par=document.getElementById("div_middle_left");
   		 
   		 //创建类别div 类别有电子产品
   		 var div_list=document.createElement("div");
   		 div_list.setAttribute("class","left_list02");
   		div_list.setAttribute("onmouseover","_onmouseover("+i+")");
   		div_list.setAttribute("onmouseout","_onmouseout("+i+")");
   		 div_par.appendChild(div_list);
   		 //创建承载内容的p标签
   		 var div_list_p1=document.createElement("p");
   		 div_list_p1.setAttribute("class","_pp");
   		 div_list.appendChild(div_list_p1);
   		 var pp=catelist[i];
   	     //创建文本节点
   		string=catelist[i].cname;
   		var list_word=document.createTextNode(string);
   		div_list_p1.appendChild(list_word);
   		 //创建p标签
   		 var div_list_p2=document.createElement("p");
   		div_list_p2.setAttribute("class","_ppp");
   		 div_list.appendChild(div_list_p2);
   		 var list_word02=document.createTextNode(">");
   		div_list_p2.appendChild(list_word02);
   		
   		
   		
   		//创建右边可以隐藏的div
   		var div_items=document.createElement("div");
   		div_items.setAttribute("class","item");
   		div_items.setAttribute("onmouseover","_onmouseover("+i+")");
   		div_items.setAttribute("onmouseout","_onmouseout("+i+")");
   		div_par.appendChild(div_items);
   		//创建承载右边商品类别的div
   		var div_item=document.createElement("div");
   		div_item.setAttribute("class","item_list");
   		var list_word02=document.createTextNode(string);
   		div_item.appendChild(list_word02);
   		div_items.appendChild(div_item);
   		//通过for循环将最后一层的商品类别写出来
   		for(var j=0;j<catelist[i].catelist.length;j++){
   			//创建a标签
   			var aa=document.createElement("a");
   			aa.setAttribute("href","productdisplaysevlet?cate_cid="+catelist[i].catelist[j].cid);
   			div_items.appendChild(aa);
   			//创建承载华为小米等等div
   			var aa_div=document.createElement("div");
   			aa_div.setAttribute("class","item_list_list");
   			aa.appendChild(aa_div);
   			//创建文本节点
   			var aa_div_word=document.createTextNode(catelist[i].catelist[j].cname);
   			aa_div.appendChild(aa_div_word);
   			
   		}
   		
   		
   	 }
    
   	 
   	 
      }
    }
	
    //得到电子产品这个父类给他加上鼠标移动事件
//    var list=document.getElementsByClassName("left_list02");
//    var item=document.getElementsByClassName("item");
//    
//    for(var i=0;i<list.length;i++){
//    	list[i].setAttribute("onmouseover","_onmouseover("+i+")");
//    	list[i].setAttribute("onmouseout","_onmouseout("+i+")");
//    }
//	
	


     
}
//鼠标移动事件
function  _onmouseover(i){
	var item=document.getElementsByClassName("item");
	item[i].style.opacity=1;
	item[i].style.zIndex=20;
}
//鼠标移出事件
function _onmouseout(i){
	var item=document.getElementsByClassName("item");
	item[i].style.opacity=0;
	item[i].style.zIndex=-20;
}
