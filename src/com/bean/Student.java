package com.bean;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
   private int sid;
   private String sname;
   private String sex;
   private String address;
   private String birthday;
   private String fname;
   private int classid;
   //临时属性
   private String cname;
   
public Student() {
	super();
	// TODO Auto-generated constructor stub
}
//添加专用
public Student(String sname, String sex, String address, String birthday, String fname, int classid) {
	super();
	this.sname = sname;
	this.sex = sex;
	this.address = address;
	this.birthday = birthday;
	this.fname = fname;
	this.classid = classid;
}
public Student(int sid, String sname, String sex, String address, String birthday, String fname, int classid,
		String cname) {
	super();
	this.sid = sid;
	this.sname = sname;
	this.sex = sex;
	this.address = address;
	this.birthday = birthday;
	this.fname = fname;
	this.classid = classid;
	this.cname = cname;
}
//修改专用
public Student(int sid, String sname, String sex, String address, String birthday, String fname, int classid) {
	super();
	this.sid = sid;
	this.sname = sname;
	this.sex = sex;
	this.address = address;
	this.birthday = birthday;
	this.fname = fname;
	this.classid = classid;
}
public int getSid() {
	return sid;
}

public void setSid(int sid) {
	this.sid = sid;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getBirthday() {
	return birthday;
}
public void setBirthday(String birthday) {
	this.birthday = birthday;
}
public int getClassid() {
	return classid;
}
public void setClassid(int classid) {
	this.classid = classid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}

public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
@Override
public String toString() {
	return "Student [sid=" + sid + ", sname=" + sname + ", sex=" + sex + ", address=" + address + ", birthday="
			+ birthday + ", fname=" + fname + ", classid=" + classid + ", cname=" + cname + "]";
}

   
}
