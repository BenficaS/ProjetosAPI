package com.example.Api_FinalAutenticacao.controller;

import com.example.Api_FinalAutenticacao.model.User;
import com.example.Api_FinalAutenticacao.service.AuthService;
import com.example.Api_FinalAutenticacao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        String response = userService.registerUser(user);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        String token = authService.authenticateUser(username, password);
        if (token != null) {
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

    @GetMapping("/role/{token}")
    public ResponseEntity<String> extractRole(@PathVariable String token) {
        String role = authService.extractRole(token);
        if (role != null) {
            System.out.println(role);
            return ResponseEntity.ok(role);
        } else {
            System.err.println(token);
            return ResponseEntity.status(400).body("Role não existe.");
        }
    }
}
