package impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import commend._DBUtils;
import dao.DaoException;
import dao.account_consumerdao;

import entity.account_consumer;
import entity.address;
import entity.cate;
import entity.consumer_addr;

public class account_consumerimpl implements account_consumerdao {

	QueryRunner qRunner=new QueryRunner();
	@Override
	public account_consumer login(account_consumer ac) {
		// TODO Auto-generated method stub
		account_consumer ac01=null;
		Connection conn=null;
		try{
			

			conn=_DBUtils.getConnection();
			String sql="select id,loginname,password,registertime,lastlogintime,ip from account_consumer where loginname=? and password=? ";
			ResultSetHandler<account_consumer> rsh=new BeanHandler<account_consumer>(account_consumer.class);
			ac01=qRunner.query(conn, sql,rsh,ac.getLoginname(),ac.getPassword());
			return ac01;
		}catch(SQLException e){
			throw new DaoException("登陆失败",e);
		}
		finally{
			_DBUtils.close(conn);
		}
		
	}
	@Override
	//用户登陆时查询出对应的详细信息
	public consumer_addr sreachconsumer_addr(account_consumer ac) {
		// TODO Auto-generated method stub
		account_consumer ac01=null;
		consumer_addr ca=null;
		Connection conn=null;
		try{
			conn=_DBUtils.getConnection();
			String sql="select * from account_consumer where loginname=? and password=? ";
			ResultSetHandler<account_consumer> rsh=new BeanHandler<account_consumer>(account_consumer.class);
			ac01=qRunner.query(conn, sql,rsh,ac.getLoginname(),ac.getPassword());
			String sql01="select * from consumer_addr where cid=?";
			ResultSetHandler<consumer_addr> rsh01=new BeanHandler<consumer_addr>(consumer_addr.class);
			ca=qRunner.query(conn, sql01,rsh01,ac01.getId());
		}catch(SQLException e){
			throw new DaoException("登陆失败",e);
		}
		finally{
			_DBUtils.close(conn);
		}
		return ca;
	}
	
	
	
	
	
	
	
	
	@Override
	//查询地址信息
	public List<address> sreachaddr() {
		// TODO Auto-generated method stub
		List<address> ac01=null;
		Connection conn=null;
		try{
			conn=_DBUtils.getConnection();
			//查询出最高类
			String sql00="select cid,aname,pid from address where pid is null";
			ResultSetHandler<List<address>> rsh00=new BeanListHandler<address>(address.class);
			ac01=qRunner.query(conn,sql00,rsh00);
			 for(int j=0;j<ac01.size();j++) {
			String sql01="select c.cid,c.aname,c.pid\r\n" + 
					"from address c\r\n" + 
					"join\r\n" + 
					"(select *\r\n" + 
					"from address\r\n" + 
					"where pid is null) ss\r\n" + 
					"on c.pid=ss.cid and ss.cid=?";
			ResultSetHandler<List<address>> rsh01=new BeanListHandler<address>(address.class);
			List<address> catelist00=qRunner.query(conn,sql01,rsh01,ac01.get(j).getCid());
			ac01.get(j).setAddrlist(catelist00);
			//上面是查询出电子产品和电脑，下面查询下面的子类
			for(int i=0;i<catelist00.size();i++) {
				int _cid=catelist00.get(i).getCid();
				String sql02="select cc.cid,cc.aname,cc.pid\r\n" + 
						"from address cc\r\n" + 
						"join\r\n" + 
						"(select c.cid,c.aname,c.pid\r\n" + 
						"from address c\r\n" + 
						"join\r\n" + 
						"(select *\r\n" + 
						"from address\r\n" + 
						"where pid is null) ss\r\n" + 
						"on c.pid=ss.cid) ccc\r\n" + 
						"on ccc.cid=cc.pid and ccc.cid=?";
				ResultSetHandler<List<address>> rsh02=new BeanListHandler<address>(address.class);
				List<address> catelist01=qRunner.query(conn,sql02,rsh02,_cid);
				catelist00.get(i).setAddrlist(catelist01);
				
			}
			 }
			
		}catch(SQLException e){
			throw new DaoException("查询地址失败",e);
		}
		finally{
			_DBUtils.close(conn);
		}
		return ac01;
	}
	@Override
	//根据账号的Id修改具体信息的地址
	public boolean updateaddr(int cid, String addr) {
		// TODO Auto-generated method stub
		Connection conn=null;
		try{
			conn=_DBUtils.getConnection();
			String sql="update consumer_addr set addr=? where cid=?";
			int count=qRunner.update(conn, sql,addr,cid);			
             if(count>0) {
            	 return true;
             }   		
		}catch(SQLException e){
			throw new DaoException("修改信息失败",e);
		}
		finally{
			_DBUtils.close(conn);
		}
		return false;
	}
	@Override
	//根据登陆账号密码查询全部
	public account_consumer sreachlogin(account_consumer ac) {
		// TODO Auto-generated method stub
		
		return null;
	}
	@Override
	//注册账号
	public boolean insertacc(account_consumer ac) {
		// TODO Auto-generated method stub
		Connection conn=null;
		try{
			conn=_DBUtils.getConnection();
			String sql="insert into account_consumer(loginname,password,registertime,lastlogintime,ip) values(?,?,?,?,?) ";
			int count=qRunner.update(conn, sql,ac.getLoginname(),ac.getPassword(),ac.getRegistertime(),ac.getLastlogintime(),ac.getIp());			
             if(count>0) {
            	 return true;
             }   		
		}catch(SQLException e){
			throw new DaoException("注册账号失败",e);
		}
		finally{
			_DBUtils.close(conn);
		}
		return false;
	}
	@Override
	//修改密码
	public boolean updateacc(account_consumer ac) {
		// TODO Auto-generated method stub
		Connection conn=null;
		try{
			conn=_DBUtils.getConnection();
			String sql="update account_consumer set password=? where id=?";
			int count=qRunner.update(conn, sql,ac.getPassword(),ac.getId());			
             
			if(count>0) {
            	 return true;
             }   		
		}catch(SQLException e){
			throw new DaoException("修改密码失败",e);
		}
		finally{
			_DBUtils.close(conn);
		}
		
		
		return false;
	}

}
