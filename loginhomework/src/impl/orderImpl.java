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
	//分页查询数据    查询全部数据
	@Override
	public pagemodel<product_orderinfo> getpagemodel(int pageno, int pagesize) {
		// TODO Auto-generated method stub
		pagemodel<product_orderinfo> model=null;
		Connection conn=null;
		try{
			conn=_DBUtils.getConnection();
			//查询出全部的不同的订单信息
			String totalcount_sql="select COUNT(ss.orderid) from\r\n" + 
					"(select * from product_orderinfo\r\n" + 
					"GROUP BY orderid) ss;\r\n" + 
					"";
			//String sql="select nikename,lemail,ltitle,lwords,lcomputerip,ldatatime,laskword from leaveword";
			ResultSetHandler<Long> rsh=new ScalarHandler<Long>();
			
			Integer totalcount=qRunner.query(conn,totalcount_sql,rsh).intValue();
			
			if(totalcount>0) {
				//分页查询
				
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
				
				
				//遍历将重复订单（一个订单号有多种商品添加到product集合里），将收货人信息添加到orderinfo,在添加到product_orderinfo里
				for(int i=0;i<polist.size();i++) {
					//得到每个id
					int order_id=polist.get(i).getOrderid();
					//为商品列表赋值
					String sql01=" select p.id,p.pname,p.cid,p.pno,p.pic,p.price,p.online,p.pdetail,p.size\r\n" + 
							" FROM product p\r\n" + 
							" join product_orderinfo po\r\n" + 

							" on p.id=po.productid and po.orderid=?";
					ResultSetHandler<List<Product>> rsh02=new BeanListHandler<Product>(Product.class);
					List<Product> pl=qRunner.query(conn,sql01,rsh02,order_id);
					//将每个orderid查询出他的商品列表
					polist.get(i).setProductlist(pl);
					//为订单信息赋值
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
						//得到orderinfo的id
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
						oi.get(j).setPaystatusname("在线支付");
					}
					if(oi.get(j).getPaystatus()==2) {
						oi.get(j).setPaystatusname("货到付款");
					}
					if(oi.get(j).getOrderstatus()==1) {
						oi.get(j).setOrderstatusname("未付款");
					}
					if(oi.get(j).getOrderstatus()==2) {
						oi.get(j).setOrderstatusname("已付款");
					}
					if(oi.get(j).getOrderstatus()==3) {
						oi.get(j).setOrderstatusname("已发货");
					}
					if(oi.get(j).getOrderstatus()==4) {
						oi.get(j).setOrderstatusname("已完成");
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
	
	//分页查询数据    查询待支付，已付款，还有。。。。。订单
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
					//分页查询
					
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
					//得到分页查询的数据
					List<product_orderinfo> polist=qRunner.query(conn,sql,rsh01,params);
					//遍历将重复订单（一个订单号有多种商品添加到product集合里），将收货人信息添加到orderinfo,在添加到product_orderinfo里
					for(int i=0;i<polist.size();i++) {
						//得到每个id
						int order_id=polist.get(i).getOrderid();
						//为商品列表赋值
						String sql01=" select p.id,p.pname,p.cid,p.pno,p.pic,p.price,p.online,p.pdetail,p.size\r\n" + 
								" FROM product p\r\n" + 
								" join product_orderinfo po\r\n" + 

								" on p.id=po.productid and po.orderid=?";
						ResultSetHandler<List<Product>> rsh02=new BeanListHandler<Product>(Product.class);
						List<Product> pl=qRunner.query(conn,sql01,rsh02,order_id);
						//将每个orderid查询出他的商品列表
						polist.get(i).setProductlist(pl);
						//为订单信息赋值
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
							//得到orderinfo的id
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
							oi.get(j).setPaystatusname("在线支付");
						}
						if(oi.get(j).getPaystatus()==2) {
							oi.get(j).setPaystatusname("货到付款");
						}
						if(oi.get(j).getOrderstatus()==1) {
							oi.get(j).setOrderstatusname("未付款");
						}
						if(oi.get(j).getOrderstatus()==2) {
							oi.get(j).setOrderstatusname("已付款");
						}
						if(oi.get(j).getOrderstatus()==3) {
							oi.get(j).setOrderstatusname("已发货");
						}
						if(oi.get(j).getOrderstatus()==4) {
							oi.get(j).setOrderstatusname("已完成");
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
