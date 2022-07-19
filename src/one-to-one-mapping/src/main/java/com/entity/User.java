package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User 
{
	
	
	

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	
	private int id;
private String name;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id",referencedColumnName = "userid")
	private UserProfile userprofile;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public UserProfile getUserprofile() {
		return userprofile;
	}
	public void setUserprofile(UserProfile userprofile) {
		this.userprofile = userprofile;
	}
	public User(int id, String name, UserProfile userprofile) {
		super();
		this.id = id;
		this.name = name;
		this.userprofile = userprofile;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	
	
}





































