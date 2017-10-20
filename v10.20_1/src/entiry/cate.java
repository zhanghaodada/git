package entiry;

import java.util.List;

public class cate {
private int cid;
private String cname;

private int pid;
//setºÍget

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
	return "cate [cid=" + cid + ", cname=" + cname +  " ,pid=" + pid + "]";
}

public cate(int cid, String cname, int pid) {
	super();
	this.cid = cid;
	this.cname = cname;
	this.pid = pid;
}

public cate() {
	super();
}

public cate(String cname, int pid) {
	super();
	this.cname = cname;
	this.pid = pid;
}

}
