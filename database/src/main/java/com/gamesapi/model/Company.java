package com.gamesapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int sourceId;

    private int country;
    private String description;
    private String name;
    private String url;

    @OneToOne
    private Cover cover;

    @ManyToMany
    private List<Game> developed = new ArrayList<>();
}
