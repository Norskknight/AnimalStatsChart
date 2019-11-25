use ASCTest;
SET foreign_key_checks = 0;
DELETE FROM ASCTest.Users;
DELETE FROM ASCTest.Role;
DELETE FROM ASCTest.Animals;
TRUNCATE TABLE ASCTest.Users;
TRUNCATE TABLE ASCTest.Role;
TRUNCATE TABLE ASCTest.Animals;
SET foreign_key_checks = 1;