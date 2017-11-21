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

INSERT INTO `RSEG105`.`category` (`id`, `name`) VALUES (1, 'Business');
INSERT INTO `RSEG105`.`category` (`id`, `name`) VALUES (2, 'Gardening');
INSERT INTO `RSEG105`.`category` (`id`, `name`) VALUES (3, 'World');

INSERT INTO `RSEG105`.`AUTHOR` (ID,FIRST_NAME,LAST_NAME,DESCRIPTION) VALUES (1,'Bennett', 'William F.','full of regret; repentant; remorseful; acknowledging failure');
INSERT INTO `RSEG105`.`AUTHOR` (ID,FIRST_NAME,LAST_NAME,DESCRIPTION) VALUES (2,'Sauer', 'Thomas J.','grateful; thankful; showing pleasure; enthusiastic');
INSERT INTO `RSEG105`.`AUTHOR` (ID,FIRST_NAME,LAST_NAME,DESCRIPTION) VALUES (3,'Helms', 'Douglas B.','enthusiastic; passionate');
INSERT INTO `RSEG105`.`AUTHOR` (ID,FIRST_NAME,LAST_NAME,DESCRIPTION) VALUES (4,'Tollner', 'Ernest W.','pompous; disdainful; overbearing; condescending; vain; scoffing');
INSERT INTO `RSEG105`.`AUTHOR` (ID,FIRST_NAME,LAST_NAME,DESCRIPTION) VALUES (5,'Atkins', 'Joseph B.','self-confident; strong-willed; authoritative; insistent');
INSERT INTO `RSEG105`.`AUTHOR` (ID,FIRST_NAME,LAST_NAME,DESCRIPTION) VALUES (6,'Albarran', 'Alan B.','amazed, filled with wonder/awe; reverential');
INSERT INTO `RSEG105`.`AUTHOR` (ID,FIRST_NAME,LAST_NAME,DESCRIPTION) VALUES (7,'Keith', 'Michael C.','hostile; aggressive; combatant');
INSERT INTO `RSEG105`.`AUTHOR` (ID,FIRST_NAME,LAST_NAME,DESCRIPTION) VALUES (8,'Rucker', 'Frank W.','sympathetic; tolerant; generous; caring; well meaning');
INSERT INTO `RSEG105`.`AUTHOR` (ID,FIRST_NAME,LAST_NAME,DESCRIPTION) VALUES (9,'Lowenstein', 'Otto','angry; acrimonious; antagonistic; spiteful; nasty');

INSERT INTO `RSEG105`.`BOOK` (`id`, `category_id`, `isbn`, `title`, `price`) VALUES (1, 1, '081382124X', 'Media economics: understanding markets, industries and concepts', 34.99);	
INSERT INTO `RSEG105`.`BOOK` (`id`, `category_id`, `isbn`, `title`, `price`) VALUES (2, 1, '081382981X', 'Sounds in the dark: all-night radio in American life', 34.99);	
INSERT INTO `RSEG105`.`BOOK` (`id`, `category_id`, `isbn`, `title`, `price`) VALUES (3, 1, '0813811503', 'Newspaper organization and management', 42.22);	
INSERT INTO `RSEG105`.`BOOK` (`id`, `category_id`, `isbn`, `title`, `price`) VALUES (4, 2, '0002192209', 'Gardening on walls', 12.25);	
INSERT INTO `RSEG105`.`BOOK` (`id`, `category_id`, `isbn`, `title`, `price`) VALUES (5, 2, '0813810302', 'Espaliers and vines for the home gardener', 45.75);	
INSERT INTO `RSEG105`.`BOOK` (`id`, `category_id`, `isbn`, `title`, `price`) VALUES (6, 3, '0813807255', 'Guatemalas economic development: the role of agriculture', 62.21);	

INSERT INTO `RSEG105`.`author_book` (`AUTHOR_ID`,`BOOK_ID`) VALUES (1,4);
INSERT INTO `RSEG105`.`author_book` (`AUTHOR_ID`,`BOOK_ID`) VALUES (2,5);
INSERT INTO `RSEG105`.`author_book` (`AUTHOR_ID`,`BOOK_ID`) VALUES (3,6);
INSERT INTO `RSEG105`.`author_book` (`AUTHOR_ID`,`BOOK_ID`) VALUES (4,1);
INSERT INTO `RSEG105`.`author_book` (`AUTHOR_ID`,`BOOK_ID`) VALUES (5,2);
INSERT INTO `RSEG105`.`author_book` (`AUTHOR_ID`,`BOOK_ID`) VALUES (6,3);
INSERT INTO `RSEG105`.`author_book` (`AUTHOR_ID`,`BOOK_ID`) VALUES (7,4);
INSERT INTO `RSEG105`.`author_book` (`AUTHOR_ID`,`BOOK_ID`) VALUES (8,5);
INSERT INTO `RSEG105`.`author_book` (`AUTHOR_ID`,`BOOK_ID`) VALUES (9,6);
