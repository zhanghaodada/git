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
	
	
	//��ѯ��ȫ�������޸Ĳ�ѯ
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
	//��ѯȫ��
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
	//��ҳ��ѯ����
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
						//��ҳ��ѯ
						
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
						//��pid����ӵ�Ϊnull����ӵ�������
						
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
     //��ӹ��
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
					throw new DaoException("��ӹ��ʧ��",e);
				}
				finally{
					DbUtils.closeQuietly(conn);
				}
				return false;
			}
			//ɾ����Ʒ���
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
					throw new DaoException("ɾ�����ʧ��",e);
				}
				finally{
					DbUtils.closeQuietly(conn);
				}
				return false;
			}
			@Override
			//�޸ķ���
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
					throw new DaoException("�޸Ĺ��ʧ��",e);
				}
				finally{
					DbUtils.closeQuietly(conn);
				}
				return false;
			}
			//������Ʒid�޸Ĺ���
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
					throw new DaoException("�޸Ĺ��ʧ��",e);
				}
				finally{
					DbUtils.closeQuietly(conn);
				}
				return false;
			}
			//������Ʒidɾ������
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
					throw new DaoException("ɾ�����ʧ��",e);
				}
				finally{
					DbUtils.closeQuietly(conn);
				}
				return false;
			}
	
}
