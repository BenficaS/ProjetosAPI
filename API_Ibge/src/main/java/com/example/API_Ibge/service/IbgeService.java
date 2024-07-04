package com.example.API_Ibge.service;
import com.example.API_Ibge.model.IbgeEntity;
import com.example.API_Ibge.repository.IbgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Service
public class IbgeService {

    @Autowired
    private IbgeRepository ibgeRepository;

        public String consultarNoticiasRelease() {
            String dadosIbge = "";
            String apiUrl = "https://servicodados.ibge.gov.br/api/v3/noticias";

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                dadosIbge = responseEntity.getBody();
            } else {
                dadosIbge = "Falha ao obter dados meteorológicos. Código de status: " + responseEntity.getStatusCode();
            }

            IbgeEntity ie = new IbgeEntity();
            ie.setNoticiasRelease(dadosIbge);

            inserirDados(ie);
            return dadosIbge;
        }

        public void inserirDados(IbgeEntity ibge) {
            ibgeRepository.save(ibge);
        }

    public String consultarRealease() {
        String dadosRelease = "";
        String apiUrl = "https://servicodados.ibge.gov.br/api/v3/noticias/?tipo=release";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            dadosRelease = responseEntity.getBody();
        } else {
            dadosRelease = "Falha ao obter dados meteorológicos. Código de status: " + responseEntity.getStatusCode();
        }

        IbgeEntity release = new IbgeEntity();
        release.setRelease(dadosRelease);

        inserirRelease(release);
        return dadosRelease;
    }

    public void inserirRelease(IbgeEntity ibge) {
        ibgeRepository.save(ibge);
    }
    public String consultarNoticia() {
        String dadosNoticia = "";
        String apiUrl = "https://servicodados.ibge.gov.br/api/v3/noticias/?tipo=release";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            dadosNoticia = responseEntity.getBody();
        } else {
            dadosNoticia = "Falha ao obter dados meteorológicos. Código de status: " + responseEntity.getStatusCode();
        }

        IbgeEntity noticia = new IbgeEntity();
        noticia.setNoticia(dadosNoticia);

        inserirNoticia(noticia);
        return dadosNoticia;
    }

    public void inserirNoticia(IbgeEntity ibge) {
        ibgeRepository.save(ibge);
    }

    }