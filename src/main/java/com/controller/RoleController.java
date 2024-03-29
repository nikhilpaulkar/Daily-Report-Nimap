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

import com.ServiceImpl.RoleServiceImpl;
import com.dto.RoleDto;
import com.dto.SuccessResponseDto;
import com.entity.RoleEntity;
import com.exception.Errordetails;
import com.exception.ResourceNotFoundException;

import com.service.RoleServiceInterface;
  @RestController
  @RequestMapping("/role")
  public class RoleController 
 {
 @Autowired
 private RoleServiceImpl roleserviceinterface;
	



@PostMapping
   public RoleEntity addrole (@RequestBody RoleDto roledto)
  { 
	return this.roleserviceinterface.addrole(roledto);

  }


@GetMapping
  public ResponseEntity<?>getallroles()
  {
	List <RoleEntity> roleentity=this.roleserviceinterface.getallroles();
	try
	{
		return new ResponseEntity<>(roleentity,HttpStatus.ACCEPTED);
	}catch (ResourceNotFoundException e)
	{
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	

}

@GetMapping("/{id}")
  public ResponseEntity<?>getbyid(@PathVariable Integer id)
  {
	return new ResponseEntity<>(new SuccessResponseDto("success","success",roleserviceinterface.getbyid(id)),HttpStatus.OK);
  }

@PutMapping("/{id}")
  public ResponseEntity<?>update(@RequestBody RoleEntity roleentity,@PathVariable("id")Integer id)
  {
	try
	{
		RoleEntity role=this.roleserviceinterface.update(roleentity, id);
		return new ResponseEntity<>(new SuccessResponseDto("Update Successfully","success",role),HttpStatus.ACCEPTED);
	}catch(Exception e)
	{
		return new ResponseEntity<>(e.toString(),HttpStatus.NO_CONTENT);
	}
	
  }

@DeleteMapping("/{id}")
  public void deletebyid(@PathVariable Integer id)
  {
	roleserviceinterface.deletebyid(id);
  }

}