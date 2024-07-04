package com.example.Api_Ecomerce.service;


import com.example.Api_Ecomerce.security.JwtUtil;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String generateToken(String nomeUsuario) {
        String token = JwtUtil.generateToken(nomeUsuario);
        return token;
    }

    public String extractUsername(String token) {
        String username = JwtUtil.extractUsername(token);
        return username;
    }
}
