DROP DATABASE RSEG105;
CREATE DATABASE RSEG105;


CREATE TABLE IF NOT EXISTS `RSEG105`.`category` (
  `id` INT NOT NULL,
  `name` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `RSEG105`.`book` (
    `id` INT NOT NULL,
    `category_id` INT NULL,
    `isbn` VARCHAR(10) NULL,
    `title` VARCHAR(500) NULL,
    `price` DECIMAL(4 , 2 ) NULL,
    PRIMARY KEY (`id`),
    INDEX `BOOKcategory_idx` (`category_id` ASC),
    CONSTRAINT `BOOKcategory` FOREIGN KEY (`category_id`)
        REFERENCES `RSEG105`.`category` (`id`)
        ON DELETE CASCADE ON UPDATE CASCADE
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS `RSEG105`.`author` (
	`ID` INT NOT NULL,
    `FIRST_NAME` VARCHAR(60) NOT NULL,
    `LAST_NAME` VARCHAR(60) NOT NULL,
	`DESCRIPTION` VARCHAR(1200) NOT NULL
)  ENGINE=INNODB;


CREATE TABLE IF NOT EXISTS `RSEG105`.`author_book` (
    `AUTHOR_ID` INT NOT NULL,
    `BOOK_ID` INT NULL,
    CONSTRAINT `authorbook_author` FOREIGN KEY (`AUTHOR_ID`)
        REFERENCES `RSEG105`.`BOOK` (`id`)
        ON DELETE CASCADE ON UPDATE CASCADE,

	CONSTRAINT `authorbook_book` FOREIGN KEY (`BOOK_ID`)
        REFERENCES `RSEG105`.`BOOK` (`id`)
        ON DELETE CASCADE ON UPDATE CASCADE
)  ENGINE=INNODB;

 

INSERT INTO `RSEG105`.`category` (`id`, `name`) VALUES (1, 'Classics');
INSERT INTO `RSEG105`.`category` (`id`, `name`) VALUES (2, 'CookBOOKs');
INSERT INTO `RSEG105`.`category` (`id`, `name`) VALUES (3, 'Science');
INSERT INTO `RSEG105`.`category` (`id`, `name`) VALUES (4, 'History');

INSERT INTO `RSEG105`.`BOOK` (`id`, `category_id`, `isbn`, `title`, `price`) VALUES (1, 3, '0374715718', 'The Zoomable Universe', 18.30);
INSERT INTO `RSEG105`.`BOOK` (`id`, `category_id`, `isbn`, `title`, `price`) VALUES (2, 3, '4567-6434', '1426218648', 27.19);
INSERT INTO `RSEG105`.`BOOK` (`id`, `category_id`, `isbn`, `title`, `price`) VALUES (3, 3, '0545947197', 'Rocks, Minerals & Gems', 13.99);
INSERT INTO `RSEG105`.`BOOK` (`id`, `category_id`, `isbn`, `title`, `price`) VALUES (4, 1, '0743273567', 'The Great Gatsby', 12.00);
INSERT INTO `RSEG105`.`BOOK` (`id`, `category_id`, `isbn`, `title`, `price`) VALUES (5, 1, '0060935464', 'To Kill a Mockingbird', 5.89);
INSERT INTO `RSEG105`.`BOOK` (`id`, `category_id`, `isbn`, `title`, `price`) VALUES (6, 2, '0393081087', 'The Food Lab', 30.97);
INSERT INTO `RSEG105`.`BOOK` (`id`, `category_id`, `isbn`, `title`, `price`) VALUES (7, 4, '1494861992', 'The Egyptian Origins of Western Philosophy', 9.95);

