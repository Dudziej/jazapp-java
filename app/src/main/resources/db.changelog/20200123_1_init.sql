create table section (
    name varchar not null,
    id   serial primary key
);
create table photo(
id serial primary key,
path varchar not null,
auction_id int references auction(id)
);
alter table auction drop column photo;