package impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import commend._DBUtils;
import dao.DaoException;
import dao.account_consumerdao;

import entity.account_consumer;

public class account_consumerimpl implements account_consumerdao {

	QueryRunner qRunner=new QueryRunner();
	@Override
	public account_consumer login(account_consumer ac) {
		// TODO Auto-generated method stub
		account_consumer ac01=null;
		Connection conn=null;
		try{
			conn=_DBUtils.getConnection();
			String sql="select * from account_consumer where loginname=? and password=? ";
			ResultSetHandler<account_consumer> rsh=new BeanHandler<account_consumer>(account_consumer.class);
			ac01=qRunner.query(conn, sql,rsh,ac.getLoginname(),ac.getPassword());
			return ac01;
		}catch(SQLException e){
			throw new DaoException("µÇÂ½Ê§°Ü",e);
		}
		finally{
			_DBUtils.close(conn);
		}
		
	}

}
