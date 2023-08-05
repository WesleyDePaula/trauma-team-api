create table users (
    id uuid not null,
    login varchar(100) not null,
    password varchar(255) not null,
    primary key (id)
);