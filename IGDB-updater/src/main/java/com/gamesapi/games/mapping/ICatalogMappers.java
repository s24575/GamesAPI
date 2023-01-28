package com.gamesapi.games.mapping;

import com.gamesapi.contract.CompanyDto;
import com.gamesapi.contract.CoverDto;
import com.gamesapi.contract.GameDto;
import com.gamesapi.contract.dictionaries.GenreDto;
import com.gamesapi.contract.dictionaries.LanguageDto;
import com.gamesapi.contract.dictionaries.PlatformDto;
import com.gamesapi.model.*;

public interface ICatalogMappers {
    IMapEntities<CompanyDto, Company> forCompany();
    IMapEntities<CoverDto, Cover> forCover();
    IMapEntities<GameDto, Game> forGame();
    IMapEntities<GenreDto, Genre> forGenre();
    IMapEntities<LanguageDto, Language> forLanguage();
    IMapEntities<PlatformDto, Platform> forPlatform();

}
