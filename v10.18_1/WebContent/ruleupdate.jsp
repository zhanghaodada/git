<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/ruleupdate.css" />
		
	</head>
	<body>
	<form action="ruleupdateservlet" method="get">
		<div id="div_all">
			<div id="div_title"><p>修改规格操作</p></div>
			<div id="div_show"><p>当前规格为:${rule.size}</p></div>
			<div id="div_middle">
				
				<div id="update_word01">更改名称:</div>
				<div id="div_middle_02"><input name="rule_size" type="text" placeholder="请输入修改的规格名称"/></div>
				
			</div>
			<input type="hidden" name="rule_id" value="${rule.id }">
			<div id="div_button">
				<a><div id="div_right"><button type="submit" name="button" value="0">取消</button></div></a>
				<a><div id="div_false"><button type="submit" name="button" value="1">确认</button></div></a>
				
			</div>
		</div>
		</form>
	</body>
</html>