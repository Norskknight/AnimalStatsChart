use ASCTest;
SET foreign_key_checks = 0;
DELETE FROM ASCTest.Users;
DELETE FROM ASCTest.Role;
DELETE FROM ASCTest.Animals;
DELETE FROM ASCTest.AverageAnimals;
TRUNCATE TABLE ASCTest.Users;
TRUNCATE TABLE ASCTest.Role;
TRUNCATE TABLE ASCTest.Animals;
TRUNCATE TABLE ASCTest.AverageAnimals;
SET foreign_key_checks = 1;