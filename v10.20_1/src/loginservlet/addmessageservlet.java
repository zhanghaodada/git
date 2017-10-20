package loginservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entiry.leaveword;
import loginservice.leavewordservice;

/**
 * Servlet implementation class addmessageservlet
 */
@WebServlet("/addmessageservlet")
public class addmessageservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addmessageservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//msg_nickname msg_email msg_title msg_content
		
		//ͨ��name��ȡֵ
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String reqType=request.getParameter("reqType");
		if(reqType==null||reqType.equals("")) {
			//������������
			System.out.println("reqtypeΪ�ս��븳ֵ����");
			leavewordservice lws=new leavewordservice();
			lws.getshow(request, response);
		}
		
		
		
		if(reqType!=null&&!reqType.equals("")) {
		//�ж�reqtype==1
		if(reqType.equals("1")) {
		String nikename=request.getParameter("msg_nickname");
		String msg_email=request.getParameter("msg_email");
		String msg_title=request.getParameter("msg_title");
		String msg_content=request.getParameter("msg_content");
		String msg_computerip=request.getLocalAddr();
		//�õ���ǰʱ��
		SimpleDateFormat formate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String _date=formate.format(System.currentTimeMillis());
		leaveword lw=new leaveword(nikename,msg_email,msg_title,msg_content,msg_computerip,_date);
		leavewordservice lws=new leavewordservice();
		boolean flag=lws.testinsert(lw);
		
		//���
		leaveword lw02=new leaveword(msg_title,"�������򵥣��Ͳ�����ˣ�");
		lws.testinsertaskword(lw02);
		lw.setLaskword(lw02.getLaskword());
		
		
		
		
		if(flag) {
			System.out.println("��ӳɹ���");
			//request.setAttribute("leaveword", lw);
			response.sendRedirect("addmessageservlet?reqType=2&pageno=1&pagesize=3");

		}
		else {
			System.out.println("���ʧ�ܣ�");
		}
		}
		//reqtype==2
		else if(reqType.equals("2")) {
			  //����ҳ�ı�ǩ��ȡ
			   String pageno=request.getParameter("pageno");
			   int _pageno=Integer.parseInt(pageno);
			   PrintWriter pw=response.getWriter();
			
			//������������
			leavewordservice lws=new leavewordservice();
			//List<leaveword> leaveword_sum=lws.sreachall();
			System.out.println("reqtype��Ϊ�ս��븳ֵ");
			lws.getMsgsLogic(request, response);
		}
		
	}
		
			
		
	}

}
