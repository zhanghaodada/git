package loginservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import loginservice.orderservice;

/**
 * Servlet implementation class orderservlet
 */
@WebServlet("/orderservlet")
public class orderservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orderservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		orderservice os=new orderservice();
		
		String button=request.getParameter("button");
		//得到隐藏域
		String button_value=request.getParameter("value_have");
		System.out.println("隐藏与的值为"+button_value);
		
		String reqType=request.getParameter("reqType");
		//没有点击效果
		if(button==null||button.equals("")) {
			//没有reqtype的值
			if(reqType==null||reqType.equals("")) {
				//将展示的信息传给页面
				os.getshow(request, response);
			}
			else if(reqType!=null&&!reqType.equals("")) {
				if(reqType.equals("2")) {
					
					
					
					if(button_value==null||button_value.equals("")) {
						System.out.println("隐藏域为空进入");
						os.getMsgsLogic(request, response);
					}
					else {
						System.out.println("隐藏域有值进入");
						os.getMsgsLogic01(request, response);
					}
					
				}
			}
			
		}
		//存在点击事件，全部信息按钮为5，待支付为1，已付款2，已发货为3，已完成为4
		else if(button!=null&&!button.equals("")) {
			
			//request.setAttribute("button_value", button);
			
			if(button.equals("1")||button.equals("2")||button.equals("3")||button.equals("4")) {
				System.out.println("有点击事件进入"+button);
				//进入根据条件选择的分页查询
				os.getshow01(request, response);
			}
             
             if(button.equals("5")) {
            	 //查看全部订单的查询
            	 os.getshow(request, response);
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
