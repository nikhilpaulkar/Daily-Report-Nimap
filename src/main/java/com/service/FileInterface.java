package com.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.entity.FileEntity;
import com.exception.ResourceNotFoundException;

public interface FileInterface 
{
	public FileEntity storeFile(MultipartFile file, String type, HttpServletRequest request);

	public String getFolderName(String type);

	Resource loadFileAsResource(String fileName) ;
 
	
}
