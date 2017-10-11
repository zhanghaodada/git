package loginservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entiry.Product;
import entiry.cate;
import entiry.rule;
import loginservice.ProductService;
import loginservice.cateservice;

/**
 * Servlet implementation class productAdd
 */
@WebServlet("/productAddServlet")
public class productAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//实例化productService对象
		ProductService ps=new ProductService();
		String button_value=request.getParameter("button");
		//有点击效果
		if(button_value!=null&&!button_value.equals("")) {
			//得到商品名称
			String pname=request.getParameter("pname_input");
			//得到所属类别
			String cid=request.getParameter("select_cid");
			
			//得到货号
			String pno=request.getParameter("input_pno");
			//得到商品图片地址
			String pic=request.getParameter("input_pic");
			//得到桑品价格
			String price=request.getParameter("input_price");
			
			//得到是否上线
			String online=request.getParameter("select_online");
			//得到描述
			String detail=request.getParameter("input_detail");
			//得到下拉列表的值
			String size=request.getParameter("select_rule");
			System.out.println("添加商品时得到下拉列表的值为"+size);
			
			//构造参数
			///System.out.println("商品名称"+pname+"cid"+cid01+"商品编号"+pno+"图片"+pic+"价格"+price01+"是否上线"+online01+"商品描述"+detail);
			//如果点击为确认
			if(button_value.equals("1")) {
				int cid01=Integer.parseInt(cid);
				Double price01=Double.parseDouble(price);
				int online01=Integer.parseInt(online);
//				rule rule=new rule();
//				ps.insertrule(rule);
				Product pro=new Product(pname,cid01,pno,pic,price01,online01,detail,size);
				boolean flag=ps.insertproduct(pro);
				System.out.println(flag);
	
				request.getRequestDispatcher("ProductServlet").forward(request, response);

				
			}
			//如果点击为取消
			if(button_value.equals("0")) {
			  request.getRequestDispatcher("ProductServlet").forward(request, response);
			}
		}
		//没有点击效果，页面加载
		else {
			System.out.println("没有点击效果进入");
			cateservice cs=new cateservice();
			List<cate> catelist=cs.sreachall();
			List<rule> rulelist=ps.sreachrule();
			request.setAttribute("rulelist",rulelist);
		    request.setAttribute("catelist",catelist);
		    request.getRequestDispatcher("productadd.jsp").forward(request,response);
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
