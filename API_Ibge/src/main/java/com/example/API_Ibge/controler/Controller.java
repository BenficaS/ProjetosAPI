package com.example.API_Ibge.controler;

import com.example.API_Ibge.service.IbgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    //Classe de serviços

    @Autowired
    private IbgeService service;

    @GetMapping("/noticiasereleases")
    public String ibgeDados(){
        return service.consultarNoticiasRelease();
    }
    @GetMapping("/release")
    public String ibgeRelease(){
        return service.consultarRealease();
    }
    @GetMapping("/noticias")
    public String ibgeNoticia(){
        return service.consultarNoticia();
    }
}