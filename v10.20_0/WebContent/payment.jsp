<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.*,entity.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>dp官方旗舰店-支付页面</title>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="js/payment.js"></script>
<link rel="stylesheet" href="css/payment.css" />
	</head>
	<body>
		<div id="div_all">
			<div id="div_head">
				<a href="homeservlet"><div id="head_title"><img src="img/logo.png"/></div></a>
				<!--<span id="head_have">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>></span>-->
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
			<form action="paymentservlet" method="GET">
			<!--中间部分-->
			<div id="div_middle">
			
			
			<!-- 订单确认 -->
			<div id="order_title">
			请确认订单信息！
			</div>
			<div id="order_have">
			<c:forEach items="${new_pro}" var="i">
			    <!-- 循环区 -->
			    <div class="order_list">
			         <div class="order_list01"><c:out value="${i.pname}"></c:out></div>
			           <div class="order_list02"><c:out value="${i.number}"></c:out></div>
			            <div class="order_list03"><c:out value="${i.price*i.number}"></c:out></div>
			    </div>
			    <!-- end -->
			    </c:forEach>
			</div>
			
			
                <!--确认地址信息-->
                <div id="addr_title">
                	请确认地址信息！
                </div>
                <div id="addr_addr">
                	<div id="div_01">地址：</div>
                	<div id="div_02">${ca.addr}</div>
                	<a href="acc_managerservlet?reqtype=1"><div id="div_03"> 更改地址</div></a>
                </div>
                  <!--添加备注-->
                
                	<div id="mask_title">
                		请填写备注！
                	</div>
                	<div id="mask_have">
                		<input type="text" name="input_mask" />
                	</div>
                
                
                <!--支付方式-->
                <div id="pay_title">
                	请选择支付方式!
                </div>
                <div id="pay_have">
                	<div class="list">
                		<a href="#"><div class="list_list"><div class="list01"></div><div class="list_con">建设银行</div></div></a>
                			<a href="#"><div class="list_list"><div class="list01"></div><div class="list_con">农业银行</div></div></a>
                			<a href="#"><div class="list_list"><div class="list01"></div><div class="list_con">工商银行</div></div></a>
                			<a href="#"><div class="list_list"><div class="list01"></div><div class="list_con">招商银行</div></div></a>
                			<a href="#"><div class="list_list"><div class="list01"></div><div class="list_con">更多</div></div></a>
                		
                	</div>
                	<div  class="list">
                		<a href="#"><div class="list_list"><div class="list01"></div><div class="list_con">支付宝</div></div></a>
                			<a href="#"><div class="list_list"><div class="list01"></div><div class="list_con">微信支付</div></div></a>
                			<a href="#"><div class="list_list"><div class="list01"></div><div class="list_con">财付通</div></div></a>
                			<a href="#"><div class="list_list"><div class="list01"></div><div class="list_con">更多</div></div></a>
                	</div>
                	<div  class="list">
                		<a href="#"><div class="list_list"><div class="list01"></div><div class="list_con">账户余额</div></div></a>
                			<a href="#"><div class="list_list"><div class="list01"></div><div class="list_con">更多</div></div></a>
                	</div>
                </div>
                <!--zhifuwancheng-->
                
                	<button type="submit" id="div_bottom_a">
                			支付完成&nbsp;√
                	</button>
                		
                		
                	
                
			</div>
			
			
			
				
			</div>
			</form>
			</div>
	</body>
</html>