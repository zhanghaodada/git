package impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import commend._DBUtils;
import dao.DaoException;
import dao.leaveworddao;
import entiry.leaveword;
import entiry.loginform;
import entiry.pagemodel;

public class leavewordImpl implements leaveworddao {
	QueryRunner qRunner=new QueryRunner();
	@Override
	//实现接口方法，向留言表加入数据
	public boolean testinsert(leaveword lw) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		try{
			conn=_DBUtils.getConnection();
			String sql="insert into leaveword(nikename,lemail,ltitle,lwords,lcomputerip,ldatatime) values(?,?,?,?,?,?)";
			//ResultSetHandler<loginform> rsh=new BeanHandler<loginform>(loginform.class);
			int count=qRunner.update(conn, sql,lw.getNikename(),lw.getLemail(),lw.getLtitle(),lw.getLwords(),lw.getLcomputerip(),lw.getLdatatime() );			
             if(count>0) {
            	 return true;
             }   		
		}catch(SQLException e){
			throw new DaoException("留言失败",e);
		}
		finally{
			_DBUtils.close(conn);
		}
		
	
		
		return false;
	}
	//向leaveword表添加解答
	@Override
	public boolean testinsertaskword(leaveword lw) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		try{
			conn=_DBUtils.getConnection();
			String sql="update leaveword set laskword=? where ltitle=?";
			//ResultSetHandler<loginform> rsh=new BeanHandler<loginform>(loginform.class);
			int count=qRunner.update(conn, sql,lw.getLaskword(),lw.getLtitle() );			
             if(count>0) {
            	 return true;
             }   		
		}catch(SQLException e){
			throw new DaoException("留言失败",e);
		}
		finally{
			_DBUtils.close(conn);
		}
		
	
		
		return false;
	}
	//查询全部内容
	@Override
	public List<leaveword> sreachall() {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		List<leaveword> leaveword_sum=new ArrayList<leaveword>();
		try{
			conn=_DBUtils.getConnection();
			//String sss="";
			String sql="select nikename,lemail,ltitle,lwords,lcomputerip,ldatatime,laskword from leaveword";
			ResultSetHandler<List<leaveword>> rsh=new BeanListHandler<leaveword>(leaveword.class);
			leaveword_sum=qRunner.query(conn,sql,rsh);
			

		}catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			_DBUtils.close(conn);
		}
		return leaveword_sum;
	}
	//分页查询数据
	@Override
	public pagemodel<leaveword> getpagemodel(int pageno, int pagesize) {
		// TODO Auto-generated method stub
		pagemodel<leaveword> model=null;
		Connection conn=null;
		try{
			conn=_DBUtils.getConnection();
			String totalcount_sql="select count(id) from leaveword";
			//String sql="select nikename,lemail,ltitle,lwords,lcomputerip,ldatatime,laskword from leaveword";
			ResultSetHandler<Long> rsh=new ScalarHandler<Long>();
			
			Integer totalcount=qRunner.query(conn,totalcount_sql,rsh).intValue();
			
			if(totalcount>0) {
				//分页查询
				
				model=new pagemodel<leaveword>();
				model.setTotalcount(totalcount);
				
				String sql="select id,nikename,lemail,ltitle,lwords,lcomputerip,ldatatime,laskword from leaveword order by ldatatime desc limit ?,?";
				ResultSetHandler<List<leaveword>> rsh01=new BeanListHandler<leaveword>(leaveword.class);
				Object[] params= {(pageno-1)*pagesize,pagesize};
				List<leaveword> leaveword=qRunner.query(conn,sql,rsh01,params);
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

}
