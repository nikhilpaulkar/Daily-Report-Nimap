package com.Intercepters;

import java.util.ArrayList;
import java.util.Arrays;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ServiceImpl.LoggerServiceInterface;
import com.dto.ErrorResponseDto;
import com.entity.ApiLoggerEntity;
import com.entity.LoggerEntity;
import com.google.gson.Gson;
import com.service.ApiLoggerServiceInterface;
@Component

public class ApiLogger implements HandlerInterceptor
{
	public ApiLogger() {

		// TODO Auto-generated constructor stub
	}
	@Autowired
	private LoggerServiceInterface loggerServiceInterface;

	@Autowired
	private ApiLoggerServiceInterface apiLoggerSerivceInterface;

	
	//Gson gson = new Gson();

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		
		ArrayList<String> url = new ArrayList<>(Arrays.asList("/auth/login", "/auth/register/") );
            final String requesturl=request.getRequestURI();
            System.out.println("url"+requesturl);
            final String requestTokenHeader = request.getHeader("Authorization");
            System.out.println("url header"+request.getHeader("Authorization"));
            System.out.println("sd");
		if (!url.contains(requesturl)) {
      
			final String requestHeader = request.getHeader("Authorization").split(" ")[1];
			LoggerEntity logsDetail = loggerServiceInterface.getLoggerDetail(requestTokenHeader);

			if (logsDetail == null) {

				ErrorResponseDto error = new ErrorResponseDto("You are not login User", "notLoginUser");
				//String employeeJsonString = this.gson.toJson(error);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				//response.getWriter().write(employeeJsonString);
				return false;

			} else {

				ApiLoggerEntity apiDetail = new ApiLoggerEntity();
				
				apiDetail.setIpAddress(request.getRemoteAddr());
				apiDetail.setUrl(request.getRequestURI());
				apiDetail.setMethod(request.getMethod());
				apiDetail.setHost(request.getRemoteHost());
			
				apiLoggerSerivceInterface.createApiLog(apiDetail);
				return true;

			}

		} else {
			ApiLoggerEntity apiDetail = new ApiLoggerEntity();
			
			apiDetail.setIpAddress(request.getRemoteAddr());
			apiDetail.setUrl(request.getRequestURI());
			apiDetail.setMethod(request.getMethod());
			apiDetail.setHost(request.getRemoteHost());
		
			apiLoggerSerivceInterface.createApiLog(apiDetail);
			return true;
			
			

		}

	}

}
