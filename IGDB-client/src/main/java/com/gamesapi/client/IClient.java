package com.gamesapi.client;

import com.gamesapi.contract.GameDto;

public interface IClient {
    GameDto getGame(int id);
}
