package com.gamesapi.games.mapping;

public interface IMapEntities <TDto, TEntity>{
    TDto mapEntity(TEntity entity);
    TEntity mapDto(TDto dto);
    TEntity mapDto(TDto dto, TEntity entity);
}
