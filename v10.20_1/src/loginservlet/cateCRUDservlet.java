package loginservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entiry.cate;
import loginservice.cateservice;
import loginservice.leavewordservice;

/**
 * Servlet implementation class cateCRUDservlet
 */
@WebServlet("/cateCRUDservlet")
public class cateCRUDservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cateCRUDservlet() {
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
		
		
		cateservice cs=new cateservice();
		PrintWriter pw=response.getWriter();
	


		List<cate> selectlist=cs.sreachall();
		request.setAttribute("selectlist",selectlist );
		
		//�õ�����������cid
		String option_value=request.getParameter("add_select");
		String cname=request.getParameter("input_add");
		String add_button=request.getParameter("add_button");
		
		//���
		if(add_button!=null&&!add_button.equals("")) {
			if(option_value!=null&&!option_value.equals("")) {
				System.out.println("input_add====="+cname);
				int pid=Integer.parseInt(option_value);
				System.out.println("select====="+pid);
				cate cate=new cate(cname,pid);
				boolean flag=cs.insertcate(cate);
				cs.getshow(request, response);
				//response.sendRedirect("cateCRUDservlet");
			
				//request.getRequestDispatcher("cateCRUDservlet").forward(request, response);

			}
			
		}
		
		//�õ�ɾ����cid
		String reqType=request.getParameter("reqType");
		String delet_cid=request.getParameter("delet_cid");
		
		
		

			//request.getRequestDispatcher("cateCRUD.jsp").forward(request, response);
		
		
		
		//��ҳ��ѯ
		
		if(reqType==null||reqType.equals("")) {
			//������������
			System.out.println("reqtypeΪ�ս��븳ֵ����");
			
			cs.getshow(request, response);
		}
		
		
		
		if(reqType!=null&&!reqType.equals("")) {

			if(reqType.equals("2")) {
				  //����ҳ�ı�ǩ��ȡ
				   String pageno=request.getParameter("pageno");
				   int _pageno=Integer.parseInt(pageno);
			
				//������������
				System.out.println("reqtype��Ϊ�ս��븳ֵ");
				cs.getMsgsLogic(request, response);
			}
			
			
			if(reqType.equals("66")) {
				int cid00=Integer.parseInt(delet_cid);
				cs.delRegion(cid00);
				System.out.println("����ɾ������ɾ���ɹ�Ŷ");
				cs.getshow(request, response);
				//request.getRequestDispatcher("cateCRUDservlet").forward(request, response);

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
