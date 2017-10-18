package dao;

import entity.Product;
import entity.pagemodel;

public interface productdao {
	//分页查询
	public pagemodel<Product> getpagemodel01(int pageno, int pagesize,int sreachtype);
	//根据商品id查询
	public Product sreachbyid(int id);
}
