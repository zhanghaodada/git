//创建head功能数组
var head=["按消费金额排序","按订单总数排序","按消费日期排序"];
//
//var vip=[
//     [{"caozuo":"操作"},{"vipnumber":"会员ID"},{"viptype":"用户类型"},{"vipname":"用户名"},{"formmoney":"已完成订单金额（元）"},{"formnumber":"已完成订单总数"},{"discount":"折扣积分"},{"newly":"最近消费"}],
//
//     [{"caozuo":""},{"vipnumber":"666"},{"viptype":"终身vip"},{"vipname":"少勇"},{"formmoney":"123"},{"formnumber":"10"},{"discount":"100"},{"newly":"2017-09-30"}],
//     [{"caozuo":""},{"vipnumber":"666"},{"viptype":"终身vip"},{"vipname":"梁家琦"},{"formmoney":"123"},{"formnumber":"10"},{"discount":"100"},{"newly":"2017-09-30"}],
//
//];
var vip=[
       ["操作","会员ID","用户类型","用户名","已完成订单金额（元）","已完成订单总数","折扣积分","最近消费"],

       ["","666","终身vip","少勇","123","10","100","2017-09-30"],
       ["","888","终身vip","家琦","123","10","100","2017-09-30"],
       ["","999","终身vip","云龙兄","123","10","100","2017-09-30"],

];
//
var update=["修改","查看"];


function _onload(){
	var div_head=document.getElementById("div_head");
	for(var i=0;i<head.length;i++){
		var div_head_div=document.createElement("div");
		div_head_div.setAttribute("class","div_head_div");
		div_head.appendChild(div_head_div);
		//创建文本节点
		var div_head_div_word=document.createTextNode(head[i]);
		div_head_div.appendChild(div_head_div_word);
		
	}
	//middle
	var div_middle=document.getElementById("div_middle");
	//创建标题
	//县创建一行的div
	var div_list=document.createElement("div");
	div_list.setAttribute("class","div_list");
	div_middle.appendChild(div_list);
	for(var i=0;i<vip[0].length;i++){
		var div_list_div=document.createElement("div");
		div_list_div.setAttribute("class","div_list_div_class"+i);
		div_list.appendChild(div_list_div);
		//创建文本节点
		var div_list_div_word=document.createTextNode(vip[0][i]);
		div_list_div.appendChild(div_list_div_word);
	}
	//读取数组
	for(var i=1;i<vip.length;i++){
				//middle
			var div_middle=document.getElementById("div_middle");
			//创建标题
			//县创建一行的div
			var div_list=document.createElement("div");
			div_list.setAttribute("class","div_list00");
			div_middle.appendChild(div_list);
		for(var j=0;j<vip[i].length;j++){
			var div_list_div=document.createElement("div");
		        div_list_div.setAttribute("class","div_list_div_class0"+j);
		        div_list.appendChild(div_list_div);
			if(j==0){
				
		        //创建开头的操作
		        var div_list_div_div01=document.createElement("div");
		        div_list_div_div01.setAttribute("class","div_list_div_div01");
		        div_list_div.appendChild(div_list_div_div01);
		        //创建文本节点
		        var word000=document.createTextNode(update[0]);
		        div_list_div_div01.appendChild(word000);
		        
		        //创建开头的操作
		        var div_list_div_div02=document.createElement("div");
		        div_list_div_div02.setAttribute("class","div_list_div_div02");
		        div_list_div.appendChild(div_list_div_div02);
		        //创建文本节点
		        var word001=document.createTextNode(update[1]);
		        div_list_div_div02.appendChild(word001);
		        
				
			}
//		var div_list_div=document.createElement("div");
//		div_list_div.setAttribute("class","div_list_div_class0"+j);
//		div_list.appendChild(div_list_div);
		//创建文本节点
		var div_list_div_word=document.createTextNode(vip[i][j]);
		div_list_div.appendChild(div_list_div_word);
	}
	}
	
	
	
}
