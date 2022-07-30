package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emp")
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String email;
private String password;
private String name;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getName(String name)
{
	return name;
}
public void setName(String name)
{
	this.name=name;
}
public User(int id, String email, String password,String name) {
	super();
	this.id = id;
	this.email = email;
	this.password = password;
	this.name=name;
}
public User() {
	super();
	
}


}
