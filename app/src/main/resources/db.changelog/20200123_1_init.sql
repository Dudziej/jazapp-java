create table section (
    id   serial primary key,
    name varchar not null UNIQUE

);
create table photo(
	id serial primary key,
	path varchar not null,
	auction_id int references auction(id)
);

alter table auction drop column photo;

alter table category add column section_id int not null references section(id);