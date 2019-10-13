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
                    'vB1Zj0cD8EnabOBJuU5TgGe8IaFNr_DUZH58NhcGF8f26F8eLgqOZsJZbhvEv8esdmx-bZmNreLdTWvIOYUCww',
                    '5bpwFNg0VPIsMb8BhQfBWb3_vZxcLbQ8rG-gmtvtPNDGZzPFOUTdC40AhRI67V-A69IsXAWAbk-uY02Gqb6N2w',
                    'member');







