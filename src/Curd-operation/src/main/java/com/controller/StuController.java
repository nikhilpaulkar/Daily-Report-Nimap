
package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Student;
import com.service.StudentService;

@RestController
public class StuController
{
  @Autowired
  private StudentService studentservice;

  @GetMapping("/student")
  public ResponseEntity<?> getAlldata(

	 @RequestParam(defaultValue="")String search,
	 @RequestParam(defaultValue="1")String pageNo,
	 @RequestParam(defaultValue="5" )String size)
	 {
	 System.out.println("page1");
	 Page<Student> student=studentservice.getAllStudent(search,pageNo,size);

	 System.out.println("page2");
	// if(student.getTotalElements()!=0)
	// {
		 System.out.println("page3");
		return  new ResponseEntity<>(student.getContent(),HttpStatus.OK);
	 //}
	//return new ResponseEntity<>("fail",HttpStatus.BAD_REQUEST);
  }
    @PostMapping("/student")
	public Student addStudent(@RequestBody Student student)
	{

        return studentservice.addStudent(student);
	}
	@PutMapping("/student/{id}")
	public void updateStudent(@PathVariable String id,@RequestBody Student student)
	{
		
		
      this.studentservice.updateStudent(id,student);
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


