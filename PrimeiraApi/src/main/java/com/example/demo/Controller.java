package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("test")
    public String helloWorld() {return  " Essa é a minha primeira API REST";}
}
