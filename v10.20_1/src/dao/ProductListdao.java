package dao;

import java.util.List;

import entiry.Product;
import entiry.pagemodel;
import entiry.rule;

public interface ProductListdao {
//��ѯ�б�
	public List<Product> sreachall();
     //��ҳ��ѯ
	public pagemodel<Product> getpagemodel(int pageno, int pagesize);
	//��ӷ���
	public boolean insertproduct(Product pro);
	//��rule����в�ѯ
	public List<rule> sreachrule();
	//��rule����в���
	public boolean insertrule(rule rule);
	//ɾ������
	public boolean delectproduct(Product pro);
	//�޸ķ���
	public boolean updateproduct(Product pro);
}
