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
		//����޸ĵ�ַ���޸����ݿ��ַ��ֵ���޸�session��ֵַ�����reqtypeΪ1������ת��֧��ҳ�棬��ȡ�µ���Ʒ����
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		String reqtype=request.getParameter("reqtype");
		String select01=request.getParameter("select01");
		String select02=request.getParameter("select02");
		String select03=request.getParameter("select03");
		String address=request.getParameter("address");
		//ƴ�ӳ��ܵ�ַ
		String sum_addr=select01+select02+select03+address;
		//��session���ȡ�û�id
		HttpSession hs=request.getSession();
		account_consumer acc=(account_consumer)hs.getAttribute("acc");
		int acc_id=acc.getId();
		System.out.println("�޸ĵ�ַ��Ϣ�õ���IdΪ"+acc_id);
		//�޸�session��ľ�����Ϣ
		consumer_addr ca=(consumer_addr)hs.getAttribute("ca");
		ca.setAddr(sum_addr);
		//�޸����ݿ�
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
