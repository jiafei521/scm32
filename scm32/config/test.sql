drop database if exists mybatis;
create database scm32 CHARACTER SET UTF8;
use scm32;

create table dept(
    dept_id int primary key auto_increment,
    dept_name varchar(50),
    dept_address varchar(50)
);


insert into dept(dept_name,dept_address) values('研发部一部','广州');
insert into dept(dept_name,dept_address) values('研发部二部','广州');
insert into dept(dept_name,dept_address) values('研发部三部','深圳');
select * from dept;

select * from supplier where sup_name like '%供应商%' limit 0,2;
