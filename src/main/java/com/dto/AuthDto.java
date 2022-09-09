package com.dto;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class AuthDto implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String token;
	private int id;
	private String email;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	public AuthDto(String token, int id, String email, String name) {
		super();
		this.token = token;
		this.id = id;
		this.email = email;
		this.name = name;
	}
	public AuthDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
