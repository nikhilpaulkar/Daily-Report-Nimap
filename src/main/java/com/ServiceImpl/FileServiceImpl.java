package com.ServiceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.dto.FileDto;
import com.entity.FileEntity;
import com.repository.FileUploadRepository;
import com.service.FileInterface;

@Service
public class FileServiceImpl implements FileInterface
{
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
    
	// add file
	public FileDto addfile(FileDto filedto) 
	{
       
       FileEntity fileentity1 = dtoToFileEntity(filedto);
       FileEntity fileentity=fileuploadrepo.save(fileentity1);
       
       return this.fileToDto(fileentity);
       
	}
    // get all data 
	@Override
	public List<FileDto> getallfiles() 
	{
	  List<FileEntity> entity=this.fileuploadrepo.findAll();
	 
		return null;
	}

	

	
	
	
	
	

}