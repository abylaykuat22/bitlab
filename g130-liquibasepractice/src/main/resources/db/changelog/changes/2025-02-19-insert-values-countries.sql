-- liquibase formatted sql

-- changeset alisher:1
INSERT INTO countries(name, code)
VALUES ('Kazakhstan', 'KAZ'),
       ('United States of America', 'USA'),
       ('Italy', 'ITL'),
       ('France', 'FRC'),
       ('Germany', 'GRM');