package loginservice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import dao.DaoFactory;
import dao.catedao;
import dao.leaveworddao;
import entiry.cate;
import entiry.leaveword;
import entiry.pagemodel;
import impl.cateImpl;
import impl.leavewordImpl;

public class cateservice {
	public static void main(String[] args) {
	//sreachall();
//		cate cate=new cate(666,"新添加的食品子类",103);
//		insertcate(cate);
	}
	
	 //查询列表
	   public static  List<cate> sreachall(){
		   catedao catedao01=DaoFactory.getInstance("cateDao",cateImpl.class);
		   List<cate> catelist=catedao01.sreachall();
		   
//		   for(int i=0;i<catelist.size();i++) {
//				System.out.println(catelist.get(i));
//			}
		   return catelist;
	   }
	   //增加方法
	   public static boolean insertcate(cate cate) {
		   catedao catedao01=DaoFactory.getInstance("cateDao",cateImpl.class);
		   boolean flag=catedao01.insertcate(cate);
		   return flag;
	   }
	   //修改商品的名称，pid
	   public boolean updatecate(cate cate) {
		   catedao catedao01=DaoFactory.getInstance("cateDao",cateImpl.class);
		   boolean flag=catedao01.updatecate(cate);
		   return flag;
	   }
	   //删除
		public void delRegion(Integer cid) {
			   catedao catedao01=DaoFactory.getInstance("cateDao",cateImpl.class);

			   catedao01.delRegion(cid);
		}
	   
	   //分页查询
	 //分页查询
	   public  pagemodel<cate> getpagemodel(int pageno,int pagesize) {
		   catedao logdao01=DaoFactory.getInstance("cateDao",cateImpl.class);
		   pagemodel<cate> pagemodel=logdao01.getpagemodel(pageno,pagesize);
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
//				int _pageNo=1;
//	     		int _pageSize=3;
				System.out.println("zheshileavewordserver");
				pagemodel<cate>  msgs=getpagemodel(_pageNo,_pageSize);
				if(msgs!=null) {
					int totalPageSize= (msgs.getTotalcount()%_pageSize==0?msgs.getTotalcount()/_pageSize:msgs.getTotalcount()/_pageSize+1);
					msgs.setTotalPageSize(totalPageSize);
					msgs.setPageno(_pageNo);
				}
				
				request.setAttribute("catelist", msgs);
				try {
					request.getRequestDispatcher("cateCRUD01.jsp").forward(request, response);
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
	     		int _pageSize=10;
				System.out.println("zheshileavewordserver");
				pagemodel<cate>  msgs=getpagemodel(_pageNo,_pageSize);
				if(msgs!=null) {
					int totalPageSize= (msgs.getTotalcount()%_pageSize==0?msgs.getTotalcount()/_pageSize:msgs.getTotalcount()/_pageSize+1);
					msgs.setTotalPageSize(totalPageSize);
					msgs.setPageno(_pageNo);
				}
				
				
				cateservice cs=new cateservice();
				List<cate> selectlist=cs.sreachall();
				
				
				request.setAttribute("selectlist",selectlist );
				request.setAttribute("catelist", msgs);
				try {
					request.getRequestDispatcher("cateCRUD01.jsp").forward(request, response);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}catch(NumberFormatException e) {
				e.printStackTrace();
			}
			
	   }
	   
	   
}
