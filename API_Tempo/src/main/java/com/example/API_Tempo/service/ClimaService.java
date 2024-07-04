package com.example.API_Tempo.service;
import com.example.API_Tempo.model.ClimaEntity;
import com.example.API_Tempo.repository.ClimaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Service
public class ClimaService {

    @Autowired
    private ClimaRepository climaRepository;

    public String preverTempo() {
        String dadosMeteorologicos = "";
        //Nível BR
        String apiUrl = "https://apiadvisor.climatempo.com.br/api/v1/anl/synoptic/locale/BR?token=9fe25332679ebce952fdd9f7f9a83c3e";
        //Nível BH
        //String apiUrl = "http://apiadvisor.climatempo.com.br/api/v1/weather/locale/6879/current?token=9fe25332679ebce952fdd9f7f9a83c3e";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            dadosMeteorologicos = responseEntity.getBody();
        } else {
            dadosMeteorologicos = "Falha ao obter dados meteorológicos. Código de status: " + responseEntity.getStatusCode();
        }
        inserirDados(dadosMeteorologicos);
        return dadosMeteorologicos;
    }

    public void inserirDados(String dadosMeteorologicos) {
        try {
            JSONArray jsonArray = new JSONArray(dadosMeteorologicos);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                String country = jsonObj.getString("country");
                String date = jsonObj.getString("date");
                String text = jsonObj.getString("text");
                ClimaEntity clima = new ClimaEntity();
                clima.setPais(country);
                clima.setDate(date);
                clima.setText(text);
                climaRepository.save(clima);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}