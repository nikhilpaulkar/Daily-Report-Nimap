package com.service;



import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.entity.ExcelEntity;

@Service
public interface ExcelInterface 
{

	ExcelEntity save(MultipartFile file);

	List<ExcelEntity> getAllTutorials();

	

	
	
}
