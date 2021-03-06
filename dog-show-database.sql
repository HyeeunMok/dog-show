DROP DATABASE IF EXISTS dogshow;
CREATE DATABASE dogshow;
USE dogshow;
CREATE TABLE dog_list (
	EntryNumber INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	Name VARCHAR(255) NOT NULL, 
	OwnerName VARCHAR(255) NOT NULL, 
	Breed VARCHAR(255) NOT NULL, 
	DogGroup VARCHAR(255) NOT NULL, 
	Gender VARCHAR(20) NOT NULL, 
	DogClass VARCHAR(255) NOT NULL, 
	Day1 VARCHAR(20), 
	Day2 VARCHAR(20), 
	Day3 VARCHAR(20), 
	Email VARCHAR(255) NOT NULL,  
	Password VARCHAR(255) NOT NULL,
	Membership VARCHAR(32) NOT NULL
);

COMMIT