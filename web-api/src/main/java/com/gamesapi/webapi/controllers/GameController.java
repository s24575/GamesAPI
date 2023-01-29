package com.gamesapi.webapi.controllers;

import com.gamesapi.model.Game;
import com.gamesapi.repositories.ICatalogData;
import com.gamesapi.webapi.contract.GameDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/v1/games")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class GameController {
    private final ICatalogData data;

    @PostMapping
    public ResponseEntity<GameDto> addGame(@RequestBody GameDto gameDto){
        Game game = new Game();
        game.setSourceId(gameDto.getSourceId());
        game.setAggregatedRating(gameDto.getAggregatedRating());
        game.setAggregatedRatingCount(gameDto.getAggregatedRatingCount());
        game.setFirstReleaseDate(gameDto.getFirstReleaseDate());
        game.setName(gameDto.getName());
        game.setRating(gameDto.getRating());
        game.setRatingCount(gameDto.getRatingCount());
        game.setStoryline(gameDto.getStoryline());
        game.setSummary(gameDto.getSummary());
        data.getGames().save(game);
        return ResponseEntity.ok(gameDto);
    }

    @GetMapping
    public ResponseEntity<List<GameDto>> getAllMovies(){
        var games = data.getGames().findAll();

        List<GameDto> gameDtos = new ArrayList<>();
        for(var game : games){
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
            gameDtos.add(gameDto);
        }

        return ResponseEntity.ok(gameDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameDto> getGame(@PathVariable int id){
        var gameOptional = data.getGames().findById(id);
        if(gameOptional.isEmpty()) return ResponseEntity.notFound().build();
        Game game = gameOptional.get();
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
        return ResponseEntity.ok().body(gameDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GameDto> updateGame(@RequestBody GameDto gameDto, @PathVariable int id){
        var gameOptional = data.getGames().findById(id);
        if(gameOptional.isEmpty()) return ResponseEntity.notFound().build();
        Game game = gameOptional.get();
        game.setSourceId(gameDto.getSourceId());
        game.setAggregatedRating(gameDto.getAggregatedRating());
        game.setAggregatedRatingCount(gameDto.getAggregatedRatingCount());
        game.setFirstReleaseDate(gameDto.getFirstReleaseDate());
        game.setName(gameDto.getName());
        game.setRating(gameDto.getRating());
        game.setRatingCount(gameDto.getRatingCount());
        game.setStoryline(gameDto.getStoryline());
        game.setSummary(gameDto.getSummary());
        data.getGames().save(game);
        return ResponseEntity.ok().body(gameDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> updateGame(@PathVariable int id){
        var gameOptional = data.getGames().findById(id);
        if(gameOptional.isEmpty()) return ResponseEntity.notFound().build();
        data.getGames().delete(gameOptional.get());
        return ResponseEntity.ok().body("Deleted game with id: " + id);
    }
}
