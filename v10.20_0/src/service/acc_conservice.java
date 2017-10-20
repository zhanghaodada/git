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
	//�û�ע��
	public boolean insertacc(account_consumer ac) {
		account_consumerdao acdao=DaoFactory.getInstance("accDao",account_consumerimpl.class);
        boolean flag=acdao.insertacc(ac);
        return flag;
	}
	//�û��޸�����
	public boolean updateacc(account_consumer ac) {
		account_consumerdao acdao=DaoFactory.getInstance("accDao",account_consumerimpl.class);
        boolean flag=acdao.updateacc(ac);
        return flag;
	}
	//�û���½���
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
	//�û���½��������Ϣ��ѯ����
	public consumer_addr sreachconsumer_addr(account_consumer ac) {
		account_consumerdao acdao=DaoFactory.getInstance("accDao",account_consumerimpl.class);
		consumer_addr ca=acdao.sreachconsumer_addr(ac);
		return ca;
	}
	//��ѯ����ַ��Ϣ
	public  List<address> sreachaddress() {
		account_consumerdao acdao=DaoFactory.getInstance("accDao",account_consumerimpl.class);
		List<address> la=acdao.sreachaddr();
		return la;
	}
	//�����û�id�޸ĵ�ַ��Ϣ
	public boolean  updateaddr(int cid,String addr) {
		account_consumerdao acdao=DaoFactory.getInstance("accDao",account_consumerimpl.class);

		boolean flag=acdao.updateaddr(cid, addr);
		return flag;
	}
}
