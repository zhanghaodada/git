package dao;

import java.util.List;

import entiry.cate;
import entiry.pagemodel;

public interface catedao {
//��ѯ�����ϣ���������Ϊ(����cid,����cname,(����cid,�����cname,�����pid))
	public List<cate> sreachall();
	//�����෽��
	public boolean insertcate(cate cate) ;
	//ɾ������
	public boolean deletcate(cate cate);
	//��ҳ��ѯ
	public pagemodel<cate> getpagemodel(int pageno, int pagesize);
	//�޸���Ʒ�������ƣ�pid
	public boolean updatecate(cate cate);
	//ɾ������
	public cate rearchId(int cid);
	//ɾ��������
	public void delRegion(Integer cid);
	
}
