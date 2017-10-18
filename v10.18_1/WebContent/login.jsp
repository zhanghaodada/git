<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/login.css" type="text/css" />
<style>
#have02_use_span{
	z-index:20;
	position:fixed;
	left: 550px;
	top: 285px;

	width:20px;
	height:40px;
	line-height: 40px;
	font-size: 30px;
	text-align: center;
	color:#df4d4e;
}
</style>
<style>
#have02_psw_span{
	z-index:20;
	position:fixed;
	left: 550px;
	top: 350px;
	
	width:20px;
	height:40px;
	line-height: 40px;
	font-size: 30px;
	text-align: center;
	color:#df4d4e;
}
</style>
<script>
function test_focus01(){
	var span01=document.getElementById("have02_use_span");
	span01.innerHTML="";
}
function test_focus02(){
	var span02=document.getElementById("have02_psw_span");
	span02.innerHTML="";
}
function test_over(){
	var input01=document.getElementById("have02_use");
	var input02=document.getElementById("have02_psw");
	var input001=input01.value;
	var input002=input02.value;
	var span01=document.getElementById("have02_use_span");
	
	var span02=document.getElementById("have02_psw_span");
	
    if(input001.length==0){
    	span01.innerHTML="*";
    }
     if(input001.length!=0){
    	span01.innerHTML="";
    }
    if(input002.length==0){
    	span02.innerHTML="*";
    }
    if(input002.length!=0){
    	span02.innerHTML="";
    }
	
	}
</script>
</head>
<body>
<form action="loginservlet" method="get">
<div id="div_login_all">

 <span id="have02_use_span" ></span>
 <span id="have02_psw_span"></span>
 
	     <div id="div_login_login">
	     	<div id="div_login_have01"><p>登录</p></div>
	     	<div id="div_login_have02">
	     	    
	     		<input id="have02_use" class="have02_input" type="text" name="username" onfocus="test_focus01()" onblur="test_over()" placeholder="请输入用户名！"/>
	     		
	     		<input id="have02_psw" class="have02_input" type="password" onfocus="test_focus02()" onblur="test_over()" name="password" placeholder="请输入密码！"/>
	     			
	     	</div>
	     	<div id="div_login_have03"><input id="have03_input" type="checkbox" name="checkbox" value="1"><span>记住密码</span>
	     		<a href="#" id="have03_a01"><span>忘记密码？</span></a>
	     	<input id="have03_button" type="submit" value="登录"  onmouseover="test_over()"/>
	     	</div>
	     	<input type="hidden" name="type" value="1">
	     	</form>
	     	<form action="" method="get">
	     	<!--右边注册-->
	     	<div id="div_register_have">
	     		<div id="have_word01"><p>注册</p></div>
	     		<div id="have_word02">&nbsp;&nbsp;您若没有账号则需要点击下方注册按钮进行注册！若是忘记密码，请点击左侧忘记密码！</div>
	     	     <!--注册按钮-->
	     	     <div id="div_register_have_button">
	     	     	<button onclick="" >点击注册</button>
	     	     </div>
	     	</div>
	     </div>
	 	
	 </div>
	 </form>
</body>
</html>