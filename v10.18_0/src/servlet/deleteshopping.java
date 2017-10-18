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

/**
 * Servlet implementation class deleteshopping
 */
@WebServlet("/deleteshopping")
public class deleteshopping extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteshopping() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//���ﳵҳ����ɾ����Ʒʱ
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		//����session
		HttpSession hs=request.getSession();
        List<Product> pl=(List<Product>)hs.getAttribute("productlist");	
		//�õ�����������Ʒid
        String pro_id=request.getParameter("pro_id");
        System.out.println("���ﳵҳ����ɾ����Ʒʱ������IdΪ"+pro_id);
        //����
        if(pro_id!=null&&!pro_id.equals("")) {
        	
        	int product_id=Integer.parseInt(pro_id);
        	List<Product> new_pl=new ArrayList<Product>();
        	boolean flag=false;
        	for(int i=0;i<pl.size();i++) {
        		if(pl.get(i).getId()==product_id) {
        			System.out.println("������ͬ����Ʒ������ɾ����");
        			flag=true;
        			continue;
        		}
        		new_pl.add(pl.get(i));
        		
        	}
        	//�����ﳵ��Ʒ���ϼӵ�session��
        	hs.setAttribute("productlist",new_pl);
        	pw.print(flag);
        	
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
