package dao;

import java.util.List;

import entiry.account_consumer;
import entiry.loginform;

public interface logindao {
  //��½��鷽��
	public loginform testlogin(loginform log) ;
	//��ѯ��Ա��Ϣ
	public List<account_consumer> sreachac();
		
	
}
