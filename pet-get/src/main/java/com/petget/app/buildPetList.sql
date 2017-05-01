## build pet list
## for mysql

USE animals;
DROP TABLE IF EXISTS pets;

CREATE TABLE pets (
    id INT NOT NULL,
    type VARCHAR(255),
    nickname VARCHAR(255),
    weight INT NOT NULL,
    color VARCHAR(255)
);

INSERT INTO pets VALUES (1, 'Bird', 'Donny', 2, 'blue');
INSERT INTO pets VALUES (2, 'Dog', 'Davey', 3, 'brown');
INSERT INTO pets VALUES (3, 'Dog', 'Daisy', 4, 'brown');
INSERT INTO pets VALUES (4, 'Cat', 'Donald', 2, 'black');
INSERT INTO pets VALUES (5, 'Snake', 'Doof', 5, 'beige');
INSERT INTO pets VALUES (6, 'Hamster', 'Duke Chubby', 3, 'blood red');
INSERT INTO pets VALUES (7, 'Spider', 'Dandelion', 1, 'green');
INSERT INTO pets VALUES (8, 'Fish', 'Dolores', 3, 'rainbow');

SELECT * FROM pets;