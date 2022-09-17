package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.service.ExcelInterface;

@RestController
@RequestMapping("/excel")
public class ExcelController 
{
	@Autowired
	private ExcelInterface excelinterface;
	
	 @PostMapping()
	  public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) 
	  {
	  
		
		if (Helper.hasExcelFormat(file))
		{
		try
		{
				    	
	    excelinterface.save(file);
				    
		return new ResponseEntity<>("Successfully Uploaded",HttpStatus.OK);
		} catch (Exception e) 
	    {
				       
		return new ResponseEntity<>("Could not upload the file..",HttpStatus.BAD_REQUEST);
	   }
 }

	return new ResponseEntity<>("Please upload an excel file..",HttpStatus.NOT_ACCEPTABLE);

			}

	 }
	
	
	
	
	


