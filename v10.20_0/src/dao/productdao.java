package dao;

import entity.Product;
import entity.pagemodel;

public interface productdao {
	//��ҳ��ѯ
	public pagemodel<Product> getpagemodel01(int pageno, int pagesize,int sreachtype);
	//������Ʒid��ѯ
	public Product sreachbyid(int id);
}
