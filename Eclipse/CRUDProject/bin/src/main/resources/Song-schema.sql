drop table if exists song CASCADE;

create table song
(
	id integer PRIMARY KEY AUTO_INCREMENT,
	song_name varchar(255),
	artist varchar(255),
	duration double
);