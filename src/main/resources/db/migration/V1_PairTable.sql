create TABLE public.pair
(
    id SERIAL PRIMARY KEY,
    pairName VARCHAR(1) ,
    tickerId INTEGER NOT NULL references public.ticker(id)
);