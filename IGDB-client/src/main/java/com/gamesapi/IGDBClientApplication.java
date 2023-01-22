package com.gamesapi;

import com.gamesapi.client.IClient;
import com.gamesapi.contract.GameDto;
import com.gamesapi.model.Game;
import com.gamesapi.repositories.ICatalogData;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class IGDBClientApplication implements CommandLineRunner {
	private final IClient client;

	private final ICatalogData database;

	public static void main(String[] args) {
		SpringApplication.run(IGDBClientApplication.class, args);
	}

	@Override
	public void run(String... args){
//		GameDto gameDto = client.getGame(1942);
//		Game game = new Game();
//		game.setName(gameDto.getName());
//		database.getGames().save(game);
	}

}
