package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.ErrorResponseDto;
import com.entity.User;
import com.exception.ResourceNotFoundException;
import com.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController
{

@Autowired
private UserService userservice;

	//get all data
@GetMapping
public ResponseEntity<?> getAlluser ()
{

	List<User> user=this.userservice.getAllUsers();
	try
	{
		

		return new ResponseEntity<>(user,HttpStatus.OK);
	}catch(ResourceNotFoundException e)
	{
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}

   @PutMapping("/{id}")
  public ResponseEntity<?>updateuser(@RequestBody User user,@PathVariable Integer id)
{
	try
	{

		userservice.updateuser(user,id);
		
		return new ResponseEntity<>(user,HttpStatus.OK);
	}catch(ResourceNotFoundException e)
	{
		return new  ResponseEntity<>(new ErrorResponseDto(e.getMessage(),"user not found with id "),HttpStatus.NOT_FOUND);
	}
}
   //delete by id
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable  Integer id)
	{
		try
		{
			userservice.deletebyid(id);
			return new ResponseEntity<>(HttpStatus.OK);

		}catch(ResourceNotFoundException e)
		{
			return new ResponseEntity<>(new ErrorResponseDto(e.getMessage(),"user not found with id"),HttpStatus.NOT_FOUND);
		}

	}



}

