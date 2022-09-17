package com.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.ApiLoggerEntity;
import com.repository.ApiLoggerRepo;
import com.service.ApiLoggerServiceInterfaace;

@Service
public class ApiLoggerServiceImpl implements ApiLoggerServiceInterfaace
{
	@Autowired
	private ApiLoggerRepo apiLoggerRepo;
	@Override
	public void createApiLog(ApiLoggerEntity apiLoggerEntity)
	{
		apiLoggerRepo.save(apiLoggerEntity);
	}
	public ApiLoggerServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
}
