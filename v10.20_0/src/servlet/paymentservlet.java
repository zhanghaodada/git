package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Product;
import entity.orderinfo;
import service.orderservice;

/**
 * Servlet implementation class paymentservlet
 */
@WebServlet("/paymentservlet")
public class paymentservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public paymentservlet() {
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
		//���֧����ɺ������Ʒ��session��
		orderservice os=new orderservice();
		//�õ���ע��Ϣ,
		String mask=request.getParameter("input_mask");
		System.out.println("����Ķ�����עΪ"+mask);
		orderinfo oi=new orderinfo();
		oi.setMask(mask);
		//���÷����޸ġ�
		os.updateorder(oi);
		
		//���session�����Ʒ
		HttpSession hs=request.getSession();
		Product pro=new Product();
		pro.setNumber(1);
		List<Product> prolist=new ArrayList<Product>();
		prolist.add(pro);
		hs.setAttribute("productlist",prolist);
		
		//��ת����ҳ
		request.getRequestDispatcher("homeservlet").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
