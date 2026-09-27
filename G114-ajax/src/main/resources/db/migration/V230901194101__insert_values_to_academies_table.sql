INSERT INTO CITIES(NAME, CODE)
VALUES ('ALMATY', 'ALM'),
       ('ASTANA', 'AST'),
       ('KARAGANDA', 'KRG');

INSERT INTO ACADEMIES(NAME, COURSE, RATING, ADDRESS, city_id)
VALUES ('BITLAB ACADEMY', 'JAVA', '9.0', 'Aimanova 126', 1),
       ('ATTRACTOR', 'PYTHON', '9.0', 'Unknown', 1),
       ('METACODING', 'C#', '9.0', 'unknown', 2),
       ('ALABS ACADEMY', 'SWIFT', '9.0', 'unknown', 3)