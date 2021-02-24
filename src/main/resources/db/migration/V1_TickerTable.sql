create TABLE public.ticker
(
--https://dzone.com/articles/bounty-spring-boot-and-postgresql-database
    id SERIAL PRIMARY KEY NOT NULL,
    tickerName VARCHAR(50) NOT NULL
);