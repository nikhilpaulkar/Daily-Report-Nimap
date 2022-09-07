package com.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.dto.SuccessResponseDto;
import com.entity.RolePermissionEntity;
import com.exception.ResourceNotFoundException;
import com.payload.RolePermissionRequest;
import com.service.RolePermissionServiceInterface;



@RestController
@RequestMapping("/rolepermission")
public class RolePermissionController
{
   @Autowired
	private RolePermissionServiceInterface rolePermissionServiceInterface;
 
	@PostMapping
	private ResponseEntity<?> add(@RequestBody RolePermissionRequest rolePermissionRequest)
	{
		try
		{
			this.rolePermissionServiceInterface.add(rolePermissionRequest);
			return new ResponseEntity<>(new SuccessResponseDto("Success", "Success", rolePermissionRequest),HttpStatus.OK);
		}catch(Exception e)
		{
			return new ResponseEntity<>("fail",HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@GetMapping
	public List<RolePermissionEntity>getall()
	{
		return rolePermissionServiceInterface.getAll();
	}
  
	@PutMapping
	public ResponseEntity<?> update(@RequestBody RolePermissionRequest rolePermissionRequest)
	{
		try
		{
			this.rolePermissionServiceInterface.updateRolePermission(rolePermissionRequest);
			return new ResponseEntity<>(new SuccessResponseDto("Success", "Success", rolePermissionRequest),HttpStatus.ACCEPTED);	
		}catch(Exception e)
		{
			return new ResponseEntity<>(new ResourceNotFoundException("Not Found"),HttpStatus.NOT_FOUND);	
		}
		
	}
	
	@DeleteMapping
	public ResponseEntity<?> delete(@RequestBody RolePermissionRequest rolePermissionRequest)
	{
		try
		{
			this.rolePermissionServiceInterface.deleteRolePermission(rolePermissionRequest);
			return new ResponseEntity<>(new SuccessResponseDto("Success", "Success", rolePermissionRequest),HttpStatus.ACCEPTED);
				
		}catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	

}
