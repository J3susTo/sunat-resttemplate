package com.sunat.sunatresttemplate.service;

import com.sunat.sunatresttemplate.model.SunatResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class SunatService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String API_BASE_URL = "https://api.decolecta.com/v1/sunat/";
    @Value("${token}")
    private String token;

    public SunatResponse consultarRuc(String numero) {
        log.info("Consultando RUC: {}", numero);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        headers.set("Accept", "application/json");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            return restTemplate.exchange(
                    API_BASE_URL + "ruc?numero=" + numero,
                    HttpMethod.GET,
                    entity,
                    SunatResponse.class
            ).getBody();
        } catch (HttpClientErrorException e) {
            log.error("Error en la consulta de RUC: {}, código: {}", numero, e.getStatusCode());
            throw new RuntimeException("Error en la consulta de RUC: " + e.getStatusCode());
        }
    }

    public SunatResponse consultarRucFull(String numero) {
        log.info("Consultando RUC completo: {}", numero);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        headers.set("Accept", "application/json");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            return restTemplate.exchange(
                    API_BASE_URL + "ruc/full?numero=" + numero,
                    HttpMethod.GET,
                    entity,
                    SunatResponse.class
            ).getBody();
        } catch (HttpClientErrorException e) {
            log.error("Error en la consulta de RUC completo: {}, código: {}", numero, e.getStatusCode());
            throw new RuntimeException("Error en la consulta de RUC completo: " + e.getStatusCode());
        }
    }
}