<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.*,entiry.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/productRule.css" />
</head>
<body>
		<form action="ruleservlet" method="get">
		<div id="div_all">
			<!--添加规格-->
			
			<div id="div_head">
				<div id="div_head_title"><p>添加规格</p></div>
				<div id="div_head_content">
					<div class="div_head_content_have"><input name="input_add" type="text" id="content_input" placeholder="请输入要添加的规格"/>
					
					<button type="submit" name="rule_add" value="1" id="content_button01">添加规格</button>
					<c:if test="${!flag}">
					<span id="div_head_have_span">输入不能为空，不能添加已存在的规格！</span>
					</c:if>
					<c:if test="${flag}">
					<span id="div_head_have_span">添加成功！</span>
					</c:if>
					</div>
					
				</div>
			</div>
			<!--查看或删除或修改子类-->
			<div id="div_middle">
				<!--显示的标题-->
				<div id="div_middle_title02">
					<div class="div_01">ID</div>
					<div class="div_02">商品ID</div>
					<div class="div_03">商品名称</div>
					<div class="div_04">规格</div>
					<div class="div_05">操作</div>
				</div>
				<!--显示的内容一行-->
				<c:forEach items="${productlist.datas}" var="i" varStatus="status">
				<div class="div_middle_content">
					<div class="div_011"><c:out value="${i.id}"></c:out></div>
					<div class="div_022"><c:out value="${i.pid}"></c:out></div>
					<div class="div_033"><c:out value=""></c:out></div>
					<div class="div_044"><c:out value="${i.size}"></c:out></div>
					<div class="div_055" id="div_05_word">
						<a href="ruleservlet?reqType=3&rule_id=${i.id}"><div class="div_delet">删除</div></a>
						<a href="ruleupdateservlet?pname=${i.size}&id=${i.id}"><div class="div_update">修改</div></a>
						
							
					</div>
				</div>
				</c:forEach>
				
	<div id="pagemodel">
	共${productlist.totalcount}条记录 ${productlist.pageno}/${productlist.totalPageSize}页
	&nbsp;
	
	<a href="ruleservlet?reqType=2&pageno=1&pagesize=9" >首页</a>
	<c:if test="${productlist.pageno>1}">
	<a disabled="disabled" href="ruleservlet?reqType=2&pageno=${productlist.pageno-1}&pagesize=9" >上一页</a> &nbsp;
	</c:if>
	
	<c:if test="${productlist.pageno<productlist.totalPageSize}">
	<a href="ruleservlet?reqType=2&pageno=${productlist.pageno+1}&pagesize=9" >下一页</a> 
	
	</c:if>
	
	<a href="ruleservlet?reqType=2&pageno=${ productlist.totalPageSize}&pagesize=9">尾页</a>

	&nbsp;第<select onChange="self.location.href=options[selectedIndex].value">
  
  <% Object obj=request.getAttribute("productlist");
  if(obj!=null){
 	 pagemodel<rule> productlist=(pagemodel<rule>) obj;
           if(productlist!=null){
        	   int _totalPageSize=productlist.getTotalPageSize();
        	   for(int i=0;i<_totalPageSize;i++){
        	     
        		    if(productlist.getPageno()==(i+1)){ %>
        		    	
        		    <option value="<%=i+1 %>" selected="selected"><%=(i+1)%></option>
        		  <%  }else{%>
        			 <option value="ruleservlet?reqType=2&pageno=<%=i+1 %>&pagesize=9" ><%=(i+1)%></option>
        		  <%}
        	   }
           }
           }
           
        %>
	</select>页
		</div>
			</div>
		</div>
		</form>
	</body>
</html>