package entity;

public class Product {
private int id;
private String pname;//商品名称（显示）
private int cid;//商品类别的cid
private String pno;//商品货号
private String pic;//商品的图片地址
private double price;//商品价格
private int online;//商品是否上线
private String pdetail;//商品描述
private String size;//商品规格
private int number;//商品数量

public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}
public Product(String pname, int cid, String pno, String pic, double price, int online, String pdetail, String size) {
	super();
	this.pname = pname;
	this.cid = cid;
	this.pno = pno;
	this.pic = pic;
	this.price = price;
	this.online = online;
	this.pdetail = pdetail;
	this.size = size;
	
}
public String getSize() {
	return size;
}
public void setSize(String size) {
	this.size = size;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getPno() {
	return pno;
}
public void setPno(String pno) {
	this.pno = pno;
}
public String getPic() {
	return pic;
}
public void setPic(String pic) {
	this.pic = pic;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getOnline() {
	return online;
}
public void setOnline(int online) {
	this.online = online;
}
public String getPdetail() {
	return pdetail;
}
public void setPdetail(String pdetail) {
	this.pdetail = pdetail;
}

@Override
public String toString() {
	return "Product [id=" + id + ", pname=" + pname + ", cid=" + cid + ", pno=" + pno + ", pic=" + pic + ", price="
			+ price + ", online=" + online + ", pdetail=" + pdetail + ", size=" + size + ", number=" + number + "]";
}
public Product(String pname, int cid, String pno, String pic, double price, int online, String pdetail) {
	super();
	
	this.pname = pname;
	this.cid = cid;
	this.pno = pno;
	this.pic = pic;
	this.price = price;
	this.online = online;
	this.pdetail = pdetail;
	
}
public Product() {
	super();
}
public Product(int id, String pname, int cid, String pno, String pic, double price, int online, String pdetail) {
	super();
	this.id = id;
	this.pname = pname;
	this.cid = cid;
	this.pno = pno;
	this.pic = pic;
	this.price = price;
	this.online = online;
	this.pdetail = pdetail;
}
public Product(int id, String pname, int cid, String pno, String pic, double price, int online, String pdetail,
		String size) {
	super();
	this.id = id;
	this.pname = pname;
	this.cid = cid;
	this.pno = pno;
	this.pic = pic;
	this.price = price;
	this.online = online;
	this.pdetail = pdetail;
	this.size = size;
}



}
