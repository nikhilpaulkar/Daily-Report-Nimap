package com.entity;




import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;



  @Entity
  @Where(clause="isactive=true")
  @SQLDelete(sql="UPDATE demo SET isactive=false WHERE id=?")
  @Table(name="Demo")
  public class User implements Serializable
  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

  private int id;
  private String email;
  private String password;
  private String name;
  private  Boolean isactive =true;

  @OneToMany(fetch=FetchType.LAZY,mappedBy="task.user",cascade=CascadeType.ALL)
  @JsonIgnore
  private List<UserRoleEntity> userrole;


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
  public Boolean getIsactive() {
	return isactive;
  }
  public void setIsactive(Boolean isactive) {
	this.isactive = isactive;
  }
  public List<UserRoleEntity> getUserrole() {
	return userrole;
  }
  public void setUserrole(List<UserRoleEntity> userrole) {
	this.userrole = userrole;
  }
  public void setName(String name) {
	this.name = name;
  }

  public User(int id, String email, String password, String name, Boolean isactive, List<UserRoleEntity> userrole) {
	super();
	this.id = id;
	this.email = email;
	this.password = password;
	this.name = name;
	this.isactive = isactive;
	this.userrole = userrole;
  }
  public User()
  {
	super();

  }




























public String getName() {
	return name;
}


}
