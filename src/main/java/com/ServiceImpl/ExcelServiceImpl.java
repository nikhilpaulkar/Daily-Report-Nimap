package com.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.controller.Helper;
import com.entity.ExcelEntity;

import com.repository.ExcelRepository;
import com.service.ExcelInterface;

@Service
public class ExcelServiceImpl implements ExcelInterface
{
   @Autowired
   private  ExcelRepository excelrepository;
   
   // upload excel file 
   public ExcelEntity save(MultipartFile file)
   {
	    try 
	    {
	    	
	    List<ExcelEntity> tutorials = Helper.excelToTutorials(file.getInputStream());
	    excelrepository.saveAll(tutorials);
	      
	    } catch (Exception e) 
	    {
	      throw new RuntimeException("fail to store excel data: " + e.getMessage());
	    }
		return null;
	  }

   // download excel file 
   public List<ExcelEntity> getAllTutorials() 
   {
	    return excelrepository.findAll();
	 }
   
   
}




