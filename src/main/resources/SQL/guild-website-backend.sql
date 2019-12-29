DROP DATABASE  IF EXISTS `guild_website_poc_app`;

CREATE DATABASE  IF NOT EXISTS `guild_website_poc_app`;
USE `guild_website_poc_app`;

--
-- Table structure for table `accounts`
--
DROP TABLE IF EXISTS `accounts`;
CREATE TABLE `accounts` (
                       `account_id`    INT           NOT NULL AUTO_INCREMENT,
                       `username`      VARCHAR(50)   NOT NULL UNIQUE,
                       `email`         VARCHAR(50)   NOT NULL UNIQUE,
                       `password_salt` VARCHAR(256)  NULL,
                       `password_hash` VARCHAR(256)  NULL,
                       `role`          VARCHAR(256)  NOT NULL,
                       PRIMARY KEY (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `guild_application`
--
DROP TABLE IF EXISTS `guild_application`;
CREATE TABLE `guild_application` (
                                     `application_id`           VARCHAR(256) NOT NULL UNIQUE,
                                     `email`                    VARCHAR(50)  NOT NULL,
                                     `battle_tag`               VARCHAR(50)  NOT NULL,
                                     `character_name`           VARCHAR(256) NOT NULL,
                                     `class`                    VARCHAR(50)  NOT NULL,
                                     `spec`                     VARCHAR(50)  NOT NULL,
                                     `realm`                    VARCHAR(100) NOT NULL,
                                     `raid_preference`          VARCHAR(256) NULL,
                                     `raid_experience`          VARCHAR(256) NULL,
                                     `heroic_raid_preference`   VARCHAR(256) NULL,
                                     `mythic_raid_preference`   VARCHAR(256) NULL,
                                     `casual_preference`        VARCHAR(256) NULL,
                                     `casual_activities`        VARCHAR(256) NULL,
                                     `mythic_plus_preference`   VARCHAR(256) NULL,
                                     `mythic_plus_goals`        VARCHAR(256) NULL,
                                     `pvp_preference`           VARCHAR(256) NULL,
                                     `arena_preference`         VARCHAR(256) NULL,
                                     `battlegrounds_preference` VARCHAR(256) NULL,
                                     `world_pvp_preference`     VARCHAR(256) NULL,
                                     `pvp_goals`                VARCHAR(256) NULL,
                                     `about_yourself`           VARCHAR(256) NULL,
                                     `application_status`       VARCHAR(256) NOT NULL,
                                     `application_date`         DATE NOT NULL,
                                     PRIMARY KEY (`application_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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







