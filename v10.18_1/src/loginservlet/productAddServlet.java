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
		//ʵ����productService����
		ProductService ps=new ProductService();
		String button_value=request.getParameter("button");
		//�е��Ч��
		if(button_value!=null&&!button_value.equals("")) {
			//�õ���Ʒ����
			String pname=request.getParameter("pname_input");
			//�õ��������
			String cid=request.getParameter("select_cid");
			
			//�õ�����
			String pno=request.getParameter("input_pno");
			//�õ���ƷͼƬ��ַ
			String pic=request.getParameter("input_pic");
			//�õ�ɣƷ�۸�
			String price=request.getParameter("input_price");
			
			//�õ��Ƿ�����
			String online=request.getParameter("select_online");
			//�õ�����
			String detail=request.getParameter("input_detail");
			//�õ������б��ֵ
			String size=request.getParameter("select_rule");
			System.out.println("�����Ʒʱ�õ������б��ֵΪ"+size);
			
			//�������
			///System.out.println("��Ʒ����"+pname+"cid"+cid01+"��Ʒ���"+pno+"ͼƬ"+pic+"�۸�"+price01+"�Ƿ�����"+online01+"��Ʒ����"+detail);
			//������Ϊȷ��
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
			//������Ϊȡ��
			if(button_value.equals("0")) {
			  request.getRequestDispatcher("ProductServlet").forward(request, response);
			}
		}
		//û�е��Ч����ҳ�����
		else {
			System.out.println("û�е��Ч������");
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
