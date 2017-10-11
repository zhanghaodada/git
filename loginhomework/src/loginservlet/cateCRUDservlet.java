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
		
		//得到添加下拉框的cid
		String option_value=request.getParameter("add_select");
		String cname=request.getParameter("input_add");
		String add_button=request.getParameter("add_button");
		
		//添加
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
		
		//得到删除的cid
		String reqType=request.getParameter("reqType");
		String delet_cid=request.getParameter("delet_cid");
		
		
		

			//request.getRequestDispatcher("cateCRUD.jsp").forward(request, response);
		
		
		
		//分页查询
		
		if(reqType==null||reqType.equals("")) {
			//加载留言内容
			System.out.println("reqtype为空进入赋值界面");
			
			cs.getshow(request, response);
		}
		
		
		
		if(reqType!=null&&!reqType.equals("")) {

			if(reqType.equals("2")) {
				  //从网页的标签获取
				   String pageno=request.getParameter("pageno");
				   int _pageno=Integer.parseInt(pageno);
			
				//加载留言内容
				System.out.println("reqtype不为空进入赋值");
				cs.getMsgsLogic(request, response);
			}
			
			
			if(reqType.equals("66")) {
				int cid00=Integer.parseInt(delet_cid);
				cs.delRegion(cid00);
				System.out.println("进入删除方法删除成功哦");
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
