package com.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
@Entity
@Table(name = "api_logger")
public class ApiLoggerEntity implements Serializable

{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String userToken;
    private String ipAddress;
    private String url;


	private String method;

	
	private String host;

	
	private String body;

	@CreationTimestamp
	private Date createdAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public ApiLoggerEntity(Long id, String userToken, String ipAddress, String url, String method, String host,
			String body, Date createdAt) {
		super();
		this.id = id;
		this.userToken = userToken;
		this.ipAddress = ipAddress;
		this.url = url;
		this.method = method;
		this.host = host;
		this.body = body;
		this.createdAt = createdAt;
	}

	public ApiLoggerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
