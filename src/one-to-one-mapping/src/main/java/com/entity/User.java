package com.entity;

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
	@Column(name="name")
private String name;
	@OneToOne
	@JoinColumn(name="userid")
	private UserProfile userprofile;
    
	
	
}





































