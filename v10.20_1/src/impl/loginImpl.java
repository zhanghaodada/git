package impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import commend._DBUtils;
import dao.DaoException;
import dao.logindao;
import entiry.Product;
import entiry.account_consumer;
import entiry.loginform;

public class loginImpl implements logindao {
	QueryRunner qRunner=new QueryRunner();
	@Override
	public loginform testlogin(loginform log) {
		// TODO Auto-generated method stub
		loginform log01=null;
		Connection conn=null;
		try{
			conn=_DBUtils.getConnection();
			String sql="select loginform_id,username,password from loginform where username=?and password=? ";
			ResultSetHandler<loginform> rsh=new BeanHandler<loginform>(loginform.class);
			log01=qRunner.query(conn, sql,rsh,log.getUsername(),log.getPassword());
			return log01;
		}catch(SQLException e){
			throw new DaoException("登陆失败",e);
		}
		finally{
			_DBUtils.close(conn);
		}
		
	}
	//查询会员信息全部内容
	@Override
	public List<account_consumer> sreachac() {
		// TODO Auto-generated method stub
		List<account_consumer> aclist=new ArrayList<account_consumer>();
		
		Connection conn=null;
		
		try{
			conn=_DBUtils.getConnection();
			String sql01="select id,loginname,password,registertime,lastlogintime,ip from account_consumer";
			ResultSetHandler<List<account_consumer>> rsh01=new BeanListHandler<account_consumer>(account_consumer.class);
			aclist=qRunner.query(conn,sql01,rsh01);



		}catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			DbUtils.closeQuietly(conn);
		}
		return aclist;
	}

}
