package com.webSecurity;

public class JwtRequest 
{
public static final String getusename = null;
private String username;
private String password;
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
public JwtRequest() {
	super();
	
}
public JwtRequest(String username, String password) {
	super();
	this.username = username;
	this.password = password;
}

}
