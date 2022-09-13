package com.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.LoggerDto;
import com.entity.LoggerEntity;
import com.entity.User;
import com.repository.LoggerRepository;

@Service("LoggerServiceImpl")
public class LoggerServiceImpl implements LoggerServiceInterface
{
	@Autowired
	private LoggerRepository loggerrepository;
  	@Override
	public void createLogger(LoggerDto loggerdto , User user)
  	{

  		LoggerEntity logger=new LoggerEntity();

  	    logger.setUserid(user);
		logger.setToken(loggerdto.getToken());
		logger.setExpiredat(loggerdto.getExpiredAt());
		System.out.println("logger"+logger);
		loggerrepository.save(logger);




  	}
	@Override
	public LoggerEntity getLoggerDetail(String requestTokenHeader) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
