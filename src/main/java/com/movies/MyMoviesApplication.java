package com.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com")
public class MyMoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyMoviesApplication.class, args);
	}
}
