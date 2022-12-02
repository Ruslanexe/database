-- 1:M relationship by triggers
DROP trigger IF EXISTS before_fireman_insert;
DELIMITER //
create trigger before_fireman_insert
    before INSERT
    on fireman for each row
begin
    declare match_row_for_id int;
    select count(*) into match_row_for_id from fire_team where id = NEW.fireteam_id;
    if match_row_for_id = 0 then
                signal sqlstate '22000'
                set MESSAGE_TEXT = 'A foreign key constrain fails for fireteam_id';
end if;
end //
DELIMITER ;

DROP trigger IF EXISTS before_fireman_update;
DELIMITER //
create trigger before_fireman_update
    before UPDATE
    on fireman for each row
begin
    declare match_row_for_id int;
            if OLD.fireteam_id <> NEW.fireteam_id then
    select count(*) into match_row_for_id from fire_team where id = NEW.fireteam_id;
    if match_row_for_id = 0 then
                    signal sqlstate '22000'
                    set MESSAGE_TEXT = 'A foreign key constrain fails for fireteam_id';
end if;
end if;
end;
DELIMITER ;

DROP trigger IF EXISTS before_fire_team_update;
DELIMITER //
create trigger before_fire_team_update
    before UPDATE
    on fire_team for each row
begin
    declare count_used_for_id int;
            if OLD.id <> NEW.id then
    select count(*) into count_used_for_id from fireman where fireteam_id = OLD.id;
    if count_used_for_id > 0 then
                    signal sqlstate '22000'
                    set MESSAGE_TEXT = 'A foreign key constrain fails for fireteam_id';
end if;
end if;
end;
DELIMITER ;


DROP trigger IF EXISTS before_fire_team_delete;
DELIMITER //
create trigger before_fire_team_delete
    before delete
    on fire_team for each row
begin
    declare count_used_for_id int;
    select count(*) into count_used_for_id from fireman where id = OLD.id;
    if count_used_for_id > 0 then
                signal sqlstate '22000'
                set MESSAGE_TEXT = 'A foreign key constraint fails for id in table fireman';
end if;
end;
DELIMITER ;

-- minimum cardinality of 6 tapes for client table
DROP trigger IF EXISTS after_client_delete;
DELIMITER //
create trigger after_client_delete
    after delete
    on client for each row
begin
    if (select count(*) from client) < 6 then
                    signal sqlstate '45000'
        set MESSAGE_TEXT = 'Delete error MIN cardinality';
end if;
end //
DELIMITER ;

-- prohibit removal of tapes from the gender table
DROP trigger IF EXISTS before_gender_delete;
DELIMITER //
create trigger before_gender_delete
    before delete
    on gender for each row
begin
    signal sqlstate '45000'
                set MESSAGE_TEXT = 'Cannot delete from table gender';
end //
DELIMITER ;

-- log table on modifying table client_gym
DROP trigger IF EXISTS after_client_gym_insert;
DELIMITER //
create trigger after_client_gym_insert
    after insert
    on client_gym for each row
begin
    INSERT INTO client_gym_logger(action, client_id, edit_time, edit_user, gym_id) VALUE
        ('insert', new.client_id, NOW(), USER(), new.gym_id);
end //
DELIMITER ;

DELIMITER //
DROP trigger IF EXISTS after_client_gym_delete;
create trigger after_client_gym_delete
    after delete
    on client_gym for each row
begin
    INSERT INTO client_gym_logger(action, client_id, edit_time, edit_user, gym_id) VALUE
        ('delete', old.client_id, NOW(), USER(), old.gym_id);
end //
DELIMITER ;