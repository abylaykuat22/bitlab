-- liquibase formatted sql

--changeset d.dzhaksylyk:1
CREATE TABLE IF NOT EXISTS students
(
    ID BIGSERIAL PRIMARY KEY ,
    NAME VARCHAR NOT NULL ,
    EMAIL VARCHAR NOT NULL UNIQUE ,
    PASSWORD VARCHAR NOT NULL ,
    AGE INT,
    EXAM INT,
    MARK VARCHAR(2)
);

--changeset d.jax:2
ALTER TABLE IF EXISTS students
DROP AGE;