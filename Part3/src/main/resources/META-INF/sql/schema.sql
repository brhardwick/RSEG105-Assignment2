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

INSERT INTO `RSEG105`.`category` (`id`, `name`) VALUES (1, 'Medicine');
INSERT INTO `RSEG105`.`category` (`id`, `name`) VALUES (2, 'Poetry');
INSERT INTO `RSEG105`.`category` (`id`, `name`) VALUES (3, 'World');

INSERT INTO `RSEG105`.`BOOK` (`id`, `category_id`, `isbn`, `title`, `price`) VALUES (1, 1, '0813803330', 'Feline clinical parasitology', 65.35);
INSERT INTO `RSEG105`.`BOOK` (`id`, `category_id`, `isbn`, `title`, `price`) VALUES (2, 1, '0813824192', 'Veterinary parasitology reference manual', 42.21);
INSERT INTO `RSEG105`.`BOOK` (`id`, `category_id`, `isbn`, `title`, `price`) VALUES (3, 1, '0813819083', 'The pupil : anatomy, physiology, and clinical applications', 10.25);
INSERT INTO `RSEG105`.`BOOK` (`id`, `category_id`, `isbn`, `title`, `price`) VALUES (4, 1, '0813826527', 'Tumors in domestic animals', 15.54);
INSERT INTO `RSEG105`.`BOOK` (`id`, `category_id`, `isbn`, `title`, `price`) VALUES (5, 1, '0813815991', 'Immunology: a comprehensive review', 13.55);
INSERT INTO `RSEG105`.`BOOK` (`id`, `category_id`, `isbn`, `title`, `price`) VALUES (6, 2, '0253366658', 'A World treasury of oral poetry', 21.22);
INSERT INTO `RSEG105`.`BOOK` (`id`, `category_id`, `isbn`, `title`, `price`) VALUES (7, 2, '043514894X', 'Distant voices : poetry of the preliterate', 32.25);
INSERT INTO `RSEG105`.`BOOK` (`id`, `category_id`, `isbn`, `title`, `price`) VALUES (8, 3, '0813819075', 'Electronic tigers of Southeast Asia: the politics of media, technology, and national development', 32.12);

INSERT INTO `RSEG105`.`AUTHOR` (ID,FIRST_NAME,LAST_NAME,DESCRIPTION) VALUES (1,'Grey-Wilson', 'Victoria ','cruel disregard; unfeeling; uncaring; indifferent; ruthless');
INSERT INTO `RSEG105`.`AUTHOR` (ID,FIRST_NAME,LAST_NAME,DESCRIPTION) VALUES (2,'Perkins', 'Harold Oliver ','truthful, straightforward; honest; unreserved');
INSERT INTO `RSEG105`.`AUTHOR` (ID,FIRST_NAME,LAST_NAME,DESCRIPTION) VALUES (3,'Fletcher', 'Lehman B. ','making biting, corrosive comments; critical');
INSERT INTO `RSEG105`.`AUTHOR` (ID,FIRST_NAME,LAST_NAME,DESCRIPTION) VALUES (4,'Bowman', 'Dwight D. ','gives warning; raises awareness; reminding');
INSERT INTO `RSEG105`.`AUTHOR` (ID,FIRST_NAME,LAST_NAME,DESCRIPTION) VALUES (5,'Foreyt', 'Bill','praising; pay tribute to; glorify; honour');
INSERT INTO `RSEG105`.`AUTHOR` (ID,FIRST_NAME,LAST_NAME,DESCRIPTION) VALUES (6,'Loewenfeld', 'Irene E.  ','informal; lively; conversational; familiar');
INSERT INTO `RSEG105`.`AUTHOR` (ID,FIRST_NAME,LAST_NAME,DESCRIPTION) VALUES (7,'Meuten', 'Donald J. ','familiar; everyday language; informal; colloquial; casual');
INSERT INTO `RSEG105`.`AUTHOR` (ID,FIRST_NAME,LAST_NAME,DESCRIPTION) VALUES (8,'Wise', 'Darla J.','humorous; witty; entertaining; diverting');
INSERT INTO `RSEG105`.`AUTHOR` (ID,FIRST_NAME,LAST_NAME,DESCRIPTION) VALUES (9,'Finnegan', 'Ruth Hilary ','sympathetic; empathetic; warm-hearted; tolerant; kind');
INSERT INTO `RSEG105`.`AUTHOR` (ID,FIRST_NAME,LAST_NAME,DESCRIPTION) VALUES (10,'Thompson', 'Denys ','having many varying characteristics; complicated');
INSERT INTO `RSEG105`.`AUTHOR` (ID,FIRST_NAME,LAST_NAME,DESCRIPTION) VALUES (11,'McDaniel', 'Drew O. ','intended to placate or pacify; appeasing');

INSERT INTO `RSEG105`.`author_book` (`AUTHOR_ID`,`BOOK_ID`) VALUES (1,7);
INSERT INTO `RSEG105`.`author_book` (`AUTHOR_ID`,`BOOK_ID`) VALUES (2,8);
INSERT INTO `RSEG105`.`author_book` (`AUTHOR_ID`,`BOOK_ID`) VALUES (3,1);
INSERT INTO `RSEG105`.`author_book` (`AUTHOR_ID`,`BOOK_ID`) VALUES (4,1);
INSERT INTO `RSEG105`.`author_book` (`AUTHOR_ID`,`BOOK_ID`) VALUES (5,2);
INSERT INTO `RSEG105`.`author_book` (`AUTHOR_ID`,`BOOK_ID`) VALUES (6,3);
INSERT INTO `RSEG105`.`author_book` (`AUTHOR_ID`,`BOOK_ID`) VALUES (7,4);
INSERT INTO `RSEG105`.`author_book` (`AUTHOR_ID`,`BOOK_ID`) VALUES (8,5);
INSERT INTO `RSEG105`.`author_book` (`AUTHOR_ID`,`BOOK_ID`) VALUES (9,6);
INSERT INTO `RSEG105`.`author_book` (`AUTHOR_ID`,`BOOK_ID`) VALUES (10,7);
INSERT INTO `RSEG105`.`author_book` (`AUTHOR_ID`,`BOOK_ID`) VALUES (11,8);
