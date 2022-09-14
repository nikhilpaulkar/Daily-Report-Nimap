package com.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.entity.FileEntity;

@Repository
public interface FileUploadRepository extends JpaRepository<FileEntity, Integer>
{


	
}
