<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,entiry.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/orderinfo.css" />
	</head>
	<body>
	<% Object obj=request.getAttribute("orderlist");
  if(obj!=null){%>
		<!---->
		<div id="div_all">
			<!--头部-->
			<form action="orderservlet" method="get">
			<div id="div_head">
				<div class="div_head_list"><button type="submit" name="button" value="5">全部订单</button></div>
				<div class="div_head_list"><button type="submit" name="button" value="1">待支付</button></div>
				<div class="div_head_list"><button type="submit" name="button" value="2">已付款</button></div>
				<div class="div_head_list"><button type="submit" name="button" value="3">已发货</button></div>
				<div class="div_head_list"><button type="submit" name="button" value="4">已完成</button></div>
				<div id="div_head_right"><input type="text" id="div_head_input" placeholder="请输入要输入的内容！" ><a href="#"><div id="search_div"><img src="img/搜索.png"/></div></a></div>
             <input type="hidden" name="value_have" value="${button_value}"/>
			</div>
			</form>
			<!--中部-->
			<div id="div_middle" >
			<c:forEach items="${orderlist.datas}" var="i">
				<!--每一个小div-->
				<div class="div_middle_have" >
					<div class="middle_head"><p>订单信息</p></div>
					
						<div class="pro_name"><p>订单编号：</p><c:out value="${i.orderlist[0].orderno}"></c:out></div>
						<div class="pro_pno"><p>商品数量：</p><c:out value="${fn:length(i.productlist)}"></c:out></div>
				
					<div class="middle_middle"><p>收货信息</p></div>
					<div class="pro_name"><p>收货人：</p><c:out value="${i.orderlist[0].ca[0].cname}"></c:out></div>
						<div class="pro_pno"><p>联系方式：</p><c:out value="${i.orderlist[0].ca[0].phone}"></c:out></div>
					
					<div class="middle_bottom"><p class="middle_bottom_p">订单状态：</p><p class="word01"><c:out value="${i.orderlist[0].orderstatusname}"></c:out></p></div>
					<a href="orderdisplayservlet?order_id=${i.orderid}&pageno=${orderlist.pageno}&pagesize=8&sreachtype=${button_value}"><div class="middle_a">查看详情</div></a>
				
				</div>
				</c:forEach>
				
				<div id="pagemodel">
	共${orderlist.totalcount}条记录 ${orderlist.pageno}/${orderlist.totalPageSize}页
	&nbsp;
	
	<a href="orderservlet?reqType=2&pageno=1&pagesize=8&value_have=${button_value}" >首页</a>
	<c:if test="${orderlist.pageno>1}">
	<a disabled="disabled" href="orderservlet?reqType=2&pageno=${orderlist.pageno-1}&pagesize=8&value_have=${button_value}" >上一页</a> &nbsp;
	</c:if>
	
	<c:if test="${orderlist.pageno<orderlist.totalPageSize}">
	<a href="orderservlet?reqType=2&pageno=${orderlist.pageno+1}&pagesize=8&value_have=${button_value}" >下一页</a> 
	
	</c:if>
	
	<a href="orderservlet?reqType=2&pageno=${ orderlist.totalPageSize}&pagesize=8&value_have=${button_value}">尾页</a>

	&nbsp;第<select onChange="self.location.href=options[selectedIndex].value">
  
  <%
  
 	 pagemodel<order> orderlist=(pagemodel<order>) obj;
           if(orderlist!=null){
        	   int _totalPageSize=orderlist.getTotalPageSize();
        	   for(int i=0;i<_totalPageSize;i++){
        	     
        		    if(orderlist.getPageno()==(i+1)){ %>
        		    	
        		    <option value="<%=i+1 %>" selected="selected"><%=(i+1)%></option>
        		  <%  }else{%>
        			 <option value="orderservlet?reqType=2&pageno=<%=i+1 %>&pagesize=8&value_have=${button_value}" ><%=(i+1)%></option>
        		  <%
        		  }
        	   }}
           }
           
        %>
	</select>页
		</div>
			</div>
		</div>
	</body>
</html>