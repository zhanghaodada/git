package dao;

import entiry.order;
import entiry.pagemodel;
import entiry.product_orderinfo;
import entiry.rule;

public interface orderdao {
//��ҳ��ѯȫ������
	public pagemodel<product_orderinfo> getpagemodel(int pageno, int pagesize);
//��ҳ��ѯ��ѯ��֧������

	pagemodel<product_orderinfo> getpagemodel01(int pageno, int pagesize,int sreachtype);

}
