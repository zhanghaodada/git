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
	//向订单表添加数据
	public boolean insertorder(List<Product> pro,int ca_id) {
		// TODO Auto-generated method stub
		orderinfo oi=new orderinfo();
		//给订单付编号
		String orderno=UUID.randomUUID().toString().substring(0,8);
		oi.setOrderno(orderno);
		//设置订单下单时间
		//得到当前时间
		SimpleDateFormat formate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String _date=formate.format(System.currentTimeMillis());
		oi.setOrdertime(_date);
		//设置支付方式 1为待付款
		oi.setOrderstatus(1);
		//给订单的addrinfo赋值
		oi.setAddrinfo(ca_id);
		
		Connection conn=null;
		try{
			conn=_DBUtils.getConnection();
			//添加订单，自动生成id，
			String sql="insert into orderinfo(orderno,orderstatus,ordertime,addrinfo) values(?,?,?,?)";
			int count=qRunner.update(conn, sql,oi.getOrderno(),oi.getOrderstatus(),oi.getOrdertime(),ca_id);			
             //根据订单编号获取Id
			String sql01="select id from orderinfo where orderno=?";
			ResultSetHandler<orderinfo> rsh = new BeanHandler<orderinfo>(orderinfo.class);
			orderinfo oo=qRunner.query(conn, sql01,rsh,orderno);
			//根据商品的数量向订单商品表里添加数据,
			for(int i=1;i<pro.size();i++) {
				//根据商品的数量来添加
				for(int j=0;j<pro.get(i).getNumber();j++) {
					String sql02="insert into product_orderinfo(orderid,productid) values(?,?)";
					int count02=qRunner.update(conn, sql02,oo.getId(),pro.get(i).getId());	
				}
			}
					
			if(count>0) {
            	 return true;
             }   		
		}catch(SQLException e){
			throw new DaoException("添加订单失败",e);
		}
		finally{
			_DBUtils.close(conn);
		}
		return false;
	}
	@Override
	//根据订单里的addrinfo来修改订单描述
	public boolean updateorder(orderinfo oi) {
		// TODO Auto-generated method stub
		Connection conn=null;
		try{
			conn=_DBUtils.getConnection();
			//添加订单，自动生成id，
			String sql="update orderinfo set orderstatus=?,mask=?";
			int count=qRunner.update(conn, sql,2,oi.getMask());			
            	
			if(count>0) {
            	 return true;
             }   		
		}catch(SQLException e){
			throw new DaoException("添加订单失败",e);
		}
		finally{
			_DBUtils.close(conn);
		}
		return false;
	}

}
