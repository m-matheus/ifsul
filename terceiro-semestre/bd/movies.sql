create database movies;

use movies;


SELECT m.title
FROM movie m
JOIN production_country pc ON m.movie_id = pc.movie_id
JOIN country c ON pc.country_id = c.country_id
WHERE c.country_name LIKE '%Brasil%' OR c.country_name LIKE '%Argentina%';


SELECT m.title, COUNT(mc.person_id) AS num_actors
FROM movie m
JOIN movie_crew mc ON m.movie_id = mc.movie_id
WHERE m.release_date >= 2010-01-01 AND mc.job LIKE '%Characters%'
GROUP BY m.title;


SELECT m.title, COUNT(mc.person_id) AS num_actors
FROM movie m
JOIN movie_crew mc ON m.movie_id = mc.movie_id
WHERE mc.job LIKE '%Characters%'
GROUP BY m.title
HAVING COUNT(mc.person_id) >= 50;
