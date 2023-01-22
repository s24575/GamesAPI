package com.gamesapi;

import com.gamesapi.model.Game;
import com.gamesapi.repositories.ICatalogData;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class DatabaseApplication implements CommandLineRunner {
	private final ICatalogData db;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseApplication.class, args);
	}

	@Override
	public void run(String... args){
//		var game = new Game();
//		game.setName("test name");
//		db.getGames().save(game);
//		System.out.println("Saved successfully!");
	}
}
