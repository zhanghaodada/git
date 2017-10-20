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
import service.acc_conservice;

/**
 * Servlet implementation class loginservlet
 */
@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginservlet() {
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
		
		acc_conservice as=new acc_conservice();
		//�õ������value
		String button=request.getParameter("button");
		String input01=request.getParameter("input01");
		String input02=request.getParameter("input02");
		
		String input03=request.getParameter("input03");
		String input04=request.getParameter("input04");
		System.out.println("��ҳ��õ���ֵΪ"+input01+""+input02);
		//����session
		HttpSession hs=request.getSession();
		
		//
		if(button!=null&&!button.equals("")) {
			//����¼�Ϊ��½
			if(button.equals("1")) {
				account_consumer acc=new account_consumer(input01,input02);
				account_consumer acc00=as.login(acc);
				boolean flag=false;
				if(acc00!=null&&!acc00.equals("")) {
					flag=true;
				}
				System.out.println("�˺������ж�"+flag);
				if(flag) {
					//��ѯ�����˺������ӵľ�����Ϣ��ֵ��session
					consumer_addr ca=as.sreachconsumer_addr(acc);
					System.out.println("ceshi=====consumer_addr"+ca);
					//��������Ϣ��ֵ��session
					hs.setAttribute("ca",ca);
					//���˺ŵ�ֵ����session 
					hs.setAttribute("acc", acc00);
					
				
					
					//��ת���û���½��ҳ��
					request.getRequestDispatcher("loginfrontpage.jsp").forward(request, response);
				}
				else {
					response.sendRedirect("login.jsp");
				}
			}
			//����¼�Ϊע��
			if(button.equals("2")) {
				account_consumer acc=new account_consumer(input03,input04);
				boolean flag=as.insertacc(acc);
				if(flag) {
					pw.print("<script>alert('ע��ɹ�');</script>");
					
				}
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
