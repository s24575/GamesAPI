package com.gamesapi.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int sourceId;

    private double aggregatedRating;
    private int aggregatedRatingCount;
    private long firstReleaseDate;
    private String name;
    private double rating;
    private int ratingCount;
    private String storyline;
    private String summary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cover_id", referencedColumnName = "id")
    private Cover cover;
    @ManyToMany
    @JoinTable(
            name = "game_genre",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genres = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "game_company",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id")
    )
    private List<Company> companies = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "game_language",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    private List<Language> languages = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "game_platform",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "platform_id")
    )
    private List<Platform> platforms = new ArrayList<>();

    @ManyToMany(mappedBy = "similarTo", cascade = CascadeType.ALL)
    private List<Game> similarGames = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "game_game",
            joinColumns = @JoinColumn(name = "game1_id"),
            inverseJoinColumns = @JoinColumn(name = "game2_id")
    )
    private List<Game> similarTo = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSourceId() {
        return sourceId;
    }

    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
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

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
    }

    public List<Game> getSimilarGames() {
        return similarGames;
    }

    public void setSimilarGames(List<Game> similarGames) {
        this.similarGames = similarGames;
    }

    public List<Game> getSimilarTo() {
        return similarTo;
    }

    public void setSimilarTo(List<Game> similarTo) {
        this.similarTo = similarTo;
    }
}
