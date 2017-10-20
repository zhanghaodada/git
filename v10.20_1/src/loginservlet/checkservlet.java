package loginservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entiry.leaveword;
import entiry.pagemodel;
import loginservice.leavewordservice;

/**
 * Servlet implementation class checkservlet
 */
@WebServlet("/checkservlet")
public class checkservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String reqtype=	request.getParameter("reqtype");
		if(reqtype.equals("1")) {
			//º”‘ÿ¡Ù—‘ƒ⁄»›
			leavewordservice lws=new leavewordservice();
			pagemodel<leaveword>  msgs=lws.getpagemodel(2, 3);
			request.setAttribute("msgs", msgs);
			//request.getRequestDispatcher("leaveword.jsp").forward(request, response);
			
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
