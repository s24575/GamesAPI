package com.gamesapi.repositories;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Getter
public class DataCatalog implements ICatalogData {
    private final GameRepository games;
}
