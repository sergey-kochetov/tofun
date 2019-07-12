DROP TABLE IF EXISTS jpa.person;

CREATE TABLE jpa.person(
	id bigint primary key,
	first_name varchar(255) not null,
	last_name varchar(255) not null,
	address varchar(255) not null
);