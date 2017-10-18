package loginservice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import dao.DaoFactory;
import dao.leaveworddao;
import entiry.leaveword;
import entiry.pagemodel;
import impl.leavewordImpl;

public class leavewordservice {
	
	//添加留言
   public boolean testinsert(leaveword lw) {
	   leaveworddao logdao01=DaoFactory.getInstance("leavewordDao",leavewordImpl.class);
		boolean flag=logdao01.testinsert(lw);
		return flag;
		
   }
   //修改解答
   public boolean testinsertaskword(leaveword lw) {
	   leaveworddao logdao01=DaoFactory.getInstance("leavewordDao",leavewordImpl.class);
       boolean flag=logdao01.testinsertaskword(lw);
	   return flag;
   }
   //查询列表
   public List<leaveword> sreachall(){
	   leaveworddao logdao01=DaoFactory.getInstance("leavewordDao",leavewordImpl.class);
	   List<leaveword> leavewordlist=logdao01.sreachall();
	   
	   for(int i=0;i<leavewordlist.size();i++) {
			System.out.println(leavewordlist.get(i));
		}
	   return leavewordlist;
   }
   //分页查询
   public  pagemodel<leaveword> getpagemodel(int pageno,int pagesize) {
	   leaveworddao logdao01=DaoFactory.getInstance("leavewordDao",leavewordImpl.class);
	   pagemodel<leaveword> pagemodel=logdao01.getpagemodel(pageno,pagesize);
	   return pagemodel;
   }
   
   //分页查询方法
   public void getMsgsLogic(ServletRequest request,ServletResponse response) {
	    //从网页的标签获取
	   String pageno=request.getParameter("pageno");
		String pagesize=request.getParameter("pagesize");
		
		try {
			int _pageNo=Integer.parseInt(pageno);
			int _pageSize=Integer.parseInt(pagesize);
			//可以直接设置为第一页，加载五条数据
//			int _pageNo=1;
//     		int _pageSize=3;
			System.out.println("zheshileavewordserver");
			pagemodel<leaveword>  msgs=getpagemodel(_pageNo,_pageSize);
			if(msgs!=null) {
				int totalPageSize= (msgs.getTotalcount()%_pageSize==0?msgs.getTotalcount()/_pageSize:msgs.getTotalcount()/_pageSize+1);
				msgs.setTotalPageSize(totalPageSize);
				msgs.setPageno(_pageNo);
			}
			
			request.setAttribute("msgs", msgs);
			try {
				request.getRequestDispatcher("leaveword.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
 //首页显示
   public void getshow(ServletRequest request,ServletResponse response) {
	  
		
		try {
			
			//可以直接设置为第一页，加载3条数据
			int _pageNo=1;
     		int _pageSize=3;
			System.out.println("zheshileavewordserver");
			pagemodel<leaveword>  msgs=getpagemodel(_pageNo,_pageSize);
			if(msgs!=null) {
				int totalPageSize= (msgs.getTotalcount()%_pageSize==0?msgs.getTotalcount()/_pageSize:msgs.getTotalcount()/_pageSize+1);
				msgs.setTotalPageSize(totalPageSize);
				msgs.setPageno(_pageNo);
			}
			
			request.setAttribute("msgs", msgs);
			try {
				request.getRequestDispatcher("leaveword.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
   }
   
   
   
   
   
   
   
}
