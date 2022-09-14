package com;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.properties.FileStorageProperties;

@SpringBootApplication()
@EnableConfigurationProperties({ FileStorageProperties.class })
public class CurdOperationApplication {
	public static void main(String[] args) {
		SpringApplication.run(CurdOperationApplication.class, args);
	}

	@Bean
	public ModelMapper modelmapper() {
		return new ModelMapper();
	}
}
