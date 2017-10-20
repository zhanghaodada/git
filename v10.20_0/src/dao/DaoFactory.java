package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class DaoFactory {
 private static Properties ps=new Properties();
 static{
	 InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream("dao.properties");
	 try{
		 ps.load(is);
		 
	 }catch(IOException e){
		 e.printStackTrace();
	 }
 }
 private DaoFactory(){}
 
 
 
 
 //�ṩ������ȡʵ����

public static <T> T getInstance(String daoName,Class<T> cls){
	T t=null;
	String className=ps.getProperty(daoName);
	if(className==null||className.equals("")){
		return t;
	}
	try{
		//��ȡ�ֽ���
		Class<?> clazz=Class.forName(className);
		t=(T)clazz.newInstance();
		
		
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}catch(InstantiationException e){
		e.printStackTrace();
	}catch(IllegalAccessException e){
		e.printStackTrace();
	}
	return t;
}



}
