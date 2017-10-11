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
	//��ҳ��ѯ
		public  pagemodel<product_orderinfo> getpagemodel(int pageno,int pagesize) {
			orderdao dao01=DaoFactory.getInstance("orderDao",orderImpl.class);
			   pagemodel<product_orderinfo> pagemodel=dao01.getpagemodel(pageno,pagesize);
			   return pagemodel;
		}

		//��ҳ��ѯ����
		public void getMsgsLogic(ServletRequest request,ServletResponse response) {
			    //����ҳ�ı�ǩ��ȡ
			   String pageno=request.getParameter("pageno");
				String pagesize=request.getParameter("pagesize");
				
				try {
					int _pageNo=Integer.parseInt(pageno);
					int _pageSize=Integer.parseInt(pagesize);
					//����ֱ������Ϊ��һҳ��������������
//					int _pageNo=1;
//		  		int _pageSize=3;
					System.out.println("�����ҳ��ѯ����չʾ");
					pagemodel<product_orderinfo>  msgs=getpagemodel(_pageNo,_pageSize);
					if(msgs!=null) {
						int totalPageSize= (msgs.getTotalcount()%_pageSize==0?msgs.getTotalcount()/_pageSize:msgs.getTotalcount()/_pageSize+1);
						msgs.setTotalPageSize(totalPageSize);
						msgs.setPageno(_pageNo);
					}
					
					request.setAttribute("orderlist", msgs);
					try {
						System.out.println("��תҳ��֮ǰ");
						request.getRequestDispatcher("orderinfo.jsp").forward(request, response);
					} catch (ServletException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}catch(NumberFormatException e) {
					e.printStackTrace();
				}
				
		}















		//��ҳ��ʾ
		public void getshow(ServletRequest request,ServletResponse response) {
			  
				
				try {
					
					//����ֱ������Ϊ��һҳ������3������
					int _pageNo=1;
		  		int _pageSize=8;
					System.out.println("����չʾҳ��");
					pagemodel<product_orderinfo>  msgs=getpagemodel(_pageNo,_pageSize);
					if(msgs!=null) {
						int totalPageSize= (msgs.getTotalcount()%_pageSize==0?msgs.getTotalcount()/_pageSize:msgs.getTotalcount()/_pageSize+1);
						msgs.setTotalPageSize(totalPageSize);
						msgs.setPageno(_pageNo);
					}
		System.out.println("���ǲ�ѯ����������"+msgs);
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
		//��ҳ��ѯ��֧�����������ȵȶ���
				public  pagemodel<product_orderinfo> getpagemodel01(int pageno,int pagesize,int sreachtype) {
					orderdao dao01=DaoFactory.getInstance("orderDao",orderImpl.class);
					   pagemodel<product_orderinfo> pagemodel=dao01.getpagemodel01(pageno,pagesize,sreachtype);
					   return pagemodel;
				}

				//��ҳ��ѯ����
				public void getMsgsLogic01(ServletRequest request,ServletResponse response) {
					    //����ҳ�ı�ǩ��ȡ
					   String pageno=request.getParameter("pageno");
						String pagesize=request.getParameter("pagesize");
						String value_have=request.getParameter("value_have");
						request.setAttribute("button_value",value_have);
						
						try {
							int _pageNo=Integer.parseInt(pageno);
							int _pageSize=Integer.parseInt(pagesize);
							int button_value=Integer.parseInt(value_have);
							//int _button_value=Integer.parseInt(button_value);
							//����ֱ������Ϊ��һҳ��������������
//							
							System.out.println("�����ҳ��ѯ����չʾ");
							pagemodel<product_orderinfo>  msgs=getpagemodel01(_pageNo,_pageSize,button_value);
							if(msgs!=null) {
								int totalPageSize= (msgs.getTotalcount()%_pageSize==0?msgs.getTotalcount()/_pageSize:msgs.getTotalcount()/_pageSize+1);
								msgs.setTotalPageSize(totalPageSize);
								msgs.setPageno(_pageNo);
							}
							
							request.setAttribute("orderlist", msgs);
							try {
								System.out.println("��תҳ��֮ǰ");
								request.getRequestDispatcher("orderinfo.jsp").forward(request, response);
							} catch (ServletException | IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}catch(NumberFormatException e) {
							e.printStackTrace();
						}
						
				}
				
				
				
				//����¼����ֱ���ʾ��ͬ����ҳ
				public void getshow01(ServletRequest request,ServletResponse response) {
					  //�õ���ҳ�����ť���ͣ����ǲ�ѯ��֧����ֻ�ᴫ��1��2��3��4
					String button_value=request.getParameter("button");
					request.setAttribute("button_value",button_value);
                    System.out.println("���ʱ���buttonֵ"+button_value);
					try {
						
						//����ֱ������Ϊ��һҳ������3������
						int _pageNo=1;
			  		int _pageSize=8;
					int _button_value=Integer.parseInt(button_value);

						System.out.println("����չʾҳ��");
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
