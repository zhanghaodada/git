package servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import entity.address;
import service.acc_conservice;

/**
 * Servlet implementation class acc_manager01servlet
 */
@WebServlet("/acc_manager01servlet")
public class acc_manager01servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public acc_manager01servlet() {
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
		//�˺Ź�����棬����޸�����͵���޸ĵ�ַ
		//ҳ����ؽ��룬��������ֵ
		acc_conservice as=new acc_conservice();
		List<address> la=as.sreachaddress();
		System.out.println("�õ��ĵ�ַ����wield"+la);
		//����gson������ת���ַ���
		Gson gson=new Gson();
		String laa=gson.toJson(la);
		pw.print(laa);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
