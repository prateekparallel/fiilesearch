package com.elsevier.filesearch.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.elsevier"})
public class FileSearchApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(FileSearchApplication.class, args);
	}

}

