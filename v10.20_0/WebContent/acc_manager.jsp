<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>账号信息管理</title>
<link rel="stylesheet" href="css/acc_manager.css" />
		<script type="text/javascript" src="js/jquery-3.2.1.js" ></script>
		<script type="text/javascript" src="js/acc_manager.js" ></script>
		<script>
			$(function(){
//				$("#right_list01").hover(function(){
//					$("#left_list01 p").css({"color":"white","background-color":"#DF4D4E"});
//				
//				},function(){
//					$("#left_list01 p").css({"color":"#282828","background-color":"whitesmoke"});
//				});
				
				$("#right_list02").hover(function(){
					$("#left_list02 p").css({"color":"white","background-color":"#DF4D4E"});
				
				},function(){
					$("#left_list02 p").css({"color":"#282828","background-color":"whitesmoke"});
				});
				$("#right_list03").hover(function(){
					$("#left_list03 p").css({"color":"white","background-color":"#DF4D4E"});
				
				},function(){
					$("#left_list03 p").css({"color":"#282828","background-color":"whitesmoke"});
				});
			})
		</script>
	</head>
	<body>
		<div id="div_all">
			<!--左边-->
			<div id="div_left">
				<div id="left_list01">
					<a href="#"><p>返回首页</p></a>
				</div>
				<div id="left_list02">
					<a href="#"><p>账号管理</p></a>
				</div>
				<div id="left_list03">
					<a href="#"><p>地址管理</p></a>
				</div>
			</div>
			<!--中间装饰-->
			<div id="div_middle">
				<div id="div_img01">
					<img src="img/xuanxiang.png" />
				</div>
				<div id="div_img02">
					<img src="img/xuanxiang.png" />
				</div>
			</div>
			<!--右边-->
			<div id="div_right">
				<!--logo-->
				<div id="right_list01">
					<img src="img/logo.png" />
					
					<div id="list_right">
						<p id="p1">您好，${ca.cname}</p>
						<a><p id="p2">帮助</p></a>
					</div>
				</div>
				<!--账号管理操作-->
				<div id="right_list02">
					<p>请输入要修改的密码</p>
					<input id="input_02" type="password" placeholder="请输入原密码"/>
					<span>*</span>
					<input  class="input_01" type="password" placeholder="请输入修改的密码"/>
					<span>*</span>
					<input class="input_01" type="password" placeholder="请再次输入密码"/>
					<span>*</span>
					<button value="1">确认修改</button>
				</div>
				<!--地址管理操作-->
				
				<div id="right_list03">
					<div id="right_list03_01">
						<p class="list03_p">您当前的地址为：</p>
					<div id="list03_word">${ca.addr}</div>
					
					</div>
					<div id="right_list03_02">
						<p class="list03_p">更改地址：</p>
					</div>
					<div id="right_list03_03">
						
						<select id="select1" >
						
					    </select>
					<select id="select2" >
						
					</select>
					<select id="select3" >
					
					</select>
					</div>
					<div id="right_list03_04">
						<p class="list03_p01">具体地址：</p>
					</div>
					<div id="right_list03_05">
					<input id="reqtype_input" type="hidden" value="${reqtype}">
					
						<input type="text" id="input_address" placeholder="请输入具体地址" />
					<button value="2">确认修改地址</button>
					</div>
					
				</div>
			</div>
		</div>
	</body>
</html>