package loginservice;

import java.util.List;

import dao.DaoFactory;
import dao.logindao;
import entiry.account_consumer;
import entiry.loginform;
import impl.loginImpl;

public class loginservice {
//	public static void main(String[] args) {
//		loginservice abc=new loginservice();
//		loginform log02=abc.testlogin("asd", "abc");
//		System.out.println("’À∫≈"+log02.getUsername()+"√‹¬Î"+log02.getPassword());
//
//	}
	public loginform testlogin(String username,String password) {
		loginform log=new loginform(username,password);
		logindao logdao01=DaoFactory.getInstance("loginDao",loginImpl.class);
		loginform log02=logdao01.testlogin(log);
		
		return log02;
	}
	public List<account_consumer> sreachac(){
		logindao logdao01=DaoFactory.getInstance("loginDao",loginImpl.class);
		return logdao01.sreachac();
	}
	
}
