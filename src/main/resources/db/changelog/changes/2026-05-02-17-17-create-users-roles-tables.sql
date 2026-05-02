-- liquibase formatted sql

-- changeset kuat:1
create table if not exists g145market.roles
(
    id          bigserial primary key,
    name        varchar(100) not null unique,
    description text,
    created_at  timestamp default now(),
    updated_At  timestamp
);

create table if not exists g145market.users
(
    id         bigserial primary key,
    full_name  varchar not null,
    email      varchar not null unique,
    password   varchar not null,
    birthdate  date,
    created_at timestamp default now(),
    updated_at timestamp
);

create table if not exists g145market.user_roles
(
    user_id bigint not null,
    role_id bigint not null,
    foreign key (user_id) references g145market.users (id),
    foreign key (role_id) references g145market.roles (id)
);

insert into g145market.roles (name, description)
values ('ROLE_ADMIN', null),
       ('ROLE_USER', null),
       ('ROLE_MANAGER', null)

-- changeset kuat:2
;alter table g145market.users
    add column phone_number varchar(20) not null unique default '0';

alter table g145market.users
    add column address varchar;