package entiry;

public class order {
//ss.id,ss.orderno,ss.orderstatus,ss.paystatus,ss.ordertime,ss.paytime,ss.mask, ss.cname, ss.addr ,ss.phone,p.id,p.pname,p.cid,p.pno,p.pic,p.price,p.pdetail
private int id;
private String orderno;
private int orderstatus;
private String orderstatusname;

private int paystatus;
private String paystatusname;
private String ordertime;
private String paytime;
private String mask;
private String cname;
private String addr;
private long phone;
private int p_id;
private String p_pname;
private int p_cid;
private String p_pno;
private String p_pic;
private double p_price;
private String p_pdetail;

public String getPaystatusname() {
	return paystatusname;
}
public void setPaystatusname(String paystatusname) {
	this.paystatusname = paystatusname;
}
public String getOrderstatusname() {
	return orderstatusname;
}
public void setOrderstatusname(String orderstatusname) {
	this.orderstatusname = orderstatusname;
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
public String getMask() {
	return mask;
}
public void setMask(String mask) {
	this.mask = mask;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public String getAddr() {
	return addr;
}
public void setAddr(String addr) {
	this.addr = addr;
}
public long getPhone() {
	return phone;
}
public void setPhone(long phone) {
	this.phone = phone;
}
public int getP_id() {
	return p_id;
}
public void setP_id(int p_id) {
	this.p_id = p_id;
}
public String getP_pname() {
	return p_pname;
}
public void setP_pname(String p_pname) {
	this.p_pname = p_pname;
}
public int getP_cid() {
	return p_cid;
}
public void setP_cid(int p_cid) {
	this.p_cid = p_cid;
}
public String getP_pno() {
	return p_pno;
}
public void setP_pno(String p_pno) {
	this.p_pno = p_pno;
}
public String getP_pic() {
	return p_pic;
}
public void setP_pic(String p_pic) {
	this.p_pic = p_pic;
}
public double getP_price() {
	return p_price;
}
public void setP_price(double p_price) {
	this.p_price = p_price;
}
public String getP_pdetail() {
	return p_pdetail;
}
public void setP_pdetail(String p_pdetail) {
	this.p_pdetail = p_pdetail;
}
@Override
public String toString() {
	return "order [id=" + id + ", orderno=" + orderno + ", orderstatus=" + orderstatus + ", paystatus=" + paystatus
			+ ", ordertime=" + ordertime + ", paytime=" + paytime + ", mask=" + mask + ", cname=" + cname + ", addr="
			+ addr + ", phone=" + phone + ", p_id=" + p_id + ", p_pname=" + p_pname + ", p_cid=" + p_cid + ", p_pno="
			+ p_pno + ", p_pic=" + p_pic + ", p_price=" + p_price + ", p_pdetail=" + p_pdetail + "]";
}

}
