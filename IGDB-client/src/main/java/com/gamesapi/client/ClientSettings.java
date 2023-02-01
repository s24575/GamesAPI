package com.gamesapi.client;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ClientSettings {
    @Value("${igdb.api.host}")
    String baseUrl;
    @Value("${igdb.api.client-id}")
    String clientId;
    @Value("${igdb.api.access-token}")
    String accessToken;
    @Value("${igdb.api.version}")
    int version;

    public String buildURL(){
        return "https://" + baseUrl + "/v" + version;
    }
}
