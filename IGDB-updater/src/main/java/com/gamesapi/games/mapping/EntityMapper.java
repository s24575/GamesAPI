package com.gamesapi.games.mapping;

import com.gamesapi.contract.CompanyDto;
import com.gamesapi.contract.CoverDto;
import com.gamesapi.contract.GameDto;
import com.gamesapi.contract.dictionaries.GenreDto;
import com.gamesapi.contract.dictionaries.LanguageDto;
import com.gamesapi.contract.dictionaries.PlatformDto;
import com.gamesapi.model.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EntityMapper implements ICatalogMappers {
    private final IMapEntities<CompanyDto, Company> forCompany;
    private final IMapEntities<CoverDto, Cover> forCover;
    private final IMapEntities<GameDto, Game> forGame;
    private final IMapEntities<GenreDto, Genre> forGenre;
    private final IMapEntities<LanguageDto, Language> forLanguage;
    private final IMapEntities<PlatformDto, Platform> forPlatform;

    @Override
    public IMapEntities<CompanyDto, Company> forCompany(){
        return forCompany;
    }
    @Override
    public IMapEntities<CoverDto, Cover> forCover(){
        return forCover;
    }
    @Override
    public IMapEntities<GameDto, Game> forGame(){
        return forGame;
    }
    @Override
    public IMapEntities<GenreDto, Genre> forGenre(){
        return forGenre;
    }
    @Override
    public IMapEntities<LanguageDto, Language> forLanguage(){
        return forLanguage;
    }
    @Override
    public IMapEntities<PlatformDto, Platform> forPlatform(){
        return forPlatform;
    }

}
