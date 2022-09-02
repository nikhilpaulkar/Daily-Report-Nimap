package com.webSecurity;

public class JwtAuthRespose
{
 private String token;
 public String getToken()
 {
	 return token;
 }
 public void setToken(String token)
 {
	 this.token=token;
 }
public JwtAuthRespose(String token) {
	super();
	this.token = token;
}
public JwtAuthRespose() {
	super();

}



}
