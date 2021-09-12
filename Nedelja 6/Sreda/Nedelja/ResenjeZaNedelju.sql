SELECT email,phone_number,region_name FROM employees
INNER JOIN departments ON employees.department_id = departments.department_id
INNER JOIN locations ON departments.location_id = locations.location_id
INNER JOIN countries ON locations.country_id = countries.country_id
INNER JOIN regions ON countries.region_id = regions.region_id
WHERE region_name = 'Europe' AND phone_number IS NOT NULL;

--Pokusaj resavanja prvog zadatka bez joina i bez AND, ovaj query nece raditi.
SELECT email,phone_number,region_name FROM employees
WHERE department_id IN (SELECT department_id FROM departments WHERE location_id IN 
                       (SELECT location_id FROM locations WHERE country_id IN 
                       (SELECT country_id FROM countries WHERE region_id IN 
                       (SELECT region_id FROM regions WHERE region_name = 'Europe'))));
 
SELECT * FROM dependents
INNER JOIN employees ON dependents.employee_id = employees.employee_id
ORDER BY salary DESC
LIMIT 5;

SELECT country_name FROM countries
INNER JOIN locations ON countries.country_id = locations.country_id
INNER JOIN departments ON locations.location_id = departments.location_id
INNER JOIN employees ON departments.department_id = employees.department_id
ORDER BY salary DESC;


