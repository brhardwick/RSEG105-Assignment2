DROP DATABASE RSEG105;
CREATE DATABASE RSEG105;


CREATE TABLE IF NOT EXISTS `RSEG105`.`category` (
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` VARCHAR(100) NULL)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `RSEG105`.`book` (
    `id` INT NOT NULL  AUTO_INCREMENT PRIMARY KEY,
    `category_id` INT NULL,
    `isbn` VARCHAR(10) NULL,
    `title` VARCHAR(500) NULL,
    `price` DECIMAL(4 , 2 ) NULL,
    INDEX `BOOKcategory_idx` (`category_id` ASC)
  
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS `RSEG105`.`author` (
	`ID` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `FIRST_NAME` VARCHAR(60) NOT NULL,
    `LAST_NAME` VARCHAR(60) NOT NULL,
	`DESCRIPTION` VARCHAR(1200) NOT NULL
)  ENGINE=INNODB;


CREATE TABLE IF NOT EXISTS `RSEG105`.`author_book` (
    `AUTHOR_ID` INT NOT NULL,
    `BOOK_ID` INT NULL
  
)  ENGINE=INNODB;

INSERT INTO `RSEG105`.`category` (`id`, `name`) VALUES (1, 'Accounting');
INSERT INTO `RSEG105`.`category` (`id`, `name`) VALUES (2, 'Agriculture');
INSERT INTO `RSEG105`.`category` (`id`, `name`) VALUES (3, 'World');


INSERT INTO `RSEG105`.`BOOK` (`id`, `category_id`, `isbn`, `title`, `price`) VALUES (1, 1, '0130018775', 'Accountants desk handbook', 12.55);
INSERT INTO `RSEG105`.`BOOK` (`id`, `category_id`, `isbn`, `title`, `price`) VALUES (2, 1, '0333573285', 'Accountancys faulty sums', 45.88);
INSERT INTO `RSEG105`.`BOOK` (`id`, `category_id`, `isbn`, `title`, `price`) VALUES (3, 1, '0444104593', 'Accountancy and economic development policy', 25.58);
INSERT INTO `RSEG105`.`BOOK` (`id`, `category_id`, `isbn`, `title`, `price`) VALUES (4, 2, '0813829429', 'Soil science simplified', 64.21);
INSERT INTO `RSEG105`.`BOOK` (`id`, `category_id`, `isbn`, `title`, `price`) VALUES (5, 2, '0813827590', 'Profiles in the history of the U. S. Soil Survey', 12.58);
INSERT INTO `RSEG105`.`BOOK` (`id`, `category_id`, `isbn`, `title`, `price`) VALUES (6, 2, '0813818478', 'Natural resources engineering', 12.99);
INSERT INTO `RSEG105`.`BOOK` (`id`, `category_id`, `isbn`, `title`, `price`) VALUES (7, 3, '0813821886', 'The mission: journalism, ethics and the world', 15.99);

INSERT INTO `RSEG105`.`AUTHOR` (ID,FIRST_NAME,LAST_NAME,DESCRIPTION) VALUES ('1','Foreyt', 'William J.','suggesting someone has done something wrong, complaining');
INSERT INTO `RSEG105`.`AUTHOR` (ID,FIRST_NAME,LAST_NAME,DESCRIPTION) VALUES ('2','Williams', 'Herbert L.','sharp; forthright; biting; hurtful; abrasive; severe');
INSERT INTO `RSEG105`.`AUTHOR` (ID,FIRST_NAME,LAST_NAME,DESCRIPTION) VALUES ('3','Durana', 'Patricia J. ','approving; think highly of; respectful; praising');
INSERT INTO `RSEG105`.`AUTHOR` (ID,FIRST_NAME,LAST_NAME,DESCRIPTION) VALUES ('4',' Effland', 'Anne','hostile; determined; forceful; argumentative');
INSERT INTO `RSEG105`.`AUTHOR` (ID,FIRST_NAME,LAST_NAME,DESCRIPTION) VALUES ('5','Ameiss', 'Albert P.','indignant; annoyed; offended; disgruntled');
INSERT INTO `RSEG105`.`AUTHOR` (ID,FIRST_NAME,LAST_NAME,DESCRIPTION) VALUES ('6','Kargas', 'Nicholas A. ','having mixed feelings; uncertain; in a dilemma; undecided');
INSERT INTO `RSEG105`.`AUTHOR` (ID,FIRST_NAME,LAST_NAME,DESCRIPTION) VALUES ('7','Bhattacharya', 'Keron ','entertained; diverted; pleased');
INSERT INTO `RSEG105`.`AUTHOR` (ID,FIRST_NAME,LAST_NAME,DESCRIPTION) VALUES ('8','Enthoven', 'Adolf Jan Henri ','incensed or enraged; threatening or menacing');
INSERT INTO `RSEG105`.`AUTHOR` (ID,FIRST_NAME,LAST_NAME,DESCRIPTION) VALUES ('9','Harpstead', 'Milo I.','full of life or excitement; lively; spirited; impassioned; vibrant');
INSERT INTO `RSEG105`.`AUTHOR` (ID,FIRST_NAME,LAST_NAME,DESCRIPTION) VALUES ('10','Carter', 'Geroge. R. ','showing little interest; lacking concern; indifferent; unemotional');


INSERT INTO `RSEG105`.`author_book` (`AUTHOR_ID`,`BOOK_ID`) VALUES (1,1);
INSERT INTO `RSEG105`.`author_book` (`AUTHOR_ID`,`BOOK_ID`) VALUES (2,2);
INSERT INTO `RSEG105`.`author_book` (`AUTHOR_ID`,`BOOK_ID`) VALUES (3,3);
INSERT INTO `RSEG105`.`author_book` (`AUTHOR_ID`,`BOOK_ID`) VALUES (4,4);
INSERT INTO `RSEG105`.`author_book` (`AUTHOR_ID`,`BOOK_ID`) VALUES (5,5);
INSERT INTO `RSEG105`.`author_book` (`AUTHOR_ID`,`BOOK_ID`) VALUES (6,6);
INSERT INTO `RSEG105`.`author_book` (`AUTHOR_ID`,`BOOK_ID`) VALUES (7,7);
INSERT INTO `RSEG105`.`author_book` (`AUTHOR_ID`,`BOOK_ID`) VALUES (8,1);
INSERT INTO `RSEG105`.`author_book` (`AUTHOR_ID`,`BOOK_ID`) VALUES (9,2);
INSERT INTO `RSEG105`.`author_book` (`AUTHOR_ID`,`BOOK_ID`) VALUES (10,3);
