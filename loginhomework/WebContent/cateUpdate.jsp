<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="java.util.*,entiry.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/cateupdate.css" />
</head>
<body>
<%Object obj=request.getAttribute("selectlist");
Object obj_cid=request.getAttribute("getcid");
if(obj!=null){
	if(obj_cid!=null){
	 List<cate> catelist=(List<cate>) obj;
	 int getcid=(Integer)obj_cid;
	 request.setAttribute("getcid_val", getcid);
	 String getcname="as";
	 for(int i=0;i<catelist.size();i++){
		 if(catelist.get(i).getCid()==getcid){
			 getcname=catelist.get(i).getCname();
		    }
	 }
	 
	 %>
	 <form action="cateUpdateservlet" method="get">
	<input type="hidden" name="getcid_val" value="${getcid}"/>
		<div id="div_all">
			<div id="div_title"><p>修改类操作</p></div>
			<div id="div_show"><p>当前类为:<%=getcname%></p></div>
			<div id="div_middle">
				
				<div id="update_word01">更改名称:</div>
				<div id="div_middle_02"><input type="text" placeholder="请输入修改的名称" name="update_input"/></div>
				<div id="update_word02">更改父类:</div>
				<div id="div_middle_04"><select id="" name="select_partent">
				<%for(int i=0;i<catelist.size();i++){ %>
				<option value="<%=catelist.get(i).getCid()%>"><%=catelist.get(i).getCname() %></option>
				<%} %>
				</select></div>
			</div>
			
			<div id="div_button">
				<div id="div_right"><button type="submit" name="button_name" value="false">取消</button></div>
				<div id="div_false"><button type="submit" name="button_name" value="true">确认</button></div>
				
			</div>
		</div>
		</form>
		<%} 
		}%>
	</body>
</html>