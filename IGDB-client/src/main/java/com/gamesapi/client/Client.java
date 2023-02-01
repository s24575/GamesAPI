package com.gamesapi.client;

import com.gamesapi.contract.CompanyDto;
import com.gamesapi.contract.CoverDto;
import com.gamesapi.contract.GameDto;
import com.gamesapi.contract.LanguageSupportDto;
import com.gamesapi.contract.dictionaries.GenreDto;
import com.gamesapi.contract.dictionaries.LanguageDto;
import com.gamesapi.contract.dictionaries.PlatformDto;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.stream.Collectors;

@Component
public class Client implements IClient{
    @Autowired
    RestTemplate restTemplate;

    private final String URL;
    private HttpHeaders httpHeaders;

    public Client(HttpHeaders httpHeaders, ClientSettings clientSettings){
        URL = clientSettings.buildURL();
        this.httpHeaders = httpHeaders;
        httpHeaders.add("Client-ID", clientSettings.getClientId());
        httpHeaders.add("Authorization", "Bearer " + clientSettings.getAccessToken());
    }

    @Override
    public GameDto getGame(int id) {
        String body = "fields *; where id=" + id + ";";
        HttpEntity<String> request = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<List<GameDto>> response = restTemplate.exchange(URL + "/games", HttpMethod.POST, request, new ParameterizedTypeReference<>() {});
        return response.getBody().get(0);
    }

    public List<GameDto> getGamesBetweenDates(LocalDate from, LocalDate to) {
        String body = "fields *; where first_release_date > " + from.toEpochSecond(LocalTime.NOON, ZoneOffset.MIN) + " & first_release_date < " + to.toEpochSecond(LocalTime.NOON, ZoneOffset.MIN) + "; limit 100;";
        HttpEntity<String> request = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<List<GameDto>> response = restTemplate.exchange(URL + "/games", HttpMethod.POST, request, new ParameterizedTypeReference<>() {});
        return response.getBody();
    }

    public CoverDto getCover(int id){
        String body = "fields *; where id=" + id + ";";
        HttpEntity<String> request = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<List<CoverDto>> response = restTemplate.exchange(URL + "/covers", HttpMethod.POST, request, new ParameterizedTypeReference<>() {});
        return response.getBody().get(0);
    }

    public List<CompanyDto> getInvolvedCompanies(List<Integer> involvedCompaniesId){
        String body = "fields *; where id=(" + involvedCompaniesId.stream().map(String::valueOf).collect(Collectors.joining(",")) + ");";
        HttpEntity<String> request = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<List<CompanyDto>> response = restTemplate.exchange(URL + "/involved_companies", HttpMethod.POST, request, new ParameterizedTypeReference<>() {});
        return response.getBody();
    }

    public List<LanguageSupportDto> getLanguageSupport(List<Integer> languageSupportsId){
        String body = "fields language; where id=(" + languageSupportsId.stream().map(String::valueOf).collect(Collectors.joining(",")) + "); limit 500;";
        HttpEntity<String> request = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<List<LanguageSupportDto>> response = restTemplate.exchange(URL + "/language_supports", HttpMethod.POST, request, new ParameterizedTypeReference<>() {});
        return response.getBody();
    }

    public List<GenreDto> getGenres(){
        String body = "fields *; limit 500;";
        HttpEntity<String> request = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<List<GenreDto>> response = restTemplate.exchange(URL + "/genres", HttpMethod.POST, request, new ParameterizedTypeReference<>() {});
        return response.getBody();
    }

    public List<LanguageDto> getLanguages(){
        String body = "fields *; limit 500;";
        HttpEntity<String> request = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<List<LanguageDto>> response = restTemplate.exchange(URL + "/languages", HttpMethod.POST, request, new ParameterizedTypeReference<>() {});
        return response.getBody();
    }

    public List<PlatformDto> getPlatforms(){
        String body = "fields *; limit 500;";
        HttpEntity<String> request = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<List<PlatformDto>> response = restTemplate.exchange(URL + "/platforms", HttpMethod.POST, request, new ParameterizedTypeReference<List<PlatformDto>>() {});
        return response.getBody();
    }
}
