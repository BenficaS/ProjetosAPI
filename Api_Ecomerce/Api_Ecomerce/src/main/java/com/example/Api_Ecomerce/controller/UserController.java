package com.example.Api_Ecomerce.controller;

import com.example.Api_Ecomerce.model.UserEntity;
import com.example.Api_Ecomerce.service.UserService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService usuarioService;

    @PostMapping("/login")
    public String login(@RequestBody UserEntity usuario) {
        String token = usuarioService.generateToken(usuario.getNome());
        return "Token: " + token;
    }


    @GetMapping("/nomeusuario/{token}")
    public String extractUsername(@PathVariable String token) {
        String username = usuarioService.extractUsername(token);
        return username;
    }

    @Secured("GERENTE")
    @GetMapping(value = "/gerente/{token}")
    public String buscaGerente(@PathVariable String token) {
        System.out.println("Chegou aqui controller");
        String nomeUsuario = usuarioService.extractUsername(token);
        return "Gerente: " + nomeUsuario;
    }

    @Secured("ADMIN")
    @GetMapping(value = "/admin/{token}")
    public String buscaAdmin(@PathVariable String token) {
        System.out.println("Chegou aqui controller");
        String nomeUsuario = usuarioService.extractUsername(token);
        return "Admin: " + nomeUsuario;
    }
}
