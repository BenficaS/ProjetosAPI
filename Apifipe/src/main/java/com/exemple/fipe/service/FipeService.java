package com.exemple.fipe.service;
import com.exemple.fipe.model.EntityFipe;
import com.exemple.fipe.repository.FipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Service
public class FipeService {
    @Autowired
    private FipeRepository fipeRepository;
    public String consultarMarcas() {
        String dadosFipe = "";
        String apiUrl = "https://parallelum.com.br/fipe/api/v1/carros/marcas";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            dadosFipe = responseEntity.getBody();
        } else {
            dadosFipe = "Falha ao obter dados meteorológicos. Código de status: " + responseEntity.getStatusCode();
        }
        inserirDados(dadosFipe);
        return dadosFipe;
    }

    public void inserirDados(String dadosFipe) {
        try {
            JSONArray jsonArray = new JSONArray(dadosFipe);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                String nome = jsonObj.getString("nome");
//                String date = jsonObj.getString("date");
//                String text = jsonObj.getString("text");
                EntityFipe fipe = new EntityFipe();
                fipe.setMarca(nome);
//                clima.setDate(date);
//                clima.setText(text);
                fipeRepository.save(fipe);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
