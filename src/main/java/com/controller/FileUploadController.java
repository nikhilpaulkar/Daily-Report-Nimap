package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import com.ServiceImpl.FileServiceImpl;

import com.dto.FileDto;
import com.exception.ResourceNotFoundException;
import com.repository.FileUploadRepository;


@RestController
@RequestMapping("/file")
public class FileUploadController 
{
	@Autowired
    private	FileServiceImpl fileserviceimpl;
	@Autowired
	private FileUploadRepository filerepo;
 
	@PostMapping
	public ResponseEntity<?> addfile(@RequestBody FileDto filedto)
	{
		try
		{
		   FileDto filedto1=this.filerepo.findbyfilename(filedto.getFilename());
		   if(filedto1!=null)
		   {
				return new  ResponseEntity<> ("user already exit",HttpStatus.NOT_ACCEPTABLE);
			}
		   else
		   {
			   fileserviceimpl.addfile(filedto1);
		   }
		}catch(ResourceAccessException e)
		{
			return new ResponseEntity<>("abc",HttpStatus.OK);
		}
	  return null;
	}
	
	@GetMapping
	public ResponseEntity<?> getallfiles(@RequestBody FileDto filedto)
	{
		try
		{
	       fileserviceimpl.getallfiles();
		}catch(ResourceNotFoundException e)
		{
			return new ResponseEntity<>("bad request",HttpStatus.BAD_REQUEST);
		}
		return null;
		
	}
	
}
