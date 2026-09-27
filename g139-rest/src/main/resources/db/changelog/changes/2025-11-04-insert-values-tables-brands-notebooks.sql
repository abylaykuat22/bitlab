-- liquibase formatted sql

-- changeset mukhammed:1
INSERT INTO brands(NAME)
VALUES ('APPLE'),
       ('ASUS'),
       ('LENOVO'),
       ('HP'),
       ('THUNDEROBOT');

-- changeset mukhammed:2
INSERT INTO notebooks (name, price, memory, ram, os, brand_id)
VALUES
-- APPLE
('MacBook Air M1', 499000, '256GB SSD', '8GB', 'macOS', 1),
('MacBook Pro 14', 899000, '512GB SSD', '16GB', 'macOS', 1),
('MacBook Air M2', 599000, '512GB SSD', '8GB', 'macOS', 1),
('MacBook Pro 16', 1099000, '1TB SSD', '32GB', 'macOS', 1),
('MacBook Air 13', 479000, '256GB SSD', '8GB', 'macOS', 1),
('MacBook Pro 13', 689000, '512GB SSD', '16GB', 'macOS', 1),
('MacBook Air M3', 639000, '512GB SSD', '8GB', 'macOS', 1),
('MacBook Pro 15', 759000, '1TB SSD', '16GB', 'macOS', 1),
('MacBook Air Retina', 429000, '128GB SSD', '8GB', 'macOS', 1),
('MacBook Air M1 Silver', 505000, '256GB SSD', '8GB', 'macOS', 1),

-- ASUS
('Asus ZenBook 14', 429000, '512GB SSD', '16GB', 'Windows 11', 2),
('Asus ROG Strix G15', 579000, '1TB SSD', '16GB', 'Windows 11', 2),
('Asus TUF Gaming F15', 499000, '512GB SSD', '16GB', 'Windows 11', 2),
('Asus VivoBook 15', 359000, '256GB SSD', '8GB', 'Windows 11', 2),
('Asus ExpertBook B5', 439000, '512GB SSD', '16GB', 'Windows 11', 2),
('Asus ROG Zephyrus G14', 679000, '1TB SSD', '32GB', 'Windows 11', 2),
('Asus TUF Dash F15', 549000, '512GB SSD', '16GB', 'Windows 11', 2),
('Asus ZenBook Duo', 789000, '1TB SSD', '16GB', 'Windows 11', 2),
('Asus Chromebook Flip', 299000, '128GB SSD', '8GB', 'ChromeOS', 2),
('Asus ROG Flow X13', 859000, '1TB SSD', '32GB', 'Windows 11', 2),

-- LENOVO
('Lenovo IdeaPad 3', 329000, '256GB SSD', '8GB', 'Windows 11', 3),
('Lenovo Legion 5', 589000, '1TB SSD', '16GB', 'Windows 11', 3),
('Lenovo ThinkPad X1', 799000, '1TB SSD', '16GB', 'Windows 11', 3),
('Lenovo Yoga Slim 7', 449000, '512GB SSD', '16GB', 'Windows 11', 3),
('Lenovo IdeaPad Gaming 3', 459000, '512GB SSD', '16GB', 'Windows 11', 3),
('Lenovo Legion 7', 899000, '1TB SSD', '32GB', 'Windows 11', 3),
('Lenovo ThinkBook 14', 379000, '512GB SSD', '8GB', 'Windows 11', 3),
('Lenovo Yoga 9', 679000, '1TB SSD', '16GB', 'Windows 11', 3),
('Lenovo IdeaPad 5', 369000, '256GB SSD', '8GB', 'Windows 11', 3),
('Lenovo ThinkPad L14', 429000, '512GB SSD', '8GB', 'Windows 11', 3),

-- HP
('HP Pavilion 14', 349000, '256GB SSD', '8GB', 'Windows 11', 4),
('HP Envy 15', 579000, '512GB SSD', '16GB', 'Windows 11', 4),
('HP Victus 16', 489000, '512GB SSD', '16GB', 'Windows 11', 4),
('HP Spectre x360', 749000, '1TB SSD', '16GB', 'Windows 11', 4),
('HP Omen 17', 859000, '1TB SSD', '32GB', 'Windows 11', 4),
('HP 250 G8', 289000, '256GB SSD', '8GB', 'Windows 11', 4),
('HP EliteBook 840', 499000, '512GB SSD', '16GB', 'Windows 11', 4),
('HP Chromebook 14', 219000, '128GB SSD', '8GB', 'ChromeOS', 4),
('HP ProBook 450', 409000, '512GB SSD', '8GB', 'Windows 11', 4),
('HP Envy x360', 599000, '512GB SSD', '16GB', 'Windows 11', 4),

-- THUNDEROBOT
('Thunderobot 911 Air', 489000, '512GB SSD', '16GB', 'Windows 11', 5),
('Thunderobot 911 X', 539000, '1TB SSD', '16GB', 'Windows 11', 5),
('Thunderobot Zero', 629000, '1TB SSD', '32GB', 'Windows 11', 5),
('Thunderobot 911 Plus', 569000, '512GB SSD', '16GB', 'Windows 11', 5),
('Thunderobot 911 Air D', 509000, '512GB SSD', '16GB', 'Windows 11', 5),
('Thunderobot ST Plus', 599000, '1TB SSD', '16GB', 'Windows 11', 5),
('Thunderobot Zero Pro', 689000, '1TB SSD', '32GB', 'Windows 11', 5),
('Thunderobot 911 Targa', 479000, '512GB SSD', '16GB', 'Windows 11', 5),
('Thunderobot 911 GT', 539000, '1TB SSD', '16GB', 'Windows 11', 5),
('Thunderobot 911 SE', 459000, '512GB SSD', '8GB', 'Windows 11', 5);