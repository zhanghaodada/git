package service;

import java.util.List;

import dao.DaoFactory;
import dao.orderdao;
import entity.Product;
import impl.orderimpl;

public class orderservice {
 //´´½¨¶©µ¥
	public boolean insertorder(List<Product> pro) {
		orderdao dao01=DaoFactory.getInstance("orderDao",orderimpl.class);
		boolean flag=dao01.insertorder(pro);
		return flag;
	}
	
}
