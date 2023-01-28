package com.gamesapi;

import com.gamesapi.games.updater.IUpdateGames;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
@AllArgsConstructor
public class IGDBUpdaterApplication implements CommandLineRunner {
	private IUpdateGames gamesUpdater;

	public static void main(String[] args) {
		SpringApplication.run(IGDBUpdaterApplication.class, args);
	}

	@Override
	public void run(String... args){
		gamesUpdater.updateByDateRange(LocalDate.now().minusMonths(1), LocalDate.now());
	}

}
