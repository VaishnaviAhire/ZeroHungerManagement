create  database ngo;
show databases;
use ngo;
create table  ngologin(username varchar(25),password varchar(25));
insert into ngologin values("ngo","12345");

select * from ngologin;



create database  user;
show databases;
use user;
create table  userlogin(username varchar(25),password varchar(25));
insert into userlogin values("user","12345");
select * from userlogin;
