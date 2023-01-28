package com.gamesapi.games.mapping.mappers;

import com.gamesapi.contract.dictionaries.PlatformDto;
import com.gamesapi.games.mapping.IMapEntities;
import com.gamesapi.model.Platform;
import org.springframework.stereotype.Component;

@Component
public class PlatformMapper implements IMapEntities<PlatformDto, Platform> {
    @Override
    public PlatformDto mapEntity(Platform platform){
        PlatformDto platformDto = new PlatformDto();
        platformDto.setSourceId(platform.getSourceId());
        platformDto.setGeneration(platform.getGeneration());
        platformDto.setName(platform.getName());
        platformDto.setSummary(platform.getSummary());
        return platformDto;
    }

    @Override
    public Platform mapDto(PlatformDto platformDto){
        Platform platform = new Platform();
        return mapDto(platformDto, platform);
    }

    @Override
    public Platform mapDto(PlatformDto platformDto, Platform platform){
        platform.setSourceId(platformDto.getSourceId());
        platform.setGeneration(platformDto.getGeneration());
        platform.setName(platformDto.getName());
        platform.setSummary(platformDto.getSummary());
        return platform;
    }
}
