INSERT INTO Users (UserName, UserPass) VALUES ('UnitTester0', 'supersecret0');
INSERT INTO ASCTest.Users (UserName, UserPass) VALUES ('UnitTester1', 'supersecret1');
INSERT INTO ASCTest.Role (RoleName, UserId, UserName ) VALUES ( 'user',1,'UnitTester0');
INSERT INTO ASCTest.Role (RoleName, UserId, UserName ) VALUES ( 'user',2,'UnitTester1');
INSERT INTO ASCTest.Animals(UserId, AnimalsName, AnimalsClass, AnimalsFiction, AnimalsHealth, AnimalsStamina, AnimalsStrength, AnimalsAgility, AnimalsDexterity, AnimalsIntelligence)VALUES (1,'testAnimalname','testAnimalclass','true',10,10,10,10,10,10);
INSERT INTO ASCTest.Animals(UserId, AnimalsName, AnimalsClass, AnimalsFiction, AnimalsHealth, AnimalsStamina, AnimalsStrength, AnimalsAgility, AnimalsDexterity, AnimalsIntelligence)VALUES (1,'testAnimalname2','testAnimalclass','true',100,10,10,10,10,10);
INSERT INTO ASCTest.Animals(UserId, AnimalsName, AnimalsClass, AnimalsFiction, AnimalsHealth, AnimalsStamina, AnimalsStrength, AnimalsAgility, AnimalsDexterity, AnimalsIntelligence)VALUES (2,'testAnimalname','testAnimalclass','true',100,10,10,10,10,10);