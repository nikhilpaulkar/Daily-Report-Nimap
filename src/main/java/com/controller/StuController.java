package com.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Student;
import com.exception.ResourceNotFoundException;
import com.service.StudentService;

import errorDetails.Message;

@RestController
@RequestMapping("/student")
public class StuController
{
  @Autowired
  private StudentService studentservice;

  //get all data
  @GetMapping()
  public ResponseEntity<?> getAlldata()
  {
	   List <Student> student=this.studentservice.getAllStudent();
	   try
	   {
		   return new ResponseEntity<>(student,HttpStatus.ACCEPTED);
		}catch (ResourceNotFoundException e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	   }
	  

   
   //get by id
     @GetMapping("/{id}")
     public ResponseEntity<?> getById(@PathVariable("id")Integer id)
    {
	  Student student=studentservice.getById(id);
      return new ResponseEntity<>(new Message("Success", "Success", student),HttpStatus.OK);
    }

  //add data
    @PostMapping()
	public ResponseEntity<?> addStudent(@RequestBody Student student)
	{

        Student studen1= studentservice.addStudent(student);
        return new ResponseEntity<>(new Message("Success", "Success", studen1),HttpStatus.OK);
	}

     //update data

    @PutMapping("/{id}")
    public ResponseEntity<?> updateuser(@PathVariable Integer id,@RequestBody Student student)
    {
    	try
    	{
    		this.studentservice.updateuser(id, student);
    		return new ResponseEntity<>(HttpStatus.ACCEPTED);
    	}
    	catch(Exception e)
    	{
    		return new ResponseEntity<>(new Message("user not found with id","",""),HttpStatus.NOT_FOUND);
    		
    	}
    }

 //delete by id
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable  Integer id)
	{
		studentservice.deleteStudent(id);
	}
	}


