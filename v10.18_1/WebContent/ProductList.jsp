<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,entiry.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/productlist.css" />
<script src="js/productlist.js"></script>
</head>
<body onload="_onload()">

<% Object obj=request.getAttribute("productlist");
		     if(obj!=null){
		    	 pagemodel<Product> productlist=(pagemodel<Product>) obj;%>
		<div id="div_all">
			<form>
			<div id="div_head">
				<ul>
					<li><button name="button_link" value="66">添加</button></li>
					<li><button>删除</button></li>
					<li><button>回收站</button></li>
					
				</ul>
				<div id="div_head_right"><input type="text" id="div_head_input" placeholder="请输入要输入的内容！" ><a href="#"><div id="search_div"><img src="img/搜索.png"/></div></a></div>
			</div>
			</form>
			<div id="div_middle">
				
			<div id="div_middle_title">
				<div id="div_miaddle_div01">
					<input type="checkbox"/>
				</div>
				<div id="div_miaddle_div02">编号</div>
				<div id="div_miaddle_div03">名称</div>
				<div id="div_miaddle_div04">价格</div>
				<div id="div_miaddle_div05">上架</div>
				<div id="div_miaddle_div06">操作</div>
			</div>
			
			<c:forEach items="${productlist.datas}" var="i" varStatus="status" >
			
			<!--每一行的设置-->
			<div class="div_miaddle_middle">
				<div class="div_miaddle_div_list011">
					<input type="checkbox"/>
				</div>
				<div class="div_middle_div_list022"><c:out value="${i.pno }"></c:out></div>
				
				
				<div class="div_middle_div_list033">
					<img class="img_hover" src=<c:out value="${i.pic }"></c:out>>
					<p><c:out value="${i.pname} "></c:out></p>
					
					<div class="div_hiddlen" id=<c:out value="div_hiddlen${status.index}"></c:out>><img  src=<c:out value="${i.pic }"></c:out>><div class="div_span">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${i.pdetail }"></c:out></div></div>
				</div>
				
				
				<div class="div_middle_div_list044"><c:out value="${i.price }"></c:out></div>
				<div class="div_middle_div_list055" ><div class="div_img" value=<c:out value="${i.online}"></c:out>></div></div>
				<div class="div_middle_div_list066">
					<a href="ProductServlet?reqType=3&id=${i.id }"><div class="div_delect">删除</div></a>
					<a href="productUpdateServlet?id=${i.id}"><div class="div_update">修改</div></a>
				</div>
			</div>
			<!--每一行设置结束-->
			</c:forEach>
			
			
			
	<div id="pagemodel">
	共${productlist.totalcount}条记录 ${productlist.pageno}/${productlist.totalPageSize}页
	&nbsp;
	
	<a href="ProductServlet?reqType=2&pageno=1&pagesize=9" >首页</a>
	<c:if test="${productlist.pageno>1}">
	<a disabled="disabled" href="ProductServlet?reqType=2&pageno=${productlist.pageno-1}&pagesize=9" >上一页</a> &nbsp;
	</c:if>
	
	<c:if test="${productlist.pageno<productlist.totalPageSize}">
	<a href="ProductServlet?reqType=2&pageno=${productlist.pageno+1}&pagesize=9" >下一页</a> 
	
	</c:if>
	
	<a href="ProductServlet?reqType=2&pageno=${ productlist.totalPageSize}&pagesize=9">尾页</a>

	&nbsp;第<select onChange="self.location.href=options[selectedIndex].value">
  
  <%
           if(productlist!=null){
        	   int _totalPageSize=productlist.getTotalPageSize();
        	   for(int i=0;i<_totalPageSize;i++){
        	     
        		    if(productlist.getPageno()==(i+1)){ %>
        		    	
        		    <option value="<%=i+1 %>" selected="selected"><%=(i+1)%></option>
        		  <%  }else{%>
        			 <option value="ProductServlet?reqType=2&pageno=<%=i+1 %>&pagesize=9" ><%=(i+1)%></option>
        		  <%}
        	   }
           }
           }
        %>
	</select>页
		</div>
			
			
			
			
			
			</div>
		</div>
		
	</body>
</html>