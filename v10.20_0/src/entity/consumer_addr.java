package entity;

public class consumer_addr {
private int id;
private String cname;
private String addr;
private String phone;
private String province;
private String city;
private String area;
private String addrs;
private int cid;

public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
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
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getProvince() {
	return province;
}
public void setProvince(String province) {
	this.province = province;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getArea() {
	return area;
}
public void setArea(String area) {
	this.area = area;
}
public String getAddrs() {
	return addrs;
}
public void setAddrs(String addrs) {
	this.addrs = addrs;
}
@Override
public String toString() {
	return "consumer_addr [id=" + id + ", cname=" + cname + ", addr=" + addr + ", phone=" + phone + ", province="
			+ province + ", city=" + city + ", area=" + area + ", addrs=" + addrs + "]";
}

}
