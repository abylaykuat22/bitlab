-- liquibase formatted sql

-- changeset kuat:1
create schema if not exists g145market;

-- -- changeset kuat:2
-- create type g145market.item_status as enum (
--     'AVAILABLE',
--     'NOT_AVAILABLE',
--     'WAITING'
-- );

-- changeset kuat:3
create table if not exists g145market.items
(
    id      bigserial primary key,
    name_kz varchar(100)     not null,
    name_en varchar(100)     not null,
    name_ru varchar(100)     not null,
    price   double precision not null,
    amount  int,
    status varchar check ( status in ('AVAILABLE', 'NOT_AVAILABLE', 'WAITING') ),
--     status  g145market.item_status not null,
    made_in varchar not null,
    created_at timestamp default now(),
    updated_at timestamp
)