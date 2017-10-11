package dao;

import entiry.order;
import entiry.pagemodel;
import entiry.product_orderinfo;
import entiry.rule;

public interface orderdao {
//分页查询全部数据
	public pagemodel<product_orderinfo> getpagemodel(int pageno, int pagesize);
//分页查询查询待支付订单

	pagemodel<product_orderinfo> getpagemodel01(int pageno, int pagesize,int sreachtype);

}
