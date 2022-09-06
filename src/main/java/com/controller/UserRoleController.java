package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.SuccessResponseDto;
import com.entity.UserRoleEntity;
import com.payload.UserRoleRequest;
import com.service.UserRoleServiceInterface;

@RestController
@RequestMapping("/assignrole")
  public class UserRoleController
  {
	@Autowired
	private UserRoleServiceInterface userroleserviceinterface;
	
	@PostMapping
	public ResponseEntity<?>add(@RequestBody UserRoleRequest userrolerequest )
	{
		try
		{
			userroleserviceinterface.add(userrolerequest);
			return new ResponseEntity<>(new SuccessResponseDto("SUCCESS","SUCEESS",userrolerequest),HttpStatus.OK);
		}catch (Exception e)
		{
			return new ResponseEntity<>("fail",HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping
	public List<UserRoleEntity>getall()
	{
		return this.userroleserviceinterface.getall();
	}
 
	
	@PutMapping("/update")
	public ResponseEntity<?>updateuserrole( @RequestBody UserRoleRequest  userrolerequest)
	{
		try
		{
			userroleserviceinterface.updateuserrole(userrolerequest);
			return new ResponseEntity<>(new SuccessResponseDto("update successfully","updated",userrolerequest),HttpStatus.OK);
		}catch (Exception e)
		{
			return new ResponseEntity<>("fail",HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping
	public ResponseEntity<?>deleteuserroles (@RequestBody UserRoleRequest userrolerequest)
		{
		  try
			{
				userroleserviceinterface.deleteuserroles(userrolerequest);
				return new ResponseEntity<> (new SuccessResponseDto("delete successfully","delete",userrolerequest) ,HttpStatus.OK);
			}catch(Exception e)
			{
				return new ResponseEntity<>("fail",HttpStatus.BAD_REQUEST);
			}
		}
	
	
	
  }
