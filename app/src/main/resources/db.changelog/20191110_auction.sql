CREATE SEQUENCE hibernate_sequence;

CREATE TABLE parameter
(
    id          serial       PRIMARY KEY,
    name        VARCHAR      NOT NULL
);

CREATE TABLE category
(    id          serial       PRIMARY KEY,
    name        VARCHAR      NOT NULL
);

CREATE TABLE auction
(
    id          serial          PRIMARY KEY,
    name        VARCHAR         NOT NULL,
    price       DECIMAL(14,2)   NOT NULL,
    description VARCHAR         NOT NULL,
    photo       VARCHAR         NOT NULL,
    creator_id  BIGSERIAL    NOT NULL,
    category_id    serial          NOT NULL
);

CREATE TABLE auction_param
(
    auction_id      serial  NOT NULL,
    parameter_id    serial  NOT NULL,
    PRIMARY KEY(auction_id, parameter_id)
);

CREATE TABLE user_entity
(
  id           BIGSERIAL    PRIMARY KEY,
  firstName    VARCHAR      NOT NULL,
  lastName     VARCHAR      NOT NULL,
  username     VARCHAR      NOT NULL,
  password     VARCHAR      NOT NULL,
  email        VARCHAR      NOT NULL,
  birthDate    DATE         NOT NULL,
  admin        BOOLEAN      NOT NULL
);


