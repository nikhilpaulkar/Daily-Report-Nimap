package com.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.dto.PermissionDto;
import com.entity.PermissionEntity;

@Service
public interface PermissionInterface
{
	
	
 PermissionDto addpermission(PermissionDto permissiondto);
 
 Page<?> getpermission(String search, String pageNo, String pagesize);
 
 PermissionDto updatePermission(PermissionDto permissionDto,Integer id);


  void delete(Integer id);

 PermissionEntity getById(Integer id);
 

 
}
