<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,entiry.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/account_consumer.css" />
	</head>
	<body>
		<form>
			<div id="div_all">
			<div id="div_head">
				<button id="head_button">返回</button>
				<div id="head_word">
					<p>注册人数为:</p>
					<p>232254</p>
				</div>
			</div>
		</form>
		
			<div id="div_middle">
				<!--标题-->
				<div id="middle_list">
					<div class="list01">会员id</div>
					<div class="list02">账号</div>
					<div class="list03">密码</div>
					<div class="list04">注册时间</div>
					<div class="list05">最近登陆</div>
					<div class="list06">ip地址</div>
					
				</div>
				<!--可以循环的-->
				<c:forEach items="${ac}" var="i">
				<div class="list">
					<div class="list01"><c:out value="${i.id }"></c:out></div>
					<div class="list02"><c:out value="${i.loginname}"></c:out></div>
					<div class="list03"><c:out value="${i.password}"></c:out></div>
					<div class="list04"><c:out value="${i.registertime}"></c:out></div>
					<div class="list05"><c:out value="${i.lastlogintime}"></c:out></div>
					<div class="list06"><c:out value="${i.ip}"></c:out></div>
					
				</div>
				</c:forEach>
			</div>
			
		</div>
	</body>
</html>