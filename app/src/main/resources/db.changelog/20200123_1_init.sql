create table section (
    id   serial primary key,
    name varchar not null    
);
create table photo(
	id serial primary key,
	path varchar not null,
	auction_id int references auction(id)
);

alter table auction drop column photo;