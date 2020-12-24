
-- Создать сущность «Товар» (id, название, стоимость) и соответствующую таблицу в БД. Заполнить таблицу тестовыми данными (20 записей).
--     Сделать RestController позволяющий выполнять следующий набор операции над этой сущностью: получение товара по id [ GET .../app/products/{id} ] получение всех товаров [ GET .../app/products ] создание нового товара [ POST .../app/products ] удаление товара по id.[ GET .../app/products/delete/{id} ] (Замечание: пока делаем немного не по правилам REST API, эта тема будет разбираться на следующих занятиях, поэтому удаление выполняется через http-метод GET, а не DELETE)
--     * К запросу всех товаров добавьте возможность фильтрации по минимальной и максимальной цене (в трех вариантах: товары дороже min цены, товары дешевле max цены, или товары, цена которых находится в пределах min-max).

--MS SQL dialect
create table product(
    id numeric(10) identity,
    title varchar(255) not null,
    price numeric(12,2) not null,
    constraint pk_product primary key(id)
);

insert into product(title, price)
values
    ('CPU AMD Ryzen 7', 17300),
    ('CPU AMD Ryzen 5', 12400),
    ('CPU Intel Celeron', 17300),
    ('CPU Intel Core i3', 24900),
    ('CPU Intel Core i5', 31200),
    ('CPU Intel XEON 4 ядра', 38100),
    ('CPU Intel XEON 6 ядер', 42100),
    ('CPU Intel XEON 12 ядер', 75600),
    ('Motherboard Asus AMD', 5900),
    ('Motherboard Gigabyte AMD', 8300),
    ('Motherboard Asus Intel', 6300),
    ('Motherboard Noname Intel XEON', 7200),
    ('RAM DDR3 4*2 GB', 4300),
    ('RAM DDR3 8*2 GB', 9200),
    ('RAM DDR4 8*2 GB', 12100),
    ('RAM DDR4 16*2 GB', 17300),
    ('Palit RTX 3060', 57200),
    ('MSI RTX 3060ti', 63600),
    ('Gigabyte RTX 3070', 65200),
    ('Gigabyte RTX 3080', 102000);



