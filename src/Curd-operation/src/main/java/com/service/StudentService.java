package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.entity.Student;
import com.repository.StuRepository;
import com.utility.Pagination;

@Service
public class StudentService 
{
	@Autowired
	private StuRepository sturepository;
	
	//get all data
	public Page<Student> getAllStudent(String search,String from,String to)
	{
		System.out.println(from);
		Pageable paging=new Pagination().getPagination(from,to);
		if((search=="") || (search==null) || (search.length()==0))
		{
			return sturepository.findByOrderById(paging,Student.class);
			
		}
		else
		{
			return sturepository.findByName(search,paging,Student.class);
		}
	}
	//get  data by id
   public Student getById(Integer id)
   {
	     return sturepository.findById(id).get();
	
   }
	//post to add data
	public Student  addStudent(Student student)
	{
		return sturepository.save(student);
	}
	//update data 
	public void updateStudent(String id, Student student)
	{
		sturepository.save(student);
	}
	//delete by id
	public void deleteStudent(Integer id)
	{
		sturepository.deleteById(id);
	}
	
	public Page<Student> getAlldata(String search, String pageNo, String size) {
		
		return null;
	}
	
}