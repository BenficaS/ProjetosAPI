package com.example.BD_RestAPI.controller;
import com.example.BD_RestAPI.model.UserEntity;
import com.example.BD_RestAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserEntity> obterTodos() {
        return userService.obterTodos();
    }

    @GetMapping("/{id}")
    public UserEntity obterPorId(@PathVariable String id) {
        return userService.obterPorId(id);
    }
    @GetMapping("/obterNome/{nome}")
    public  List <UserEntity> obterNome(@PathVariable String nome){return userService.obterNome(nome); }
    @GetMapping("/obterEmail/{email}")
    public List<UserEntity> obterEmail(@PathVariable String email){return userService.obterEmail(email);}
    @GetMapping List<UserEntity> obterEmailNome(@RequestParam("nome") String nome, @RequestParam("email") String email) {
        return userService.obterEmailNome(nome, email);
    }
    @PostMapping
    public void inserirLista(@RequestBody List<UserEntity> users){ userService.inserirLista(users);}


    @PostMapping
    public UserEntity inserir(@RequestBody UserEntity user) { return userService.inserir(user); }

    @PutMapping("/{id}")
    public UserEntity atualizar(@PathVariable String id, @RequestBody UserEntity user) {
        return userService.atualizar(id, user);
    }
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable String id) {
        userService.excluir(id);
    }

}