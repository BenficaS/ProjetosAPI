package com.example.API_Ibge.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bd-ibge")
public class IbgeEntity {

 private String noticiasRelease;
 private String release;
 private String noticia;

    public String getNoticia() {
        return noticia;
    }

    public void setNoticia(String noticia) {
        this.noticia = noticia;
    }

    public String getNoticiasRelease() {
        return noticiasRelease;
    }

    public void setNoticiasRelease(String noticiasRelease) {
        this.noticiasRelease = noticiasRelease;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }





}