package dao;

import java.util.List;

import entiry.cate;
import entiry.pagemodel;

public interface catedao {
//查询出集合，集合类型为(父类cid,父类cname,(子类cid,子类的cname,子类的pid))
	public List<cate> sreachall();
	//增加类方法
	public boolean insertcate(cate cate) ;
	//删除方法
	public boolean deletcate(cate cate);
	//分页查询
	public pagemodel<cate> getpagemodel(int pageno, int pagesize);
	//修改商品类别的名称，pid
	public boolean updatecate(cate cate);
	//删除方法
	public cate rearchId(int cid);
	//删除主方法
	public void delRegion(Integer cid);
	
}
