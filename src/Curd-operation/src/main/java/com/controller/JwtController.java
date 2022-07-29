package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;
import com.service.UserService;
import com.webSecurity.JwtAuthRequest;
import com.webSecurity.JwtAuthResponse;
import com.webSecurity.JwtTokenHelper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
@RestController

public class JwtController
{
	@Autowired
	private JwtTokenHelper jwttokenfilter; 
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
public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest jwtauthrequest)
{
	this.
}
	
}

