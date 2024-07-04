package com.example.Jwt_RestApi.service;

import com.example.Jwt_RestApi.security.JwtUtil;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    public String generateToken(String username) {
        String token = JwtUtil.generateToken(username);
        return token;
    }

    public String extractUsername(String token) {
        String username = JwtUtil.extractUsername(token);
        return username;
    }
}