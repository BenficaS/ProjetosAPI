package com.example.Api_FinalAutenticacao.service;

import com.example.Api_FinalAutenticacao.model.User;
import com.example.Api_FinalAutenticacao.repository.UserRepository;
import com.example.Api_FinalAutenticacao.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public String authenticateUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return jwtUtil.generateToken(username, user.getRole());
        }
        return null;
    }

    public String extractUsername(String token) {
        return jwtUtil.extractUsername(token);
    }

    public String extractRole(String token) {
        return jwtUtil.extractRole(token);
    }
}
