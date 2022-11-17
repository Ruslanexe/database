DROP PROCEDURE IF EXISTS insertion_into_fire_man;
DELIMITER //
create procedure insertion_into_fire_man(
    in new_fireteam_id int ,
    in new_name varchar(50),
    in new_surname varchar(50),
    OUT generated_id int)
begin
        DECLARE new_fire_team_id_exist int;
select new_fireteam_id into new_fire_team_id_exist;
if new_fire_team_id_exist is null then
            signal sqlstate '45000'
            set MESSAGE_TEXT = 'Fire_team with this id not found';
end if;
insert into fireman(fireteam_id, name, surname) VALUE (new_fireteam_id,new_name,new_surname);
select id into generated_id from fireman where surname=new_surname;
end //
DELIMITER ;

DROP PROCEDURE IF EXISTS insertion_into_client_gym_M_to_M;
DELIMITER //
create procedure insertion_into_client_gym_M_to_M(
    IN new_gym_id int,
    IN new_client_id int)
begin
    DECLARE new_gym_id_exists int;
    DECLARE new_client_id_exists int;
    select id into new_gym_id_exists from gym where id=new_gym_id;
    select id into new_client_id_exists from client where id=new_client_id;
    if new_gym_id_exists is null then
        signal sqlstate '22000'
            set MESSAGE_TEXT = 'Gym with this id not found';
    elseif new_client_id_exists is null then
        signal sqlstate '22000'
            set MESSAGE_TEXT = 'Client with this id not found';
    end if;
    insert into client_gym(gym_id, client_id) VALUE (new_gym_id_exists, new_client_id_exists);
end //
DELIMITER ;

DROP PROCEDURE IF EXISTS InsertLinesToFireteam;
DELIMITER //
CREATE PROCEDURE InsertLinesToFireteam()
BEGIN
	DECLARE line int;
    SET line = 0;
	WHILE line < 10 DO
        SET line = line + 1;
        insert into fireteam(name) value(CONCAT("fireteam", line));
	END WHILE;
END //
DELIMITER ;

drop procedure if exists ProcCursor;
DELIMITER //
CREATE PROCEDURE ProcCursor()
BEGIN
	DECLARE fireteamName varchar(50);
    DECLARE tablesCount int;
    DECLARE done boolean default false;
	DECLARE nameCur CURSOR 
    FOR SELECT name FROM fireteam;
    DECLARE CONTINUE HANDLER
	FOR NOT FOUND SET done = true;
    OPEN nameCur;
    myloop: LOOP
		FETCH nameCur INTO fireteamName;
		IF done THEN
			leave myloop;
        END IF;
        SET @tmpQuery = CONCAT('CREATE DATABASE IF NOT EXISTS ', fireteamName);
        PREPARE compiled FROM @tmpQuery;
        EXECUTE compiled;
        DEALLOCATE PREPARE compiled;
        SET tablesCount = 0;
        WHILE tablesCount < 5 DO
			SET tablesCount = tablesCount + 1;
            SET @tmpQuery = CONCAT('CREATE TABLE IF NOT EXISTS ', fireteamName, '.', fireteamName, (tablesCount), '(id int not null auto_increment, CONSTRAINT ', fireteamName, '_pk PRIMARY KEY (id))');
			PREPARE compiled FROM @tmpQuery;
			EXECUTE compiled;
			DEALLOCATE PREPARE compiled;
        END WHILE;
    END LOOP;
    CLOSE namecur;
END //
DELIMITER ;

DROP FUNCTION IF EXISTS complexity_avg;
DELIMITER //
create function complexity_avg()
    returns INT DETERMINISTIC
begin
    return (SELECT avg(complexity) FROM exercise);
end //
DELIMITER ;

DROP PROCEDURE IF EXISTS exercise_complexity_avg;
DELIMITER //
create procedure exercise_complexity_avg(
    OUT res_complexity_avg INT)
begin
    SELECT complexity_avg() INTO res_complexity_avg;
end //
DELIMITER ;

