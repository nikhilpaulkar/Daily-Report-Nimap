package com.ServiceImpl;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.entity.FileEntity;
import com.exception.ResourceNotFoundException;
import com.properties.FileStorageProperties;
import com.repository.FileUploadRepository;
import com.service.FileInterface;

@Service
public class FileServiceImpl implements FileInterface {

	private final Path fileStorageLocation;

	@Autowired

	public FileServiceImpl(FileStorageProperties fileStorageProperties) {

		this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();

		try {

			Files.createDirectories(this.fileStorageLocation);

		} catch (Exception ex) {

			throw new ResourceNotFoundException(
					"Could not create the directory where the uploaded files will be stored.");

		}

	}

	@Autowired
	private FileUploadRepository fileUploadRepository;

	@Override
	public FileEntity storeFile(MultipartFile file, String type, HttpServletRequest request) {

		// Normalize file name
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		try {

			// Check if the file's name contains invalid characters
			if (fileName.contains("..")) 
			{

				throw new ResourceNotFoundException("Sorry! Filename contains invalid path sequence " + fileName);

			}

			File pathAsFile = new File(this.fileStorageLocation + "/" + type);

			if (!Files.exists(Paths.get(this.fileStorageLocation + "/" + type))) 
			{

				pathAsFile.mkdir();
            
			}

			// Copy file to the target location (Replacing existing file with the same name)
			Path targetLocation = this.fileStorageLocation.resolve(type + "/" + fileName);
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
			FileEntity newFile = new FileEntity();
			newFile.setEncoding(request.getCharacterEncoding());
			newFile.setType(type);
			newFile.setFilename(fileName);
			newFile.setMimetype(file.getContentType());
			newFile.setOriginalname(fileName);
			newFile.setSize(file.getSize());

			FileEntity fileDetail = fileUploadRepository.save(newFile);
			return fileDetail;

		} catch (IOException ex) 
		{

			throw new ResourceNotFoundException("Could not store file " + fileName + ". Please try again!");

		}

	}

	@Override
	public Resource loadFileAsResource(String fileName) throws ResourceNotFoundException {

		try 
		{

			Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
			Resource resource = new UrlResource(filePath.toUri());

			if (resource.exists()) 
			{

				return resource;

			} else 
			{

				throw new ResourceNotFoundException("File not found ");

			}

		} catch (Exception ex) 
		{

			throw new ResourceNotFoundException("File not found");

		}

	}

	@Override
	public String getFolderName(String type) throws ResourceNotFoundException 
	{

		String folderPath = "";

		switch (type) {

		case "images":
			folderPath = "images";
			break;

		case "test":
			folderPath = "test";
			break;

		case "pdf":
			folderPath = "pdf";
			break;

		default:
			throw new ResourceNotFoundException("Invalid Upload Type");

		}

		return folderPath;

	}

}
