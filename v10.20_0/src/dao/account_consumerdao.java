package dao;

import java.util.List;

import entity.account_consumer;
import entity.address;
import entity.consumer_addr;

public interface account_consumerdao {
	//查询全部账号全部信息
	public account_consumer sreachlogin(account_consumer ac);
	//注册账号
	public boolean insertacc(account_consumer ac);
	//修改密码
	public boolean updateacc(account_consumer ac);
     //登陆检查
	public account_consumer login(account_consumer ac);
	//登陆时将信息提取出来
	public consumer_addr sreachconsumer_addr(account_consumer ac);
	//地址信息查询
	public List<address> sreachaddr();
	//修改地址信息
	public boolean updateaddr(int cid,String addr);
}
