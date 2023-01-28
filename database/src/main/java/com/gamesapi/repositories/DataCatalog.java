package com.gamesapi.repositories;

import com.gamesapi.model.Cover;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Getter
public class DataCatalog implements ICatalogData {
    private final GameRepository games;
    private final CompanyRepository companies;
    private final LanguageRepository languages;
    private final GenreRepository genres;
    private final PlatformRepository platforms;
    private final CoverRepository covers;
}
