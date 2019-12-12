CREATE TABLE auction
(
    id   serial PRIMARY KEY,
    name        VARCHAR   NOT NULL,
    price       DECIMAL(2)   NOT NULL,
    description VARCHAR   NOT NULL,
    photo       VARCHAR   NOT NULL,
    parameters  VARCHAR
);