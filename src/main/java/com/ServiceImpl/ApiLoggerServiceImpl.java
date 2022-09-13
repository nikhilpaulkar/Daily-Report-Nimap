package com.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.ApiLoggerEntity;
import com.repository.ApiLoggerRepository;
import com.service.ApiLoggerServiceInterface;

@Service
public class ApiLoggerServiceImpl implements ApiLoggerServiceInterface
{

	@Autowired
	ApiLoggerRepository apiLoggerRepository;
	@Override
	public void createApiLog(ApiLoggerEntity api) 
	{
		apiLoggerRepository.save(api);
		
	}

}
