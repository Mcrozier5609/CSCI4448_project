## build pet list
## for mysql

USE animals;
DROP TABLE IF EXISTS pets;

CREATE TABLE pets (
    id INT NOT NULL,
    type VARCHAR(255),
    nickname VARCHAR(255),
    weight INT NOT NULL,
    color VARCHAR(255),
    imageURL VARCHAR(255)
);

INSERT INTO pets VALUES (1, 'Bird', 'Donny', 2, 'blue', 'http://pngimg.com/uploads/parrot/parrot_PNG717.png');
INSERT INTO pets VALUES (2, 'Dog', 'Davey', 3, 'brown', 'http://r.ddmcdn.com/w_830/s_f/o_1/cx_0/cy_220/cw_1255/ch_1255/APL/uploads/2014/11/dog-breed-selector-australian-shepherd.jpg');
INSERT INTO pets VALUES (3, 'Dog', 'Daisy', 4, 'brown', 'https://www.royalcanin.com/~/media/Royal-Canin/Product-Categories/dog-maxi-landing-hero.ashx');
INSERT INTO pets VALUES (4, 'Cat', 'Donald', 2, 'black', 'http://cdn2-www.cattime.com/assets/uploads/2015/10/black-cat-names.jpg');
INSERT INTO pets VALUES (5, 'Snake', 'Doof', 5, 'beige', 'http://www.masnakes.org/snakes/brown/fullsize/brown_fs.jpg');
INSERT INTO pets VALUES (6, 'Hamster', 'Duke Chubby', 3, 'blood red', 'https://s-media-cache-ak0.pinimg.com/736x/92/40/c0/9240c0c7c57720ca0119d7d3d495fe3b.jpg');
INSERT INTO pets VALUES (7, 'Spider', 'Dandelion', 1, 'green', 'http://farm7.staticflickr.com/6200/6055125893_100168d6d1.jpg');
INSERT INTO pets VALUES (8, 'Fish', 'Dolores', 3, 'rainbow', 'http://www.themusichall.org/assets/uploads/images/17_03_SDS_RainbowFish_event.jpg');

SELECT * FROM pets;