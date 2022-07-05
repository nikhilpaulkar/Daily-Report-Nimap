package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bean.Subject;
import service.SubjectService;

@RestController
public class SubjectController 
{
	@Autowired
    private SubjectService subjectService;
	@RequestMapping("subject")
	public List<Subject> getallsubject()
	{
	 return	subjectService.getAllsubject();
		
	}
	@RequestMapping(method = RequestMethod.POST, value="/subject")
	public void addSubject(@RequestBody Subject subject )
	{
		subjectService.addSubject(subject);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/subject/{id}")
	public void updateSubject(@PathVariable String id,@RequestBody Subject subject )
	{
		
	}
	public void DeleteSubject(@PathVariable String id)
	{
		
	}
	
}
