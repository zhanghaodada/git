package loginservice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import dao.DaoFactory;
import dao.ProductListdao;
import dao.leaveworddao;
import entiry.Product;
import entiry.leaveword;
import entiry.pagemodel;
import entiry.rule;
import impl.ProductListImpl;
import impl.cateImpl;
import impl.leavewordImpl;

public class ProductService {
//public static void main(String[] args) {
//	sreachall();
//}
	//��ѯȫ��
public static List<Product> sreachall() {
	ProductListdao dao01=DaoFactory.getInstance("productDao",ProductListImpl.class);
	List<Product> productlist=dao01.sreachall();
//	for(int i=0;i<productlist.size();i++) {
//		System.out.println(productlist.get(i));
//	}
	return productlist;
}
//��ҳ��ѯ
//��ҳ��ѯ
public  pagemodel<Product> getpagemodel(int pageno,int pagesize) {
	ProductListdao dao01=DaoFactory.getInstance("productDao",ProductListImpl.class);
	   pagemodel<Product> pagemodel=dao01.getpagemodel(pageno,pagesize);
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
//  		int _pageSize=3;
			System.out.println("zheshiserver");
			pagemodel<Product>  msgs=getpagemodel(_pageNo,_pageSize);
			if(msgs!=null) {
				int totalPageSize= (msgs.getTotalcount()%_pageSize==0?msgs.getTotalcount()/_pageSize:msgs.getTotalcount()/_pageSize+1);
				msgs.setTotalPageSize(totalPageSize);
				msgs.setPageno(_pageNo);
			}
			
			request.setAttribute("productlist", msgs);
			try {
				request.getRequestDispatcher("ProductList.jsp").forward(request, response);
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
  		int _pageSize=9;
			System.out.println("zheshiserver");
			pagemodel<Product>  msgs=getpagemodel(_pageNo,_pageSize);
			if(msgs!=null) {
				int totalPageSize= (msgs.getTotalcount()%_pageSize==0?msgs.getTotalcount()/_pageSize:msgs.getTotalcount()/_pageSize+1);
				msgs.setTotalPageSize(totalPageSize);
				msgs.setPageno(_pageNo);
			}
			
			request.setAttribute("productlist", msgs);
			try {
				request.getRequestDispatcher("ProductList.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
}
//������Ʒ��
      public boolean insertproduct(Product pro) {
    		ProductListdao dao01=DaoFactory.getInstance("productDao",ProductListImpl.class);

    		boolean flag=dao01.insertproduct(pro);
    		return flag;
      } 
      //������Ʒʱ���ӹ��
      public boolean insertrule(rule rule) {
  		ProductListdao dao01=DaoFactory.getInstance("productDao",ProductListImpl.class);
         boolean flag=dao01.insertrule(rule);
         return flag;
      }
    //������Ʒʱ��ѯȫ�����
      public List<rule> sreachrule() {
  		ProductListdao dao01=DaoFactory.getInstance("productDao",ProductListImpl.class);
         List<rule> rulelist=dao01.sreachrule();
         return rulelist;
      }
      //ɾ����Ʒ
      public boolean deleteproduct(Product pro) {
  		ProductListdao dao01=DaoFactory.getInstance("productDao",ProductListImpl.class);
        boolean flag=dao01.delectproduct(pro);
        return flag;
      }
      //�޸���Ʒ
      public boolean updateproduct(Product pro) {
    		ProductListdao dao01=DaoFactory.getInstance("productDao",ProductListImpl.class);
            boolean flag=dao01.updateproduct(pro);
            return flag;
      }
}
