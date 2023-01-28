package com.gamesapi.contract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReleaseDateDto {
    @JsonProperty("id")
    private int sourceId;
    private long date;
    @JsonProperty("game")
    private int gameSourceId;
}
