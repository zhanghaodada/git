package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Product;
import service.productservice;

/**
 * Servlet implementation class productlistsession
 */
@WebServlet("/productlistsession")
public class productlistsession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productlistsession() {
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
		PrintWriter pw=response.getWriter();
		//session
		HttpSession hs=request.getSession();
		//商品展示页面，点击加入购物车，传值进这个servlet,
		//得到点击加入购物车的商品id
		String pro_id_have=request.getParameter("pro_id");
		//通过点击加入购物
		if(pro_id_have!=null&&!pro_id_have.equals("")) {
			int pro_id=Integer.parseInt(pro_id_have);
			productservice ps=new productservice();
			Product pro=ps.sreachbyid(pro_id);
			System.out.println("商品的Id为"+pro_id);
			//System.out.println("从页面得到的商品为"+pro);
			
			List<Product> productlist=(List<Product>)hs.getAttribute("productlist");
             //判断是否为空
             if(productlist!=null&&!productlist.equals("")) {
            	 boolean flag=false;
            	 //判断购物车是否存在需要加入 购物车的商品id
            	 for(int i=0;i<productlist.size();i++) {
            		 int product_id=productlist.get(i).getId();
            		 //存在相等的情况
            		 if(product_id==pro_id) {
            			 System.out.println("存在商品Id进入状态"+product_id);
            			 int number=productlist.get(i).getNumber();
            			 productlist.get(i).setNumber(number+1);
                         System.out.println("现在session里存的购物车信息为"+productlist);
                         flag=false;
                         break;
            		 }
            		 //购物车中不含有相同的商品
            		 else{
            			 flag=true;            			
            		 }
            	 }
            	 //通过flag判断不存在重复商品情况
            	 if(flag) {
            		 productlist.add(pro);
                   System.out.println("现在session里存的购物车信息为"+productlist);
            	 }
             }
			hs.setAttribute("productlist",productlist);
			List<Product> productlist01=(List<Product>)hs.getAttribute("productlist");
			System.out.println("点击加入购物车后的商品件数"+(productlist01.size()-1));
			//计算商品的件数
			int total_num=0;
			for(int i=0;i<productlist01.size();i++) {
				 total_num+=productlist01.get(i).getNumber();
			}
			pw.print(total_num-1);
		}
		//没有点击加入购物车,显示购物车件数
		else {
			List<Product> productlist=(List<Product>)hs.getAttribute("productlist");
            //判断是否为空
            if(productlist!=null&&!productlist.equals("")) {
            	//计算商品的件数
    			int total_num=0;
    			for(int i=0;i<productlist.size();i++) {
    				 total_num+=productlist.get(i).getNumber();
    			}
    			pw.print(total_num-1);

            }
		}
		
		//String button=request.getParameter("butto");
		//System.out.println("点击购物车得到商品的Id为"+button);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
