package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.account_consumer;
import service.productservice;

/**
 * Servlet implementation class productdisplaysevlet
 */
@WebServlet("/productdisplaysevlet")
public class productdisplaysevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productdisplaysevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		productservice ps=new productservice();
		//从首页得到类别，比如华为会得到华为该类的cid
		//String pro_pid=request.getParameter("cate_cid");
		String reqType=request.getParameter("reqType");
		
		//创建session 获取session的值
		HttpSession hs=request.getSession();
		//将得到的转到account_consumer
		account_consumer acc=(account_consumer)hs.getAttribute("acc");
		System.out.println(acc);
		//有账号登陆时
		if(acc!=null) {
			if(reqType==null||reqType.equals("")) {
				//跳转到有登陆的商品展示首页
				ps.getshow02(request, response);
			}
			else if(reqType.equals("2")) {
				//跳转到有登陆的商品分页
				ps.getMsgsLogic02(request, response);
			}
		}
		//没有账号登陆时
		else {
		if(reqType==null||reqType.equals("")) {
			//跳转到没有登陆的商品展示首页
			ps.getshow01(request, response);
		}
		else if(reqType.equals("2")) {
			//跳转没有登陆的商品展示分页
			ps.getMsgsLogic01(request, response);
		}
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
