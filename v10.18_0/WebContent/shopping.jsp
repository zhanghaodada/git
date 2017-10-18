<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.*,entity.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/shopping.css" />
<script type="text/javascript" src="js/jquery-3.2.1.js" ></script>
<script type="text/javascript" src="js/shopping.js" ></script>
	</head>
	<body>
		<div id="div_all">
			<div id="div_head">
				<div id="head_title">我的购物车</div>
				<!--buzhou-->
				<div id="div_step01">
					<div class="step_word01">1</div> 
					<div class="step_word02">我的购物车</div>
				</div>
				<div id="div_step02">
					<div class="step_word01">2</div>
					<div class="step_word02">确认信息并支付</div>
				</div>
				
			</div>
			<div id="div_middle">
				
				<!--biaoti-->
				<div id="middle_title">
					<div>全选</div>
					<div style="width: 350px;" >商品</div>
					<div>规格</div>
					<div>单价</div>
					<div>数量</div>
					<div>总计</div>
					<div>操作</div>
					
				</div>
				
				<c:forEach items="${productlist}" var="i">
				<!--循环区-->
				<div class="div_list" >
					<div class="div00">
						<input type="checkbox" />
					</div>
					<div style="width: 350px;" ><c:out value="${i.pname}"></c:out></div>
					<div><c:out value="${i.size}"></c:out></div>
					<div><c:out value="${i.price}"></c:out>0</div>
					<div>
						<div class="middle_have">
							<button class="middle_button01" value="${i.id}">-</button>
							<input class="inputt" type="text"  value="${i.number}"/>
							<button class="middle_button02" value="${i.id}">+</button>
						</div>
					</div>
					<div><c:out value="${i.number*i.price}"></c:out>0</div>
					<div>
						<button class="butto" value="${i.id}">删除</button>
					</div>
				</div>
				</c:forEach>
				
				
				
				
				
				
			</div>
			<!--底部提交订单区-->
			<div id="div_bottom">
				<!---->
				<form action="homeservlet" method="GET">
              				<div id="bottom_left">
              					<div class="bottom_left_left">
              						<input type="checkbox" /><p>全选</p>
              						<a><div>删除选中的商品</div></a>
              						
              					</div>
              					
              					<div class="bottom_left_left">
              						<button type="submit" >继续购物</button>
              					</div>
              				</div>
              		</form>
              				<!---->
              				<div id="bottom_right">
              					<div>
              						<p>商品总数：</p>
              						<span id="bottom_span">${total_num}</span>
              					</div>
              					<div>
              						<p>运费：</p>
              						<span>￥0.00</span>
              					</div>
              					<div>
              						<p>总金额：</p>
              						<span id="bottom_span01">${total_price}.00</span>
              					</div>
              					<div id="div_butt">
              						<a href="orderservlet"><div>确认订单&nbsp;&nbsp;&nbsp;&nbsp;></div></a>
              					</div>
              				</div>
			</div>
		</div>
		
	</body>
</html>