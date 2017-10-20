package dao;

import java.util.List;

import entity.Product;
import entity.orderinfo;

public interface orderdao {
//新建一个订单，向订单表插入一条数据,同时向product_order表里添加订单
	public boolean insertorder(List<Product> pro,int ca_id);
	// 根据addrinfo修改订单信息
	public boolean updateorder(orderinfo oi);

}
