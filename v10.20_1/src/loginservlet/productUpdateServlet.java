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
		//ʵ����productService����
				ProductService ps=new ProductService();
				String button_value=request.getParameter("button");
				//�õ���Ʒչʾ��������id
				String pro_id01=request.getParameter("id");
				System.out.println("��Ʒչʾ��id"+pro_id01);
				//�е��Ч��
				if(button_value!=null&&!button_value.equals("")) {
					//�õ���Ʒ��id
					String id=request.getParameter("product_id");
					System.out.println("���޸�ҳ��õ���ֵid"+id);
					
					
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
					//�õ������б�Ĺ�����
					String size=request.getParameter("select_rule");
					//�������
					//System.out.println("��Ʒid"+id001+"��Ʒ����"+pname+"cid"+cid01+"��Ʒ���"+pno+"ͼƬ"+pic+"�۸�"+price01+"�Ƿ�����"+online01+"��Ʒ����"+detail);
					//������Ϊȷ��
					if(button_value.equals("1")) {
						
						int id001=Integer.parseInt(id);
						int cid01=Integer.parseInt(cid);
						Double price01=Double.parseDouble(price);
						int online01=Integer.parseInt(online);

						
						Product pro=new Product(id001,pname,cid01,pno,pic,price01,online01,detail,size);
						boolean flag=ps.updateproduct(pro);
						//������Ʒid�޸�rule���
						rule rule=new rule();
						rule.setPid(id001);
						rule.setSize(size);
						ruleservice rs=new ruleservice();
						rs.updaterule01(rule);
						System.out.println("�޸ĵĽ��Ϊ"+flag);
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
					//��id�����޸Ľ���
					int pro_id=Integer.parseInt(pro_id01);
					Product product=null;
					List<Product> productlist01=ps.sreachall();
					for(int i=0;i<productlist01.size();i++) {
						if(pro_id==productlist01.get(i).getId()) {
							product=productlist01.get(i);
						}
					}
					//��ҳ�洫rule��ֵ
					List<rule> rulelist=ps.sreachrule();
					request.setAttribute("rulelist",rulelist);
					//��ҳ�洫ֵ
					request.setAttribute("product", product);
					//��ҳ�洫����ֵ
					for(int i=0;i<catelist.size();i++) {
						System.out.println("catelist���ֵΪ"+catelist.get(i));
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
