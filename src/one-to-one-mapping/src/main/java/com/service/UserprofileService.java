package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.UserProfile;
import com.repository.UserProfileRepository;

@Service
public class UserprofileService
{
  @Autowired
  private UserProfileRepository us;
  
 public List<UserProfile> get()
 {
	return this.us.findAll();

	 
 }
 public UserProfile add(UserProfile userprofile)
 {
	 return us.save(userprofile);
 }
 public void  updateProfile(String id, UserProfile userprofile)
 {
	 us.save(userprofile);
 }
 public void deleteUserprofile(Integer id)
 {
	 us.deleteById(id);
 }
 public void deleteUserProfile()
 {
	 us.deleteAll();
 }
public UserProfile adduserprofile(UserProfile userprofile) {
	// TODO Auto-generated method stub
	return null;
}

 
 
 
 
}
