package com.example.API_Autenticacao.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example"})
public class ApiAutenticacaoApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiAutenticacaoApplication.class, args);
	}
}