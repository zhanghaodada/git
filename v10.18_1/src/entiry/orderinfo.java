package entiry;

import java.util.List;

public class orderinfo {
private int id;
private String orderno;
private int orderstatus;
private String orderstatusname;
private String paystatusname;
private int paystatus;
private String ordertime;
private String paytime;
private int  addrinfo;
private List<consumer_addr> ca;
private String mask;



public String getOrderstatusname() {
	return orderstatusname;
}
public void setOrderstatusname(String orderstatusname) {
	this.orderstatusname = orderstatusname;
}
public String getPaystatusname() {
	return paystatusname;
}
public void setPaystatusname(String paystatusname) {
	this.paystatusname = paystatusname;
}
public List<consumer_addr> getCa() {
	return ca;
}
public void setCa(List<consumer_addr> ca) {
	this.ca = ca;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getOrderno() {
	return orderno;
}
public void setOrderno(String orderno) {
	this.orderno = orderno;
}
public int getOrderstatus() {
	return orderstatus;
}
public void setOrderstatus(int orderstatus) {
	this.orderstatus = orderstatus;
}
public int getPaystatus() {
	return paystatus;
}
public void setPaystatus(int paystatus) {
	this.paystatus = paystatus;
}
public String getOrdertime() {
	return ordertime;
}
public void setOrdertime(String ordertime) {
	this.ordertime = ordertime;
}
public String getPaytime() {
	return paytime;
}
public void setPaytime(String paytime) {
	this.paytime = paytime;
}
public int getAddrinfo() {
	return addrinfo;
}
public void setAddrinfo(int addinfo) {
	this.addrinfo = addinfo;
}
public String getMask() {
	return mask;
}
public void setMask(String mask) {
	this.mask = mask;
}
@Override
public String toString() {
	return "orderinfo [id=" + id + ", orderno=" + orderno + ", orderstatus=" + orderstatus + ", paystatus=" + paystatus
			+ ", ordertime=" + ordertime + ", paytime=" + paytime + ", addinfo=" + addrinfo + ", mask=" + mask + "] /r/n";
}

}
