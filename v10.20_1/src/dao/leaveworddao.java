package dao;

import java.util.List;

import entiry.leaveword;
import entiry.pagemodel;

public interface leaveworddao {
//��mysql���������
	public boolean testinsert(leaveword lw);
	//�������
	public boolean testinsertaskword(leaveword lw);
	//��ѯȫ������
	public List<leaveword> sreachall();
	//��ҳ��ѯ����
	public pagemodel<leaveword> getpagemodel(int pageno,int pagesize);
	
}
