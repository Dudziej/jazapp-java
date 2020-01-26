create table basket(
	user_id BIGINT references user_entity(id),
	data    date not null,
	PRIMARY KEY (user_id)
);

create table auctions_in_basket(
    id serial primary key,
    auction_id int references auction(id) not null ON DELETE CASCADE,
    basket_id int references basket(id) not null ON DELETE CASCADE,
    count int not null,
    data date not null

);
