<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="css/demo.css">
		<link rel="stylesheet" href="css/app.css">
		<link rel="stylesheet" href="css/frontpage.css" />
		<script type="text/javascript" src="js/frontpage.js" ></script>
	</head>
	<body onload="_onload()">
		<!--head-->
		<div id="div_head">
			<a href="homeservlet"><img id="div_head_img" src="img/logo.png" /></a>
			<div id="div_head_sreach" >
				<input type="text" />
				<a href="#"><p>搜本店</p></a>
			</div>
			<a href="login.jsp"><div id="div_head_list01">亲，请登录</div></a>
			<a href="shoppingdisplaysevlet"><div id="div_head_list02" >购物车0件</div></a>
			<a href="#"><div class="div_head_list03">联系客服</div></a>
			<a href="#"><div class="div_head_list03">服务指南</div></a>
		</div>
		<!--middle-->
		<div id="div_middle">
			<div id="div_middle_left">
				<div id="left_list01"><p>商品类别</p></div>
				
			</div>
			<!--轮播图-->
			
			<div class="slider">

	        <div class="slider-img">
		    <ul class="slider-img-ul">
			<li><img src="img/list005.jpg"></li>
			<li><img src="img/list001.jpg"></li>
			<li><img src="img/list002.jpg"></li>
			<li><img src="img/list003.jpg"></li>
			<li><img src="img/list004.jpg"></li>
			<li><img src="img/list005.jpg"></li>
			<li><img src="img/list001.jpg"></li>
		</ul>
		</div>
	
	   </div>

			<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
			<script type="text/javascript" src="js/xSlider.js"></script>

		</div>
		<!--
        	作者：1052768635@qq.com
        	时间：2017-10-07
        	描述：
        -->
        <div id="div_bottom">
        	<img src="img/111.jpg" />
        </div>
        <!--爆款推荐-->
        <div id="div_sale">
        	
        </div>
	</body>
</html>