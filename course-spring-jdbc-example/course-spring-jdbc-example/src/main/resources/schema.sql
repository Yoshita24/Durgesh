create table if not exists course(
    id int primary key,
    title varchar(100) not null,
    description varchar(500),
    category_id int not null,
    foreign key(category_id) references categories(id)
    on delete cascade
    on update cascade
);