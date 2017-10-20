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
import entity.consumer_addr;
import service.acc_conservice;

/**
 * Servlet implementation class acc_con_addressservlet
 */
@WebServlet("/acc_con_addressservlet")
public class acc_con_addressservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public acc_con_addressservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//点击修改地址后，修改数据库地址的值，修改session地址值，如果reqtype为1，则跳转到支付页面，获取新的商品集合
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		String reqtype=request.getParameter("reqtype");
		String select01=request.getParameter("select01");
		String select02=request.getParameter("select02");
		String select03=request.getParameter("select03");
		String address=request.getParameter("address");
		//拼接成总地址
		String sum_addr=select01+select02+select03+address;
		//从session里获取用户id
		HttpSession hs=request.getSession();
		account_consumer acc=(account_consumer)hs.getAttribute("acc");
		int acc_id=acc.getId();
		System.out.println("修改地址信息得到的Id为"+acc_id);
		//修改session里的具体信息
		consumer_addr ca=(consumer_addr)hs.getAttribute("ca");
		ca.setAddr(sum_addr);
		//修改数据库
		acc_conservice as=new acc_conservice();
		pw.print(as.updateaddr(acc_id, sum_addr));
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
