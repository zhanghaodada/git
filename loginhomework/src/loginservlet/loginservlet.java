package loginservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import commend.MD5;
import entiry.loginform;
import loginservice.loginservice;

/**
 * Servlet implementation class loginservlet
 */
@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public loginservlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("======get方法=========");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		
        PrintWriter pw=response.getWriter();

		
		//得到name为username和password的值
			String name=request.getParameter("username");
			String psw=request.getParameter("password");
			String check=request.getParameter("type");
			HttpSession session=request.getSession();
		    if(check!=null&&!check.equals("")&&check.equals("1")) {
//		    	if(name==null|name.equals("")) {
//		    	   // pw.append("<script>function test_click(){var span=document.getElementById(\"have02_use_span\");span.innerHTML=\"*\";}</script>");
//		    		//response.sendRedirect("login.jsp");
//		    	    return;
//		    	}
//		    	if(psw==null|psw.equals("")) {
////	    		pw.append("<script>function test_click(){ var input_click=documnet.getElementById(\"have03_button\");\r\n" + 
////	    				"	input_click.setAttribute(\"value\",\"注册\");}</script>");
//		    		//response.sendRedirect("login.jsp");
//		    	}
		    	//调用loginservice
				loginservice loginservice=new loginservice();
				loginform log=loginservice.testlogin(name, MD5.GetMD5Code(psw));
			if(log!=null) {
				//pw.append("<script>alert('登陆成功');</script>");
				String ischecked=request.getParameter("checkbox");
				System.out.println(ischecked);
				if(ischecked!=null&&ischecked.equals("1")) {
					//
					Cookie username_cookie=new Cookie("username_cookie",URLEncoder.encode(name,"UTF-8"));
					//
					username_cookie.setMaxAge(7*24*60*60);
					//12345---dsfbsfgfbfvdwretr
					Cookie psw_cookie=new Cookie("password_cookie",MD5.GetMD5Code(psw));
					//System.out.println(MD5.GetMD5Code(psw));
					psw_cookie.setMaxAge(7*24*60*60);
					response.addCookie(username_cookie);
					response.addCookie(psw_cookie);
				}
				session.setAttribute("log",log);
				request.getRequestDispatcher("index.jsp").forward(request,response);
			}
			else {	
				//pw.append("<script>alert('登陆失败');</script>");
//				request.setAttribute("log",new loginform("admin","admin"));
		response.sendRedirect("login.jsp");
//		pw.append("<script>window.onload=function(){"
//				+ "var span01=document.getElementById(\"have03_button\");\r\n" + 
//				"	span01.innerHTML=\"cuo\";}</script>");
	          }
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
