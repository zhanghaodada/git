package loginservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entiry.rule;
import loginservice.ruleservice;

/**
 * Servlet implementation class ruleupdateservlet
 */
@WebServlet("/ruleupdateservlet")
public class ruleupdateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ruleupdateservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ruleservice rs=new ruleservice();
		String button=request.getParameter("button");
		String pname=request.getParameter("pname");
		
		String id=request.getParameter("id");
		//System.out.println("进入规格修改时"+pname+"id"+id);
		//得到点击的值
		if(button==null||button.equals("")) {
			rule rr=new rule();
			//
			int id01=Integer.parseInt(id);
			rr.setId(id01);
			rr.setSize(pname);
			System.out.println("rule的值为"+rr);
			request.setAttribute("rule",rr );
			request.getRequestDispatcher("ruleupdate.jsp").forward(request, response);
		}
		else if(button!=null&&!button.equals("")) {
			if(button.equals("1")) {
				String rule_id=request.getParameter("rule_id");
				int rule_id01=Integer.parseInt(rule_id);
				String rule_size=request.getParameter("rule_size");
				rule rule=new rule();
				rule.setId(rule_id01);
				rule.setSize(rule_size);
				rs.updaterule(rule);
				request.getRequestDispatcher("ruleservlet").forward(request, response);

			}
			if(button.equals("0")) {
				request.getRequestDispatcher("ruleservlet").forward(request, response);
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
