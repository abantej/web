DELETE FROM profile;
INSERT INTO profile(id, first_name, middle_name, last_name, birth_date) VALUES(1L, 'Ember', 'Xin', 'Spirit', '1990-01-14');
INSERT INTO profile(id, first_name, middle_name, last_name, birth_date) VALUES(2L, 'Pangolier', 'Rollig', 'Thunder', '1980-09-24');
INSERT INTO profile(id, first_name, middle_name, last_name, birth_date) VALUES(3L, 'Mars', 'R', 'Man', '1950-08-11');
INSERT INTO profile(id, first_name, middle_name, last_name, birth_date) VALUES(5L, 'Dragon', 'J', 'Knight', '1952-03-11');
INSERT INTO profile(id, first_name, middle_name, last_name, birth_date) VALUES(6L, 'Juggernaut', 'J', 'Masked', '1945-08-11');
INSERT INTO profile(id, first_name, middle_name, last_name, birth_date) VALUES(7L, 'Brew', 'B', 'Master', '1952-03-11');

DELETE FROM address;
INSERT INTO address (id, profile_id, address, city, state, zip, country) VALUES(1L, 1L, 'Random Address 1', NULL, NULL, '123456', 'Philippines');
INSERT INTO address(id, profile_id, address, city, state, zip, country) VALUES(2L, 2L, 'Random Address 2', NULL, NULL, '123456', 'Singapore');
INSERT INTO address(id, profile_id, address, city, state, zip, country) VALUES(3L, 6L, 'Random Address 3', NULL, NULL, '123456', 'Singapore');
INSERT INTO address(id, profile_id, address, city, state, zip, country) VALUES(4L, 7L, 'Random Address 4', NULL, NULL, '123456', 'Singapore');
