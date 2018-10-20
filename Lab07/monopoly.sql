--
-- This SQL script builds a monopoly database, deleting any pre-existing version.
--
-- @author kvlinden
-- @version Summer, 2015
--

-- Drop previous versions of the tables if they they exist, in reverse order of foreign keys.
DROP TABLE IF EXISTS OwnedProperty;
DROP TABLE IF EXISTS Property;
DROP TABLE IF EXISTS PlayerGame;
DROP TABLE IF EXISTS Game;
DROP TABLE IF EXISTS Player;


-- Create the schema.
CREATE TABLE Game (
	ID integer PRIMARY KEY, 
	time timestamp
	);

CREATE TABLE Player (
	ID integer PRIMARY KEY, 
	emailAddress varchar(50) NOT NULL,
	name varchar(50) 
	);

CREATE TABLE PlayerGame (
	gameID integer REFERENCES Game(ID), 
	playerID integer REFERENCES Player(ID),
	score decimal,
	cash money
	);

CREATE TABLE Property(
	ID int PRIMARY KEY,
	name varchar(50),
	houses int NOT NULL,
	hotels int NOT NULL 
);

CREATE TABLE OwnedProperty(
	game int REFERENCES Game(ID),
	player int REFERENCES Player(ID),
	propertyID int REFERENCES Property(ID)
);

-- Allow users to select data from the tables.
GRANT SELECT ON Game TO PUBLIC;
GRANT SELECT ON Player TO PUBLIC;
GRANT SELECT ON PlayerGame TO PUBLIC;
GRANT SELECT ON Property TO PUBLIC;
GRANT SELECT ON OwnedProperty TO PUBLIC;


-- Add sample records.
INSERT INTO Game VALUES (1, '2006-06-27 08:00:00');
INSERT INTO Game VALUES (2, '2006-06-28 13:20:00');
INSERT INTO Game VALUES (3, '2006-06-29 18:41:00');
INSERT INTO Game VALUES (4, '2018-11-29 13:21:00');


INSERT INTO Player(ID, emailAddress) VALUES (1, 'me@calvin.edu');
INSERT INTO Player VALUES (2, 'king@gmail.edu', 'The King');
INSERT INTO Player VALUES (3, 'dog@gmail.edu', 'Dogbreath');
INSERT INTO Player VALUES (4, 'jww@calvin.edu', 'Josh');

INSERT INTO PlayerGame VALUES (1, 1, 0.00, 0.00);
INSERT INTO PlayerGame VALUES (1, 2, 0.00, 0.00);
INSERT INTO PlayerGame VALUES (1, 3, 2350.00, 0.00);
INSERT INTO PlayerGame VALUES (2, 1, 1000.00, 0.00);
INSERT INTO PlayerGame VALUES (2, 2, 0.00, 0.00);
INSERT INTO PlayerGame VALUES (2, 3, 500.00, 0.00);
INSERT INTO PlayerGame VALUES (3, 2, 0.00, 0.00);
INSERT INTO PlayerGame VALUES (3, 3, 5500.00, 0.00);
INSERT INTO PlayerGame VALUES (4, 4, 5500.00, 0.00);

INSERT INTO Property VALUES (1,'NewYork Avenue', 2, 2);
INSERT INTO Property VALUES (2,'LA Avenue', 4, 1);
INSERT INTO Property VALUES (3,'Chicago Avenue', 3, 5);

INSERT INTO OwnedProperty VALUES (4, 4, 2);