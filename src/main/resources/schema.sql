CREATE TABLE public.ticker
(
--https://dzone.com/articles/bounty-spring-boot-and-postgresql-database
    id SERIAL PRIMARY KEY NOT NULL,
    tickerName VARCHAR(50) NOT NULL
);

CREATE TABLE public.pair
(
    id SERIAL PRIMARY KEY,
    pairName VARCHAR(1) ,
    tickerId INTEGER NOT NULL references public.ticker(id)
);
CREATE TABLE public.pairArrayValues
(
    id SERIAL PRIMARY KEY,
    fetchedTime DATE NOT NULL DEFAULT CURRENT_DATE,
    firstParameter NUMERIC,
    secondParameter NUMERIC,
    thirdParameter NUMERIC,
    pairId INTEGER NOT NULL references public.pair(id)
);
