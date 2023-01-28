package com.gamesapi.games.mapping.mappers;

import com.gamesapi.contract.GameDto;
import com.gamesapi.games.mapping.IMapEntities;
import com.gamesapi.model.Game;
import org.springframework.stereotype.Component;

@Component
public class GameMapper implements IMapEntities<GameDto, Game> {
    @Override
    public GameDto mapEntity(Game game){
        GameDto gameDto = new GameDto();
        gameDto.setSourceId(game.getSourceId());
        gameDto.setAggregatedRating(game.getAggregatedRating());
        gameDto.setAggregatedRatingCount(game.getAggregatedRatingCount());
        gameDto.setFirstReleaseDate(game.getFirstReleaseDate());
        gameDto.setName(game.getName());
        gameDto.setRating(game.getRating());
        gameDto.setRatingCount(game.getRatingCount());
        gameDto.setStoryline(game.getStoryline());
        gameDto.setSummary(game.getSummary());
        return gameDto;
    }

    @Override
    public Game mapDto(GameDto gameDto){
        Game game = new Game();
        return mapDto(gameDto, game);
    }

    @Override
    public Game mapDto(GameDto gameDto, Game game){
        game.setSourceId(gameDto.getSourceId());
        game.setAggregatedRating(gameDto.getAggregatedRating());
        game.setAggregatedRatingCount(gameDto.getAggregatedRatingCount());
        game.setFirstReleaseDate(gameDto.getFirstReleaseDate());
        game.setName(gameDto.getName());
        game.setRating(gameDto.getRating());
        game.setRatingCount(gameDto.getRatingCount());
        game.setStoryline(gameDto.getStoryline());
        game.setSummary(gameDto.getSummary());
        return game;
    }
}
