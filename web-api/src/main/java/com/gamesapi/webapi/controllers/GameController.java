package com.gamesapi.webapi.controllers;

import com.gamesapi.model.Game;
import com.gamesapi.repositories.ICatalogData;
import com.gamesapi.webapi.contract.GameDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/v1/games")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class GameController {
    Logger logger = LoggerFactory.getLogger(GameController.class);
    private final ICatalogData data;

    @GetMapping
    public ResponseEntity<List<GameDto>> getAllMovies(){
        logger.trace("getting all movies");
        return ResponseEntity.ok(data.getGames().findAll().stream().map(this::mapGameToDto).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<GameDto> addGame(@RequestBody GameDto gameDto){
        if(data.getGames().save(mapDtoToGame(gameDto)) == null){
            logger.error("couldn't save the game:" + gameDto.getId());
            return ResponseEntity.badRequest().body(gameDto);
        }
        logger.trace("saved the game: " + gameDto.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(gameDto);
    }

    @GetMapping("/{id}")
    @Cacheable(cacheNames = "game", key = "#id")
    public ResponseEntity<GameDto> getGame(@PathVariable int id){
        var gameOptional = data.getGames().findById(id);
        if(gameOptional.isEmpty()) {
            logger.error("couldn't find the game: " + id);
            return ResponseEntity.notFound().build();
        }
        logger.trace("accessed the game: " + id);
        return ResponseEntity.ok().body(mapGameToDto(gameOptional.get()));
    }

    @PutMapping("/{id}")
    @CachePut(cacheNames = "game", key = "#id")
    public ResponseEntity<GameDto> updateGame(@RequestBody GameDto gameDto, @PathVariable int id){
        var gameOptional = data.getGames().findById(id);
        if(gameOptional.isEmpty()){
            logger.error("couldn't find the game: " + id);
            return ResponseEntity.notFound().build();
        }
        if(data.getGames().save(mapDtoToGame(gameDto, gameOptional.get())) == null){
            logger.error("couldn't update the game: " + id);
            return ResponseEntity.badRequest().body(gameDto);
        }
        logger.trace("updated the game: " + id);
        return ResponseEntity.ok().body(gameDto);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(cacheNames = "game", key = "#id")
    public ResponseEntity<String> updateGame(@PathVariable int id){
        var gameOptional = data.getGames().findById(id);
        if(gameOptional.isEmpty()){
            logger.error("couldn't find the game: " + id);
            return ResponseEntity.notFound().build();
        }
        data.getGames().delete(gameOptional.get());
        logger.trace("deleted the game: " + id);
        return ResponseEntity.ok().body("Deleted game with id: " + id);
    }

    // Mappers

    public GameDto mapGameToDto(Game game){
        GameDto gameDto = new GameDto();
        gameDto.setId(game.getId());
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

    public Game mapDtoToGame(GameDto gameDto){
        Game game = new Game();
        return mapDtoToGame(gameDto, game);
    }

    public Game mapDtoToGame(GameDto gameDto, Game game){
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
