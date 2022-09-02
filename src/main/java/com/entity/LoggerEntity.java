package com.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
@Entity
@Table(name = "logger")
public class LoggerEntity
{
	@Id
	@GeneratedValue
	private int id;

	@OneToOne(fetch=FetchType.LAZY)
	private User userid;

	private String token;
	@CreationTimestamp
	private Date createdat;
	private Date expiredat;
	public int getId() {
		return id;
	}

	public User getUserid() {
		return userid;
	}

	public void setUserid(User userid) {
		this.userid = userid;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getuserid()
	{
		return userid;
	}
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	public Date getCreatedat() {
		return createdat;
	}
	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
	}
	public Date getExpiredat() {
		return expiredat;
	}
	public void setExpiredat(Date expiredat) {
		this.expiredat = expiredat;
	}
	public LoggerEntity(int id, String token, Date createdat, Date expiredat,User userid) {
		super();
		this.id = id;
		this.token = token;
		this.createdat = createdat;
		this.expiredat = expiredat;
		this.userid=userid;
	}
	public LoggerEntity() {
		super();

	}




}
