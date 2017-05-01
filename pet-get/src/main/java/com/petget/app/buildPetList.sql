## build pet list
## for mysql

USE animals;
DROP TABLE IF EXISTS pets;

CREATE TABLE pets (
    id INT NOT NULL,
    nickname VARCHAR(255),
    weight INT NOT NULL,
    color VARCHAR(255)
);

INSERT INTO pets VALUES (1, 'Donny', 2, 'blue');
INSERT INTO pets VALUES (2, 'Davey', 3, 'brown');
INSERT INTO pets VALUES (3, 'Daisy', 4, 'brown');
INSERT INTO pets VALUES (4, 'Donald', 2, 'black');
INSERT INTO pets VALUES (5, 'Doof', 5, 'beige');
INSERT INTO pets VALUES (6, 'Duke Chubby', 3, 'blood red');
INSERT INTO pets VALUES (7, 'Dandelion', 1, 'green');
INSERT INTO pets VALUES (8, 'Dolores', 3, 'rainbow');

SELECT * FROM pets;