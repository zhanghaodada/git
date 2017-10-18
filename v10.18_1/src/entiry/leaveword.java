package entiry;

public class leaveword {
	private int id;
private String nikename;
private String lemail;
private String ltitle;
private String lwords;
private String lcomputerip;
private String ldatatime;
private String laskword;

public String getLaskword() {
	return laskword;
}
public void setLaskword(String laskword) {
	this.laskword = laskword;
}
public String getLcomputerip() {
	return lcomputerip;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public void setLcomputerip(String lcomputerip) {
	this.lcomputerip = lcomputerip;
}
public String getLdatatime() {
	return ldatatime;
}
public void setLdatatime(String ldatatime) {
	this.ldatatime = ldatatime;
}

//set和get方法
public String getNikename() {
	return nikename;
}
public void setNikename(String nikename) {
	this.nikename = nikename;
}
public String getLemail() {
	return lemail;
}
public void setLemail(String lemail) {
	this.lemail = lemail;
}
public String getLtitle() {
	return ltitle;
}
public void setLtitle(String ltitle) {
	this.ltitle = ltitle;
}
public String getLwords() {
	return lwords;
}
public void setLwords(String lwords) {
	this.lwords = lwords;
}
//构造方法
public leaveword() {
	super();
	// TODO Auto-generated constructor stub
}
public leaveword(String nikename, String lemail, String ltitle, String lwords) {
	super();
	this.nikename = nikename;
	this.lemail = lemail;
	this.ltitle = ltitle;
	this.lwords = lwords;
}
public leaveword(String nikename, String lemail, String ltitle, String lwords, String lcomputerip, String ldatatime) {
	super();
	this.nikename = nikename;
	this.lemail = lemail;
	this.ltitle = ltitle;
	this.lwords = lwords;
	this.lcomputerip = lcomputerip;
	this.ldatatime = ldatatime;
}
public leaveword(String laskword) {
	super();
	this.laskword = laskword;
}
public leaveword(String ltitle, String laskword) {
	super();
	this.ltitle = ltitle;
	this.laskword = laskword;
}
@Override
public String toString() {
	return "leaveword [id=" + id + ", nikename=" + nikename + ", lemail=" + lemail + ", ltitle=" + ltitle + ", lwords="
			+ lwords + ", lcomputerip=" + lcomputerip + ", ldatatime=" + ldatatime + ", laskword=" + laskword + "]";
}



}
