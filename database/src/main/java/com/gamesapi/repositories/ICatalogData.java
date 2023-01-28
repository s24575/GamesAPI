package com.gamesapi.repositories;

public interface ICatalogData {
    GameRepository getGames();
    CompanyRepository getCompanies();
    LanguageRepository getLanguages();
    GenreRepository getGenres();
    PlatformRepository getPlatforms();
    CoverRepository getCovers();
}
