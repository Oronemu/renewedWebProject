create table users (
	id serial primary key,
	username varchar(50) not null unique,
	password varchar(100) not null
)

create table posts (
	id serial primary key,
	title varchar(200) not null,
	author varchar(50) not null,
	text varchar not null,
	date date not null
)