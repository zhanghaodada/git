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
import entity.account_consumer;
import entity.consumer_addr;
import service.orderservice;

/**
 * Servlet implementation class orderservlet
 */
@WebServlet("/orderservlet")
public class orderservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orderservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//����ύ���������ҳ�棬���ж��Ƿ��½
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		//����session
		HttpSession hs=request.getSession();
		account_consumer ac=(account_consumer)hs.getAttribute("acc");
		//�Ѿ���½��
		if(ac!=null&&!ac.equals("")) {
			//���session����Ʒ��Ϣ��ֵ
			List<Product> pro=(List<Product>)hs.getAttribute("productlist");
			//������Ʒ��Ϣ��ֵ,������session
			List<Product> new_pro=new ArrayList<Product>();
			for(int i=1;i<pro.size();i++){
				new_pro.add(pro.get(i));
			}
			request.setAttribute("new_pro",new_pro);
			hs.setAttribute("new_productlist",new_pro);
			
			orderservice os=new orderservice();
			//���session��ľ�����Ϣ
			consumer_addr ca=(consumer_addr)hs.getAttribute("ca");
			//��consumer_addr��idͨ����������orderinfo
			//System.out.println("������Ϣ��idΪ"+ca.getId());
			os.insertorder(pro,ca.getId());
			
			
			
			
			request.setAttribute("ca", ca);
			//���session�����Ʒ
			Product pro00=new Product();
			pro00.setNumber(1);
			List<Product> prolist=new ArrayList<Product>();
			prolist.add(pro00);
			hs.setAttribute("productlist",prolist);
			//������ɵ�����ҳ��
			request.getRequestDispatcher("payment.jsp").forward(request, response);
			
		}
		//û�е�½���
		else if(ac==null||ac.equals("")) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
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
