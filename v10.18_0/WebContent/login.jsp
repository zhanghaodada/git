<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/login.css" />
	</head>
	<body>
		<div id="div_all" >
			<a href="frontpage.jsp">
				<div id="div_img"><img src="img/logo.png"/></div>
			</a>
			<form action="loginservlet" method="get">
			<div id="div_have">
				<!--左侧登陆界面-->
				<div id="have_left">
					<p id="left_p">登陆</p>
					<div class="left_login" id="left_name"><p>用户名：</p><input type="text" name="input01" /></div>
					<div class="left_login" id="left_password"><p>密码：</p><input type="text" name="input02" /></div>
					<div id="left_button">
						<input type="checkbox">自动登陆
						<a href="#"><p>忘记密码</p></a>
						<button type="submit" name="button" value="1">登陆</button>
					</div>
				</div>
				<!--右侧注册界面-->
				<div id="have_right">
					<p id="right_p">注册</p>
					<div class="right_res" id="right_name"><p>用户名：</p><input type="text"/></div>
					<div class="right_res" id="right_password"><p>密码：</p><input type="text"/></div>
					<div id="right_button">
						<button type="submit" name="button" value="2">注册</button>
					</div>
				</div>
			
		</div>
		</form>
	</body>
</html>