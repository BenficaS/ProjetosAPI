package com.example.Api_FinalAutenticacao.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

    @SpringBootApplication(scanBasePackages = {"com.example"})
    @EnableMongoRepositories("com.example.Api_FinalAutenticacao.repository")
    public class JwtApiFinalRestApllication {

        public static void main(String[] args) {
            SpringApplication.run(JwtApiFinalRestApllication.class, args);
        }

    }
