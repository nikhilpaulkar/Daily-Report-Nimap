package com.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.PermissionEntity;

@Repository
public interface PermissionRepo extends JpaRepository<PermissionEntity, Integer> 
{

	Page<?> findByActionName(String search, Pageable pageable, Class<PermissionEntity> class1);

}
