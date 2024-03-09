package com.example.demo;

import com.example.demo.repository.DemoApplication;
import org.springframework.boot.SpringApplication;

public class TestDemoApplication {
	public static void main(String[] args) {
		SpringApplication
				.from(DemoApplication::main)
				.with(TestDemoApplication.class)
				.run(args);
	}
}


