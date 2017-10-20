package service;

import java.util.List;

import dao.DaoFactory;
import dao.frontpagedao;
import entity.cate;

import impl.frontpageimpl;

public class frontpageservice {
	
//	public static void main(String[] args) {
//		List<cate> oo=sreachcate();
//	}
//	
	
public  List<cate> sreachcate(){
	frontpagedao dao01=DaoFactory.getInstance("frontpageDao",frontpageimpl.class);
    List<cate> catelist=dao01.sreachcate();
    for(int i=0;i<catelist.size();i++) {
    	System.out.println(catelist.get(i));
    }
    return catelist;
}
}
