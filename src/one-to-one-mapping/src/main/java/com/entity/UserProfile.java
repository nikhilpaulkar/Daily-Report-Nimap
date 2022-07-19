package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userprofile")
public class UserProfile
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userid;
	@Column(name="address")
	private String address;
	@Column(name="phoneno")
	private String phoneno;
	public UserProfile()
	{
		
	}
	
	public int getUserid() {
		return userid;
	}
    public void setUserid(int userid) {
		this.userid = userid;
	}
    public String getAddress() {
		return address;
	}
     public void setAddress(String address) {
		this.address = address;
	}
    public String getPhoneno() {
		return phoneno;
	}
    public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
       public UserProfile(int userid, String address, String phoneno) {
		super();
		this.userid = userid;
		this.address = address;
		this.phoneno = phoneno;
	}
	
	
	
	
	
}
	