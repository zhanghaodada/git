package dao;

import java.util.List;

import entity.Product;
import entity.orderinfo;

public interface orderdao {
//�½�һ���������򶩵������һ������,ͬʱ��product_order������Ӷ���
	public boolean insertorder(List<Product> pro,int ca_id);
	// ����addrinfo�޸Ķ�����Ϣ
	public boolean updateorder(orderinfo oi);

}
