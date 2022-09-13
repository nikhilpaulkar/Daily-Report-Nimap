package com.ServiceImpl;

import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Path;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dto.FileDto;
import com.entity.FileEntity;
import com.properties.FileStorageProperties;
import com.repository.FileUploadRepository;
import com.service.FileInterface;

@Service
public class FileServiceImpl implements FileInterface
{
	private final Path fileStorageLocation = null;
	@Autowired
	private FileUploadRepository fileuploadrepo;
	
	
	@Autowired
	private ModelMapper modelmapper;
	
	
	//conversion fileentity  to  dto 
	private  FileEntity dtoToFileEntity(FileDto filedto)
	{
		FileEntity fileentity =this.modelmapper.map(filedto, FileEntity.class);
		
		return fileentity;
	}
  
	// conversion dto to fileentity
	private FileDto fileToDto(FileEntity  fileentity)
	{
		FileDto filedto =this.modelmapper.map(fileentity,FileDto.class);
		return filedto;
	}

	@Override
	public FileEntity storeFile(MultipartFile file, String type, HttpServletRequest request) 
	{
		
		return null;
	}
     
	// upload file 
	



	

}