package dao;

import java.util.List;

import entiry.leaveword;
import entiry.pagemodel;

public interface leaveworddao {
//向mysql里插入数据
	public boolean testinsert(leaveword lw);
	//添加留言
	public boolean testinsertaskword(leaveword lw);
	//查询全部内容
	public List<leaveword> sreachall();
	//分页查询数据
	public pagemodel<leaveword> getpagemodel(int pageno,int pagesize);
	
}
