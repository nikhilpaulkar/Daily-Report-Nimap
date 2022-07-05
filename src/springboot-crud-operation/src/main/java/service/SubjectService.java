package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bean.Subject;
import repository.SubjectRepository;

@Service
public class SubjectService 
{
	@Autowired
	public SubjectRepository subjectRep;
	public List<Subject> getAllsubject()
   {
		
        List<Subject> subject = new ArrayList<>();
		
		return subject;
   }
	public void addSubject(Subject subject)
	{
	
	}
}
