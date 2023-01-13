package com.backendcarwash.backendcarwash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@SpringBootApplication
public class BackendCarWashApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendCarWashApplication.class, args);
	}

}
