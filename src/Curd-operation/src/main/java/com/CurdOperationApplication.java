package com;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
public class CurdOperationApplication
{

	public static void main(String[] args) 
	{
		SpringApplication.run(CurdOperationApplication.class, args);
	}
	@Bean
	public  ModelMapper modelMapper()
	{
		return new ModelMapper();
		
	}

}