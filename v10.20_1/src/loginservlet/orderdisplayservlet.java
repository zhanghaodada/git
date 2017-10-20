package loginservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entiry.order;
import entiry.pagemodel;
import entiry.product_orderinfo;
import loginservice.orderservice;

/**
 * Servlet implementation class orderdisplayservlet
 */
@WebServlet("/orderdisplayservlet")
public class orderdisplayservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orderdisplayservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		orderservice os=new orderservice();
		String orderid=request.getParameter("order_id");
		String page_no=request.getParameter("pageno");
		String page_size=request.getParameter("pagesize");
		String sreach=request.getParameter("sreachtype");
		String button_value=request.getParameter("button_back");
	    System.out.println("从订单页面得到的值为"+orderid+","+page_no+","+page_size+","+sreach);
		//得到button的值，为返回值为1
	    if(button_value!=null&&!button_value.equals("")) {
			if(button_value.equals("1")) {
			   request.getRequestDispatcher("orderservlet").forward(request, response);

			}
		}
	    //加载页面值
		else if(orderid!=null&&!orderid.equals("")) {
			//得到商品的id
			int order_id=Integer.parseInt(orderid);
			int pageno=Integer.parseInt(page_no);
			int pagesize=Integer.parseInt(page_size);
			
			if(sreach!=null&&!sreach.equals("")) {
				//得到查询的类型，1，2，3，4
				int sreachtype=Integer.parseInt(sreach);
				pagemodel<product_orderinfo> orderlist=os.getpagemodel01(pageno, pagesize,sreachtype);
				System.out.println(orderlist);
				product_orderinfo po=null;
				for(int i=0;i<orderlist.getDatas().size();i++) {
					System.out.println("查询的列表为"+orderlist.getDatas().get(i));
					if(orderlist.getDatas().get(i).getOrderid()==order_id) {
						po=orderlist.getDatas().get(i);
					}
				}
				request.setAttribute("order",po);
			    request.getRequestDispatcher("orderdisplay.jsp").forward(request, response);
				
			}
			else {
				pagemodel<product_orderinfo> orderlist=os.getpagemodel(pageno, pagesize);
				System.out.println(orderlist);
				product_orderinfo po=null;
				for(int i=0;i<orderlist.getDatas().size();i++) {
					System.out.println("查询的列表为"+orderlist.getDatas().get(i));
					if(orderlist.getDatas().get(i).getOrderid()==order_id) {
						po=orderlist.getDatas().get(i);
					}
				}
				request.setAttribute("order",po);
			    request.getRequestDispatcher("orderdisplay.jsp").forward(request, response);
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
