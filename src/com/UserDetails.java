package com;
public class UserDetails implements java.io.Serializable{

private String address;
private int con_umber;
private String email_id;
private String comp_name;
private String exp;
private String skills;


public String getAddress() {
	System.out.println("Inside Get Address =>" +address);
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public int getCon_umber() {
	return con_umber;
}

public void setCon_umber(int con_umber) {
	this.con_umber = con_umber;
}

public String getEmail_id() {
	return email_id;
}

public void setEmail_id(String email_id) {
	this.email_id = email_id;
}
public String getComp_name() {
	return comp_name;
}
public void setComp_name(String comp_name) {
	this.comp_name = comp_name;
}
public String getExp() {
	return exp;
}
public void setExp(String exp) {
	this.exp = exp;
}
public String getSkills() {
	return skills;
}
public void setSkills(String skills) {
	this.skills = skills;
}
	
	
	
}
