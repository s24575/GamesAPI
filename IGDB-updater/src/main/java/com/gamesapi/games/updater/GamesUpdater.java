package com.gamesapi.games.updater;

import com.gamesapi.client.IClient;
import com.gamesapi.games.mapping.ICatalogMappers;
import com.gamesapi.model.Game;
import com.gamesapi.model.Genre;
import com.gamesapi.model.Language;
import com.gamesapi.model.Platform;
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
        System.out.println("updated dictionaries");
        var gameDtos = client.getGamesBetweenDates(from, to);

        List<Game> games = new ArrayList<>();
        for(var gameDto : gameDtos){
            var gameOptional = data.getGames().findBySourceId(gameDto.getSourceId());
            if(gameOptional.isPresent()){
                games.add(entityMapper.forGame().mapDto(gameDto, gameOptional.get()));
            } else {
                games.add(entityMapper.forGame().mapDto(gameDto));
            }

            Game game = games.get(games.size() - 1);

            // Update game genres
            List<Genre> genres = new ArrayList<>();
            for(var genreId : gameDto.getGenres()){
                var genre = data.getGenres().findBySourceId(genreId).get();
                genre.getGames().add(game);
                genres.add(genre);
            }
            game.setGenres(genres);

            // Update game languages
            List<Language> languages = new ArrayList<>();
            for(var languageId : gameDto.getLanguages()){
                var language = data.getLanguages().findBySourceId(languageId).get();
                language.getGames().add(game);
                languages.add(language);
            }
            game.setLanguages(languages);

            // Update

            // This updating doesn't make sense, I should get list from game and update it, so I don't just ignore all those existing entities.
        }
        data.getGames().saveAll(games);
    }

    @Override
    public void updateDictionaries(){
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
