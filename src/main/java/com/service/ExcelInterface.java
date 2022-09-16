package com.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.entity.ExcelEntity;

@Service
public interface ExcelInterface 
{

	ExcelEntity save(MultipartFile file,String type);

	
}
