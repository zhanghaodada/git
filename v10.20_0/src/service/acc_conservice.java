package service;

import java.util.List;

import dao.DaoFactory;
import dao.account_consumerdao;
import entity.account_consumer;
import entity.address;
import entity.consumer_addr;
import impl.account_consumerimpl;

public class acc_conservice {
//public static void main(String[] args) {
//	
//	System.out.println(sreachaddress());
//}
	//用户注册
	public boolean insertacc(account_consumer ac) {
		account_consumerdao acdao=DaoFactory.getInstance("accDao",account_consumerimpl.class);
        boolean flag=acdao.insertacc(ac);
        return flag;
	}
	//用户修改密码
	public boolean updateacc(account_consumer ac) {
		account_consumerdao acdao=DaoFactory.getInstance("accDao",account_consumerimpl.class);
        boolean flag=acdao.updateacc(ac);
        return flag;
	}
	//用户登陆检测
	public static  account_consumer login(account_consumer ac) {
		account_consumerdao acdao=DaoFactory.getInstance("accDao",account_consumerimpl.class);
		account_consumer ac01=acdao.login(ac);
		return ac01;
//		if(ac01!=null&&!ac01.equals("")) {
//			return true;
//		}
//		else {
//			return false;
//		}
		
	}
	//用户登陆将具体信息查询出来
	public consumer_addr sreachconsumer_addr(account_consumer ac) {
		account_consumerdao acdao=DaoFactory.getInstance("accDao",account_consumerimpl.class);
		consumer_addr ca=acdao.sreachconsumer_addr(ac);
		return ca;
	}
	//查询出地址信息
	public  List<address> sreachaddress() {
		account_consumerdao acdao=DaoFactory.getInstance("accDao",account_consumerimpl.class);
		List<address> la=acdao.sreachaddr();
		return la;
	}
	//根据用户id修改地址信息
	public boolean  updateaddr(int cid,String addr) {
		account_consumerdao acdao=DaoFactory.getInstance("accDao",account_consumerimpl.class);

		boolean flag=acdao.updateaddr(cid, addr);
		return flag;
	}
}
