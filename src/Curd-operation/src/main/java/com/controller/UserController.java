package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;
import com.service.UserService;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

@RestController

public class UserController
{

	
	@Autowired 	
	private UserService userservice;
	
	//get all data
@GetMapping("/user")
public List<User> getuser ()
{
	return userservice.getAlldata();
}
  //add data 
@PostMapping("/user")
public void adddata(@RequestBody User user)
{
	userservice.adduser(user);
}

//update data
@PutMapping("/user{id}")
public void  updatedat(@PathVariable Integer Id,@RequestBody User user)
{
	userservice.updatedata(Id, user);
}

}

