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
		//����ҳ�õ���𣬱��绪Ϊ��õ���Ϊ�����cid
		//String pro_pid=request.getParameter("cate_cid");
		String reqType=request.getParameter("reqType");
		
		//����session ��ȡsession��ֵ
		HttpSession hs=request.getSession();
		//���õ���ת��account_consumer
		account_consumer acc=(account_consumer)hs.getAttribute("acc");
		System.out.println(acc);
		//���˺ŵ�½ʱ
		if(acc!=null) {
			if(reqType==null||reqType.equals("")) {
				//��ת���е�½����Ʒչʾ��ҳ
				ps.getshow02(request, response);
			}
			else if(reqType.equals("2")) {
				//��ת���е�½����Ʒ��ҳ
				ps.getMsgsLogic02(request, response);
			}
		}
		//û���˺ŵ�½ʱ
		else {
		if(reqType==null||reqType.equals("")) {
			//��ת��û�е�½����Ʒչʾ��ҳ
			ps.getshow01(request, response);
		}
		else if(reqType.equals("2")) {
			//��תû�е�½����Ʒչʾ��ҳ
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
