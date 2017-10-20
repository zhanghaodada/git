package entity;

import java.util.List;

public class product_orderinfo {
private int orderid;
private int productid;
private List<orderinfo> orderlist;
private List<Product> productlist;


public List<orderinfo> getOrderlist() {
	return orderlist;
}
public void setOrderlist(List<orderinfo> orderlist) {
	this.orderlist = orderlist;
}
public List<Product> getProductlist() {
	return productlist;
}
public void setProductlist(List<Product> productlist) {
	this.productlist = productlist;
}
public int getOrderid() {
	return orderid;
}
public void setOrderid(int orderid) {
	this.orderid = orderid;
}
public int getProductid() {
	return productid;
}
public void setProductid(int productid) {
	this.productid = productid;
}
@Override
public String toString() {
	return "\r\n product_orderinfo "
			+ "[orderid=" + orderid + ","
					+ "productid=" + productid + ", \r\n"
					+ "orderlist=" + orderlist
			+ ", \r\n"
			+ "productlist=" + productlist + "]";
}


}
