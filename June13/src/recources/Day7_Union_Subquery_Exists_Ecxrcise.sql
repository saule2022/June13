--TODO 1
--query for all tracks that appear on any playlist_track
--order by track name

--TODO 2
--query for all tracks that have been bought
--order by track name

SELECT TrackId, name
FROM tracks t
WHERE TrackId IN (
	SELECT TrackId
	FROM playlist_track pt)
ORDER BY Name ;


SELECT TrackId, name
FROM  tracks t
WHERE EXISTS (
	SELECT TrackId
	FROM invoice_items ii
	WHERE
	t.TrackId=ii.TrackId)
 ORDER BY Name;
