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
public class LanguageDto {
    @JsonProperty("id")
    private int sourceId;

    private String name;
    @JsonProperty("native_name")
    private String nativeName;
}
