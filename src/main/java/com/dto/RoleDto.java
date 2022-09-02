package com.dto;

import java.util.List;

import com.entity.UserRoleEntity;

public class RoleDto
{
	private int id;
	private String roleName;
	//private List<UserRoleEntity> userrole;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getroleName() {
		return roleName;
	}
	public void setroleName(String roleName) {
		this.roleName = roleName;
	}
//	public List<UserRoleEntity> getUserrole() {
//		return userrole;
//	}
//	public void setUserrole(List<UserRoleEntity> userrole) {
//		this.userrole = userrole;
//	}
	public RoleDto(int id, String roleName, List<UserRoleEntity> userrole) {
		super();
		this.id = id;
		this.roleName = roleName;
		//this.userrole = userrole;
	}
	public RoleDto() {
		super();
		
	}
	
	

}
