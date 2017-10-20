package service;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoFactory;
import dao.productdao;

import entity.*;
import impl.*;
import servlet.productdisplaysevlet;


public class productservice {
//	public static void main(String[] args) {
//		System.out.println(sreachbyid(27001));
//	}
	
	//根据id查询商品信息
	public  Product sreachbyid( int id) {
		productdao dao01=DaoFactory.getInstance("productDao",productimpl.class);
		   Product pro=dao01.sreachbyid(id);
		   return pro;
	}
	//分页查询待支付。。。。等等订单
	public  pagemodel<Product> getpagemodel01(int pageno,int pagesize,int sreachtype) {
		productdao dao01=DaoFactory.getInstance("productDao",productimpl.class);
		   pagemodel<Product> pagemodel=dao01.getpagemodel01(pageno,pagesize,sreachtype);
		   return pagemodel;
	}

	//分页查询方法
	public void getMsgsLogic01(ServletRequest request,ServletResponse response) {
		    //从网页的标签获取
		   String pageno=request.getParameter("pageno");
			String pagesize=request.getParameter("pagesize");
			String value_have=request.getParameter("value_have");
			request.setAttribute("pro_pid",value_have);
			
			try {
				int _pageNo=Integer.parseInt(pageno);
				int _pageSize=Integer.parseInt(pagesize);
				int button_value=Integer.parseInt(value_have);
				//int _button_value=Integer.parseInt(button_value);
				//可以直接设置为第一页，加载五条数据
//				
				System.out.println("进入分页查询不是展示");
				pagemodel<Product>  msgs=getpagemodel01(_pageNo,_pageSize,button_value);
				if(msgs!=null) {
					int totalPageSize= (msgs.getTotalcount()%_pageSize==0?msgs.getTotalcount()/_pageSize:msgs.getTotalcount()/_pageSize+1);
					msgs.setTotalPageSize(totalPageSize);
					msgs.setPageno(_pageNo);
				}
				
				request.setAttribute("productlist", msgs);
				try {
					System.out.println("跳转页面之前");
					request.getRequestDispatcher("productdisplay.jsp").forward(request, response);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}catch(NumberFormatException e) {
				e.printStackTrace();
			}
			
	}
	//点击事件，分别显示不同的首页
	public void getshow01(ServletRequest request,ServletResponse response) {
		
		
		  //得到类别
		String button_value=request.getParameter("cate_cid");
		request.setAttribute("pro_pid",button_value);
        System.out.println("点击时间后值"+button_value);
		try {
			
			//可以直接设置为第一页，加载3条数据
			int _pageNo=1;
  		int _pageSize=8;
		int _button_value=Integer.parseInt(button_value);

			System.out.println("进入展示页面");
			pagemodel<Product>  msgs=getpagemodel01(_pageNo,_pageSize,_button_value);
			if(msgs!=null) {
				int totalPageSize= (msgs.getTotalcount()%_pageSize==0?msgs.getTotalcount()/_pageSize:msgs.getTotalcount()/_pageSize+1);
				msgs.setTotalPageSize(totalPageSize);
				msgs.setPageno(_pageNo);
			}

//			for(int i=0;i<msgs.getDatas().size();i++) {
//				System.out.println("得到的商品信息为"+msgs.getDatas().get(i));
//			}
			
			request.setAttribute("productlist", msgs);
			try {
				
				
				request.getRequestDispatcher("productdisplay.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//分页查询方法
		public void getMsgsLogic02(ServletRequest request,ServletResponse response) {
			    //从网页的标签获取
			   String pageno=request.getParameter("pageno");
				String pagesize=request.getParameter("pagesize");
				String value_have=request.getParameter("value_have");
				request.setAttribute("pro_pid",value_have);
				
				try {
					int _pageNo=Integer.parseInt(pageno);
					int _pageSize=Integer.parseInt(pagesize);
					int button_value=Integer.parseInt(value_have);
					//int _button_value=Integer.parseInt(button_value);
					//可以直接设置为第一页，加载五条数据
//					
					System.out.println("进入分页查询不是展示");
					pagemodel<Product>  msgs=getpagemodel01(_pageNo,_pageSize,button_value);
					if(msgs!=null) {
						int totalPageSize= (msgs.getTotalcount()%_pageSize==0?msgs.getTotalcount()/_pageSize:msgs.getTotalcount()/_pageSize+1);
						msgs.setTotalPageSize(totalPageSize);
						msgs.setPageno(_pageNo);
					}
					
					request.setAttribute("productlist", msgs);
					try {
						System.out.println("跳转页面之前");
						request.getRequestDispatcher("loginproductdisplay.jsp").forward(request, response);
					} catch (ServletException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}catch(NumberFormatException e) {
					e.printStackTrace();
				}
				
		}
		//点击事件，分别显示不同的首页
		public void getshow02(ServletRequest request,ServletResponse response) {
			
			
			  //得到类别
			String button_value=request.getParameter("cate_cid");
			request.setAttribute("pro_pid",button_value);
	        System.out.println("点击时间后值"+button_value);
			try {
				
				//可以直接设置为第一页，加载3条数据
				int _pageNo=1;
	  		int _pageSize=8;
			int _button_value=Integer.parseInt(button_value);

				System.out.println("进入展示页面");
				pagemodel<Product>  msgs=getpagemodel01(_pageNo,_pageSize,_button_value);
				if(msgs!=null) {
					int totalPageSize= (msgs.getTotalcount()%_pageSize==0?msgs.getTotalcount()/_pageSize:msgs.getTotalcount()/_pageSize+1);
					msgs.setTotalPageSize(totalPageSize);
					msgs.setPageno(_pageNo);
				}

//				for(int i=0;i<msgs.getDatas().size();i++) {
//					System.out.println("得到的商品信息为"+msgs.getDatas().get(i));
//				}
				
				request.setAttribute("productlist", msgs);
				try {
					
					
					request.getRequestDispatcher("loginproductdisplay.jsp").forward(request, response);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}catch(NumberFormatException e) {
				e.printStackTrace();
			}
			
	}
	
	
	
	
	
	
	
}
