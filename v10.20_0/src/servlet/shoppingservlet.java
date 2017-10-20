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
 * Servlet implementation class shoppingservlet
 */
@WebServlet("/shoppingservlet")
public class shoppingservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shoppingservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��ҳû�е�½ʱ����    ��ʾ���ﳵ�ļ���
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		
		//����Ʒ��Ϣ���ϸ���session
		//����session
		HttpSession hs=request.getSession();
		
		//��ҳ�״μ��أ�productlist�϶�Ϊ��
		if((List<Product>)hs.getAttribute("productlist")==null){
		
		List<Product> productlist=new ArrayList<Product>();
		Product pro=new Product();
		pro.setPname("ceshi");
		pro.setNumber(1);
		productlist.add(pro);
		hs.setAttribute("productlist",productlist);
		//�õ����ϵĳ��ȸ����ﳵ������ֵ
		List<Product> productlist01=(List<Product>)hs.getAttribute("productlist");
		System.out.println("������빺�ﳵ�����Ʒ����"+productlist01.size());
		//������Ʒ�ļ���
		int total_num=0;
		for(int i=0;i<productlist01.size();i++) {
			 total_num+=productlist01.get(i).getNumber();
		}
		pw.print(total_num-1);
		}
		
		else {
			List<Product> productlist01=(List<Product>)hs.getAttribute("productlist");
			System.out.println("������빺�ﳵ�����Ʒ����"+productlist01.size());
			//������Ʒ�ļ���
			int total_num=0;
			for(int i=0;i<productlist01.size();i++) {
				 total_num+=productlist01.get(i).getNumber();
			}
			pw.print(total_num-1);
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
