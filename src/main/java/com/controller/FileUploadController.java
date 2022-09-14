package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dto.ErrorResponseDto;
import com.dto.SuccessResponseDto;
import com.entity.FileEntity;
import com.entity.UploadFileResponse;
import com.exception.ResourceNotFoundException;
import com.service.FileInterface;

@RestController
@RequestMapping("/file")
public class FileUploadController 
{

   @Autowired
   private FileInterface fileinterface;
	
	@PostMapping
	public ResponseEntity<?> addfile(@RequestParam("file") MultipartFile file,@RequestParam(defaultValue = "") String type, HttpServletRequest request)
			
	{
		FileEntity fileDetail = new FileEntity();

		try 
		{

			fileDetail = fileinterface.storeFile(file, fileinterface.getFolderName(type), request);

		} catch (ResourceNotFoundException e) 
		{

			return new ResponseEntity<>(new ErrorResponseDto(e.getMessage(), "invalidUploadType"), HttpStatus.BAD_REQUEST);

		}

		return new ResponseEntity<>(new SuccessResponseDto("File Uploaded Successfully", "fileUploadSuccessfully", new UploadFileResponse(fileDetail.getId(), fileDetail.getFilename(), type)), HttpStatus.CREATED);

	   }
	
		
		
	}
	

