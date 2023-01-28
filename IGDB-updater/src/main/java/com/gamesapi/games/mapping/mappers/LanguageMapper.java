package com.gamesapi.games.mapping.mappers;

import com.gamesapi.contract.dictionaries.LanguageDto;
import com.gamesapi.games.mapping.IMapEntities;
import com.gamesapi.model.Language;
import org.springframework.stereotype.Component;

@Component
public class LanguageMapper implements IMapEntities<LanguageDto, Language> {
    @Override
    public LanguageDto mapEntity(Language language){
        LanguageDto languageDto = new LanguageDto();
        languageDto.setSourceId(language.getSourceId());
        languageDto.setName(language.getName());
        languageDto.setNativeName(language.getNativeName());
        return languageDto;
    }

    @Override
    public Language mapDto(LanguageDto languageDto){
        Language language = new Language();
        return mapDto(languageDto, language);
    }

    @Override
    public Language mapDto(LanguageDto languageDto, Language language){
        language.setSourceId(languageDto.getSourceId());
        language.setName(languageDto.getName());
        language.setNativeName(languageDto.getNativeName());
        return language;
    }
}