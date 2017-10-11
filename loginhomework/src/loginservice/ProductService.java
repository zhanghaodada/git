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
	//查询全部
public static List<Product> sreachall() {
	ProductListdao dao01=DaoFactory.getInstance("productDao",ProductListImpl.class);
	List<Product> productlist=dao01.sreachall();
//	for(int i=0;i<productlist.size();i++) {
//		System.out.println(productlist.get(i));
//	}
	return productlist;
}
//分页查询
//分页查询
public  pagemodel<Product> getpagemodel(int pageno,int pagesize) {
	ProductListdao dao01=DaoFactory.getInstance("productDao",ProductListImpl.class);
	   pagemodel<Product> pagemodel=dao01.getpagemodel(pageno,pagesize);
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















//首页显示
public void getshow(ServletRequest request,ServletResponse response) {
	  
		
		try {
			
			//可以直接设置为第一页，加载3条数据
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
//增加商品信
      public boolean insertproduct(Product pro) {
    		ProductListdao dao01=DaoFactory.getInstance("productDao",ProductListImpl.class);

    		boolean flag=dao01.insertproduct(pro);
    		return flag;
      } 
      //增加商品时增加规格
      public boolean insertrule(rule rule) {
  		ProductListdao dao01=DaoFactory.getInstance("productDao",ProductListImpl.class);
         boolean flag=dao01.insertrule(rule);
         return flag;
      }
    //增加商品时查询全部规格
      public List<rule> sreachrule() {
  		ProductListdao dao01=DaoFactory.getInstance("productDao",ProductListImpl.class);
         List<rule> rulelist=dao01.sreachrule();
         return rulelist;
      }
      //删除商品
      public boolean deleteproduct(Product pro) {
  		ProductListdao dao01=DaoFactory.getInstance("productDao",ProductListImpl.class);
        boolean flag=dao01.delectproduct(pro);
        return flag;
      }
      //修改商品
      public boolean updateproduct(Product pro) {
    		ProductListdao dao01=DaoFactory.getInstance("productDao",ProductListImpl.class);
            boolean flag=dao01.updateproduct(pro);
            return flag;
      }
}
