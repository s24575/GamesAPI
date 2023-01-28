package com.gamesapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Platform {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int sourceId;

    private int generation;
    private String name;
    private String summary;

    @ManyToMany
    private List<Game> games = new ArrayList<>();
}
