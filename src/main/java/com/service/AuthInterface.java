package com.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.entity.User;

public interface AuthInterface {

	UserDetails loasUserByUsername(String email);

	public boolean  comaparePassword(String email,String hashpassword);
}
