package com.gamesapi.contract.dictionaries;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlatformDto {
    @JsonProperty("id")
    private int sourceId;

    private int generation;
    private String name;
    private String summary;
}
