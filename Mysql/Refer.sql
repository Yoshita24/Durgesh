show databases;
create database jb2404;
use jb2404;

create table users(
user_id int primary key,
name varchar(100),
cit varchar(100) not null,
salary int 
);
desc users;


insert into users(user_id,name,cit,salary)
values(1101,'Vivek','Delhi',50000);
insert into users(user_id,name,cit,salary)
values(1102,'Ankit','Kanpur',50000);
insert into users(user_id,name,cit,salary)
values(1103,'Yash','Mumbai',60000);
insert into users
values(1104,'Deven','Mumbai',70000);
select * from users;
select * from users where salary=50000;
select * from Users where cit IN ('Delhi','Mumbai');

select * from Users where salary between 10000 and 60000;

select * from users where name like '%k';
select * from users where cit like '_u%';
select * from users order by name desc;
select * from users limit 3;
select * from users limit 3 offset 2;

update users set cit='Delhi',salary=587545 where user_id=1102;

delete from users where user_id=1104;

start transaction;
select * from users;
savepoint savepoint1;
delete from users where user_id = 1102;
rollback to savepoint savepoint1;
commit; -- here savepoint would be released (means data would be saved to db)
release savepoint savepoint1;
select name as USER_NAME from users; -- alias
select * from users as u where u.user_id=1101;

create table address(
	address_id int primary key,
    street varchar(100),
    zip_code int,
    country varchar(50) NOT NULL,
    UID int,
    FOREIGN KEY (UID) REFERENCES USERS(USER_ID)
    
);

insert into address values (101,'abc mall',22387,"India",1101);
insert into address values (102,'indira nagar',22387,"India",1101);
insert into address values (103,'Gandhi nagar',22387,"India",1102);
insert into address values (104,'Gandhi nagar',22387,"India",1109); 
-- 0	59	20:12:24	insert into address values (104,'Gandhi nagar',22387,"India",1109)	
-- Error Code: 1452.
--  Cannot add or update a child row: a foreign key constraint fails (`jb2404`.`address`, CONSTRAINT `address_ibfk_1` FOREIGN KEY (`UID`) REFERENCES `users` (`user_id`))	0.016 sec
insert into address values (104,'Gandhi nagar',22387,"India",null); 

select * from address;

-- get all address of Vivek -- here join required
-- inner join
select u.name,u.cit,u.salary,a.street,a.country
from users u
inner join address a
on u.user_id = a.uid
where u.name ='Vivek';

-- left join
select u.name,u.cit,u.salary,a.street,a.country
from users u
left join address a
on u.user_id = a.uid;

-- right join
select u.name,u.cit,u.salary,a.street,a.country
from users u
right join address a
on u.user_id = a.uid;

-- nested query
select u.name,u.cit,u.salary,a.street,a.country
from users u
inner join address a
on u.user_id = a.uid
where u.user_id = (select user_id from users where name ='Vivek');

-- group by
-- If you want to find out how many addresses each user has, you can use the GROUP BY clause as
select u.user_id, u.name, count(address_id) as address_count 
from users u left join address a on u.user_id = a.UID
group by u.user_id,u.name;

-- having
-- You want to retrieve users who have more than one address.

-- Key Difference: WHERE vs HAVING
-- WHERE: Filters rows before grouping.
-- HAVING: Filters groups after aggregation.
select u.user_id, u.name, count(address_id) as address_count 
from users u left join address a on u.user_id = a.UID
group by u.user_id,u.name
having address_count >1;
-- count
select count(user_id) from users;

-- sum
select sum(Salary) from users;

