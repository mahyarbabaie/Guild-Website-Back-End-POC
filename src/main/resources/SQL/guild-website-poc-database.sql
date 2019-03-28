DROP DATABASE  IF EXISTS `guild_website_poc_app`;

CREATE DATABASE  IF NOT EXISTS `guild_website_poc_app`;
USE `guild_website_poc_app`;

--
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
CREATE TABLE `accounts` (
                       `account_id` int(11)        NOT NULL AUTO_INCREMENT,
                       `username` varchar(50)      NOT NULL,
                       `email` varchar(50)         NOT NULL,
                       PRIMARY KEY (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `hashSalts`
--

DROP TABLE IF EXISTS `hash_salts`;
CREATE TABLE `hash_salts` (
                          `hash_salt_account_id` int(11)  NOT NULL,
                          `hash` varchar(128)             NOT NULL,
                          `salt` varchar(50)              NOT NULL,
                          PRIMARY KEY (`hash_salt_account_id`),
                          CONSTRAINT `fk_hash_salt_account_id`
                          FOREIGN KEY (`hash_salt_account_id`)
                          REFERENCES `guild_website_poc_app`.`accounts`(`account_id`)
                          ON UPDATE CASCADE
                          ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;






