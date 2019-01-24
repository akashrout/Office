package com.akash.RestDemoJersey;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Alien {
	
	private  String name;
	private int point;
	private int id;
	private String addr;
	
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Alien [name=" + name + ", point=" + point + ", id=" + id + ", addr=" + addr + "]";
	}
	
	
	
	

}
