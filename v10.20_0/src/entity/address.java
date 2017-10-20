package entity;

import java.util.List;

public class address {
private int cid;
private String aname;
private int pid;
private List<address> addrlist;
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getAname() {
	return aname;
}
public void setAname(String aname) {
	this.aname = aname;
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public List<address> getAddrlist() {
	return addrlist;
}
public void setAddrlist(List<address> addrlist) {
	this.addrlist = addrlist;
}
@Override
public String toString() {
	return "address [cid=" + cid + ", aname=" + aname + ", pid=" + pid + ", addrlist=" + addrlist + "]";
}

}
