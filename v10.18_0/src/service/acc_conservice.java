package service;

import dao.DaoFactory;
import dao.account_consumerdao;
import entity.account_consumer;
import impl.account_consumerimpl;

public class acc_conservice {
public static void main(String[] args) {
	account_consumer ac=new account_consumer("abc","123");
	System.out.println(login(ac));
}
	public static  boolean login(account_consumer ac) {
		account_consumerdao acdao=DaoFactory.getInstance("accDao",account_consumerimpl.class);
		account_consumer ac01=acdao.login(ac);
		if(ac01!=null&&!ac01.equals("")) {
			return true;
		}
		else {
			return false;
		}
		
	}
}
