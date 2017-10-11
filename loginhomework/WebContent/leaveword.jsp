<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*,entiry.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
   
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="keywords" content="留言板" />
    <meta name="description" content="留言板" />
    <title>留言板</title>
   
    <link rel="stylesheet" type="text/css" href="css/front.css" />
    <link rel="stylesheet" type="text/css" href="css/guestbook.css" />
    
  </head>
  
  <body onload="directUrl()">
  <form id="myform" >
    <!--页头Begin-->
    <div id="gbook_head"><img border="0" src="img/title.jpg" alt="" /></div>
    <!--页头End-->
    <!--主体Begin-->
    <div id="gbook_content">
    	
		     <% Object obj=request.getAttribute("msgs");
		     if(obj!=null){
		    	pagemodel<leaveword> lw=(pagemodel<leaveword>) obj;
		    	//leaveword lw=(leaveword)obj;
		    	for(int i=0;i<lw.getDatas().size();i++){
		    	%>
		    <!--留言Begin-->
    	<div class="gbook_msg_list">
	     <div class="msg_bar">
		    <div class="gbook_usrname">
			<img src="img/question.gif" border="0" align="absmiddle"/>
			&nbsp;<%=lw.getDatas().get(i).getNikename()%>
			</div>
			<div class="msg_time"><%=lw.getDatas().get(i).getLdatatime() %></div>
			<div class="clear"></div>
		 </div>
		 
		 <div class="msg_content">
		
		    	 
		     
		   <strong>标题：<%=lw.getDatas().get(i).getLtitle()%></strong><br />&nbsp;&nbsp;&nbsp;&nbsp;<%=lw.getDatas().get(i).getLwords() %>&nbsp;
		 
		
		 </div>
		 
		 <div class="reply_content">
		 <img src="img/answer.gif" border="0" align="absmiddle"/>
		 &nbsp;<span class="gbook_answer">为您服务:</span><br />&nbsp;&nbsp;<%=lw.getDatas().get(i).getLaskword() %>
		 </div>
		 <div class="clear"></div>
		 
	 </div>
   <!--留言end-->
   <% }%>
	 
	 <div class="msg_page">
	 
		<div>
	共<%=lw.getTotalcount() %>条记录 <%=lw.getPageno() %>/<%=lw.getTotalPageSize() %>页
	&nbsp;
	<a href="addmessageservlet?reqType=2&pageno=1&pagesize=3" >首页</a>
	<%if(lw.getPageno()>1){ %>
	<a disabled="disabled" href="addmessageservlet?reqType=2&pageno=<%=lw.getPageno()-1 %>&pagesize=3" >上一页</a>&nbsp;
	<%} %>
	<%if(lw.getPageno()<lw.getTotalPageSize()){ %>
	<a href="addmessageservlet?reqType=2&pageno=<%=lw.getPageno()+1 %>&pagesize=3" >下一页</a> 
	<%} %>
	<a href="addmessageservlet?reqType=2&pageno=<%=lw.getTotalPageSize() %>&pagesize=3">尾页</a>
	&nbsp;第<select onChange="self.location.href=options[selectedIndex].value">
  
  <%
           if(lw!=null){
        	   int _totalPageSize=lw.getTotalPageSize();
        	   for(int i=0;i<_totalPageSize;i++){
        	     
        		    if(lw.getPageno()==(i+1)){ %>
        		    	
        		    <option value="<%=i+1 %>" selected="selected"><%=(i+1)%></option>
        		  <%  }else{%>
        			 <option value="addmessageservlet?reqType=2&pageno=<%=i+1 %>&pagesize=3" ><%=(i+1)%></option>
        		  <%}
        	   }
           }
        %>
	</select>页
		</div>
	 </div>
	  <%}%>
	  <input type="hidden" name="type" value="1">
 <!--留言列表End-->
 </form>
 <!--留言表单Begin-->
    <div class="gbook_form">
    <table width="98%" cellspacing="1" cellpadding="0" border="0" bgcolor="#7dbfdb" align="center" style="margin-top: 10px; margin-bottom: 10px;">
      <tbody>
        <tr id="aa_b">
          <td height="25"  bgcolor="#282828" align="left">&nbsp; <img height="12" width="14" border="0" align="absmiddle" src="images/liuyan.gif" alt="" /> <strong>我 要 留 言</strong></td>
        </tr>
        <tr>
          <td height="200" valign="top" bgcolor="#f5f4fa">
          <form id="jvForm" action="addmessageservlet?reqType=1" method="post">
            <table width="98%" cellspacing="0" cellpadding="0" border="0" align="center">
              <tbody>
                <tr>
                  <td height="25" width="108" align="right">昵称：</td>
                  <td width="95" align="left">
                  	<input type="text" name="msg_nickname" minlength="3" vld="{messages:{required:'请填写标题',minlength:'标题不能少于3个字符',maxlength:'标题长度不能超过50个字符'}}" size="30" maxlength="50" id="msg_title" class="required" />
									</td>
                  <td width="60" align="right">邮箱：</td>
                  <td width="484" align="left"><input type="text" name="msg_email" minlength="3" vld="{messages:{required:'请填写标题',minlength:'标题不能少于3个字符',maxlength:'标题长度不能超过50个字符'}}" size="30" maxlength="50" id="msg_title" class="required" /></td>
                </tr>
                <tr>
                  <td align="right">标 题：</td>
                  <td align="left" colspan="3"><input type="text" name="msg_title" minlength="3" vld="{messages:{required:'请填写标题',minlength:'标题不能少于3个字符',maxlength:'标题长度不能超过50个字符'}}" size="50" maxlength="50" id="msg_title" class="required" /></td>
                </tr>
                <tr>
                  <td height="25" align="right">留言内容：</td>
                  <td align="left" colspan="3"><textarea name="msg_content" minlength="5" vld="{messages:{required:'请填写留言内容',minlength:'留言内容不能少于5个字符'}}" cols="70" rows="5" id="msg_content" class="required"></textarea></td>
                </tr>
               <!--  <tr>
                  <td height="30" align="right">验证码：</td>
                  <td align="left"><input type="text" name="msg_checkCode" size="10" title="请输入验证码" id="msg_checkCode" class="required" /></td>
                  <td align="left" colspan="2"></td>
                </tr> -->
                <tr>
                  <td height="30" align="center" colspan="4"><input type="submit" value="提 交" /></td>
                </tr>
              </tbody>
            </table>
          </form>
          <table width="98%" cellspacing="0" cellpadding="0" border="0" align="center">
            <tbody>
              <tr>
                <td align="left" style="line-height: 20px;">&nbsp;&nbsp;1.用户发表留言仅代表其个人意见，并且承担一切因发表内容引起的纠纷和责任;<br />
                &nbsp;&nbsp;2.本站管理人员有权在不通知用户的情况下删除不符合规定的留言信息或留做证据;<br />
                &nbsp;&nbsp;3.请客观的评价您所看到的资讯，提倡就事论事，杜绝漫骂和人身攻击等不文明行为.</td>
              </tr>
            </tbody>
          </table>
          </td>
        </tr>
      </tbody>
    </table>
    </div>
    <!--留言表单End-->
    <div class="clear"></div>
    </div>
    <!--主体End--><!--页脚Begin-->
    <div id="gbook_foot">powered by qjyong copyright &copy; blog.csdn.net/qjyong&nbsp;
</div>
    <!--页脚End-->
  </body>
</html>