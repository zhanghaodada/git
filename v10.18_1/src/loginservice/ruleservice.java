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
//��ѯ����
	public List<rule> sreachall(){
		ruledao dao01=DaoFactory.getInstance("ruleDao",ruleImpl.class);
		List<rule> rulelist=dao01.sreachall();
		return rulelist;
	}
	//��ѯ����
		public List<rule> sreachall01(){
			ruledao dao01=DaoFactory.getInstance("ruleDao",ruleImpl.class);
			List<rule> rulelist=dao01.sreachall01();
			return rulelist;
		}
	//���ݹ��id���ӹ��
	public boolean insertrule(rule rule) {
		ruledao dao01=DaoFactory.getInstance("ruleDao",ruleImpl.class);
        boolean flag=dao01.insertrule(rule);
		return flag;
	}
	//���ݹ��id�޸Ĺ��
	public boolean updaterule(rule rule ) {
		ruledao dao01=DaoFactory.getInstance("ruleDao",ruleImpl.class);
        boolean flag=dao01.updaterule(rule);
		return flag;
	}
	//���ݹ��idɾ�����
	public boolean deleterule(rule rule) {
		ruledao dao01=DaoFactory.getInstance("ruleDao",ruleImpl.class);
        boolean flag=dao01.deleterule(rule);
		return flag;
	}
	//������Ʒid�޸Ĺ��
		public boolean updaterule01(rule rule ) {
			ruledao dao01=DaoFactory.getInstance("ruleDao",ruleImpl.class);
	        boolean flag=dao01.updaterule01(rule);
			return flag;
		}
		//������Ʒidɾ�����
		public boolean deleterule01(rule rule) {
			ruledao dao01=DaoFactory.getInstance("ruleDao",ruleImpl.class);
	        boolean flag=dao01.deleterule01(rule);
			return flag;
		}
	//��ҳ��ѯ
	public  pagemodel<rule> getpagemodel(int pageno,int pagesize) {
		ruledao dao01=DaoFactory.getInstance("ruleDao",ruleImpl.class);
		   pagemodel<rule> pagemodel=dao01.getpagemodel(pageno,pagesize);
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
//				int _pageNo=1;
//	  		int _pageSize=3;
				System.out.println("�����ҳ��ѯ����չʾ");
				pagemodel<rule>  msgs=getpagemodel(_pageNo,_pageSize);
				if(msgs!=null) {
					int totalPageSize= (msgs.getTotalcount()%_pageSize==0?msgs.getTotalcount()/_pageSize:msgs.getTotalcount()/_pageSize+1);
					msgs.setTotalPageSize(totalPageSize);
					msgs.setPageno(_pageNo);
				}
				
				request.setAttribute("productlist", msgs);
				try {
					System.out.println("��תҳ��֮ǰ");
					request.getRequestDispatcher("productrule.jsp").forward(request, response);
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
				System.out.println("����չʾҳ��");
				pagemodel<rule>  msgs=getpagemodel(_pageNo,_pageSize);
				if(msgs!=null) {
					int totalPageSize= (msgs.getTotalcount()%_pageSize==0?msgs.getTotalcount()/_pageSize:msgs.getTotalcount()/_pageSize+1);
					msgs.setTotalPageSize(totalPageSize);
					msgs.setPageno(_pageNo);
				}
				//
				//����rulelist�����ѯ����product�������Ӧ��
//				List<rule> rulelist=sreachall();
//				ProductService ps=new ProductService();
//				List<Product> productlist=ps.sreachall();
//				//List<rule> rl=null;
//				for(int i=0;i<rulelist.size();i++) {
//					for(int j=0;j<productlist.size();j++) {
//						if(rulelist.get(i).getPid()==productlist.get(j).getId()) {
//							//rule rr=new rule();
//							System.out.println("���������ֵ"+productlist.get(j).getPname());
//							msgs.getDatas().get(i).setPname(productlist.get(j).getPname());
//							System.out.println("����rr������"+msgs.getDatas().get(i));
//							
//						}
//						else {
//							msgs.getDatas().get(i).setPname("����");
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
