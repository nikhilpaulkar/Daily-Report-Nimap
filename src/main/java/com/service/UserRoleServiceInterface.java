package com.service;

import java.util.List;

import com.entity.UserRoleEntity;
import com.payload.UserRoleRequest;

public interface UserRoleServiceInterface 
{

	void add(UserRoleRequest userrolerequest);
    List<UserRoleEntity> getall();
    void updateuserrole (UserRoleRequest userrolerequest);
    
    
    
}
