package com.exemple.fipe.aplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {"com.exemple.fipe"})
@EnableMongoRepositories("com.exemple.fipe.repository")

public class FipeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FipeApplication.class, args);
	}

}
