package dao;

import java.util.List;

import entiry.Product;
import entiry.pagemodel;
import entiry.rule;

public interface ruledao {
	//��ѯ����
	public List<rule> sreachall();
	//��ѯ�����У����޸�
	public List<rule> sreachall01();
	//��ҳ��ѯ
	public pagemodel<rule> getpagemodel(int pageno, int pagesize);
	//���ݹ��id���ӹ��ķ���
	public boolean insertrule(rule rule) ;
	//���ݹ��idɾ����񷽷�
	public boolean deleterule(rule rule);
	//���ݹ��id�޸Ĺ�񷽷�
	public boolean updaterule(rule rule);
	//������Ʒid�޸Ĺ��
	public boolean updaterule01(rule rule);
	//������Ʒidɾ�����
	public boolean deleterule01(rule rule);
}
