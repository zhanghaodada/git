package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.account_consumer;
import service.acc_conservice;

/**
 * Servlet implementation class acc_conupdateservlet
 */
@WebServlet("/acc_conupdateservlet")
public class acc_conupdateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public acc_conupdateservlet() {
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
		//点击修改密码进入此界面
		String old=request.getParameter("old");
		String _new=request.getParameter("_new");
		String _new02=request.getParameter("new02");
		HttpSession hs=request.getSession();
		account_consumer acc=(account_consumer)hs.getAttribute("acc");
		boolean flag=true;
		String old_pass=acc.getPassword();
		if(!old_pass.equals(old)) {
			flag=false;
		}
		else {
			//
			account_consumer acc01=new account_consumer();
			acc01.setPassword(_new);
			acc01.setId(acc.getId());
			acc_conservice as=new acc_conservice();
			flag=as.updateacc(acc01);
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
