/*
 * ������
 * 
 * */
package commend;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.DataSources;

public class _DBUtils {
private _DBUtils(){}
static DataSource ds=null;
private static Properties ps=new Properties();
static{
	try{
		ps.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties"));
		//��������
		Class.forName(ps.getProperty("driver"));
		//ʹ��c3p0���ݿ����ӳ�
				DataSource dataSorce=DataSources.unpooledDataSource(ps.getProperty("url"),ps.getProperty("user"),ps.getProperty("psw"));
				ds=DataSources.pooledDataSource(dataSorce);
				
	}catch(IOException e){
		e.printStackTrace();
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
//��ȡ���ݿ�����
public static Connection getConnection() throws SQLException{
	Connection conn=null;
	//conn=DriverManager.getConnection(ps.getProperty("url"), ps.getProperty("user"), ps.getProperty("psw"));
	conn=ds.getConnection();
	return conn;
}
//�ر����ݿ�
public static void close(Connection conn){
	try{
		if(null!=conn){
			conn.close();
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
}
//�ر�statement
public static void close(Statement statement){
	try{
		if(statement!=null){
			statement.close();
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
}
//�ر�resultSet
public static void close(ResultSet rs){
	try{
		if(rs!=null){
			rs.close();
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
}
//�ر���ɾ��
public static void close(Connection conn,Statement statement){
	close(conn);
	close(statement);
}
//�رղ�
public static void close(Connection conn,Statement statement,ResultSet rs){
	close(conn);
	close(statement);
	close(rs);
}

}
