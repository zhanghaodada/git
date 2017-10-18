<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="css/myorder.css" />
	</head>
	<body>
		<!--head-->
		<div id="div_head">
			<a href="#"><img id="div_head_img" src="img/logo.png" /></a>
			<div id="div_head_sreach" >
				<input type="text"  />
				<a href="#"><p>搜本店</p></a>
			</div>
			<a href="#"><div id="div_head_list01">待支付</div></a>
			<a href="#"><div id="div_head_list02" >待发货</div></a>
			<a href="#"><div class="div_head_list03">已发货</div></a>
			<a href="#"><div class="div_head_list03">已完成</div></a>
			
		</div>
		
		<!--middle-->
			<div id="div_middle">
				<!--循环区-->
				<div class="middle_list">
					<!--订单编号，订单状态-->
					<div class="list_list01">
						<div class="list01_have01">订单编号:</div>
						<div class="list01_have02">567897654758657463565765876</div>
						
						<div class="list01_have05">下单时间:</div>
						<div class="list01_have06">2017-10-14 09:30</div>
						<div class="list01_have03">订单状态:</div>
						<!--根据传的值是1-->
						<div class="list01_have04">已完成</div>
					</div>
					<!--商品信息-->
					<div class="list_list02">
						<div class="list02_have01">
							<img src="img/list01.png" />
						</div>
						<div class="list02_have02">这是商品的描述</div>
						<div class="list02_have03">x1</div>
						<div class="list02_have04">2399.00</div>
						<!--根据订单状态来 支付订单，取消订单，删除订单-->
						<div class="list02_have05">
							<button>删除订单</button>
						<button>确认收货</button>
						<button>物流信息</button>
						<button>联系卖家</button>
						</div>
						
					</div>
				</div>
				<!--end-->
				
				
				
				<!--循环区-->
				<div class="middle_list">
					<!--订单编号，订单状态-->
					<div class="list_list01">
						<div class="list01_have01">订单编号:</div>
						<div class="list01_have02">567897654758657463565765876</div>
						
						<div class="list01_have05">下单时间:</div>
						<div class="list01_have06">2017-10-14 09:30</div>
						<div class="list01_have03">订单状态:</div>
						<!--根据传的值是1-->
						<div class="list01_have04">已完成</div>
					</div>
					<!--商品信息-->
					<div class="list_list02">
						<div class="list02_have01">
							<img src="img/list01.png" />
						</div>
						<div class="list02_have02">这是商品的描述</div>
						<div class="list02_have03">x1</div>
						<div class="list02_have04">2399.00</div>
						<!--根据订单状态来 支付订单，取消订单，删除订单-->
						<div class="list02_have05">
							<button>删除订单</button>
						<button>确认收货</button>
						<button>物流信息</button>
						<button>联系卖家</button>
						</div>
						
					</div>
				</div>
				<!--end-->
			</div>
	</body>
</html>