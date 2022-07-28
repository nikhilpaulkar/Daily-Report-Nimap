package com.controller;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.webSecurity.JwtRequest;
import com.webSecurity.JwtResponse;

public class JwtController
{
	
@GetMapping("/")
public String home()
{
	return "welcome to Nimap ";
}

//add data the data 
@PostMapping("/autheticate")
public JwtResponse authenticate(@RequestBody JwtRequest jwtrequest)throws Exception
{
	try {
 
		  new UsernamePasswordAuthenticationToken(
		  jwtrequest.getUsername(),
		   jwtrequest.getPassword()
		   )
		  ;
	} catch(BadCredentialsException e) {
	  throw new Exception("invalid credresentials",e);
  }
	return null;
	
	
}
}
