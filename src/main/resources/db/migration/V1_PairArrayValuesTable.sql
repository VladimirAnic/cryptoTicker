create TABLE public.pairArrayValues
(
    id SERIAL PRIMARY KEY,
    fetchedTime DATE NOT NULL DEFAULT CURRENT_DATE,
    firstParameter NUMERIC,
    secondParameter NUMERIC,
    thirdParameter NUMERIC,
    pairId INTEGER NOT NULL references public.pair(id)
);