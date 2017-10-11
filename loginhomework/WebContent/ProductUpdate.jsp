<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page import="java.util.*,entiry.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/productUpdate.css" />
</head>
<body onload="">
		<div id="div_head"><p id="p1">商品修改</p><p id="p2">如果不需要修改空白即可</p></div>
		<form action="productUpdateServlet" method="get">
		<div id="div_all">
			<!--商品名称-->
			
			<input type="hidden" name="product_id" value="${product.id}"/>
			<div class="div_list">
				<div class="div_list_left">商品名称</div>
				<div class="div_list_right">
					<input name="pname_input" value="${product.pname }" class="div_list01_input" type="text"/><span>*</span>
				</div>
			</div>
			
			
			<div class="div_list">
				<div class="div_list_left">所属类别</div>
				<div class="div_list_right">
					<select name="select_pid" class="div_list_right_select01">
						<option>请选择</option>
						<option>衣服</option>
					</select>
					<select name="select_cid" id="div_list_right_select02">
						<option>请选择</option>
						<c:forEach items="${catelist}" var="i">
						<option value="${i.cid}">
                         <c:out value="${i.cname}"></c:out>
                           </option>
						</c:forEach>
					</select><span>*</span>
				</div>
			</div>
			
			
			<div class="div_list">
				<div class="div_list_left">货号</div>
				<div class="div_list_right">
					<input name="input_pno" value="${product.pno }" class="div_list01_input" type="text"/><span>*</span>
				</div>
			</div>
			
			
			<div class="div_list">
				<div class="div_list_left">规格</div>
				<div class="div_list_right">
					<select name="select_rule" class="div_list_right_select01">
						<option>请选择</option>
						<c:forEach items="${rulelist}" var="i">
						<option value="${i.size}" name="select_rule_value">
                         <c:out value="${i.size}"></c:out>
                           </option>
						</c:forEach>
					</select><span>*</span>
				</div>
			</div>
			
			
			<div class="div_list">
				<div class="div_list_left">上传照片</div>
				<div class="div_list_right">
					<input name="input_pic" class="div_list01_input" type="file"/>
				</div>
			</div>
			
			
			<div class="div_list">
				<div class="div_list_left">商品价格</div>
				<div class="div_list_right">
					<input name="input_price" value="${product.price}" class="div_list01_input" type="text"/><span>*</span>
				</div>
			</div>
			
			
			<div class="div_list">
				<div class="div_list_left">点击数</div>
				<div class="div_list_right">
					<input name="input_click" class="div_list01_input" type="text"/><span>*</span>
				</div>
			</div>
			
			
			<div class="div_list">
				<div class="div_list_left">是否推荐</div>
				<div class="div_list_right">
					
						
					
					<input class="div_list_radio01"  type="radio" name="select"/>
					<p>是</p>
					
					<input class="div_list_radio02" type="radio" name="select"/>
					
					<p>否</p>
					
				</div>
			</div>
			
			
			<div class="div_list">
				<div class="div_list_left">是否特价</div>
				<div class="div_list_right">
					<input class="div_list_radio01"  type="radio" name="select"/>
					<p>是</p>
					
					<input class="div_list_radio02" type="radio" name="select"/>
					
					<p>否</p>
				</div>
			</div>
			
			
			<div class="div_list">
				<div class="div_list_left">是否上线</div>
				<div class="div_list_right">
					<input class="div_list_radio01"  type="radio" name="select_online" value="1"/>
					<p>是</p>
					
					<input class="div_list_radio02" type="radio" name="select_online" value="0"/>
					
					<p>否</p>
				</div>
			</div>
			
			
			<div id="div_pro_des">
				<div id="div_pro_des_left">商品描述</div>
				<div id="div_pro_des_right">
					<input type="text" name="input_detail" id="div_textarea">
						
					</input>
				</div>
			</div>
			<div class="div_list">
				<div id="div_button01">
					<button name="button" value="1">提交</button>
				</div>
				<div id="div_button02">
					<button name="button" value="0">取消</button>
				</div>
			</div>
			
			
			
		</div>
		</form>
	</body>
</html>