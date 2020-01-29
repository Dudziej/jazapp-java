create table section (
    id   serial primary key,
    name varchar not null    
    section_id int references section(id);

);
create table photo(
	id serial primary key,
	path varchar not null,
	auction_id int references auction(id)
);

alter table auction drop column photo;