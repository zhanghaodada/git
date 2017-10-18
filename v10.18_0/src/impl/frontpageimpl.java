package impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import commend._DBUtils;
import dao.frontpagedao;
import entity.cate;

public class frontpageimpl implements frontpagedao {
	QueryRunner qRunner=new QueryRunner();
	@Override
	//查询父类子类只有两层
	public List<cate> sreachcate() {
		// TODO Auto-generated method stub
	List<cate> catelist=new ArrayList<cate>();
		
		Connection conn=null;
		try{
			conn=_DBUtils.getConnection();

			String sql01="select c.cid,c.cname,c.pid\r\n" + 
					"from cate c\r\n" + 
					"join\r\n" + 
					"(select *\r\n" + 
					"from cate\r\n" + 
					"where pid is null) ss\r\n" + 
					"on c.pid=ss.cid";
			ResultSetHandler<List<cate>> rsh01=new BeanListHandler<cate>(cate.class);
			catelist=qRunner.query(conn,sql01,rsh01);
			//上面是查询出电子产品和电脑，下面查询下面的子类
			for(int i=0;i<catelist.size();i++) {
				int _cid=catelist.get(i).getCid();
				String sql02="select cc.cid,cc.cname,cc.pid\r\n" + 
						"from cate cc\r\n" + 
						"join\r\n" + 
						"(select c.cid,c.cname,c.pid\r\n" + 
						"from cate c\r\n" + 
						"join\r\n" + 
						"(select *\r\n" + 
						"from cate\r\n" + 
						"where pid is null) ss\r\n" + 
						"on c.pid=ss.cid) ccc\r\n" + 
						"on ccc.cid=cc.pid and ccc.cid=?";
				ResultSetHandler<List<cate>> rsh02=new BeanListHandler<cate>(cate.class);
				List<cate> catelist01=qRunner.query(conn,sql02,rsh02,_cid);
				catelist.get(i).setCatelist(catelist01);
				
			}

		}catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			_DBUtils.close(conn);
		}
		
		return catelist;
	}

}
