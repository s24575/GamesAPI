package com.gamesapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
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

    @OneToOne
    private Cover cover;

    @ManyToMany
    private List<Genre> genres = new ArrayList<>();
    @ManyToMany
    private List<Company> companies = new ArrayList<>();
    @ManyToMany
    private List<Language> languages = new ArrayList<>();
    @ManyToMany
    private List<Platform> platforms = new ArrayList<>();
    @ManyToMany
    private List<Game> similarGames = new ArrayList<>();
}
