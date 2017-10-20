package entity;

import java.util.List;

public class pagemodel<T> {
private int pageno;//当前页数
private List<T> datas;//当前页数的数据集合
private int pagesize;//每页可以放多少
private Integer totalcount;//总的记录数
private int totalPageSize;//总共页数

public int getTotalPageSize() {
	return totalPageSize;
}
public void setTotalPageSize(int totalPageSize) {
	this.totalPageSize = totalPageSize;
}
public int getPageno() {
	return pageno;
}
public void setPageno(int pageno) {
	this.pageno = pageno;
}
public List<T> getDatas() {
	return datas;
}
public void setDatas(List<T> datas) {
	this.datas = datas;
}
public int getPagesize() {
	return pagesize;
}
public void setPagesize(int pagesize) {
	this.pagesize = pagesize;
}
public Integer getTotalcount() {
	return totalcount;
}
public void setTotalcount(Integer totalcount) {
	this.totalcount = totalcount;
}
@Override
public String toString() {
	return "pagemodel [pageno=" + pageno + ", datas=" + datas + ", pagesize=" + pagesize + ", totalcount=" + totalcount
			+ "]";
}

}
