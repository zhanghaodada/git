package loginservice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import dao.DaoFactory;
import dao.ProductListdao;
import dao.ruledao;
import entiry.Product;
import entiry.pagemodel;
import entiry.rule;
import impl.ProductListImpl;
import impl.ruleImpl;

public class ruleservice {
//查询所有
	public List<rule> sreachall(){
		ruledao dao01=DaoFactory.getInstance("ruleDao",ruleImpl.class);
		List<rule> rulelist=dao01.sreachall();
		return rulelist;
	}
	//查询所有
		public List<rule> sreachall01(){
			ruledao dao01=DaoFactory.getInstance("ruleDao",ruleImpl.class);
			List<rule> rulelist=dao01.sreachall01();
			return rulelist;
		}
	//根据规格id增加规格
	public boolean insertrule(rule rule) {
		ruledao dao01=DaoFactory.getInstance("ruleDao",ruleImpl.class);
        boolean flag=dao01.insertrule(rule);
		return flag;
	}
	//根据规格id修改规格
	public boolean updaterule(rule rule ) {
		ruledao dao01=DaoFactory.getInstance("ruleDao",ruleImpl.class);
        boolean flag=dao01.updaterule(rule);
		return flag;
	}
	//根据规格id删除规格
	public boolean deleterule(rule rule) {
		ruledao dao01=DaoFactory.getInstance("ruleDao",ruleImpl.class);
        boolean flag=dao01.deleterule(rule);
		return flag;
	}
	//根据商品id修改规格
		public boolean updaterule01(rule rule ) {
			ruledao dao01=DaoFactory.getInstance("ruleDao",ruleImpl.class);
	        boolean flag=dao01.updaterule01(rule);
			return flag;
		}
		//根据商品id删除规格
		public boolean deleterule01(rule rule) {
			ruledao dao01=DaoFactory.getInstance("ruleDao",ruleImpl.class);
	        boolean flag=dao01.deleterule01(rule);
			return flag;
		}
	//分页查询
	public  pagemodel<rule> getpagemodel(int pageno,int pagesize) {
		ruledao dao01=DaoFactory.getInstance("ruleDao",ruleImpl.class);
		   pagemodel<rule> pagemodel=dao01.getpagemodel(pageno,pagesize);
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
//	  		int _pageSize=3;
				System.out.println("进入分页查询不是展示");
				pagemodel<rule>  msgs=getpagemodel(_pageNo,_pageSize);
				if(msgs!=null) {
					int totalPageSize= (msgs.getTotalcount()%_pageSize==0?msgs.getTotalcount()/_pageSize:msgs.getTotalcount()/_pageSize+1);
					msgs.setTotalPageSize(totalPageSize);
					msgs.setPageno(_pageNo);
				}
				
				request.setAttribute("productlist", msgs);
				try {
					System.out.println("跳转页面之前");
					request.getRequestDispatcher("productrule.jsp").forward(request, response);
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
				System.out.println("进入展示页面");
				pagemodel<rule>  msgs=getpagemodel(_pageNo,_pageSize);
				if(msgs!=null) {
					int totalPageSize= (msgs.getTotalcount()%_pageSize==0?msgs.getTotalcount()/_pageSize:msgs.getTotalcount()/_pageSize+1);
					msgs.setTotalPageSize(totalPageSize);
					msgs.setPageno(_pageNo);
				}
				//
				//遍历rulelist数组查询出与product数组相对应的
//				List<rule> rulelist=sreachall();
//				ProductService ps=new ProductService();
//				List<Product> productlist=ps.sreachall();
//				//List<rule> rl=null;
//				for(int i=0;i<rulelist.size();i++) {
//					for(int j=0;j<productlist.size();j++) {
//						if(rulelist.get(i).getPid()==productlist.get(j).getId()) {
//							//rule rr=new rule();
//							System.out.println("测试输出的值"+productlist.get(j).getPname());
//							msgs.getDatas().get(i).setPname(productlist.get(j).getPname());
//							System.out.println("测试rr的数据"+msgs.getDatas().get(i));
//							
//						}
//						else {
//							msgs.getDatas().get(i).setPname("暂无");
//						}
//					}
//				}
			//	request.setAttribute("rl",rl);
				request.setAttribute("productlist", msgs);
				try {
					request.getRequestDispatcher("productrule.jsp").forward(request, response);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}catch(NumberFormatException e) {
				e.printStackTrace();
			}
			
	}
}
