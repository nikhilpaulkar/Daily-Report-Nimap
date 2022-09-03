package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.entity.Student;
import com.exception.ResourceNotFoundException;
import com.repository.StuRepository;


@Service
public class StudentService
{
	@Autowired
	private StuRepository sturepository;

	//get all data
	public List <Student> getAllStudent()
	{
		List<Student> student=sturepository.findAll();
		return sturepository.findAll();
	}
	//get  data by id
   public Student getById(Integer id)
   {
	  Student student =sturepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("resource not found"));
	  return student;
   }
	//post to add data
	public Student  addStudent(Student student)
	{

	    Student student1=sturepository.save(student);
		return sturepository.save(student1);
	}
	
	//update by id
	public Student updateuser(Integer id,Student student)
	{
		  Student student1 = this.sturepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("resource not found"));

		  student1.setName(student.getName());
		  student1.setCity(student.getCity());
		  
		  Student s1= this.sturepository.save(student1);
		 	return s1;
	}
	
	//delete by id
	public void deleteStudent(Integer id)
	{

		sturepository.deleteById(id);
	}

	

}