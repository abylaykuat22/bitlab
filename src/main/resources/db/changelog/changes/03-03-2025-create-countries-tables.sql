-- liquibase formatted sql

-- changeset alisher:1
CREATE TABLE IF NOT EXISTS COUNTRIES
(
    ID SERIAL PRIMARY KEY,
    NAME varchar not null ,
    CODE varchar not null unique

);
