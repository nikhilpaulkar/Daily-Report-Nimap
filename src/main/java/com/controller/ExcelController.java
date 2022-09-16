package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.entity.ExcelEntity;
import com.excel.ExcelHelper;
import com.service.ExcelInterface;

@RestController
@RequestMapping("/excel")
public class ExcelController 
{
	@Autowired
	private ExcelInterface excelinterface;
	
	 @PostMapping()
	  public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file,String type) 
	 {
	  
           ExcelEntity excelentity=new ExcelEntity();
           if(file.getOriginalFilename().endsWith("xlsx")&&type.endsWith("xlsx"))
	    {
	      try 
	      {
	         excelentity= excelinterface.save(file, type);

	       return new ResponseEntity<>("file upload successfully!!",HttpStatus.ACCEPTED);
	      } catch (Exception e)
	      {
	        
	        return new  ResponseEntity<>("only excel file upload !!",HttpStatus.NOT_ACCEPTABLE);
	      }
	    }
		return null;

	 }
	
	
	
	
	

}
