package com.myWebService.futusistDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.myWebService.futusistDemo.repositories")
@ComponentScan("com.myWebService.futusistDemo.services")
@ComponentScan("com.myWebService.futusistDemo.controllers")

@SpringBootApplication
public class FutusistDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FutusistDemoApplication.class, args);
	}

}

