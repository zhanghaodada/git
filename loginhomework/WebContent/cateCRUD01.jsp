<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="java.util.*,entiry.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/cateCRUD.css" />
</head>
<body>
		<form action="cateCRUDservlet" method="get">
		<div id="div_all">
			<!--添加子类-->
			<% Object obj=request.getAttribute("catelist");
		     if(obj!=null){
		    	 pagemodel<cate> catelist=(pagemodel<cate>) obj;%>
			<div id="div_head">
				<div id="div_head_title"><p>添加父类或子类</p></div>
				<form action="cateCRUDservlet" method="get">
				<div id="div_head_content">
					<div class="div_head_content_have"><input type="text" id="content_input"  name="input_add" placeholder="请输入要添加的子类"/>
					<select id="content_select" name="add_select" >
					<% 
					Object obj01=request.getAttribute("selectlist");
					if(obj01!=null){
					List<cate> cate=(List<cate>)obj01;
					for(int i=0;i<cate.size();i++){%>
						<option name="option_name" value="<%=cate.get(i).getCid() %>"><%= cate.get(i).getCname()%></option>
						
						<%}
					}%>
					</select>
					<button id="content_button01" type="submit" name="add_button" value="1">添加类</button>
					
					</div>
					
				</div>
				</form>
			</div>
			<!--查看或删除或修改子类-->
			<div id="div_middle">
				<!--显示的标题-->
				<div id="div_middle_title02">
					<div class="div_01">ID</div>
					<div class="div_02">名称</div>
					<div class="div_03">父类ID</div>
					
					<div class="div_05">操作</div>
				</div>
				<!--显示的内容一行-->
				<% 
		    	for(int i=0;i<catelist.getDatas().size();i++){
		    	%>
				<div class="div_middle_content">
					<div class="div_011"><%=catelist.getDatas().get(i).getCid() %></div>
					<div class="div_022"><%=catelist.getDatas().get(i).getCname() %></div>
					<div class="div_033"><%=catelist.getDatas().get(i).getPid() %></div>
					
					<div class="div_055" id="div_05_word">
						<a href="cateCRUDservlet?reqType=66&delet_cid=<%=catelist.getDatas().get(i).getCid()%>"><div class="div_delet">删除</div></a>
						<a href="cateUpdateservlet?getcid=<%=catelist.getDatas().get(i).getCid() %>"><div class="div_update">修改</div></a>
						
							
					</div>
				</div>
				<%}%>
				
	<div id="pagemodel">
	共<%=catelist.getTotalcount() %>条记录 <%=catelist.getPageno() %>/<%=catelist.getTotalPageSize() %>页
	&nbsp;
	<a href="cateCRUDservlet?reqType=2&pageno=1&pagesize=10" >首页</a>
	<%if(catelist.getPageno()>1){ %>
	<a disabled="disabled" href="cateCRUDservlet?reqType=2&pageno=<%=catelist.getPageno()-1 %>&pagesize=10" >上一页</a>&nbsp;
	<%} %>
	<%if(catelist.getPageno()<catelist.getTotalPageSize()){ %>
	<a href="cateCRUDservlet?reqType=2&pageno=<%=catelist.getPageno()+1 %>&pagesize=10" >下一页</a> 
	<%} %>
	<a href="cateCRUDservlet?reqType=2&pageno=<%=catelist.getTotalPageSize() %>&pagesize=10">尾页</a>
	&nbsp;第<select onChange="self.location.href=options[selectedIndex].value">
  
  <%
           if(catelist!=null){
        	   int _totalPageSize=catelist.getTotalPageSize();
        	   for(int i=0;i<_totalPageSize;i++){
        	     
        		    if(catelist.getPageno()==(i+1)){ %>
        		    	
        		    <option value="<%=i+1 %>" selected="selected"><%=(i+1)%></option>
        		  <%  }else{%>
        			 <option value="cateCRUDservlet?reqType=2&pageno=<%=i+1 %>&pagesize=10" ><%=(i+1)%></option>
        		  <%}
        	   }
           }
        %>
	</select>页
	<% }%>
		</div>
			</div>
		</div>
		</form>
	</body>
</html>