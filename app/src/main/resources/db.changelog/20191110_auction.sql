CREATE TABLE parameter
(
    id   serial PRIMARY KEY,
    name        VARCHAR      NOT NULL
);

CREATE TABLE auction
(
    id          serial       PRIMARY KEY,
    name        VARCHAR      NOT NULL,
    price       DECIMAL(2)   NOT NULL,
    description VARCHAR      NOT NULL,
    photo       VARCHAR      NOT NULL
);

CREATE TABLE auction_param
(
    auction_id      serial  NOT NULL,
    parameter_id    serial  NOT NULL,
    PRIMARY KEY(auction_id, parameter_id)
);