<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
       <link rel="stylesheet" href="css/index.css"/>
		<script src="js/index.js"></script>
		 <script language="javascript" src="js/index.js" charset="utf-8"></script>
</head>
<body onload="init()">
		<!--第一部分-->
		<div id="head_div">
			<div id="head_div_leftdiv" ><img src="img/logo.png"/></div>
			<div id="head_div_rightdiv">
			<ul>
				<a href="#"><li class="head_li">状态</li></a>
				<a href="#"><li class="head_li">订单</li></a>
				<a href="#"><li class="head_li">报表</li></a>
				<a href="#"><li class="head_li">设置</li></a>
				<a href="#"><li class="head_li">消息</li></a>
			</ul>
			<!--搜索部分-->
			<div id="div01_search"><input type="text" placeholder="请输入要搜索的内容！"/></div>
			</div>
			
		</div>
		<div id="div_02">
		<!--第二部分左边-->
		<div id="div_middle_left">
			<!--左侧选项-->
			
		</div>
		<!--中部右边-->
		<div id="div_middle_right">
			<!--<button id="div_01_0" onclick="javascript:document.getElementById('ifrm').src='login.html';">点击一下</button>-->
			 <iframe src="" name="ifrm" id="ifrm" width="1130" height="550"></iframe>
		</div>
		</div>
	</body>
</html>