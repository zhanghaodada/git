package dao;

import java.util.List;

import entiry.Product;
import entiry.pagemodel;
import entiry.rule;

public interface ProductListdao {
//查询列表
	public List<Product> sreachall();
     //分页查询
	public pagemodel<Product> getpagemodel(int pageno, int pagesize);
	//添加方法
	public boolean insertproduct(Product pro);
	//对rule表进行查询
	public List<rule> sreachrule();
	//对rule表进行插入
	public boolean insertrule(rule rule);
	//删除方法
	public boolean delectproduct(Product pro);
	//修改方法
	public boolean updateproduct(Product pro);
}
