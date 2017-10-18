package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.account_consumer;

/**
 * Servlet implementation class homeservlet
 */
@WebServlet("/homeservlet")
public class homeservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public homeservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//得到session的值判断
		//创建session
	    HttpSession hs=request.getSession();
	    //得到session里的账号信息，若有账号信息，跳转到有账号信系页面
	   account_consumer acc=(account_consumer)hs.getAttribute("acc");
	    if(acc!=null) {
	    	request.getRequestDispatcher("loginfrontpage.jsp").forward(request, response);
	    }
	    //跳转到没有登陆信息界面
	    else {
	    	request.getRequestDispatcher("frontpage.jsp").forward(request, response);

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
