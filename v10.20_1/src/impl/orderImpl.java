package impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import commend._DBUtils;
import dao.orderdao;
import entiry.Product;
import entiry.consumer_addr;
import entiry.order;
import entiry.orderinfo;
import entiry.pagemodel;
import entiry.product_orderinfo;
import entiry.rule;

public class orderImpl implements orderdao {
	QueryRunner qRunner=new QueryRunner();
	//��ҳ��ѯ����    ��ѯȫ������
	@Override
	public pagemodel<product_orderinfo> getpagemodel(int pageno, int pagesize) {
		// TODO Auto-generated method stub
		pagemodel<product_orderinfo> model=null;
		Connection conn=null;
		try{
			conn=_DBUtils.getConnection();
			//��ѯ��ȫ���Ĳ�ͬ�Ķ�����Ϣ
			String totalcount_sql="select COUNT(ss.orderid) from\r\n" + 
					"(select * from product_orderinfo\r\n" + 
					"GROUP BY orderid) ss;\r\n" + 
					"";
			//String sql="select nikename,lemail,ltitle,lwords,lcomputerip,ldatatime,laskword from leaveword";
			ResultSetHandler<Long> rsh=new ScalarHandler<Long>();
			
			Integer totalcount=qRunner.query(conn,totalcount_sql,rsh).intValue();
			
			if(totalcount>0) {
				//��ҳ��ѯ
				
				model=new pagemodel<product_orderinfo>();
				model.setTotalcount(totalcount);
				
//				String sql=" select ss.id id,ss.orderno orderno,ss.orderstatus orderstatus,ss.paystatus paystatus,ss.ordertime ordertime,ss.paytime paytime,ss.mask mask,ss.cname cname,ss.addr addr,ss.phone phone,p.id p_id,p.pname p_pname,p.cid p_cid,p.pno p_pno,p.pic p_pic,p.price p_price,p.pdetail p_pdetail\r\n" + 
//						"from\r\n" + 
//						"(\r\n" + 
//						"select o.id,o.orderno,o.orderstatus,o.paystatus,o.ordertime,o.paytime,o.mask,ca.cname,ca.addr,ca.phone\r\n" + 
//						"from orderinfo o\r\n" + 
//						"join consumer_addr ca\r\n" + 
//						"where o.addrinfo=ca.id  \r\n" + 
//						" ) ss\r\n" + 
//						" join product_orderinfo po\r\n" + 
//						"join product p\r\n" + 
//						" where po.orderid=ss.id and po.productid=p.id\r\n" + 
//						"LIMIT ?,?";
				String sql="select ss.orderid,ss.productid from\r\n" + 
						"(select * from product_orderinfo\r\n" + 
						"GROUP BY orderid) ss\r\n" + 
						"LIMIT ?,?";
				ResultSetHandler<List<product_orderinfo>> rsh01=new BeanListHandler<product_orderinfo>(product_orderinfo.class);
				Object[] params= {(pageno-1)*pagesize,pagesize};
				List<product_orderinfo> polist=qRunner.query(conn,sql,rsh01,params);
				
				
				//�������ظ�������һ���������ж�����Ʒ��ӵ�product����������ջ�����Ϣ��ӵ�orderinfo,����ӵ�product_orderinfo��
				for(int i=0;i<polist.size();i++) {
					//�õ�ÿ��id
					int order_id=polist.get(i).getOrderid();
					//Ϊ��Ʒ�б�ֵ
					String sql01=" select p.id,p.pname,p.cid,p.pno,p.pic,p.price,p.online,p.pdetail,p.size\r\n" + 
							" FROM product p\r\n" + 
							" join product_orderinfo po\r\n" + 

							" on p.id=po.productid and po.orderid=?";
					ResultSetHandler<List<Product>> rsh02=new BeanListHandler<Product>(Product.class);
					List<Product> pl=qRunner.query(conn,sql01,rsh02,order_id);
					//��ÿ��orderid��ѯ��������Ʒ�б�
					polist.get(i).setProductlist(pl);
					//Ϊ������Ϣ��ֵ
//					StringBuffer sql = new StringBuffer();
//					sql.append("")
//						.append("")
//						.append("")
//						.append("");
					String sql02=" select oo.id,oo.orderno,oo.orderstatus,oo.paystatus,oo.ordertime,oo.paytime,oo.addrinfo,oo.mask\r\n" + 
							" FROM product p\r\n" + 
							" join product_orderinfo po\r\n" + 
							" join (select o.id,o.orderno,o.orderstatus,o.paystatus,o.ordertime,o.paytime,o.addrinfo,o.mask,ca.cname,ca.addr,ca.phone,ca.province,ca.city,ca.area,ca.addrs\r\n" + 
							"       from orderinfo o\r\n" + 
							"       join consumer_addr ca\r\n" + 
							"       on o.addrinfo=ca.id) oo\r\n" + 
							" on p.id=po.productid and oo.id=po.orderid and po.orderid=?";
					ResultSetHandler<List<orderinfo>> rsh03=new BeanListHandler<orderinfo>(orderinfo.class);
					List<orderinfo> oi=qRunner.query(conn,sql02,rsh03,order_id);
					
					for(int j=0;j<oi.size();j++) {
						//�õ�orderinfo��id
						int _id=oi.get(j).getAddrinfo();
						String sql05="select ca.id id,ca.cname cname,ca.addr addr,ca.phone phone,ca.province province,ca.city city,ca.area area,ca.addrs addrs\r\n" + 
								"from orderinfo oi\r\n" + 
								"join consumer_addr ca\r\n" + 
								"on oi.addrinfo=ca.id AND oi.addrinfo=?";
						ResultSetHandler<List<consumer_addr>> rsh04=new BeanListHandler<consumer_addr>(consumer_addr.class);
						List<consumer_addr> ca=qRunner.query(conn,sql05,rsh04,_id);
						oi.get(j).setCa(ca);
					}
					polist.get(i).setOrderlist(oi);
				}
				
				
				
				
				
				
				//
				for(int i=0;i<polist.size();i++) {
					List<orderinfo> oi=polist.get(i).getOrderlist();
					for(int j=0;j<oi.size();j++) {
						
					
					if(oi.get(j).getPaystatus()==1) {
						oi.get(j).setPaystatusname("����֧��");
					}
					if(oi.get(j).getPaystatus()==2) {
						oi.get(j).setPaystatusname("��������");
					}
					if(oi.get(j).getOrderstatus()==1) {
						oi.get(j).setOrderstatusname("δ����");
					}
					if(oi.get(j).getOrderstatus()==2) {
						oi.get(j).setOrderstatusname("�Ѹ���");
					}
					if(oi.get(j).getOrderstatus()==3) {
						oi.get(j).setOrderstatusname("�ѷ���");
					}
					if(oi.get(j).getOrderstatus()==4) {
						oi.get(j).setOrderstatusname("�����");
					}
					}
				}
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
	
	//��ҳ��ѯ����    ��ѯ��֧�����Ѹ�����С�������������
		@Override
		public pagemodel<product_orderinfo> getpagemodel01(int pageno, int pagesize,int sreachtype) {
			// TODO Auto-generated method stub
			pagemodel<product_orderinfo> model=null;
			Connection conn=null;
			try{
				conn=_DBUtils.getConnection();
				String totalcount_sql=" select COUNT(DISTINCT o.id)\r\n" + 
						" from orderinfo o\r\n" + 
						" join product_orderinfo po\r\n" + 
						" on o.id=po.orderid and o.orderstatus=?";
				//String sql="select nikename,lemail,ltitle,lwords,lcomputerip,ldatatime,laskword from leaveword";
				ResultSetHandler<Long> rsh=new ScalarHandler<Long>();
				
				Integer totalcount=qRunner.query(conn,totalcount_sql,rsh,sreachtype).intValue();
				
				if(totalcount>0) {
					//��ҳ��ѯ
					
					model=new pagemodel<product_orderinfo>();
					model.setTotalcount(totalcount);
					

					String sql="select *\r\n" + 
							" from orderinfo o\r\n" + 
							" join product_orderinfo po\r\n" + 
							" on o.id=po.orderid and o.orderstatus=?\r\n" + 
							"GROUP BY po.orderid\r\n" + 
							"LIMIT ?,?;";
					ResultSetHandler<List<product_orderinfo>> rsh01=new BeanListHandler<product_orderinfo>(product_orderinfo.class);
					Object[] params= {sreachtype,(pageno-1)*pagesize,pagesize};
					//�õ���ҳ��ѯ������
					List<product_orderinfo> polist=qRunner.query(conn,sql,rsh01,params);
					//�������ظ�������һ���������ж�����Ʒ��ӵ�product����������ջ�����Ϣ��ӵ�orderinfo,����ӵ�product_orderinfo��
					for(int i=0;i<polist.size();i++) {
						//�õ�ÿ��id
						int order_id=polist.get(i).getOrderid();
						//Ϊ��Ʒ�б�ֵ
						String sql01=" select p.id,p.pname,p.cid,p.pno,p.pic,p.price,p.online,p.pdetail,p.size\r\n" + 
								" FROM product p\r\n" + 
								" join product_orderinfo po\r\n" + 

								" on p.id=po.productid and po.orderid=?";
						ResultSetHandler<List<Product>> rsh02=new BeanListHandler<Product>(Product.class);
						List<Product> pl=qRunner.query(conn,sql01,rsh02,order_id);
						//��ÿ��orderid��ѯ��������Ʒ�б�
						polist.get(i).setProductlist(pl);
						//Ϊ������Ϣ��ֵ
//						StringBuffer sql = new StringBuffer();
//						sql.append("")
//							.append("")
//							.append("")
//							.append("");
						String sql02=" select oo.id,oo.orderno,oo.orderstatus,oo.paystatus,oo.ordertime,oo.paytime,oo.addrinfo,oo.mask\r\n" + 
								" FROM product p\r\n" + 
								" join product_orderinfo po\r\n" + 
								" join (select o.id,o.orderno,o.orderstatus,o.paystatus,o.ordertime,o.paytime,o.addrinfo,o.mask,ca.cname,ca.addr,ca.phone,ca.province,ca.city,ca.area,ca.addrs\r\n" + 
								"       from orderinfo o\r\n" + 
								"       join consumer_addr ca\r\n" + 
								"       on o.addrinfo=ca.id) oo\r\n" + 
								" on p.id=po.productid and oo.id=po.orderid and po.orderid=?";
						ResultSetHandler<List<orderinfo>> rsh03=new BeanListHandler<orderinfo>(orderinfo.class);
						List<orderinfo> oi=qRunner.query(conn,sql02,rsh03,order_id);
						
						for(int j=0;j<oi.size();j++) {
							//�õ�orderinfo��id
							int _id=oi.get(j).getAddrinfo();
							String sql05="select ca.id id,ca.cname cname,ca.addr addr,ca.phone phone,ca.province province,ca.city city,ca.area area,ca.addrs addrs\r\n" + 
									"from orderinfo oi\r\n" + 
									"join consumer_addr ca\r\n" + 
									"on oi.addrinfo=ca.id AND oi.addrinfo=?";
							ResultSetHandler<List<consumer_addr>> rsh04=new BeanListHandler<consumer_addr>(consumer_addr.class);
							List<consumer_addr> ca=qRunner.query(conn,sql05,rsh04,_id);
							oi.get(j).setCa(ca);
						}
						polist.get(i).setOrderlist(oi);
					}
					
					
					
					
					
					
					//
					for(int i=0;i<polist.size();i++) {
						List<orderinfo> oi=polist.get(i).getOrderlist();
						for(int j=0;j<oi.size();j++) {
							
						
						if(oi.get(j).getPaystatus()==1) {
							oi.get(j).setPaystatusname("����֧��");
						}
						if(oi.get(j).getPaystatus()==2) {
							oi.get(j).setPaystatusname("��������");
						}
						if(oi.get(j).getOrderstatus()==1) {
							oi.get(j).setOrderstatusname("δ����");
						}
						if(oi.get(j).getOrderstatus()==2) {
							oi.get(j).setOrderstatusname("�Ѹ���");
						}
						if(oi.get(j).getOrderstatus()==3) {
							oi.get(j).setOrderstatusname("�ѷ���");
						}
						if(oi.get(j).getOrderstatus()==4) {
							oi.get(j).setOrderstatusname("�����");
						}
						}
					}
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
	
}
