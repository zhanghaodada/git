package entiry;

public class account_consumer {
private int id;
private String loginname;
private String password;
private String registertime;
private String lastlogintime;

private String ip;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getLoginname() {
	return loginname;
}

public void setLoginname(String loginname) {
	this.loginname = loginname;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getRegistertime() {
	return registertime;
}

public void setRegistertime(String registertime) {
	this.registertime = registertime;
}

public String getLastlogintime() {
	return lastlogintime;
}

public void setLastlogintime(String lastlogintime) {
	this.lastlogintime = lastlogintime;
}

public String getIp() {
	return ip;
}

public void setIp(String ip) {
	this.ip = ip;
}

}
