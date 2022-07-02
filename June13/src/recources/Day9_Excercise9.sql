--TODO 1
--Which city has the most invoices?
--Order by invoice count

SELECT BillingCity ,
COUNT(InvoiceId) InvoiceCount
FROM invoices i
GROUP BY BillingCity
ORDER BY InvoiceCount DESC;


--TODO 2
--Which cities has the best customers
--This means we want to have an ordered list
--of 5 best cities with highest sum of totals

SELECT BillingCity ,
Total (Total) SumOfTotal
FROM invoices i
GROUP BY BillingCity
ORDER BY SumOfTotal DESC LIMIT 5;

--TODO 3 Find the biggest 3 spenders
--this might involve joining customers and invoices and invoice items
--then using GROUP BY and then SUM on grouped TOTAL
--goood
SELECT i.CustomerId, c.FirstName, c.LastName, SUM(Total) Sumtotal
FROM invoices i
JOIN customers c
ON i.CustomerId = c.CustomerId
GROUP BY i.CustomerId
ORDER BY Sumtotal DESC;


SELECT CustomerId ,
SUM(Total) Sumtotal
FROM invoices i
GROUP BY CustomerId
ORDER BY Sumtotal DESC;

--TODO 4 find ALL listeners to classical music
-- include their names and emails and phone numbers
--this might not need aggregation

SELECT * FROM genres g ; --Classical

SELECT i.CustomerId, c.FirstName, c.LastName, c.Email, c.Phone,  COUNT(t.TrackId) ClassicalMusicTracks, SUM(total) Sumtotal
FROM customers c
JOIN invoices i
ON i.CustomerId = c.CustomerId
JOIN invoice_items ii
ON i.InvoiceId=ii.InvoiceId
JOIN tracks t
ON t.TrackId =ii.TrackId
JOIN genres g
ON t.GenreId =g.GenreId
WHERE g.Name ='Classical'
GROUP BY i.CustomerId
ORDER BY ClassicalMusicTracks DESC;