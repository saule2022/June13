--TODO 1
-- create index for milliseconds on tracks table
CREATE INDEX idx_track_milliseconds
ON tracks(milliseconds);


-- can it use unique constraint?

--Can not use unique constraint
CREATE UNIQUE INDEX idx_tracks_milliseconds
ON tracks(milliseconds);


-- query all tracks over 5 min length

SELECT * FROM tracks t
WHERE Milliseconds  >300000;
-- check if the query uses index

EXPLAIN QUERY PLAN
SELECT * FROM tracks t2
WHERE Milliseconds  >300000;
--USES index


--TODO 2
-- create index on combined LENGTH of customers first_name and last_name

CREATE INDEX idx_first_last_name
ON customers(LENGTH(FirstName)+LENGTH(LastName));

-- two possible approaches one with concat one without


-- find all customers with combined length over 20 symbols
SELECT* FROM customers c
WHERE (LENGTH (FirstName)+LENGTH(LastName))>20;

-- check if the query uses index
EXPLAIN QUERY PLAN
SELECT * FROM customers c2
WHERE (LENGTH (FirstName)+LENGTH(LastName))>20;

--USES index