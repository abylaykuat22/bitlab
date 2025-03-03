-- liquibase formatted sql

-- changeset aslancho:1
CREATE TABLE IF NOT EXISTS STATUSES
(
    ID SERIAL PRIMARY KEY,
    NAME varchar not null unique,
    DESCRIPTION varchar
);