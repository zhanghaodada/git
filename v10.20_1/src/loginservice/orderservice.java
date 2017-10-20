package loginservice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import dao.DaoFactory;
import dao.orderdao;
import dao.ruledao;
import entiry.order;
import entiry.pagemodel;
import entiry.product_orderinfo;
import entiry.rule;
import impl.orderImpl;
import impl.ruleImpl;

public class orderservice {
	//分页查询
		public  pagemodel<product_orderinfo> getpagemodel(int pageno,int pagesize) {
			orderdao dao01=DaoFactory.getInstance("orderDao",orderImpl.class);
			   pagemodel<product_orderinfo> pagemodel=dao01.getpagemodel(pageno,pagesize);
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
//					int _pageNo=1;
//		  		int _pageSize=3;
					System.out.println("进入分页查询不是展示");
					pagemodel<product_orderinfo>  msgs=getpagemodel(_pageNo,_pageSize);
					if(msgs!=null) {
						int totalPageSize= (msgs.getTotalcount()%_pageSize==0?msgs.getTotalcount()/_pageSize:msgs.getTotalcount()/_pageSize+1);
						msgs.setTotalPageSize(totalPageSize);
						msgs.setPageno(_pageNo);
					}
					
					request.setAttribute("orderlist", msgs);
					try {
						System.out.println("跳转页面之前");
						request.getRequestDispatcher("orderinfo.jsp").forward(request, response);
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
		  		int _pageSize=8;
					System.out.println("进入展示页面");
					pagemodel<product_orderinfo>  msgs=getpagemodel(_pageNo,_pageSize);
					if(msgs!=null) {
						int totalPageSize= (msgs.getTotalcount()%_pageSize==0?msgs.getTotalcount()/_pageSize:msgs.getTotalcount()/_pageSize+1);
						msgs.setTotalPageSize(totalPageSize);
						msgs.setPageno(_pageNo);
					}
		System.out.println("这是查询出来的数据"+msgs);
					request.setAttribute("orderlist", msgs);
					try {
						request.getRequestDispatcher("orderinfo.jsp").forward(request, response);
					} catch (ServletException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}catch(NumberFormatException e) {
					e.printStackTrace();
				}
				
		}
		//分页查询待支付。。。。等等订单
				public  pagemodel<product_orderinfo> getpagemodel01(int pageno,int pagesize,int sreachtype) {
					orderdao dao01=DaoFactory.getInstance("orderDao",orderImpl.class);
					   pagemodel<product_orderinfo> pagemodel=dao01.getpagemodel01(pageno,pagesize,sreachtype);
					   return pagemodel;
				}

				//分页查询方法
				public void getMsgsLogic01(ServletRequest request,ServletResponse response) {
					    //从网页的标签获取
					   String pageno=request.getParameter("pageno");
						String pagesize=request.getParameter("pagesize");
						String value_have=request.getParameter("value_have");
						request.setAttribute("button_value",value_have);
						
						try {
							int _pageNo=Integer.parseInt(pageno);
							int _pageSize=Integer.parseInt(pagesize);
							int button_value=Integer.parseInt(value_have);
							//int _button_value=Integer.parseInt(button_value);
							//可以直接设置为第一页，加载五条数据
//							
							System.out.println("进入分页查询不是展示");
							pagemodel<product_orderinfo>  msgs=getpagemodel01(_pageNo,_pageSize,button_value);
							if(msgs!=null) {
								int totalPageSize= (msgs.getTotalcount()%_pageSize==0?msgs.getTotalcount()/_pageSize:msgs.getTotalcount()/_pageSize+1);
								msgs.setTotalPageSize(totalPageSize);
								msgs.setPageno(_pageNo);
							}
							
							request.setAttribute("orderlist", msgs);
							try {
								System.out.println("跳转页面之前");
								request.getRequestDispatcher("orderinfo.jsp").forward(request, response);
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
					  //得到网页点击按钮类型，还是查询待支付，只会传进1，2，3，4
					String button_value=request.getParameter("button");
					request.setAttribute("button_value",button_value);
                    System.out.println("点击时间后button值"+button_value);
					try {
						
						//可以直接设置为第一页，加载3条数据
						int _pageNo=1;
			  		int _pageSize=8;
					int _button_value=Integer.parseInt(button_value);

						System.out.println("进入展示页面");
						pagemodel<product_orderinfo>  msgs=getpagemodel01(_pageNo,_pageSize,_button_value);
						if(msgs!=null) {
							int totalPageSize= (msgs.getTotalcount()%_pageSize==0?msgs.getTotalcount()/_pageSize:msgs.getTotalcount()/_pageSize+1);
							msgs.setTotalPageSize(totalPageSize);
							msgs.setPageno(_pageNo);
						}
			
						request.setAttribute("orderlist", msgs);
						try {
							request.getRequestDispatcher("orderinfo.jsp").forward(request, response);
						} catch (ServletException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}catch(NumberFormatException e) {
						e.printStackTrace();
					}
					
			}
}
