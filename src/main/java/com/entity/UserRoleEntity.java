package com.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

@Entity
@Table(name="userrole")
@Where(clause="isactive=true")
@SQLDelete(sql="UPDATE userrole SET isactive=false WHERE id=? AND u.user_id=?")
@AssociationOverrides({@AssociationOverride(name="task.users",joinColumns=@JoinColumn(name="user_id")),@AssociationOverride(name="task.roles",joinColumns=@JoinColumn(name="role_id"))})
public class UserRoleEntity implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
   @CreationTimestamp
	private Date createdat;
   
   @UpdateTimestamp
	private Date updatedat;
	private boolean isactive=true;
	
	@EmbeddedId
	private UserRoleId task= new UserRoleId();
	
	public Date getCreatedat() {
		return createdat;
	}
	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
	}
	public Date getUpdatedat() {
		return updatedat;
	}
	public void setUpdatedat(Date updatedat) {
		this.updatedat = updatedat;
	}
	public boolean isIsactive() {
		return isactive;
	}
	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}
	@EmbeddedId
	public UserRoleId getTask() {
		return task;
	}
	public void setTask(UserRoleId task) {
		this.task = task;
	}
	public UserRoleEntity(Date createdat, Date updatedat, boolean isactive, UserRoleId task) {
		super();
		this.createdat = createdat;
		this.updatedat = updatedat;
		this.isactive = isactive;
		this.task = task;
	}
	public UserRoleEntity() {
		super();
		
	}
	
	
	
}
