
package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Student;
import com.service.StudentService;

@RestController
public class StuController 
{
  @Autowired
  private StudentService studentservice;
  
  @GetMapping("/student")
  public List<Student> getstudent()
  {
	 return studentservice.getAlldata();
  }
  
	@PostMapping("/studentpost")
	public Student addStudent(@RequestBody Student student)
	{
		
        return studentservice.addStudent(student);
	}
	@PutMapping("/studentput/{id}")
	public void updateStudent(@PathVariable String id,@RequestBody Student student)
	{
		studentservice.updateStudent(id,student);
	}
	@DeleteMapping("student/{id}")
	public void deleteStudent(@PathVariable  Integer id)
	{
		studentservice.deleteStudent(id);
	}
	@DeleteMapping("student")
	public void deleteStudent(@RequestBody Student student)
	{
		studentservice.deleteStudent();
	}
	
	}
	

