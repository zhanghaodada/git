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
	
	//����id��ѯ��Ʒ��Ϣ
	public  Product sreachbyid( int id) {
		productdao dao01=DaoFactory.getInstance("productDao",productimpl.class);
		   Product pro=dao01.sreachbyid(id);
		   return pro;
	}
	//��ҳ��ѯ��֧�����������ȵȶ���
	public  pagemodel<Product> getpagemodel01(int pageno,int pagesize,int sreachtype) {
		productdao dao01=DaoFactory.getInstance("productDao",productimpl.class);
		   pagemodel<Product> pagemodel=dao01.getpagemodel01(pageno,pagesize,sreachtype);
		   return pagemodel;
	}

	//��ҳ��ѯ����
	public void getMsgsLogic01(ServletRequest request,ServletResponse response) {
		    //����ҳ�ı�ǩ��ȡ
		   String pageno=request.getParameter("pageno");
			String pagesize=request.getParameter("pagesize");
			String value_have=request.getParameter("value_have");
			request.setAttribute("pro_pid",value_have);
			
			try {
				int _pageNo=Integer.parseInt(pageno);
				int _pageSize=Integer.parseInt(pagesize);
				int button_value=Integer.parseInt(value_have);
				//int _button_value=Integer.parseInt(button_value);
				//����ֱ������Ϊ��һҳ��������������
//				
				System.out.println("�����ҳ��ѯ����չʾ");
				pagemodel<Product>  msgs=getpagemodel01(_pageNo,_pageSize,button_value);
				if(msgs!=null) {
					int totalPageSize= (msgs.getTotalcount()%_pageSize==0?msgs.getTotalcount()/_pageSize:msgs.getTotalcount()/_pageSize+1);
					msgs.setTotalPageSize(totalPageSize);
					msgs.setPageno(_pageNo);
				}
				
				request.setAttribute("productlist", msgs);
				try {
					System.out.println("��תҳ��֮ǰ");
					request.getRequestDispatcher("productdisplay.jsp").forward(request, response);
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
		
		
		  //�õ����
		String button_value=request.getParameter("cate_cid");
		request.setAttribute("pro_pid",button_value);
        System.out.println("���ʱ���ֵ"+button_value);
		try {
			
			//����ֱ������Ϊ��һҳ������3������
			int _pageNo=1;
  		int _pageSize=8;
		int _button_value=Integer.parseInt(button_value);

			System.out.println("����չʾҳ��");
			pagemodel<Product>  msgs=getpagemodel01(_pageNo,_pageSize,_button_value);
			if(msgs!=null) {
				int totalPageSize= (msgs.getTotalcount()%_pageSize==0?msgs.getTotalcount()/_pageSize:msgs.getTotalcount()/_pageSize+1);
				msgs.setTotalPageSize(totalPageSize);
				msgs.setPageno(_pageNo);
			}

//			for(int i=0;i<msgs.getDatas().size();i++) {
//				System.out.println("�õ�����Ʒ��ϢΪ"+msgs.getDatas().get(i));
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//��ҳ��ѯ����
		public void getMsgsLogic02(ServletRequest request,ServletResponse response) {
			    //����ҳ�ı�ǩ��ȡ
			   String pageno=request.getParameter("pageno");
				String pagesize=request.getParameter("pagesize");
				String value_have=request.getParameter("value_have");
				request.setAttribute("pro_pid",value_have);
				
				try {
					int _pageNo=Integer.parseInt(pageno);
					int _pageSize=Integer.parseInt(pagesize);
					int button_value=Integer.parseInt(value_have);
					//int _button_value=Integer.parseInt(button_value);
					//����ֱ������Ϊ��һҳ��������������
//					
					System.out.println("�����ҳ��ѯ����չʾ");
					pagemodel<Product>  msgs=getpagemodel01(_pageNo,_pageSize,button_value);
					if(msgs!=null) {
						int totalPageSize= (msgs.getTotalcount()%_pageSize==0?msgs.getTotalcount()/_pageSize:msgs.getTotalcount()/_pageSize+1);
						msgs.setTotalPageSize(totalPageSize);
						msgs.setPageno(_pageNo);
					}
					
					request.setAttribute("productlist", msgs);
					try {
						System.out.println("��תҳ��֮ǰ");
						request.getRequestDispatcher("loginproductdisplay.jsp").forward(request, response);
					} catch (ServletException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}catch(NumberFormatException e) {
					e.printStackTrace();
				}
				
		}
		//����¼����ֱ���ʾ��ͬ����ҳ
		public void getshow02(ServletRequest request,ServletResponse response) {
			
			
			  //�õ����
			String button_value=request.getParameter("cate_cid");
			request.setAttribute("pro_pid",button_value);
	        System.out.println("���ʱ���ֵ"+button_value);
			try {
				
				//����ֱ������Ϊ��һҳ������3������
				int _pageNo=1;
	  		int _pageSize=8;
			int _button_value=Integer.parseInt(button_value);

				System.out.println("����չʾҳ��");
				pagemodel<Product>  msgs=getpagemodel01(_pageNo,_pageSize,_button_value);
				if(msgs!=null) {
					int totalPageSize= (msgs.getTotalcount()%_pageSize==0?msgs.getTotalcount()/_pageSize:msgs.getTotalcount()/_pageSize+1);
					msgs.setTotalPageSize(totalPageSize);
					msgs.setPageno(_pageNo);
				}

//				for(int i=0;i<msgs.getDatas().size();i++) {
//					System.out.println("�õ�����Ʒ��ϢΪ"+msgs.getDatas().get(i));
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
