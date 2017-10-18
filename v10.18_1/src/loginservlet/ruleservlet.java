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
 * Servlet implementation class ruleservlet
 */
@WebServlet("/ruleservlet")
public class ruleservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ruleservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ruleservice rs=new ruleservice();
		List<rule> rulelist=rs.sreachall();
		
		String reqType=request.getParameter("reqType");
		//得到button
		String button_add=request.getParameter("rule_add");
		//得到添加的值
		String rule_size=request.getParameter("input_add");
		
		//判断reqType是否为空，为空则是第一次进入
		if(button_add==null||button_add.equals("")) {
		if(reqType==null||reqType.equals("")) {
			rs.getshow(request, response);
		}
		//分页查询时
				else if(reqType.equals("2")) {
					rs.getMsgsLogic(request, response);
					
				}
		//删除方法
				else if(reqType.equals("3")) {
					String rule_id=request.getParameter("rule_id");
					int id=Integer.parseInt(rule_id);
					rule rr=new rule();
					rr.setId(id);
					rs.deleterule(rr);
					rs.getshow(request, response);
				}
		}
		//点击添加
		else if(button_add!=null&&button_add.equals("1")) {
			rule rule=new rule();
			boolean flag=true;
			//输入的值为空
			
			if(rule_size==null||rule_size.equals("")) {
				System.out.println("测试输入的input框的值"+rule_size);
				flag=false;
				request.setAttribute("flag",flag);
				rs.getshow(request, response);
				//request.getRequestDispatcher("productrule.jsp").forward(request, response);
			}
			else {
				//判断是否存在
				List<rule> rulelist01=rs.sreachall01();
			    for(int i=0;i<rulelist01.size();i++) {
			    	String size=rulelist01.get(i).getSize();
			    	System.out.println("size"+size);
			    	if(size.equals(rule_size)) {
			    		flag=false;
			    		request.setAttribute("flag", flag);
						rs.getshow(request, response);
						return;
			    	}
			    }
				rule.setSize(rule_size);
				System.out.println(rule);
				System.out.println("执行增加方法");
				rs.insertrule(rule);
				request.setAttribute("flag", flag);
				rs.getshow(request, response);
				//request.getRequestDispatcher("productrule.jsp").forward(request, response);
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
