create table company(id integer not null auto_increment, source_id integer not null, country integer, description TEXT, name varchar(255), url varchar(255), primary key(id));
create table cover(id integer not null auto_increment, source_id integer not null, height integer, width integer, image_id varchar(255), url varchar(255), game_id integer not null, primary key(id));
create table game(id integer not null auto_increment, source_id integer not null, aggregated_rating double, aggregated_rating_count integer, first_release_date long, name varchar(255), rating double, rating_count integer, storyline TEXT, summary TEXT, cover_id integer, primary key (id));
create table genre(id integer not null auto_increment, source_id integer not null, name varchar(255), primary key(id));
create table language(id integer not null auto_increment, source_id integer not null, name varchar(255), native_name varchar(255), primary key(id));
create table platform(id integer not null auto_increment, source_id integer not null, generation integer, name varchar(255), summary TEXT, primary key(id));

create table game_company(game_id integer not null, company_id integer not null);
create table game_genre(game_id integer not null, genre_id integer not null);
create table game_language(game_id integer not null, languaglanguagee_id integer not null);
create table game_platform(game_id integer not null, platform_id integer not null);
create table game_game(game_id integer not null, game_id2 integer not null);

ALTER TABLE game_company ADD FOREIGN KEY (game_id) REFERENCES game(id);
ALTER TABLE game_company ADD FOREIGN KEY (company_id) REFERENCES company(id);
ALTER TABLE game_genre ADD FOREIGN KEY (game_id) REFERENCES game(id);
ALTER TABLE game_genre ADD FOREIGN KEY (genre_id) REFERENCES genre(id);
ALTER TABLE game_language ADD FOREIGN KEY (game_id) REFERENCES game(id);
ALTER TABLE game_language ADD FOREIGN KEY (language_id) REFERENCES language(id);
ALTER TABLE game_platform ADD FOREIGN KEY (game_id) REFERENCES game(id);
ALTER TABLE game_platform ADD FOREIGN KEY (platform_id) REFERENCES platform(id);
ALTER TABLE game_game ADD FOREIGN KEY (game_id) REFERENCES game(id);
ALTER TABLE game_game ADD FOREIGN KEY (game_id2) REFERENCES game(id);
ALTER TABLE cover ADD FOREIGN KEY (game_id) REFERENCES game(id);
ALTER TABLE game ADD FOREIGN KEY (cover_id) REFERENCES cover(id);