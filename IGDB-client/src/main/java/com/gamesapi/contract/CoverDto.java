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
public class CoverDto {
    @JsonProperty("id")
    private int sourceId;

    private int height;
    @JsonProperty("image_id")
    private String imageId;
    private String url;
    private int width;
}
