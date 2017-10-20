$(function(){
	//进入没有登陆状态页面显示的购物车件数
	$.ajax({
		type:"GET",
	    url:"http://localhost:7878/frontpage/productlistsession",
	    success:function(data){
	    	//alert(data);
	    	$("#div_head_list02").html("购物车"+data+"件");
	    }
	});
	
	$(".button03").click(function(){
		//alert($(this).val());
		//没有登陆账号状态下的点击加入购物车更改购物车件数
		$.ajax({
		type:"GET",
	    url:"http://localhost:7878/frontpage/productlistsession?pro_id="+$(this).val(),
	    success:function(data){
	    	//alert(data);
	    	$("#div_head_list02").html("购物车"+data+"件");
	    }
	});
	})
})


//function _onclick(){
//	
//	alert($(".button03").val());
//	$.ajax({
//		type:"GET",
//	    url:"http://localhost:7878/frontpage/productlistsession?pro_id="+$("button[name=butto]").val(val),
//	    success:function(data){
//	    	alert(data);
//	    	$("#div_head_list02").html("购物车"+data+"件");
//	    }
//	});
//}
