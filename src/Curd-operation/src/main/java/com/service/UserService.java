package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.entity.User;

import com.repository.UserRepository;

@Service
public class UserService 
{
	@Autowired
	private UserRepository userrepository;
	//get all data 
	public List<User> getAlldata()
	{
		return userrepository.findAll();
	}
	
	//add data 
	public User adduser(User user)
	{
		return userrepository.save(user);
	}

	//update data
	public void updatedata(Integer Id,User user)
	{
		userrepository.save(user);
	}
}