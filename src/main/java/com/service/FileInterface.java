package com.service;

import java.util.List;

import com.dto.FileDto;


public interface FileInterface 
{
	
  FileDto addfile(FileDto filedto);
	
  List<FileDto>getallfiles();
	
}
