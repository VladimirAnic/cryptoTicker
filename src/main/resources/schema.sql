create table public.ticker
(
--https://dzone.com/articles/bounty-spring-boot-and-postgresql-database
    id serial primary key not null,
    ticker_Name varchar(50) not null
);

create table public.pair
(
    id serial primary key,
    pair_Name varchar(1) ,
    ticker_Id integer not null references public.ticker(id)
);
create table public.pair_array_values
(
    id serial primary key,
    fetched_Time date not null default current_date,
    first_Parameter numeric,
    second_Parameter numeric,
    third_Parameter numeric,
    pair_Id integer not null references public.pair(id)
);
