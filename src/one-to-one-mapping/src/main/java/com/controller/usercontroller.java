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

import com.entity.User;
import com.repository.UserRepository;
import com.service.UserService;

@RestController
public class usercontroller 
{
@Autowired
private UserService userservice;
@GetMapping("/user")
public List<User> getUser()
{
	return userservice.getAlldata();
}
@PostMapping("/userpost")
public User add(@RequestBody User user)
{
	return userservice.adduser(user);
}
@PutMapping("/user{id}")
public void updateuser(@PathVariable String id,@RequestBody User user)
{
	userservice.updateuser(id, user);
}
@DeleteMapping("/user{id}")
public void deleteuser(@PathVariable Integer id)
{
	 userservice.deleteStudent(id);
}
@DeleteMapping("user")
public void deleteuser(@RequestBody User user)
{
  userservice.deleteUser();
}


}
