package com.gamesapi.client;

import com.gamesapi.contract.GameDto;
import com.gamesapi.contract.dictionaries.GenreDto;
import com.gamesapi.contract.dictionaries.LanguageDto;
import com.gamesapi.contract.dictionaries.PlatformDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
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

//    private String URL;
//    private HttpHeaders headers;
//    public Client(HttpHeaders headers){
//        this.headers = headers;
//    }

    @Override
    public GameDto getGame(int id) {
        System.out.println("Game ID: " + id);
        String url = "https://" + baseUrl + "/v" + version + "/games";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Client-ID", clientId);
        headers.add("Authorization", "Bearer " + accessToken);
        String body = "fields *; where id=" + id + ";";
        HttpEntity<String> request = new HttpEntity<String>(body, headers);
//        ResponseEntity<GameDto> response = restTemplate.postForEntity(url, request, GameDto.class);
        ResponseEntity<List<GameDto>> response = restTemplate.exchange(url, HttpMethod.POST, request, new ParameterizedTypeReference<List<GameDto>>() {});
        return response.getBody().get(0);
    }

    public List<GameDto> getGamesBetweenDates(LocalDate from, LocalDate to) {
        String url = "https://" + baseUrl + "/v" + version + "/games";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Client-ID", clientId);
        headers.add("Authorization", "Bearer " + accessToken);
        String body = "fields *; where first_release_date > " + from.toEpochSecond(LocalTime.NOON, ZoneOffset.MIN) + " & first_release_date < " + to.toEpochSecond(LocalTime.NOON, ZoneOffset.MIN) + "; limit 500;";
        HttpEntity<String> request = new HttpEntity<String>(body, headers);
        ResponseEntity<List<GameDto>> response = restTemplate.exchange(url, HttpMethod.POST, request, new ParameterizedTypeReference<List<GameDto>>() {});
        return response.getBody();
    }

    public List<GenreDto> getGenres(){
        String url = "https://" + baseUrl + "/v" + version + "/genres";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Client-ID", clientId);
        headers.add("Authorization", "Bearer " + accessToken);
        String body = "fields *; limit 500;";
        HttpEntity<String> request = new HttpEntity<String>(body, headers);
        ResponseEntity<List<GenreDto>> response = restTemplate.exchange(url, HttpMethod.POST, request, new ParameterizedTypeReference<List<GenreDto>>() {});
        return response.getBody();
    }

    public List<LanguageDto> getLanguages(){
        String url = "https://" + baseUrl + "/v" + version + "/languages";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Client-ID", clientId);
        headers.add("Authorization", "Bearer " + accessToken);
        String body = "fields *; limit 500;";
        HttpEntity<String> request = new HttpEntity<String>(body, headers);
        ResponseEntity<List<LanguageDto>> response = restTemplate.exchange(url, HttpMethod.POST, request, new ParameterizedTypeReference<List<LanguageDto>>() {});
        return response.getBody();
    }

    public List<PlatformDto> getPlatforms(){
        String url = "https://" + baseUrl + "/v" + version + "/platforms";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Client-ID", clientId);
        headers.add("Authorization", "Bearer " + accessToken);
        String body = "fields *; limit 500;";
        HttpEntity<String> request = new HttpEntity<String>(body, headers);
        ResponseEntity<List<PlatformDto>> response = restTemplate.exchange(url, HttpMethod.POST, request, new ParameterizedTypeReference<List<PlatformDto>>() {});
        return response.getBody();
    }
}
