SELECT * FROM profesori
WHERE godine > 45;

SELECT godine FROM ucenici
ORDER BY godine DESC;

SELECT * FROM profesori
WHERE predmet = 'Informatika';

SELECT ime,prezime FROM ucenici
WHERE godine > 15 AND prosek > 6.5;

SELECT ucenikid,ime,prezime FROM ucenici
WHERE Length(ime) = 6;

