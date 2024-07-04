package com.exemple.fipe.controler;

import com.exemple.fipe.service.FipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FipeControler {


    @Autowired
    private FipeService service;

    @GetMapping("/marcas")
    public String consultarMarcas() {
        return service.consultarMarcas();
    }
}
