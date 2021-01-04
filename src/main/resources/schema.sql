create table public.ticker
    (
    --https://dzone.com/articles/bounty-spring-boot-and-postgresql-database
        ticker_id serial primary key not null,
        ticker_name varchar(50) not null
    );
create table public.ticker_pair
    (
        pair_id integer references public.pair(pair_id),
        ticker_id integer references public.ticker(ticker_id)
    );
create table public.pair
    (
        pair_id serial primary key,
        pair_name varchar(1)
    --    ticker_id integer references public.ticker(ticker_id)
    );
create table public.pair_array_values
    (
        pair_array_values_id serial primary key,
        fetched_time date not null default current_date,
        first_parameter numeric,
        second_parameter numeric,
        third_parameter numeric,
        pair_id integer references public.pair(pair_id)
    );
create sequence ticker_id_seq start with 1 increment by 50;
create sequence pair_array_values_id_seq start with 1 increment by 50;
create sequence pair_id_seq start with 1 increment by 50;
insert into public.pair (pair_id, pair_name)
    values
        (0, 'a'),
        (1, 'b'),
        (2, 'c'),
        (3, 'v'),
        (4, 'p'),
        (5, 't'),
        (6, 'l'),
        (7, 'h'),
        (8, 'o')
        ;