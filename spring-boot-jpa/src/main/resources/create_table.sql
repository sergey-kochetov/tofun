DROP TABLE IF EXISTS jpa.person;
DROP TABLE IF EXISTS jpa.passport;

CREATE TABLE jpa.person(
	id bigint primary key,
	first_name varchar(255) not null,
	last_name varchar(255) not null,
	address varchar(255) not null,
	passport_id bigint not null
);

CREATE TABLE jpa.passport(
	id bigint primary key,
	person_id bigint not null,
	number varchar(255) not null
);

ALTER TABLE ONLY jpa.person
    ADD CONSTRAINT person_fk FOREIGN KEY (passport_id) REFERENCES jpa.passport(id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY jpa.passport
    ADD CONSTRAINT passport_fk FOREIGN KEY (person_id) REFERENCES jpa.person(id) ON UPDATE CASCADE ON DELETE CASCADE;
