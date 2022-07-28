package com.service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.entity.Student;
import com.exception.ResourceNotFoundException;
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
	public void updateuser(String id,Student student)
	{
		  sturepository.findById(Integer.parseInt(id)).orElseThrow(() -> new ResourceNotFoundException("resource not found"));
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
//	//dto to student 
//	public Student dtoToStudent(com.demo.dto.StudentDto studentdto)
//	{
//		return this.modelMapper.map(studentdto, Student.class);
//	}
//	//student to dto
//	public com.demo.dto.StudentDto studentoDto(Student student)
//	{
//		return this.modelMapper.map(student, com.demo.dto.StudentDto.class);
//	}
//	
}