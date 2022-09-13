package com.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.entity.FileEntity;

public interface FileInterface 
{
	public FileEntity storeFile(MultipartFile file, String type, HttpServletRequest request);

	public static String getFolderName(String type) {
		
		return null;
	}

 
	
}
