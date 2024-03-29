package com.controller;

import java.util.Calendar;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ServiceImpl.AuthServiceImpl;
import com.ServiceImpl.LoggerServiceInterface;
import com.dto.AuthDto;
import com.dto.ErrorResponseDto;
import com.dto.LoggerDto;
import com.dto.UserDto;
import com.entity.User;
import com.exception.ResourceNotFoundException;
import com.repository.UserRepository;
import com.service.UserService;
import com.webSecurity.JwtAuthRequest;
import com.webSecurity.JwtAuthRespose;
import com.webSecurity.JwtTokenUtil;


@RestController

public class AuthController {

	@Autowired
	private AuthServiceImpl authServiceImpl;
	@Autowired
	UserRepository userrepository;
	
	@Autowired
	private UserService userservice;
	@Autowired
	private JwtTokenUtil jwttokenutil;
	@Autowired
	private LoggerServiceInterface loggerserviceinterface;

	@PostMapping("/login")
	public ResponseEntity<?> createAuthenticationToken(@Valid @RequestBody JwtAuthRequest authenticationRequest)
			throws Exception {

		try {

			User user1 = userservice.findByEmail(authenticationRequest.getEmail());
			System.out.println(user1.getPassword());
			if (authServiceImpl.comaparePassword(user1.getPassword(), authenticationRequest.getPassword()));
			{
				System.out.println("Data" + user1.getEmail());
				final String token = jwttokenutil.generateToken(user1);
			
				LoggerDto logger = new LoggerDto();
				logger.setToken(token);
				
				Calendar calender = Calendar.getInstance();
				calender.add(Calendar.HOUR_OF_DAY, 5);
				logger.setExpiredAt(calender.getTime());
				loggerserviceinterface.createLogger(logger, user1);
				return new ResponseEntity<>(new JwtAuthRespose(token), HttpStatus.OK);
				//return new ResponseEntity<>( new AuthDto token(user1.getId(),user1.getEmail(),user1.getName(),HttpStatus.OK));
			}
		} catch (BadCredentialsException e) {
			throw new Exception("invalid user or password");
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponseDto(e.getMessage(), "user not found "), HttpStatus.NOT_FOUND);
		}

	}

	// register api
   @PostMapping("/register")
	
	public ResponseEntity<?> createUser(@RequestBody UserDto userdto) throws Exception {
      
	   
	 
	  try 
	  {
		  User user=this.userrepository.findByEmail(userdto.getEmail());
		  if(user !=null)
		  {
				return new ResponseEntity<>("user already exisits", HttpStatus.NOT_FOUND);
		  }
		  else 
		  {
			  
		    this.userservice.createUser(userdto);
		    return new ResponseEntity<>("Success", HttpStatus.CREATED);
		  }
		

		} catch (Exception e) {

			return new ResponseEntity<>("hello", HttpStatus.OK);
		}
	  
	

	
	
   }
}
