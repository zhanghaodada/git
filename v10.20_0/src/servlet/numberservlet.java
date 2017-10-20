package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Product;

/**
 * Servlet implementation class numberservlet
 */
@WebServlet("/numberservlet")
public class numberservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public numberservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//�޸���Ʒ�������ӻ����������ҳ��
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		//����session
		HttpSession hs=request.getSession();
		List<Product> pl=(List<Product>)hs.getAttribute("productlist");
		//�õ�������type��ֵ��typeΪ1Ϊ��������typeΪ2Ϊ�Ӳ���
		String type=request.getParameter("type");
		//�õ���Ʒid
		String pro_id=request.getParameter("pro_id");
		
		if(pro_id!=null&&!pro_id.equals("")) {
			int p_id=Integer.parseInt(pro_id);
			boolean flag=true;
			for(int i=0;i<pl.size();i++) {
				if(pl.get(i).getId()==p_id) {
					//�ж�type��1����2
					if(type.equals("1")) {
						pl.get(i).setNumber(pl.get(i).getNumber()-1);
						pw.print(flag);
					}
					else if(type.equals("2")) {
						pl.get(i).setNumber(pl.get(i).getNumber()+1);
						pw.print(flag);
					}
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
