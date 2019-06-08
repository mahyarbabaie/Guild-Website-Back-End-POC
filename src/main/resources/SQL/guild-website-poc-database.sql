DROP DATABASE  IF EXISTS `guild_website_poc_app`;

CREATE DATABASE  IF NOT EXISTS `guild_website_poc_app`;
USE `guild_website_poc_app`;

--
-- Table structure for table `accounts`
--
DROP TABLE IF EXISTS `accounts`;
CREATE TABLE `accounts` (
                       `account_id`    int           NOT NULL AUTO_INCREMENT,
                       `username`      varchar(50)   NOT NULL UNIQUE,
                       `email`         varchar(50)   NOT NULL UNIQUE,
                       `password_salt` varchar(256)  NULL,
                       `password_hash` varchar(256)  NULL,
                       `role`          varchar(256)  NOT NULL,
                       PRIMARY KEY (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Insert Test
--
INSERT INTO accounts (username,
                      email,
                      password_salt,
                      password_hash,
                      role)
            VALUES ('test121',
                    'test@gmail.com',
                    '8iO-siq37V3icDn13GU6oBOVoNqgn2-ewrIpGBW8FkCbLvBb4grGwMGyLPrKg7LpjKqMVHcM0VX7hNwyUdJpsA',
                    '1mBkNjKh8ddpCf4OiCBRDXNWHzsg2jYvYuCH7RrfHMt81YgVUC8AYDT2Lv4zwocBrPaf9cX-IuOCZS05Kuk5tA',
                    'member');







