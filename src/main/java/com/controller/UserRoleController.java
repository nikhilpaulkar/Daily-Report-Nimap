package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.UserRoleEntity;
import com.service.UserRoleServiceInterface;

@RestController
@RequestMapping("/assignrole")
  public class UserRoleController
  {
	@Autowired
	private UserRoleServiceInterface userroleserviceinterface;
	
	//@PostMapping
//	public ResponseEntity<?>add(@RequestBody UserRoleEntity userroleentity)
//	{
//		try
//		{
//			userroleserviceinterface.add(userroleentity);
//		}catch 
//	}
	
 
  }
