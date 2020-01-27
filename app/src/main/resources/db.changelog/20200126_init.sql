create table basket(
	id serial primary key,
	user_id BIGINT references user_entity(id),
	data    date not null
);

create table auctions_in_basket(
    id serial primary key,
    auction_id int references auction(id) not null,
    basket_id int references basket(id) not null,
    count int not null,
    data date not null

);
