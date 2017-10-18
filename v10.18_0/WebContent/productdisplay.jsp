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
<link rel="stylesheet" href="css/productdisplay.css" />
<script type="text/javascript" src="js/jquery-3.2.1.js" ></script>
<script type="text/javascript" src="js/productdisplay.js" ></script>
	</head>
	<body>
		<!--head-->
		<div id="div_head">
			<a href="homeservlet"><img id="div_head_img" src="img/logo.png" /></a>
			<div id="div_head_sreach" >
				<input type="text"  />
				<a href="#"><p>搜本店</p></a>
			</div>
			<a href="login.jsp"><div id="div_head_list01">亲，请登录</div></a>
			<a href="shoppingdisplaysevlet"><div id="div_head_list02" >购物车0件</div></a>
			<a href="#"><div class="div_head_list03">联系客服</div></a>
			<a href="#"><div class="div_head_list03">服务指南</div></a>
		</div>
		<!--中间部分-->
		
		<div id="div_middle" >
			
			
			
			<c:forEach items="${productlist.datas}" var="i">
			<div class="div_div_list">
				<!--每个商品div-->
			<div class="div_list">
					<!--承载图片的div-->
					<div class="div_img">
						<img src="img/list01.png">
						
					</div>
					<!--承载价格的div-->
					<div class="div_price">
						<p>￥<c:out value="${i.price}"></c:out></p>
					</div>
					<!--承载描述的div-->
					<div class="div_dec">
						<p><c:out value="${i.pdetail}"></c:out></p>
					</div>
					<!--承载操作的div-->
					<div class="div_make">
						<div class="make_left">
							
						</div>
						
						<button class="button03" name="butto" value="${i.id}" >加入购物车</button>
					</div>
			   </div>
			</div>
			</c:forEach>
			
			<input type="hidden" name="value_have" value="${pro_pid}"/>
			<div id="pagemodel">
	共${productlist.totalcount}条记录 ${productlist.pageno}/${productlist.totalPageSize}页
	&nbsp;
	
	<a href="productdisplaysevlet?reqType=2&pageno=1&pagesize=8&value_have=${pro_pid}" >首页</a>
	<c:if test="${productlist.pageno>1}">
	<a disabled="disabled" href="productdisplaysevlet?reqType=2&pageno=${productlist.pageno-1}&pagesize=8&value_have=${pro_pid}" >上一页</a> &nbsp;
	</c:if>
	
	<c:if test="${productlist.pageno<productlist.totalPageSize}">
	<a href="productdisplaysevlet?reqType=2&pageno=${productlist.pageno+1}&pagesize=8&value_have=${pro_pid}" >下一页</a> 
	
	</c:if>
	
	<a href="productdisplaysevlet?reqType=2&pageno=${ productlist.totalPageSize}&pagesize=8&value_have=${pro_pid}">尾页</a>

	&nbsp;第<select onchange="self.location.href=options[selectedIndex].value">
  		
  		<c:forEach begin="0" end="${productlist.totalPageSize-1}" step="1" var="i" >
  		<c:choose>
  		<c:when test="${productlist.pageno==i+1 }">
  			<option value="productdisplaysevlet?reqType=2&pageno=${i+1} }&pagesize=8&value_have=${pro_pid}" selected="selected">${i+1}</option>
  		</c:when>
  		<c:otherwise>
  		<option value="productdisplaysevlet?reqType=2&pageno=${i+1}&pagesize=8&value_have=${pro_pid}" >${i+1}</option>
  		</c:otherwise>	
		</c:choose>
		</c:forEach>
		</select>页
		</div>
			
			
			
			
		</div>
		
	</body>
</html>