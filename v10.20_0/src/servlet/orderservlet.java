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
		//点击提交订单进入此页面，先判断是否登陆
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		//创建session
		HttpSession hs=request.getSession();
		account_consumer ac=(account_consumer)hs.getAttribute("acc");
		//已经登陆了
		if(ac!=null&&!ac.equals("")) {
			//获得session里商品信息的值
			List<Product> pro=(List<Product>)hs.getAttribute("productlist");
			//复制商品信息的值,并赋给session
			List<Product> new_pro=new ArrayList<Product>();
			for(int i=1;i<pro.size();i++){
				new_pro.add(pro.get(i));
			}
			request.setAttribute("new_pro",new_pro);
			hs.setAttribute("new_productlist",new_pro);
			
			orderservice os=new orderservice();
			//获得session里的具体信息
			consumer_addr ca=(consumer_addr)hs.getAttribute("ca");
			//将consumer_addr的id通过方法传给orderinfo
			//System.out.println("具体信息的id为"+ca.getId());
			os.insertorder(pro,ca.getId());
			
			
			
			
			request.setAttribute("ca", ca);
			//清空session里的商品
			Product pro00=new Product();
			pro00.setNumber(1);
			List<Product> prolist=new ArrayList<Product>();
			prolist.add(pro00);
			hs.setAttribute("productlist",prolist);
			//请求分派到订单页面
			request.getRequestDispatcher("payment.jsp").forward(request, response);
			
		}
		//没有登陆情况
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
