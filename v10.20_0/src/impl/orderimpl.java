package impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import commend._DBUtils;
import dao.DaoException;
import dao.orderdao;

import entity.Product;
import entity.orderinfo;
import java.util.*;

public class orderimpl implements orderdao {
	QueryRunner qRunner=new QueryRunner();
	@Override
	//�򶩵����������
	public boolean insertorder(List<Product> pro,int ca_id) {
		// TODO Auto-generated method stub
		orderinfo oi=new orderinfo();
		//�����������
		String orderno=UUID.randomUUID().toString().substring(0,8);
		oi.setOrderno(orderno);
		//���ö����µ�ʱ��
		//�õ���ǰʱ��
		SimpleDateFormat formate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String _date=formate.format(System.currentTimeMillis());
		oi.setOrdertime(_date);
		//����֧����ʽ 1Ϊ������
		oi.setOrderstatus(1);
		//��������addrinfo��ֵ
		oi.setAddrinfo(ca_id);
		
		Connection conn=null;
		try{
			conn=_DBUtils.getConnection();
			//��Ӷ������Զ�����id��
			String sql="insert into orderinfo(orderno,orderstatus,ordertime,addrinfo) values(?,?,?,?)";
			int count=qRunner.update(conn, sql,oi.getOrderno(),oi.getOrderstatus(),oi.getOrdertime(),ca_id);			
             //���ݶ�����Ż�ȡId
			String sql01="select id from orderinfo where orderno=?";
			ResultSetHandler<orderinfo> rsh = new BeanHandler<orderinfo>(orderinfo.class);
			orderinfo oo=qRunner.query(conn, sql01,rsh,orderno);
			//������Ʒ�������򶩵���Ʒ�����������,
			for(int i=1;i<pro.size();i++) {
				//������Ʒ�����������
				for(int j=0;j<pro.get(i).getNumber();j++) {
					String sql02="insert into product_orderinfo(orderid,productid) values(?,?)";
					int count02=qRunner.update(conn, sql02,oo.getId(),pro.get(i).getId());	
				}
			}
					
			if(count>0) {
            	 return true;
             }   		
		}catch(SQLException e){
			throw new DaoException("��Ӷ���ʧ��",e);
		}
		finally{
			_DBUtils.close(conn);
		}
		return false;
	}
	@Override
	//���ݶ������addrinfo���޸Ķ�������
	public boolean updateorder(orderinfo oi) {
		// TODO Auto-generated method stub
		Connection conn=null;
		try{
			conn=_DBUtils.getConnection();
			//��Ӷ������Զ�����id��
			String sql="update orderinfo set orderstatus=?,mask=?";
			int count=qRunner.update(conn, sql,2,oi.getMask());			
            	
			if(count>0) {
            	 return true;
             }   		
		}catch(SQLException e){
			throw new DaoException("��Ӷ���ʧ��",e);
		}
		finally{
			_DBUtils.close(conn);
		}
		return false;
	}

}
