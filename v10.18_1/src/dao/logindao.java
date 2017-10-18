package dao;

import java.util.List;

import entiry.account_consumer;
import entiry.loginform;

public interface logindao {
  //登陆检查方法
	public loginform testlogin(loginform log) ;
	//查询会员信息
	public List<account_consumer> sreachac();
		
	
}
