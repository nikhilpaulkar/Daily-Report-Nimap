package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.ApiLoggerEntity;

@Repository
public interface ApiLoggerRepo extends JpaRepository<ApiLoggerEntity, Integer>
{

}
