package dao;

import java.util.List;

import entity.account_consumer;
import entity.address;
import entity.consumer_addr;

public interface account_consumerdao {
	//��ѯȫ���˺�ȫ����Ϣ
	public account_consumer sreachlogin(account_consumer ac);
	//ע���˺�
	public boolean insertacc(account_consumer ac);
	//�޸�����
	public boolean updateacc(account_consumer ac);
     //��½���
	public account_consumer login(account_consumer ac);
	//��½ʱ����Ϣ��ȡ����
	public consumer_addr sreachconsumer_addr(account_consumer ac);
	//��ַ��Ϣ��ѯ
	public List<address> sreachaddr();
	//�޸ĵ�ַ��Ϣ
	public boolean updateaddr(int cid,String addr);
}
