package entiry;

public class loginform {
private int loginform_id;
private String username;
private String password;
//�вεĹ��췽��
public loginform(int loginform_id, String username, String password) {
	super();
	this.loginform_id = loginform_id;
	this.username = username;
	this.password = password;
}
public loginform(String username, String password) {
	// TODO Auto-generated constructor stub
	this.username = username;
	this.password = password;
}
public loginform() {
	// TODO Auto-generated constructor stub
}
//��дtoString����
public String toString() {
	return "depts [dept_id=" + loginform_id + ", name=" + username + ", description="
			+ password + "]";
}
//set��get����
public int getLoginform_id() {
	return loginform_id;
}
public void setLoginform_id(int loginform_id) {
	this.loginform_id = loginform_id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
