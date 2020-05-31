package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@ComponentScan("com.example.demo")
public class Demo1Application{

	@Value("${spring.application.name}")
	private String name;
	
	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}
	
	
	
}
