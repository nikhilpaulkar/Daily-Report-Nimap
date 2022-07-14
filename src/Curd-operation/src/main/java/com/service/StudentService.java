package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.entity.Student;
import com.repository.StuRepository;

@Service
public class StudentService 
{
	@Autowired
	private StuRepository sturepository;
	
	public List<Student> getAlldata()
	{
		return  (List<Student>) sturepository.findAll();
		 
	}
	public Student  addStudent(Student student)
	{
		return sturepository.save(student);
	}
}