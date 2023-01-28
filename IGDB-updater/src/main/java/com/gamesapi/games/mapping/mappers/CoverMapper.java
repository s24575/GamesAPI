package com.gamesapi.games.mapping.mappers;

import com.gamesapi.contract.CoverDto;
import com.gamesapi.games.mapping.IMapEntities;
import com.gamesapi.model.Cover;
import org.springframework.stereotype.Component;

@Component
public class CoverMapper implements IMapEntities<CoverDto, Cover> {
    @Override
    public CoverDto mapEntity(Cover cover){
        CoverDto coverDto = new CoverDto();
        coverDto.setSourceId(cover.getSourceId());
        coverDto.setHeight(cover.getHeight());
        coverDto.setImageId(cover.getImageId());
        coverDto.setUrl(cover.getUrl());
        coverDto.setWidth(cover.getWidth());
        return coverDto;
    }

    @Override
    public Cover mapDto(CoverDto coverDto){
        Cover cover = new Cover();
        return mapDto(coverDto, cover);
    }
    @Override
    public Cover mapDto(CoverDto coverDto, Cover cover){
        cover.setSourceId(coverDto.getSourceId());
        cover.setHeight(coverDto.getHeight());
        cover.setImageId(coverDto.getImageId());
        cover.setUrl(coverDto.getUrl());
        cover.setWidth(coverDto.getWidth());
        return cover;
    }
}
