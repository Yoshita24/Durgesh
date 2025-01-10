select * from categories;
Select * from categories where title ='testinggg';
select * from course;
select * from jpa_user;
select cat.title,cat.description,cou.description,cou.title
from
categories cat inner join course cou
on cat.id = cou.category_id