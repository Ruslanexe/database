create database if not exists Labor_SQL;
use Labor_SQL;
SELECT * FROM outcomes;
-- First 1
SELECT * FROM outcomes WHERE not result ="sunk" and battle = "Guadalcanal";
-- Second2
SELECT * FROM ships WHERE name like "%a";
-- Fifth 5
SELECT ships.name, ships.launched , classes.displacement
FROM ships
INNER JOIN classes on ships.class = classes.class
WHERE launched > "1922" AND displacement >"35000" AND  classes.type= "bb";
-- Eighth 8
Select outcomes.ship as shipName, (
  SELECT classes.numGuns from classes where classes.class = (
    SELECT ships.class from ships where ships.name = shipName
    )
) as numGuns from outcomes where outcomes.battle = "Guadalcanal";
-- Third 3
Select product.maker,pc.model,pc.price
FROM product
INNER JOIN pc on product.model = pc.model ;
-- Fourth 4
SELECT DISTINCT maker FROM product WHERE NOT EXISTS (SELECT * FROM pc WHERE pc.model=product.model) AND product.type="PC";
-- Sixth 6
SELECT CONCAT("model: ",model, ";", " color: ",color, ";", " type: ",type, ";", " price: ",price, ";") AS  Result FROM printer;  
-- Seventh 7
SELECT DISTINCT maker
 FROM product
 WHERE  EXISTS 
 (SELECT * FROM pc WHERE pc.model=product.model) 
 AND product.type="PC";  
-- Tenth 10
SELECT distinct maker FROM product WHERE maker = "A" and (type = "PC" OR "Laptop") 
UNION (
SELECT AVG(price) from pc);
-- Ninth 9
SELECT company.name,plane,town_to,town_from,time_out,time_in,
CASE 
    WHEN DATE_FORMAT(time_in,'%H')  > Date_FORMAT(time_out,'%H') THEN DATE_FORMAT(time_in,'%H')  - Date_FORMAT(time_out,'%H')
    ELSE Date_FORMAT(time_out,'%H') - DATE_FORMAT(time_in,'%H')
    END
    as duration
FROM trip
INNER JOIN company 
ON company.ID_comp = trip.ID_comp
;