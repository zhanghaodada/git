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
	
	//�������
   public boolean testinsert(leaveword lw) {
	   leaveworddao logdao01=DaoFactory.getInstance("leavewordDao",leavewordImpl.class);
		boolean flag=logdao01.testinsert(lw);
		return flag;
		
   }
   //�޸Ľ��
   public boolean testinsertaskword(leaveword lw) {
	   leaveworddao logdao01=DaoFactory.getInstance("leavewordDao",leavewordImpl.class);
       boolean flag=logdao01.testinsertaskword(lw);
	   return flag;
   }
   //��ѯ�б�
   public List<leaveword> sreachall(){
	   leaveworddao logdao01=DaoFactory.getInstance("leavewordDao",leavewordImpl.class);
	   List<leaveword> leavewordlist=logdao01.sreachall();
	   
	   for(int i=0;i<leavewordlist.size();i++) {
			System.out.println(leavewordlist.get(i));
		}
	   return leavewordlist;
   }
   //��ҳ��ѯ
   public  pagemodel<leaveword> getpagemodel(int pageno,int pagesize) {
	   leaveworddao logdao01=DaoFactory.getInstance("leavewordDao",leavewordImpl.class);
	   pagemodel<leaveword> pagemodel=logdao01.getpagemodel(pageno,pagesize);
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
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
 //��ҳ��ʾ
   public void getshow(ServletRequest request,ServletResponse response) {
	  
		
		try {
			
			//����ֱ������Ϊ��һҳ������3������
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
