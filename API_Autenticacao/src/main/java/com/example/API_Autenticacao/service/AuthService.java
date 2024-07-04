package com.example.API_Autenticacao.service;

import com.example.API_Autenticacao.security.API_AutenticacaoUtil;
import org.springframework.stereotype.Service;


@Service
public class AuthService {


    public String generateToken(String username) {
        String token = API_AutenticacaoUtil.generateToken(username);
        return token;
    }

    public String extractUsername(String token) {
        String username = API_AutenticacaoUtil.extractUsername(token);
        return username;
    }
}