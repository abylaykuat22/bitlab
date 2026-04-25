-- liquibase formatted sql

-- changeset kuat:1
create table if not exists g145market.categories
(
    id         bigserial primary key,
    name_kz    varchar(100)     not null,
    name_en    varchar(100)     not null,
    name_ru    varchar(100)     not null,
    price      double precision not null,
    code       varchar(30)      not null unique,
    created_at timestamp default now(),
    updated_at timestamp
)

-- changeset kuat:2
;alter table g145market.items
    add column category_id bigint
        constraint fk_category_id
            references g145market.categories (id);

-- changeset kuat:3
alter table g145market.categories
drop column price;

-- changeset kuat:4
INSERT INTO g145market.categories (name_kz, name_en, name_ru, code)
VALUES
    ('Электроника', 'Electronics', 'Электроника', 'electronics'),
    ('Тұрмыстық техника', 'Home Appliances', 'Бытовая техника', 'home-appliances'),
    ('Смартфондар', 'Smartphones', 'Смартфоны', 'smartphones'),
    ('Ноутбуктер және компьютерлер', 'Laptops & PCs', 'Ноутбуки и компьютеры', 'laptops-and-pcs'),
    ('Киім', 'Clothing', 'Одежда', 'clothing'),
    ('Аяқ киім', 'Shoes', 'Обувь', 'shoes'),
    ('Үйге арналған тауарлар', 'Home Goods', 'Товары для дома', 'home-goods'),
    ('Балалар тауарлары', 'Baby Products', 'Детские товары', 'baby-products'),
    ('Спорт және демалыс', 'Sport & Outdoors', 'Спорт и отдых', 'sport-and-outdoors'),
    ('Автотауарлар', 'Auto Parts', 'Автотовары', 'auto-parts');