package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import commend._DBUtils;
import dao.DaoException;
import dao.catedao;
import entiry.cate;
import entiry.leaveword;
import entiry.pagemodel;

public class cateImpl implements catedao {
	QueryRunner qRunner=new QueryRunner();
	@Override
	//��ѯ�����ϣ���������Ϊ(����cid,����cname,(����cid,�����cname,�����pid))
	public List<cate> sreachall() {
		// TODO Auto-generated method stub
		List<cate> catelist=new ArrayList<cate>();
		
		Connection conn=null;
		try{
			conn=_DBUtils.getConnection();

			String sql01="select cid,cname,pid from cate";
			ResultSetHandler<List<cate>> rsh01=new BeanListHandler<cate>(cate.class);
			catelist=qRunner.query(conn,sql01,rsh01);

		}catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			_DBUtils.close(conn);
		}
		return catelist;
	}
	@Override
	//�����
	public boolean insertcate(cate cate) {
		// TODO Auto-generated method stub
		Connection conn=null;
		try{
			conn=_DBUtils.getConnection();
			String sql="insert into cate(cname,pid) values(?,?)";
			//ResultSetHandler<loginform> rsh=new BeanHandler<loginform>(loginform.class);
			int count=qRunner.update(conn, sql,cate.getCname(),cate.getPid());			
             if(count>0) {
            	 return true;
             }   		
		}catch(SQLException e){
			throw new DaoException("����ʧ��",e);
		}
		finally{
			_DBUtils.close(conn);
		}
		return false;
	}
	@Override
	//ɾ��cate
	public boolean deletcate(cate cate) {
		// TODO Auto-generated method stub
		return false;
	}

	//��ҳ��ѯ����
	//��ҳ��ѯ����
		@Override
		public pagemodel<cate> getpagemodel(int pageno, int pagesize) {
			// TODO Auto-generated method stub
			pagemodel<cate> model=null;
			Connection conn=null;
			try{
				conn=_DBUtils.getConnection();
				String totalcount_sql="select count(cid) from cate";
				//String sql="select nikename,lemail,ltitle,lwords,lcomputerip,ldatatime,laskword from leaveword";
				ResultSetHandler<Long> rsh=new ScalarHandler<Long>();
				
				Integer totalcount=qRunner.query(conn,totalcount_sql,rsh).intValue();
				
				if(totalcount>0) {
					//��ҳ��ѯ
					
					model=new pagemodel<cate>();
					model.setTotalcount(totalcount);
					
					String sql="select cid,cname,pid from cate order by cid desc limit ?,?";
					ResultSetHandler<List<cate>> rsh01=new BeanListHandler<cate>(cate.class);
					Object[] params= {(pageno-1)*pagesize,pagesize};
					List<cate> leaveword=qRunner.query(conn,sql,rsh01,params);
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
		@Override
		//�޸���Ʒ�������Ʒ���ƣ�pid
		public boolean updatecate(cate cate) {
			// TODO Auto-generated method stub
			Connection conn=null;
			try{
				conn=_DBUtils.getConnection();
				String sql="update cate set cname=?,pid=? where cid=?";
				
				//ResultSetHandler<loginform> rsh=new BeanHandler<loginform>(loginform.class);
				int count=qRunner.update(conn, sql,cate.getCname(),cate.getPid(),cate.getCid());			
	             if(count>0) {
	            	 return true;
	             }   		
			}catch(SQLException e){
				throw new DaoException("����ʧ��",e);
			}
			finally{
				_DBUtils.close(conn);
			}
			return false;
			
		}
		
		
		/**
		 * ɾ������
		 * =======================================================================================================
		 */
		@Override
		public cate rearchId(int cid) {
			Connection conn=null;
			try {
			conn =_DBUtils.getConnection();
			String sql = "select * from cate where cid =?";
			ResultSetHandler<cate> rs = new BeanHandler<cate>(cate.class);
			cate tb = null;
			
				tb = qRunner.query(conn, sql, rs, cid);
				if(tb!=null)
				{
					return tb;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally
			{
				DbUtils.closeQuietly(conn);
			}
			return null;
		}

		//ɾ��������
		public void delRegion(Integer cid)
		{
			Connection conn = null;
			try
			{
				conn = _DBUtils.getConnection();
				//ConnectionFactory.beginTransaction(conn);
				cate currentNode = rearchId(cid);
				recursionDelNode(conn,cid);
				//������ڵ���û���ӽڵ�
				if(currentNode.getPid()==0)
				{
					currentNode.setPid(0);
				}
				//�ύ����
				//ConnectionFactory.commitTransaction(conn);
			}catch(Exception e)
			{
				e.printStackTrace();
				//ConnectionFactory.rollbackTransaction(conn);
			}finally
			{
				//ConnectionFactory.resetConnection(conn);
				DbUtils.closeQuietly(conn);
			}
		}
		
		/**
		 * �ݹ�ɾ��
		 * @param conn
		 * @param cid
		 */
		private void recursionDelNode(Connection conn, Integer cid)throws SQLException {
			String sql ="select cid,cname,pid from cate where pid = ?";
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try
			{
				conn =  _DBUtils.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, cid);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					if(0==rs.getInt("pid"))
					{
						recursionDelNode(conn, rs.getInt("cid"));
					}
					delNode(conn,rs.getInt("cid"));
				}
				//ɾ������
				delNode(conn,cid);
			
			}finally
			{
				DbUtils.closeQuietly(rs);
				DbUtils.closeQuietly(pstmt);
			}
			
		}
		/**
		 * ɾ���ڵ�
		 * @param conn
		 * @param int1
		 */
		private void delNode(Connection conn, int cid)throws SQLException {
			String sql ="delete from cate where cid=?";
			PreparedStatement pstmt  = null;
			try
			{
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, cid);
				pstmt.executeUpdate();
			}finally
			{
				DbUtils.closeQuietly(pstmt);
			}
			
		}
		
		
}
