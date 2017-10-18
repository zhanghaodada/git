$(function(){
	//购物车页面点击减号数量减一
	$(".middle_button01").click(function(){
		//得到商品的Id
		var pro_id=$(this).val();
		//得到该点击对象
		var bto=$(this);
		
		if(bto.next().val()>0){
			//点击会修改session值
			$.ajax({
				type:"GET",
				url:"http://localhost:7878/frontpage/numberservlet?type=1&pro_id="+pro_id,
				success:function(data){
					//得到是否完成修改 data为true则是成功
					if(data){
						bto.next().val(bto.next().val()-1);
						//列表里的商品价格会变化
						bto.parent().parent().next().html(bto.next().val()*bto.parent().parent().prev().html()+".00");
						//总价会跟着变化
						$("#bottom_span01").html(parseInt($("#bottom_span01").html())-parseInt(bto.parent().parent().prev().html())+".00");
						//总数会跟着变化啊
						$("#bottom_span").html($("#bottom_span").html()-1);
					}
					
				}
			});
		
			
		}
		
		
	});
	//购物车页面，点击加号数量加一，
	$(".middle_button02").click(function(){
		//得到商品的Id
		var pro_id=$(this).val();
		//得到该点击对象
		var bto=$(this);
		
		if(parseInt(bto.prev().val())>=0){
			//点击会修改session值
			$.ajax({
				type:"GET",
				url:"http://localhost:7878/frontpage/numberservlet?type=2&pro_id="+pro_id,
				success:function(data){
					//得到是否完成修改 data为true则是成功
					if(data){
						var num=bto.prev().val();
						bto.prev().val(parseInt(num)+1);
						//列表里的商品价格会变化
						bto.parent().parent().next().html(bto.prev().val()*bto.parent().parent().prev().html()+".00");
						//总价会跟着变化
						$("#bottom_span01").html(parseInt($("#bottom_span01").html())+parseInt(bto.parent().parent().prev().html())+".00");
						//总数会跟着变化啊
						$("#bottom_span").html(parseInt($("#bottom_span").html())+1);
					}
					
				}
			});
			
		
		}
	});
	
	
	
	
	
	
	//给删除的点击事件
	$(".butto").click(function(){
//		$(this).parent().parent().css({
//			"opacity":"0",
//			"transition":"1s",
//			
//		})
		//$(this).parent().parent().height(0);	
		//得到商品的id
		var pro_id=$(this).val();
		var del=$(this);
		
		$.ajax({
			
			type:"GET",
			url:"http://localhost:7878/frontpage/deleteshopping?pro_id="+pro_id,
			data:del,
			success:function(data){
				//根据得到的是否删除的判断值来进行删除父类
				if(data){
					
					del.parent().parent().remove();
				}
			}
		});
		
	});

});