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
private UserRepository userrepo;
	
	public List<UserRepository>getAlldata()
	{
		return userrepo.findAll();
	}
	public User adduser(User user)
	{
		return userrepo.save(user);
	}
	public void updateuser(String id,User user)
	{
		 userrepo.save(user);
	}
	public void deleteStudent(Integer id)
	{
		userrepo.deleteById(id);
	}
	public void deleteUser()
	{
		userrepo.deleteAll();
	}
}
