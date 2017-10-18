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

/**
 * Servlet implementation class shoppingdisplaysevlet
 */
@WebServlet("/shoppingdisplaysevlet")
public class shoppingdisplayservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shoppingdisplayservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//点击进入购物车之后
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//创建session
		HttpSession hs=request.getSession();
		//得到加入购物车商品集合
		List<Product> pro=(List<Product>)hs.getAttribute("productlist");
		List<Product> productlist=new ArrayList<Product>();
		for(int i=1;i<pro.size();i++) {
			productlist.add(pro.get(i));
		}
		//计算商品总价
		int total_price=0;
		//计算商品的件数
				int total_num=0;
				for(int i=0;i<productlist.size();i++) {
					 total_num+=productlist.get(i).getNumber();
					 total_price+=productlist.get(i).getPrice()*productlist.get(i).getNumber();
				}
	
		request.setAttribute("total_price", total_price);	
		request.setAttribute("total_num",total_num);
		request.setAttribute("productlist",productlist);
		request.getRequestDispatcher("shopping.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
