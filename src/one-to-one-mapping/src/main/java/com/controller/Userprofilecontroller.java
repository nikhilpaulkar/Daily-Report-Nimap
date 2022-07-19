package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.UserProfile;
import com.repository.UserProfileRepository;
import com.service.UserprofileService;

@RestController

public class Userprofilecontroller 
{
  @Autowired
 private UserprofileService us;
  
	@GetMapping("/get")
	public List<UserProfile> get()
	{
		return us.get();
	}
	@PostMapping("/userprofile")
	public UserProfile adduserprofile(@RequestBody UserProfile userprofile)
	{
		return us.adduserprofile(userprofile);
	}
	@PutMapping("/userprofile/{id}")
	public void  updateprofile(@PathVariable String id,@RequestBody UserProfile userprofile)
	{
		us.updateProfile(id, userprofile);
	}
	@DeleteMapping("userprofile/{id}")
	public void deleteuserprofile(@PathVariable Integer id)
	{
		us.deleteUserprofile(id);
	}
	@DeleteMapping("/userprofile")
	public void deleteUserprofile(@RequestBody UserProfile userprofile)
	{
		us.deleteUserProfile();
	}
}
