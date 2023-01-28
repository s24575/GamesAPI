package com.gamesapi.contract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameDto {
    @JsonProperty("id")
    private int sourceId;

    @JsonProperty("aggregated_rating")
    private double aggregatedRating;
    @JsonProperty("aggregated_rating_count")
    private int aggregatedRatingCount;
    @JsonProperty("first_release_date")
    private long firstReleaseDate;
    private String name;
    private double rating;
    @JsonProperty("rating_count")
    private int ratingCount;
    private String storyline;
    private String summary;

    private Integer cover;

    private List<Integer> genres;
    @JsonProperty("involved_companies")
    private List<Integer> companies;
    @JsonProperty("language_supports")
    private List<Integer> languages;
    private List<Integer> platforms;
    @JsonProperty("similar_games")
    private List<Integer> similarGames;
}
