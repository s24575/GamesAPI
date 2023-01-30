package com.gamesapi.webapi.contract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class GameDto {
    @JsonProperty("id")
    private int id;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAggregatedRating() {
        return aggregatedRating;
    }

    public void setAggregatedRating(double aggregatedRating) {
        this.aggregatedRating = aggregatedRating;
    }

    public int getAggregatedRatingCount() {
        return aggregatedRatingCount;
    }

    public void setAggregatedRatingCount(int aggregatedRatingCount) {
        this.aggregatedRatingCount = aggregatedRatingCount;
    }

    public long getFirstReleaseDate() {
        return firstReleaseDate;
    }

    public void setFirstReleaseDate(long firstReleaseDate) {
        this.firstReleaseDate = firstReleaseDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }

    public String getStoryline() {
        return storyline;
    }

    public void setStoryline(String storyline) {
        this.storyline = storyline;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getCover() {
        return cover;
    }

    public void setCover(Integer cover) {
        this.cover = cover;
    }

    public List<Integer> getGenres() {
        return genres;
    }

    public void setGenres(List<Integer> genres) {
        this.genres = genres;
    }

    public List<Integer> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Integer> companies) {
        this.companies = companies;
    }

    public List<Integer> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Integer> languages) {
        this.languages = languages;
    }

    public List<Integer> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<Integer> platforms) {
        this.platforms = platforms;
    }

    public List<Integer> getSimilarGames() {
        return similarGames;
    }

    public void setSimilarGames(List<Integer> similarGames) {
        this.similarGames = similarGames;
    }
}
