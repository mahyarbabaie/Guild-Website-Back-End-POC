DROP DATABASE  IF EXISTS `guild_website_poc_app`;

CREATE DATABASE  IF NOT EXISTS `guild_website_poc_app`;
USE `guild_website_poc_app`;

--
-- Table structure for table `accounts`
--
DROP TABLE IF EXISTS `accounts`;
CREATE TABLE `accounts` (
                       `account_id`    int           NOT NULL AUTO_INCREMENT,
                       `username`      varchar(50)   NOT NULL,
                       `email`         varchar(50)   NOT NULL,
                       `password_salt` varchar(50)   NOT NULL,
                       `password_hash` varchar(128)  NOT NULL,
                       PRIMARY KEY (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Insert Test
--
INSERT INTO accounts (username, email, password_salt, password_hash) VALUES ('test', 'test@gmail.com', 'salty', 'hashy');







