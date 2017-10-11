package loginservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entiry.cate;
import loginservice.cateservice;

/**
 * Servlet implementation class cateUpdateservlet
 */
@WebServlet("/cateUpdateservlet")
public class cateUpdateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cateUpdateservlet() {
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
		//得到全部信息
		List<cate> selectlist=cs.sreachall();
		request.setAttribute("selectlist",selectlist );
		//得到删除那一行的cid
		String getcid000=request.getParameter("getcid");
		
		
		
		
		
		
		//得到确认按钮的值
		String button_value=request.getParameter("button_name");
		//从页面得到操作类的id
		String getcid_val=request.getParameter("getcid_val");
		//String getcid_val="408";
		System.out.println("button的value"+button_value+"cid的值"+getcid_val);
		//判断得到的值
		if(button_value!=null&&!button_value.equals("")) {
			//点击确定按钮
			if(button_value.equals("true")) {
				String getcname=request.getParameter("update_input");
				//得到下拉框的父类的cid
				String getpartentcid=request.getParameter("select_partent");
				//说明input框里输入了值
				if(getcname!=null&&!getcname.equals("")) {
					
					
					int getpid=Integer.parseInt(getpartentcid);
					int getcid01=Integer.parseInt(getcid_val);
					System.out.println("修改类名时输出cid"+getcid01);
					cate cate01=new cate(getcid01,getcname,getpid);
					cs.updatecate(cate01);
					request.getRequestDispatcher("cateCRUDservlet").forward(request, response);
				}
				
				//没有输入值
				else {
					
					
					
					int getcid01=Integer.parseInt(getcid_val);
					int getpid=Integer.parseInt(getpartentcid);
					System.out.println("不修改类时输出cid==="+getcid_val);
					//循环遍历全部的表拿到与上一页的cid相同的cname再赋值
					String getcname02="as";
					 for(int i=0;i<selectlist.size();i++){
						 if(selectlist.get(i).getCid()==getcid01){
							 getcname02=selectlist.get(i).getCname();
						    }
					 }
					 cate cate01=new cate(getcid01,getcname02,getpid);
					 cs.updatecate(cate01);
					 request.getRequestDispatcher("cateCRUDservlet").forward(request, response);
				}
				
			}
			//点击退出
			else {
				request.getRequestDispatcher("cateCRUDservlet").forward(request, response);
			}
		}
		
		
		//首次进入执行
		else {
		int cid=Integer.parseInt(getcid000);
		System.out.println("进入修改界面输出cid=="+cid);
		request.setAttribute("getcid", cid);
		request.getRequestDispatcher("cateUpdate.jsp").forward(request, response);
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
