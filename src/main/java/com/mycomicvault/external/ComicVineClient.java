package com.mycomicvault.external;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ComicVineClient {

    @Value("${comicvine.api.url}")
    private String baseUrl;

    @Value("${comicvine.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public ResponseEntity<String> buscar(String query, String resource) {
        String url = String.format(
                "%s/search/?api_key=%s&format=json&query=%s&resources=%s",
                baseUrl, apiKey, query, resource
        );

        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "MyComicVault");

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    }

    public ResponseEntity<String> buscarPorFiltro(String recurso, String nome) {
        String url = String.format(
                "%s/%s/?api_key=%s&format=json&filter=name:%s",
                baseUrl, recurso, apiKey, nome
        );

        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "MyComicVault");

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    }

    public ResponseEntity<String> buscarEdicaoPorVolumeEEdicao(String volumeId, String numero) {
        String url = String.format(
                "%s/issues/?api_key=%s&format=json&filter=volume:%s,issue_number:%s",
                baseUrl, apiKey, volumeId, numero
        );

        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "MyComicVault");

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    }
}
