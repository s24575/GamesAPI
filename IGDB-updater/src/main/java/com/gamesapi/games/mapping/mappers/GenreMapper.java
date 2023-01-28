package com.gamesapi.games.mapping.mappers;

import com.gamesapi.contract.dictionaries.GenreDto;
import com.gamesapi.games.mapping.IMapEntities;
import com.gamesapi.model.Genre;
import org.springframework.stereotype.Component;

@Component
public class GenreMapper implements IMapEntities<GenreDto, Genre> {
    @Override
    public GenreDto mapEntity(Genre genre){
        GenreDto genreDto = new GenreDto();
        genreDto.setSourceId(genre.getSourceId());
        genreDto.setName(genre.getName());
        return genreDto;
    }

    @Override
    public Genre mapDto(GenreDto genreDto){
        Genre genre = new Genre();
        return mapDto(genreDto, genre);
    }

    @Override
    public Genre mapDto(GenreDto genreDto, Genre genre){
        genre.setSourceId(genreDto.getSourceId());
        genre.setName(genreDto.getName());
        return genre;
    }
}
