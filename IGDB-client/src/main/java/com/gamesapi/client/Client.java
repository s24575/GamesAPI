package com.gamesapi.client;

import com.gamesapi.contract.GameDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Client implements IClient{
    @Autowired
    RestTemplate restTemplate;
    @Value("${igdb.api.host}")
    String baseUrl;
    @Value("${igdb.api.client-id}")
    String clientId;
    @Value("${igdb.api.access-token}")
    String accessToken;
    @Value("${igdb.api.version}")
    int version;

    @Override
    public GameDto getGame(int id) {
        String url = "https://" + baseUrl + "/v" + version + "/games";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Client-ID", clientId);
        headers.add("Authorization", "Bearer " + accessToken);
        String body = "fields name; where id=" + id + ";";
        HttpEntity<String> request = new HttpEntity<String>(body, headers);
//        ResponseEntity<GameDto> response = restTemplate.postForEntity(url, request, GameDto.class);
        ResponseEntity<List<GameDto>> response = restTemplate.exchange(url, HttpMethod.POST, request, new ParameterizedTypeReference<List<GameDto>>() {});
        return response.getBody().get(0);
    }
}
