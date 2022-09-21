package com.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;



import com.google.gson.Gson;
import com.service.ApiLoggerServiceInterfaace;
import com.ServiceImpl.LoggerServiceInterface;
import com.entity.ApiLoggerEntity;
import com.entity.LoggerEntity;

import com.exception.Errordetails;

@Component
public class ApiLogger implements HandlerInterceptor
{
	@Autowired
	private LoggerServiceInterface loggerServiceInterface;
	
	@Autowired
	private ApiLoggerServiceInterfaace apiLoggerServiceInterface;
	
	public ApiLogger()
	{
		super();
		// TODO Auto-generated constructor stub
	}
    Gson gson=new Gson();

	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception
	{
		
		
		ArrayList<String> url=new ArrayList<>(Arrays.asList("/login","/register"));
		
		final String requestUrl=request.getRequestURI();
		
		final String header=request.getHeader("Authorization");
	
		
		if(!url.contains(requestUrl))
		{
		final String requestHeader=(null !=header ) ?header.split(" ")[1]:null ;
			LoggerEntity logDetails=loggerServiceInterface.getLoggerDetail(requestHeader);

			
        
		
		if(logDetails==null)
		{
			
			Errordetails errorDetails=new Errordetails(new Date(), "User Not Log In", "Not LogIn");
			String employeeJsonString = this.gson.toJson(errorDetails);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.getWriter().write(employeeJsonString);

			return false;
		}
		else
		{
			
			ApiLoggerEntity apiLoggerEntity=new ApiLoggerEntity();

			
			apiLoggerEntity.setToken(header);
			apiLoggerEntity.setMethod(request.getMethod());
			apiLoggerEntity.setUrl(request.getRequestURI());
			apiLoggerEntity.setHost(request.getRemoteHost());
			apiLoggerEntity.setIpAddress(request.getRemoteAddr());
			apiLoggerEntity.setBody(request instanceof StandardMultipartHttpServletRequest ? null : request.getReader().lines().collect(Collectors.joining(System.lineSeparator())));

			this.apiLoggerServiceInterface.createApiLog(apiLoggerEntity);
			return true;
		 }
		
		
	    }
		else
	    {
			
		ApiLoggerEntity apiLoggerEntity=new ApiLoggerEntity();
		apiLoggerEntity.setToken("");
		apiLoggerEntity.setMethod(request.getMethod());
		apiLoggerEntity.setUrl(requestUrl);
		apiLoggerEntity.setHost(request.getRemoteHost());
		apiLoggerEntity.setIpAddress(request.getRemoteAddr());
		apiLoggerEntity.setBody(request instanceof StandardMultipartHttpServletRequest ? null : request.getInputStream().toString().lines().collect(Collectors.joining(System.lineSeparator())));

		this.apiLoggerServiceInterface.createApiLog(apiLoggerEntity);
		return true;


		
		
	}

	
	

}



}