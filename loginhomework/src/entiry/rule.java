package entiry;

public class rule {
private int id;
private int pid;
//private String pname;
private String size;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
//public String getPname() {
//	return pname;
//}
//public void setPname(String pname) {
//	this.pname = pname;
//}
public String getSize() {
	return size;
}
public void setSize(String size) {
	this.size = size;
}
@Override
public String toString() {
	return "rule [id=" + id + ", pid=" + pid + ",  size=" + size + "]";
}
public rule(int id, int pid,  String size) {
	super();
	this.id = id;
	this.pid = pid;
//	this.pname = pname;
	this.size = size;
}
public rule() {
	super();
}
public rule(int pid, String size) {
	super();
	this.pid = pid;
	this.size = size;
}

}
