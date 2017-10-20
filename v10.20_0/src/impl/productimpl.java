package impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import commend._DBUtils;
import dao.productdao;
import entity.*;

public class productimpl implements productdao {
	QueryRunner qRunner=new QueryRunner();
	//��ҳ��ѯ����  ������ҳ���Ϊ��Ϊ��С��
			@Override
			public pagemodel<Product> getpagemodel01(int pageno, int pagesize,int sreachtype) {
				// TODO Auto-generated method stub
				pagemodel<Product> model=null;
				Connection conn=null;
				try{
					conn=_DBUtils.getConnection();
					String totalcount_sql=" select count(id)\r\n" + 
							"from product\r\n" + 
							"where cid=?";
					ResultSetHandler<Long> rsh=new ScalarHandler<Long>();
					
					Integer totalcount=qRunner.query(conn,totalcount_sql,rsh,sreachtype).intValue();
					
					if(totalcount>0) {
						//��ҳ��ѯ
						
						model=new pagemodel<Product>();
						model.setTotalcount(totalcount);
						

						String sql="select *\r\n" + 
								"from product\r\n" + 
								"where cid=?\r\n" + 
								"LIMIT ?,?";
						ResultSetHandler<List<Product>> rsh01=new BeanListHandler<Product>(Product.class);
						Object[] params= {sreachtype,(pageno-1)*pagesize,pagesize};
						//�õ���ҳ��ѯ������
						List<Product> polist=qRunner.query(conn,sql,rsh01,params);
						model.setDatas(polist);
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
			
			
			//����Id����ѯ��Ʒ��Ϣ
			
			public Product sreachbyid(int id) {
				// TODO Auto-generated method stub
				
				
				Product pro=null;
				Connection conn=null;
				try{
					conn=_DBUtils.getConnection();
					String sql="select * from product where id=?";
					ResultSetHandler<Product> rsh=new BeanHandler<Product>(Product.class);
					
					pro=qRunner.query(conn,sql,rsh,id);
					pro.setNumber(1);
					
				
				}catch(SQLException e){
					e.printStackTrace();
				}
				finally{
					_DBUtils.close(conn);
				}
				return pro;
			}
}
