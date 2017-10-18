package loginservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entiry.Product;
import entiry.rule;
import loginservice.ProductService;
import loginservice.ruleservice;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductService ps=new ProductService();
		List<Product> productlist=ps.sreachall();
		String reqType=request.getParameter("reqType");
		
		String button_link=request.getParameter("button_link");
		
		if(reqType!=null&&!reqType.equals("")) {
			//分页查询设置
			if(reqType.equals("2")) {
				  //从网页的标签获取
				   String pageno=request.getParameter("pageno");
				   int _pageno=Integer.parseInt(pageno);
			
				//加载留言内容
				System.out.println("reqtype不为空进入赋值");
				ps.getMsgsLogic(request, response);
			}
		   //删除设置reqType为3时
			if(reqType.equals("3")) {
				String id=request.getParameter("id");
				int id01=Integer.parseInt(id);
				System.out.println("删除时得到的cid为"+id);
				Product pro=new Product();
				pro.setId(id01);
				ps.deleteproduct(pro);
				//根据商品id删除规格
				rule rule=new rule();
				rule.setPid(id01);
				ruleservice rs=new ruleservice();
				rs.deleterule01(rule);
				
				ps.getshow(request, response);
			}
		}
		//界面没有操作时进入
		 if(reqType==null||reqType.equals("")) {
			 //得到操作按钮
			 if(button_link==null||button_link.equals("")){
				 ps.getshow(request, response);			 
				 }
			 
			 if(button_link!=null&&!button_link.equals("")) {
				 if(button_link.equals("66")) {
					 request.getRequestDispatcher("productAddServlet").forward(request, response);
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
