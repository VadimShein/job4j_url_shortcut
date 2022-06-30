create table if not exists sites(
    id serial primary key,
    login text,
    password text,
    site text unique
);

create table if not exists urls(
    id serial primary key,
    url text,
    code text unique,
    total int,
    site_id int references sites(id)
);