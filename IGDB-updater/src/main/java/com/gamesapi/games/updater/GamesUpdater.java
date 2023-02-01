package com.gamesapi.games.updater;

import com.gamesapi.client.IClient;
import com.gamesapi.contract.CompanyDto;
import com.gamesapi.contract.LanguageSupportDto;
import com.gamesapi.games.mapping.ICatalogMappers;
import com.gamesapi.model.*;
import com.gamesapi.repositories.ICatalogData;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class GamesUpdater implements IUpdateGames {
    private final ICatalogData data;
    private final IClient client;
    private final ICatalogMappers entityMapper;

    @Override
    public void updateByDateRange(LocalDate from, LocalDate to) {
        updateDictionaries();
        var gameDtos = client.getGamesBetweenDates(from, to);
        System.out.println("updating games...");

        for(var gameDto : gameDtos){
            var gameOptional = data.getGames().findBySourceId(gameDto.getSourceId());
            if(gameOptional.isPresent()){
                // This portion should update existing game entities in a database.
                // I might skip it to avoid complexity and to not slow things down.
            } else {
                Game game = entityMapper.forGame().mapDto(gameDto);

                // Add cover
                if(gameDto.getCover() != null){
                    Cover cover = entityMapper.forCover().mapDto(client.getCover(gameDto.getCover()));
                    game.setCover(cover);
                    cover.setGame(game);
                }

                // Add company
                if(gameDto.getCompanies() != null){
                    List<CompanyDto> companyDtos = client.getInvolvedCompanies(gameDto.getCompanies());
                    List<Company> companies = new ArrayList<>();
                    for(CompanyDto companyDto : companyDtos){
                        var companyOptional = data.getCompanies().findBySourceId(companyDto.getSourceId());
                        if(companyOptional.isPresent()){
                            companies.add(companyOptional.get());
                        } else{
                            Company company = entityMapper.forCompany().mapDto(companyDto);
                            companies.add(company);
                        }
                    }
                    game.setCompanies(companies);
                }

                // Add genres
                if(gameDto.getGenres() != null) {
                    List<Genre> genres = new ArrayList<>();
                    for (var genreId : gameDto.getGenres()) {
                        Genre genre = data.getGenres().findBySourceId(genreId).get();
                        genres.add(genre);
                    }
                    game.setGenres(genres);
                }

                // Add languages
                if(gameDto.getLanguages() != null) {
                    List<LanguageSupportDto> languageSupportDtos = client.getLanguageSupport(gameDto.getLanguages());
                    List<Language> languages = new ArrayList<>();
                    for (var languageSupportDto : languageSupportDtos) {
                        var language = data.getLanguages().findBySourceId(languageSupportDto.getLanguageId()).get();
                        languages.add(language);
                    }
                    game.setLanguages(languages);
                }

                // Add platforms
                if(gameDto.getPlatforms() != null) {
                    List<Platform> platforms = new ArrayList<>();
                    for (var platformId : gameDto.getPlatforms()) {
                        var platform = data.getPlatforms().findBySourceId(platformId).get();
                        platforms.add(platform);
                    }
                    game.setPlatforms(platforms);
                }

                data.getGames().save(game);
            }
        }
    }

    @Override
    public void updateDictionaries(){
        System.out.println("updating dictionaries...");

        var genreDtos = client.getGenres();
        var languageDtos = client.getLanguages();
        var platformDtos = client.getPlatforms();

        List<Genre> genres = new ArrayList<>();
        for(var genreDto : genreDtos){
            var genreOptional = data.getGenres().findBySourceId(genreDto.getSourceId());
            if(genreOptional.isPresent()){
                genres.add(entityMapper.forGenre().mapDto(genreDto, genreOptional.get()));
            } else {
                genres.add(entityMapper.forGenre().mapDto(genreDto));
            }
        }
        data.getGenres().saveAll(genres);

        List<Language> languages = new ArrayList<>();
        for(var languageDto : languageDtos){
            var languageOptional = data.getLanguages().findBySourceId(languageDto.getSourceId());
            if(languageOptional.isPresent()){
                languages.add(entityMapper.forLanguage().mapDto(languageDto, languageOptional.get()));
            } else {
                languages.add(entityMapper.forLanguage().mapDto(languageDto));
            }
        }
        data.getLanguages().saveAll(languages);

        List<Platform> platforms = new ArrayList<>();
        for(var platformDto : platformDtos){
            var platformOptional = data.getPlatforms().findBySourceId(platformDto.getSourceId());
            if(platformOptional.isPresent()){
                platforms.add(entityMapper.forPlatform().mapDto(platformDto, platformOptional.get()));
            } else {
                platforms.add(entityMapper.forPlatform().mapDto(platformDto));
            }
        }
        data.getPlatforms().saveAll(platforms);
    }
}
