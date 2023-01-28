package com.gamesapi.games.updater;

import java.time.LocalDate;

public interface IUpdateGames {
    void updateByDateRange(LocalDate from, LocalDate to);
    void updateDictionaries();
}
