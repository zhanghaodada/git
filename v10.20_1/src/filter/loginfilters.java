package filter;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entiry.loginform;
import loginservice.loginservice;

/**
 * Servlet Filter implementation class loginfilters
 */
@WebFilter("/login.jsp")
public class loginfilters implements Filter {

    /**
     * Default constructor. 
     */
    public loginfilters() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
         Cookie[] cookies=request.getCookies();
         Cookie username_cookie=null;
         Cookie psw_cookie=null;
         
         String username=null;
         String password=null;
         System.out.println("������ҳ��֮ǰ");
         if(cookies!=null&&cookies.length>0) {
        	 for(Cookie c:cookies) {
        		 String name=c.getName();
        		 String value=c.getValue();
        		 if(name!=null&&name.equals("username_cookie")) {
        			 //����
        			 username=URLDecoder.decode(value,"UTF-8");
        			 System.out.println("������username"+username);
        			 username_cookie=c;
        		 }
        		 if(name!=null&&name.equals("password_cookie")) {
        			 password=value;
        			 System.out.println("������password"+password);
        			 psw_cookie=c;
        		 }
        	 }
         }
         if(username!=null&&password!=null) {
        	loginservice loginservice=new loginservice();
			loginform log=loginservice.testlogin(username,password);
			if(log!=null) {
				HttpSession session=request.getSession();
				session.setAttribute("log", log);
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
			}
			else {
				//�û��˺����뷢���ı�
				System.out.println("û�н���������");
				username_cookie.setMaxAge(0);
				psw_cookie.setMaxAge(0);
				response.addCookie(username_cookie);
				response.addCookie(psw_cookie);
				response.sendRedirect("loginservlet");
			}
         }
		// pass the request along the filter chain
		chain.doFilter(req,resp);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
