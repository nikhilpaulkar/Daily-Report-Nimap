package com.service;

import javax.servlet.http.HttpServletRequest;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import com.entity.FileEntity;


public interface FileInterface {
	public FileEntity storeFile(MultipartFile file, String type, HttpServletRequest request);

	public String getFolderName(String type);

	public Resource loadFileAsResource(String fileName);

}
