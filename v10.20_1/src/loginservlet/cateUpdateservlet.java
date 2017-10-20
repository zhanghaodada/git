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
		//�õ�ȫ����Ϣ
		List<cate> selectlist=cs.sreachall();
		request.setAttribute("selectlist",selectlist );
		//�õ�ɾ����һ�е�cid
		String getcid000=request.getParameter("getcid");
		
		
		
		
		
		
		//�õ�ȷ�ϰ�ť��ֵ
		String button_value=request.getParameter("button_name");
		//��ҳ��õ��������id
		String getcid_val=request.getParameter("getcid_val");
		//String getcid_val="408";
		System.out.println("button��value"+button_value+"cid��ֵ"+getcid_val);
		//�жϵõ���ֵ
		if(button_value!=null&&!button_value.equals("")) {
			//���ȷ����ť
			if(button_value.equals("true")) {
				String getcname=request.getParameter("update_input");
				//�õ�������ĸ����cid
				String getpartentcid=request.getParameter("select_partent");
				//˵��input����������ֵ
				if(getcname!=null&&!getcname.equals("")) {
					
					
					int getpid=Integer.parseInt(getpartentcid);
					int getcid01=Integer.parseInt(getcid_val);
					System.out.println("�޸�����ʱ���cid"+getcid01);
					cate cate01=new cate(getcid01,getcname,getpid);
					cs.updatecate(cate01);
					request.getRequestDispatcher("cateCRUDservlet").forward(request, response);
				}
				
				//û������ֵ
				else {
					
					
					
					int getcid01=Integer.parseInt(getcid_val);
					int getpid=Integer.parseInt(getpartentcid);
					System.out.println("���޸���ʱ���cid==="+getcid_val);
					//ѭ������ȫ���ı��õ�����һҳ��cid��ͬ��cname�ٸ�ֵ
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
			//����˳�
			else {
				request.getRequestDispatcher("cateCRUDservlet").forward(request, response);
			}
		}
		
		
		//�״ν���ִ��
		else {
		int cid=Integer.parseInt(getcid000);
		System.out.println("�����޸Ľ������cid=="+cid);
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
