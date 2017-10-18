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
import loginservice.ruleservice;

/**
 * Servlet implementation class productUpdateServlet
 */
@WebServlet("/productUpdateServlet")
public class productUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productUpdateServlet() {
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
				//得到商品展示传进来的id
				String pro_id01=request.getParameter("id");
				System.out.println("商品展示的id"+pro_id01);
				//有点击效果
				if(button_value!=null&&!button_value.equals("")) {
					//得到商品的id
					String id=request.getParameter("product_id");
					System.out.println("从修改页面得到的值id"+id);
					
					
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
					//得到下拉列表的规格参数
					String size=request.getParameter("select_rule");
					//构造参数
					//System.out.println("商品id"+id001+"商品名称"+pname+"cid"+cid01+"商品编号"+pno+"图片"+pic+"价格"+price01+"是否上线"+online01+"商品描述"+detail);
					//如果点击为确认
					if(button_value.equals("1")) {
						
						int id001=Integer.parseInt(id);
						int cid01=Integer.parseInt(cid);
						Double price01=Double.parseDouble(price);
						int online01=Integer.parseInt(online);

						
						Product pro=new Product(id001,pname,cid01,pno,pic,price01,online01,detail,size);
						boolean flag=ps.updateproduct(pro);
						//根据商品id修改rule规格
						rule rule=new rule();
						rule.setPid(id001);
						rule.setSize(size);
						ruleservice rs=new ruleservice();
						rs.updaterule01(rule);
						System.out.println("修改的结果为"+flag);
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
					//将id传进修改界面
					int pro_id=Integer.parseInt(pro_id01);
					Product product=null;
					List<Product> productlist01=ps.sreachall();
					for(int i=0;i<productlist01.size();i++) {
						if(pro_id==productlist01.get(i).getId()) {
							product=productlist01.get(i);
						}
					}
					//向页面传rule的值
					List<rule> rulelist=ps.sreachrule();
					request.setAttribute("rulelist",rulelist);
					//像页面传值
					request.setAttribute("product", product);
					//向页面传类别的值
					for(int i=0;i<catelist.size();i++) {
						System.out.println("catelist存的值为"+catelist.get(i));
					}
				    request.setAttribute("catelist",catelist);
				    request.getRequestDispatcher("ProductUpdate.jsp").forward(request,response);
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
