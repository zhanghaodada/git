package impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import commend._DBUtils;
import dao.DaoException;
import dao.ruledao;
import entiry.Product;
import entiry.cate;
import entiry.pagemodel;
import entiry.rule;

public class ruleImpl implements ruledao {
	QueryRunner qRunner=new QueryRunner();
	
	
	//查询表全部，不修改查询
	public List<rule> sreachall01() {
		// TODO Auto-generated method stub
        List<rule> rulelist=new ArrayList<rule>();
		
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		try{
			conn=_DBUtils.getConnection();
			String sql01="select id,pid,size from rule";
			ResultSetHandler<List<rule>> rsh01=new BeanListHandler<rule>(rule.class);
			rulelist=qRunner.query(conn,sql01,rsh01);
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			DbUtils.closeQuietly(conn);
		}
		return rulelist;
	}
	@Override
	//查询全部
	public List<rule> sreachall() {
		// TODO Auto-generated method stub
        List<rule> rulelist=new ArrayList<rule>();
		
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		try{
			conn=_DBUtils.getConnection();
			String sql01="select r.id,r.pid,p.pname,r.size\r\n" + 
					"from rule r\r\n" + 
					"join product p\r\n" + 
					"where r.pid=p.id";
			ResultSetHandler<List<rule>> rsh01=new BeanListHandler<rule>(rule.class);
			rulelist=qRunner.query(conn,sql01,rsh01);
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			DbUtils.closeQuietly(conn);
		}
		return rulelist;
	}
	//分页查询数据
			@Override
			public pagemodel<rule> getpagemodel(int pageno, int pagesize) {
				// TODO Auto-generated method stub
				pagemodel<rule> model=null;
				Connection conn=null;
				try{
					conn=_DBUtils.getConnection();
					String totalcount_sql="select count(id) from rule";
					//String sql="select nikename,lemail,ltitle,lwords,lcomputerip,ldatatime,laskword from leaveword";
					ResultSetHandler<Long> rsh=new ScalarHandler<Long>();
					
					Integer totalcount=qRunner.query(conn,totalcount_sql,rsh).intValue();
					
					if(totalcount>0) {
						//分页查询
						
						model=new pagemodel<rule>();
						model.setTotalcount(totalcount);
						
//						String sql="select r.id id,r.pid pid,p.pname pname,r.size size\r\n" + 
//								"					from rule r\r\n" + 
//								"					join product p\r\n" + 
//								"					where r.pid=p.id\r\n" + 
//								"order by id desc limit ?,?";
						String sql="select id,pid,size from rule order by id desc limit ?,?";
						ResultSetHandler<List<rule>> rsh01=new BeanListHandler<rule>(rule.class);
						Object[] params= {(pageno-1)*pagesize,pagesize};
						List<rule> leaveword=qRunner.query(conn,sql,rsh01,params);
						//将pid新添加的为null的添加到集合里
						
						model.setDatas(leaveword);
					}
					

				}catch(SQLException e){
					e.printStackTrace();
				}
				finally{
					_DBUtils.close(conn);
				}
				return model;
			}
     //添加规格
			public boolean insertrule(rule rule) {
				Connection conn=null;
				try{
					conn=_DBUtils.getConnection();
					String sql="insert into rule(size) values(?)";
					//ResultSetHandler<loginform> rsh=new BeanHandler<loginform>(loginform.class);
					int count=qRunner.update(conn, sql,rule.getSize());			
		             if(count>0) {
		            	 return true;
		             }   		
				}catch(SQLException e){
					throw new DaoException("添加规格失败",e);
				}
				finally{
					DbUtils.closeQuietly(conn);
				}
				return false;
			}
			//删除商品规格
			public boolean deleterule( rule rule) {
				Connection conn=null;
				try{
					conn=_DBUtils.getConnection();
					String sql="delete from rule where id=?";
					//ResultSetHandler<loginform> rsh=new BeanHandler<loginform>(loginform.class);
					int count=qRunner.update(conn, sql,rule.getId());			
		             if(count>0) {
		            	 return true;
		             }   		
				}catch(SQLException e){
					throw new DaoException("删除规格失败",e);
				}
				finally{
					DbUtils.closeQuietly(conn);
				}
				return false;
			}
			@Override
			//修改方法
			public boolean updaterule(rule rule) {
				// TODO Auto-generated method stub
				Connection conn=null;
				try{
					conn=_DBUtils.getConnection();
					String sql="update rule set size=? where id=?";
					//ResultSetHandler<loginform> rsh=new BeanHandler<loginform>(loginform.class);
					int count=qRunner.update(conn, sql,rule.getSize(),rule.getId());			
		             if(count>0) {
		            	 return true;
		             }   		
				}catch(SQLException e){
					throw new DaoException("修改规格失败",e);
				}
				finally{
					DbUtils.closeQuietly(conn);
				}
				return false;
			}
			//根据商品id修改规格表
			@Override
			public boolean updaterule01(rule rule) {
				// TODO Auto-generated method stub
				Connection conn=null;
				try{
					conn=_DBUtils.getConnection();
					String sql="update rule set size=? where pid=?";
					//ResultSetHandler<loginform> rsh=new BeanHandler<loginform>(loginform.class);
					int count=qRunner.update(conn, sql,rule.getSize(),rule.getPid());			
		             if(count>0) {
		            	 return true;
		             }   		
				}catch(SQLException e){
					throw new DaoException("修改规格失败",e);
				}
				finally{
					DbUtils.closeQuietly(conn);
				}
				return false;
			}
			//根据商品id删除规格表
			@Override
			public boolean deleterule01(rule rule) {
				// TODO Auto-generated method stub
				Connection conn=null;
				try{
					conn=_DBUtils.getConnection();
					String sql="delete from rule where pid=?";
					//ResultSetHandler<loginform> rsh=new BeanHandler<loginform>(loginform.class);
					int count=qRunner.update(conn, sql,rule.getPid());			
		             if(count>0) {
		            	 return true;
		             }   		
				}catch(SQLException e){
					throw new DaoException("删除规格失败",e);
				}
				finally{
					DbUtils.closeQuietly(conn);
				}
				return false;
			}
	
}
