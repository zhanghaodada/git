package service;

import java.util.List;

import dao.DaoFactory;
import dao.orderdao;
import entity.Product;
import entity.orderinfo;
import impl.orderimpl;

public class orderservice {
 //��������
	public boolean insertorder(List<Product> pro,int ca_id) {
		orderdao dao01=DaoFactory.getInstance("orderDao",orderimpl.class);
		boolean flag=dao01.insertorder(pro,ca_id);
		return flag;
	}
	//�޸Ķ���״̬���޸�Ϊ2���޸Ķ�����ע
	public boolean updateorder(orderinfo oi) {
		orderdao dao01=DaoFactory.getInstance("orderDao",orderimpl.class);
		boolean flag=dao01.updateorder(oi);
		return flag;
	}
	
}
