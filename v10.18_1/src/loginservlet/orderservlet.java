package loginservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import loginservice.orderservice;

/**
 * Servlet implementation class orderservlet
 */
@WebServlet("/orderservlet")
public class orderservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orderservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		orderservice os=new orderservice();
		
		String button=request.getParameter("button");
		//�õ�������
		String button_value=request.getParameter("value_have");
		System.out.println("�������ֵΪ"+button_value);
		
		String reqType=request.getParameter("reqType");
		//û�е��Ч��
		if(button==null||button.equals("")) {
			//û��reqtype��ֵ
			if(reqType==null||reqType.equals("")) {
				//��չʾ����Ϣ����ҳ��
				os.getshow(request, response);
			}
			else if(reqType!=null&&!reqType.equals("")) {
				if(reqType.equals("2")) {
					
					
					
					if(button_value==null||button_value.equals("")) {
						System.out.println("������Ϊ�ս���");
						os.getMsgsLogic(request, response);
					}
					else {
						System.out.println("��������ֵ����");
						os.getMsgsLogic01(request, response);
					}
					
				}
			}
			
		}
		//���ڵ���¼���ȫ����Ϣ��ťΪ5����֧��Ϊ1���Ѹ���2���ѷ���Ϊ3�������Ϊ4
		else if(button!=null&&!button.equals("")) {
			
			//request.setAttribute("button_value", button);
			
			if(button.equals("1")||button.equals("2")||button.equals("3")||button.equals("4")) {
				System.out.println("�е���¼�����"+button);
				//�����������ѡ��ķ�ҳ��ѯ
				os.getshow01(request, response);
			}
             
             if(button.equals("5")) {
            	 //�鿴ȫ�������Ĳ�ѯ
            	 os.getshow(request, response);
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
