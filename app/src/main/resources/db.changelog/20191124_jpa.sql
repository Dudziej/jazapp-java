CREATE TABLE card_holder
(
    id         BIGINT  NOT NULL,
    first_name VARCHAR NOT NULL,
    last_name  VARCHAR NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE card
(
    number         BIGINT  NOT NULL,
    card_type      VARCHAR NOT NULL,
    card_holder_id BIGINT  NOT NULL,

    PRIMARY KEY (number),
    FOREIGN KEY(card_holder_id) REFERENCES card_holder(id)
);

CREATE TABLE card_access
(
    card_number BIGINT  NOT NULL,
    door_id     VARCHAR NOT NULL,
    start_hour  INTEGER NOT NULL,
    end_hour    INTEGER NOT NULL,

    PRIMARY KEY (card_number, door_id)
);

CREATE TABLE door
(
    id    BIGINT  NOT NULL,
    name  VARCHAR NOT NULL,
    floor INTEGER NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE already_run_sample
(
    name VARCHAR NOT NULL PRIMARY KEY
);