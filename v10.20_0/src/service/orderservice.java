package service;

import java.util.List;

import dao.DaoFactory;
import dao.orderdao;
import entity.Product;
import entity.orderinfo;
import impl.orderimpl;

public class orderservice {
 //创建订单
	public boolean insertorder(List<Product> pro,int ca_id) {
		orderdao dao01=DaoFactory.getInstance("orderDao",orderimpl.class);
		boolean flag=dao01.insertorder(pro,ca_id);
		return flag;
	}
	//修改订单状态，修改为2，修改订单备注
	public boolean updateorder(orderinfo oi) {
		orderdao dao01=DaoFactory.getInstance("orderDao",orderimpl.class);
		boolean flag=dao01.updateorder(oi);
		return flag;
	}
	
}
