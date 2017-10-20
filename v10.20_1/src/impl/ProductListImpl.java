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
import dao.ProductListdao;
import entiry.Product;
import entiry.cate;
import entiry.leaveword;
import entiry.pagemodel;
import entiry.rule;

public class ProductListImpl implements ProductListdao {
	QueryRunner qRunner=new QueryRunner();
	@Override
	//查询所有信息
	public List<Product> sreachall() {
		// TODO Auto-generated method stub
        List<Product> productlist=new ArrayList<Product>();
		
		Connection conn=null;
		
		try{
			conn=_DBUtils.getConnection();
			

			String sql01="select id,pname,cid,pno,pic,price,online,pdetail from product";
			ResultSetHandler<List<Product>> rsh01=new BeanListHandler<Product>(Product.class);
			productlist=qRunner.query(conn,sql01,rsh01);



		}catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			DbUtils.closeQuietly(conn);
		}
		return productlist;
		
	}
	
	
	//分页查询数据
		@Override
		public pagemodel<Product> getpagemodel(int pageno, int pagesize) {
			// TODO Auto-generated method stub
			pagemodel<Product> model=null;
			Connection conn=null;
			try{
				conn=_DBUtils.getConnection();
				String totalcount_sql="select count(id) from product";
				//String sql="select nikename,lemail,ltitle,lwords,lcomputerip,ldatatime,laskword from leaveword";
				ResultSetHandler<Long> rsh=new ScalarHandler<Long>();
				
				Integer totalcount=qRunner.query(conn,totalcount_sql,rsh).intValue();
				
				if(totalcount>0) {
					//分页查询
					
					model=new pagemodel<Product>();
					model.setTotalcount(totalcount);
					
					String sql="select id,pname,cid,pno,pic,price,online,pdetail from product order by id desc limit ?,?";
					ResultSetHandler<List<Product>> rsh01=new BeanListHandler<Product>(Product.class);
					Object[] params= {(pageno-1)*pagesize,pagesize};
					List<Product> leaveword=qRunner.query(conn,sql,rsh01,params);
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
		//向数据库添加数据
		public boolean insertproduct(Product pro) {
			Connection conn=null;
			try{
				conn=_DBUtils.getConnection();
				String sql="insert into product(pname,cid,pno,pic,price,online,pdetail,size) values(?,?,?,?,?,?,?,?)";
				//ResultSetHandler<loginform> rsh=new BeanHandler<loginform>(loginform.class);
				int count=qRunner.update(conn, sql,pro.getPname(),pro.getCid(),pro.getPno(),pro.getPic(),pro.getPrice(),pro.getOnline(),pro.getPdetail(),pro.getSize());			
	             if(count>0) {
	            	 return true;
	             }   		
			}catch(SQLException e){
				throw new DaoException("添加商品失败",e);
			}
			finally{
				DbUtils.closeQuietly(conn);
			}
			
		
			
			return false;
		}
       

		@Override
		//删除方法
		public boolean delectproduct(Product pro) {
			// TODO Auto-generated method stub
			Connection conn=null;
			try{
				conn=_DBUtils.getConnection();
				String sql="delete from product where id=?";
				//ResultSetHandler<loginform> rsh=new BeanHandler<loginform>(loginform.class);
				int count=qRunner.update(conn, sql,pro.getId());			
	             if(count>0) {
	            	 return true;
	             }   		
			}catch(SQLException e){
				throw new DaoException("删除商品失败",e);
			}
			finally{
				DbUtils.closeQuietly(conn);
			}
			
		
			
			return false;
		}


		@Override
		//修改方法
		public boolean updateproduct(Product pro) {
			// TODO Auto-generated method stub
			Connection conn=null;
			try{
				conn=_DBUtils.getConnection();
				String sql="update product set pname=?,cid=?,pno=?,pic=?,price=?,online=?,pdetail=?,size=?  where id=?";
				//ResultSetHandler<loginform> rsh=new BeanHandler<loginform>(loginform.class);
				int count=qRunner.update(conn, sql,pro.getPname(),pro.getCid(),pro.getPno(),pro.getPic(),pro.getPrice(),pro.getOnline(),pro.getPdetail(),pro.getSize(),pro.getId());			
	             if(count>0) {
	            	 return true;
	             }   		
			}catch(SQLException e){
				throw new DaoException("修改商品失败",e);
			}
			finally{
				DbUtils.closeQuietly(conn);
			}
			
		
			
			return false;
			
		}

        //添加商品时插入rule表数据
		@Override
		public boolean insertrule(rule rule) {
			// TODO Auto-generated method stub
			Connection conn=null;
			try{
				conn=_DBUtils.getConnection();
				String sql="insert into rule(pid,size) values(?,?)";
				//ResultSetHandler<loginform> rsh=new BeanHandler<loginform>(loginform.class);
				int count=qRunner.update(conn, sql,rule.getPid(),rule.getSize());			
	             if(count>0) {
	            	 return true;
	             }   		
			}catch(SQLException e){
				throw new DaoException("添加商品时添加规格失败",e);
			}
			finally{
				DbUtils.closeQuietly(conn);
			}
			
		
			return false;
		}

		//对rule进行查询，在select里输出
		@Override
		public List<rule> sreachrule() {
			// TODO Auto-generated method stub
			 List<rule> productlist=new ArrayList<rule>();
				
				Connection conn=null;
				
				try{
					conn=_DBUtils.getConnection();
					

					String sql01="select id,pid,size from rule";
					ResultSetHandler<List<rule>> rsh01=new BeanListHandler<rule>(rule.class);
					productlist=qRunner.query(conn,sql01,rsh01);



				}catch(SQLException e){
					e.printStackTrace();
				}
				finally{
					DbUtils.closeQuietly(conn);
				}
				return productlist;
				
			
		}

       
		

}
