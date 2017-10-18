package dao;

import java.util.List;

import entiry.Product;
import entiry.pagemodel;
import entiry.rule;

public interface ruledao {
	//查询所有
	public List<rule> sreachall();
	//查询表所有，不修改
	public List<rule> sreachall01();
	//分页查询
	public pagemodel<rule> getpagemodel(int pageno, int pagesize);
	//根据规格id增加规格的方法
	public boolean insertrule(rule rule) ;
	//根据规格id删除规格方法
	public boolean deleterule(rule rule);
	//根据规格id修改规格方法
	public boolean updaterule(rule rule);
	//根据商品id修改规格
	public boolean updaterule01(rule rule);
	//根据商品id删除规格
	public boolean deleterule01(rule rule);
}
