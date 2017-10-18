package filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import entiry.leaveword;
import loginservice.leavewordservice;

/**
 * Servlet Filter implementation class leavewordfilter
 */
@WebFilter("/leavewordfilter")
public class leavewordfilter implements Filter {

    /**
     * Default constructor. 
     */
    public leavewordfilter() {
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
	@SuppressWarnings("unused")
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		
//		//º”‘ÿ¡Ù—‘ƒ⁄»›
//		leavewordservice lws=new leavewordservice();
//		//List<leaveword> leaveword_sum=lws.sreachall();
//		lws.getMsgsLogic(request, response);
//		String check=request.getParameter("type");
//		if(check.equals("")&&!check.equals("1")&&check==null) 
//		{
//			leavewordservice lws=new leavewordservice();
//			lws.getshow(request, response);
//		}
//	
		
		
        
		chain.doFilter(request, response);
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
