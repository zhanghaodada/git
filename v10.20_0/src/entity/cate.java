package entity;

import java.util.List;

public class cate {
private int cid;
private String cname;
private int pid;
private List<cate> catelist;

public List<cate> getCatelist() {
	return catelist;
}
public void setCatelist(List<cate> catelist) {
	this.catelist = catelist;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
@Override
public String toString() {
	return "cate [cid=" + cid + ", cname=" + cname + ", pid=" + pid + ", catelist=" + catelist + "]";
}


}
