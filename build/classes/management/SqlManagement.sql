show databases;
use management;
show tables from management;

select * from hotel;
select * from items;
select * from login;
select * from people;
select * from quantity;
DROP TABLE qnt;

DELETE FROM quantity
WHERE Hotelid = '15331915';

SET SQL_SAFE_UPDATES = 0;

