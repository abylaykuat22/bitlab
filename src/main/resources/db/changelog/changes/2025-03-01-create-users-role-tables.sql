
--liquibase sanzhar: 1
create table if not exists ROLES
(
    ID bigserial primary key,
    NAME varchar not null
);

--liquibase sanzhar: 2
create table if not exists USERS
(
    ID bigserial primary key,
    USERNAME varchar not null ,
    EMAIL varchar,
    PASSWORD_HASH varchar,
    CREATE_AT date,
    UPDATE_AT date

);

--liquibase sanzhar: 3
create table if not exists USER_ROLES
(

    USERS_ID int not null,
    ROLES_ID int not null,
    primary key (USERS_ID,ROLES_ID),
    foreign key (USERS_ID) references USERS(id) on delete cascade,
    foreign key (ROLES_ID) references ROLES(ID) on delete cascade

);