package com.vincent.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.vincent.demo.web.filter","com.vincent.demo"})
public class App{
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}