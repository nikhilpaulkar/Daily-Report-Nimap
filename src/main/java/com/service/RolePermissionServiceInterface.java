package com.service;

import java.util.List;

import com.entity.RolePermissionEntity;
import com.payload.RolePermissionRequest;

public interface RolePermissionServiceInterface 
{

	void add(RolePermissionRequest rolePermissionRequest);
	
	List<RolePermissionEntity> getAll();
	
	void updateRolePermission(RolePermissionRequest rolePermissionRequest);

	void deleteRolePermission(RolePermissionRequest rolePermissionRequest);

	List<RolePermissionEntity> getpermissionbyuserid(int id);
	
}
