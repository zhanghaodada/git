package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Product;
import service.productservice;

/**
 * Servlet implementation class productlistsession
 */
@WebServlet("/productlistsession")
public class productlistsession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productlistsession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		//session
		HttpSession hs=request.getSession();
		//��Ʒչʾҳ�棬������빺�ﳵ����ֵ�����servlet,
		//�õ�������빺�ﳵ����Ʒid
		String pro_id_have=request.getParameter("pro_id");
		//ͨ��������빺��
		if(pro_id_have!=null&&!pro_id_have.equals("")) {
			int pro_id=Integer.parseInt(pro_id_have);
			productservice ps=new productservice();
			Product pro=ps.sreachbyid(pro_id);
			System.out.println("��Ʒ��IdΪ"+pro_id);
			//System.out.println("��ҳ��õ�����ƷΪ"+pro);
			
			List<Product> productlist=(List<Product>)hs.getAttribute("productlist");
             //�ж��Ƿ�Ϊ��
             if(productlist!=null&&!productlist.equals("")) {
            	 boolean flag=false;
            	 //�жϹ��ﳵ�Ƿ������Ҫ���� ���ﳵ����Ʒid
            	 for(int i=0;i<productlist.size();i++) {
            		 int product_id=productlist.get(i).getId();
            		 //������ȵ����
            		 if(product_id==pro_id) {
            			 System.out.println("������ƷId����״̬"+product_id);
            			 int number=productlist.get(i).getNumber();
            			 productlist.get(i).setNumber(number+1);
                         System.out.println("����session���Ĺ��ﳵ��ϢΪ"+productlist);
                         flag=false;
                         break;
            		 }
            		 //���ﳵ�в�������ͬ����Ʒ
            		 else{
            			 flag=true;            			
            		 }
            	 }
            	 //ͨ��flag�жϲ������ظ���Ʒ���
            	 if(flag) {
            		 productlist.add(pro);
                   System.out.println("����session���Ĺ��ﳵ��ϢΪ"+productlist);
            	 }
             }
			hs.setAttribute("productlist",productlist);
			List<Product> productlist01=(List<Product>)hs.getAttribute("productlist");
			System.out.println("������빺�ﳵ�����Ʒ����"+(productlist01.size()-1));
			//������Ʒ�ļ���
			int total_num=0;
			for(int i=0;i<productlist01.size();i++) {
				 total_num+=productlist01.get(i).getNumber();
			}
			pw.print(total_num-1);
		}
		//û�е�����빺�ﳵ,��ʾ���ﳵ����
		else {
			List<Product> productlist=(List<Product>)hs.getAttribute("productlist");
            //�ж��Ƿ�Ϊ��
            if(productlist!=null&&!productlist.equals("")) {
            	//������Ʒ�ļ���
    			int total_num=0;
    			for(int i=0;i<productlist.size();i++) {
    				 total_num+=productlist.get(i).getNumber();
    			}
    			pw.print(total_num-1);

            }
		}
		
		//String button=request.getParameter("butto");
		//System.out.println("������ﳵ�õ���Ʒ��IdΪ"+button);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
