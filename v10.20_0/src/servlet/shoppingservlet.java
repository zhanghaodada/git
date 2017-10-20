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
		//首页没有登陆时进入    显示购物车的件数
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		
		//将商品信息集合赋给session
		//创建session
		HttpSession hs=request.getSession();
		
		//首页首次加载，productlist肯定为空
		if((List<Product>)hs.getAttribute("productlist")==null){
		
		List<Product> productlist=new ArrayList<Product>();
		Product pro=new Product();
		pro.setPname("ceshi");
		pro.setNumber(1);
		productlist.add(pro);
		hs.setAttribute("productlist",productlist);
		//得到集合的长度给购物车件数赋值
		List<Product> productlist01=(List<Product>)hs.getAttribute("productlist");
		System.out.println("点击加入购物车后的商品件数"+productlist01.size());
		//计算商品的件数
		int total_num=0;
		for(int i=0;i<productlist01.size();i++) {
			 total_num+=productlist01.get(i).getNumber();
		}
		pw.print(total_num-1);
		}
		
		else {
			List<Product> productlist01=(List<Product>)hs.getAttribute("productlist");
			System.out.println("点击加入购物车后的商品件数"+productlist01.size());
			//计算商品的件数
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
