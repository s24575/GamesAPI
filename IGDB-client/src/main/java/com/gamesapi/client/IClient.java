package com.gamesapi.client;

import com.gamesapi.contract.CompanyDto;
import com.gamesapi.contract.CoverDto;
import com.gamesapi.contract.GameDto;
import com.gamesapi.contract.dictionaries.GenreDto;
import com.gamesapi.contract.dictionaries.LanguageDto;
import com.gamesapi.contract.dictionaries.PlatformDto;

import java.time.LocalDate;
import java.util.List;

public interface IClient {
    GameDto getGame(int id);
    List<GameDto> getGamesBetweenDates(LocalDate from, LocalDate to);
    CoverDto getCover(int id);
    List<CompanyDto> getCompanies(List<Integer> companyIds);
    List<GenreDto> getGenres();
    List<LanguageDto> getLanguages();
    List<PlatformDto> getPlatforms();
}
